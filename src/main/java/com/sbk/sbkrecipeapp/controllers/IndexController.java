package com.sbk.sbkrecipeapp.controllers;

import com.sbk.sbkrecipeapp.domain.Category;
import com.sbk.sbkrecipeapp.domain.UnitOfMeasure;
import com.sbk.sbkrecipeapp.repositories.CategoryRepository;
import com.sbk.sbkrecipeapp.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {
    
    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"", "/index", "/index.html"})
    private String getIndexPage() {
        
        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

        System.out.println("Cat id is: "+ categoryOptional.get().getId());
        System.out.println("Uom id is: "+ unitOfMeasureOptional.get().getId());
        return "index";
    }
}
