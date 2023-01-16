package com.weusouza.service;

import com.weusouza.domain.Endereco;
import com.weusouza.repositories.EnderecoRepository;
import com.weusouza.service.exeptions.ObjectNotFoundExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EnderecoService {
    private final EnderecoRepository repository;
@Autowired
    public EnderecoService(EnderecoRepository repository) {
        this.repository = repository;
    }

    public Endereco findById(Integer id){
        Optional<Endereco> obj = repository.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundExeption("endereco não encontrado id: "+id+", Tipo: "+ Endereco.class.getName()));
    }
}
