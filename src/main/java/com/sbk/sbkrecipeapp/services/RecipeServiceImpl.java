package com.sbk.sbkrecipeapp.services;

import com.sbk.sbkrecipeapp.domain.Recipe;
import com.sbk.sbkrecipeapp.repositories.RecipesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {
    
    private RecipesRepository recipesRepository;

    public RecipeServiceImpl(RecipesRepository recipesRepository) {
        this.recipesRepository = recipesRepository;
    }

    @Override
    public Set<Recipe> findAll() {
        log.debug("Inside find all");
        Set<Recipe> recipes = new HashSet<>();
        recipesRepository.findAll().iterator().forEachRemaining(recipes :: add);       
        return recipes;
    }

    @Override
    public Set<Recipe> getRecipes() {
        log.debug("Inside find all");
        
        Set<Recipe> recipes = new HashSet<>();
        recipesRepository.findAll().iterator().forEachRemaining(recipes :: add);
        return recipes;
    }

    @Override
    public Recipe findById(Long id) {
        log.debug("Inside find One by id");
        Optional<Recipe> recipeOptional = recipesRepository.findById(id);
        
        if (!recipeOptional.isPresent()) {
            throw new RuntimeException("Null recipe returned");
        }
        return recipeOptional.get();
    }
}
