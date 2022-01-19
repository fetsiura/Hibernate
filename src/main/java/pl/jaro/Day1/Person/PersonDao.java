package pl.jaro.Day1.Person;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.jaro.Day1.common.GenericDao;

@Transactional
@Repository
public class PersonDao extends GenericDao<Person> {

    public PersonDao(){
        super(Person.class);
    }
}
