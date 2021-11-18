package net.guides.springboot2.springboot2jpacrudexample.service;
import net.guides.springboot2.springboot2jpacrudexample.model.Movie;
import net.guides.springboot2.springboot2jpacrudexample.model.Quotes;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.guides.springboot2.springboot2jpacrudexample.repository.MovieRepository;
import net.guides.springboot2.springboot2jpacrudexample.repository.QuotesRepository;

@Service
public class MovieQuotesService {
    
    @Autowired
    private MovieRepository repositorioMovies;
    @Autowired
    private QuotesRepository repositorioQuotes;

    public Movie saveMovie(Movie movie) {
        return repositorioMovies.save(movie);
    }

    public List<Movie> saveMovies(List<Movie> movie) {
        return repositorioMovies.saveAll(movie);
    }

    public Quotes saveQuote(Quotes quote) {
        return repositorioQuotes.save(quote);
    }

    public List<Quotes> saveQuotes(List<Quotes> quote) {
        return repositorioQuotes.saveAll(quote);
    }

    public Quotes findQuoteById(int id){
        return repositorioQuotes.findById(id);
    }

    public List<Quotes> findQuotesByMovie(Movie movie){
        return repositorioQuotes.findByMovie(movie);
    }

    public int countQuotes(){
        return (int) repositorioQuotes.count();
    }

    public Movie findMovieById(int id){
        return repositorioMovies.findById(id);
    }

    public List<Quotes> findAllQuotes(){
        return repositorioQuotes.findAll();
    }

    public List<Movie> findAllMovies(){
        return repositorioMovies.findAll();
    }
}