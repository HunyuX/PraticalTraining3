package com.example.server.bean;
/**
 *
 *
 * 用户类  对应前端的个人信息查询
 *
 *在查询个人信息时作为给前端的返回数据
 */
public class UserInfo {
    private String user_number;
    private String user_name;
    private String user_gender;
    private String user_age;


    public UserInfo(String user_number, String user_name, String user_gender, String user_age) {
        this.user_number = user_number;
        this.user_name = user_name;
        this.user_gender = user_gender;
        this.user_age = user_age;
    }

    public String getUser_number() {
        return user_number;
    }

    public void setUser_number(String user_number) {
        this.user_number = user_number;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_gender() {
        return user_gender;
    }

    public void setUser_gender(String user_gender) {
        this.user_gender = user_gender;
    }

    public String getUser_age() {
        return user_age;
    }

    public void setUser_age(String user_age) {
        this.user_age = user_age;
    }
}
