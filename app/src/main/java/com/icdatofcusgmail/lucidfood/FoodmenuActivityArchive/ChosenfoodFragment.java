package com.icdatofcusgmail.lucidfood.FoodmenuActivityArchive;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.icdatofcusgmail.lucidfood.LucidApplication;
import com.icdatofcusgmail.lucidfood.R;

/**
 * Created by DAVID OGUNDEPO on 03/28/2017.
 *
 */

public class ChosenfoodFragment extends Fragment {

    TextView textView, textView2nd, textView3rd, textView4th, textView5th, textView6th, textView7th, textView8th, textView9th, textView10th, textView11th, textView12th, textView13th, textView14th, textView15th, textView16th, textView17th, textView18th, textView19th, textView20th, textView21st;
    ImageButton imageButton, imageButton2nd, imageButton3rd, imageButton4th, imageButton5th, imageButton6th, imageButton7th, imageButton8th, imageButton9th, imageButton10th, imageButton11th, imageButton12th, imageButton13th, imageButton14th, imageButton15th, imageButton16th, imageButton17th, imageButton18th, imageButton19th, imageButton20th, imageButton21st;
    OnPriceSetListener onPriceSetListener;

    LucidApplication app;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.foodmenufragment3_chosenfood, container, false);

        app = LucidApplication.getInstance();

        textView = (Button) view.findViewById(R.id.Istchosenbutton);
        textView.setVisibility(View.GONE);
        textView2nd = (Button) view.findViewById(R.id.Secondchosenbutton);
        textView2nd.setVisibility(View.GONE);
        textView3rd = (Button) view.findViewById(R.id.Thirdchosenbutton);
        textView3rd.setVisibility(View.GONE);
        textView4th = (Button) view.findViewById(R.id.Fourthchosenbutton);
        textView4th.setVisibility(View.GONE);
        textView5th = (Button) view.findViewById(R.id.Fifthchosenbutton);
        textView5th.setVisibility(View.GONE);
        textView6th = (Button) view.findViewById(R.id.Sixthchosenbutton);
        textView6th.setVisibility(View.GONE);
        textView7th = (Button) view.findViewById(R.id.Seventhchosenbutton);
        textView7th.setVisibility(View.GONE);
        textView8th = (Button) view.findViewById(R.id.Eightchosenbutton);
        textView8th.setVisibility(View.GONE);
        textView9th = (Button) view.findViewById(R.id.Ninthchosenbutton);
        textView9th.setVisibility(View.GONE);
        textView10th = (Button) view.findViewById(R.id.Tenthchosenbutton);
        textView10th.setVisibility(View.GONE);
        textView11th = (Button) view.findViewById(R.id.Eleventhchosenbutton);
        textView11th.setVisibility(View.GONE);
        textView12th = (Button) view.findViewById(R.id.Twelvthchosenbutton);
        textView12th.setVisibility(View.GONE);
        textView13th = (Button) view.findViewById(R.id.Thirteenthchosenbutton);
        textView13th.setVisibility(View.GONE);
        textView14th = (Button) view.findViewById(R.id.Fourteenthchosenbutton);
        textView14th.setVisibility(View.GONE);
        textView15th = (Button) view.findViewById(R.id.Fifteenthchosenbutton);
        textView15th.setVisibility(View.GONE);
        textView16th = (Button) view.findViewById(R.id.Sixteenthchosenbutton);
        textView16th.setVisibility(View.GONE);
        textView17th = (Button) view.findViewById(R.id.Seventeenthchosenbutton);
        textView17th.setVisibility(View.GONE);
        textView18th = (Button) view.findViewById(R.id.Eighteenthchosenbutton);
        textView18th.setVisibility(View.GONE);
        textView19th = (Button) view.findViewById(R.id.Nineteenthchosenbutton);
        textView19th.setVisibility(View.GONE);
        textView20th = (Button) view.findViewById(R.id.Twentiethchosenbutton);
        textView20th.setVisibility(View.GONE);
        textView21st = (Button) view.findViewById(R.id.TwentyIstchosenbutton);
        textView21st.setVisibility(View.GONE);

        imageButton = (ImageButton) view.findViewById(R.id.Istchosendeletebutton);
        imageButton.setVisibility(View.GONE);
        imageButton2nd = (ImageButton) view.findViewById(R.id.Secondchosendeletebutton);
        imageButton2nd.setVisibility(View.GONE);
        imageButton3rd = (ImageButton) view.findViewById(R.id.Thirdchosendeletebutton);
        imageButton3rd.setVisibility(View.GONE);
        imageButton4th = (ImageButton) view.findViewById(R.id.Fourthchosendeletebutton);
        imageButton4th.setVisibility(View.GONE);
        imageButton5th = (ImageButton) view.findViewById(R.id.Fifthchosendeletebutton);
        imageButton5th.setVisibility(View.GONE);
        imageButton6th = (ImageButton) view.findViewById(R.id.Sixthchosendeletebutton);
        imageButton6th.setVisibility(View.GONE);
        imageButton7th = (ImageButton) view.findViewById(R.id.Seventhchosendeletebutton);
        imageButton7th.setVisibility(View.GONE);
        imageButton8th = (ImageButton) view.findViewById(R.id.Eightchosendeletebutton);
        imageButton8th.setVisibility(View.GONE);
        imageButton9th = (ImageButton) view.findViewById(R.id.Ninthchosendeleltebutton);
        imageButton9th.setVisibility(View.GONE);
        imageButton10th = (ImageButton) view.findViewById(R.id.Tenthchosendeletebutton);
        imageButton10th.setVisibility(View.GONE);
        imageButton11th = (ImageButton) view.findViewById(R.id.Eleventhchosendeleltebutton);
        imageButton11th.setVisibility(View.GONE);
        imageButton12th = (ImageButton) view.findViewById(R.id.Twelvthchosendeletebutton);
        imageButton12th.setVisibility(View.GONE);
        imageButton13th = (ImageButton) view.findViewById(R.id.Thirteenthchosendeleltebutton);
        imageButton13th.setVisibility(View.GONE);
        imageButton14th = (ImageButton) view.findViewById(R.id.Fourteenthchosendeletebutton);
        imageButton14th.setVisibility(View.GONE);
        imageButton15th = (ImageButton) view.findViewById(R.id.Fifteenthchosendeleltebutton);
        imageButton15th.setVisibility(View.GONE);
        imageButton16th = (ImageButton) view.findViewById(R.id.Sixteenthchosendeletebutton);
        imageButton16th.setVisibility(View.GONE);
        imageButton17th = (ImageButton) view.findViewById(R.id.Seventeenthchosendeleltebutton);
        imageButton17th.setVisibility(View.GONE);
        imageButton18th = (ImageButton) view.findViewById(R.id.Eighteenthchosendeletebutton);
        imageButton18th.setVisibility(View.GONE);
        imageButton19th = (ImageButton) view.findViewById(R.id.Nineteenthchosendeleltebutton);
        imageButton19th.setVisibility(View.GONE);
        imageButton20th = (ImageButton) view.findViewById(R.id.Twentiethchosendeletebutton);
        imageButton20th.setVisibility(View.GONE);
        imageButton21st = (ImageButton) view.findViewById(R.id.TwentyIstchosendeletebutton);
        imageButton21st.setVisibility(View.GONE);

        return view;
    }

    interface OnPriceSetListener {
        void setPrice(String price);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            onPriceSetListener = (OnPriceSetListener) activity;
        } catch (Exception ignored) {
        }
    }

    public void updateInfo(String name) {

        imageButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            textView.setVisibility(View.GONE);
            imageButton.setVisibility(View.GONE);
            FoodmenuActivity.Pcount.setEnabled(false);
            FoodmenuActivity.Purchase.setEnabled(false);
            String Price = textView.getText().toString();
            onPriceSetListener.setPrice(Price);
            app.prev.remove("0");
            if (!imageButton.isShown() && imageButton2nd.isShown() || imageButton3rd.isShown()
                    || imageButton4th.isShown() || imageButton5th.isShown() || imageButton6th.isShown()
                    || imageButton7th.isShown() || imageButton8th.isShown() || imageButton9th.isShown()
                    || imageButton10th.isShown() ||imageButton11th.isShown() || imageButton12th.isShown()
                    || imageButton13th.isShown() || imageButton14th.isShown() || imageButton15th.isShown()
                    || imageButton16th.isShown() || imageButton17th.isShown() || imageButton18th.isShown()
                    || imageButton19th.isShown() || imageButton20th.isShown() || imageButton21st.isShown()) {
                FoodmenuActivity.Pcount.setEnabled(true);
                FoodmenuActivity.Purchase.setEnabled(true);
            }
        }
        });

        imageButton2nd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView2nd.setVisibility(View.GONE);
                imageButton2nd.setVisibility(View.GONE);
                FoodmenuActivity.Pcount.setEnabled(false);
                FoodmenuActivity.Purchase.setEnabled(false);
                String Price = textView2nd.getText().toString();
                onPriceSetListener.setPrice(Price);
                app.prev.remove("1");
                if (!imageButton2nd.isShown() && imageButton.isShown() || imageButton3rd.isShown()
                        || imageButton4th.isShown() || imageButton5th.isShown() || imageButton6th.isShown()
                        || imageButton7th.isShown() || imageButton8th.isShown() || imageButton9th.isShown()
                        || imageButton10th.isShown() || imageButton11th.isShown() || imageButton12th.isShown()
                        || imageButton13th.isShown() || imageButton14th.isShown() || imageButton15th.isShown()
                        || imageButton16th.isShown() || imageButton17th.isShown() || imageButton18th.isShown()
                        || imageButton19th.isShown() || imageButton20th.isShown() || imageButton21st.isShown()) {
                    FoodmenuActivity.Pcount.setEnabled(true);
                    FoodmenuActivity.Purchase.setEnabled(true);
                }
            }
        });

        imageButton3rd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView3rd.setVisibility(View.GONE);
                imageButton3rd.setVisibility(View.GONE);
                FoodmenuActivity.Pcount.setEnabled(false);
                FoodmenuActivity.Purchase.setEnabled(false);
                String Price = textView3rd.getText().toString();
                onPriceSetListener.setPrice(Price);
                app.prev.remove("2");
                if (!imageButton3rd.isShown() && imageButton.isShown() || imageButton2nd.isShown()
                        || imageButton4th.isShown() || imageButton5th.isShown() || imageButton6th.isShown()
                        || imageButton7th.isShown() || imageButton8th.isShown() || imageButton9th.isShown()
                        || imageButton10th.isShown() || imageButton11th.isShown() || imageButton12th.isShown()
                        || imageButton13th.isShown() || imageButton14th.isShown() || imageButton15th.isShown()
                        || imageButton16th.isShown() || imageButton17th.isShown() || imageButton18th.isShown()
                        || imageButton19th.isShown() || imageButton20th.isShown() || imageButton21st.isShown()) {
                    FoodmenuActivity.Pcount.setEnabled(true);
                    FoodmenuActivity.Purchase.setEnabled(true);
                }
            }
        });

        imageButton4th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView4th.setVisibility(View.GONE);
                imageButton4th.setVisibility(View.GONE);
                FoodmenuActivity.Pcount.setEnabled(false);
                FoodmenuActivity.Purchase.setEnabled(false);
                String Price = textView4th.getText().toString();
                onPriceSetListener.setPrice(Price);
                app.prev.remove("3");
                if (!imageButton4th.isShown() && imageButton.isShown() || imageButton2nd.isShown()
                        || imageButton3rd.isShown() || imageButton5th.isShown() || imageButton6th.isShown()
                        || imageButton7th.isShown() || imageButton8th.isShown() || imageButton9th.isShown()
                        || imageButton10th.isShown() || imageButton11th.isShown() || imageButton12th.isShown()
                        || imageButton13th.isShown() || imageButton14th.isShown() || imageButton15th.isShown()
                        || imageButton16th.isShown() || imageButton17th.isShown() || imageButton18th.isShown()
                        || imageButton19th.isShown() || imageButton20th.isShown() || imageButton21st.isShown()) {
                    FoodmenuActivity.Pcount.setEnabled(true);
                    FoodmenuActivity.Purchase.setEnabled(true);
                }
            }
        });

        imageButton5th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView5th.setVisibility(View.GONE);
                imageButton5th.setVisibility(View.GONE);
                FoodmenuActivity.Pcount.setEnabled(false);
                FoodmenuActivity.Purchase.setEnabled(false);
                String Price = textView5th.getText().toString();
                onPriceSetListener.setPrice(Price);
                app.prev.remove("4");
                if (!imageButton5th.isShown() && imageButton.isShown() || imageButton2nd.isShown()
                        || imageButton3rd.isShown() || imageButton4th.isShown() || imageButton6th.isShown()
                        || imageButton7th.isShown() || imageButton8th.isShown() || imageButton9th.isShown()
                        || imageButton10th.isShown() || imageButton11th.isShown() || imageButton12th.isShown()
                        || imageButton13th.isShown() || imageButton14th.isShown() || imageButton15th.isShown()
                        || imageButton16th.isShown() || imageButton17th.isShown() || imageButton18th.isShown()
                        || imageButton19th.isShown() || imageButton20th.isShown() || imageButton21st.isShown()) {
                    FoodmenuActivity.Pcount.setEnabled(true);
                    FoodmenuActivity.Purchase.setEnabled(true);
                }
            }
        });

        imageButton6th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView6th.setVisibility(View.GONE);
                imageButton6th.setVisibility(View.GONE);
                FoodmenuActivity.Pcount.setEnabled(false);
                FoodmenuActivity.Purchase.setEnabled(false);
                String Price = textView6th.getText().toString();
                onPriceSetListener.setPrice(Price);
                app.prev.remove("5");
                if (!imageButton6th.isShown() && imageButton.isShown() || imageButton2nd.isShown()
                        || imageButton3rd.isShown() || imageButton4th.isShown() || imageButton5th.isShown()
                        || imageButton7th.isShown() || imageButton8th.isShown() || imageButton9th.isShown()
                        || imageButton10th.isShown() || imageButton11th.isShown() || imageButton12th.isShown()
                        || imageButton13th.isShown() || imageButton14th.isShown() || imageButton15th.isShown()
                        || imageButton16th.isShown() || imageButton17th.isShown() || imageButton18th.isShown()
                        || imageButton19th.isShown() || imageButton20th.isShown() || imageButton21st.isShown()) {
                    FoodmenuActivity.Pcount.setEnabled(true);
                    FoodmenuActivity.Purchase.setEnabled(true);
                }
            }
        });

        imageButton7th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView7th.setVisibility(View.GONE);
                imageButton7th.setVisibility(View.GONE);
                FoodmenuActivity.Pcount.setEnabled(false);
                FoodmenuActivity.Purchase.setEnabled(false);
                String Price = textView7th.getText().toString();
                onPriceSetListener.setPrice(Price);
                app.prev.remove("6");
                if (!imageButton7th.isShown() && imageButton.isShown() || imageButton2nd.isShown()
                        || imageButton3rd.isShown() || imageButton4th.isShown() || imageButton5th.isShown()
                        || imageButton6th.isShown() || imageButton8th.isShown() || imageButton9th.isShown()
                        || imageButton10th.isShown() || imageButton11th.isShown() || imageButton12th.isShown()
                        || imageButton13th.isShown() || imageButton14th.isShown() || imageButton15th.isShown()
                        || imageButton16th.isShown() || imageButton17th.isShown() || imageButton18th.isShown()
                        || imageButton19th.isShown() || imageButton20th.isShown() || imageButton21st.isShown()) {
                    FoodmenuActivity.Pcount.setEnabled(true);
                    FoodmenuActivity.Purchase.setEnabled(true);
                }
            }
        });

        imageButton8th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView8th.setVisibility(View.GONE);
                imageButton8th.setVisibility(View.GONE);
                FoodmenuActivity.Pcount.setEnabled(false);
                FoodmenuActivity.Purchase.setEnabled(false);
                String Price = textView8th.getText().toString();
                onPriceSetListener.setPrice(Price);
                app.prev.remove("7");
                if (!imageButton8th.isShown() && imageButton.isShown() || imageButton2nd.isShown()
                        || imageButton3rd.isShown() || imageButton4th.isShown() || imageButton5th.isShown()
                        || imageButton6th.isShown() || imageButton7th.isShown() || imageButton9th.isShown()
                        || imageButton10th.isShown() || imageButton11th.isShown() || imageButton12th.isShown()
                        || imageButton13th.isShown() || imageButton14th.isShown() || imageButton15th.isShown()
                        || imageButton16th.isShown() || imageButton17th.isShown() || imageButton18th.isShown()
                        || imageButton19th.isShown() || imageButton20th.isShown() || imageButton21st.isShown()) {
                    FoodmenuActivity.Pcount.setEnabled(true);
                    FoodmenuActivity.Purchase.setEnabled(true);
                }
            }
        });

        imageButton9th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView9th.setVisibility(View.GONE);
                imageButton9th.setVisibility(View.GONE);
                FoodmenuActivity.Pcount.setEnabled(false);
                FoodmenuActivity.Purchase.setEnabled(false);
                String Price = textView9th.getText().toString();
                onPriceSetListener.setPrice(Price);
                app.prev.remove("8");
                if (!imageButton9th.isShown() && imageButton.isShown() || imageButton2nd.isShown()
                        || imageButton3rd.isShown() || imageButton4th.isShown() || imageButton5th.isShown()
                        || imageButton6th.isShown() || imageButton7th.isShown() || imageButton8th.isShown()
                        || imageButton10th.isShown() || imageButton11th.isShown() || imageButton12th.isShown()
                        || imageButton13th.isShown() || imageButton14th.isShown() || imageButton15th.isShown()
                        || imageButton16th.isShown() || imageButton17th.isShown() || imageButton18th.isShown()
                        || imageButton19th.isShown() || imageButton20th.isShown() || imageButton21st.isShown()) {
                    FoodmenuActivity.Pcount.setEnabled(true);
                    FoodmenuActivity.Purchase.setEnabled(true);
                }

            }
        });

        imageButton10th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView10th.setVisibility(View.GONE);
                imageButton10th.setVisibility(View.GONE);
                FoodmenuActivity.Pcount.setEnabled(false);
                FoodmenuActivity.Purchase.setEnabled(false);
                String Price = textView10th.getText().toString();
                onPriceSetListener.setPrice(Price);
                app.prev.remove("9");
                if (!imageButton10th.isShown() && imageButton.isShown() || imageButton2nd.isShown()
                        || imageButton3rd.isShown() || imageButton4th.isShown() || imageButton5th.isShown()
                        || imageButton6th.isShown() || imageButton7th.isShown() || imageButton8th.isShown()
                        || imageButton9th.isShown() || imageButton11th.isShown() || imageButton12th.isShown()
                        || imageButton13th.isShown() || imageButton14th.isShown() || imageButton15th.isShown()
                        || imageButton16th.isShown() || imageButton17th.isShown() || imageButton18th.isShown()
                        || imageButton19th.isShown() || imageButton20th.isShown() || imageButton21st.isShown()) {
                    FoodmenuActivity.Pcount.setEnabled(true);
                    FoodmenuActivity.Purchase.setEnabled(true);
                }
            }
        });

        imageButton11th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView11th.setVisibility(View.GONE);
                imageButton11th.setVisibility(View.GONE);
                FoodmenuActivity.Pcount.setEnabled(false);
                FoodmenuActivity.Purchase.setEnabled(false);
                String Price = textView11th.getText().toString();
                onPriceSetListener.setPrice(Price);
                app.prev.remove("10");
                if (!imageButton11th.isShown() && imageButton2nd.isShown() || imageButton3rd.isShown()
                        || imageButton4th.isShown() || imageButton5th.isShown() || imageButton6th.isShown()
                        || imageButton7th.isShown() || imageButton8th.isShown() || imageButton9th.isShown()
                        || imageButton10th.isShown() ||imageButton.isShown() || imageButton12th.isShown()
                        || imageButton13th.isShown() || imageButton14th.isShown() || imageButton15th.isShown()
                        || imageButton16th.isShown() || imageButton17th.isShown() || imageButton18th.isShown()
                        || imageButton19th.isShown() || imageButton20th.isShown() || imageButton21st.isShown()) {
                    FoodmenuActivity.Pcount.setEnabled(true);
                    FoodmenuActivity.Purchase.setEnabled(true);
                }
            }
        });

        imageButton12th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView12th.setVisibility(View.GONE);
                imageButton12th.setVisibility(View.GONE);
                FoodmenuActivity.Pcount.setEnabled(false);
                FoodmenuActivity.Purchase.setEnabled(false);
                String Price = textView12th.getText().toString();
                onPriceSetListener.setPrice(Price);
                app.prev.remove("11");
                if (!imageButton12th.isShown() && imageButton.isShown() || imageButton3rd.isShown()
                        || imageButton4th.isShown() || imageButton5th.isShown() || imageButton6th.isShown()
                        || imageButton7th.isShown() || imageButton8th.isShown() || imageButton9th.isShown()
                        || imageButton10th.isShown() ||imageButton11th.isShown() || imageButton2nd.isShown()
                        || imageButton13th.isShown() || imageButton14th.isShown() || imageButton15th.isShown()
                        || imageButton16th.isShown() || imageButton17th.isShown() || imageButton18th.isShown()
                        || imageButton19th.isShown() || imageButton20th.isShown() || imageButton21st.isShown()) {
                    FoodmenuActivity.Pcount.setEnabled(true);
                    FoodmenuActivity.Purchase.setEnabled(true);
                }
            }
        });

        imageButton13th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView13th.setVisibility(View.GONE);
                imageButton13th.setVisibility(View.GONE);
                FoodmenuActivity.Pcount.setEnabled(false);
                FoodmenuActivity.Purchase.setEnabled(false);
                String Price = textView13th.getText().toString();
                onPriceSetListener.setPrice(Price);
                app.prev.remove("12");
                if (!imageButton13th.isShown() && imageButton.isShown() || imageButton2nd.isShown()
                        || imageButton4th.isShown() || imageButton5th.isShown() || imageButton6th.isShown()
                        || imageButton7th.isShown() || imageButton8th.isShown() || imageButton9th.isShown()
                        || imageButton10th.isShown() ||imageButton11th.isShown() || imageButton12th.isShown()
                        || imageButton3rd.isShown() || imageButton14th.isShown() || imageButton15th.isShown()
                        || imageButton16th.isShown() || imageButton17th.isShown() || imageButton18th.isShown()
                        || imageButton19th.isShown() || imageButton20th.isShown() || imageButton21st.isShown()) {
                    FoodmenuActivity.Pcount.setEnabled(true);
                    FoodmenuActivity.Purchase.setEnabled(true);
                }
            }
        });

        imageButton14th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView14th.setVisibility(View.GONE);
                imageButton14th.setVisibility(View.GONE);
                FoodmenuActivity.Pcount.setEnabled(false);
                FoodmenuActivity.Purchase.setEnabled(false);
                String Price = textView14th.getText().toString();
                onPriceSetListener.setPrice(Price);
                app.prev.remove("13");
                if (!imageButton14th.isShown() && imageButton.isShown() || imageButton2nd.isShown()
                        || imageButton3rd.isShown() || imageButton5th.isShown() || imageButton6th.isShown()
                        || imageButton7th.isShown() || imageButton8th.isShown() || imageButton9th.isShown()
                        || imageButton10th.isShown() ||imageButton11th.isShown() || imageButton12th.isShown()
                        || imageButton13th.isShown() || imageButton4th.isShown() || imageButton15th.isShown()
                        || imageButton16th.isShown() || imageButton17th.isShown() || imageButton18th.isShown()
                        || imageButton19th.isShown() || imageButton20th.isShown() || imageButton21st.isShown()) {
                    FoodmenuActivity.Pcount.setEnabled(true);
                    FoodmenuActivity.Purchase.setEnabled(true);
                }
            }
        });

        imageButton15th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView15th.setVisibility(View.GONE);
                imageButton15th.setVisibility(View.GONE);
                FoodmenuActivity.Pcount.setEnabled(false);
                FoodmenuActivity.Purchase.setEnabled(false);
                String Price = textView15th.getText().toString();
                onPriceSetListener.setPrice(Price);
                app.prev.remove("14");
                if (!imageButton15th.isShown() && imageButton.isShown() || imageButton2nd.isShown()
                        || imageButton3rd.isShown() || imageButton4th.isShown() || imageButton6th.isShown()
                        || imageButton7th.isShown() || imageButton8th.isShown() || imageButton9th.isShown()
                        || imageButton10th.isShown() ||imageButton11th.isShown() || imageButton12th.isShown()
                        || imageButton13th.isShown() || imageButton14th.isShown() || imageButton5th.isShown()
                        || imageButton16th.isShown() || imageButton17th.isShown() || imageButton18th.isShown()
                        || imageButton19th.isShown() || imageButton20th.isShown() || imageButton21st.isShown()) {
                    FoodmenuActivity.Pcount.setEnabled(true);
                    FoodmenuActivity.Purchase.setEnabled(true);
                }
            }
        });

        imageButton16th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView16th.setVisibility(View.GONE);
                imageButton16th.setVisibility(View.GONE);
                FoodmenuActivity.Pcount.setEnabled(false);
                FoodmenuActivity.Purchase.setEnabled(false);
                String Price = textView16th.getText().toString();
                onPriceSetListener.setPrice(Price);
                app.prev.remove("15");
                if (!imageButton16th.isShown() && imageButton.isShown() || imageButton2nd.isShown()
                        || imageButton3rd.isShown() || imageButton4th.isShown() || imageButton5th.isShown()
                        || imageButton7th.isShown() || imageButton8th.isShown() || imageButton9th.isShown()
                        || imageButton10th.isShown() ||imageButton11th.isShown() || imageButton12th.isShown()
                        || imageButton13th.isShown() || imageButton14th.isShown() || imageButton15th.isShown()
                        || imageButton16th.isShown() || imageButton17th.isShown() || imageButton18th.isShown()
                        || imageButton19th.isShown() || imageButton20th.isShown() || imageButton21st.isShown()) {
                    FoodmenuActivity.Pcount.setEnabled(true);
                    FoodmenuActivity.Purchase.setEnabled(true);
                }
            }
        });

        imageButton17th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView17th.setVisibility(View.GONE);
                imageButton17th.setVisibility(View.GONE);
                FoodmenuActivity.Pcount.setEnabled(false);
                FoodmenuActivity.Purchase.setEnabled(false);
                String Price = textView17th.getText().toString();
                onPriceSetListener.setPrice(Price);
                app.prev.remove("16");
                if (!imageButton17th.isShown() && imageButton.isShown() || imageButton2nd.isShown()
                        || imageButton3rd.isShown() || imageButton4th.isShown() || imageButton5th.isShown()
                        || imageButton6th.isShown() || imageButton8th.isShown() || imageButton9th.isShown()
                        || imageButton10th.isShown() ||imageButton11th.isShown() || imageButton12th.isShown()
                        || imageButton13th.isShown() || imageButton14th.isShown() || imageButton15th.isShown()
                        || imageButton16th.isShown() || imageButton7th.isShown() || imageButton18th.isShown()
                        || imageButton19th.isShown() || imageButton20th.isShown() || imageButton21st.isShown()) {
                    FoodmenuActivity.Pcount.setEnabled(true);
                    FoodmenuActivity.Purchase.setEnabled(true);
                }
            }
        });

        imageButton18th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView18th.setVisibility(View.GONE);
                imageButton18th.setVisibility(View.GONE);
                FoodmenuActivity.Pcount.setEnabled(false);
                FoodmenuActivity.Purchase.setEnabled(false);
                String Price = textView18th.getText().toString();
                onPriceSetListener.setPrice(Price);
                app.prev.remove("17");
                if (!imageButton18th.isShown() && imageButton.isShown() || imageButton2nd.isShown()
                        || imageButton3rd.isShown() || imageButton4th.isShown() || imageButton5th.isShown()
                        || imageButton6th.isShown() || imageButton7th.isShown() || imageButton9th.isShown()
                        || imageButton10th.isShown() ||imageButton11th.isShown() || imageButton12th.isShown()
                        || imageButton13th.isShown() || imageButton14th.isShown() || imageButton15th.isShown()
                        || imageButton16th.isShown() || imageButton17th.isShown() || imageButton8th.isShown()
                        || imageButton19th.isShown() || imageButton20th.isShown() || imageButton21st.isShown()) {
                    FoodmenuActivity.Pcount.setEnabled(true);
                    FoodmenuActivity.Purchase.setEnabled(true);
                }
            }
        });

        imageButton19th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView19th.setVisibility(View.GONE);
                imageButton19th.setVisibility(View.GONE);
                FoodmenuActivity.Pcount.setEnabled(false);
                FoodmenuActivity.Purchase.setEnabled(false);
                String Price = textView19th.getText().toString();
                onPriceSetListener.setPrice(Price);
                app.prev.remove("18");
                if (!imageButton19th.isShown() && imageButton.isShown() || imageButton2nd.isShown()
                        || imageButton3rd.isShown() || imageButton4th.isShown() || imageButton5th.isShown()
                        || imageButton6th.isShown() || imageButton7th.isShown() || imageButton8th.isShown()
                        || imageButton10th.isShown() ||imageButton11th.isShown() || imageButton12th.isShown()
                        || imageButton13th.isShown() || imageButton14th.isShown() || imageButton15th.isShown()
                        || imageButton16th.isShown() || imageButton17th.isShown() || imageButton18th.isShown()
                        || imageButton9th.isShown() || imageButton20th.isShown() || imageButton21st.isShown()) {
                    FoodmenuActivity.Pcount.setEnabled(true);
                    FoodmenuActivity.Purchase.setEnabled(true);
                }

            }
        });

        imageButton20th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView20th.setVisibility(View.GONE);
                imageButton20th.setVisibility(View.GONE);
                FoodmenuActivity.Pcount.setEnabled(false);
                FoodmenuActivity.Purchase.setEnabled(false);
                String Price = textView20th.getText().toString();
                onPriceSetListener.setPrice(Price);
                app.prev.remove("19");
                if (!imageButton20th.isShown() && imageButton.isShown() || imageButton2nd.isShown()
                        || imageButton3rd.isShown() || imageButton4th.isShown() || imageButton5th.isShown()
                        || imageButton6th.isShown() || imageButton7th.isShown() || imageButton8th.isShown()
                        || imageButton9th.isShown() ||imageButton11th.isShown() || imageButton12th.isShown()
                        || imageButton13th.isShown() || imageButton14th.isShown() || imageButton15th.isShown()
                        || imageButton16th.isShown() || imageButton17th.isShown() || imageButton18th.isShown()
                        || imageButton19th.isShown() || imageButton10th.isShown() || imageButton21st.isShown()) {
                    FoodmenuActivity.Pcount.setEnabled(true);
                    FoodmenuActivity.Purchase.setEnabled(true);
                }
            }
        });



        imageButton21st.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView21st.setVisibility(View.GONE);
                imageButton21st.setVisibility(View.GONE);
                FoodmenuActivity.Pcount.setEnabled(false);
                FoodmenuActivity.Purchase.setEnabled(false);
                String Price = textView21st.getText().toString();
                onPriceSetListener.setPrice(Price);
                app.prev.remove("20");
                if (!imageButton21st.isShown() && imageButton2nd.isShown() || imageButton3rd.isShown()
                        || imageButton4th.isShown() || imageButton5th.isShown() || imageButton6th.isShown()
                        || imageButton7th.isShown() || imageButton8th.isShown() || imageButton9th.isShown()
                        || imageButton10th.isShown() || imageButton11th.isShown() || imageButton12th.isShown()
                        || imageButton13th.isShown() || imageButton14th.isShown() || imageButton15th.isShown()
                        || imageButton16th.isShown() || imageButton17th.isShown() || imageButton18th.isShown()
                        || imageButton19th.isShown() || imageButton20th.isShown()  || imageButton.isShown()) {
                    FoodmenuActivity.Pcount.setEnabled(true);
                    FoodmenuActivity.Purchase.setEnabled(true);
                }
            }
        });



        if (name.contentEquals("150 naira White Rice")) {
            textView.setText(name);
            textView.setVisibility(View.VISIBLE);
            imageButton.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("200 naira White Rice")) {
            textView.setText(name);
            textView.setVisibility(View.VISIBLE);
            imageButton.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("250 naira White Rice")) {
            textView.setText(name);
            textView.setVisibility(View.VISIBLE);
            imageButton.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("300 naira White Rice")) {
            textView.setText(name);
            textView.setVisibility(View.VISIBLE);
            imageButton.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("350 naira White Rice")) {
            textView.setText(name);
            textView.setVisibility(View.VISIBLE);
            imageButton.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("400 naira White Rice")) {
            textView.setText(name);
            textView.setVisibility(View.VISIBLE);
            imageButton.setVisibility(View.VISIBLE);
        }

        if (name.contentEquals("150 naira Jollof Rice")) {
            textView2nd.setText(name);
            textView2nd.setVisibility(View.VISIBLE);
            imageButton2nd.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("200 naira Jollof Rice")) {
            textView2nd.setText(name);
            textView2nd.setVisibility(View.VISIBLE);
            imageButton2nd.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("250 naira Jollof Rice")) {
            textView2nd.setText(name);
            textView2nd.setVisibility(View.VISIBLE);
            imageButton2nd.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("300 naira Jollof Rice")) {
            textView2nd.setText(name);
            textView2nd.setVisibility(View.VISIBLE);
            imageButton2nd.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("350 naira Jollof Rice")) {
            textView2nd.setText(name);
            textView2nd.setVisibility(View.VISIBLE);
            imageButton2nd.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("400 naira Jollof Rice")) {
            textView2nd.setText(name);
            textView2nd.setVisibility(View.VISIBLE);
            imageButton2nd.setVisibility(View.VISIBLE);
        }

        if (name.contentEquals("150 naira Fried Rice")) {
            textView3rd.setText(name);
            textView3rd.setVisibility(View.VISIBLE);
            imageButton3rd.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("200 naira Fried Rice")) {
            textView3rd.setText(name);
            textView3rd.setVisibility(View.VISIBLE);
            imageButton3rd.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("250 naira Fried Rice")) {
            textView3rd.setText(name);
            textView3rd.setVisibility(View.VISIBLE);
            imageButton3rd.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("300 naira Fried Rice")) {
            textView3rd.setText(name);
            textView3rd.setVisibility(View.VISIBLE);
            imageButton3rd.setVisibility(View.VISIBLE);
        }  else if (name.contentEquals("350 naira Fried Rice")) {
            textView3rd.setText(name);
            textView3rd.setVisibility(View.VISIBLE);
            imageButton3rd.setVisibility(View.VISIBLE);
        }  else if (name.contentEquals("400 naira Fried Rice")) {
            textView3rd.setText(name);
            textView3rd.setVisibility(View.VISIBLE);
            imageButton3rd.setVisibility(View.VISIBLE);
        }

        if (name.contentEquals("150 naira Vegatable Rice")) {
            textView4th.setText(name);
            textView4th.setVisibility(View.VISIBLE);
            imageButton4th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("200 naira Vegatable Rice")) {
            textView4th.setText(name);
            textView4th.setVisibility(View.VISIBLE);
            imageButton4th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("250 naira Vegatable Rice")) {
            textView4th.setText(name);
            textView4th.setVisibility(View.VISIBLE);
            imageButton4th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("300 naira Vegatable Rice")) {
            textView4th.setText(name);
            textView4th.setVisibility(View.VISIBLE);
            imageButton4th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("350 naira Vegatable Rice")) {
            textView4th.setText(name);
            textView4th.setVisibility(View.VISIBLE);
            imageButton4th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("400 naira Vegatable Rice")) {
            textView4th.setText(name);
            textView4th.setVisibility(View.VISIBLE);
            imageButton4th.setVisibility(View.VISIBLE);
        }

        if (name.contentEquals("150 naira Coconut Rice")) {
            textView5th.setText(name);
            textView5th.setVisibility(View.VISIBLE);
            imageButton5th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("200 naira Coconut Rice")) {
            textView5th.setText(name);
            textView5th.setVisibility(View.VISIBLE);
            imageButton5th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("250 naira Coconut Rice")) {
            textView5th.setText(name);
            textView5th.setVisibility(View.VISIBLE);
            imageButton5th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("300 naira Coconut Rice")) {
            textView5th.setText(name);
            textView5th.setVisibility(View.VISIBLE);
            imageButton5th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("350 naira Coconut Rice")) {
            textView5th.setText(name);
            textView5th.setVisibility(View.VISIBLE);
            imageButton5th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("400 naira Coconut Rice")) {
            textView5th.setText(name);
            textView5th.setVisibility(View.VISIBLE);
            imageButton5th.setVisibility(View.VISIBLE);
        }

        if (name.contentEquals("100 naira Small Beef")) {
            textView6th.setText(name);
            textView6th.setVisibility(View.VISIBLE);
            imageButton6th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("200 naira Small Beef(2)")) {
            textView6th.setText(name);
            textView6th.setVisibility(View.VISIBLE);
            imageButton6th.setVisibility(View.VISIBLE);
        }  else if (name.contentEquals("300 naira Small Beef(3)")) {
            textView6th.setText(name);
            textView6th.setVisibility(View.VISIBLE);
            imageButton6th.setVisibility(View.VISIBLE);
        }  else if (name.contentEquals("400 naira Small Beef(4)")) {
            textView6th.setText(name);
            textView6th.setVisibility(View.VISIBLE);
            imageButton6th.setVisibility(View.VISIBLE);
        }  else if (name.contentEquals("500 naira Small Beef(5)")) {
            textView6th.setText(name);
            textView6th.setVisibility(View.VISIBLE);
            imageButton6th.setVisibility(View.VISIBLE);
        }  else if (name.contentEquals("600 naira Small Beef(6)")) {
            textView6th.setText(name);
            textView6th.setVisibility(View.VISIBLE);
            imageButton6th.setVisibility(View.VISIBLE);
        }


        if (name.contentEquals("200 naira Big Beef")) {
            textView7th.setText(name);
            textView7th.setVisibility(View.VISIBLE);
            imageButton7th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("400 naira Big Beef(2)")) {
            textView7th.setText(name);
            textView7th.setVisibility(View.VISIBLE);
            imageButton7th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("600 naira Big Beef(3)")) {
            textView7th.setText(name);
            textView7th.setVisibility(View.VISIBLE);
            imageButton7th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("800 naira Big Beef(4)")) {
            textView7th.setText(name);
            textView7th.setVisibility(View.VISIBLE);
            imageButton7th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("1000 naira Big Beef(5)")) {
            textView7th.setText(name);
            textView7th.setVisibility(View.VISIBLE);
            imageButton7th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("1200 naira Small Beef(6)")) {
            textView7th.setText(name);
            textView7th.setVisibility(View.VISIBLE);
            imageButton7th.setVisibility(View.VISIBLE);
        }


        if (name.contentEquals("100 naira Assorted Meat")) {
            textView8th.setText(name);
            textView8th.setVisibility(View.VISIBLE);
            imageButton8th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("200 naira Assorted Meat(2)")) {
            textView8th.setText(name);
            textView8th.setVisibility(View.VISIBLE);
            imageButton8th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("300 naira Assorted Meat(3)")) {
            textView8th.setText(name);
            textView8th.setVisibility(View.VISIBLE);
            imageButton8th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("400 naira Assorted Meat(4)")) {
            textView8th.setText(name);
            textView8th.setVisibility(View.VISIBLE);
            imageButton8th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("500 naira Assorted Meat(5)")) {
            textView8th.setText(name);
            textView8th.setVisibility(View.VISIBLE);
            imageButton8th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("600 naira Assorted Meat(6)")) {
            textView8th.setText(name);
            textView8th.setVisibility(View.VISIBLE);
            imageButton8th.setVisibility(View.VISIBLE);
        }

        if (name.contentEquals("50 naira Ponmo")) {
            textView9th.setText(name);
            textView9th.setVisibility(View.VISIBLE);
            imageButton9th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("100 naira Ponmo(2)")) {
            textView9th.setText(name);
            textView9th.setVisibility(View.VISIBLE);
            imageButton9th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("150 naira Ponmo(3)")) {
            textView9th.setText(name);
            textView9th.setVisibility(View.VISIBLE);
            imageButton9th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("200 naira Ponmo(4)")) {
            textView9th.setText(name);
            textView9th.setVisibility(View.VISIBLE);
            imageButton9th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("250 naira Ponmo(5)")) {
            textView9th.setText(name);
            textView9th.setVisibility(View.VISIBLE);
            imageButton9th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("250 naira Ponmo(6)")) {
            textView9th.setText(name);
            textView9th.setVisibility(View.VISIBLE);
            imageButton9th.setVisibility(View.VISIBLE);
        }

        if (name.contentEquals("200 naira Small Chicken")) {
            textView10th.setText(name);
            textView10th.setVisibility(View.VISIBLE);
            imageButton10th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("400 naira Small Chicken(2)")) {
            textView10th.setText(name);
            textView10th.setVisibility(View.VISIBLE);
            imageButton10th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("600 naira Small Chicken(3)")) {
            textView10th.setText(name);
            textView10th.setVisibility(View.VISIBLE);
            imageButton10th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("800 naira Small Chicken(4)")) {
            textView10th.setText(name);
            textView10th.setVisibility(View.VISIBLE);
            imageButton10th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("1000 naira Small Chicken(5)")) {
            textView10th.setText(name);
            textView10th.setVisibility(View.VISIBLE);
            imageButton10th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("1200 naira Small Chicken(6)")) {
            textView10th.setText(name);
            textView10th.setVisibility(View.VISIBLE);
            imageButton10th.setVisibility(View.VISIBLE);
        }

        if (name.contentEquals("300 naira Big Chicken")) {
            textView11th.setText(name);
            textView11th.setVisibility(View.VISIBLE);
            imageButton11th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("600 naira Big Chicken(2)")) {
            textView11th.setText(name);
            textView11th.setVisibility(View.VISIBLE);
            imageButton11th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("900 naira Big Chicken(3)")) {
            textView11th.setText(name);
            textView11th.setVisibility(View.VISIBLE);
            imageButton11th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("1200 naira Big Chicken(4)")) {
            textView11th.setText(name);
            textView11th.setVisibility(View.VISIBLE);
            imageButton11th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("1500 naira Big Chicken(5)")) {
            textView11th.setText(name);
            textView11th.setVisibility(View.VISIBLE);
            imageButton11th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("1800 naira Big Chicken(6)")) {
            textView11th.setText(name);
            textView11th.setVisibility(View.VISIBLE);
            imageButton11th.setVisibility(View.VISIBLE);
        }

        if (name.contentEquals("200 naira Small Goatmeat")) {
            textView12th.setText(name);
            textView12th.setVisibility(View.VISIBLE);
            imageButton12th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("400 naira Small Goatmeat(2)")) {
            textView12th.setText(name);
            textView12th.setVisibility(View.VISIBLE);
            imageButton12th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("600 naira Small Goatmeat(3)")) {
            textView12th.setText(name);
            textView12th.setVisibility(View.VISIBLE);
            imageButton12th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("800 naira Small Goatmeat(4)")) {
            textView12th.setText(name);
            textView12th.setVisibility(View.VISIBLE);
            imageButton12th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("1000 naira Small Goatmeat(5)")) {
            textView12th.setText(name);
            textView12th.setVisibility(View.VISIBLE);
            imageButton12th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("1200 naira Small Goatmeat(6)")) {
            textView12th.setText(name);
            textView12th.setVisibility(View.VISIBLE);
            imageButton12th.setVisibility(View.VISIBLE);
        }

        if (name.contentEquals("300 naira Big Goatmeat")) {
            textView13th.setText(name);
            textView13th.setVisibility(View.VISIBLE);
            imageButton13th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("600 naira Big Goatmeat(2)")) {
            textView13th.setText(name);
            textView13th.setVisibility(View.VISIBLE);
            imageButton13th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("900 naira Big Goatmeat(3)")) {
            textView13th.setText(name);
            textView13th.setVisibility(View.VISIBLE);
            imageButton13th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("1200 naira Big Goatmeat(4)")) {
            textView13th.setText(name);
            textView13th.setVisibility(View.VISIBLE);
            imageButton13th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("1500 naira Big Goatmeat(5)")) {
            textView13th.setText(name);
            textView13th.setVisibility(View.VISIBLE);
            imageButton13th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("1800 naira Big Goatmeat(6)")) {
            textView13th.setText(name);
            textView13th.setVisibility(View.VISIBLE);
            imageButton13th.setVisibility(View.VISIBLE);
        }

        if (name.contentEquals("100 naira Titus Fish")) {
            textView14th.setText(name);
            textView14th.setVisibility(View.VISIBLE);
            imageButton14th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("200 naira Titus Fish(2)")) {
            textView14th.setText(name);
            textView14th.setVisibility(View.VISIBLE);
            imageButton14th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("300 naira Titus Fish(3)")) {
            textView14th.setText(name);
            textView14th.setVisibility(View.VISIBLE);
            imageButton14th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("400 naira Titus Fish(4)")) {
            textView14th.setText(name);
            textView14th.setVisibility(View.VISIBLE);
            imageButton14th.setVisibility(View.VISIBLE);
        }  else if (name.contentEquals("500 naira Titus Fish(5)")) {
            textView14th.setText(name);
            textView14th.setVisibility(View.VISIBLE);
            imageButton14th.setVisibility(View.VISIBLE);
        }  else if (name.contentEquals("600 naira Titus Fish(6)")) {
            textView14th.setText(name);
            textView14th.setVisibility(View.VISIBLE);
            imageButton14th.setVisibility(View.VISIBLE);
        }

        if (name.contentEquals("100 naira Sawa Fish")) {
            textView15th.setText(name);
            textView15th.setVisibility(View.VISIBLE);
            imageButton15th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("200 naira Sawa Fish(2)")) {
            textView15th.setText(name);
            textView15th.setVisibility(View.VISIBLE);
            imageButton15th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("300 naira Sawa Fish(3)")) {
            textView15th.setText(name);
            textView15th.setVisibility(View.VISIBLE);
            imageButton15th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("400 naira Sawa Fish(4)")) {
            textView15th.setText(name);
            textView15th.setVisibility(View.VISIBLE);
            imageButton15th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("500 naira Sawa Fish(5)")) {
            textView15th.setText(name);
            textView15th.setVisibility(View.VISIBLE);
            imageButton15th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("600 naira Sawa Fish(6)")) {
            textView15th.setText(name);
            textView15th.setVisibility(View.VISIBLE);
            imageButton15th.setVisibility(View.VISIBLE);
        }

        if (name.contentEquals("100 naira Panla Fish")) {
            textView16th.setText(name);
            textView16th.setVisibility(View.VISIBLE);
            imageButton16th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("200 naira Panla Fish(2)")) {
            textView16th.setText(name);
            textView16th.setVisibility(View.VISIBLE);
            imageButton16th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("300 naira Panla Fish(3)")) {
            textView16th.setText(name);
            textView16th.setVisibility(View.VISIBLE);
            imageButton16th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("400 naira Panla Fish(4)")) {
            textView16th.setText(name);
            textView16th.setVisibility(View.VISIBLE);
            imageButton16th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("500 naira Panla Fish(5)")) {
            textView16th.setText(name);
            textView16th.setVisibility(View.VISIBLE);
            imageButton16th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("600 naira Panla Fish(6)")) {
            textView16th.setText(name);
            textView16th.setVisibility(View.VISIBLE);
            imageButton16th.setVisibility(View.VISIBLE);
        }

        if (name.contentEquals("100 naira MoiMoi")) {
            textView17th.setText(name);
            textView17th.setVisibility(View.VISIBLE);
            imageButton17th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("200 naira MoiMoi(2)")) {
            textView17th.setText(name);
            textView17th.setVisibility(View.VISIBLE);
            imageButton17th.setVisibility(View.VISIBLE);
        }  else if (name.contentEquals("300 naira MoiMoi(3)")) {
            textView17th.setText(name);
            textView17th.setVisibility(View.VISIBLE);
            imageButton17th.setVisibility(View.VISIBLE);
        }  else if (name.contentEquals("400 naira MoiMoi(4)")) {
            textView17th.setText(name);
            textView17th.setVisibility(View.VISIBLE);
            imageButton17th.setVisibility(View.VISIBLE);
        }  else if (name.contentEquals("500 naira MoiMoi(5)")) {
            textView17th.setText(name);
            textView17th.setVisibility(View.VISIBLE);
            imageButton17th.setVisibility(View.VISIBLE);
        }  else if (name.contentEquals("600 naira MoiMoi(6)")) {
            textView17th.setText(name);
            textView17th.setVisibility(View.VISIBLE);
            imageButton17th.setVisibility(View.VISIBLE);
        }

        if (name.contentEquals("50 naira Plantain")) {
            textView18th.setText(name);
            textView18th.setVisibility(View.VISIBLE);
            imageButton18th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("100 naira Plantain")) {
            textView18th.setText(name);
            textView18th.setVisibility(View.VISIBLE);
            imageButton18th.setVisibility(View.VISIBLE);
        }  else if (name.contentEquals("150 naira Plantain")) {
            textView18th.setText(name);
            textView18th.setVisibility(View.VISIBLE);
            imageButton18th.setVisibility(View.VISIBLE);
        }  else if (name.contentEquals("200 naira Plantain")) {
            textView18th.setText(name);
            textView18th.setVisibility(View.VISIBLE);
            imageButton18th.setVisibility(View.VISIBLE);
        }  else if (name.contentEquals("250 naira Plantain")) {
            textView18th.setText(name);
            textView18th.setVisibility(View.VISIBLE);
            imageButton18th.setVisibility(View.VISIBLE);
        }  else if (name.contentEquals("300 naira Plantain")) {
            textView18th.setText(name);
            textView18th.setVisibility(View.VISIBLE);
            imageButton18th.setVisibility(View.VISIBLE);
        }

        if (name.contentEquals("50 naira Boiled Egg")) {
            textView19th.setText(name);
            textView19th.setVisibility(View.VISIBLE);
            imageButton19th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("100 naira Boiled Egg(2)")) {
            textView19th.setText(name);
            textView19th.setVisibility(View.VISIBLE);
            imageButton19th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("150 naira Boiled Egg(3)")) {
            textView19th.setText(name);
            textView19th.setVisibility(View.VISIBLE);
            imageButton19th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("200 naira Boiled Egg(4)")) {
            textView19th.setText(name);
            textView19th.setVisibility(View.VISIBLE);
            imageButton19th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("250 naira Boiled Egg(5)")) {
            textView19th.setText(name);
            textView19th.setVisibility(View.VISIBLE);
            imageButton19th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("300 naira Boiled Egg(6)")) {
            textView19th.setText(name);
            textView19th.setVisibility(View.VISIBLE);
            imageButton19th.setVisibility(View.VISIBLE);
        }

        if (name.contentEquals("100 naira Coleslaw")) {
            textView20th.setText(name);
            textView20th.setVisibility(View.VISIBLE);
            imageButton20th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("150 naira Coleslaw")) {
            textView20th.setText(name);
            textView20th.setVisibility(View.VISIBLE);
            imageButton20th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("200 naira Coleslaw")) {
            textView20th.setText(name);
            textView20th.setVisibility(View.VISIBLE);
            imageButton20th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("250 naira Coleslaw")) {
            textView20th.setText(name);
            textView20th.setVisibility(View.VISIBLE);
            imageButton20th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("300 naira Coleslaw")) {
            textView20th.setText(name);
            textView20th.setVisibility(View.VISIBLE);
            imageButton20th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("350 naira Coleslaw")) {
            textView20th.setText(name);
            textView20th.setVisibility(View.VISIBLE);
            imageButton20th.setVisibility(View.VISIBLE);
        }

        if (name.contentEquals("100 naira WhiteBeans")) {
            textView21st.setText(name);
            textView21st.setVisibility(View.VISIBLE);
            imageButton21st.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("150 naira WhiteBeans")) {
            textView21st.setText(name);
            textView21st.setVisibility(View.VISIBLE);
            imageButton21st.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("200 naira WhiteBeans")) {
            textView21st.setText(name);
            textView21st.setVisibility(View.VISIBLE);
            imageButton21st.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("250 naira WhiteBeans")) {
            textView21st.setText(name);
            textView21st.setVisibility(View.VISIBLE);
            imageButton21st.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("300 naira WhiteBeans")) {
            textView21st.setText(name);
            textView21st.setVisibility(View.VISIBLE);
            imageButton21st.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("350 naira WhiteBeans")) {
            textView21st.setText(name);
            textView21st.setVisibility(View.VISIBLE);
            imageButton21st.setVisibility(View.VISIBLE);
        }

        FoodmenuActivity.Pcount.setText("" + "PLATE COUNT" + "");
    }
}
