package com.sarpkansavaskan.movieApp.business.abstracts;

import java.util.List;

import com.sarpkansavaskan.movieApp.entities.Language;

public interface LanguageService {
	
	void delete(int id);
	
	List<Language> getAll();

}
