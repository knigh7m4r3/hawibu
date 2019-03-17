package blexer.datalayer.repositoryImpl;

import blexer.datalayer.model.Monat;
import blexer.datalayer.repository.MonatRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MonatRepositoryCustomImpl implements MonatRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Monat getByName(String monatName) {
        final List<Monat> monatList = entityManager.createQuery("from Monat m where m.name = '" + monatName + "'").getResultList();
        if(monatList.size() > 0){
            return monatList.get(0);
        }else{
            return null;
        }
    }
}
