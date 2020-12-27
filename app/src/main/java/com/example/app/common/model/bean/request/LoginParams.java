package com.example.app.common.model.bean.request;

public class LoginParams {

    private String username;

    private String phone_code;

    private String login_pass;

    public LoginParams(String phone_code, String username, String login_pass) {
        this.username = username;
        this.login_pass = login_pass;
        this.phone_code = phone_code;
    }


}
