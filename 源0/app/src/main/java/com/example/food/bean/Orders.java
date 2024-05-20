package com.example.food.bean;

import org.litepal.crud.DataSupport;

import java.io.Serializable;

public class Orders extends DataSupport implements Serializable {
    private String account;//账号
    private String title;//标题
    private String number;//编号
    private String amount;//数量
    private String date;//时间
    private String description;
    private String orderId;

    private String orderComment; // 新添加的订单评论字段

    public Orders(String order_title, String order_description, String orderId) {
        this.orderId = orderId;
        this.title = title;
        this.description = description;
        this.orderComment = ""; // 初始化评论为空
    }


    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOrderComment() {
        return orderComment;
    }

    public void setOrderComment(String orderComment) {
        this.orderComment = orderComment;
    }

    public Orders(String account, String orderTitle, String number, String amount, String date) {
        this.account = account;
        this.title = orderTitle;
        this.number = number;
        this.amount = amount;
        this.date = date;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
