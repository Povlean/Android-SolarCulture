package com.example.andriod_solar_term.beans;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName tbl_user
 */
@TableName(value ="tbl_user")
@Data
public class User implements Serializable {
    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名
     */
    @TableField(value = "username")
    private String username;

    /**
     * 密码
     */
    @TableField(value = "password")
    private String password;

    /**
     * 出生季节
     */
    @TableField(value = "born_season")
    private String bronSeason;

    /**
     * 年龄
     */
    @TableField(value = "age")
    private Integer age;

    /**
     * 喜欢的食物
     */
    @TableField(value = "food_favor")
    private String foodFavor;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}