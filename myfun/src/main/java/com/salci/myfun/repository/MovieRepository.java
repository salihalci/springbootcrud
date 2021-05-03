package com.salci.myfun.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salci.myfun.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer>{

}
