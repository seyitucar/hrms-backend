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

import com.seyitucar.hrmsSpring.business.abstracts.JobExperienceService;
import com.seyitucar.hrmsSpring.core.utilities.results.DataResult;
import com.seyitucar.hrmsSpring.core.utilities.results.Result;
import com.seyitucar.hrmsSpring.entities.concretes.JobExperience;

@CrossOrigin
@RestController
@RequestMapping("/api/jobexperiences")
public class JobExperiencesController {
	
	private JobExperienceService jobExperienceService;

	@Autowired
	public JobExperiencesController(JobExperienceService jobExperienceService) {
		super();
		this.jobExperienceService = jobExperienceService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobExperience jobExperience) {
		return this.jobExperienceService.add(jobExperience);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody JobExperience jobExperience){
		return this.jobExperienceService.update(jobExperience);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam int id) {
		return this.jobExperienceService.delete(id);
	}
	
	@GetMapping("/getById")
	public DataResult<JobExperience> getById(@RequestParam int id){
		return this.jobExperienceService.getById(id);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobExperience>> getAll(){
		return this.jobExperienceService.getAll();
	}
	
	@GetMapping("/findAllByEmployeeIdOrderByJobLeaveDateDesc")
	DataResult<List<JobExperience>> findAllByEmployeeIdOrderByJobLeaveDateDesc(@RequestParam int employeeId){
		return this.jobExperienceService.findAllByEmployeeIdOrderByJobLeaveDateDesc(employeeId);
	}

}
