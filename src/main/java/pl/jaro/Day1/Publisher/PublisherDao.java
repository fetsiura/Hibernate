package pl.jaro.Day1.Publisher;

import pl.jaro.Day1.common.GenericDao;

public class PublisherDao extends GenericDao<Publisher> {
    public PublisherDao(Class<Publisher> entityClass) {
        super(entityClass);
    }
}
