package pl.jaro.Day1.Author;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {

    Optional<Author> findByEmail(String email);
    Optional<Author> findByPesel(String pesel);
    List<Author> findByLastName(String lastName);


}
