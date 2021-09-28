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

import com.seyitucar.hrmsSpring.business.abstracts.WorkingTypeService;
import com.seyitucar.hrmsSpring.core.utilities.results.DataResult;
import com.seyitucar.hrmsSpring.core.utilities.results.Result;
import com.seyitucar.hrmsSpring.entities.concretes.WorkingType;

@CrossOrigin
@RestController
@RequestMapping("/api/workingtypes")
public class WorkingTypesController {
	
	private WorkingTypeService workingTypeService;

	@Autowired
	public WorkingTypesController(WorkingTypeService workingTypeService) {
		super();
		this.workingTypeService = workingTypeService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody WorkingType workingType) {
		return this.workingTypeService.add(workingType);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody WorkingType workingType) {
		return this.workingTypeService.update(workingType);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam int id) {
		return this.workingTypeService.delete(id);
	}
	
	@GetMapping("/getById")
	public DataResult<WorkingType> getById(@RequestParam int id){
		return this.workingTypeService.getById(id);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<WorkingType>> getAll(){
		return this.workingTypeService.getAll();
	}

}
