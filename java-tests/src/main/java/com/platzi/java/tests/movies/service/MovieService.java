package com.platzi.java.tests.movies.service;

import java.util.Collection;
import java.util.stream.Collectors;

import com.platzi.java.tests.movies.data.MovieRepository;
import com.platzi.java.tests.movies.model.Genre;
import com.platzi.java.tests.movies.model.Movie;

public class MovieService {
	
	private MovieRepository movieRepository;
	
	public MovieService(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

	public Collection<Movie> findMoviesByGenre(Genre genre) {
		
		Collection<Movie> allMovies = movieRepository.findAll().stream().
				filter(movie -> movie.getGenre() == genre).collect(Collectors.toList());
		
		return allMovies;
	}

	public Collection<Movie> findMovieByLenght(int lenght) {

		Collection<Movie> allMovies = movieRepository.findAll().stream().
				filter(movie -> movie.getMinutes() <= lenght).collect(Collectors.toList());
		
		return allMovies;
	}
	
	
	
}
