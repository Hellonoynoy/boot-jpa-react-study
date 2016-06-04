package com.noynoy.repository.login;

import com.noynoy.domain.admin.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by noynoy on 2016. 1. 20..
 */
public interface AdminLoginRepository extends JpaRepository<Admin, Integer> {

    
    Admin findByAdminIdAndPassword(@Param("adminId") String id,
                                   @Param("password") String password);

}
