package com.easyaudit.business.abstracts;

import java.util.List;

import com.easyaudit.core.utilities.results.DataResult;
import com.easyaudit.core.utilities.results.Result;
import com.easyaudit.entities.concretes.Question;

public interface QuestionService {
	
	Result add(Question question);
	Result update(Question question);
	Result delete(int id);
	DataResult<Question> getById(int id);
	DataResult<List<Question>> getAll();
}
