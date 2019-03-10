package blexer.datalayer.repository;

import blexer.datalayer.model.Artikel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ArtikelRepository extends JpaRepository<Artikel, Integer> {
}
