package com.example.food.ui.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.food.R;

public class CommentActivity extends AppCompatActivity {

    private static final String SHARED_PREF_NAME = "MySharedPref";
    private static final String KEY_COMMENT = "comment";

    private SharedPreferences sharedPreferences;
    private TextView tvComments;
//    private TextView tvCommentHeader;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        // 初始化SharedPreferences
        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);

        // 初始化评论页面的控件
        initViews();


        // 获取评论内容并设置评论提示文本的显示状态
        String comment = getComment();
        tvComments.setText(comment);
        TextView tvCommentHeader = findViewById(R.id.tvCommentHeader);
        // 检查评论内容，如果有评论则隐藏提示文本
        if (!comment.isEmpty()) {
            tvCommentHeader.setVisibility(View.GONE);
        }

        // 设置发表评论按钮的点击事件
        Button btnSubmitComment = findViewById(R.id.btnSubmitComment);
        btnSubmitComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCommentDialog();
            }
        });
    }

    // 初始化评论页面的控件
    private void initViews() {
        tvComments = findViewById(R.id.tvComments);
    }

    // 显示评论对话框
    private void showCommentDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("发表评论");
        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);

        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String comment = input.getText().toString().trim();
                saveComment(comment);
                tvComments.setText(comment);
            }
        });

        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }

    // 保存评论内容到SharedPreferences
    private void saveComment(String comment) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_COMMENT, comment);
        editor.apply();
    }

    // 获取评论内容
    private String getComment() {
        return sharedPreferences.getString(KEY_COMMENT, "");
    }
}
