package com.noynoy.aop;

import com.noynoy.model.account.Level;
import com.noynoy.model.account.Login;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
public class AdministratorInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();
        if(session.getAttribute("login") != null) {

            Login loginData = (Login)session.getAttribute("login");

            if(loginData.getLevel().equals(Level.ADMIN) || loginData.getLevel().equals(Level.SUPERADMIN)) {
                return true;
            } else {
                log.info("level ==> {}", loginData.getLevel());
                log.info("no permission");
                response.sendRedirect("/admin/login");
                return false;
            }

        } else {
            log.info("no permission");
            response.sendRedirect("/admin/login");
            return false;
        }

    }

}
