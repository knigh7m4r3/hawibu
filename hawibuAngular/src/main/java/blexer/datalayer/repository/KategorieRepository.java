package blexer.datalayer.repository;

import blexer.datalayer.model.Kategorie;
import org.springframework.data.jpa.repository.JpaRepository;


public interface KategorieRepository extends JpaRepository<Kategorie, Integer> {
}
