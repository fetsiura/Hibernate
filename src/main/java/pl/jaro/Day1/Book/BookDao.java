package pl.jaro.Day1.Book;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.jaro.Day1.common.GenericDao;

import javax.persistence.Query;
import java.util.List;


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
}
