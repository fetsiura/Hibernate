package pl.jaro.Day1.Author;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.jaro.Day1.Book.Book;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "authors")
@Data
@NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

//    @ManyToMany(fetch = FetchType.EAGER)
//    private List<Book> books = new ArrayList<>();
}
