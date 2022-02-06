package pl.jaro.Day1.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    @Query("select b from Book b JOIN FETCH b.authors a where b.id= ?1")
    Optional<Book> findWithAuthors(Long id);

    @Query("SELECT b FROM Book b WHERE b.title = ?1")
    List<Book> findBooksByTitle(String title);

    @Query("SELECT b FROM Book b WHERE b.category = ?1")
    List<Book> findBooksByCategory(Category category);

    @Query("SELECT b FROM Book b WHERE b.rating BETWEEN :start  AND :end")
    List<Book> findWhenRatingBetween(@Param("start")Integer start, @Param("end")Integer end);

    @Query("SELECT b FROM Book b WHERE b.publisher.name =?1")
    List<Book> findByPublisher(String name);

    @Query(nativeQuery = true,
            value = "SELECT * FROM books WHERE category_id =:category ORDER BY title ASC LIMIT 1")
    Optional<Book> firstBookFromCategoryByTitle(@Param("category") long category);
}
