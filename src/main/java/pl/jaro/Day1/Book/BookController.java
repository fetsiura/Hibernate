package pl.jaro.Day1.Book;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.jaro.Day1.Author.Author;
import pl.jaro.Day1.Author.AuthorDao;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/books/old")
public class BookController {

    private final BookDao bookDao;
    private final AuthorDao authorDao;

    public BookController(BookDao bookDao, AuthorDao authorDao) {
        this.bookDao = bookDao;
        this.authorDao= authorDao;
    }

    @PostMapping
    public void create(@RequestBody Book book){

        Author author1 = authorDao.find(1L).orElseThrow();
        Author author2 = authorDao.find(2L).orElseThrow();

        book.addAuthor(author1);
        book.addAuthor(author2);
        bookDao.save(book);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public String get(@PathVariable Long id){

        return bookDao.find(id)
                .map(Objects::toString)
                .orElse("book not exists");
    }


    @PostMapping("/update/{id}/{title}")
    @ResponseBody
    public void update(@PathVariable Long id,
                         @PathVariable String title){

        Book book = bookDao.find(id).orElseThrow(RuntimeException::new);
        book.setTitle(title);
        bookDao.merge(book);
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable Long id){

        bookDao.delete(id);
    }

    @GetMapping
    @ResponseBody
    public String getBooks(@RequestParam Optional<Integer> rating){
    return rating.map(bookDao::getRatingList)
                .orElseGet(bookDao::findAll)
                .stream()
                .map(Objects::toString)
                .collect(Collectors.joining());

    }

    @GetMapping("/publisher")
    @ResponseBody
    public String getBooksWithPublishers(@RequestParam Optional<String> name){

        return name.map( bookDao::definitelyPublisher)
                .orElseGet(bookDao::ifPublisherExist)
                .stream()
                .map(Objects::toString)
                .collect(Collectors.joining());

    }


}
