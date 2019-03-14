package blexer.datalayer.service;

import blexer.datalayer.CoreService;
import blexer.datalayer.model.Bon;
import blexer.datalayer.model.Posten;

import java.util.List;

public interface PostenService extends CoreService<Posten, Integer> {

    List<Posten> getByBons(List<Bon> bonList);

}
