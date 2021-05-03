package com.salci.myfun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salci.myfun.exception.ResourceNotFoundexception;
import com.salci.myfun.model.Movie;
import com.salci.myfun.repository.MovieRepository;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class MovieController {
	@Autowired
	private MovieRepository movieRepository;
	
	@CrossOrigin
	@PostMapping("/movie")
	public Movie createMovie(@RequestBody Movie movie) {
		Movie movie1 = movieRepository.save(movie);
		
		return movie1;
	}
	
	@CrossOrigin
	@GetMapping("/movies")
	public Page<Movie> listMovies(org.springframework.data.domain.Pageable pageable){
		
		return movieRepository.findAll(pageable);
	}
	
	@CrossOrigin
	@GetMapping("/movie/{id}")
	public Movie getById(@PathVariable Integer id) {
		Movie movie = movieRepository.getOne(id);
		return movie;
	}
	
	@CrossOrigin
	@DeleteMapping("/movie")
	public ResponseEntity<?> deleteMovie(@PathVariable Integer id){
		
		return movieRepository.findById(id)
				.map(movie->{
					movieRepository.delete(movie);
					
					return ResponseEntity.ok().build();
				}).orElseThrow(()->new ResourceNotFoundexception("Not found with id"));
			
		
	}
	
	
	
	
}
