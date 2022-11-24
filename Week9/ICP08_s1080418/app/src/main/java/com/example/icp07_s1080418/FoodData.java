package com.example.icp07_s1080418;

import android.graphics.drawable.Drawable;

public class FoodData {
    private String id;
    private String name;
    private String price;
    private int pic;
    public FoodData(String id, String name, int pic, String price){
        this.id = id;
        this.name = name;
        this.price = price;
        this.pic = pic;
    }

    public String getName(){
        return name;
    }

    public String getId(){
        return id;
    }

    public String getPrice(){
        return price;
    }

    public int getPic() { return pic;}

}
