package com.platzi.java.tests.movies.data;

import java.util.Collection;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.platzi.java.tests.movies.model.Genre;
import com.platzi.java.tests.movies.model.Movie;

public class MovieRepositoryJDBC implements MovieRepository {
	
	private JdbcTemplate jdbcTemplate;
	
	public MovieRepositoryJDBC(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Movie findById(long id) {
		
		Object[] args = { id };
		
		return jdbcTemplate.queryForObject("SELECT * FROM movies WHERE id = ?", args, movieMapper);
	}

	@Override
	public Collection<Movie> findAll() {
		return this.jdbcTemplate.query("SELECT * FROM movies", movieMapper);
	}

	@Override
	public void saveOrUpdate(Movie movie) {
		// TODO Auto-generated method stub

	}

	private static RowMapper<Movie> movieMapper = (rs, rowNum) ->
		new Movie(
			rs.getInt("id"),
			rs.getString("name"),
			rs.getInt("minutes"),
			Genre.valueOf(rs.getString("genre")) 
		);

}
