package com.test.recipeapplication;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.recipeapplication.model.RecipeDetails;

public interface RecipeRepo extends JpaRepository<RecipeDetails, Long>{

}
