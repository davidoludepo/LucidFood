package com.icdatofcusgmail.lucidfood.FoodmenuActivityArchive;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.icdatofcusgmail.lucidfood.LucidApplication;
import com.icdatofcusgmail.lucidfood.R;
import com.icdatofcusgmail.lucidfood.VendorActivityArchive.Icdat;

import org.json.simple.JSONArray;

/**
 * Created by DAVID OGUNDEPO on 03/27/2017.
 *
 */

public class FoodpriceFragment extends Fragment {

    Button button, button2, button3, button4, button5, button6;
    OnNameSetListener onNameSetListener;
    LucidApplication MainApp;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.foodmenufragment2_foodprice, container, false);

        button = (Button) view.findViewById(R.id.Istpricebutton);
        button2 = (Button) view.findViewById(R.id.Secondpricebutton);
        button3 = (Button) view.findViewById(R.id.Thirdpricebutton);
        button4 = (Button) view.findViewById(R.id.Fourthpricebutton);
        button5 = (Button) view.findViewById(R.id.Fifthpricebutton);
        button6 = (Button) view.findViewById(R.id.Sixthpricebutton);

        button.setVisibility(View.GONE);
        button2.setVisibility(View.GONE);
        button3.setVisibility(View.GONE);
        button4.setVisibility(View.GONE);
        button5.setVisibility(View.GONE);
        button6.setVisibility(View.GONE);

        MainApp = LucidApplication.getInstance();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = button.getText().toString();
                onNameSetListener.setName(Name);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = button2.getText().toString();
                onNameSetListener.setName(Name);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = button3.getText().toString();
                onNameSetListener.setName(Name);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = button4.getText().toString();
                onNameSetListener.setName(Name);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = button5.getText().toString();
                onNameSetListener.setName(Name);
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = button6.getText().toString();
                onNameSetListener.setName(Name);
            }
        });
        return view;
    }

    interface OnNameSetListener {
        void setName(String name);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            onNameSetListener = (OnNameSetListener) activity;
        } catch (Exception ignored) {
        }
    }

    public void Datachange(int i) {
        JSONArray prices = new JSONArray();
        for(int j = 0; j< MainApp.selectedfoods.size(); j++){
             Icdat icdat = (Icdat)MainApp.selectedfoods.get(j);
             if(i == j){
                 prices = (JSONArray)MainApp.prices.get(icdat.getFoodname());
                 break;
             }
         }

        button.setText(prices.get(0).toString());
        button.setVisibility(View.VISIBLE);

        button2.setText(prices.get(1).toString());
        button2.setVisibility(View.VISIBLE);

        button3.setText(prices.get(2).toString());
        button3.setVisibility(View.VISIBLE);

        button4.setText(prices.get(3).toString());
        button4.setVisibility(View.VISIBLE);

        button5.setText(prices.get(4).toString());
        button5.setVisibility(View.VISIBLE);

        button6.setText(prices.get(5).toString());
        button6.setVisibility(View.VISIBLE);

    }
}
