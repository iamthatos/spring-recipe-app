package com.sbk.sbkrecipeapp.services;


import com.sbk.sbkrecipeapp.domain.Recipe;
import com.sbk.sbkrecipeapp.repositories.RecipesRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class RecipeServiceImplTest {
    
    RecipeServiceImpl recipeService;
    
    @Mock
    RecipesRepository recipesRepository;
    
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        
        recipeService = new RecipeServiceImpl(recipesRepository);
    }

    @Test
    public void getRecipes() throws Exception {
        Recipe recipe = new Recipe();
        HashSet recipeHashSet = new HashSet();
        recipeHashSet.add(recipe);
        
        when(recipeService.getRecipes()).thenReturn(recipeHashSet);
        
        Set<Recipe> recipes = recipeService.getRecipes();
        
        assertEquals(1, recipes.size());
        verify(recipesRepository, times(1)).findAll();
    }

}