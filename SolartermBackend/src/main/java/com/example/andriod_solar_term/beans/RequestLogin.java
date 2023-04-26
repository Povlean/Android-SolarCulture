package com.example.andriod_solar_term.beans;

import lombok.Data;

/**
 * @description:TODO
 * @author:Povlean
 */
@Data
public class RequestLogin {
    private String username;
    private String password;

    public RequestLogin() {
    }

    public RequestLogin(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
