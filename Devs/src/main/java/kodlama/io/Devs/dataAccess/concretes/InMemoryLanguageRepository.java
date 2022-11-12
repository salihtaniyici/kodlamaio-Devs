package kodlama.io.Devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.Devs.entities.concretes.Language;

@Repository
public class InMemoryLanguageRepository implements LanguageRepository {
	List<Language> languages;
	
	public InMemoryLanguageRepository() {
		//super();
		languages = new ArrayList<Language>();
		languages.add(new Language(1,"C#"));
		languages.add(new Language(2,"Java"));
		languages.add(new Language(3,"Python"));
		
		
	}

	@Override
	public List<Language> getAll() {
		return languages;
	}

	@Override
	public void add(Language language) {
		this.languages.add(language);
		
	}

	@Override
	public void delete(int id) {
		for(Language language:languages) {
			if(language.getId()==id) {
				languages.remove(id);
			}
		}
		
	}

	@Override
	public void update(Language language) {
		for(Language lang:languages) {
			if(lang.getId()==language.getId()) 
			{
				lang.setId(language.getId());
				lang.setName(language.getName());
			}
		}
		
	}

	@Override
	public Language getById(int id) {
		for(Language language:languages) {
			if(language.getId()==id) {
				return language;
			}
		}
		return null;
	}

	
	

}
