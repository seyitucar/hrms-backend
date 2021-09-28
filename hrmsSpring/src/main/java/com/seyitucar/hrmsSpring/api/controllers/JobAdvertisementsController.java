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

import com.seyitucar.hrmsSpring.business.abstracts.JobAdvertisementService;
import com.seyitucar.hrmsSpring.core.utilities.results.DataResult;
import com.seyitucar.hrmsSpring.core.utilities.results.Result;
import com.seyitucar.hrmsSpring.entities.concretes.JobAdvertisement;

@CrossOrigin
@RestController
@RequestMapping("/api/jobAdvertisements")
public class JobAdvertisementsController {
	
	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement){
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody JobAdvertisement jobAdvertisement){
		return this.jobAdvertisementService.update(jobAdvertisement);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam int id){
		return this.jobAdvertisementService.delete(id);
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobAdvertisement>> getAll(){
		return this.jobAdvertisementService.getAll();
	}
	
	@GetMapping("/getById")
	public DataResult<JobAdvertisement> getById(int id){
		return this.jobAdvertisementService.getById(id);
	}

	@GetMapping("/getByIsActiveTrue")
	public DataResult<List<JobAdvertisement>> getByIsActiveTrue(){
		return this.jobAdvertisementService.getByIsActiveTrue();
	}
	
	@GetMapping("/getByIsActiveFalse")
	public DataResult<List<JobAdvertisement>> getByIsActiveFalse(){
		return this.jobAdvertisementService.getByIsActiveFalse();
	}

	@GetMapping("/getByEmployerId")
	public DataResult<List<JobAdvertisement>> getByEmployerId(@RequestParam int employerId){
		return this.jobAdvertisementService.getByEmployerId(employerId);
	}
	
	@GetMapping("/getByIsActiveTrueAndCompanyName")
	public DataResult<List<JobAdvertisement>> getByIsActiveTrueAndCompanyName(@RequestParam String companyName){
	return this.jobAdvertisementService.getByIsActiveTrueAndCompanyName(companyName);
	}

	 
	@GetMapping("/getByIsActiveTrueOrderByApplicationDeadline")
	public DataResult<List<JobAdvertisement>> getByIsActiveTrueOrderByApplicationDeadline(){
		return this.jobAdvertisementService.getByIsActiveTrueOrderByApplicationDeadline();
	}
	
	@GetMapping("/getByIsActiveTrueOrderByApplicationDeadlineDesc")
	public DataResult<List<JobAdvertisement>> getByIsActiveTrueOrderByApplicationDeadlineDesc(){
		return this.jobAdvertisementService.getByIsActiveTrueOrderByApplicationDeadlineDesc();
	}

	@PostMapping("/setStatus")
	public Result setStatus(@RequestParam int jobAdvertisementId, @RequestParam int employerId, @RequestParam boolean status) {
		return this.jobAdvertisementService.setStatus(jobAdvertisementId, employerId, status);
	}
	
}
