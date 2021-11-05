package com.sarpkansavaskan.movieApp.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sarpkansavaskan.movieApp.business.abstracts.LanguageService;
import com.sarpkansavaskan.movieApp.dataAccess.LanguageDao;
import com.sarpkansavaskan.movieApp.entities.Language;

@Service
public class LanguageManager implements LanguageService{
	
	private final LanguageDao languageDao;
	
	
	public LanguageManager(LanguageDao languageDao) {
		this.languageDao = languageDao;
	}
	

	@Override
	public void delete(int id) {
		languageDao.deleteById(id);
		
	}

	@Override
	public List<Language> getAll() {
		return languageDao.findAll();
	}

}
