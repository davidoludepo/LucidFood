package com.icdatofcusgmail.lucidfood;

import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.res.Configuration;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.TreeMap;

/**
 * Created by DAVID OGUNDEPO on 06/02/2017.
 *
 */

public class LucidApplication extends Application {

    public  String[] Diamond;
    private static LucidApplication instance;
    public  JSONArray  selectedfoods;
    public JSONObject prices;

    public JSONObject stack;

    public int allinfoodcounter = 0;

    public int fifty = 50;
    public int hundred = 100;
    public int onefifty = 150;
    public int twohundred = 200;
    public int twofifty = 250;
    public int threehundred = 300;
    public int threehundredfifty = 350;
    public int fourhundred = 400;
    public int fourhundredfifty = 450;
    public int fivehundred = 500;
    public int fivehundredfifty = 550;
    public int sixhundred = 600;
    public int sixhundredfifty = 650;
    public int sevenhundred = 700;
    public int sevenhundredfifty = 750;
    public int eighthundred = 800;
    public int eighthundredfifty = 850;
    public int ninehundred = 900;
    public int ninehundredfifty = 950;
    public int onethousand = 1000;
    public int onethousandfifty = 1050;
    public int onethousandhundred = 1100;
    public int onethousandonefifty = 1150;
    public int onethousandtwohundred = 1200;
    public int onethousandtwofifty = 1250;
    public int onethousandthreehundred = 1300;
    public int onethousandthreefifty = 1350;
    public int onethousandfourhundred = 1400;
    public int onethousandfourfifty = 1450;
    public int onethousandfivehundred = 1500;


    public TreeMap<String,String> prev;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        selectedfoods = new JSONArray();
        prices = new JSONObject();
        prev = new TreeMap<>();

        stack = new JSONObject();


        JSONArray whiterice = new JSONArray();
        whiterice.add("150 naira White Rice");
        whiterice.add("200 naira White Rice");
        whiterice.add("250 naira White Rice");
        whiterice.add("300 naira White Rice");
        whiterice.add("350 naira White Rice");
        whiterice.add("400 naira White Rice");
        prices.put("White Rice",whiterice);

        JSONArray jollofrice = new JSONArray();
        jollofrice.add("150 naira Jollof Rice");
        jollofrice.add("200 naira Jollof Rice");
        jollofrice.add("250 naira Jollof Rice");
        jollofrice.add("300 naira Jollof Rice");
        jollofrice.add("350 naira Jollof Rice");
        jollofrice.add("400 naira Jollof Rice");
        prices.put("Jollof Rice",jollofrice);

        JSONArray friedrice = new JSONArray();
        friedrice.add("150 naira Fried Rice");
        friedrice.add("200 naira Fried Rice");
        friedrice.add("250 naira Fried Rice");
        friedrice.add("300 naira Fried Rice");
        friedrice.add("350 naira Fried Rice");
        friedrice.add("400 naira Fried Rice");
        prices.put("Fried Rice",friedrice);

        JSONArray beef = new JSONArray();
        beef.add("100 naira Beef");
        beef.add("200 naira Beef(2)");
        beef.add("300 naira Beef(3)");
        beef.add("400 naira Beef(4)");
        beef.add("500 naira Beef(5)");
        beef.add("600 naira Beef(6)");
        prices.put("Beef",beef);

        JSONArray chicken = new JSONArray();
        chicken.add("300 naira Chicken");
        chicken.add("600 naira Chicken(2)");
        chicken.add("900 naira Chicken(3)");
        chicken.add("1200 naira Chicken(4)");
        chicken.add("1500 naira Chicken(5)");
        chicken.add("1800 naira Chicken(6)");
        prices.put("Chicken",chicken);

        JSONArray moimoi = new JSONArray();
        moimoi.add("100 naira MoiMoi");
        moimoi.add("200 naira MoiMoi(2)");
        moimoi.add("300 naira MoiMoi(3)");
        moimoi.add("400 naira MoiMoi(4)");
        moimoi.add("500 naira MoiMoi(5)");
        moimoi.add("600 naira MoiMoi(6)");
        prices.put("Moi Moi",moimoi);

        JSONArray plantain = new JSONArray();
        plantain.add("50 naira Plantain");
        plantain.add("100 naira Plantain");
        plantain.add("150 naira Plantain");
        plantain.add("200 naira Plantain");
        plantain.add("250 naira Plantain");
        plantain.add("300 naira Plantain");
        prices.put("Plantain",plantain);

        JSONArray egg = new JSONArray();
        egg.add("50 naira Egg");
        egg.add("100 naira Egg(2)");
        egg.add("150 naira Egg(3)");
        egg.add("200 naira Egg(4)");
        egg.add("250 naira Egg(5)");
        egg.add("300 naira Egg(6)");
        prices.put("Egg",egg);

        JSONArray sides = new JSONArray();
        sides.add("100 naira Sides");
        sides.add("150 naira Sides");
        sides.add("200 naira Sides");
        sides.add("250 naira Sides");
        sides.add("300 naira Sides");
        sides.add("400 naira Sides");
        prices.put("Coleslaw",sides);

        JSONArray beans = new JSONArray();
        beans.add("50 naira Beans");
        beans.add("100 naira Beans");
        beans.add("150 naira Beans");
        beans.add("200 naira Beans");
        beans.add("250 naira Beans");
        beans.add("300 naira Beans");
        prices.put("Beans",beans);

    }



    public static LucidApplication getInstance(){
        return instance;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
    }

    @Override
    public void registerComponentCallbacks(ComponentCallbacks callback) {
        super.registerComponentCallbacks(callback);
    }

    @Override
    public void unregisterComponentCallbacks(ComponentCallbacks callback) {
        super.unregisterComponentCallbacks(callback);
    }

    @Override
    public void registerActivityLifecycleCallbacks(ActivityLifecycleCallbacks callback) {
        super.registerActivityLifecycleCallbacks(callback);
    }

    @Override
    public void unregisterActivityLifecycleCallbacks(ActivityLifecycleCallbacks callback) {
        super.unregisterActivityLifecycleCallbacks(callback);
    }

    @Override
    public void registerOnProvideAssistDataListener(OnProvideAssistDataListener callback) {
        super.registerOnProvideAssistDataListener(callback);
    }

    @Override
    public void unregisterOnProvideAssistDataListener(OnProvideAssistDataListener callback) {
        super.unregisterOnProvideAssistDataListener(callback);
    }
}
