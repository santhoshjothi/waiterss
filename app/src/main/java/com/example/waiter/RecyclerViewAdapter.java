package com.example.waiter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RecyclerViewAdapter extends BaseAdapter {

    String [] result;
    Context context;
    int [] imageId;
    private static LayoutInflater inflater=null;
    public RecyclerViewAdapter(Context contexts, String[] NameList, int[] Images) {
        // TODO Auto-generated constructor stub
        result=NameList;
        context=contexts;
        imageId=Images;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder
    {
        TextView textView;
        ImageView imageView;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        View rowView;

        rowView = inflater.inflate(R.layout.recycler_view_item, null);
        holder.textView =(TextView) rowView.findViewById(R.id.textView);
        holder.imageView =(ImageView) rowView.findViewById(R.id.imageView);

        holder.textView.setText(result[position]);
        holder.imageView.setImageResource(imageId[position]);

        holder.imageView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(context, "You Clicked "+result[position], Toast.LENGTH_SHORT).show();

                Intent intent =new Intent(context,ItemSearchActivity.class);
                context.startActivity(intent);
            }
        });

        return rowView;
    }

}