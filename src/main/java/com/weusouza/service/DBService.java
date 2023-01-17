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
        Pessoa p1 = new Pessoa(null,"antonio", LocalDate.of(1997, 11, 27));
        Pessoa p2 = new Pessoa(null,"carlos", LocalDate.of(1999, 12, 28));
        Pessoa p3 = new Pessoa(null,"maria", LocalDate.of(1998, 10, 29));
        Pessoa p4 = new Pessoa(null,"jose", LocalDate.of(1998, 11, 20));
        Endereco e1 = new Endereco(null,"rua8",72815460,12,"brasilia",p1);
        Endereco e2 = new Endereco(null,"rua9",72815470,13,"brasilia",p2);
        Endereco e3 = new Endereco(null,"rua10",72815459,15,"brasilia",p3);
        Endereco e4 = new Endereco(null,"rua22",72815800,17,"luziânia",p1);
        Endereco e5 = new Endereco(null,"rua32",72815550,18,"luziânia",p2);
        Endereco e6 = new Endereco(null,"rua42",72815500,20,"luziânia",p3);

        p1.getEndereco().addAll(Arrays.asList(e1,e4));
        p2.getEndereco().addAll(Arrays.asList(e2,e5));
        p3.getEndereco().addAll(Arrays.asList(e3,e6));




        this.pessoaRepository.saveAll(Arrays.asList(p1,p2,p3,p4));
        this.enderecoRepository.saveAll(Arrays.asList(e1,e2,e3,e4,e5,e6));

    }
}
