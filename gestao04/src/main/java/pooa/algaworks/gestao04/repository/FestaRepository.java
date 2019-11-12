package pooa.algaworks.gestao04.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pooa.algaworks.gestao04.models.Festa;

public interface FestaRepository extends JpaRepository<Festa, Long> {
    
}
