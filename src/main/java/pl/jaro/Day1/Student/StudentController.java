package pl.jaro.Day1.Student;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/student/form")
public class StudentController {

    @GetMapping
    public String getForm(Model model){
        model.addAttribute("student", new Student());
        return "/Student/formCreate";
    }

    @PostMapping
    @ResponseBody
    public String confForm(Student student){
        return student.toString();
    }

    @ModelAttribute("programmingSkillsModel")
    public List<String> skills(){
        return List.of("Java", "PHP", "Python","Ruby");
    }
    @ModelAttribute("countries")
    public List<String>  countries(){
        return List.of("Ukraine", "Poland", "Germany","Italy");
    }
    @ModelAttribute("hobbies")
    public List<String>  hobbies(){
        return List.of("football", "tenis");
    }
    @ModelAttribute("genders")
    public List<String> genders() {
        return Arrays.asList("Male", "Female");
    }

}