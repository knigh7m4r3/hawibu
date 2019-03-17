package blexer.datalayer.repositoryImpl;

import blexer.datalayer.model.Jahr;
import blexer.datalayer.repository.JahrRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class JahrRepositoryCustomImpl implements JahrRepositoryCustom {


    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Jahr getByJahr(Integer jahr) {
        final List<Jahr> jahrList = entityManager.createQuery("from Jahr j where j.jahr = '" + jahr + "'").getResultList();
        if(jahrList.size() > 0){
            return jahrList.get(0);
        }else{
            return null;
        }
    }
}
