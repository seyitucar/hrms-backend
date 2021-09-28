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

import com.easyaudit.business.abstracts.SupplierService;
import com.easyaudit.core.utilities.results.DataResult;
import com.easyaudit.core.utilities.results.Result;
import com.easyaudit.entities.concretes.Supplier;

@CrossOrigin
@RestController
@RequestMapping("/api/suppliers")
public class SuppliersController {
	
	private SupplierService supplierService;

	@Autowired
	public SuppliersController(SupplierService supplierService) {
		super();
		this.supplierService = supplierService;
	}
	

	@PostMapping("/add")
	public Result add(@RequestBody Supplier supplier) {
		return this.supplierService.add(supplier);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody Supplier supplier) {
		return this.supplierService.update(supplier);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam int id) {
		return this.supplierService.delete(id);
	}
	
	@GetMapping("/getById")
	public DataResult<Supplier> getById(@RequestParam int id) {
		return this.supplierService.getById(id);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Supplier>> getAll() {
		return this.supplierService.getAll();
	}

}
