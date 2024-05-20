package com.example.food.ui.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.food.R;

public class CommentActivity extends AppCompatActivity {
    private static final String TAG = "CommentActivity"; // 日志标识
    private EditText etComment;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        Log.d(TAG, "onCreate: Activity started"); // 添加日志输出

        // 初始化界面控件
        etComment = findViewById(R.id.et_comment);
        btnSubmit = findViewById(R.id.btn_submit);

        // 获取传递的订单信息
        String orderId = getIntent().getStringExtra("orderId");
        Log.d(TAG, "onCreate: orderId = " + orderId); // 添加日志输出

        // 添加提交评论按钮点击事件
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 获取用户输入的评论内容
                String comment = etComment.getText().toString();
                Log.d(TAG, "Submit button clicked, comment: " + comment); // 添加日志输出

                if (!comment.isEmpty()) {
                    // 保存评论信息到数据库，并关联到对应的订单
                    saveCommentToDatabase(orderId, comment);

                    // 提示评论提交成功
                    Toast.makeText(CommentActivity.this, "评价成功", Toast.LENGTH_SHORT).show();
                    finish(); // 关闭评论页面
                } else {
                    Toast.makeText(CommentActivity.this, "评论不能为空", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // 将评论信息保存到数据库的方法
    private void saveCommentToDatabase(String orderId, String comment) {
        // 在此处编写保存评论信息到数据库的逻辑
        // 可以创建 Comment 数据模型类，保存评论内容和订单关联信息
        // 这里仅作示例，实际项目中需根据数据库操作方式进行保存
    }
}
