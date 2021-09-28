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

import com.seyitucar.hrmsSpring.business.abstracts.EmployerService;
import com.seyitucar.hrmsSpring.core.utilities.results.DataResult;
import com.seyitucar.hrmsSpring.core.utilities.results.Result;
import com.seyitucar.hrmsSpring.entities.concretes.Employer;

@CrossOrigin
@RestController
@RequestMapping("/api/employers")
public class EmployersController {
	
	private EmployerService employerService;

	@Autowired
	public EmployersController(EmployerService employerServie) {
		super();
		this.employerService = employerServie;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Employer>> getAll(){
		return this.employerService.getAll();
	}
	
	@GetMapping("/getById")
	public DataResult<Employer> getById(int id){
		return this.employerService.getById(id);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Employer employer){
		return this.employerService.add(employer);		
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody Employer employer) {
		return this.employerService.update(employer);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam int id) {
		return this.employerService.delete(id);
	}
	

}
