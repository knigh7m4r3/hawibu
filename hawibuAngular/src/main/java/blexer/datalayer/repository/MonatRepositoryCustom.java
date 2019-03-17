package blexer.datalayer.repository;

import blexer.datalayer.model.Monat;

public interface MonatRepositoryCustom {

    Monat getByName(String monatName);
}
