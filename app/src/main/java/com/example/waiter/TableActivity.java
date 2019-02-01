package com.example.waiter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class TableActivity extends AppCompatActivity {


    GridView gridView;
    ArrayList arrayList;

    public static String[] names = {
            "Table-1","Table-2","Table-3","Table-4","Table-5","Table-6","Table-7","Table-8","Table-9","Table-10"
    };
    public static int[] Images = {
            R.drawable.ic_restaurant,R.drawable.ic_restaurant,R.drawable.ic_restaurant,R.drawable.ic_restaurant,R.drawable.ic_restaurant,R.drawable.ic_restaurant
            ,R.drawable.ic_restaurant,R.drawable.ic_restaurant,R.drawable.ic_restaurant,R.drawable.ic_restaurant,

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
        gridView = (GridView) findViewById(R.id.gridView);


        RecyclerViewAdapter adapter = new RecyclerViewAdapter(TableActivity.this, names, Images);
        gridView.setAdapter(adapter);


    }
}