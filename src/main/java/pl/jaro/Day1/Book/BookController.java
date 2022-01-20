package pl.jaro.Day1.Book;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.jaro.Day1.Author.Author;
import pl.jaro.Day1.Author.AuthorDao;

import java.util.Objects;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/books")
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
    public String getBooks(){
      return bookDao.findAll().stream()
              .map(Book::toString)
              .collect(Collectors.joining());
    }
}
