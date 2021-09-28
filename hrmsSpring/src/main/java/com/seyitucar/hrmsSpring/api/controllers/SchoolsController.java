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

import com.seyitucar.hrmsSpring.business.abstracts.SchoolService;
import com.seyitucar.hrmsSpring.core.utilities.results.DataResult;
import com.seyitucar.hrmsSpring.core.utilities.results.Result;
import com.seyitucar.hrmsSpring.entities.concretes.School;

@CrossOrigin
@RestController
@RequestMapping("/api/schools")
public class SchoolsController {
	
	private SchoolService schoolService;

	@Autowired
	public SchoolsController(SchoolService schoolService) {
		super();
		this.schoolService = schoolService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody School school) {
		return this.schoolService.add(school);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody School school) {
		return this.schoolService.update(school);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam int id) {
		return this.schoolService.delete(id);
	}
	
	@GetMapping("/getById")
	public DataResult<School> getById(@RequestParam int id){
		return this.schoolService.getById(id);
	}
	
	
	@GetMapping("/getAll")
	public DataResult<List<School>> getAll(){
		return this.schoolService.getAll();
	}
	
	@GetMapping("/findAllByEmployeeIdOrderBySchoolGraduationDateDesc")
	DataResult<List<School>> findAllByEmployeeIdOrderBySchoolGraduationDateDesc(@RequestParam int employeeId){
		return this.schoolService.findAllByEmployeeIdOrderBySchoolGraduationDateDesc(employeeId);
	}

}
