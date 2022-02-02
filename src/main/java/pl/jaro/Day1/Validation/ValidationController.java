package pl.jaro.Day1.Validation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.jaro.Day1.Book.Book;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Controller
@Slf4j
public class ValidationController {

    private final Validator validator;

    @Autowired
    public ValidationController(Validator validator) {
        this.validator = validator;
    }


    @GetMapping("/validate")
    public String validateBookTest(Model model){
        Book book = new Book();
        book.setRating(100);

        Set<ConstraintViolation<Book>> validate = validator.validate(book);
        if(!validate.isEmpty()){
            validate.forEach( bookConstraintViolation -> log.warn(bookConstraintViolation.getMessage()+" -> "+bookConstraintViolation.getPropertyPath()));

        } else {

        }
        model.addAttribute("validateList",validate);
        return "/validate/validate";
    }
}
