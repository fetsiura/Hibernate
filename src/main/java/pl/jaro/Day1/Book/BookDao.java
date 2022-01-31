package pl.jaro.Day1.Book;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.jaro.Day1.common.GenericDao;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;


@Repository
public class BookDao extends GenericDao<Book> {


    public BookDao() {
        super(Book.class);
    }



    @Transactional(readOnly = true)
    public List<Book> findAll (){

        Query query = entityManager.createQuery("select b from Book b");

        return query.getResultList();
    }

    @Transactional(readOnly = true)
    public List<Book> getRatingList(int rating){
        Query query = entityManager.createQuery("select b from Book b where b.rating = :rating");
       query.setParameter("rating",rating);
        return query.getResultList();
    }

    @Transactional(readOnly = true)
    public List<Book> ifPublisherExist(){
        Query query = entityManager.createQuery("select b from Book b where b.publisher is not null ");
        return query.getResultList();
    }

    @Transactional(readOnly = true)
    public List<Book> definitelyPublisher(String name){
        Query query = entityManager.createQuery("select b from Book b where b.publisher.name= :name");
        query.setParameter("name",name);
        return query.getResultList();
    }
    @Transactional(readOnly = true)
    public List<Book> definitelyAuthor(String name){
        Query query = entityManager.createQuery("select b from Book b JOIN b.authors a where a.firstName= :name");
        query.setParameter("name",name);
        return query.getResultList();
    }

    @Transactional
    public Optional<Book> getWithAuthors(Long id){
        Query query = entityManager.createQuery("select b from Book b JOIN FETCH b.authors a where b.id= :id");
        query.setParameter("id",id);
        try{
            Book singleResult =(Book) query.getSingleResult();
            return Optional.of(singleResult);
        }catch (NoResultException ex){
            return Optional.empty();
        }
    }
}
