package pooa.algaworks.gestao04.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pooa.algaworks.gestao04.models.FestaModel;

public interface FestaRepository extends JpaRepository<FestaModel, Long> {
    
}
