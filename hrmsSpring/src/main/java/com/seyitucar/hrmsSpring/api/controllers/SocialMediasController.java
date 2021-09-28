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

import com.seyitucar.hrmsSpring.business.abstracts.SocialMediaService;
import com.seyitucar.hrmsSpring.core.utilities.results.DataResult;
import com.seyitucar.hrmsSpring.core.utilities.results.Result;
import com.seyitucar.hrmsSpring.entities.concretes.SocialMedia;

@CrossOrigin
@RestController
@RequestMapping("/api/socialmedias")
public class SocialMediasController {
	
	private SocialMediaService socialMediaService;

	@Autowired
	public SocialMediasController(SocialMediaService socialMediaService) {
		super();
		this.socialMediaService = socialMediaService; 
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody SocialMedia socialMedia) {
		return this.socialMediaService.add(socialMedia);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody SocialMedia socialMedia) {
		return this.socialMediaService.update(socialMedia);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam int id) {
		return this.socialMediaService.delete(id);
	}
	
	@GetMapping("/getById")
	public DataResult<SocialMedia> getById(@RequestParam int id){
		return this.socialMediaService.getById(id);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<SocialMedia>> getAll(){
		return this.socialMediaService.getAll();
	}

}
