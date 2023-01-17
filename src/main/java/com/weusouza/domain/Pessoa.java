package com.weusouza.domain;


import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Pessoa  {
   @javax.persistence.Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
   @NotEmpty(message = "campo NOME é requerido")
   @Length(min= 3, max =100,message = "O campo nome deve ter entre 3 e 100 caracteres")
    private String nome;
    @NotNull
    private LocalDate DataNascimento;
    @OneToMany(mappedBy = "pessoa")
    private List<Endereco>endereco = new ArrayList<>();



    public Pessoa(Integer id, String nome, LocalDate dataNascimento) {
        Id = id;
        this.nome = nome;
        DataNascimento = dataNascimento;
    }

    public Pessoa() {

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

    public List<Endereco> getEndereco() {
        return endereco;
    }

    public void setEndereco(List<Endereco> endereco) {
        this.endereco = endereco;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Id.equals(pessoa.Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }
}
