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

    TextView textView, textView2nd, textView3rd, textView4th, textView5th, textView6th, textView7th, textView8th, textView9th, textView10th;
    ImageButton imageButton, imageButton2nd, imageButton3rd, imageButton4th, imageButton5th, imageButton6th, imageButton7th, imageButton8th, imageButton9th, imageButton10th;
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
                    || imageButton10th.isShown()) {
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
                        || imageButton10th.isShown()) {
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
                        || imageButton10th.isShown()) {
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
                        || imageButton3rd.isShown()   || imageButton5th.isShown() || imageButton6th.isShown()
                        || imageButton7th.isShown() || imageButton8th.isShown() || imageButton9th.isShown()
                        || imageButton10th.isShown()) {
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
                        || imageButton3rd.isShown()   || imageButton4th.isShown() || imageButton6th.isShown()
                        || imageButton7th.isShown() || imageButton8th.isShown() || imageButton9th.isShown()
                        || imageButton10th.isShown()) {
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
                        || imageButton3rd.isShown()   || imageButton4th.isShown() || imageButton5th.isShown()
                        || imageButton7th.isShown() || imageButton8th.isShown() || imageButton9th.isShown()
                        || imageButton10th.isShown()) {
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
                        || imageButton3rd.isShown()   || imageButton4th.isShown() || imageButton5th.isShown()
                        || imageButton6th.isShown() || imageButton8th.isShown() || imageButton9th.isShown()
                        || imageButton10th.isShown()) {
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
                        || imageButton3rd.isShown()   || imageButton4th.isShown() || imageButton5th.isShown()
                        || imageButton6th.isShown() || imageButton7th.isShown() || imageButton9th.isShown()
                        || imageButton10th.isShown()) {
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
                        || imageButton3rd.isShown()   || imageButton4th.isShown() || imageButton5th.isShown()
                        || imageButton6th.isShown() || imageButton7th.isShown() || imageButton8th.isShown()
                        || imageButton10th.isShown()) {
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
                        || imageButton3rd.isShown()   || imageButton4th.isShown() || imageButton5th.isShown()
                        || imageButton6th.isShown() || imageButton7th.isShown() || imageButton8th.isShown()
                        || imageButton9th.isShown()) {
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

        if (name.contentEquals("100 naira Beef")) {
            textView4th.setText(name);
            textView4th.setVisibility(View.VISIBLE);
            imageButton4th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("200 naira Beef(2)")) {
            textView4th.setText(name);
            textView4th.setVisibility(View.VISIBLE);
            imageButton4th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("300 naira Beef(3)")) {
            textView4th.setText(name);
            textView4th.setVisibility(View.VISIBLE);
            imageButton4th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("400 naira Beef(4)")) {
            textView4th.setText(name);
            textView4th.setVisibility(View.VISIBLE);
            imageButton4th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("500 naira Beef(5)")) {
            textView4th.setText(name);
            textView4th.setVisibility(View.VISIBLE);
            imageButton4th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("600 naira Beef(6)")) {
            textView4th.setText(name);
            textView4th.setVisibility(View.VISIBLE);
            imageButton4th.setVisibility(View.VISIBLE);
        }

        if (name.contentEquals("300 naira Chicken")) {
            textView5th.setText(name);
            textView5th.setVisibility(View.VISIBLE);
            imageButton5th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("600 naira Chicken(2)")) {
            textView5th.setText(name);
            textView5th.setVisibility(View.VISIBLE);
            imageButton5th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("900 naira Chicken(3)")) {
            textView5th.setText(name);
            textView5th.setVisibility(View.VISIBLE);
            imageButton5th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("1200 naira Chicken(4)")) {
            textView5th.setText(name);
            textView5th.setVisibility(View.VISIBLE);
            imageButton5th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("1500 naira Chicken(5)")) {
            textView5th.setText(name);
            textView5th.setVisibility(View.VISIBLE);
            imageButton5th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("1800 naira Chicken(6)")) {
            textView5th.setText(name);
            textView5th.setVisibility(View.VISIBLE);
            imageButton5th.setVisibility(View.VISIBLE);
        }

        if (name.contentEquals("100 naira MoiMoi")) {
            textView6th.setText(name);
            textView6th.setVisibility(View.VISIBLE);
            imageButton6th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("200 naira MoiMoi(2)")) {
            textView6th.setText(name);
            textView6th.setVisibility(View.VISIBLE);
            imageButton6th.setVisibility(View.VISIBLE);
        }  else if (name.contentEquals("300 naira MoiMoi(3)")) {
            textView6th.setText(name);
            textView6th.setVisibility(View.VISIBLE);
            imageButton6th.setVisibility(View.VISIBLE);
        }  else if (name.contentEquals("400 naira MoiMoi(4)")) {
            textView6th.setText(name);
            textView6th.setVisibility(View.VISIBLE);
            imageButton6th.setVisibility(View.VISIBLE);
        }  else if (name.contentEquals("500 naira MoiMoi(5)")) {
            textView6th.setText(name);
            textView6th.setVisibility(View.VISIBLE);
            imageButton6th.setVisibility(View.VISIBLE);
        }  else if (name.contentEquals("600 naira MoiMoi(6)")) {
            textView6th.setText(name);
            textView6th.setVisibility(View.VISIBLE);
            imageButton6th.setVisibility(View.VISIBLE);
        }

        if (name.contentEquals("50 naira Plantain")) {
            textView7th.setText(name);
            textView7th.setVisibility(View.VISIBLE);
            imageButton7th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("100 naira Plantain")) {
            textView7th.setText(name);
            textView7th.setVisibility(View.VISIBLE);
            imageButton7th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("150 naira Plantain")) {
            textView7th.setText(name);
            textView7th.setVisibility(View.VISIBLE);
            imageButton7th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("200 naira Plantain")) {
            textView7th.setText(name);
            textView7th.setVisibility(View.VISIBLE);
            imageButton7th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("250 naira Plantain")) {
            textView7th.setText(name);
            textView7th.setVisibility(View.VISIBLE);
            imageButton7th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("300 naira Plantain")) {
            textView7th.setText(name);
            textView7th.setVisibility(View.VISIBLE);
            imageButton7th.setVisibility(View.VISIBLE);
        }

        if (name.contentEquals("50 naira Egg")) {
            textView8th.setText(name);
            textView8th.setVisibility(View.VISIBLE);
            imageButton8th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("100 naira Egg(2)")) {
            textView8th.setText(name);
            textView8th.setVisibility(View.VISIBLE);
            imageButton8th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("150 naira Egg(3)")) {
            textView8th.setText(name);
            textView8th.setVisibility(View.VISIBLE);
            imageButton8th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("200 naira Egg(4)")) {
            textView8th.setText(name);
            textView8th.setVisibility(View.VISIBLE);
            imageButton8th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("250 naira Egg(5)")) {
            textView8th.setText(name);
            textView8th.setVisibility(View.VISIBLE);
            imageButton8th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("300 naira Egg(6)")) {
            textView8th.setText(name);
            textView8th.setVisibility(View.VISIBLE);
            imageButton8th.setVisibility(View.VISIBLE);
        }

        if (name.contentEquals("100 naira Sides")) {
            textView9th.setText(name);
            textView9th.setVisibility(View.VISIBLE);
            imageButton9th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("150 naira Sides")) {
            textView9th.setText(name);
            textView9th.setVisibility(View.VISIBLE);
            imageButton9th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("200 naira Sides")) {
            textView9th.setText(name);
            textView9th.setVisibility(View.VISIBLE);
            imageButton9th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("250 naira Sides")) {
            textView9th.setText(name);
            textView9th.setVisibility(View.VISIBLE);
            imageButton9th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("300 naira Sides")) {
            textView9th.setText(name);
            textView9th.setVisibility(View.VISIBLE);
            imageButton9th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("400 naira Sides")) {
            textView9th.setText(name);
            textView9th.setVisibility(View.VISIBLE);
            imageButton9th.setVisibility(View.VISIBLE);
        }

        if (name.contentEquals("50 naira Beans")) {
            textView10th.setText(name);
            textView10th.setVisibility(View.VISIBLE);
            imageButton10th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("100 naira Beans")) {
            textView10th.setText(name);
            textView10th.setVisibility(View.VISIBLE);
            imageButton10th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("150 naira Beans")) {
            textView10th.setText(name);
            textView10th.setVisibility(View.VISIBLE);
            imageButton10th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("200 naira Beans")) {
            textView10th.setText(name);
            textView10th.setVisibility(View.VISIBLE);
            imageButton10th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("250 naira Beans")) {
            textView10th.setText(name);
            textView10th.setVisibility(View.VISIBLE);
            imageButton10th.setVisibility(View.VISIBLE);
        } else if (name.contentEquals("300 naira Beans")) {
            textView10th.setText(name);
            textView10th.setVisibility(View.VISIBLE);
            imageButton10th.setVisibility(View.VISIBLE);
        }
  //      FoodmenuActivity.stringplayti = FoodmenuActivity.playtcount;
        FoodmenuActivity.Pcount.setText("" + "PLATE COUNT" + "");
    }
}
