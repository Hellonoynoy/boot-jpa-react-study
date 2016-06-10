package com.noynoy.config;

import com.noynoy.aop.AdministratorInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by noynoy on 2016. 6. 4..
 */
@Configuration
public class AppConfig extends WebMvcConfigurerAdapter {

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
