package com.sarpkansavaskan.movieApp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.sarpkansavaskan.movieApp.business.abstracts.ActorService;
import com.sarpkansavaskan.movieApp.business.abstracts.GenreService;
import com.sarpkansavaskan.movieApp.business.abstracts.LanguageService;
import com.sarpkansavaskan.movieApp.business.abstracts.MovieService;
import com.sarpkansavaskan.movieApp.entities.Actor;
import com.sarpkansavaskan.movieApp.entities.Genre;
import com.sarpkansavaskan.movieApp.entities.Language;
import com.sarpkansavaskan.movieApp.entities.Movie;

@Controller
@RequestMapping("/movies")
public class MovieController {

	private final MovieService movieService;
	private final ActorService actorService;
	private final GenreService genreService;
	private final LanguageService languageService;

	@Autowired
	public MovieController(MovieService movieService, ActorService actorService, GenreService genreService,
			LanguageService languageService) {
		this.movieService = movieService;
		this.actorService = actorService;
		this.genreService = genreService;
		this.languageService = languageService;
	}
	
//
//	@GetMapping
//	public String index(Model model) {
//		Page<Movie> moviePage = movieService.getAll(1, 5);
//		model.addAttribute("moviePage", moviePage);
//		System.out.println(moviePage + "asdasdasASDFASDASDASD");
//		return "movies";
//	}
	
	@GetMapping
	public String Page(Model model) {
		List<Movie> movie = movieService.getAll();
		model.addAttribute("movie", movie);
		
		return "movies";
	}

	@GetMapping("/add")
	public String addMovie(@Valid Model model) {
		List<Actor> actors = actorService.getAll();
		List<Genre> genres = genreService.getAll();
		List<Language> languages = languageService.getAll();
		model.addAttribute("movie", new Movie());
		model.addAttribute("actors", actors);
		model.addAttribute("genres", genres);
		model.addAttribute("languages", languages);

		return "addmovie";
	}
	
	@PostMapping("/save")
	public String save( Movie movie) {
		movieService.save(movie);
		return "redirect:/movies";
	}

	@GetMapping("/update/{id}")
	public String updateMovie(@PathVariable("id") int id, Model model) {
		Movie movie = movieService.getById(id);
		List<Actor> actors = actorService.getAll();
		List<Genre> genres = genreService.getAll();
		List<Language> languages = languageService.getAll();
		model.addAttribute("movie", movie);
		model.addAttribute("actors", actors);
		model.addAttribute("genres", genres);
		model.addAttribute("languages", languages);

		return "updatemovie";
	}

	public String deleteMovie(@PathVariable("id") int id) {
		movieService.delete(id);
		return "redirect:/movies";
	}
}