package pl.jaro.Day1.Author;

import org.springframework.stereotype.Repository;
import pl.jaro.Day1.common.GenericDao;

@Repository
public class AuthorDao extends GenericDao<Author> {
    public AuthorDao() {
        super(Author.class);
    }
}
