package com.epul.androidcinema.domain;

import java.io.Serializable;

public class LoginParam implements Serializable {
    private String username;
    private String password;

    public LoginParam(String username, String pwd) {
        this.username = username;
        this.password = pwd;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}