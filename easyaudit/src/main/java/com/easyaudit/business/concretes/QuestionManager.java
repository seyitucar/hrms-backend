package com.easyaudit.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easyaudit.business.abstracts.QuestionService;
import com.easyaudit.core.utilities.results.DataResult;
import com.easyaudit.core.utilities.results.Result;
import com.easyaudit.core.utilities.results.SuccessDataResult;
import com.easyaudit.core.utilities.results.SuccessResult;
import com.easyaudit.dataAccess.abstracts.QuestionDao;
import com.easyaudit.entities.concretes.Question;

@Service
public class QuestionManager implements QuestionService {
	
	private QuestionDao questionDao;

	@Autowired
	public QuestionManager(QuestionDao questionDao) {
		super();
		this.questionDao = questionDao;
	}

	@Override
	public Result add(Question question) {
		this.questionDao.save(question);
		return new SuccessResult("Denetim sorusu eklendi");
	}

	@Override
	public Result update(Question question) {
		Question updQuestion = this.questionDao.getById(question.getId());
		updQuestion.setAuditQuestion(question.getAuditQuestion());
		updQuestion.setMainCategory(question.getMainCategory());
		updQuestion.setSubCategory(question.getSubCategory());
		this.questionDao.save(updQuestion);
		return new SuccessResult("Denetim sorusu güncellendi");
	}

	@Override
	public Result delete(int id) {
		this.questionDao.deleteById(id);
		return new SuccessResult("Denetim sorusu silindi");
	}

	@Override
	public DataResult<Question> getById(int id) {
		return new SuccessDataResult<Question>(this.questionDao.findById(id).orElse(null));
	}

	@Override
	public DataResult<List<Question>> getAll() {
		return new SuccessDataResult<List<Question>>(this.questionDao.findAll());
	}

}
