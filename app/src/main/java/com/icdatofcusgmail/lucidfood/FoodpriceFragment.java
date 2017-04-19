package com.icdatofcusgmail.lucidfood;

import android.app.Activity;
import android.app.Fragment;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by DAVID OGUNDEPO on 03/27/2017.
 */

public class FoodpriceFragment extends Fragment {

    TextView textView, textView2, textView3, textView4, textView5, textView6;
    Button button, button2, button3, button4, button5, button6;
    OnNameSetListener onNameSetListener;

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

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = textView.getText().toString();
                onNameSetListener.setName(Name);
            }
        });
       // Animation in = AnimationUtils.loadAnimation(getActivity(), android.R.anim.slide_in_left);
       // Animation out = AnimationUtils.loadAnimation(getActivity(), android.R.anim.slide_out_right);



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
        Resources resourcez = getResources();

        String[] amount = resourcez.getStringArray(R.array.amount);
        button.setText(amount[i]);
        button.setVisibility(View.VISIBLE);

        String[] amount2 = resourcez.getStringArray(R.array.amount2);
        button2.setText(amount2[i]);
        button2.setVisibility(View.VISIBLE);

        String[] amount3 = resourcez.getStringArray(R.array.amount3);
        button3.setText(amount3[i]);
        button3.setVisibility(View.VISIBLE);

        String[] amount4 = resourcez.getStringArray(R.array.amount4);
        button4.setText(amount4[i]);
        button4.setVisibility(View.VISIBLE);

        String[] amount5 = resourcez.getStringArray(R.array.amount5);
        button5.setText(amount5[i]);
        button5.setVisibility(View.VISIBLE);

        String[] amount6 = resourcez.getStringArray(R.array.amount6);
        button6.setText(amount6[i]);
        button6.setVisibility(View.VISIBLE);

    }
}
