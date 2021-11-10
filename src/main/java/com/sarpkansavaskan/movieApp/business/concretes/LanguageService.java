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
	
	public Language save(Language language) {
		return languageDao.save(language);
		
	}

	public void delete(int id) {
		languageDao.deleteById(id);
	}
	
	public Language getById(int id) {
		return languageDao.getById(id);
	}
	
	
	public List<Language> getAll() {
		return languageDao.findAll();
	}

}
