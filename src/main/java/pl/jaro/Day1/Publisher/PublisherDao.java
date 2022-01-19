package pl.jaro.Day1.Publisher;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.jaro.Day1.common.GenericDao;

@Transactional
@Repository
public class PublisherDao extends GenericDao<Publisher> {
    public PublisherDao() {

        super(Publisher.class);
    }
}
