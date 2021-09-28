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

import com.seyitucar.hrmsSpring.business.abstracts.SystemUserService;
import com.seyitucar.hrmsSpring.core.utilities.results.DataResult;
import com.seyitucar.hrmsSpring.core.utilities.results.Result;
import com.seyitucar.hrmsSpring.entities.concretes.SystemUser;

@CrossOrigin
@RestController
@RequestMapping("/api/systemusers")
public class SystemUsersController {
	
	private SystemUserService systemUserService;
	
	@Autowired
	public SystemUsersController(SystemUserService systemUserService) {
		super();
		this.systemUserService = systemUserService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody SystemUser systemUser) {
		return this.systemUserService.add(systemUser);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody SystemUser systemUser) {
		return this.systemUserService.update(systemUser);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam int id) {
		return this.systemUserService.delete(id);
	}
	
	@GetMapping("/getById")
	public DataResult<SystemUser> getById(@RequestParam int id){
		return this.systemUserService.getById(id);
	}

	@GetMapping("/getAll")
	public DataResult<List<SystemUser>> getAll(){
		return this.systemUserService.getAll();
	}
}
