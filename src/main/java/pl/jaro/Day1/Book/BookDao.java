package pl.jaro.Day1.Book;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;


@Slf4j
@Repository
@Transactional
public class BookDao {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Book book){
        log.info("Save book {}",book);
        entityManager.persist(book);
    }

    public Optional<Book> findById (Long id){
       return Optional.ofNullable(entityManager.find(Book.class,id));
    }


    public Book update (Book book){
        log.info("Update book {}",book);
        return entityManager.merge(book);
    }


    public void delete(Long id){

        findById(id).ifPresent(entityManager ::remove);

    }
}
