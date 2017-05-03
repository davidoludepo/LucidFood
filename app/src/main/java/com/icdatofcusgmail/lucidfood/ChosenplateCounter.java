package com.icdatofcusgmail.lucidfood;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

/**
 * Created by DAVID OGUNDEPO on 03/28/2017.
 */

public class ChosenplateCounter extends Fragment {

    EasyMoneyTextView count;
   // public static double countall;
    ImageButton imageButton, imageButton2nd, imageButton3rd, imageButton4th, imageButton5th, imageButton6th, imageButton7th, imageButton8th, imageButton9th, imageButton10th;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.foodmenufragment5_chosenplate_counter, container, false);

        count = (EasyMoneyTextView) view.findViewById(R.id.counter);

      //  countall = 0.00;

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

    @SuppressLint("SetTextI18n")

    public void updateInfo(String price) {

        int number1 = 0, number2 = 0, number3 = 0, number4 = 0, number5 = 0,
                number6 = 0, number7 = 0, number8 = 0, number9 = 0,
                number10 = 0, result;

        if (price.contentEquals("150 naira White Rice")) {
           // number1 = Integer.parseInt("150");
            count.setText("150");
        } else if (price.contentEquals("200 naira White Rice")) {
          //  number1 = Integer.parseInt("200");
            count.setText("200");
        } else if (price.contentEquals("250 naira White Rice")) {
           // number1 = Integer.parseInt("250");
            count.setText("250");
        } else if (price.contentEquals("300 naira White Rice")) {
         //   number1 = Integer.parseInt("300");
            count.setText("300");
        } else if (price.contentEquals("350 naira White Rice")) {
        //    number1 = Integer.parseInt("350");
            count.setText("350");
        } else if (price.contentEquals("400 naira White Rice")) {
        //    number1 = Integer.parseInt("400");
            count.setText("400");
        }

        if (price.contentEquals("150 naira Jollof Rice")) {
          //  number2 = Integer.parseInt("150");
            count.setText("150");
        } else if (price.contentEquals("200 naira Jollof Rice")) {
       //     number2 = Integer.parseInt("200");
            count.setText("200");
        } else if (price.contentEquals("250 naira Jollof Rice")) {
      //      number2 = Integer.parseInt("250");
            count.setText("250");
        } else if (price.contentEquals("300 naira Jollof Rice")) {
     //       number2 = Integer.parseInt("300");
            count.setText("300");
        } else if (price.contentEquals("350 naira Jollof Rice")) {
     //       number2 = Integer.parseInt("350");
            count.setText("350");
        } else if (price.contentEquals("400 naira Jollof Rice")) {
     //       number2 = Integer.parseInt("400");
            count.setText("400");
        }

        if (price.contentEquals("150 naira Fried Rice")) {
      //      number3 = Integer.parseInt("150");
            count.setText("150");
        } else if (price.contentEquals("200 naira Fried Rice")) {
      //      number3 = Integer.parseInt("200");
            count.setText("200");
        } else if (price.contentEquals("250 naira Fried Rice")) {
      //      number3 = Integer.parseInt("250");
            count.setText("250");
        } else if (price.contentEquals("300 naira Fried Rice")) {
     //       number3 = Integer.parseInt("300");
            count.setText("300");
        } else if (price.contentEquals("350 naira Fried Rice")) {
     //       number3 = Integer.parseInt("350");
            count.setText("350");
        } else if (price.contentEquals("400 naira Fried Rice")) {
    //        number3 = Integer.parseInt("400");
            count.setText("400");
        }

        if (price.contentEquals("100 naira Beef")) {
     //       number4 = Integer.parseInt("150");
            count.setText("100");
        } else if (price.contentEquals("200 naira Beef(2)")) {
    //        number4 = Integer.parseInt("200");
            count.setText("200");
        } else if (price.contentEquals("300 naira Beef(3)")) {
    //        number4 = Integer.parseInt("300");
            count.setText("300");
        } else if (price.contentEquals("400 naira Beef(4)")) {
    //        number4 = Integer.parseInt("400");
            count.setText("400");
        } else if (price.contentEquals("500 naira Beef(5)")) {
    //        number4 = Integer.parseInt("500");
            count.setText("500");
        } else if (price.contentEquals("600 naira Beef(6)")) {
   //         number4 = Integer.parseInt("600");
            count.setText("600");
        }

        if (price.contentEquals("300 naira Chicken")) {
    //        number5 = Integer.parseInt("300");
            count.setText("300");
        } else if (price.contentEquals("600 naira Chicken(2)")) {
   //         number5 = Integer.parseInt("600");
            count.setText("600");
        } else if (price.contentEquals("900 naira Chicken(3)")) {
   //         number5 = Integer.parseInt("900");
            count.setText("900");
        } else if (price.contentEquals("1200 naira Chicken(4)")) {
   //         number5 = Integer.parseInt("1200");
            count.setText("1200");
        } else if (price.contentEquals("1500 naira Chicken(5)")) {
  //          number5 = Integer.parseInt("1500");
            count.setText("1500");
        } else if (price.contentEquals("1800 naira Chicken(6)")) {
  //          number5 = Integer.parseInt("1800");
            count.setText("1800");
        }

        if (price.contentEquals("100 naira MoiMoi")) {
    //        number6 = Integer.parseInt("100");
            count.setText("100");
        } else if (price.contentEquals("200 naira MoiMoi(2)")) {
    //        number6 = Integer.parseInt("200");
            count.setText("200");
        } else if (price.contentEquals("300 naira MoiMoi(3)")) {
    //        number6 = Integer.parseInt("300");
            count.setText("300");
        } else if (price.contentEquals("400 naira MoiMoi(4)")) {
    //        number6 = Integer.parseInt("400");
            count.setText("400");
        } else if (price.contentEquals("500 naira MoiMoi(5)")) {
    //        number6 = Integer.parseInt("500");
            count.setText("500");
        } else if (price.contentEquals("600 naira MoiMoi(6)")) {
  //          number6 = Integer.parseInt("600");
            count.setText("600");
        }

        if (price.contentEquals("50 naira Plantain")) {
  //          number7 = Integer.parseInt("50");
            count.setText("50");
        } else if (price.contentEquals("100 naira Plantain")) {
   //         number7 = Integer.parseInt("100");
            count.setText("100");
        } else if (price.contentEquals("150 naira Plantain")) {
  //          number7 = Integer.parseInt("150");
            count.setText("150");
        } else if (price.contentEquals("200 naira Plantain")) {
   //         number7 = Integer.parseInt("200");
            count.setText("200");
        } else if (price.contentEquals("250 naira Plantain")) {
   //         number7 = Integer.parseInt("250");
            count.setText("250");
        } else if (price.contentEquals("300 naira Plantain")) {
  //          number7 = Integer.parseInt("300");
            count.setText("300");
        }

        if (price.contentEquals("50 naira Egg")) {
   //         number8 = Integer.parseInt("50");
            count.setText("50");
        } else if (price.contentEquals("100 naira Egg(2)")) {
   //         number8 = Integer.parseInt("100");
            count.setText("100");
        } else if (price.contentEquals("150 naira Egg(3)")) {
    //        number8 = Integer.parseInt("150");
            count.setText("150");
        } else if (price.contentEquals("200 naira Egg(4)")) {
      //      number8 = Integer.parseInt("200");
            count.setText("200");
        } else if (price.contentEquals("250 naira Egg(5)")) {
    //        number8 = Integer.parseInt("250");
            count.setText("250");
        } else if (price.contentEquals("300 naira Egg(6)")) {
     //       number8 = Integer.parseInt("300");
            count.setText("300");
        }

        if (price.contentEquals("100 naira Sides")) {
   //         number9 = Integer.parseInt("100");
            count.setText("100");
        } else if (price.contentEquals("150 naira Sides")) {
   //         number9 = Integer.parseInt("150");
            count.setText("150");
        } else if (price.contentEquals("200 naira Sides")) {
   //         number9 = Integer.parseInt("200");
            count.setText("200");
        } else if (price.contentEquals("250 naira Sides")) {
   //         number9 = Integer.parseInt("250");
            count.setText("250");
        } else if (price.contentEquals("300 naira Sides")) {
   //         number9 = Integer.parseInt("300");
            count.setText("300");
        } else if (price.contentEquals("400 naira Sides")) {
   //         number9 = Integer.parseInt("400");
            count.setText("400");
        }

        if (price.contentEquals("50 naira Beans")) {
   //         number10 = Integer.parseInt("50");
            count.setText("50");
        } else if (price.contentEquals("100 naira Beans")) {
   //         number10 = Integer.parseInt("100");
            count.setText("100");
        } else if (price.contentEquals("150 naira Beans")) {
   //         number10 = Integer.parseInt("150");
            count.setText("150");
        } else if (price.contentEquals("200 naira Beans")) {
    //        number10 = Integer.parseInt("200");
            count.setText("200");
        } else if (price.contentEquals("250 naira Beans")) {
   //         number10 = Integer.parseInt("250");
            count.setText("250");
        } else if (price.contentEquals("300 naira Beans")) {
   //         number10 = Integer.parseInt("300");
            count.setText("300");
        }

     //   result = number1 + number2 + number3 + number4 + number5 + number6 + number7 + number8 + number9 + number10;
     //   count.setText(Integer.toString(result));

        //   if (result > 0) {
      //      count.setText(number1 + number2 + number3 + number4 + number5 + number6 + number7 + number8 + number9 + number10);
    //    }
    }
}
