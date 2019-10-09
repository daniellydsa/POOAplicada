package pooa.algaworks.gestao04.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pooa.algaworks.gestao04.models.Convidado;

public interface Convidados extends JpaRepository<Convidado, Long> {
    
}
