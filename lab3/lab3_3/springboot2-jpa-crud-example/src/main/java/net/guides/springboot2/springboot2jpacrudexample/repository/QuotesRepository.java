package net.guides.springboot2.springboot2jpacrudexample.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import net.guides.springboot2.springboot2jpacrudexample.model.Movie;
import net.guides.springboot2.springboot2jpacrudexample.model.Quotes;

public interface QuotesRepository extends JpaRepository<Quotes, Integer> {
    Quotes findById(int id);
    List<Quotes> findByMovie(Movie movie);
}
