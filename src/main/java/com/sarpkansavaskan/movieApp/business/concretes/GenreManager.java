package com.sarpkansavaskan.movieApp.business.concretes;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.sarpkansavaskan.movieApp.business.abstracts.GenreService;
import com.sarpkansavaskan.movieApp.dataAccess.GenreDao;
import com.sarpkansavaskan.movieApp.entities.Genre;

@Service
public class GenreManager implements GenreService {
	
	private final GenreDao genreDao;
	
	
	public GenreManager(GenreDao genreDao) {
		super();
		this.genreDao = genreDao;
	}

	@Override
	public void add(Genre genre) {
		genreDao.save(genre);
		
	}

	@Override
	public void update(Genre genre) {
		genreDao.save(genre);
		
	}

	@Override
	public void delete(int id) {
		genreDao.deleteById(id);
		
	}

	@Override
	public Set<Genre> findByGenreNameIn(List<String> genreName) {

		return genreDao.findByGenreNameIn(genreName);
	}

	@Override
	public Genre getById(int id) {
		return genreDao.getById(id);
	}

	@Override
	public List<Genre> getAll() {
		return genreDao.findAll();
	}

}
