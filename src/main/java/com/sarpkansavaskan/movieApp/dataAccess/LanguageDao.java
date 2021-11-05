package com.sarpkansavaskan.movieApp.dataAccess;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sarpkansavaskan.movieApp.entities.Language;

@Repository
public interface LanguageDao extends JpaRepository<Language, Integer>{

	Set<Language> findByNameIn(List<String> name);
	
	Language findByMovieId(int id);
}
