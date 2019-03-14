package blexer.datalayer.repository;

import blexer.datalayer.model.Bon;
import blexer.datalayer.model.Posten;

import java.util.List;

public interface PostenRepositoryCustom {

    List<Posten> getByBon(List<Bon> bonList);
}
