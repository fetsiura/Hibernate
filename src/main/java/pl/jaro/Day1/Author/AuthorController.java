package pl.jaro.Day1.Author;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.jaro.Day1.Book.Confirm;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorRepository authorRepository;
    private final AuthorDao authorDao;
    private final Confirm confirm;

    public AuthorController(AuthorRepository authorRepository, AuthorDao authorDao, Confirm confirm) {
        this.authorRepository = authorRepository;
        this.authorDao = authorDao;
        this.confirm = confirm;
    }

    @GetMapping
    public String getAll(Model model){
        model.addAttribute("authors",authorDao.findAll());
        return "/Authors/authorsPage";
    }


    @GetMapping("/form")
    public String getFormCreate(Model model){
        model.addAttribute("author",new Author());
        return "/Authors/authorCreate";
    }

    @PostMapping("/form")
    public String getProcessCreate(Author author){
        authorDao.save(author);
        return "redirect:/authors";
    }

    ///edit form
    @GetMapping("/update/{id}")
    public String getAuthorEditForm(@PathVariable("id") Long id,
                                  Model model){
        model.addAttribute("author",authorDao.find(id).orElseThrow());
        return "/Authors/authorEdit";
    }

    @PostMapping("/update/{id}")
    public String editAuthor(Author author){
        authorDao.merge(author);
        return "redirect:/authors";
    }

    ///delete form
    @GetMapping("/delete/{id}")
    public String deleteAuthor(@PathVariable Long id){
        int check = confirm.check();
        if(check==0){
            authorDao.delete(id);
        }
        return "redirect:/authors";
    }

    @GetMapping("/option")
    public String getWithOptions(@RequestParam Optional<String> pesel,
                                 @RequestParam Optional<String> email,
                                 Model model){
        List<Author> authors = new ArrayList<>();

        if(!pesel.isEmpty()){
            authors = pesel.map(authorRepository::findWhenPeselStartsWith).orElseThrow();
        }
        if(!email.isEmpty()){
            authors = email.map(authorRepository::findWhenEmailStartsWith).orElseThrow();
        }
        model.addAttribute("authors",authors);
        return "/Authors/authorsPage";
    }
}
