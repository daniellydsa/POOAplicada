package pooa.algaworks.gestao04.models;

import java.io.Serializable;
import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;

@Entity
public class FestaModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    
//    @Temporal(TemporalType.DATE)
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
//        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
//        this.dtFesta = formato.parse(dtFesta);
          this.dtFesta = dtFesta;
    }
    
}
