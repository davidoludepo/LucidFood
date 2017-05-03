package com.icdatofcusgmail.lucidfood;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by DAVID OGUNDEPO on 03/27/2017.
 */


public class Icdat implements Parcelable{

    String foodname;
    int foodimage;
    boolean selected = true;

    protected Icdat(Parcel in) {
        foodname = in.readString();
        foodimage = in.readInt();
        selected = in.readByte() != 0;
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

    public Icdat(){}

    public Icdat(String foodname, int foodimage) {
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
