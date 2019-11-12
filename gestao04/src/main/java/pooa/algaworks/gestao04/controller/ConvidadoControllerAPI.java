package pooa.algaworks.gestao04.controller;

import java.util.Collection;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pooa.algaworks.gestao04.models.Convidado;
import pooa.algaworks.gestao04.repository.Convidados;

@RestController
@RequestMapping("/api/convidados")
public class ConvidadoControllerAPI {
    
    @Autowired
    Convidados convidados;
    
    
    @GetMapping
    public Collection<Convidado> listaConvidados(){
        return this.convidados.findAll();
    }
    
    @GetMapping(value = "/{id}")
    public Optional<Convidado> getConvidado(@PathVariable Long id){
        return this.convidados.findById(id);
    }
    
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> removeConvidado(@PathVariable Long id){
        Optional<Convidado> c = convidados.findById(id);
        if(c == null) return new ResponseEntity<> (HttpStatus.NOT_FOUND);
        convidados.deleteById(id);
        return new ResponseEntity<> (HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<?> saveConvidado(Convidado convidado) {
        return new ResponseEntity<Convidado> (convidados.save(convidado), HttpStatus.OK);
    }
}
