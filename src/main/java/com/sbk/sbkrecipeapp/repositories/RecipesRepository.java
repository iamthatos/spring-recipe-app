package com.sbk.sbkrecipeapp.repositories;

import com.sbk.sbkrecipeapp.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipesRepository extends CrudRepository<Recipe, Long> {
}
