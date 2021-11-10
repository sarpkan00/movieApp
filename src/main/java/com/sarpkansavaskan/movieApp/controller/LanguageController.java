package com.sarpkansavaskan.movieApp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sarpkansavaskan.movieApp.business.concretes.LanguageService;
import com.sarpkansavaskan.movieApp.entities.Language;

@Controller
@RequestMapping("/languages")
public class LanguageController {

	private final LanguageService languageService;

	public LanguageController(LanguageService languageService) {
		super();
		this.languageService = languageService;
	}
	
	@GetMapping
	public String index(Model model) {
		List<Language> languages = languageService.getAll();
		model.addAttribute("languages", languages);
		return "language/languages";
	}

	@GetMapping("/addlanguage")
	public String addLanguage(Model model) {
		model.addAttribute("language", new Language());

		return "language/addlanguage";
	}

	@GetMapping("/update/{id}")
	public String updateActor(@PathVariable("id") int id, Model model) {
		Language language = languageService.getById(id);
		model.addAttribute("language", language);

		return "language/updatelanguage";
	}

	@GetMapping("/delete/{id}")
	public String deleteActor(@PathVariable("id") int id) {
		languageService.delete(id);
		return "redirect:/languages";
	}

	@PostMapping("/save")
	public String save(Language language) {
		languageService.save(language);
		return "redirect:/languages";
	}
}
