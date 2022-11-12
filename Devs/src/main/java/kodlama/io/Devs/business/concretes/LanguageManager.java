package kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.Devs.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService {
	private LanguageRepository languageRepository;
	
	
	@Autowired
	public LanguageManager(LanguageRepository languageRepository) {
		//super();
		this.languageRepository = languageRepository;
		
		
	}

	@Override
	public List<Language> getAll() {
		return languageRepository.getAll();
	}

	@Override
	public void add(Language language) throws Exception{
		if(language.getName().isEmpty()) {
			throw new Exception("Name cannot be empty!");
		}else if(isValid(language.getName())) {
			throw new Exception("Language registered!");
		}else {languageRepository.add(language);}
		
	}

	@Override
	public void delete(int id) {
		languageRepository.delete(id);
		
	}

	@Override
	public void update(Language language) {
		languageRepository.update(language);
		
	}

	@Override
	public Language getById(int id) {
		return this.languageRepository.getById(id);
	}
	
	private boolean isValid(String name) {
		for(Language lang:languageRepository.getAll()){
			if(lang.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}

}
