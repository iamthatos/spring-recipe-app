package com.sbk.sbkrecipeapp.repositories;

import com.sbk.sbkrecipeapp.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RecipesRepository extends CrudRepository<Recipe, Long> {

    Optional<Recipe> findByDescription (String description);
}
