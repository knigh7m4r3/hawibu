package blexer.datalayer.repository;

import blexer.datalayer.model.Bon;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BonRepository extends JpaRepository<Bon, Integer> {
}
