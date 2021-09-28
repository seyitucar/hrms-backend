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

import com.easyaudit.business.abstracts.AuditService;
import com.easyaudit.core.utilities.results.DataResult;
import com.easyaudit.core.utilities.results.Result;
import com.easyaudit.entities.concretes.Audit;

@CrossOrigin
@RestController
@RequestMapping("/api/audits")
public class AuditsController {
	
	private AuditService auditService;

	@Autowired
	public AuditsController(AuditService auditService) {
		super();
		this.auditService = auditService;
	}
	

	@PostMapping("/add")
	public Result add(@RequestBody Audit audit) {
		return this.auditService.add(audit);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody Audit audit) {
		return this.auditService.update(audit);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam int id) {
		return this.auditService.delete(id);
	}
	
	@GetMapping("/getById")
	public DataResult<Audit> getById(@RequestParam int id) {
		return this.auditService.getById(id);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Audit>> getAll() {
		return this.auditService.getAll();
	}

}
