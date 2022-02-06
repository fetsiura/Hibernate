package pl.jaro.Day1.Book;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import pl.jaro.Day1.Author.Author;
import pl.jaro.Day1.Category.Category;
import pl.jaro.Day1.Publisher.Publisher;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Size(min = 5,max = 50)
    private String title;

    @Range(min = 1,max=10)
    private Integer rating;

    @Size(max = 600)
    private String description;

//    @NotNull
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

//    @NotNull
    @ManyToMany(cascade = CascadeType.MERGE)
    private List<Author> authors = new ArrayList<>();

//    @Min(2)
//    private Integer pages;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "category_id")
    private Category category;


    public void addAuthor(Author author){
        authors.add(author);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", rating=" + rating +
                ", description='" + description + '\'' +
                ", publisher=" + publisher +
                '}';
    }
}
