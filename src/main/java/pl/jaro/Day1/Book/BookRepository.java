package pl.jaro.Day1.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.jaro.Day1.Author.Author;
import pl.jaro.Day1.Category.Category;
import pl.jaro.Day1.Publisher.Publisher;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

    List<Book> findByTitle(String title);
    List<Book> findByCategory(Category category);
    List<Book> findByCategoryId(Long categoryId);

    List<Book> findByAuthorsContaining(Author author);
    List<Book> findByPublisher(Publisher publisher);
    List<Book> findByRating (Integer rating);
    List<Book> findByCategoryOrderByTitleAsc( Category category);

}
