package com.seyitucar.hrmsSpring.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.seyitucar.hrmsSpring.business.abstracts.FavoriteJobService;
import com.seyitucar.hrmsSpring.core.utilities.results.DataResult;
import com.seyitucar.hrmsSpring.core.utilities.results.Result;
import com.seyitucar.hrmsSpring.entities.concretes.FavoriteJob;

@CrossOrigin
@RestController
@RequestMapping("/api/favoriteJobs")
public class FavoriteJobsController {
	
	private FavoriteJobService favoriteJobService;

	@Autowired
	public FavoriteJobsController(FavoriteJobService favoriteJobService) {
		super();
		this.favoriteJobService = favoriteJobService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody FavoriteJob favoriteJob) {
		return this.favoriteJobService.add(favoriteJob);
	}
	
	@PostMapping("/remove")
	public Result remove(@RequestParam int id) {
		return this.favoriteJobService.remove(id);
	}
	
	@GetMapping("/getAll")
	public Result getAll() {
		return this.favoriteJobService.getAll();
	}
	
	@GetMapping("/getById")
	public Result getById(@RequestParam int id) {
		return this.favoriteJobService.getById(id);
	}
	
	
	@GetMapping("/getAlByEmployeeId")
	public Result getAllByEmployeeId(@RequestParam int employeeId) {
		return this.favoriteJobService.getAllByEmployeeId(employeeId);
	}
	
	
	@GetMapping("/getByEmployeeIdAndJobAdvertisementId")
	public DataResult<FavoriteJob> getByEmployeeIdAndJobAdvertisementId(@RequestParam int employeeId, @RequestParam int jobAdvertisementId) {
		return this.favoriteJobService.getByEmployeeIdAndJobAdvertisementId(employeeId,jobAdvertisementId);
	}
	


}
