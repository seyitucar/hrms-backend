package com.seyitucar.hrmsSpring.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seyitucar.hrmsSpring.business.abstracts.JobAdvertisementConfirmService;
import com.seyitucar.hrmsSpring.core.utilities.results.Result;
import com.seyitucar.hrmsSpring.entities.concretes.JobAdvertisementConfirm;

@CrossOrigin
@RestController
@RequestMapping("/api/jobAdvertisementConfirms")
public class JobAdvertisementConfirmsController {
	
	private JobAdvertisementConfirmService jobAdvertisementConfirmService;
	
	@Autowired
	public JobAdvertisementConfirmsController(JobAdvertisementConfirmService jobAdvertisementConfirmService) {
		super();
		this.jobAdvertisementConfirmService = jobAdvertisementConfirmService;
	}

	@PostMapping("/setActiveJobAdvertisement")
	public Result setActiveJobAdvertisement(@RequestBody JobAdvertisementConfirm jobAdvertisementConfirm) {
		return this.jobAdvertisementConfirmService.setActiveJobAdvertisement(jobAdvertisementConfirm);
	}
	
	@PostMapping("/setPassiveJobAdvertisement")
	public Result setPassiveJobAdvertisement(@RequestBody JobAdvertisementConfirm jobAdvertisementConfirm) {
		return this.jobAdvertisementConfirmService.setPassiveJobAdvertisement(jobAdvertisementConfirm);
	}

}
