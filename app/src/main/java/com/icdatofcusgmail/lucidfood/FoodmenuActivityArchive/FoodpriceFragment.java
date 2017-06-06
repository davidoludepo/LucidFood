package com.icdatofcusgmail.lucidfood.FoodmenuActivityArchive;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.icdatofcusgmail.lucidfood.LucidApplication;
import com.icdatofcusgmail.lucidfood.R;
import com.icdatofcusgmail.lucidfood.VendorActivityArchive.Icdat;

import org.json.simple.JSONArray;

/**
 * Created by DAVID OGUNDEPO on 03/27/2017.
 *
 */

public class FoodpriceFragment extends Fragment {

    TextView textView, textView2, textView3, textView4, textView5, textView6;
    Button button, button2, button3, button4, button5, button6;
    OnNameSetListener onNameSetListener;
    LucidApplication MainApp;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.foodmenufragment2_foodprice, container, false);

        textView = (TextView) view.findViewById(R.id.Istpricebutton);
        textView2 = (TextView) view.findViewById(R.id.Secondpricebutton);
        textView3 = (TextView) view.findViewById(R.id.Thirdpricebutton);
        textView4 = (TextView) view.findViewById(R.id.Fourthpricebutton);
        textView5 = (TextView) view.findViewById(R.id.Fifthpricebutton);
        textView6 = (TextView) view.findViewById(R.id.Sixthpricebutton);

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
                String Name = textView.getText().toString();
                onNameSetListener.setName(Name);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = textView2.getText().toString();
                onNameSetListener.setName(Name);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = textView3.getText().toString();
                onNameSetListener.setName(Name);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = textView4.getText().toString();
                onNameSetListener.setName(Name);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = textView5.getText().toString();
                onNameSetListener.setName(Name);
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = textView6.getText().toString();
                onNameSetListener.setName(Name);
            }
        });

        return view;
    }
    public interface OnNameSetListener {
        public void setName(String name);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            onNameSetListener = (OnNameSetListener) activity;
        } catch (Exception e) {

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
