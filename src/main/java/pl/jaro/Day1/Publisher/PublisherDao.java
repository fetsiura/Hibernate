package pl.jaro.Day1.Publisher;

import org.springframework.stereotype.Repository;
import pl.jaro.Day1.common.GenericDao;

@Repository
public class PublisherDao extends GenericDao<Publisher> {
    public PublisherDao() {

        super(Publisher.class);
    }
}
