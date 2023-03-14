package com.example.android_solar_term.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.example.android_solar_term.beans.RequestLogin;
import com.example.android_solar_term.beans.RequestRegister;
import com.example.android_solar_term.beans.User;
import com.example.android_solar_term.mapper.UserMapper;
import com.example.android_solar_term.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
* @author Asphyxia
* @description 针对表【tbl_user】的数据库操作Service实现
* @createDate 2022-12-23 22:41:26
*/

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User searchByUsername(String username) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername,username);
        User user = this.getOne(queryWrapper);
        user.setPassword(null);
        return user;
    }

    @Override
    public void updateByUsername(User user) {
        this.updateById(user);
    }

    @Override
    public User userLogin(RequestLogin requestLogin) {
        String password = requestLogin.getPassword();
        String username = requestLogin.getUsername();
        if (password == null || username == null){
            return null;
        }
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername,username).eq(User::getPassword,password);
        User loginUser = this.getOne(queryWrapper);
        // e10adc3949ba59abbe56e057f20f883 ..e
        if (loginUser == null){
            return null;
        }
        loginUser.setPassword(null);
        return loginUser;
    }

    @Override
    public Integer userRegister(RequestRegister requestRegister) {
        String password = requestRegister.getPassword();
        String checkPassword = requestRegister.getCheckPassword();
        String username = requestRegister.getUsername();
        if (password == null || checkPassword == null || username == null){
            return -1;
        }
        if (!password.equals(checkPassword)){
            return -1;
        }
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername,username);
        User user = this.getOne(queryWrapper);
        if (user != null){
            System.out.println("注册的账号名重复");
            return -2;
        }
        User regUser = new User();
        regUser.setUsername(username);
        regUser.setPassword(password);
        this.save(regUser);
        return 1;
    }

    @Override
    public Integer userLoginOut(HttpServletRequest request) {
        if (request.getSession().getAttribute("loginState") == null){
            return -1;
        }
        request.getSession().removeAttribute("loginState");
        return 1;
    }

}




