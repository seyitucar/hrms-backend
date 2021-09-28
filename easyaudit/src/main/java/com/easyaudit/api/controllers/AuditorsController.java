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

import com.easyaudit.business.abstracts.AuditorService;
import com.easyaudit.core.utilities.results.DataResult;
import com.easyaudit.core.utilities.results.Result;
import com.easyaudit.entities.concretes.Auditor;

@CrossOrigin
@RestController
@RequestMapping("/api/auditors")
public class AuditorsController {
	
	private AuditorService auditorService;

	@Autowired
	public AuditorsController(AuditorService auditorService) {
		super();
		this.auditorService = auditorService;
	}
	

	@PostMapping("/add")
	public Result add(@RequestBody Auditor auditor) {
		return this.auditorService.add(auditor);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody Auditor auditor) {
		return this.auditorService.update(auditor);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam int id) {
		return this.auditorService.delete(id);
	}
	
	@GetMapping("/getById")
	public DataResult<Auditor> getById(@RequestParam int id) {
		return this.auditorService.getById(id);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Auditor>> getAll() {
		return this.auditorService.getAll();
	}

}
