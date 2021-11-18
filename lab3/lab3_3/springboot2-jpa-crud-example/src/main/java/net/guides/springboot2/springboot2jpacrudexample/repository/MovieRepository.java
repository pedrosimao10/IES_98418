package net.guides.springboot2.springboot2jpacrudexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.guides.springboot2.springboot2jpacrudexample.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    Movie findById(int id);
}
