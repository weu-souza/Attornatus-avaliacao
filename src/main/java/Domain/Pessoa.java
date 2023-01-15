package Domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Pessoa {
    private Integer Id;
    private String nome;
    private Date DataNascimento;
    private List<Endereco> enderecoPrincipal = new ArrayList<>();
    private List<Endereco> outrosEnderecos = new ArrayList<>();

    public Pessoa(Integer id, String nome, Date dataNascimento) {
        Id = id;
        this.nome = nome;
        DataNascimento = dataNascimento;
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

    public Date getDataNascimento() {
        return DataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        DataNascimento = dataNascimento;
    }

    public List<Endereco> getEnderecoPrincipal() {
        return enderecoPrincipal;
    }

    public void setEnderecoPrincipal(List<Endereco> enderecoPrincipal) {
        this.enderecoPrincipal = enderecoPrincipal;
    }

    public List<Endereco> getOutrosEnderecos() {
        return outrosEnderecos;
    }

    public void setOutrosEnderecos(List<Endereco> outrosEnderecos) {
        this.outrosEnderecos = outrosEnderecos;
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
