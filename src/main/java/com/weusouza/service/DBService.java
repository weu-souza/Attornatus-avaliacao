package com.weusouza.service;
import com.weusouza.domain.*;
import com.weusouza.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;

@Service
public class DBService {
    private final PessoaRepository pessoaRepository;
    private final EnderecoRepository enderecoRepository;
@Autowired
    public DBService(PessoaRepository pessoaRepository, EnderecoRepository enderecoRepository) {
        this.pessoaRepository = pessoaRepository;
        this.enderecoRepository = enderecoRepository;
    }

    public void instanciaBaseDeDados(){
        Pessoa p1 = new Pessoa(null,"weu", LocalDate.of(1997, 11, 27));
        Endereco e1 = new Endereco(null,"rua8",72815460,12,"paraiba",p1);
        p1.getEnderecoPrincipal().addAll(Arrays.asList(e1));
//        this.pessoaRepository.saveAll(Arrays.asList(p1));
//        this.enderecoRepository.saveAll(Arrays.asList(e1));
    }
}
