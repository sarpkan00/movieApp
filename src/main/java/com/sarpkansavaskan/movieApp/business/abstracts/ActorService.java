package com.sarpkansavaskan.movieApp.business.abstracts;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.sarpkansavaskan.movieApp.entities.Actor;

public interface ActorService {

	
	Optional<Actor> findById(int id);
	
	List<Actor> getByActorName(String actorName);
	
	List<Actor> getAllByMovieId(int movieId);

	List<Actor> getAll();
	
	
}
