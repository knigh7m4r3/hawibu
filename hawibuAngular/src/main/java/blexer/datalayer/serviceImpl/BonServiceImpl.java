package blexer.datalayer.serviceImpl;

import blexer.datalayer.model.Bon;
import blexer.datalayer.repository.BonRepositoryCustom;
import blexer.datalayer.repository.BonRepository;
import blexer.datalayer.service.BonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class BonServiceImpl implements BonService {

     @Autowired
     private BonRepository repository;

     @Autowired
     private BonRepositoryCustom bonRepositoryCustom;

    @Transactional
    public Bon getEntity(Integer id) {
        return repository.getOne(id);
    }

    @Transactional
    public void saveEntity(Bon entity) {
        repository.save(entity);
    }

    @Transactional
    public void updateEntity(Bon entity) {
        repository.save(entity);
    }

    @Transactional
    public void deleteEntity(Bon entity) {
        repository.delete(entity);
    }

    @Transactional
    public List<Bon> getAll() {
        return repository.findAll();
    }

    @Transactional
    public List<Bon> getByMonat(String monat) {
        return bonRepositoryCustom.getByMonat(monat);
    }

    @Transactional
    public List<Bon> getByJahr(String jahr) {
        return bonRepositoryCustom.getByJahr(jahr);
    }
}
