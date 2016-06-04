package com.noynoy.controller.admin.category;

import com.noynoy.domain.category.Category;
import com.noynoy.domain.category.CategoryForm;
import com.noynoy.service.category.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by noynoy on 2016. 1. 22..
 */
@RestController
@RequestMapping("/api/admin/categorys")
@Slf4j
public class RestAdminCategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Category> categorys() {
        return categoryService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Category saveCategory(@ModelAttribute CategoryForm categoryForm) {
        return categoryService.save(categoryForm);
    }

    @RequestMapping(value = "/delete")
    public int deleteCategory(@RequestParam(value = "id", required = true) int id) {
        return categoryService.delete(id);
    }

    @RequestMapping(value = "/edit")
    public Category editCategory(@ModelAttribute CategoryForm categoryForm) {
        return categoryService.edit(categoryForm);
    }

}
