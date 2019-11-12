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
import pooa.algaworks.gestao04.models.Festa;
import pooa.algaworks.gestao04.repository.FestaRepository;


@RestController
@RequestMapping("/api/festas")
public class FestasControllerAPI {

	@Autowired
	private FestaRepository festas;

	@GetMapping
	public Collection<Festa> listafestas() {
            return this.festas.findAll();
	}

	@GetMapping(value = "/{id}")
	public Optional<Festa> getfesta(@PathVariable("id") Long id) {
            return this.festas.findById(id);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> removefesta(@PathVariable("id") Long id) {
            Optional<Festa> f = festas.findById(id);
            if (f == null)  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            festas.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> savefesta(Festa festa) {
		return new ResponseEntity<>(festas.save(festa), HttpStatus.OK);
	}

}
