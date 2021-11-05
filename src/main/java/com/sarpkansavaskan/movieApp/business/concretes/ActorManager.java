package com.sarpkansavaskan.movieApp.business.concretes;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.sarpkansavaskan.movieApp.business.abstracts.ActorService;
import com.sarpkansavaskan.movieApp.dataAccess.ActorDao;
import com.sarpkansavaskan.movieApp.entities.Actor;

@Service
public class ActorManager implements ActorService {
	
	private final ActorDao actorDao;

	public ActorManager(ActorDao actorDao) {
		this.actorDao = actorDao;
	}

	@Override
	public Optional<Actor> findById(int id) {
		
		return actorDao.findById(id);
	}
	
	@Override
	public List<Actor> getByActorName(String actorName) {
		
		return actorDao.findByActorName(actorName);
	}
	
	

	@Override
	public List<Actor> getAll() {
		
		return actorDao.findAll();
	}

	@Override
	public List<Actor> getAllByMovieId(int movieId) {
		// TODO Auto-generated method stub
		return null;
	}

	

	

}
