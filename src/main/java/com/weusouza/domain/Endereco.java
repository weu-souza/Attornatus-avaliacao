package com.weusouza.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;
@Entity
public class Endereco {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "campo LOGRADOURO é requerido")
    @Length(min= 3, max =100,message = "O campo Logradouro deve ter entre 3 e 100 caracteres")
    private String logradouro;
    @NotNull
    private Integer cep;
    private Integer num;
    @NotEmpty(message = "campo CIDADE é requerido")
    @Length(min= 3, max =100,message = "O campo cidade deve ter entre 3 e 100 caracteres")
    private String cidade;
@JsonIgnore
@ManyToOne
@JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    public Endereco(Integer id, String logradouro, Integer cep, Integer num, String cidade, Pessoa pessoa) {
        this.id = id;
        this.logradouro = logradouro;
        this.cep = cep;
        this.num = num;
        this.cidade = cidade;
        this.pessoa = pessoa;
    }

    public Endereco() {

    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Endereco endereco = (Endereco) o;
        return Objects.equals(id, endereco.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
