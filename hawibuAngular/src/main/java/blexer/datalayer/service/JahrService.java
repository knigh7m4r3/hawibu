package blexer.datalayer.service;

import blexer.datalayer.CoreService;
import blexer.datalayer.model.Jahr;

public interface JahrService extends CoreService<Jahr, Integer> {

    Jahr getByJahr(Integer jahr);

}
