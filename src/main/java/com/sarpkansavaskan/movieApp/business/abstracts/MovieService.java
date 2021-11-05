package com.sarpkansavaskan.movieApp.business.abstracts;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;

import com.sarpkansavaskan.movieApp.entities.Movie;

public interface MovieService {
	
	void save(Movie movie);
	
	void delete(int id);
	
	Movie getById(int id);
	
	List<Movie> getAllByMovieIdOrderByRealeseYear(Date realeseYear);
	
//	List<Movie> getAllAsc();
	
	Page<Movie> getAll(int pageNo, int pageSize);
	
	List<Movie> getAll();
	

}
