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

import com.seyitucar.hrmsSpring.business.abstracts.JobTitleService;
import com.seyitucar.hrmsSpring.core.utilities.results.DataResult;
import com.seyitucar.hrmsSpring.core.utilities.results.Result;
import com.seyitucar.hrmsSpring.entities.concretes.JobTitle;

@CrossOrigin
@RestController
@RequestMapping("/api/jobtitles")
public class JobTitlesController {
	
	private JobTitleService jobTitleService;
	
	@Autowired
	public JobTitlesController(JobTitleService jobTitleService) {
		super();
		this.jobTitleService = jobTitleService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobTitle jobTitle){
		return this.jobTitleService.add(jobTitle);		
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody JobTitle jobTitle) {
		return this.jobTitleService.update(jobTitle);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam int id) {
		return this.jobTitleService.delete(id);
	}
	
	@GetMapping("/getById")
	public DataResult<JobTitle> getById(@RequestParam int id){
		return this.jobTitleService.getById(id);
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobTitle>> getAll(){
		return this.jobTitleService.getAll();		
	}

}
