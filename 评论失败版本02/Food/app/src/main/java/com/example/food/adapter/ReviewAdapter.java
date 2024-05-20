package com.example.food.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.food.R;
import com.example.food.bean.OrderReview;

import java.util.ArrayList;

public class ReviewAdapter extends ArrayAdapter<OrderReview> {
    private Context mContext;
    private ArrayList<OrderReview> mReviewList;

    public ReviewAdapter(Context context, ArrayList<OrderReview> reviewList) {
        super(context, 0, reviewList);
        mContext = context;
        mReviewList = reviewList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null) {
            listItem = LayoutInflater.from(mContext).inflate(R.layout.item_review, parent, false);
        }

        OrderReview currentItem = mReviewList.get(position);

        TextView tvOrderTitle = listItem.findViewById(R.id.textViewOrderTitle);
        TextView tvReview = listItem.findViewById(R.id.textViewReview);

        tvOrderTitle.setText(currentItem.getOrderTitle());
        tvReview.setText(currentItem.getComment());

        return listItem;
    }
}
