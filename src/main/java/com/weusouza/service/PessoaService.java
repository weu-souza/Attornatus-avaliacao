package com.weusouza.service;

import com.weusouza.DTO.PessoaDto;
import com.weusouza.domain.Pessoa;
import com.weusouza.repositories.PessoaRepository;
import com.weusouza.service.exeptions.DataIntegrityViolationExeption;
import com.weusouza.service.exeptions.ObjectNotFoundExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class PessoaService {
    private final PessoaRepository repository;

    @Autowired
    public PessoaService(PessoaRepository repository) {
        this.repository = repository;
    }


    public Pessoa findById(Integer id) {
        Optional<Pessoa> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundExeption("Objeto não encontrado! Id: " + id + ", Tipo: " + Pessoa.class.getName()));
    }

    public List<Pessoa> findAll() {
        return repository.findAll();
    }

    public Pessoa create(Pessoa obj) {
        obj.setId(null);
        return repository.save(obj);
    }

    public Pessoa update(Integer id, PessoaDto objDto) {
        Pessoa obj = findById(id);
        obj.setNome(objDto.getNome());
        obj.setDataNascimento(objDto.getDataNascimento());
        return repository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationExeption("pessoa não pode ser deletada! possui endereço associado");
        }

    }
}
