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

import com.easyaudit.business.abstracts.AuditTypeService;
import com.easyaudit.core.utilities.results.DataResult;
import com.easyaudit.core.utilities.results.Result;
import com.easyaudit.entities.concretes.AuditType;

@CrossOrigin
@RestController
@RequestMapping("/api/auditTypes")
public class AuditTypesController {
	
	private AuditTypeService auditTypeService;

	@Autowired
	public AuditTypesController(AuditTypeService auditTypeService) {
		super();
		this.auditTypeService = auditTypeService;
	}	

	@PostMapping("/add")
	public Result add(@RequestBody AuditType auditType) {
		return this.auditTypeService.add(auditType);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody AuditType auditType) {
		return this.auditTypeService.update(auditType);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam int id) {
		return this.auditTypeService.delete(id);
	}
	
	@GetMapping("/getById")
	public DataResult<AuditType> getById(@RequestParam int id) {
		return this.auditTypeService.getById(id);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<AuditType>> getAll() {
		return this.auditTypeService.getAll();
	}

}
