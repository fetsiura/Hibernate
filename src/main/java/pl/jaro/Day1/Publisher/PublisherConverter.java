package pl.jaro.Day1.Publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class PublisherConverter implements Converter<String, Publisher> {
    @Autowired
    private PublisherDao publisherDao;

    @Override
    public Publisher convert(String source) {

        return publisherDao.find(Long.parseLong(source)).orElseThrow();
    }
}