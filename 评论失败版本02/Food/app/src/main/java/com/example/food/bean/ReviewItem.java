package com.example.food.bean;

public class ReviewItem {
    private String userName;
    private String review;
    private String date; // 添加日期字段

    public ReviewItem(String userName, String review, String date) {
        this.userName = userName;
        this.review = review;
        this.date = date;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
