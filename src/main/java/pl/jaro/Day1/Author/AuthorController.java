package pl.jaro.Day1.Author;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.jaro.Day1.Book.Confirm;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorDao authorDao;
    private final Confirm confirm;

    public AuthorController(AuthorDao authorDao, Confirm confirm) {
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


}
