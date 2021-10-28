package com.test.recipeapplication.service;

import java.util.List;

import com.test.recipeapplication.model.RecipeDetails;

public interface RecipeService {

	void dumpData(List<RecipeDetails> recipeDetails);
	
	List<RecipeDetails> findAllRecipe();

	RecipeDetails findAllRecipeById(Long id);

	RecipeDetails saveRecipe(RecipeDetails recipeDetails);
}
