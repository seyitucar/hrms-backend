package com.seyitucar.hrmsSpring.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seyitucar.hrmsSpring.business.abstracts.EmployerUpdateConfirmService;
import com.seyitucar.hrmsSpring.core.utilities.results.Result;
import com.seyitucar.hrmsSpring.entities.concretes.EmployerUpdateConfirm;

@CrossOrigin
@RestController
@RequestMapping("/api/employerUpdateConfirms")
public class EmployerUpdateConfirmsController {
	
	private EmployerUpdateConfirmService confirmService;

	@Autowired
	public EmployerUpdateConfirmsController(EmployerUpdateConfirmService confirmService) {
		super();
		this.confirmService = confirmService;
	}
	
	@PostMapping("/verifyEmployerUpdate")
	public Result verifyEmployerUpdate(@RequestBody EmployerUpdateConfirm employerUpdateConfirm) {
		return this.confirmService.verifyEmployerUpdate(employerUpdateConfirm);
	}
	
	@PostMapping("/rejectEmployerUpdate")
	public Result rejectEmployerUpdate(@RequestBody EmployerUpdateConfirm employerUpdateConfirm) {
		return this.confirmService.rejectEmployerUpdate(employerUpdateConfirm);
	}

}
