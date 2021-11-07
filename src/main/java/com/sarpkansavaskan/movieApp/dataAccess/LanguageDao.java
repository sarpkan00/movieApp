package com.sarpkansavaskan.movieApp.dataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sarpkansavaskan.movieApp.entities.Language;

@Repository
public interface LanguageDao extends JpaRepository<Language, Integer>{
	
	List<Language> findByNameIn(List<String> name);
	
	//Set<Language> findAllByMoviesId(int id);
	
}
