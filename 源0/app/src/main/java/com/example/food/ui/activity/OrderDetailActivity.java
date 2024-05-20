package com.example.food.ui.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.food.R;
import com.example.food.bean.Orders;

public class OrderDetailActivity extends AppCompatActivity {
    private static final String TAG = "OrderDetailActivity"; // 日志标识
    private TextView tvOrderTitle;
    private TextView tvOrderDescription;
    private Button btnComment;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit_detail); // 使用 activity_fruit_detail.xml 作为布局文件
        Log.d(TAG, "onCreate: Activity started"); // 添加日志输出

        // 初始化界面控件
        tvOrderTitle = findViewById(R.id.title);
        tvOrderDescription = findViewById(R.id.content);
        btnComment = findViewById(R.id.btn_comment);

        // 获取订单信息，这里假设 orderId 是订单的唯一标识符
        String orderId = getIntent().getStringExtra("orderId");
        Log.d(TAG, "onCreate: orderId = " + orderId); // 添加日志输出
        Orders order = getOrderFromDatabase(orderId);

        // 显示订单信息
        if (order != null) {
            tvOrderTitle.setText(order.getTitle());
            tvOrderDescription.setText(order.getDescription());
        }

        // 添加评论按钮点击事件
        btnComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Comment button clicked"); // 添加日志输出
                // 跳转到评论页面，并传递订单信息给评论页面
                Intent intent = new Intent(OrderDetailActivity.this, CommentActivity.class);
                intent.putExtra("orderId", orderId);
                startActivity(intent);
            }
        });
    }

    // 从数据库获取订单信息的方法
    private Orders getOrderFromDatabase(String orderId) {
        // 从数据库或者其他数据源中获取订单信息
        // 这里仅作示例，实际项目中需根据数据库操作方式进行查询
        // 假设 Orders 类是订单数据模型
        return new Orders("Order Title", "Order Description", orderId);
    }
}
