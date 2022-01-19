package pl.jaro.Day1.Person;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.jaro.Day1.PersonDetails.PersonDetails;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String password;
    private String email;

    @OneToOne(cascade = CascadeType.MERGE)
    private PersonDetails personDetails;
}
