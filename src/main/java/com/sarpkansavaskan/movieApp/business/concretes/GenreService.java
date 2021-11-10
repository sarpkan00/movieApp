package com.sarpkansavaskan.movieApp.business.concretes;

import java.util.List;


import org.springframework.stereotype.Service;
import com.sarpkansavaskan.movieApp.dataAccess.GenreDao;
import com.sarpkansavaskan.movieApp.entities.Genre;

@Service
public class GenreService {
	
	private final GenreDao genreDao;
	
	
	public GenreService(GenreDao genreDao) {
		super();
		this.genreDao = genreDao;
	}
	
	public Genre save(Genre genre) {
		genreDao.save(genre);
		
		return genre;
	}

	public void delete(int id) {
		genreDao.deleteById(id);
	}

	
	public List<Genre> getByGenreName(List<String> genreName){
		return genreDao.findByGenreNameIn(genreName);
	}

	public Genre getById(int id) {
		return genreDao.getById(id);
	}

	public List<Genre> getAllGenre() {
		return genreDao.findAll();
	}

}
