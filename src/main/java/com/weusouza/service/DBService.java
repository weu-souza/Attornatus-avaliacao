package com.weusouza.service;
import com.weusouza.Domain.*;
import com.weusouza.Repositories.EnderecoRepository;
import com.weusouza.Repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;

@Service
public class DBService {
    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    public void instanciaBaseDeDados(){
        Pessoa p1 = new Pessoa(null,"weu", LocalDate.of(1997, 11, 27));
        Endereco e1 = new Endereco(null,"rua8",72815460,12,"paraiba",p1);
        p1.getEnderecoPrincipal().addAll(Arrays.asList(e1));
        this.pessoaRepository.saveAll(Arrays.asList(p1));
        this.enderecoRepository.saveAll(Arrays.asList(e1));
    }
}
