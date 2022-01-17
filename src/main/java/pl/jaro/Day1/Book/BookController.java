package pl.jaro.Day1.Book;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookDao bookDao;

    public BookController(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @PostMapping
    public void create(@RequestBody Book book){

        bookDao.save(book);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public String get(@PathVariable Long id){

        return bookDao.findById(id)
                .map(Objects::toString)
                .orElse("book not exists");
    }


    @PostMapping("/update/{id}/{title}")
    @ResponseBody
    public void update(@PathVariable Long id,
                         @PathVariable String title){

        Book book = bookDao.findById(id).orElseThrow(RuntimeException::new);
        book.setTitle(title);
        bookDao.update(book);
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable Long id){

        bookDao.delete(id);
    }

}
