package com.test.recipeapplication.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.recipeapplication.RecipeRepo;
import com.test.recipeapplication.model.RecipeDetails;
import com.test.recipeapplication.service.RecipeService;

@Service
public class RecipeServiceImpl implements RecipeService{
	
	@Autowired
	private RecipeRepo recipeRepo;

	@Override
	public void dumpData(List<RecipeDetails> recipeDetails) {
		
		for (RecipeDetails newRecipeDetails : recipeDetails) {
			System.out.println(newRecipeDetails.getId());
			recipeRepo.save(newRecipeDetails);
		}
	}

	@Override
	public List<RecipeDetails> findAllRecipe() {
		// TODO Auto-generated method stub
		return recipeRepo.findAll();
	}

	@Override
	public RecipeDetails findAllRecipeById(Long id) {
		// TODO Auto-generated method stub
		 return recipeRepo.findById(id).orElse(null);
	}

	@Override
	public RecipeDetails saveRecipe(RecipeDetails recipeDetails) {
		// TODO Auto-generated method stub
		return  recipeRepo.save(recipeDetails);
	}

}
