package blexer.datalayer.repository;

import blexer.datalayer.model.Jahr;
import blexer.datalayer.model.Monat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MonatRepository extends JpaRepository<Monat, Integer> {



}