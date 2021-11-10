package com.sarpkansavaskan.movieApp.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;
import com.sarpkansavaskan.movieApp.dataAccess.ActorDao;
import com.sarpkansavaskan.movieApp.entities.Actor;

@Service
public class ActorService {

	private final ActorDao actorDao;

	public ActorService(ActorDao actorDao) {
		this.actorDao = actorDao;
	}


	public Actor save(Actor actor) {
		
		actorDao.save(actor);
		return actor;
	}
	public void delete(int id) {
	actorDao.deleteById(id);
	}


	public Actor getById(int id) {
		return actorDao.getById(id);
	}

	public List<Actor> getAll() {
		return actorDao.findAll();
	}

}
