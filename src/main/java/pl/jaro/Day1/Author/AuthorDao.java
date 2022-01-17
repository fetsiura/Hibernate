package pl.jaro.Day1.Author;

import pl.jaro.Day1.common.GenericDao;

public class AuthorDao extends GenericDao<Author> {
    public AuthorDao(Class<Author> entityClass) {
        super(entityClass);
    }
}
