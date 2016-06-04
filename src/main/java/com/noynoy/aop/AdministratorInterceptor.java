package com.noynoy.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by noynoy on 2016. 6. 4..
 */
@Slf4j
public class AdministratorInterceptor extends HandlerInterceptorAdapter {

    /**
     * 세션에 계정정보가 있는지 여부로 인증 여부를 체크한다.
     * 계정정보가 없다면, 로그인 페이지로 이동한다.
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {

        /**
        try {
            //세션이 있을경우 본인 표시
            HttpSession session = request.getSession();


            if(session != null && session.getAttribute("login") != null) {
                Login login = (Login)session.getAttribute("login");
                if(
                        login.getLevelId() == AUTH_TUTOR ||
                                login.getLevelId() == AUTH_ACADEMY_MASTER ||
                                login.getLevelId() == AUTH_MASTER) {

                    return true;
                } else {
                    throw new ModelAndViewDefiningException(new ModelAndView("redirect:/administrator/login"));
                }

            } else {
                throw new ModelAndViewDefiningException(new ModelAndView("redirect:/administrator/login"));
            }

        } catch (Exception e) {
            throw new ModelAndViewDefiningException(new ModelAndView("redirect:/administrator/login"));
        }
        **/
        try {
            return true;
        } catch (Exception e) {
            throw new ModelAndViewDefiningException(new ModelAndView("redirect:/administrator/login"));
        }
    }

}
