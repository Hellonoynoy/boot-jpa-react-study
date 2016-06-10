package com.noynoy.controller.admin.login;

import com.noynoy.domain.admin.Admin;
import com.noynoy.service.login.AdminLoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by noynoy on 2016. 1. 20..
 */
@RestController
@RequestMapping("/api/login")
@Slf4j
public class RestAdminLoginController {

    @Autowired
    private AdminLoginService adminLoginService;

    @RequestMapping
    public String loginProcess(@ModelAttribute Admin loginUser, HttpServletRequest request) {

        String returnString = "none";
        Admin admin = adminLoginService.loginByAdmin(loginUser);

        if(admin != null) {
            HttpSession session = request.getSession();
            session.setAttribute("adminId", admin.getAdminId());
            session.setAttribute("name",    admin.getName());
            returnString = "/admin/members";
        }

        return returnString;
    }

}
