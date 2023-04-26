package com.example.andriod_solar_term.beans;

import lombok.Data;

import java.util.Objects;

/**
 * @description:TODO
 * @author:Povlean
 */
@Data
public class RequestRegister {
    private String username;
    private String password;
    private String checkPassword;

    public RequestRegister() {
    }

    public RequestRegister(String username, String password, String checkPassword) {
        this.username = username;
        this.password = password;
        this.checkPassword = checkPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestRegister that = (RequestRegister) o;
        return Objects.equals(username, that.username) && Objects.equals(password, that.password) && Objects.equals(checkPassword, that.checkPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, checkPassword);
    }
}
