package com.sarpkansavaskan.movieApp.business.abstracts;

import java.util.List;
import java.util.Set;

import com.sarpkansavaskan.movieApp.entities.Genre;

public interface GenreService {
	
	void add(Genre genre);
	
	void update(Genre genre);
	
	void delete(int id);
	
	Set<Genre> findByGenreNameIn(List<String> genreName);
	
	Genre getById(int id);
	
	List<Genre> getAll();

}
