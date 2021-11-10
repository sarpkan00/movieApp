package com.sarpkansavaskan.movieApp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sarpkansavaskan.movieApp.business.concretes.GenreService;
import com.sarpkansavaskan.movieApp.entities.Genre;

@Controller
@RequestMapping("/genres")
public class GenreController {

	private final GenreService genreService;

	public GenreController(GenreService genreService) {
		super();
		this.genreService = genreService;
	}

	@GetMapping
	public String index(Model model) {
		List<Genre> genres = genreService.getAllGenre();
		model.addAttribute("genres", genres);
		return "genre/genres";
	}

	@GetMapping("/addgenre")
	public String addGenre(Model model) {
		model.addAttribute("genre", new Genre());

		return "genre/addgenre";
	}

	@GetMapping("/update/{id}")
	public String updateActor(@PathVariable("id") int id, Model model) {
		Genre genre = genreService.getById(id);
		model.addAttribute("genre", genre);

		return "genre/updategenre";
	}

	@GetMapping("/delete/{id}")
	public String deleteActor(@PathVariable("id") int id) {
		genreService.delete(id);
		return "redirect:/genres";
	}

	@PostMapping("/save")
	public String save(Genre genre) {
		genreService.save(genre);
		return "redirect:/genres";
	}

}
