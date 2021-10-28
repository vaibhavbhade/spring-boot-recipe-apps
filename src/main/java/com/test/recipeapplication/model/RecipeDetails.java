package com.test.recipeapplication.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RecipeDetails {

	@Id
private Long id;

private String name;

private String image;

private String category;

private String label;

private Double price; 

private String description ;


public RecipeDetails() {
	super();
	// TODO Auto-generated constructor stub
}



public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getImage() {
	return image;
}

public void setImage(String image) {
	this.image = image;
}

public String getCategory() {
	return category;
}

public void setCategory(String category) {
	this.category = category;
}

public String getLabel() {
	return label;
}

public void setLabel(String label) {
	this.label = label;
}

public Double getPrice() {
	return price;
}

public void setPrice(Double price) {
	this.price = price;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}





	
	
}
