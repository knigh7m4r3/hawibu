package blexer.datalayer.serviceImpl;

import blexer.datalayer.repository.JahrRepository;
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

    @Transactional
    public Jahr getEntity(Integer id) {
        return repository.getOne(id);
    }

    @Transactional
    public void saveEntity(Jahr entity) {
        repository.save(entity);
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
}
