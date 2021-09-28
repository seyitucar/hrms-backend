package com.seyitucar.hrmsSpring.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.seyitucar.hrmsSpring.business.abstracts.CoverLetterService;
import com.seyitucar.hrmsSpring.core.utilities.results.DataResult;
import com.seyitucar.hrmsSpring.core.utilities.results.Result;
import com.seyitucar.hrmsSpring.entities.concretes.CoverLetter;

@CrossOrigin
@RestController
@RequestMapping("/api/coverletters")
public class CoverLettersController {
	
	private CoverLetterService coverLetterService;

	@Autowired
	public CoverLettersController(CoverLetterService coverLetterService) {
		super();
		this.coverLetterService = coverLetterService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CoverLetter coverLetter) {
		return this.coverLetterService.add(coverLetter);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody CoverLetter coverLetter ) {
		return this.coverLetterService.update(coverLetter);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam int id) {
		return this.coverLetterService.delete(id);
	}
	
	@GetMapping("/getById")
	public DataResult<CoverLetter> getById(@RequestParam int id){
		return this.coverLetterService.getById(id);
	}
	
	@GetMapping("/getAllByEmployeeId")
	public DataResult<List<CoverLetter>> getAllByEmployeeId(@RequestParam int employeeId){
		return this.coverLetterService.getAllByEmployeeId(employeeId);
	}

	
	@GetMapping("/getAll")
	public DataResult<List<CoverLetter>> getAll(){
		return this.coverLetterService.getAll();
	}
	
}
