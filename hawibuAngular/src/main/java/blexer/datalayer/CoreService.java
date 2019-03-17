package blexer.datalayer;

import java.util.List;

public interface CoreService<T, E> {

    T getEntity(E id);
    T saveEntity(T entity);
    void updateEntity(T entity);
    void deleteEntity(T entity);
    List<T> getAll();
}
