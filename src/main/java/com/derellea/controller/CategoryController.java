package com.derellea.controller;

import com.derellea.domain.Category;
import com.derellea.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @RequestMapping("/list")
    @ResponseBody
    public List<Category> list(){
        return categoryService.findAll();
    }
}
