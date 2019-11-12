package pooa.algaworks.gestao04.models;

import java.io.Serializable;
import java.text.ParseException;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Festa implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty(message = "Nome é obrigatório.")
    @Size(max = 30, message = "Nome não pode conter mais que 30 caracteres.")
    private String nome;

    private String dtFesta;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDtFesta() {
        return dtFesta;
    }

    public void setDtFesta(String dtFesta) throws ParseException {
        this.dtFesta = dtFesta;
    }
    
}
