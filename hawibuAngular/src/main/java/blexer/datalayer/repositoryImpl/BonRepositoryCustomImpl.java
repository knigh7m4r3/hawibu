package blexer.datalayer.repositoryImpl;

import blexer.datalayer.model.Bon;
import blexer.datalayer.repository.BonRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class BonRepositoryCustomImpl implements BonRepositoryCustom {


    @PersistenceContext
    private EntityManager entityManager;

    public List<Bon> getByMonat(String monat){
        return this.entityManager.createQuery("select b from Bon b where b.monat.id = (select m.id from Monat m where m.name = '" + monat + "')").getResultList();

    }

    public List<Bon> getByJahr(String jahr){
        return this.entityManager.createQuery("select b from Bon b where b.monat.id IN (select m.id from Monat m where m.jahr.id = (select j.id from Jahr j where j.jahr = '" + jahr + "'))").getResultList();
    }
}
