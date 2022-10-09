package com.example.server.bean;

public class Message {

    public Integer id;
    public Integer exhibit_number;
    public String user_name;
    public String date;
    public String content;

    public Message(Integer id, Integer exhibit_number, String user_name, String date, String content) {
        this.id = id;
        this.exhibit_number = exhibit_number;
        this.user_name = user_name;
        this.date = date;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getExhibit_number() {
        return exhibit_number;
    }

    public void setExhibit_number(Integer exhibit_number) {
        this.exhibit_number = exhibit_number;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
