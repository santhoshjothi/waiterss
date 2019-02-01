package com.example.waiter;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


import com.example.waiter.model.Food;

import java.util.ArrayList;

import static android.provider.MediaStore.Video.VideoColumns.CATEGORY;

import static com.example.waiter.DBHelper.IMAGEURL;
import static com.example.waiter.DBHelper.ITEMID;
import static com.example.waiter.DBHelper.ITEMNAME;
import static com.example.waiter.DBHelper.PRICE;
import static com.example.waiter.DBHelper.QUANTITY;
import static com.example.waiter.DBHelper.TABLENAME;

/**
 * Created by Guanzhu Li on 1/13/2017.
 */
public class DBManipulation {
    private DBHelper mDBHelper;
    private SQLiteDatabase mSQLiteDatabase;
    private Context mContext;
    private static String mDBName;
    private static DBManipulation mInstance;

    public DBManipulation(Context context) {
        mDBName = DBHelper.DATABASE_NAME;
        this.mContext = context;
        mDBHelper = new DBHelper(context);
        mSQLiteDatabase = mDBHelper.getWritableDatabase();
    }

    public SQLiteDatabase getDb(){
        return mSQLiteDatabase;
    }

    public static DBManipulation getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new DBManipulation(context);
        }
        return mInstance;
    }


    public void addAll(){
        ArrayList<Integer> foodsList = OrderItem.getInstance(mContext).getFoodInCart();
        for (Integer i : foodsList){
            Food curFood = OrderItem.getInstance(mContext).getFoodById(i);
//            INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY)
//            VALUES (1, 'Paul', 32, 'California', 20000.00 );
            String insertCurrentFood = "INSERT INTO " + TABLENAME + "("
                                    + ITEMID + ","
                                    + ITEMNAME + ","
                                    + QUANTITY + ","
                                    + PRICE + ","
                                    + CATEGORY + ","
                                    + IMAGEURL
                                    + ")"
                                    + "VALUES ("
                                    + curFood.getmId() + ","
                                    + "'" + curFood.getmName() + "'" + ","
                                    + OrderItem.getInstance(mContext).getFoodNumber(curFood) + ","
                                    + curFood.getmPrice()+ ","
                                    + "'" + curFood.getmCategory() + "'" + ","
                                    + "'" + curFood.getmImageUrl() + "'"
                                    + ")";
            Log.e("DB", "insert value query: " + insertCurrentFood);
            mSQLiteDatabase.execSQL(insertCurrentFood);
        }
    }


    public void deleteAll(){
        mSQLiteDatabase.execSQL("delete from "+ TABLENAME);
        Log.e("DB", "Delete all: " + "delete from "+ TABLENAME);
    }


}
