package blexer.datalayer.service;

import blexer.datalayer.CoreService;
import blexer.datalayer.model.Bon;

import java.util.List;

public interface BonService extends CoreService<Bon, Integer> {
     List<Bon> getByMonat(String monat);

    List<Bon> getByJahr(String jahr);


}
