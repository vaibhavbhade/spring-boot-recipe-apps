package com.test.recipeapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.test.recipeapplication.model.RecipeDetails;
import com.test.recipeapplication.service.RecipeService;
import com.test.recipeapplication.serviceImpl.RecipeServiceImpl;

@RestController
public class RecipeController {
	
	
	@Autowired
	private RecipeService recipeService;
	

	@GetMapping("/dump")
	public String Dump() {

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<RecipeDetails>> recipeDetailsResponse = restTemplate.exchange(
				"https://s3-ap-southeast-1.amazonaws.com/he-public-data/reciped9d7b8c.json", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<RecipeDetails>>() {
				});
		List<RecipeDetails> recipeDetails = recipeDetailsResponse.getBody();

		System.out.println("size :: " + recipeDetails.size());
		recipeService.dumpData(recipeDetails);
		return "Data Dump!";
	}
	
	@GetMapping("/")
	public List<RecipeDetails> getRecipeDetails() {
		return recipeService.findAllRecipe();
	}
	
	@GetMapping("/id")
	public RecipeDetails getRecipeDetailsbyID(Long id) throws Exception {
		
		RecipeDetails recipeDetails = recipeService.findAllRecipeById(id);
		if(recipeDetails==null) {
			throw new Exception("Recipe not Exist!! ");
		}
		return recipeDetails;
	}
	
	@PostMapping("/")
	public RecipeDetails storeNewRecipe(@RequestBody RecipeDetails recipeDetails){
		
		return recipeService.saveRecipe(recipeDetails);
	}
	
	@GetMapping("/{id}/show")
	public String storeNewRecipe(@PathVariable Long id) throws Exception{
		
		RecipeDetails recipeDetails = recipeService.findAllRecipeById(id);
		if(recipeDetails==null) {
			throw new Exception("This id not Exist!! ");
		}
		return recipeDetails.getImage();
	}
	
	

}
