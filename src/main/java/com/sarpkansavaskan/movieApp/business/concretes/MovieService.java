package com.sarpkansavaskan.movieApp.business.concretes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sarpkansavaskan.movieApp.dataAccess.ActorDao;
import com.sarpkansavaskan.movieApp.dataAccess.GenreDao;
import com.sarpkansavaskan.movieApp.dataAccess.LanguageDao;
import com.sarpkansavaskan.movieApp.dataAccess.MovieDao;
import com.sarpkansavaskan.movieApp.entities.Actor;
import com.sarpkansavaskan.movieApp.entities.Genre;
import com.sarpkansavaskan.movieApp.entities.Language;
import com.sarpkansavaskan.movieApp.entities.Movie;

@Service
public class MovieService {

	private final  MovieDao movieDao;
	private final ActorDao actorDao;
	private final GenreDao genreDao;
	private final LanguageDao languageDao;
	

	public MovieService(MovieDao movieDao, ActorDao actorDao, 
			GenreDao genreDao, LanguageDao languageDao) {
		this.movieDao = movieDao;
		this.actorDao = actorDao;
		this.genreDao = genreDao;
		this.languageDao = languageDao;
	}

	
	public void save(Movie movie) {
		
		List<Actor> actors = actorDao.findByActorNameIn(movie.getActors().stream().map(Actor::getActorName)
				.collect(Collectors.toList()));
		movie.setActors(actors);
		
		List<Genre> genres = genreDao.findByGenreNameIn(movie.getGenres().stream().map(Genre::getGenreName)
				.collect(Collectors.toList()));
		movie.setGenres(genres);
		
		List<Language> languages = languageDao.findByNameIn(movie.getLanguages().stream().map(Language::getName)
				.collect(Collectors.toList()));
		movie.setLanguages(languages);
		
		movieDao.save(movie);
		

	}

//	@Override
//	public void update(Movie movie) {
//		List<Actor> actors = actorService.getAllByMovieId(movie.getId());
//		movie.setActor(new HashSet<>(actors));
//		movieDao.save(movie);
//
//	}

	
	public void delete(int id) {
		movieDao.deleteById(id);

	}


	public Movie getById(int id) {
		return movieDao.getById(id);
	}


	public List<Movie> getAllByMovieIdOrderByRealeseYear(Date realeseYear) {

		return movieDao.getAllByIdOrderByRealeseYear(realeseYear);
	}

//	@Override
//	public List<Movie> getAll(int pageNo, int pageSize) {
//			Pageable pageable = PageRequest.of(1, 5, Sort.by("name").ascending());
//		return movieDao.findAll(pageable).getContent();
//	}
	

	public Page<Movie> getAll(int pageNo, int pageSize) {
			Sort sort = Sort.by(Sort.Direction.ASC,"name");
			Pageable pageable = PageRequest.of(pageNo, pageSize,sort);
		return movieDao.findAll(pageable);
	}


	public List<Movie> getAll() {
		return movieDao.findAll();
	}


//	@Override
//	public List<Movie> getAllAsc() {
//		Sort sort = Sort.by(Sort.Direction.ASC,"name");
//		return movieDao.findAll(sort);
//	}

}
