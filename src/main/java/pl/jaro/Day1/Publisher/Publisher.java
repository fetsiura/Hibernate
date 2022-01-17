package pl.jaro.Day1.Publisher;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "publishers")
public class Publisher {

    @Id
    private Integer id;
    private String name;
}
