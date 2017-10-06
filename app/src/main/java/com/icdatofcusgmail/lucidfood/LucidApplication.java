package com.icdatofcusgmail.lucidfood;

import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.TextView;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.TreeMap;

/**
 * Created by DAVID OGUNDEPO on 06/02/2017.
 *
 */

public class LucidApplication extends Application {

    public  String[] Diamond;
    public Bundle sellerOruko;
    public TextView Idtext;
    public TextView Nametext;
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


        JSONArray white_rice = new JSONArray();
        white_rice.add("150 naira White Rice");
        white_rice.add("200 naira White Rice");
        white_rice.add("250 naira White Rice");
        white_rice.add("300 naira White Rice");
        white_rice.add("350 naira White Rice");
        white_rice.add("400 naira White Rice");
        prices.put("White Rice",white_rice);

        JSONArray jollof_rice = new JSONArray();
        jollof_rice.add("150 naira Jollof Rice");
        jollof_rice.add("200 naira Jollof Rice");
        jollof_rice.add("250 naira Jollof Rice");
        jollof_rice.add("300 naira Jollof Rice");
        jollof_rice.add("350 naira Jollof Rice");
        jollof_rice.add("400 naira Jollof Rice");
        prices.put("Jollof Rice",jollof_rice);

        JSONArray fried_rice = new JSONArray();
        fried_rice.add("150 naira Fried Rice");
        fried_rice.add("200 naira Fried Rice");
        fried_rice.add("250 naira Fried Rice");
        fried_rice.add("300 naira Fried Rice");
        fried_rice.add("350 naira Fried Rice");
        fried_rice.add("400 naira Fried Rice");
        prices.put("Fried Rice",fried_rice);

        JSONArray vegetable_rice = new JSONArray();
        vegetable_rice.add("150 naira Vegatable Rice");
        vegetable_rice.add("200 naira Vegatable Rice");
        vegetable_rice.add("250 naira Vegatable Rice");
        vegetable_rice.add("300 naira Vegatable Rice");
        vegetable_rice.add("350 naira Vegatable Rice");
        vegetable_rice.add("400 naira Vegatable Rice");
        prices.put("Vegetable Rice",vegetable_rice);

        JSONArray coconut_rice = new JSONArray();
        coconut_rice.add("150 naira Coconut Rice");
        coconut_rice.add("200 naira Coconut Rice");
        coconut_rice.add("250 naira Coconut Rice");
        coconut_rice.add("300 naira Coconut Rice");
        coconut_rice.add("350 naira Coconut Rice");
        coconut_rice.add("400 naira Coconut Rice");
        prices.put("Coconut Rice",coconut_rice);

        JSONArray small_beef = new JSONArray();
        small_beef.add("100 naira Small Beef");
        small_beef.add("200 naira Small Beef(2)");
        small_beef.add("300 naira Small Beef(3)");
        small_beef.add("400 naira Small Beef(4)");
        small_beef.add("500 naira Small Beef(5)");
        small_beef.add("600 naira Small Beef(6)");
        prices.put("Small Beef",small_beef);

        JSONArray big_beef = new JSONArray();
        big_beef.add("200 naira Big Beef");
        big_beef.add("400 naira Big Beef(2)");
        big_beef.add("600 naira Big Beef(3)");
        big_beef.add("800 naira Big Beef(4)");
        big_beef.add("1000 naira Big Beef(5)");
        big_beef.add("1200 naira Small Beef(6)");
        prices.put("Big Beef",big_beef);

        JSONArray assorted_meat = new JSONArray();
        assorted_meat.add("100 naira Assorted Meat");
        assorted_meat.add("200 naira Assorted Meat(2)");
        assorted_meat.add("300 naira Assorted Meat(3)");
        assorted_meat.add("400 naira Assorted Meat(4)");
        assorted_meat.add("500 naira Assorted Meat(5)");
        assorted_meat.add("600 naira Assorted Meat(6)");
        prices.put("Assorted Meat",assorted_meat);

        JSONArray ponmo = new JSONArray();
        ponmo.add("50 naira Ponmo");
        ponmo.add("100 naira Ponmo(2)");
        ponmo.add("150 naira Ponmo(3)");
        ponmo.add("200 naira Ponmo(4)");
        ponmo.add("250 naira Ponmo(5)");
        ponmo.add("250 naira Ponmo(6)");
        prices.put("Ponmo",ponmo);

        JSONArray small_chicken = new JSONArray();
        small_chicken.add("200 naira Small Chicken");
        small_chicken.add("400 naira Small Chicken(2)");
        small_chicken.add("600 naira Small Chicken(3)");
        small_chicken.add("800 naira Small Chicken(4)");
        small_chicken.add("1000 naira Small Chicken(5)");
        small_chicken.add("1200 naira Small Chicken(6)");
        prices.put("Small Chicken",small_chicken);

        JSONArray big_chicken = new JSONArray();
        big_chicken.add("300 naira Big Chicken");
        big_chicken.add("600 naira Big Chicken(2)");
        big_chicken.add("900 naira Big Chicken(3)");
        big_chicken.add("1200 naira Big Chicken(4)");
        big_chicken.add("1500 naira Big Chicken(5)");
        big_chicken.add("1800 naira Big Chicken(6)");
        prices.put("Big Chicken",big_chicken);

        JSONArray small_goatmeat = new JSONArray();
        small_goatmeat.add("200 naira Small Goatmeat");
        small_goatmeat.add("400 naira Small Goatmeat(2)");
        small_goatmeat.add("600 naira Small Goatmeat(3)");
        small_goatmeat.add("800 naira Small Goatmeat(4)");
        small_goatmeat.add("1000 naira Small Goatmeat(5)");
        small_goatmeat.add("1200 naira Small Goatmeat(6)");
        prices.put("Small GoatMeat",small_goatmeat);

        JSONArray big_goatmeat = new JSONArray();
        big_goatmeat.add("300 naira Big Goatmeat");
        big_goatmeat.add("600 naira Big Goatmeat(2)");
        big_goatmeat.add("900 naira Big Goatmeat(3)");
        big_goatmeat.add("1200 naira Big Goatmeat(4)");
        big_goatmeat.add("1500 naira Big Goatmeat(5)");
        big_goatmeat.add("1800 naira Big Goatmeat(6)");
        prices.put("Big GoatMeat",big_goatmeat);

        JSONArray titus_fish = new JSONArray();
        titus_fish.add("100 naira Titus Fish");
        titus_fish.add("200 naira Titus Fish(2)");
        titus_fish.add("300 naira Titus Fish(3)");
        titus_fish.add("400 naira Titus Fish(4)");
        titus_fish.add("500 naira Titus Fish(5)");
        titus_fish.add("600 naira Titus Fish(6)");
        prices.put("Titus Fish",titus_fish);

        JSONArray sawa_fish = new JSONArray();
        sawa_fish.add("100 naira Sawa Fish");
        sawa_fish.add("200 naira Sawa Fish(2)");
        sawa_fish.add("300 naira Sawa Fish(3)");
        sawa_fish.add("400 naira Sawa Fish(4)");
        sawa_fish.add("500 naira Sawa Fish(5)");
        sawa_fish.add("600 naira Sawa Fish(6)");
        prices.put("Sawa Fish",sawa_fish);

        JSONArray panla_fish = new JSONArray();
        panla_fish.add("100 naira Panla Fish");
        panla_fish.add("200 naira Panla Fish(2)");
        panla_fish.add("300 naira Panla Fish(3)");
        panla_fish.add("400 naira Panla Fish(4)");
        panla_fish.add("500 naira Panla Fish(5)");
        panla_fish.add("600 naira Panla Fish(6)");
        prices.put("Panla Fish",panla_fish);

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

        JSONArray boiled_egg = new JSONArray();
        boiled_egg.add("50 naira Boiled Egg");
        boiled_egg.add("100 naira Boiled Egg(2)");
        boiled_egg.add("150 naira Boiled Egg(3)");
        boiled_egg.add("200 naira Boiled Egg(4)");
        boiled_egg.add("250 naira Boiled Egg(5)");
        boiled_egg.add("300 naira Boiled Egg(6)");
        prices.put("Boiled Egg",boiled_egg);

        JSONArray coleslaw = new JSONArray();
        coleslaw.add("100 naira Coleslaw");
        coleslaw.add("150 naira Coleslaw");
        coleslaw.add("200 naira Coleslaw");
        coleslaw.add("250 naira Coleslaw");
        coleslaw.add("300 naira Coleslaw");
        coleslaw.add("350 naira Coleslaw");
        prices.put("Coleslaw",coleslaw);

        JSONArray white_beans = new JSONArray();
        white_beans.add("100 naira WhiteBeans");
        white_beans.add("150 naira WhiteBeans");
        white_beans.add("200 naira WhiteBeans");
        white_beans.add("250 naira WhiteBeans");
        white_beans.add("300 naira WhiteBeans");
        white_beans.add("350 naira WhiteBeans");
        prices.put("WhiteBeans",white_beans);

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
