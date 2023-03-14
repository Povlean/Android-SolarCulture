package com.example.bigjobapplication.bean;
import java.io.Serializable;

/**
 * 
 * @TableName tbl_user
 */

public class User implements Serializable {

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", bronSeason='" + bronSeason + '\'' +
                ", age=" + age +
                ", foodFavor='" + foodFavor + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getBronSeason() {
        return bronSeason;
    }

    public void setBronSeason(String bronSeason) {
        this.bronSeason = bronSeason;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getFoodFavor() {
        return foodFavor;
    }

    public void setFoodFavor(String foodFavor) {
        this.foodFavor = foodFavor;
    }

    public User(Integer id, String username, String password, String bronSeason, Integer age, String foodFavor) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.bronSeason = bronSeason;
        this.age = age;
        this.foodFavor = foodFavor;
    }

    /**
     * 
     */

    private Integer id;

    /**
     * 用户名
     */

    private String username;

    /**
     * 密码
     */

    private String password;

    /**
     * 出生季节
     */

    private String bronSeason;

    /**
     * 年龄
     */

    private Integer age;

    /**
     * 喜欢的食物
     */

    private String foodFavor;


    private static final long serialVersionUID = 1L;

}