package com.easyaudit.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.easyaudit.business.abstracts.QuestionService;
import com.easyaudit.core.utilities.results.DataResult;
import com.easyaudit.core.utilities.results.Result;
import com.easyaudit.entities.concretes.Question;

@CrossOrigin
@RestController
@RequestMapping("/api/questions")
public class QuestionsController {
	
	private QuestionService questionService;
	
	@Autowired
	public QuestionsController(QuestionService questionService) {
		super();
		this.questionService = questionService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody Question question) {
		return this.questionService.add(question);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody Question question) {
		return this.questionService.update(question);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam int id) {
		return this.questionService.delete(id);
	}
	
	@GetMapping("/getById")
	public DataResult<Question> getById(@RequestParam int id) {
		return this.questionService.getById(id);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Question>> getAll() {
		return this.questionService.getAll();
	}
}
