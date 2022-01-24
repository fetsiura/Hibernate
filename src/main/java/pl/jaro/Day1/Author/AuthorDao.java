package pl.jaro.Day1.Author;

import org.springframework.stereotype.Repository;
import pl.jaro.Day1.Publisher.Publisher;
import pl.jaro.Day1.common.GenericDao;

import javax.persistence.Query;
import java.util.List;

@Repository
public class AuthorDao extends GenericDao<Author> {
    public AuthorDao() {
        super(Author.class);
    }


    public List<Author> findAll(){

        Query query = entityManager.createQuery("select a from authors a");
        return query.getResultList();
    }
}
