package com.noynoy.controller.admin.login;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by noynoy on 2016. 1. 20..
 */
@Controller
@Slf4j
public class AdminLoginController {

    @RequestMapping(value = "/admin/login", method = RequestMethod.GET)
    public String loginForm() {
        return "admin/login/login";
    }



}
