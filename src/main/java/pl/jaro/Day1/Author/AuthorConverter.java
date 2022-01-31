package pl.jaro.Day1.Author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class AuthorConverter implements Converter<String,Author> {

    @Autowired
    private AuthorDao authorDao;

    @Override
    public Author convert(String source){
        return authorDao.find(Long.parseLong(source)).orElseThrow();
    }
}
