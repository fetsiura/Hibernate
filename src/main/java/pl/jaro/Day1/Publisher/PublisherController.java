package pl.jaro.Day1.Publisher;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.jaro.Day1.Author.Author;
import pl.jaro.Day1.Author.AuthorDao;
import pl.jaro.Day1.Book.Confirm;

@Controller
@RequestMapping("/publishers")
public class PublisherController {

    private final PublisherDao publisherDao;
    private final Confirm confirm;

    public PublisherController(PublisherDao publisherDao, Confirm confirm) {
        this.publisherDao = publisherDao;
        this.confirm = confirm;
    }

    @GetMapping
    public String getAll(Model model){
        model.addAttribute("publishers", publisherDao.findAll());
        return "/Publishers/publishersPage";
    }


    @GetMapping("/form")
    public String getFormCreate(Model model){
        model.addAttribute("publisher",new Publisher());
        return "/Publishers/publisherCreate";
    }

    @PostMapping("/form")
    public String getProcessCreate(Publisher publisher){
        publisherDao.save(publisher);
        return "redirect:/publishers";
    }

    ///edit form
    @GetMapping("/update/{id}")
    public String getPublisherEditForm(@PathVariable("id") Long id,
                                  Model model){
        model.addAttribute("publisher", publisherDao.find(id).orElseThrow());
        return "/Publishers/publisherEdit";
    }

    @PostMapping("/update/{id}")
    public String editPublisher(Publisher publisher){
        publisherDao.merge(publisher);
        return "redirect:/publishers";
    }

    ///delete form
    @GetMapping("/delete/{id}")
    public String deletePublisher(@PathVariable Long id){
        int check = confirm.check();
        if(check==0){
            publisherDao.delete(id);
        }
        return "redirect:/publishers";
    }


}
