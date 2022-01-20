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
}
