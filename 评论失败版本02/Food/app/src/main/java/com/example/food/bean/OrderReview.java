package com.example.food.bean;

public class OrderReview {
    private String userName;
    private String comment;
    private int rating;
    private String date;
    private String orderTitle;
    private String title;

    public OrderReview(String userName, String comment, int rating, String date) {
        this.userName = userName;
        this.comment = comment;
        this.rating = rating;
        this.date = date;
        this.orderTitle = title;
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
    public String getOrderTitle() {
        // 在这里编写方法的具体逻辑
        return orderTitle; // 假设订单标题存储在一个名为 orderTitle 的变量中
    }

    public OrderReview(String title) {
        this.title = title; // 在构造函数中初始化 'title'
    }

    public String getTitle() {
        return this.title; // 返回 'title' 的值
    }


    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
