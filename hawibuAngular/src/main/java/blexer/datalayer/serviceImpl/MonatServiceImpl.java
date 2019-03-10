package blexer.datalayer.serviceImpl;

import blexer.datalayer.model.Monat;
import blexer.datalayer.repository.MonatRepository;
import blexer.datalayer.service.MonatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class MonatServiceImpl implements MonatService {

     @Autowired
     private MonatRepository repository;

    @Transactional
    public Monat getEntity(Integer id) {
        return repository.getOne(id);
    }

    @Transactional
    public void saveEntity(Monat entity) {
        repository.save(entity);
    }

    @Transactional
    public void updateEntity(Monat entity) {
        repository.save(entity);
    }

    @Transactional
    public void deleteEntity(Monat entity) {
        repository.delete(entity);
    }

    @Transactional
    public List<Monat> getAll() {
        return repository.findAll();
    }
}
