package com.sarpkansavaskan.movieApp.dataAccess;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sarpkansavaskan.movieApp.entities.Actor;

@Repository
public interface ActorDao extends JpaRepository<Actor, Integer> {
	
	List<Actor> findByActorName(String actorName);
} 
