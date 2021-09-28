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

import com.seyitucar.hrmsSpring.business.abstracts.EmployerUpdateService;
import com.seyitucar.hrmsSpring.core.utilities.results.DataResult;
import com.seyitucar.hrmsSpring.core.utilities.results.Result;
import com.seyitucar.hrmsSpring.entities.concretes.EmployerUpdate;

@CrossOrigin
@RestController
@RequestMapping("/api/employerUpdates")
public class EmployerUpdatesController { 
	
	private EmployerUpdateService employerUpdateService;
	
	@Autowired
	public EmployerUpdatesController(EmployerUpdateService employerUpdateService) {
		super();
		this.employerUpdateService = employerUpdateService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody EmployerUpdate employerUpdate) {
		return this.employerUpdateService.add(employerUpdate);
	}
	
	
	@GetMapping("/getAll")
	public DataResult<List<EmployerUpdate>> getAll() {
		return this.employerUpdateService.getAll();
	}
	
	@GetMapping("/getByEmployerIdAndIsVerifiedFalse")
	public DataResult<EmployerUpdate> getByEmployerIdAndIsVerifiedFalse(@RequestParam int employerId) {
		return this.employerUpdateService.getByEmployerIdAndIsVerifiedFalse(employerId);
	}

}
