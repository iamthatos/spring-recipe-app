package com.sbk.sbkrecipeapp.services;

import com.sbk.sbkrecipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    
    Set<Recipe> findAll();

    Set<Recipe> getRecipes();
    
    Recipe findById (Long id);
}
