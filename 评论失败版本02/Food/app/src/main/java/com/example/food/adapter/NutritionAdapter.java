package com.example.food.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.food.bean.NutritionItem;
import com.example.food.R;

import java.util.ArrayList;

public class NutritionAdapter extends ArrayAdapter<NutritionItem> {

    public NutritionAdapter(Context context, ArrayList<NutritionItem> data) {
        super(context, 0, data);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 获取当前项的数据
        NutritionItem item = getItem(position);

        // 检查是否有可重用的视图，如果没有，则创建一个新的视图
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_nutrition, parent, false);
        }

        // 获取视图中的控件
        TextView textViewName = convertView.findViewById(R.id.textViewName);
        TextView textViewValue = convertView.findViewById(R.id.textViewValue);

        // 将数据设置到控件中
        textViewName.setText(item.getName());
        textViewValue.setText(item.getValue());

        return convertView;
    }
}
