package com.noynoy.config;

import com.noynoy.aop.AdministratorInterceptor;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by noynoy on 2016. 6. 4..
 */
@Configuration
public class AppConfig extends WebMvcConfigurerAdapter implements EmbeddedServletContainerCustomizer {


    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        container.addErrorPages(new ErrorPage(HttpStatus.BAD_REQUEST, "/error/400"));
        container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/error/404"));
        container.addErrorPages(new ErrorPage(HttpStatus.CONFLICT, "/error/500"));
    }

    /**
     * aop
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AdministratorInterceptor())
                .addPathPatterns("/admin/**")
                .excludePathPatterns("/admin/login")
                .excludePathPatterns("/admin/**/*.include");
    }

}
