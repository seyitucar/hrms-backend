package com.seyitucar.hrmsSpring.business.abstracts;

import java.util.List;

import com.seyitucar.hrmsSpring.core.utilities.results.DataResult;
import com.seyitucar.hrmsSpring.core.utilities.results.Result;
import com.seyitucar.hrmsSpring.entities.concretes.Language;

public interface LanguageService {
	
	Result add(Language language);
	Result update(Language language);
	Result delete(int id);
	DataResult<Language> getById(int id);
	DataResult<List<Language>> getAll();
}
