package blexer.datalayer.serviceImpl;

import blexer.datalayer.model.Bon;
import blexer.datalayer.model.Posten;
import blexer.datalayer.repository.PostenRepository;
import blexer.datalayer.repository.PostenRepositoryCustom;
import blexer.datalayer.service.PostenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class PostenServiceImpl implements PostenService {

     @Autowired
     private PostenRepository repository;

     @Autowired
     private PostenRepositoryCustom repositoryCustom;

    @Transactional
    public Posten getEntity(Integer id) {
        return repository.getOne(id);
    }

    @Transactional
    public void saveEntity(Posten entity) {
        repository.save(entity);
    }

    @Transactional
    public void updateEntity(Posten entity) {
        repository.save(entity);
    }

    @Transactional
    public void deleteEntity(Posten entity) {
        repository.delete(entity);
    }

    @Transactional
    public List<Posten> getAll() {
        return repository.findAll();
    }

    @Transactional
    public List<Posten> getByBons(List<Bon> bonList) {
        return repositoryCustom.getByBon(bonList);
    }
}
