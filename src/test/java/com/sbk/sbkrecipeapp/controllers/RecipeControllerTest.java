package com.sbk.sbkrecipeapp.controllers;

import com.sbk.sbkrecipeapp.domain.Recipe;
import com.sbk.sbkrecipeapp.services.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class RecipeControllerTest {
    
    @Mock
    RecipeService recipeService;
    
    @InjectMocks
    RecipeController controller;
    
    MockMvc mockMvc;
    
    Recipe recipe;
    
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        
        recipe = new Recipe();
        recipe.setId(1L);
    }

    @Test
    public void showById() throws Exception {
        
        when(recipeService.findById(anyLong())).thenReturn(recipe);
        
        mockMvc.perform(get("/recipe/show/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/show"));
    }

}