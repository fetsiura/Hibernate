package pl.jaro.Day1.Book;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/books")
public class BookControllerNew {

    private final BookRepository bookRepository;

    public BookControllerNew(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @GetMapping
    @ResponseBody
    public String findAll(@RequestParam Optional<String> title){

        return title.map(bookRepository::findByTitle)
                .orElseGet(bookRepository::findAll)
                .stream()
                .map(Objects::toString)
                .collect(Collectors.joining());
    }
}
