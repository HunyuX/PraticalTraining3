package com.example.server.bean;

/**
 *
 *
 * 用户类  对应与数据库的用户表User
 *
 *
 */
public class User {
    private Integer user_number;
    private String user_name;
    private String user_password;
    private Integer user_gender;
    private String user_email;

    public User(Integer user_number, String user_name, String user_password, Integer user_gender, String user_email) {
        this.user_number = user_number;
        this.user_name = user_name;
        this.user_password = user_password;
        this.user_gender = user_gender;
        this.user_email = user_email;
    }

    public Integer getUser_number() {
        return user_number;
    }

    public void setUser_number(Integer user_number) {
        this.user_number = user_number;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public Integer getUser_gender() {
        return user_gender;
    }

    public void setUser_gender(Integer user_gender) {
        this.user_gender = user_gender;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }
}
