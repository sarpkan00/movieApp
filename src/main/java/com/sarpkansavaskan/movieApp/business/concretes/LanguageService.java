package com.sarpkansavaskan.movieApp.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;


import com.sarpkansavaskan.movieApp.dataAccess.LanguageDao;
import com.sarpkansavaskan.movieApp.entities.Language;

@Service
public class LanguageService {
	
	private final LanguageDao languageDao;
	
	
	public LanguageService(LanguageDao languageDao) {
		this.languageDao = languageDao;
	}
	
	
	public List<Language> getAll() {
		return languageDao.findAll();
	}

}
