package pl.jaro.Day1.PersonDetails;

import org.springframework.stereotype.Repository;
import pl.jaro.Day1.Person.Person;
import pl.jaro.Day1.common.GenericDao;

@Repository
public class PersonDetailsDao extends GenericDao<PersonDetails> {

    public PersonDetailsDao(){
        super(PersonDetails.class);
    }
}
