package pl.jaro.Day1.Book;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.jaro.Day1.Author.Author;
import pl.jaro.Day1.Publisher.Publisher;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Integer rating;
    private String description;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @ManyToMany(cascade = CascadeType.MERGE)
    private List<Author> authors = new ArrayList<>();

    public void addAuthor(Author author){
        authors.add(author);
    }
}
