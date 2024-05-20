package com.example.food.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.food.R;
import com.example.food.adapter.NutritionAdapter;
import com.example.food.bean.NutritionItem;
import com.example.food.bean.Orders;
import com.example.food.util.SPUtils;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class NutritionAnalysisActivity extends Activity {
    private ListView listView;
    private TextView textViewNoOrder;
    private TextView textViewOrders;
    private NutritionAdapter adapter;
    private String account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrition_analysis);

        // 初始化界面
        listView = findViewById(R.id.listViewNutrition);
        textViewNoOrder = findViewById(R.id.textViewNoOrder);
        textViewOrders = findViewById(R.id.textViewOrders);
        account = (String) SPUtils.get(this, SPUtils.ACCOUNT, "");

        // 检查是否有订单
        List<Orders> orders = DataSupport.where("account = ?", account).find(Orders.class);
        if (orders != null && !orders.isEmpty()) {

            // 如果有订单，则显示订单信息
            StringBuilder ordersText = new StringBuilder("订单信息:\n");
            for (Orders order : orders) {
                ordersText.append(order.getTitle())
                        .append(" - ")
                        .append(order.getNumber())
                        .append(" - ")
                        .append(order.getDate())
                        .append("\n");
            }
            textViewOrders.setText(ordersText.toString());
            // 如果有订单，则显示营养成分
            textViewNoOrder.setVisibility(View.GONE);
            listView.setVisibility(View.VISIBLE);
            initListView();
        } else {
            // 如果没有订单，则显示提示信息
            textViewNoOrder.setVisibility(View.VISIBLE);
            listView.setVisibility(View.GONE);
            Toast.makeText(this, "无订单，无法显示营养成分", Toast.LENGTH_SHORT).show();
        }
    }

    private void initListView() {
        // 获取营养成分数据
        ArrayList<NutritionItem> nutritionItems = getSampleNutritionData();

        // 设置适配器
        adapter = new NutritionAdapter(this, nutritionItems);
        listView.setAdapter(adapter);
    }

    // 模拟获取营养成分数据的方法
    private ArrayList<NutritionItem> getSampleNutritionData() {
        ArrayList<NutritionItem> nutritionItems = new ArrayList<>();

        // 添加模拟数据，实际情况下需要根据菜品数据查询真实的营养成分
        nutritionItems.add(new NutritionItem("维生素A", "100 IU"));
        nutritionItems.add(new NutritionItem("蛋白质", "20 g"));
        nutritionItems.add(new NutritionItem("脂肪", "10 g"));
        nutritionItems.add(new NutritionItem("碳水化合物", "30 g"));

        // 添加更多的营养成分数据...

        return nutritionItems;
    }

}
