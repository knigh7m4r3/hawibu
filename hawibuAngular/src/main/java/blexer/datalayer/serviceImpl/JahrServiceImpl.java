package blexer.datalayer.serviceImpl;

import blexer.datalayer.repository.JahrRepository;
import blexer.datalayer.repository.JahrRepositoryCustom;
import blexer.datalayer.service.JahrService;
import blexer.datalayer.model.Jahr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class JahrServiceImpl implements JahrService {

     @Autowired
     private JahrRepository repository;

     @Autowired
     private JahrRepositoryCustom repositoryCustom;

    @Transactional
    public Jahr getEntity(Integer id) {
        return repository.getOne(id);
    }

    @Transactional
    public Jahr saveEntity(Jahr entity) {
        return repository.save(entity);
    }

    @Transactional
    public void updateEntity(Jahr entity) {
        repository.save(entity);
    }

    @Transactional
    public void deleteEntity(Jahr entity) {
        repository.delete(entity);
    }

    @Transactional
    public List<Jahr> getAll() {
        return repository.findAll();
    }

    @Transactional
    public Jahr getByJahr(Integer jahr) {
        return repositoryCustom.getByJahr(jahr);
    }
}
