package net.guides.springboot2.springboot2jpacrudexample.model;
import javax.persistence.*;

@Entity
@Table(name = "quotes")
public class Quotes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "content", nullable = false)
    private String content;
    @ManyToOne 
    @JoinColumn(name="movie_id")
    private Movie movie;

    public Quotes(int id, String content, Movie movie) {
        this.id = id;
        this.content = content;
        this.movie = movie;
    }

    public Quotes(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
   
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Override
    public String toString() {
        return "Quote [content=" + content + ", id=" + id + ", movie=" + movie + "]";
    }
    
}