package com.weusouza.DTO;

import com.weusouza.domain.Endereco;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class EnderecoDto {
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

    public EnderecoDto() {
    }

    public EnderecoDto(Endereco obj) {
        this.id = obj.getId();
        this.logradouro = obj.getLogradouro();
        this.cep = obj.getCep();
        this.num = obj.getNum();
        this.cidade = obj.getCidade();
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
}
