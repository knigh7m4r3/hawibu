package blexer.datalayer.repository;

import blexer.datalayer.model.Bon;

import java.util.List;

public interface BonRepositoryCustom {

    List<Bon> getByMonat(String monat);
    List<Bon> getByJahr(String jahr);

}
