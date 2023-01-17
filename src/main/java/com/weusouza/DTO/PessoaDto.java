package com.weusouza.DTO;

import com.weusouza.domain.Pessoa;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class PessoaDto {
    private Integer Id;
    @NotEmpty(message = "campo NOME é requerido")
    @Length(min= 3, max =100,message = "O campo nome deve ter entre 3 e 100 caracteres")
    private String nome;
    @NotNull
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
