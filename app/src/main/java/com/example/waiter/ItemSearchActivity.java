package com.example.waiter;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.waiter.model.Food;

import java.io.Serializable;
import java.util.ArrayList;
import android.animation.LayoutTransition;
public class ItemSearchActivity extends AppCompatActivity {

    int count = 0;
    LinearLayout lin_item;
    AutoCompleteTextView actv;
    Food food;
    Button sub;
    ArrayList<Food> itemsFoodList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_search);

        String[] fruits = {"Apple", "Banana", "Cherry", "Date", "Grape", "Kiwi", "Mango", "Pear"};
        lin_item = (LinearLayout) findViewById(R.id.lin_item);
        actv = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        sub=(Button)findViewById(R.id.sub);
        //Creating the instance of ArrayAdapter containing list of fruit names
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.select_dialog_item, fruits);


        final ArrayList<Food> itemsFood = new ArrayList<>();
        Food foo = new Food();
        foo.setmName("Apple");
        foo.setQuntity(0);
        itemsFood.add(foo);
        Food foo1 = new Food();
        foo1.setmName("Idly");
        foo.setQuntity(0);
        Food foo2 = new Food();
        foo2.setmName("Orange");
        foo.setQuntity(0);
        Food foo3 = new Food();
        foo3.setmName("Dosa");
        foo.setQuntity(0);
        Food foo4 = new Food();
        foo4.setmName("Appvffd");
        foo.setQuntity(0);
        itemsFood.add(foo1);
        itemsFood.add(foo2);
        itemsFood.add(foo3);
        itemsFood.add(foo4);


        newAdapter searchAdapter = new newAdapter(this,itemsFood);
        actv.setAdapter(searchAdapter);
        actv.setThreshold(1);
        actv.setTextColor(getResources().getColor(R.color.colorPrimary));
            actv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    String selectedItem = actv.getAdapter().getItem(i).toString();
                    Log.v("ItemValue", "" + selectedItem);
                    addingItem(selectedItem);
                }
            });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int childCount;
                itemsFoodList = new ArrayList<>();
//                int id = OrderItem.getInstance(ItemSearchActivity.this).getFoodInCart().get(0);
//                final Food curFood = OrderItem.getInstance(ItemSearchActivity.this).getFoodById(id);
//                final int curFoodNumber = OrderItem.getInstance(ItemSearchActivity.this).getFoodNumber(curFood);
//                Log.i("count", "" + curFoodNumber);
;

                childCount = lin_item.getChildCount();
                Log.i("count", "" + childCount);
                if (childCount>0 ) {
                }
                for (int c = 0; c < childCount; c++) {
                    View childView = lin_item.getChildAt(c);
                    TextView childTextView = (TextView) (childView.findViewById(R.id.txt_pdtName_item));
                    TextView childTextqty = (TextView) (childView.findViewById(R.id.txt_qty_item));
                    String a = (String) (childTextView.getText().toString());
                    String b = (String) (childTextqty.getText());
                    Log.i("a", "" + a);
                    Food  food = new Food();
                    food.setmName(a);
                    itemsFoodList.add(food);
                }
                Intent order=new Intent(ItemSearchActivity.this,OrderItemListActivity.class);
                order.putExtra("orderList",(Serializable) itemsFoodList);
                startActivity(order);
            }
        });
    }

    public void addingItem(String item){
        count = count + 1;
        Log.i("count", "" + count);
        final LayoutInflater inflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View inflatedLayout = inflater.inflate(R.layout.inventory_item_list, null);
      //  inflatedLayout.setTag(count);
        final TextView txt_pdtName_item = (TextView) inflatedLayout.findViewById(R.id.txt_pdtName_item);
        final TextView txt_qty_item = (TextView) inflatedLayout.findViewById(R.id.txt_qty_item);
        final ImageView btn_remove_item = (ImageView) inflatedLayout.findViewById(R.id.btn_remove_item);
        final ImageView btn_minus_item = (ImageView) inflatedLayout.findViewById(R.id.btn_minus);
         ImageView  btn_plus_item= (ImageView) inflatedLayout.findViewById(R.id.btn_plus);
        btn_plus_item.setTag(count);
        txt_pdtName_item.setText(item);
       // txt_qty_item.setText(value_qty);
      //  edt_value_Qty.setText("");
        //edt_PdtNme.setText("");
        actv.requestFocus();
        lin_item.addView(inflatedLayout, lin_item.getChildCount() - 1);


        LayoutTransition transition = new LayoutTransition();
        lin_item.setLayoutTransition(transition);





        btn_plus_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View index = ((LinearLayout) inflatedLayout.getParent()).getChildAt(view.getId());

                //int index = ((ViewGroup) inflatedLayout.getParent()).indexOfChild(inflatedLayout);
                Log.i("count", "" +index);


                TextView quntity_Txt = (TextView) inflatedLayout.findViewById(R.id.txt_qty_item);

                int quntity=Integer.parseInt(quntity_Txt.getText().toString());
                int qty=quntity+1;

                quntity_Txt.setText(String.valueOf(qty));

            }
        });
        btn_minus_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView quntity_Txt = (TextView) inflatedLayout.findViewById(R.id.txt_qty_item);

                int quntity=Integer.parseInt(quntity_Txt.getText().toString());

                if (quntity == 1) {

                    ((LinearLayout) inflatedLayout.getParent()).removeView(inflatedLayout);
                    } else {
                    int qty = quntity - 1;
                    quntity_Txt.setText(String.valueOf(qty));
                }


            }
        });
        btn_remove_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((LinearLayout) inflatedLayout.getParent()).removeView(inflatedLayout);
                int childCount = ((LinearLayout) inflatedLayout.getParent()).getChildCount();
                Log.v("AddProduct",""+childCount);
            }
        });



    }


}
