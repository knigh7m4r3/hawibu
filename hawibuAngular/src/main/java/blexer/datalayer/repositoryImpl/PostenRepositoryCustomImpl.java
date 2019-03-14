package blexer.datalayer.repositoryImpl;

import blexer.datalayer.model.Bon;
import blexer.datalayer.model.Posten;
import blexer.datalayer.repository.PostenRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PostenRepositoryCustomImpl implements PostenRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Posten> getByBon(List<Bon> bonList) {
        final List<Integer> idList = new ArrayList<>();
        for(Bon bon : bonList){
            idList.add(bon.getId());
        }

        final Query query = entityManager.createQuery("from Posten p where p.bon.id in :ids");
        query.setParameter("ids", idList);
        return query.getResultList();

    }
}
