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

import com.seyitucar.hrmsSpring.business.abstracts.SkillService;
import com.seyitucar.hrmsSpring.core.utilities.results.DataResult;
import com.seyitucar.hrmsSpring.core.utilities.results.Result;
import com.seyitucar.hrmsSpring.entities.concretes.Skill;

@CrossOrigin
@RestController
@RequestMapping("/api/skills")
public class SkillsController {

	private SkillService skillService;
	
	@Autowired
	public SkillsController(SkillService skillService) {
		super();
		this.skillService = skillService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody Skill skill) {
		return this.skillService.add(skill);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody Skill skill) {
		return this.skillService.update(skill);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam int id) {
		return this.skillService.delete(id);
	}
	
	@GetMapping("/getById")
	public DataResult<Skill> getById(@RequestParam int id){
		return this.skillService.getById(id);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Skill>> getAll(){
		return this.skillService.getAll();
	}
	
	@GetMapping("/getAllByEmployeeId")
	DataResult<List<Skill>> getAllByEmployeeId(@RequestParam int employeeId){
		return this.skillService.getAllByEmployeeId(employeeId);
	}
}
