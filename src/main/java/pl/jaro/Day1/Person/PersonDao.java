package pl.jaro.Day1.Person;

import org.springframework.stereotype.Repository;
import pl.jaro.Day1.common.GenericDao;

@Repository
public class PersonDao extends GenericDao<Person> {

    public PersonDao(){
        super(Person.class);
    }
}
