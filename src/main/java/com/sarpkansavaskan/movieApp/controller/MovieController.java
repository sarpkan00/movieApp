package com.sarpkansavaskan.movieApp.controller;

import java.util.List;


import javax.validation.Valid;


import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.sarpkansavaskan.movieApp.business.concretes.*;
import com.sarpkansavaskan.movieApp.entities.*;


@Controller
@RequestMapping("/movies")
public class MovieController {
	
	private final MovieService movieService;
	private final ActorService actorService;
	private final GenreService genreService;
	private final LanguageService languageService;

	
	public MovieController(MovieService movieService, ActorService actorService, GenreService genreService,
			LanguageService languageService) {
	this.movieService = movieService;
		this.actorService = actorService;
		this.genreService = genreService;
		this.languageService = languageService;
}
	

//	@GetMapping
//	public String index(Model model) {
//		Page<Movie> moviePage = movieService.getAll(1, 5);
//		model.addAttribute("moviePage", moviePage);
//		System.out.println(moviePage + "asdasdasASDFASDASDASD");
//		return "movies";
//	}
	
	@GetMapping
	public String Page(Model model) {
		List<Movie> movies = movieService.getAll();
		model.addAttribute("movie", movies);
		return "movie/movies";
	}
	

	@GetMapping("/add")
	public String addMovie(@Valid Model model) {
		model.addAttribute("movie", new Movie());
		model.addAttribute("actors", actorService.getAll());
		model.addAttribute("genres", genreService.getAllGenre());
		model.addAttribute("languages", languageService.getAll());
                       
		return "movie/addmovie";
	}
	
	@GetMapping("/update/{id}")
	public String updateMovie(@PathVariable("id") int id, Model model) {
		Movie movie = movieService.getById(id);
		List<Genre> genres = genreService.getAllGenre();
		List<Language> languages = languageService.getAll();
		List<Actor> actors = actorService.getAll();
		model.addAttribute("movie", movie);
		model.addAttribute("actors",actors);
		model.addAttribute("genres", genres);
		model.addAttribute("languages", languages);
		return "movie/updatemovie";
	}
	
	@PostMapping("/save")
	public String save(Movie movie) {
		movieService.save(movie);
		return "redirect:/movies";
	}

	
	@GetMapping("/delete/{id}")
	public String deleteMovie(@PathVariable("id") int id) {
		movieService.delete(id);
		return "redirect:/movies";
	}
}
