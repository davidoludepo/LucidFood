package com.icdatofcusgmail.lucidfood;

/**
 * Created by DAVID OGUNDEPO on 03/27/2017.
 */

public class Icdat {

    private String foodname;
    private int foodimage;

    Icdat(String foodname, int foodimage) {
        this.foodimage = foodimage;
        this.foodname = foodname;
    }

    public String getFoodname() {
        return foodname;
    }
    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }
    int getFoodimage() {
        return foodimage;
    }
    public void setFoodimage(int foodimage) {
        this.foodimage = foodimage;
    }
    public Icdat() {

    }
}
