package com.sarpkansavaskan.movieApp.dataAccess;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sarpkansavaskan.movieApp.entities.Genre;

@Repository
public interface GenreDao extends JpaRepository<Genre, Integer>{
	
	Set<Genre> findByGenreNameIn(List<String> genreName);
	
}
