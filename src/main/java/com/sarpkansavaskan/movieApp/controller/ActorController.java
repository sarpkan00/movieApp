package com.sarpkansavaskan.movieApp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import com.sarpkansavaskan.movieApp.business.concretes.ActorService;
import com.sarpkansavaskan.movieApp.entities.Actor;

@Controller
@RequestMapping("/actors")
public class ActorController {
	
	private final ActorService actorService;

	public ActorController(ActorService actorService) {
		super();
		this.actorService = actorService;
	}
	
	@GetMapping
	public String index(Model model) {
		List<Actor> actors = actorService.getAll();
		model.addAttribute("actors", actors);
		return "actor/actors";
	}
	
	@GetMapping("/addactor")
	public String addActor(Model model) {
		model.addAttribute("actor", new Actor());
		return "actor/addactor";
	}
	
	@GetMapping("/update/{id}")
	public String updateActor(@PathVariable("id") int id, Model model) {
		Actor actor = actorService.getById(id);
		model.addAttribute("actor", actor);
		return "actor/updateactor";
	}
	
	@GetMapping("/delete/{id}")
    public String deleteActor(@PathVariable("id") int id) {
        actorService.delete(id);
        return "redirect:/actors";
    }
	
    @PostMapping("/save")
    public String save(Actor actor) {
        actorService.save(actor);
        return "redirect:/actors";
    }
}
