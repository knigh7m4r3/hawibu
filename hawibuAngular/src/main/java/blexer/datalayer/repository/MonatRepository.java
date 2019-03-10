package blexer.datalayer.repository;

import blexer.datalayer.model.Monat;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MonatRepository extends JpaRepository<Monat, Integer> {
}
