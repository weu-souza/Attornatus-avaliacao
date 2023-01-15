package Domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Pessoa implements Serializable {
   @javax.persistence.Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String nome;
    private Date DataNascimento;
    @OneToMany(mappedBy = "pessoa")
    private List<Endereco>endereco = new ArrayList<>();


    public Pessoa(Integer id, String nome, Date dataNascimento) {
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

    public Date getDataNascimento() {
        return DataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        DataNascimento = dataNascimento;
    }

    public List<Endereco> getEnderecoPrincipal() {
        return endereco;
    }

    public void setEnderecoPrincipal(List<Endereco> endereco) {
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
