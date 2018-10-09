package com.sbk.sbkrecipeapp.services;

import com.sbk.sbkrecipeapp.domain.Recipe;
import com.sbk.sbkrecipeapp.repositories.RecipesRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class RecipeServiceImpl implements RecipeService {
    
    private RecipesRepository recipesRepository;

    public RecipeServiceImpl(RecipesRepository recipesRepository) {
        this.recipesRepository = recipesRepository;
    }

    @Override
    public Set<Recipe> findAll() {
        Set<Recipe> recipes = new HashSet<>();
        recipesRepository.findAll().iterator().forEachRemaining(recipes :: add);       
        return recipes;
    }

    @Override
    public Recipe findById(Long id) {
        Optional<Recipe> recipeOptional = recipesRepository.findById(id);
        return recipeOptional.get();
    }
}
