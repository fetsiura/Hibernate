package pl.jaro.Day1.Author;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "authors")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {

    @Id
    private Integer id;
    private String firstName;
    private String lastName;
}
