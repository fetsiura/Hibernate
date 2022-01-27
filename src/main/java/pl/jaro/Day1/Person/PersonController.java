package pl.jaro.Day1.Person;
import org.springframework.ui.Model;
import pl.jaro.Day1.Person.Person;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.jaro.Day1.PersonDetails.PersonDetailsDao;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/persons")
public class PersonController {

    private PersonDao personDao;
    private PersonDetailsDao personDetailsDao;

    public PersonController(PersonDao personDao, PersonDetailsDao personDetailsDao) {
        this.personDao = personDao;
        this.personDetailsDao = personDetailsDao;
    }
    
    
    @GetMapping("/{id}")
    @ResponseBody
    public String get(@PathVariable Long id){

        return personDao.find(id)
                .map( Objects::toString)
                .orElse("person not exists");
    }


    @PostMapping
    public void create(@RequestBody Person person  ){

        personDao.save(person);
    }

    @PostMapping("/{id}/{login}")
    @ResponseBody
    public void update(@PathVariable Long id,
                       @PathVariable String login){

        Person person = personDao.find(id).orElseThrow(RuntimeException::new);
        person.setLogin(login);
        personDao.merge(person);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){

        personDao.delete(id);
    }

    @GetMapping("/form")
    public String getRegistration(Model model){
        model.addAttribute("person",new Person());

        return "/personRegistrationForm";
    }

    @PostMapping("/form")
    @ResponseBody
    public String processRegistration(Person person){
        personDao.save(person);
        return "success";
    }

}
