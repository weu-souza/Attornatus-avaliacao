package com.weusouza.DTO;

import com.weusouza.domain.Pessoa;

import java.time.LocalDate;

public class PessoaDto {
    private Integer Id;
    private String nome;
    private LocalDate DataNascimento;

    public PessoaDto() {
    }

    public PessoaDto(Pessoa obj) {
        Id = obj.getId();
        this.nome = obj.getNome();
        DataNascimento = obj.getDataNascimento();
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return DataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        DataNascimento = dataNascimento;
    }
}
