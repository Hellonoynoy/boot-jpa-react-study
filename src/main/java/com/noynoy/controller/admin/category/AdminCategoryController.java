package com.noynoy.controller.admin.category;

import com.noynoy.domain.admin.Admin;
import com.noynoy.service.category.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

/**
 * Created by noynoy on 2016. 1. 22..
 */
@Controller
@RequestMapping("/admin/categorys")
@SessionAttributes("aSession")
@Slf4j
public class AdminCategoryController {

    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("aSession")
    public Admin aSession(HttpSession session) {
        Admin admin = new Admin();
        try {
            admin.setAdminId(session.getAttribute("adminId").toString());
            admin.setName(session.getAttribute("name").toString());
        } catch(Exception e) {}
        return admin;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String categorys(Model model) {
        model.addAttribute("categorys", categoryService.findAll());
        return "admin/category/categorys";
    }

}
