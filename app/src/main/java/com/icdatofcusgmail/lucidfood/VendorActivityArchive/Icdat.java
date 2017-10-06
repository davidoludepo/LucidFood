package com.icdatofcusgmail.lucidfood.VendorActivityArchive;

/**
 * Created by DAVID OGUNDEPO on 03/27/2017.
 *
 */


public class Icdat {

    private String foodname;
    private int foodimage;
    private boolean selected;
    private SmoothCheckBox smooth;



    Icdat(String foodname, int foodimage, SmoothCheckBox smoothe) {
        super();
        this.foodimage = foodimage;
        this.foodname = foodname;
        this.smooth = smoothe;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public int getFoodimage() {
        return foodimage;
    }

    public void setFoodimage(int foodimage) {
        this.foodimage = foodimage;
    }

    SmoothCheckBox getSmooth() {
        return smooth;
    }

    public void setSmooth(SmoothCheckBox smooth) {
        this.smooth = smooth;
    }

    public boolean isSelected()
    {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

}
