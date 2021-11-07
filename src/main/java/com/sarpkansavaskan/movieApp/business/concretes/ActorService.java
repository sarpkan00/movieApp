package com.sarpkansavaskan.movieApp.business.concretes;

import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;
import com.sarpkansavaskan.movieApp.dataAccess.ActorDao;
import com.sarpkansavaskan.movieApp.entities.Actor;

@Service
public class ActorService{
	
	private final ActorDao actorDao;

	public ActorService(ActorDao actorDao) {
		this.actorDao = actorDao;
	}
	
	public Optional<Actor> getById(int id) {
		return actorDao.findById(id);
	}
	
	public List<Actor> getAllByMovieId(int movieId) {
        return actorDao.findByMovies_Id(movieId);
    }
	
	public List<Actor> getByActorName(List<String> actorName) {
		return actorDao.findByActorNameIn(actorName);
	}

	
	public List<Actor> getAll() {
		return actorDao.findAll();
	}

	

	

}
