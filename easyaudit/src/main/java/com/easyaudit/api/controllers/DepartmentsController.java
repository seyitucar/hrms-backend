package com.easyaudit.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.easyaudit.business.abstracts.DepartmentService;
import com.easyaudit.core.utilities.results.DataResult;
import com.easyaudit.core.utilities.results.Result;
import com.easyaudit.entities.concretes.Department;

@CrossOrigin
@RestController
@RequestMapping("/api/departments")
public class DepartmentsController {
	
	private DepartmentService departmentService;

	@Autowired
	public DepartmentsController(DepartmentService departmentService) {
		super();
		this.departmentService = departmentService;
	}	

	@PostMapping("/add")
	public Result add(@RequestBody Department department) {
		return this.departmentService.add(department);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody Department department) {
		return this.departmentService.update(department);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam int id) {
		return this.departmentService.delete(id);
	}
	
	@GetMapping("/getById")
	public DataResult<Department> getById(@RequestParam int id) {
		return this.departmentService.getById(id);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Department>> getAll() {
		return this.departmentService.getAll();
	}

}
