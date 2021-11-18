package net.guides.springboot2.springboot2jpacrudexample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;


@Entity
@Table(name = "movies")
public class Movie {
    private int id;
    private String title;
    private int year;

    @OneToMany(mappedBy = "movie")
    private List<Quotes> quotes;

    public Movie(int id, String title, int year) {
        this.id = id;
        this.title = title;
        this.year = year;
    }

    public Movie(){}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "title", nullable = false)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "year", nullable = false)
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


    @Override
    public String toString() {
        return "Movie [id=" + id + ", title=" + title + ", year=" + year + "]";
    }
}