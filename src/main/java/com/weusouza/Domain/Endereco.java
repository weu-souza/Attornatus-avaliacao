package com.weusouza.Domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
@Entity
public class Endereco implements Serializable {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String logradouro;
    private Integer cep;
    private Integer num;
    private String cidade;
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
