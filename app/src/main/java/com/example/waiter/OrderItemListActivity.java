package com.example.waiter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.waiter.model.Food;

import java.util.ArrayList;

public class OrderItemListActivity extends AppCompatActivity {



    ArrayList<Food> foodList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_item_list);

        foodList=(ArrayList<Food>)getIntent().getSerializableExtra("orderList");

        Log.v("foodList",""+foodList.get(0).getmName());
    }
}
