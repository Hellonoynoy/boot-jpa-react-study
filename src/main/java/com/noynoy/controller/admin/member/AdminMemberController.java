package com.noynoy.controller.admin.member;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by noynoy on 2016. 1. 22..
 */
@Controller
@Slf4j
@RequestMapping("/admin/members")
public class AdminMemberController {

    @RequestMapping(method = RequestMethod.GET)
    public String getMembers() {
        return "admin/member/members";
    }

}
