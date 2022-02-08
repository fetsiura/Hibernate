package pl.jaro.Day1.Book;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.jaro.Day1.Author.Author;
import pl.jaro.Day1.Author.AuthorRepository;
import pl.jaro.Day1.Publisher.Publisher;
import pl.jaro.Day1.Publisher.PublisherRepository;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/books")
public class BookControllerNew {

    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;
    private final AuthorRepository authorRepository;
    private final Confirm confirm;

    public BookControllerNew(BookRepository bookRepository, PublisherRepository publisherRepository, AuthorRepository authorRepository, Confirm confirm) {
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
        this.authorRepository = authorRepository;
        this.confirm = confirm;
    }

//    @GetMapping
//    @ResponseBody
//    public String findAll(@RequestParam Optional<String> title){
//
//        return title.map(bookRepository::findByTitle)
//                .orElseGet(bookRepository::findAll)
//                .stream()
//                .map(Objects::toString)
//                .collect(Collectors.joining());
//    }

    /////all books
    @GetMapping
    public String showAll(@RequestParam Optional<String> publisher,
                          Model model){
        List<Book> collect = new ArrayList<>(publisher.map(bookRepository::findByPublisher)
                .orElseGet(bookRepository::findAll));
        model.addAttribute("books",collect);
        return "Books/booksPage";
    }

    /// add book
    @GetMapping("/form")
    public String getBookForm(Model model){
        model.addAttribute("book", new Book());
        model.addAttribute("publishers", publisherRepository.findAll());
        return "/Books/bookCreate";
    }

    @PostMapping("/form")
    public String createBook(@Valid Book book, BindingResult result){
        if(result.hasErrors()){
            return "/Books/bookCreate";
        }
        bookRepository.save(book);
        return "redirect:/books";
    }


    ///edit book
    @GetMapping("/edit/{id}")
    public String getBookEditForm(@PathVariable("id") Long id,
                                  Model model){
        model.addAttribute("book",bookRepository.findWithAuthors(id).orElseThrow());
        return "/Books/bookEdit";
    }

    @PostMapping("/update")
    public String editBook(@Valid Book book,
                           BindingResult result){
        if (result.hasErrors()){
            return "/Books/BookEdit";
        }
        bookRepository.save(book);

        return "redirect:/books";
    }

    ///delete book
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id){
        int check = confirm.check();
        if(check==0){
            bookRepository.deleteById(id);
        }
        return "redirect:/books";
    }

    //ZAD 2
    @GetMapping("/punkt1")
    public String punkt1(Model model){
        model.addAttribute("books",bookRepository.findWhenRatingBetween(3,5));
        return "Books/booksPage";
    }
    @GetMapping("/punkt3")
    public String punkt3(Model model){
        List<Book> books = new ArrayList<>();
        Book book = bookRepository.firstBookFromCategoryByTitle(1L).orElseThrow();
        books.add(book);

        model.addAttribute("books",books);
        return "Books/booksPage";
    }


    ///////////
    @ModelAttribute("publishers")
    public List<Publisher> publishers(){
        return publisherRepository.findAll();
    }

    @ModelAttribute("authors")
    public List<Author> authors(){
        return authorRepository.findAll();
    }
}
