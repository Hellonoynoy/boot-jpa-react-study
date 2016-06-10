package com.noynoy.model.account;

import lombok.Data;

/**
 * Created by noynoy on 2016. 6. 5..
 */
@Data
public class Login {

    private String userId;
    private String nickname;
    private String email;
    private String password;

    private Level level;

}
