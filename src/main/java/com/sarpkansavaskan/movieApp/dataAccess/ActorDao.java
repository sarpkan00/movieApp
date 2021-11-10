package com.sarpkansavaskan.movieApp.dataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sarpkansavaskan.movieApp.entities.Actor;

@Repository
public interface ActorDao extends JpaRepository<Actor, Integer> {

	List<Actor> findByActorNameIn(List<String> actorName);

//	Actor getById(int id);
}
