package pl.jaro.Day1.common;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Transactional
public abstract class GenericDao<T> {

    private final Class<T> entityClass;

    @PersistenceContext
    protected EntityManager entityManager;

    public GenericDao(Class<T> entityClass) {
        //TODO: To mozna zrobic bez przekazywania clazz ale wymaga np refleksji, której jeszcze nie znacie
        this.entityClass = entityClass;
    }

    public Optional<T> find(Long id) {
        return Optional.ofNullable(entityManager.find(entityClass, id));
    }

    public void save(T entity) {
        entityManager.persist(entity);
    }

    public T merge(T entity) {
        return entityManager.merge(entity);
    }

    public void delete(T entity) {
        entityManager.remove(entityManager.contains(entity) ?
            entity : entityManager.merge(entity));
    }

    public void delete(Long id) {
        find(id).ifPresent(entityManager::remove);
    }

    public List<T> findAll(){
        String question = "select entity from "+ entityClass.getSimpleName()+" entity";
        Query query = entityManager.createQuery(question);
        return query.getResultList();
    }

}
