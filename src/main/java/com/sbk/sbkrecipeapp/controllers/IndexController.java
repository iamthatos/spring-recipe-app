package com.sbk.sbkrecipeapp.controllers;

import com.sbk.sbkrecipeapp.domain.Category;
import com.sbk.sbkrecipeapp.domain.UnitOfMeasure;
import com.sbk.sbkrecipeapp.repositories.CategoryRepository;
import com.sbk.sbkrecipeapp.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Slf4j
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
        log.debug("Getting index page");
        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

        System.out.println("Cat id is: "+ categoryOptional.get().getId());
        System.out.println("Uom id is: "+ unitOfMeasureOptional.get().getId());
        return "index";
    }
}
