package blexer.datalayer.repository;

import blexer.datalayer.model.Geschaeft;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GeschaeftRepository extends JpaRepository<Geschaeft, Integer> {
}
