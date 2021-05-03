package com.salci.myfun.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties; 

@Entity
@Table(name="movies")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Movie {
	@Id
	@Column(name="id",nullable = false)
	@SequenceGenerator(name="movie_seq",sequenceName = "movie_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "movie_seq")
	private Integer id;
	
	private String moviename;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMoviename() {
		return moviename;
	}

	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}

	
	
	

}
