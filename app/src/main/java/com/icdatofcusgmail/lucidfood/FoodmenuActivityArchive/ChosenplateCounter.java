package com.icdatofcusgmail.lucidfood.FoodmenuActivityArchive;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.icdatofcusgmail.lucidfood.R;

/**
 * Created by DAVID OGUNDEPO on 03/28/2017.
 *
 */

public class ChosenplateCounter extends Fragment {

    TextView count;
    TextView textView, textView2nd, textView3rd, textView4th, textView5th, textView6th, textView7th, textView8th, textView9th, textView10th;
    ImageButton imageButton, imageButton2nd, imageButton3rd, imageButton4th, imageButton5th, imageButton6th, imageButton7th, imageButton8th, imageButton9th, imageButton10th;
    Button button, button2, button3, button4, button5, button6;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.foodmenufragment5_chosenplate_counter, container, false);

        textView = (Button) view.findViewById(R.id.Istchosenbutton);
        textView2nd = (Button) view.findViewById(R.id.Secondchosenbutton);
        textView3rd = (Button) view.findViewById(R.id.Thirdchosenbutton);
        textView4th = (Button) view.findViewById(R.id.Fourthchosenbutton);
        textView5th = (Button) view.findViewById(R.id.Fifthchosenbutton);
        textView6th = (Button) view.findViewById(R.id.Sixthchosenbutton);
        textView7th = (Button) view.findViewById(R.id.Seventhchosenbutton);
        textView8th = (Button) view.findViewById(R.id.Eightchosenbutton);
        textView9th = (Button) view.findViewById(R.id.Ninthchosenbutton);
        textView10th = (Button) view.findViewById(R.id.Tenthchosenbutton);


        imageButton = (ImageButton) view.findViewById(R.id.Istchosendeletebutton);
        imageButton2nd = (ImageButton) view.findViewById(R.id.Secondchosendeletebutton);
        imageButton3rd = (ImageButton) view.findViewById(R.id.Thirdchosendeletebutton);
        imageButton4th = (ImageButton) view.findViewById(R.id.Fourthchosendeletebutton);
        imageButton5th = (ImageButton) view.findViewById(R.id.Fifthchosendeletebutton);
        imageButton6th = (ImageButton) view.findViewById(R.id.Sixthchosendeletebutton);
        imageButton7th = (ImageButton) view.findViewById(R.id.Seventhchosendeletebutton);
        imageButton8th = (ImageButton) view.findViewById(R.id.Eightchosendeletebutton);
        imageButton9th = (ImageButton) view.findViewById(R.id.Ninthchosendeleltebutton);
        imageButton10th = (ImageButton) view.findViewById(R.id.Tenthchosendeletebutton);


        return view;
    }

    public void updatePrice(String price) {
    }

    public void updateInfo(String price) {

        button = (Button) getActivity().findViewById(R.id.Istpricebutton);
        button2 = (Button) getActivity().findViewById(R.id.Secondpricebutton);
        button3 = (Button) getActivity().findViewById(R.id.Thirdpricebutton);
        button4 = (Button) getActivity().findViewById(R.id.Fourthpricebutton);
        button5 = (Button) getActivity().findViewById(R.id.Fifthpricebutton);
        button6 = (Button) getActivity().findViewById(R.id.Sixthpricebutton);
        count = (TextView) getActivity().findViewById(R.id.counter);

        count.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() >= 4)
                    count.setTextColor(Color.parseColor("#B71C1C"));
                else {
                    count.setTextColor(Color.parseColor("#000000"));
                }
            }
        });

        String s1, s2, s3, s4, s5, s6, s7, s8, s9, s10;
        String s1n, s2n, s3n, s4n, s5n, s6n, s7n, s8n, s9n, s10n;
        int n1, n2, n3, n4, n5, n6, n7, n8, n9, n10;
        int addupWhite = 0, addupJollof = 0, addupFried = 0, addupBeef = 0,
                addupChicken = 0, addupMoiMoi = 0, addupPlantain = 0, addupEgg = 0,
                addupColeslaw = 0, addupBeans = 0;


        if (price.contentEquals("150 naira White Rice")) {
            s1 = button.getText().toString();
            s1n = s1.substring(s1.indexOf(""), s1.indexOf(" naira White Rice"));
            n1 = Integer.parseInt(s1n);
               count.setText("" + s1n);
            addupWhite = +150;
        } else if (price.contentEquals("200 naira White Rice")) {
            s1 = button2.getText().toString();
            s1n = s1.substring(s1.indexOf(""), s1.indexOf(" naira White Rice"));
            n1 = Integer.parseInt(s1n);
                  count.setText("" + n1);
            addupWhite = +200;
        } else if (price.contentEquals("250 naira White Rice")) {
            s1 = button3.getText().toString();
            s1n = s1.substring(s1.indexOf(""), s1.indexOf(" naira White Rice"));
            n1 = Integer.parseInt(s1n);
                    count.setText("" + n1);
            addupWhite = +250;
        } else if (price.contentEquals("300 naira White Rice")) {
            s1 = button4.getText().toString();
            s1n = s1.substring(s1.indexOf(""), s1.indexOf(" naira White Rice"));
            n1 = Integer.parseInt(s1n);
                    count.setText("" + n1);
            addupWhite = +300;
        } else if (price.contentEquals("350 naira White Rice")) {
            s1 = button5.getText().toString();
            s1n = s1.substring(s1.indexOf(""), s1.indexOf(" naira White Rice"));
            n1 = Integer.parseInt(s1n);
                 count.setText("" + n1);
            addupWhite = +350;
        } else if (price.contentEquals("400 naira White Rice")) {
            s1 = button6.getText().toString();
            s1n = s1.substring(s1.indexOf(""), s1.indexOf(" naira White Rice"));
            n1 = Integer.parseInt(s1n);
                   count.setText("" + n1);
            addupWhite = +400;
        }

        if (price.contentEquals("150 naira Jollof Rice")) {
            s2 = button.getText().toString();
            s2n = s2.substring(s2.indexOf(""), s2.indexOf(" naira Jollof Rice"));
            n2 = Integer.parseInt(s2n);
                   count.setText("" + n2);
            addupJollof = +150;
        } else if (price.contentEquals("200 naira Jollof Rice")) {
            s2 = button2.getText().toString();
            s2n = s2.substring(s2.indexOf(""), s2.indexOf(" naira Jollof Rice"));
            n2 = Integer.parseInt(s2n);
                  count.setText("" + n2);
            addupJollof = +200;
        } else if (price.contentEquals("250 naira Jollof Rice")) {
            s2 = button3.getText().toString();
            s2n = s2.substring(s2.indexOf(""), s2.indexOf(" naira Jollof Rice"));
            n2 = Integer.parseInt(s2n);
                 count.setText("" + n2);
            addupJollof = +250;
        } else if (price.contentEquals("300 naira Jollof Rice")) {
            s2 = button4.getText().toString();
            s2n = s2.substring(s2.indexOf(""), s2.indexOf(" naira Jollof Rice"));
            n2 = Integer.parseInt(s2n);
                 count.setText("" + n2);
            addupJollof = +300;
        } else if (price.contentEquals("350 naira Jollof Rice")) {
            s2 = button5.getText().toString();
            s2n = s2.substring(s2.indexOf(""), s2.indexOf(" naira Jollof Rice"));
            n2 = Integer.parseInt(s2n);
                  count.setText("" + n2);
            addupJollof = +350;
        } else if (price.contentEquals("400 naira Jollof Rice")) {
            s2 = button6.getText().toString();
            s2n = s2.substring(s2.indexOf(""), s2.indexOf(" naira Jollof Rice"));
            n2 = Integer.parseInt(s2n);
                 count.setText("" + n2);
            addupJollof = +400;
        }

        if (price.contentEquals("150 naira Fried Rice")) {
            s3 = button.getText().toString();
            s3n = s3.substring(s3.indexOf(""), s3.indexOf(" naira Fried Rice"));
            n3 = Integer.parseInt(s3n);
                  count.setText("" + n3);
            addupFried = +150;
        } else if (price.contentEquals("200 naira Fried Rice")) {
            s3 = button2.getText().toString();
            s3n = s3.substring(s3.indexOf(""), s3.indexOf(" naira Fried Rice"));
            n3 = Integer.parseInt(s3n);
                 count.setText("" + n3);
            addupFried = +200;
        } else if (price.contentEquals("250 naira Fried Rice")) {
            s3 = button3.getText().toString();
            s3n = s3.substring(s3.indexOf(""), s3.indexOf(" naira Fried Rice"));
            n3 = Integer.parseInt(s3n);
                   count.setText("" + n3);
            addupFried = +250;
        } else if (price.contentEquals("300 naira Fried Rice")) {
            s3 = button4.getText().toString();
            s3n = s3.substring(s3.indexOf(""), s3.indexOf(" naira Fried Rice"));
            n3 = Integer.parseInt(s3n);
                  count.setText("" + n3);
            addupFried = +300;
        } else if (price.contentEquals("350 naira Fried Rice")) {
            s3 = button5.getText().toString();
            s3n = s3.substring(s3.indexOf(""), s3.indexOf(" naira Fried Rice"));
            n3 = Integer.parseInt(s3n);
                  count.setText("" + n3);
            addupFried = +350;
        } else if (price.contentEquals("400 naira Fried Rice")) {
            s3 = button6.getText().toString();
            s3n = s3.substring(s3.indexOf(""), s3.indexOf(" naira Fried Rice"));
            n3 = Integer.parseInt(s3n);
                  count.setText("" + n3);
            addupFried = +400;
        }

        if (price.contentEquals("100 naira Beef")) {
            s4 = button.getText().toString();
            s4n = s4.substring(s4.indexOf(""), s4.indexOf(" naira Beef"));
            n4 = Integer.parseInt(s4n);
                 count.setText("" + n4);
            addupBeef = +100;
        } else if (price.contentEquals("200 naira Beef(2)")) {
            s4 = button2.getText().toString();
            s4n = s4.substring(s4.indexOf(""), s4.indexOf(" naira Beef(2)"));
            n4 = Integer.parseInt(s4n);
                count.setText("" + n4);
            addupBeef = +200;
        } else if (price.contentEquals("300 naira Beef(3)")) {
            s4 = button3.getText().toString();
            s4n = s4.substring(s4.indexOf(""), s4.indexOf(" naira Beef(3)"));
            n4 = Integer.parseInt(s4n);
                  count.setText("" + n4);
            addupBeef = +300;
        } else if (price.contentEquals("400 naira Beef(4)")) {
            s4 = button4.getText().toString();
            s4n = s4.substring(s4.indexOf(""), s4.indexOf(" naira Beef(4)"));
            n4 = Integer.parseInt(s4n);
                    count.setText("" + n4);
            addupBeef = +400;
        } else if (price.contentEquals("500 naira Beef(5)")) {
            s4 = button5.getText().toString();
            s4n = s4.substring(s4.indexOf(""), s4.indexOf(" naira Beef(5)"));
            n4 = Integer.parseInt(s4n);
                 count.setText("" + n4);
            addupBeef = +500;
        } else if (price.contentEquals("600 naira Beef(6)")) {
            s4 = button6.getText().toString();
            s4n = s4.substring(s4.indexOf(""), s4.indexOf(" naira Beef(6)"));
            n4 = Integer.parseInt(s4n);
                   count.setText("" + n4);
            addupBeef = +600;
        }

        if (price.contentEquals("300 naira Chicken")) {
            s5 = button.getText().toString();
            s5n = s5.substring(s5.indexOf(""), s5.indexOf(" naira Chicken"));
            n5 = Integer.parseInt(s5n);
                   count.setText("" + n5);
            addupChicken = +300;
        } else if (price.contentEquals("600 naira Chicken(2)")) {
            s5 = button2.getText().toString();
            s5n = s5.substring(s5.indexOf(""), s5.indexOf(" naira Chicken(2)"));
            n5 = Integer.parseInt(s5n);
                  count.setText("" + n5);
            addupChicken = +600;
        } else if (price.contentEquals("900 naira Chicken(3)")) {
            s5 = button3.getText().toString();
            s5n = s5.substring(s5.indexOf(""), s5.indexOf(" naira Chicken(3)"));
            n5 = Integer.parseInt(s5n);
                   count.setText("" + n5);
            addupChicken = +900;
        } else if (price.contentEquals("1200 naira Chicken(4)")) {
            s5 = button4.getText().toString();
            s5n = s5.substring(s5.indexOf(""), s5.indexOf(" naira Chicken(4)"));
            n5 = Integer.parseInt(s5n);
                 count.setText("" + n5);
            addupChicken = +1200;
        } else if (price.contentEquals("1500 naira Chicken(5)")) {
            s5 = button5.getText().toString();
            s5n = s5.substring(s5.indexOf(""), s5.indexOf(" naira Chicken(5)"));
            n5 = Integer.parseInt(s5n);
                count.setText("" + n5);
            addupChicken = +1500;
        } else if (price.contentEquals("1800 naira Chicken(6)")) {
            s5 = button6.getText().toString();
            s5n = s5.substring(s5.indexOf(""), s5.indexOf(" naira Chicken(6)"));
            n5 = Integer.parseInt(s5n);
                  count.setText("" + n5);
            addupChicken = +1800;
        }

        if (price.contentEquals("100 naira MoiMoi")) {
            s6 = button.getText().toString();
            s6n = s6.substring(s6.indexOf(""), s6.indexOf(" naira MoiMoi"));
            n6 = Integer.parseInt(s6n);
                count.setText("" + n6);
            addupChicken = +100;
        } else if (price.contentEquals("200 naira MoiMoi(2)")) {
            s6 = button2.getText().toString();
            s6n = s6.substring(s6.indexOf(""), s6.indexOf(" naira MoiMoi(2)"));
            n6 = Integer.parseInt(s6n);
                  count.setText("" + n6);
            addupChicken = +200;
        } else if (price.contentEquals("300 naira MoiMoi(3)")) {
            s6 = button3.getText().toString();
            s6n = s6.substring(s6.indexOf(""), s6.indexOf(" naira MoiMoi(3)"));
            n6 = Integer.parseInt(s6n);
                   count.setText("" + n6);
            addupChicken = +300;
        } else if (price.contentEquals("400 naira MoiMoi(4)")) {
            s6 = button4.getText().toString();
            s6n = s6.substring(s6.indexOf(""), s6.indexOf(" naira MoiMoi(4)"));
            n6 = Integer.parseInt(s6n);
                 count.setText("" + n6);
            addupChicken = +400;
        } else if (price.contentEquals("500 naira MoiMoi(5)")) {
            s6 = button5.getText().toString();
            s6n = s6.substring(s6.indexOf(""), s6.indexOf(" naira MoiMoi(5)"));
            n6 = Integer.parseInt(s6n);
                  count.setText("" + n6);
            addupChicken = +500;
        } else if (price.contentEquals("600 naira MoiMoi(6)")) {
            s6 = button6.getText().toString();
            s6n = s6.substring(s6.indexOf(""), s6.indexOf(" naira MoiMoi(6)"));
            n6 = Integer.parseInt(s6n);
                 count.setText("" + n6);
            addupChicken = +600;
        }

        if (price.contentEquals("50 naira Plantain")) {
            s7 = button.getText().toString();
            s7n = s7.substring(s7.indexOf(""), s7.indexOf(" naira Plantain"));
            n7 = Integer.parseInt(s7n);
                  count.setText("" + n7);
            addupChicken = +50;
        } else if (price.contentEquals("100 naira Plantain")) {
            s7 = button2.getText().toString();
            s7n = s7.substring(s7.indexOf(""), s7.indexOf(" naira Plantain"));
            n7 = Integer.parseInt(s7n);
                  count.setText("" + n7);
            addupChicken = +100;
        } else if (price.contentEquals("150 naira Plantain")) {
            s7 = button3.getText().toString();
            s7n = s7.substring(s7.indexOf(""), s7.indexOf(" naira Plantain"));
            n7 = Integer.parseInt(s7n);
                 count.setText("" + n7);
            addupChicken = +150;
        } else if (price.contentEquals("200 naira Plantain")) {
            s7 = button4.getText().toString();
            s7n = s7.substring(s7.indexOf(""), s7.indexOf(" naira Plantain"));
            n7 = Integer.parseInt(s7n);
                 count.setText("" + n7);
            addupChicken = +200;
        } else if (price.contentEquals("250 naira Plantain")) {
            s7 = button5.getText().toString();
            s7n = s7.substring(s7.indexOf(""), s7.indexOf(" naira Plantain"));
            n7 = Integer.parseInt(s7n);
                  count.setText("" + n7);
            addupChicken = +250;
        } else if (price.contentEquals("300 naira Plantain")) {
            s7 = button6.getText().toString();
            s7n = s7.substring(s7.indexOf(""), s7.indexOf(" naira Plantain"));
            n7 = Integer.parseInt(s7n);
                 count.setText("" + n7);
            addupChicken = +300;
        }

        if (price.contentEquals("50 naira Egg")) {
            s8 = button.getText().toString();
            s8n = s8.substring(s8.indexOf(""), s8.indexOf(" naira Egg"));
            n8 = Integer.parseInt(s8n);
                   count.setText("" + n8);
            addupEgg = +50;
        } else if (price.contentEquals("100 naira Egg(2)")) {
            s8 = button2.getText().toString();
            s8n = s8.substring(s8.indexOf(""), s8.indexOf(" naira Egg(2)"));
            n8 = Integer.parseInt(s8n);
                  count.setText("" + n8);
            addupEgg = +100;
        } else if (price.contentEquals("150 naira Egg(3)")) {
            s8 = button3.getText().toString();
            s8n = s8.substring(s8.indexOf(""), s8.indexOf(" naira Egg(3)"));
            n8 = Integer.parseInt(s8n);
                  count.setText("" + n8);
            addupEgg = +150;
        } else if (price.contentEquals("200 naira Egg(4)")) {
            s8 = button4.getText().toString();
            s8n = s8.substring(s8.indexOf(""), s8.indexOf(" naira Egg(4)"));
            n8 = Integer.parseInt(s8n);
                  count.setText("" + n8);
            addupEgg = +200;
        } else if (price.contentEquals("250 naira Egg(5)")) {
            s8 = button5.getText().toString();
            s8n = s8.substring(s8.indexOf(""), s8.indexOf(" naira Egg(5)"));
            n8 = Integer.parseInt(s8n);
                 count.setText("" + n8);
            addupEgg = +250;
        } else if (price.contentEquals("300 naira Egg(6)")) {
            s8 = button6.getText().toString();
            s8n = s8.substring(s8.indexOf(""), s8.indexOf(" naira Egg(6)"));
            n8 = Integer.parseInt(s8n);
                 count.setText("" + n8);
            addupEgg = +300;
        }

        if (price.contentEquals("100 naira Sides")) {
            s9 = button.getText().toString();
            s9n = s9.substring(s9.indexOf(""), s9.indexOf(" naira Sides"));
            n9 = Integer.parseInt(s9n);
                 count.setText("" + n9);
            addupColeslaw = +100;
        } else if (price.contentEquals("150 naira Sides")) {
            s9 = button2.getText().toString();
            s9n = s9.substring(s9.indexOf(""), s9.indexOf(" naira Sides"));
            n9 = Integer.parseInt(s9n);
                  count.setText("" + n9);
            addupColeslaw = +150;
        } else if (price.contentEquals("200 naira Sides")) {
            s9 = button3.getText().toString();
            s9n = s9.substring(s9.indexOf(""), s9.indexOf(" naira Sides"));
            n9 = Integer.parseInt(s9n);
                 count.setText("" + n9);
            addupColeslaw = +200;
        } else if (price.contentEquals("250 naira Sides")) {
            s9 = button4.getText().toString();
            s9n = s9.substring(s9.indexOf(""), s9.indexOf(" naira Sides"));
            n9 = Integer.parseInt(s9n);
                 count.setText("" + n9);
            addupColeslaw = +250;
        } else if (price.contentEquals("300 naira Sides")) {
            s9 = button5.getText().toString();
            s9n = s9.substring(s9.indexOf(""), s9.indexOf(" naira Sides"));
            n9 = Integer.parseInt(s9n);
                 count.setText("" + n9);
            addupColeslaw = +300;
        } else if (price.contentEquals("400 naira Sides")) {
            s9 = button6.getText().toString();
            s9n = s9.substring(s9.indexOf(""), s9.indexOf(" naira Sides"));
            n9 = Integer.parseInt(s9n);
                 count.setText("" + n9);
            addupColeslaw = +400;
        }

        if (price.contentEquals("50 naira Beans")) {
            s10 = button.getText().toString();
            s10n = s10.substring(s10.indexOf(""), s10.indexOf(" naira Beans"));
            n10 = Integer.parseInt(s10n);
                count.setText("" + n10);
            addupBeans = +50;
        } else if (price.contentEquals("100 naira Beans")) {
            s10 = button2.getText().toString();
            s10n = s10.substring(s10.indexOf(""), s10.indexOf(" naira Beans"));
            n10 = Integer.parseInt(s10n);
                 count.setText("" + n10);
            addupBeans = +100;
        } else if (price.contentEquals("150 naira Beans")) {
            s10 = button3.getText().toString();
            s10n = s10.substring(s10.indexOf(""), s10.indexOf(" naira Beans"));
            n10 = Integer.parseInt(s10n);
                count.setText("" + n10);
            addupBeans = +150;
        } else if (price.contentEquals("200 naira Beans")) {
            s10 = button4.getText().toString();
            s10n = s10.substring(s10.indexOf(""), s10.indexOf(" naira Beans"));
            n10 = Integer.parseInt(s10n);
                 count.setText("" + n10);
            addupBeans = +200;
        } else if (price.contentEquals("250 naira Beans")) {
            s10 = button5.getText().toString();
            s10n = s10.substring(s10.indexOf(""), s10.indexOf(" naira Beans"));
            n10 = Integer.parseInt(s10n);
            count.setText("" + n10);
            addupBeans = +250;
        } else if (price.contentEquals("300 naira Beans")) {
            s10 = button6.getText().toString();
            s10n = s10.substring(s10.indexOf(""), s10.indexOf(" naira Beans"));
            n10 = Integer.parseInt(s10n);
            count.setText("" + n10);
            addupBeans = +300;
        }
    }

}
