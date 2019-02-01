package com.example.waiter.model;
// Lily: Designed and implemented Food class for future using.
// Xiao: Added setImage function for storing image after ImageRequest finished.

import android.graphics.Bitmap;

import java.io.Serializable;


/**
 * Created by Guanzhu Li on 1/13/2017.
 */
public class Food implements Serializable{
    private int mId;
    private String mName;
    private double mPrice;
    private String mCategory;
    private String mImageUrl;
    private int quntity;


    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public double getmPrice() {
        return mPrice;
    }

    public void setmPrice(double mPrice) {
        this.mPrice = mPrice;
    }

    public String getmCategory() {
        return mCategory;
    }

    public void setmCategory(String mCategory) {
        this.mCategory = mCategory;
    }

    public String getmImageUrl() {
        return mImageUrl;
    }

    public void setmImageUrl(String mImageUrl) {
        this.mImageUrl = mImageUrl;
    }

    public int getQuntity() {
        return quntity;
    }

    public void setQuntity(int quntity) {
        this.quntity = quntity;
    }
}
