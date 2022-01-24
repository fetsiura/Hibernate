package pl.jaro.Day1.Publisher;

import org.springframework.stereotype.Repository;
import pl.jaro.Day1.common.GenericDao;

import javax.persistence.Query;
import java.util.List;

@Repository
public class PublisherDao extends GenericDao<Publisher> {
    public PublisherDao() {

        super(Publisher.class);
    }


    public List<Publisher> findAll(){

        Query query = entityManager.createQuery("select p from publishers p");
        return query.getResultList();
    }
}
