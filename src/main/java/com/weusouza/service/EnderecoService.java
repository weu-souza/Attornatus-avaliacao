package com.weusouza.service;

import com.weusouza.domain.Endereco;
import com.weusouza.repositories.EnderecoRepository;
import com.weusouza.service.exeptions.ObjectNotFoundExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {
    private final EnderecoRepository repository;
    private final PessoaService pessoaService;

    @Autowired
    public EnderecoService(EnderecoRepository repository, PessoaService pessoaService) {
        this.repository = repository;
        this.pessoaService = pessoaService;
    }

    public Endereco findById(Integer id) {
        Optional<Endereco> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundExeption("endereco não encontrado id: " + id + ", Tipo: " + Endereco.class.getName()));
    }

    public List<Endereco> findByPessoaId(Integer id_pess) {
        pessoaService.findById(id_pess);
        return repository.findAlllByPessoa(id_pess);
    }


    public Endereco update(Integer id, Endereco obj) {
        Endereco newObj = findById(id);
        updateData(newObj, obj);
        return repository.save(newObj);
    }

    private void updateData(Endereco newObj, Endereco obj) {
        newObj.setLogradouro(obj.getLogradouro());
        newObj.setCep(obj.getCep());
        newObj.setCidade(obj.getCidade());
        newObj.setNum(obj.getNum());
    }
}
