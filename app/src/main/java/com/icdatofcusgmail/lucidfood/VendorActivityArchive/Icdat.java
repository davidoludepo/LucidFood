package com.icdatofcusgmail.lucidfood.VendorActivityArchive;

import android.os.Parcel;
import android.os.Parcelable;

import com.icdatofcusgmail.lucidfood.SmoothCheckBox;

/**
 * Created by DAVID OGUNDEPO on 03/27/2017.
 *
 */


public class Icdat implements Parcelable{

    private String foodname;
    private int foodimage;
    private boolean selected = true;
    private SmoothCheckBox smooth;

    private Icdat (Parcel in) {
        foodname = in.readString();
        foodimage = in.readInt();
        selected = in.readByte() != 0;
    }

    public Icdat() {

    }

    public static final Creator<Icdat> CREATOR = new Creator<Icdat>() {
        @Override
        public Icdat createFromParcel(Parcel in) {
            return new Icdat(in);
        }

        @Override
        public Icdat[] newArray(int size) {
            return new Icdat[size];
        }
    };


    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public Icdat(String foodname, int foodimage, SmoothCheckBox smoothe) {
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

    public SmoothCheckBox getSmooth() {
        return smooth;
    }

    public void setSmooth(SmoothCheckBox smooth) {
        this.smooth = smooth;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(foodname);
        dest.writeInt(foodimage);
        dest.writeByte((byte) (selected ? 1 : 0));
    }
}
