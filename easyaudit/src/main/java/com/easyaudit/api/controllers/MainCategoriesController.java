package com.easyaudit.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.easyaudit.business.abstracts.MainCategoryService;
import com.easyaudit.core.utilities.results.DataResult;
import com.easyaudit.core.utilities.results.ErrorDataResult;
import com.easyaudit.core.utilities.results.Result;
import com.easyaudit.entities.concretes.MainCategory;

@CrossOrigin
@RestController
@RequestMapping("/api/mainCategories")
public class MainCategoriesController {
	
	private MainCategoryService mainCategoryService;

	@Autowired
	public MainCategoriesController(MainCategoryService mainCategoryService) {
		super();
		this.mainCategoryService = mainCategoryService;
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody MainCategory mainCategory) {
		return ResponseEntity.ok(this.mainCategoryService.add(mainCategory));
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody MainCategory mainCategory) {
		return this.mainCategoryService.update(mainCategory);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam int id) {
		return this.mainCategoryService.delete(id);
	}
	
	@GetMapping("/getById")
	public DataResult<MainCategory> getById(@RequestParam int id) {
		return this.mainCategoryService.getById(id);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<MainCategory>> getAll() {
		return this.mainCategoryService.getAll();
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
		Map<String, String> validationErrors = new HashMap<String, String>();
		for(FieldError fieldError :	exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}		
		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors,"Doğrulama Hatası");
		return errors;
	}
}
