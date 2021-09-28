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

import com.easyaudit.business.abstracts.SubCategoryService;
import com.easyaudit.core.utilities.results.DataResult;
import com.easyaudit.core.utilities.results.Result;
import com.easyaudit.entities.concretes.SubCategory;

@CrossOrigin
@RestController
@RequestMapping("/api/subCategories")
public class SubCategoriesController {
	
	private SubCategoryService subCategoryService;

	@Autowired
	public SubCategoriesController(SubCategoryService subCategoryService) {
		super();
		this.subCategoryService = subCategoryService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody SubCategory subCategory) {
		return this.subCategoryService.add(subCategory);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody SubCategory subCategory) {
		return this.subCategoryService.update(subCategory);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam int id) {
		return this.subCategoryService.delete(id);
	}
	
	@GetMapping("/getById")
	public DataResult<SubCategory> getById(@RequestParam int id) {
		return this.subCategoryService.getById(id);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<SubCategory>> getAll() {
		return this.subCategoryService.getAll();
	}
}