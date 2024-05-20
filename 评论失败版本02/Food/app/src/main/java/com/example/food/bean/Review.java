package com.example.food.bean;

public class Review {
    private String userName;
    private String comment;
    private String date;

    public Review(String userName, String comment, String date) {
        this.userName = userName;
        this.comment = comment;
        this.date = date;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}