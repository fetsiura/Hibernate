package pl.jaro.Day1.Author;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.jaro.Day1.common.GenericDao;

@Transactional
@Repository
public class AuthorDao extends GenericDao<Author> {
    public AuthorDao() {
        super(Author.class);
    }
}
