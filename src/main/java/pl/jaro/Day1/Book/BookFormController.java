package pl.jaro.Day1.Book;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.jaro.Day1.Author.Author;
import pl.jaro.Day1.Author.AuthorDao;
import pl.jaro.Day1.Publisher.Publisher;
import pl.jaro.Day1.Publisher.PublisherDao;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookFormController {

    private final BookDao bookDao;
    private final PublisherDao publisherDao;
    private final AuthorDao authorDao;
    private final Confirm confirm;

    public BookFormController(BookDao bookDao, PublisherDao publisherDao, AuthorDao authorDao, Confirm confirm) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.authorDao = authorDao;
        this.confirm = confirm;
    }


    @GetMapping("/form")
    public String getBookForm(Model model){
        model.addAttribute("book", new Book());
        model.addAttribute("publishers", publisherDao.findAll());
        return "/Books/bookCreate";
    }

    @PostMapping("/form")
    public String createBook(Book book){
        bookDao.save(book);
        return "redirect:/books";
    }


    @GetMapping
    public String showAll(Model model){
        model.addAttribute("books",bookDao.findAll());
        return "Books/booksPage";
    }

    ///edit form
    @GetMapping("/update/{id}")
    public String getBookEditForm(@PathVariable("id") Long id,
                                  Model model){
        model.addAttribute("book",bookDao.getWithAuthors(id).orElseThrow());
        return "/Books/bookEdit";
    }

    @PostMapping("/update/{id}")
    public String editBook(Book book){
        bookDao.merge(book);
        return "redirect:/books";
    }

    ///delete form
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id){
        int check = confirm.check();
        if(check==0){
            bookDao.delete(id);
        }
        return "redirect:/books";
    }



///////////
    @ModelAttribute("publishers")
    public List<Publisher> publishers(){
        return publisherDao.findAll();
    }

    @ModelAttribute("authors")
    public List<Author> authors(){
        return authorDao.findAll();
    }

}
