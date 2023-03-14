package com.example.android_solar_term.common;

public enum Code {

    SUCCESS(0,"success",""),
    PARAMS_ERROR(40000,"请求参数错误","账号或密码错误"),
    NULL_ERROR(40001,"请求数据为空","数据为空"),
    NOT_LOGIN(40100,"未登录","账号尚未登录"),
    NO_AUTH(40101,"无权限","用户权限不够"),

    SYSTEM_ERROR(50000,"系统内部异常","内部异常");

    private final int code;
    private final String message;
    private final String description;

    Code(int code, String message, String description) {
        this.code = code;
        this.message = message;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }
}
