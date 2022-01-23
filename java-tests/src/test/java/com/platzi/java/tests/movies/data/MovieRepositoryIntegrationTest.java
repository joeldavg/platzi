package com.platzi.java.tests.movies.data;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Collection;

import javax.sql.DataSource;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import com.platzi.java.tests.movies.model.Genre;
import com.platzi.java.tests.movies.model.Movie;

public class MovieRepositoryIntegrationTest {

	private MovieRepositoryJDBC movieRepositoryJDBC = null;
	private DataSource dataSource = null;
	
	@Before
	public void setUp() throws SQLException {
		dataSource =
				new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL", "sa", "sa");
		
		ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("test-data.sql"));
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		MovieRepositoryJDBC movieRepositoryJDBC = new MovieRepositoryJDBC(jdbcTemplate);
	}
	
	@Test
	public void loadAllMovies() {

		Collection<Movie> movies = movieRepositoryJDBC.findAll();
		
		assertThat( movies, CoreMatchers.is(Arrays.asList(
                new Movie(1, "Dark Knight", 152, Genre.ACTION),
                new Movie(2, "Memento", 113, Genre.THRILLER),
                new Movie(3, "Matrix", 136, Genre.ACTION)
        )) );
		
	}
	
	@Test
	public void loadMovieById() {
		
		Movie movie = movieRepositoryJDBC.findById(2);
		
		assertThat(movie, CoreMatchers.is( new Movie(2, "Memento", 113, Genre.THRILLER)) );
	}
	
	@After
	public void tearDown() throws Exception {
		final Statement s = dataSource.getConnection().createStatement();
		s.execute("drop all objects delete files"); //"shutdown" is also enough 
	}

}
