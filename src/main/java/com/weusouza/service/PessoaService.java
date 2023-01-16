package com.weusouza.service;

import com.weusouza.domain.Pessoa;
import com.weusouza.service.exeptions.ObjectNotFoundExeption;
import com.weusouza.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service

public class PessoaService {
    private final PessoaRepository repository;
@Autowired
    public PessoaService(PessoaRepository repository) {
        this.repository = repository;
    }




    public Pessoa findById(Integer id){
        Optional<Pessoa> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundExeption("Objeto não encontrado! Id: "+id + ", Tipo: "+Pessoa.class.getName()));
    }
}
