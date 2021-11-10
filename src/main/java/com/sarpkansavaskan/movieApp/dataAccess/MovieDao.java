package com.sarpkansavaskan.movieApp.dataAccess;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sarpkansavaskan.movieApp.entities.Actor;
import com.sarpkansavaskan.movieApp.entities.Movie;

@Repository
public interface MovieDao extends JpaRepository<Movie, Integer> {

	List<Movie> getAllByIdOrderByRealeseYear(Date realeseYear);
	
	Movie getById(int id);
	
	void save(Actor actor);
}
