package pl.jaro.Day1.Book;


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

    public BookFormController(BookDao bookDao, PublisherDao publisherDao, AuthorDao authorDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.authorDao = authorDao;
    }


    @GetMapping("/form")
    public String getBookForm(Model model){
        model.addAttribute("book", new Book());
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
    @GetMapping("/edit/{id}")
    public String getEditForm(@PathVariable Long id,
                              Model model){
        model.addAttribute("book",bookDao.find(id).orElseThrow());
        return "/Books/bookEdit";

    }

    @PostMapping("/update")
    public String processEditBook(Book book){
        bookDao.merge(book);
        return "redirect:/books";
    }



    @ModelAttribute("publishers")
    public List<Publisher> publishers(){
        return publisherDao.findAll();
    }

    @ModelAttribute("authors")
    public List<Author> authors(){
        return authorDao.findAll();
    }

}
