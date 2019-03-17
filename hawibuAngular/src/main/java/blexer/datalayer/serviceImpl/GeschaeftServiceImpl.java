package blexer.datalayer.serviceImpl;

import blexer.datalayer.model.Geschaeft;
import blexer.datalayer.repository.GeschaeftRepository;
import blexer.datalayer.service.GeschaeftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class GeschaeftServiceImpl implements GeschaeftService {

     @Autowired
     private GeschaeftRepository repository;

    @Transactional
    public Geschaeft getEntity(Integer id) {
        return repository.getOne(id);
    }

    @Transactional
    public Geschaeft saveEntity(Geschaeft entity) {
        return repository.save(entity);
    }

    @Transactional
    public void updateEntity(Geschaeft entity) {
        repository.save(entity);
    }

    @Transactional
    public void deleteEntity(Geschaeft entity) {
        repository.delete(entity);
    }

    @Transactional
    public List<Geschaeft> getAll() {
        return repository.findAll();
    }
}
