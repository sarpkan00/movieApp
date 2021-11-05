package com.sarpkansavaskan.movieApp.business.concretes;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sarpkansavaskan.movieApp.business.abstracts.GenreService;
import com.sarpkansavaskan.movieApp.business.abstracts.MovieService;
import com.sarpkansavaskan.movieApp.dataAccess.ActorDao;
import com.sarpkansavaskan.movieApp.dataAccess.GenreDao;
import com.sarpkansavaskan.movieApp.dataAccess.LanguageDao;
import com.sarpkansavaskan.movieApp.dataAccess.MovieDao;
import com.sarpkansavaskan.movieApp.entities.Actor;
import com.sarpkansavaskan.movieApp.entities.Genre;
import com.sarpkansavaskan.movieApp.entities.Language;
import com.sarpkansavaskan.movieApp.entities.Movie;

@Service
public class MovieManager implements MovieService {

	private final  MovieDao movieDao;
	private final ActorDao actorDao;
	private final GenreService genreService;
	private final LanguageDao languageDao;
	

	public MovieManager(MovieDao movieDao, ActorDao actorDao, 
			GenreService genreService, LanguageDao languageDao) {
		this.movieDao = movieDao;
		this.actorDao = actorDao;
		this.genreService = genreService;
		this.languageDao = languageDao;
	}

	@Override
	public void save(Movie movie) {
		String actor1 = movie.getActor().stream().map(a -> a.getActorName()).toString();
		List<Actor> actor = actorDao.findByActorName(actor1);
		movie.setActor(actor);

		Set<Genre> genre = genreService.findByGenreNameIn(movie.getGenre().stream().map(Genre::getGenreName)
				.collect(Collectors.toList()));
		movie.setGenre(genre);
		
		Set<Language> language = languageDao.findByNameIn(movie.getLanguage().stream().map(Language::getName).collect(Collectors.toList()));
		movie.setLanguage(language);
		
		
		
		movieDao.save(movie);
		
		

	}

//	@Override
//	public void update(Movie movie) {
//		List<Actor> actors = actorService.getAllByMovieId(movie.getId());
//		movie.setActor(new HashSet<>(actors));
//		movieDao.save(movie);
//
//	}

	@Override
	public void delete(int id) {
		movieDao.deleteById(id);

	}

	@Override
	public Movie getById(int id) {
		return movieDao.getById(id);
	}

	@Override
	public List<Movie> getAllByMovieIdOrderByRealeseYear(Date realeseYear) {

		return movieDao.getAllByIdOrderByRealeseYear(realeseYear);
	}

//	@Override
//	public List<Movie> getAll(int pageNo, int pageSize) {
//			Pageable pageable = PageRequest.of(1, 5, Sort.by("name").ascending());
//		return movieDao.findAll(pageable).getContent();
//	}
	
	@Override
	public Page<Movie> getAll(int pageNo, int pageSize) {
			Sort sort = Sort.by(Sort.Direction.ASC,"name");
			Pageable pageable = PageRequest.of(pageNo, pageSize,sort);
		return movieDao.findAll(pageable);
	}

	@Override
	public List<Movie> getAll() {
		return movieDao.findAll();
	}


//	@Override
//	public List<Movie> getAllAsc() {
//		Sort sort = Sort.by(Sort.Direction.ASC,"name");
//		return movieDao.findAll(sort);
//	}

}
