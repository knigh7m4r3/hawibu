package blexer.datalayer.serviceImpl;

import blexer.datalayer.model.Kategorie;
import blexer.datalayer.repository.KategorieRepository;
import blexer.datalayer.service.KategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class KategorieServiceImpl implements KategorieService {

     @Autowired
     private KategorieRepository repository;

    @Transactional
    public Kategorie getEntity(Integer id) {
        return repository.getOne(id);
    }

    @Transactional
    public void saveEntity(Kategorie entity) {
        repository.save(entity);
    }

    @Transactional
    public void updateEntity(Kategorie entity) {
        repository.save(entity);
    }

    @Transactional
    public void deleteEntity(Kategorie entity) {
        repository.delete(entity);
    }

    @Transactional
    public List<Kategorie> getAll() {
        return repository.findAll();
    }
}
