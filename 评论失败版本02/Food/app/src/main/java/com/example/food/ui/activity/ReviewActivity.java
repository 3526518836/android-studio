package com.example.food.ui.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.food.R;
import com.example.food.adapter.ReviewAdapter;
import com.example.food.bean.OrderReview;
import com.example.food.util.SPUtils;

import java.util.ArrayList;
import java.util.List;

public class ReviewActivity extends AppCompatActivity {
    private LinearLayout layoutOrders;
    private TextView textViewNoReview;
    private TextView textViewReviews;
    private ListView listViewReviews;
    private ReviewAdapter adapter;
    private String account;
    private List<OrderReview> orderReviews;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        // 初始化界面
        layoutOrders = findViewById(R.id.layoutOrders);
        textViewNoReview = findViewById(R.id.textViewNoReview);
        textViewReviews = findViewById(R.id.textViewReviews);
        listViewReviews = findViewById(R.id.listViewReviews);
        account = (String) SPUtils.get(this, SPUtils.ACCOUNT, "");

        // 检查是否有评论
        orderReviews = getSampleOrderReviews();
        if (orderReviews != null && !orderReviews.isEmpty()) {
            // 显示评论列表
            textViewNoReview.setVisibility(View.GONE);
            layoutOrders.setVisibility(View.VISIBLE);
            displayReviews();
        } else {
            // 如果没有评论，则显示提示信息
            textViewNoReview.setVisibility(View.VISIBLE);
            textViewReviews.setText("无评论");
            layoutOrders.setVisibility(View.GONE);
            Toast.makeText(this, "无评论", Toast.LENGTH_SHORT).show();
        }
    }

    private void displayReviews() {
        ArrayList<OrderReview> reviewList = new ArrayList<>(orderReviews);
        adapter = new ReviewAdapter(this, reviewList);
        listViewReviews.setAdapter(adapter);
        listViewReviews.setVisibility(View.VISIBLE);

        for (OrderReview review : orderReviews) {
            View orderView = getLayoutInflater().inflate(R.layout.item_review, null);
            TextView orderTitle = orderView.findViewById(R.id.textViewOrderTitle);
            TextView orderComment = orderView.findViewById(R.id.textViewReview);

            orderTitle.setText(review.getOrderTitle());
            orderComment.setText(review.getComment());

            layoutOrders.addView(orderView);
        }
    }

    // 模拟获取订单评论数据的方法
    private List<OrderReview> getSampleOrderReviews() {
        List<OrderReview> reviews = new ArrayList<>();
        // 添加模拟数据，实际情况下需要从数据库或网络获取订单评论数据
        reviews.add(new OrderReview("Order 001", "shajshdakjsd", 5, "2024-05-18"));
        reviews.add(new OrderReview("Order 002", "Great service and tasty dishes!", 4, "2024-05-17"));

        // 添加更多的订单评论数据...

        return reviews;
    }
}
