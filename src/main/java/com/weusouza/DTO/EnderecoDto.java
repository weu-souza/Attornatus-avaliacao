package com.weusouza.DTO;

import com.weusouza.domain.Endereco;

public class EnderecoDto {
    private Integer id;
    private String logradouro;
    private Integer cep;
    private Integer num;
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
