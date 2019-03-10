package blexer.datalayer.repository;

import blexer.datalayer.model.Posten;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PostenRepository extends JpaRepository<Posten, Integer> {
}
