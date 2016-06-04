package com.noynoy.controller.admin;

import com.noynoy.domain.admin.Admin;
import com.noynoy.repository.menu.MenuRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

/**
 * Created by noynoy on 2016. 1. 22..
 */
@Controller
@RequestMapping("/admin/layout")
@SessionAttributes("adminSession")
@Slf4j
public class CommonAdminLayoutController {

    @Autowired
    private MenuRepository menuRepository;

    @ModelAttribute("adminSession")
    public Admin aSession(HttpSession session) {
        Admin admin = new Admin();
        try {
            admin.setAdminId(session.getAttribute("adminId").toString());
            admin.setName(session.getAttribute("name").toString());
        } catch(Exception e) {}
        return admin;
    }

    @RequestMapping("/global.include")
    public String includeGlobal() {
        return "admin/include/global.include";
    }

    @RequestMapping("/top.include")
    public String includeTop() {
        return "admin/include/top.include";
    }

    @RequestMapping("/sidebar.include")
    public String includeSidebar(Model model,
                                 @RequestParam(value = "selectedMenu", defaultValue = "1") int selectMenu) {
        model.addAttribute(selectMenu);
        model.addAttribute("sidebarMenus", menuRepository.findAll(new Sort(Sort.Direction.ASC, "sort")));
        return "admin/include/sidebar.include";
    }

    @RequestMapping("/footer.include")
    public String includeFooter() {
        return "admin/include/footer.include";
    }

}
