package com.platzi.java.tests.movies.data;

import java.util.Collection;

import com.platzi.java.tests.movies.model.Movie;

public interface MovieRepository {

	Movie findById(long id);
	Collection<Movie> findAll();
	void saveOrUpdate(Movie movie);
	
}
