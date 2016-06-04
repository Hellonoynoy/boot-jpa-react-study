package com.noynoy.service.login;

import com.noynoy.domain.admin.Admin;
import com.noynoy.repository.login.AdminLoginRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by noynoy on 2016. 6. 4..
 */
@Service
@Slf4j
public class AdminLoginService {

    @Autowired
    AdminLoginRepository adminLoginRepository;

    public Admin loginByAdmin(Admin admin) {

        Admin loginUser = adminLoginRepository.findByAdminIdAndPassword(admin.getAdminId(), admin.getPassword());

        if(loginUser != null) {
            loginUser.setLoginDate(new Date());
            adminLoginRepository.save(loginUser);
        }

        return loginUser;
    }
}
