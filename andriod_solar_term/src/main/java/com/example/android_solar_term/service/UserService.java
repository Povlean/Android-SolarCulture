package com.example.android_solar_term.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.android_solar_term.beans.RequestLogin;
import com.example.android_solar_term.beans.RequestRegister;
import com.example.android_solar_term.beans.User;

import javax.servlet.http.HttpServletRequest;


/**
* @author Asphyxia
* @description 针对表【tbl_user】的数据库操作Service
* @createDate 2022-12-23 22:41:26
*/
public interface UserService extends IService<User> {
    User searchByUsername(String username);

    void updateByUsername(User user);

    User userLogin(RequestLogin requestLogin);

    Integer userRegister(RequestRegister requestRegister);

    Integer userLoginOut(HttpServletRequest request);
}
