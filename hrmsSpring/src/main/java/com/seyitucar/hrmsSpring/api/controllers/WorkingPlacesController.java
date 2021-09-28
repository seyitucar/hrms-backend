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

import com.seyitucar.hrmsSpring.business.abstracts.WorkingPlaceService;
import com.seyitucar.hrmsSpring.core.utilities.results.DataResult;
import com.seyitucar.hrmsSpring.core.utilities.results.Result;
import com.seyitucar.hrmsSpring.entities.concretes.WorkingPlace;

@CrossOrigin
@RestController
@RequestMapping("/api/workingplaces")
public class WorkingPlacesController {
	
	private WorkingPlaceService workingPlaceService;
	
	@Autowired
	public WorkingPlacesController(WorkingPlaceService workingPlaceService) {
		super();
		this.workingPlaceService = workingPlaceService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody WorkingPlace workingPlace) {
		return this.workingPlaceService.add(workingPlace);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody WorkingPlace workingPlace) {
		return this.workingPlaceService.update(workingPlace);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam int id) {
		return this.workingPlaceService.delete(id);
	}
	
	@GetMapping("/getById")
	public DataResult<WorkingPlace> getById(@RequestParam int id){
		return this.workingPlaceService.getById(id);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<WorkingPlace>> getAll(){
		return this.workingPlaceService.getAll();
	}

}
