package pl.jaro.Day1.Author;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {

    Optional<Author> findByEmail(String email);
    Optional<Author> findByPesel(String pesel);
    List<Author> findByLastName(String lastName);

    @Query("SELECT a FROM  authors a WHERE a.email LIKE ?1%")
    List<Author> findWhenEmailStartsWith(String email);

    @Query("SELECT a FROM  authors a WHERE a.pesel LIKE ?1%")
    List<Author> findWhenPeselStartsWith(String pesel);




}
