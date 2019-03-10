package blexer.datalayer.serviceImpl;

import blexer.datalayer.model.Artikel;
import blexer.datalayer.repository.ArtikelRepository;
import blexer.datalayer.service.ArtikelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class ArtikelServiceImpl implements ArtikelService {

     @Autowired
     private ArtikelRepository repository;

    @Transactional
    public Artikel getEntity(Integer id) {
        return repository.getOne(id);
    }

    @Transactional
    public void saveEntity(Artikel entity) {
        repository.save(entity);
    }

    @Transactional
    public void updateEntity(Artikel entity) {
        repository.save(entity);
    }

    @Transactional
    public void deleteEntity(Artikel entity) {
        repository.delete(entity);
    }

    @Transactional
    public List<Artikel> getAll() {
        return repository.findAll();
    }
}
