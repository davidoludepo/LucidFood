package com.icdatofcusgmail.lucidfood;

import android.app.Dialog;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.antonionicolaspina.revealtextview.RevealTextView;
import com.muddzdev.styleabletoastlibrary.StyleableToast;
import com.squareup.leakcanary.LeakCanary;

import java.util.ArrayList;
import java.util.Arrays;

public class FoodmenuActivity extends AppCompatActivity implements Communicator, FoodpriceFragment.OnNameSetListener, ChosenfoodFragment.OnPriceSetListener, CompoundButton.OnCheckedChangeListener, AdapterView.OnItemClickListener {

    PowerManager.WakeLock wakeLock;
    Toolbar toolbar_foodmenu;
    private RelativeLayout relative;
    static TextView textView, textView2nd, textView3rd, textView4th, textView5th, textView6th, textView7th, textView8th, textView9th, textView10th;
    Button button, button2, button3, button4, button5, button6;
    static Button Pcount, Purchase;
    VendorAdapter foodmenuAdapter;
    ListView ShowForThis;
    TextView WelcomeSweet, Lucid;
    Button ConfirmPurchaze;
    CheckBox pack;
    String pacque, stringue = "";
    FoodHistoryDBHelper foodHistoryDBHelper;
    MenuItem savior, salvation;
    private ImageView AnimatedImageView;
    TextView count;
    static ImageButton imageButton, imageButton2nd, imageButton3rd, imageButton4th, imageButton5th, imageButton6th, imageButton7th, imageButton8th, imageButton9th, imageButton10th;
// public static double countall;

    private enum OperationAnimation {
        BEGIN, ADJOURN
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foodmenu);
        Log.d("FoodmenuActivity", "onCreate invoked");
        foodHistoryDBHelper = new FoodHistoryDBHelper(this);

        if (LeakCanary.isInAnalyzerProcess(FoodmenuActivity.this)) {
            return;
        }
        LeakCanary.install(getApplication());  //Should be this, Used to check data leaks in Activities
        //   Bundle b = getIntent().getExtras();
        //   ArrayList<Parcelable> resultArr = b.getParcelableArrayList("selectedItems");
        ShowForThis = (ListView) findViewById(R.id.listView);
        //  ShowForThis.setOnItemClickListener(this);
        //  final
        //   VendorAdapter foodmenuAdapter = new VendorAdapter(
        //       this, getTeams(), resultArr);
        //  ShowForThis.setAdapter(foodmenuAdapter);

        Intent i = this.getIntent();
        Icdat icdat = i.getParcelableExtra("selectedItems");
        //  ShowForThis.setAdapter(new ArrayAdapter<>(getApplicationContext(), Icdat));

        PowerManager powerManager = (PowerManager) getSystemService(Context.POWER_SERVICE);
        wakeLock = powerManager.newWakeLock(PowerManager.FULL_WAKE_LOCK, "deprecatedmyfoot");
        wakeLock.acquire();
        textView = (Button) findViewById(R.id.Istchosenbutton);
        textView2nd = (Button) findViewById(R.id.Secondchosenbutton);
        textView3rd = (Button) findViewById(R.id.Thirdchosenbutton);
        textView4th = (Button) findViewById(R.id.Fourthchosenbutton);
        textView5th = (Button) findViewById(R.id.Fifthchosenbutton);
        textView6th = (Button) findViewById(R.id.Sixthchosenbutton);
        textView7th = (Button) findViewById(R.id.Seventhchosenbutton);
        textView8th = (Button) findViewById(R.id.Eightchosenbutton);
        textView9th = (Button) findViewById(R.id.Ninthchosenbutton);
        textView10th = (Button) findViewById(R.id.Tenthchosenbutton);

        WelcomeSweet = (TextView) findViewById(R.id.UserWelcome);
        Lucid = (RevealTextView) findViewById(R.id.AppName);
        Typeface blackface = Typeface.createFromAsset(getAssets(), "customfont/buttonfor.otf");
        Lucid.setTypeface(blackface);

        savior = (MenuItem) findViewById(R.id.like_plate);
        salvation = (MenuItem) findViewById(R.id.saved_plate);

        imageButton = (ImageButton) findViewById(R.id.Istchosendeletebutton);
        imageButton2nd = (ImageButton) findViewById(R.id.Secondchosendeletebutton);
        imageButton3rd = (ImageButton) findViewById(R.id.Thirdchosendeletebutton);
        imageButton4th = (ImageButton) findViewById(R.id.Fourthchosendeletebutton);
        imageButton5th = (ImageButton) findViewById(R.id.Fifthchosendeletebutton);
        imageButton6th = (ImageButton) findViewById(R.id.Sixthchosendeletebutton);
        imageButton7th = (ImageButton) findViewById(R.id.Seventhchosendeletebutton);
        imageButton8th = (ImageButton) findViewById(R.id.Eightchosendeletebutton);
        imageButton9th = (ImageButton) findViewById(R.id.Ninthchosendeleltebutton);
        imageButton10th = (ImageButton) findViewById(R.id.Tenthchosendeletebutton);

        button = (Button) findViewById(R.id.Istpricebutton);
        button2 = (Button) findViewById(R.id.Secondpricebutton);
        button3 = (Button) findViewById(R.id.Thirdpricebutton);
        button4 = (Button) findViewById(R.id.Fourthpricebutton);
        button5 = (Button) findViewById(R.id.Fifthpricebutton);
        button6 = (Button) findViewById(R.id.Sixthpricebutton);
        Pcount = (Button) findViewById(R.id.button);

        Purchase = (Button) findViewById(R.id.button20000);

        AnimatedImageView = (ImageView) findViewById(R.id.animatedImages);

        if (!textView.isShown() && !textView2nd.isShown() && !textView3rd.isShown()
                && !textView4th.isShown() && !textView5th.isShown() && !textView6th.isShown()
                && !textView7th.isShown() && !textView8th.isShown() && !textView9th.isShown()
                && !textView10th.isShown()) {
            Toast.makeText(getApplicationContext(), "Not shown", Toast.LENGTH_SHORT).show();
            Pcount.setEnabled(false);
            Purchase.setEnabled(false);
        }


        //  button.setOnClickListener(this);
        //  button2.setOnClickListener(this);u

        Bundle FirstParcel = getIntent().getExtras();
        try {
            WelcomeSweet.setText("Welcome, " + FirstParcel.getString("king") + "");
        } catch (RuntimeException ex) {
            Log.d("Runtime", "Exception");
            Toast.makeText(getApplicationContext(), "Sorry Man....", Toast.LENGTH_SHORT).show();
        } catch (Exception c) {
            Log.d("Just", "Exception");
            Toast.makeText(getApplicationContext(), "Sorry Woman....", Toast.LENGTH_SHORT).show();
        }


        ConfirmPurchaze = (Button) findViewById(R.id.button20000);

        //   count = (TextView) findViewById(R.id.counter);

        //   requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        relative = (RelativeLayout) findViewById(R.id.activity_Foodmenu);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(android.R.color.transparent));
        }
        toolbar_foodmenu = (Toolbar) findViewById(R.id.ToolbarFoodmenuActivity);
        setSupportActionBar(toolbar_foodmenu);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");



    }

    private ArrayList<Icdat> getTeams() {
        final ArrayList<Icdat> icdats = new ArrayList<>();
        return icdats;
    }

    /**   @Override public void onClick(View v) {

    int number1 = 0, number2 = 0, number3 = 0, number4 = 0, number5 = 0, number6 = 0, number7 = 0, number8 = 0, number9 = 0, number10 = 0;
    StringBuilder result = new StringBuilder();

    imageButton.setOnClickListener(new View.OnClickListener() {
    @Override public void onClick(View v) {
    textView.setVisibility(View.GONE);
    imageButton.setVisibility(View.GONE);
    }
    });

    imageButton2nd.setOnClickListener(new View.OnClickListener() {
    @Override public void onClick(View v) {
    textView2nd.setVisibility(View.GONE);
    imageButton2nd.setVisibility(View.GONE);
    }
    });

    imageButton3rd.setOnClickListener(new View.OnClickListener() {
    @Override public void onClick(View v) {
    textView3rd.setVisibility(View.GONE);
    imageButton3rd.setVisibility(View.GONE);
    }
    });

    imageButton4th.setOnClickListener(new View.OnClickListener() {
    @Override public void onClick(View v) {
    textView4th.setVisibility(View.GONE);
    imageButton4th.setVisibility(View.GONE);
    }
    });

    imageButton5th.setOnClickListener(new View.OnClickListener() {
    @Override public void onClick(View v) {
    textView5th.setVisibility(View.GONE);
    imageButton5th.setVisibility(View.GONE);
    }
    });

    imageButton6th.setOnClickListener(new View.OnClickListener() {
    @Override public void onClick(View v) {
    textView6th.setVisibility(View.GONE);
    imageButton6th.setVisibility(View.GONE);
    }
    });

    imageButton7th.setOnClickListener(new View.OnClickListener() {
    @Override public void onClick(View v) {
    textView7th.setVisibility(View.GONE);
    imageButton7th.setVisibility(View.GONE);
    }
    });

    imageButton8th.setOnClickListener(new View.OnClickListener() {
    @Override public void onClick(View v) {
    textView8th.setVisibility(View.GONE);
    imageButton8th.setVisibility(View.GONE);
    }
    });

    imageButton9th.setOnClickListener(new View.OnClickListener() {
    @Override public void onClick(View v) {
    textView9th.setVisibility(View.GONE);
    imageButton9th.setVisibility(View.GONE);
    }
    });

    imageButton10th.setOnClickListener(new View.OnClickListener() {
    @Override public void onClick(View v) {
    textView10th.setVisibility(View.GONE);
    imageButton10th.setVisibility(View.GONE);
    }
    });

    if (button.getText().equals("150 naira White Rice") && button.isPressed()) {
    //  textView.setText("150 naira White Rice");
    textView.setVisibility(View.VISIBLE);
    imageButton.setVisibility(View.VISIBLE);
    number1 += 150;
    }
    if (button.getText().equals("150 naira Jollof Rice"))
    {
    //    textView2nd.setText("150 naira Jollof Rice");
    textView2nd.setVisibility(View.VISIBLE);
    imageButton2nd.setVisibility(View.VISIBLE);
    number2 += 150;
    }
    if (button.getText().equals("150 naira Fried Rice"))
    {
    //    textView3rd.setText("150 naira Fried Rice");
    textView3rd.setVisibility(View.VISIBLE);
    imageButton3rd.setVisibility(View.VISIBLE);
    number3 += 150;
    }

    if (button.getText().equals("100 naira Beef"))
    {
    //   textView4th.setText("100 naira Beef");
    textView4th.setVisibility(View.VISIBLE);
    imageButton4th.setVisibility(View.VISIBLE);
    number4 += 100;
    }

    if (button.getText().equals("300 naira Chicken"))
    {
    //    textView5th.setText("300 naira Chicken");
    textView5th.setVisibility(View.VISIBLE);
    imageButton5th.setVisibility(View.VISIBLE);
    number5 += 300;
    }

    if (button.getText().equals("100 naira MoiMoi"))
    {
    //    textView6th.setText("100 naira MoiMoi");
    textView6th.setVisibility(View.VISIBLE);
    imageButton6th.setVisibility(View.VISIBLE);
    number6 += 100;
    }

    if (button.getText().equals("50 naira Plantain"))
    {
    //    textView7th.setText("50 naira Plantain");
    textView7th.setVisibility(View.VISIBLE);
    imageButton7th.setVisibility(View.VISIBLE);
    number7 += 50;
    }

    if (button.getText().equals("50 naira Egg"))
    {
    //   textView8th.setText("50 naira Egg");
    textView8th.setVisibility(View.VISIBLE);
    imageButton8th.setVisibility(View.VISIBLE);
    number8 += 50;
    }

    if (button.getText().equals("100 naira Sides"))
    {
    //    textView9th.setText("100 naira Sides");
    textView9th.setVisibility(View.VISIBLE);
    imageButton9th.setVisibility(View.VISIBLE);
    number9 += 100;
    }

    if (button.getText().equals("50 naira Beans"))
    {
    //  textView10th.setText("50 naira Beans");
    textView10th.setVisibility(View.VISIBLE);
    imageButton10th.setVisibility(View.VISIBLE);
    number10 += 50;
    }


    //  2                     N                         D

    if (button2.getText().equals("200 naira White Rice")) {
    //   textView.setText("200 naira White Rice");
    textView.setVisibility(View.VISIBLE);
    imageButton.setVisibility(View.VISIBLE);
    //  number1 += + 50;
    }


    if (button2.getText().equals("200 naira Jollof Rice"))
    {
    textView2nd.setText("200 naira Jollof Rice");
    textView2nd.setVisibility(View.VISIBLE);
    imageButton2nd.setVisibility(View.VISIBLE);
    // number2 += + 50;
    }
    if (button2.getText().equals("200 naira Fried Rice"))
    {
    textView3rd.setText("200 naira Fried Rice");
    textView3rd.setVisibility(View.VISIBLE);
    imageButton3rd.setVisibility(View.VISIBLE);
    //  number3 += + 50;
    }

    if (button2.getText().equals("200 naira Beef(2)"))
    {
    textView4th.setText("200 naira Beef(2)");
    textView4th.setVisibility(View.VISIBLE);
    imageButton4th.setVisibility(View.VISIBLE);
    // number4 += + 50;
    }

    if (button2.getText().equals("600 naira Chicken(2)"))
    {
    textView5th.setText("600 naira Chicken(2)");
    textView5th.setVisibility(View.VISIBLE);
    imageButton5th.setVisibility(View.VISIBLE);
    //    number5 += + 300;
    }

    if (button2.getText().equals("200 naira MoiMoi(2)"))
    {
    textView6th.setText("200 naira MoiMoi(2)");
    textView6th.setVisibility(View.VISIBLE);
    imageButton6th.setVisibility(View.VISIBLE);
    //  number6 += + 50;
    }

    if (button2.getText().equals("100 naira Plantain"))
    {
    textView7th.setText("100 naira Plantain");
    textView7th.setVisibility(View.VISIBLE);
    imageButton7th.setVisibility(View.VISIBLE);
    //   number7 += + 50;
    }

    if (button2.getText().equals("100 naira Egg(2)"))
    {
    textView8th.setText("100 naira Egg(2)");
    textView8th.setVisibility(View.VISIBLE);
    imageButton8th.setVisibility(View.VISIBLE);
    //   number8 += + 50;
    }

    if (button2.getText().equals("150 naira Sides"))
    {
    textView9th.setText("150 naira Sides");
    textView9th.setVisibility(View.VISIBLE);
    imageButton9th.setVisibility(View.VISIBLE);
    // number9 += + 50;
    }

    if (button2.getText().equals("100 naira Beans"))
    {
    textView10th.setText("100 naira Beans");
    textView10th.setVisibility(View.VISIBLE);
    imageButton10th.setVisibility(View.VISIBLE);
    //  number10 += + 50;
    }


    //    3                 R                   D

    if (button3.getText().equals("250 naira White Rice")) {
    textView.setText("250 naira White Rice");
    textView.setVisibility(View.VISIBLE);
    imageButton.setVisibility(View.VISIBLE);
    //    number1 += 150;
    }
    if (button3.getText().equals("250 naira Jollof Rice"))
    {
    textView2nd.setText("250 naira Jollof Rice");
    textView2nd.setVisibility(View.VISIBLE);
    imageButton2nd.setVisibility(View.VISIBLE);
    //   number2 += 150;
    }
    if (button3.getText().equals("250 naira Fried Rice"))
    {
    textView3rd.setText("250 naira Fried Rice");
    textView3rd.setVisibility(View.VISIBLE);
    imageButton3rd.setVisibility(View.VISIBLE);
    //    number3 += 150;
    }

    if (button3.getText().equals("300 naira Beef(3)"))
    {
    textView4th.setText("300 naira Beef(3)");
    textView4th.setVisibility(View.VISIBLE);
    imageButton4th.setVisibility(View.VISIBLE);
    //    number4 += 100;
    }

    if (button3.getText().equals("900 naira Chicken(3)"))
    {
    textView5th.setText("900 naira Chicken(3)");
    textView5th.setVisibility(View.VISIBLE);
    imageButton5th.setVisibility(View.VISIBLE);
    //    number5 += 300;
    }

    if (button3.getText().equals("300 naira MoiMoi(3)"))
    {
    textView6th.setText("300 naira MoiMoi(3)");
    textView6th.setVisibility(View.VISIBLE);
    imageButton6th.setVisibility(View.VISIBLE);
    //   number6 += 100;
    }

    if (button3.getText().equals("150 naira Plantain"))
    {
    textView7th.setText("150 naira Plantain");
    textView7th.setVisibility(View.VISIBLE);
    imageButton7th.setVisibility(View.VISIBLE);
    //    number7 += 50;
    }

    if (button3.getText().equals("150 naira Egg(3)"))
    {
    textView8th.setText("150 naira Egg(3)");
    textView8th.setVisibility(View.VISIBLE);
    imageButton8th.setVisibility(View.VISIBLE);
    //   number8 += 50;
    }

    if (button3.getText().equals("200 naira Sides"))
    {
    textView9th.setText("200 naira Sides");
    textView9th.setVisibility(View.VISIBLE);
    imageButton9th.setVisibility(View.VISIBLE);
    //   number9 += 100;
    }

    if (button3.getText().equals("150 naira Beans"))
    {
    textView10th.setText("150 naira Beans");
    textView10th.setVisibility(View.VISIBLE);
    imageButton10th.setVisibility(View.VISIBLE);
    //   number10 += 50;
    }


    //  4                     T                      H

    if (button4.getText().equals("300 naira White Rice")) {
    textView.setText("300 naira White Rice");
    textView.setVisibility(View.VISIBLE);
    imageButton.setVisibility(View.VISIBLE);
    //  number1 += + 50;
    }


    if (button4.getText().equals("300 naira Jollof Rice"))
    {
    textView2nd.setText("300 naira Jollof Rice");
    textView2nd.setVisibility(View.VISIBLE);
    imageButton2nd.setVisibility(View.VISIBLE);
    // number2 += + 50;
    }
    if (button4.getText().equals("300 naira Fried Rice"))
    {
    textView3rd.setText("300 naira Fried Rice");
    textView3rd.setVisibility(View.VISIBLE);
    imageButton3rd.setVisibility(View.VISIBLE);
    //  number3 += + 50;
    }

    if (button4.getText().equals("400 naira Beef(4)"))
    {
    textView4th.setText("400 naira Beef(4)");
    textView4th.setVisibility(View.VISIBLE);
    imageButton4th.setVisibility(View.VISIBLE);
    // number4 += + 50;
    }

    if (button4.getText().equals("1200 naira Chicken(4)"))
    {
    textView5th.setText("1200 naira Chicken(4)");
    textView5th.setVisibility(View.VISIBLE);
    imageButton5th.setVisibility(View.VISIBLE);
    //    number5 += + 300;
    }

    if (button4.getText().equals("400 naira MoiMoi(4)"))
    {
    textView6th.setText("400 naira MoiMoi(4)");
    textView6th.setVisibility(View.VISIBLE);
    imageButton6th.setVisibility(View.VISIBLE);
    //  number6 += + 50;
    }

    if (button4.getText().equals("200 naira Plantain"))
    {
    textView7th.setText("200 naira Plantain");
    textView7th.setVisibility(View.VISIBLE);
    imageButton7th.setVisibility(View.VISIBLE);
    //   number7 += + 50;
    }

    if (button4.getText().equals("200 naira Egg(4)"))
    {
    textView8th.setText("200 naira Egg(4)");
    textView8th.setVisibility(View.VISIBLE);
    imageButton8th.setVisibility(View.VISIBLE);
    //   number8 += + 50;
    }

    if (button4.getText().equals("250 naira Sides"))
    {
    textView9th.setText("250 naira Sides");
    textView9th.setVisibility(View.VISIBLE);
    imageButton9th.setVisibility(View.VISIBLE);
    // number9 += + 50;
    }

    if (button4.getText().equals("200 naira Beans"))
    {
    textView10th.setText("200 naira Beans");
    textView10th.setVisibility(View.VISIBLE);
    imageButton10th.setVisibility(View.VISIBLE);
    //  number10 += + 50;
    }


    //    5                   T                    H


    if (button5.getText().equals("350 naira White Rice")) {
    textView.setText("350 naira White Rice");
    textView.setVisibility(View.VISIBLE);
    imageButton.setVisibility(View.VISIBLE);
    //    number1 += 150;
    }
    if (button5.getText().equals("350 naira Jollof Rice"))
    {
    textView2nd.setText("350 naira Jollof Rice");
    textView2nd.setVisibility(View.VISIBLE);
    imageButton2nd.setVisibility(View.VISIBLE);
    //   number2 += 150;
    }
    if (button5.getText().equals("350 naira Fried Rice"))
    {
    textView3rd.setText("350 naira Fried Rice");
    textView3rd.setVisibility(View.VISIBLE);
    imageButton3rd.setVisibility(View.VISIBLE);
    //    number3 += 150;
    }

    if (button5.getText().equals("500 naira Beef(5)"))
    {
    textView4th.setText("500 naira Beef(5)");
    textView4th.setVisibility(View.VISIBLE);
    imageButton4th.setVisibility(View.VISIBLE);
    //    number4 += 100;
    }

    if (button5.getText().equals("1500 naira Chicken(5)"))
    {
    textView5th.setText("1500 naira Chicken(5)");
    textView5th.setVisibility(View.VISIBLE);
    imageButton5th.setVisibility(View.VISIBLE);
    //    number5 += 300;
    }

    if (button5.getText().equals("500 naira MoiMoi(5)"))
    {
    textView6th.setText("500 naira MoiMoi(5)");
    textView6th.setVisibility(View.VISIBLE);
    imageButton6th.setVisibility(View.VISIBLE);
    //   number6 += 100;
    }

    if (button5.getText().equals("250 naira Plantain"))
    {
    textView7th.setText("250 naira Plantain");
    textView7th.setVisibility(View.VISIBLE);
    imageButton7th.setVisibility(View.VISIBLE);
    //    number7 += 50;
    }

    if (button5.getText().equals("250 naira Egg(5)"))
    {
    textView8th.setText("250 naira Egg(5)");
    textView8th.setVisibility(View.VISIBLE);
    imageButton8th.setVisibility(View.VISIBLE);
    //   number8 += 50;
    }

    if (button5.getText().equals("300 naira Sides"))
    {
    textView9th.setText("300 naira Sides");
    textView9th.setVisibility(View.VISIBLE);
    imageButton9th.setVisibility(View.VISIBLE);
    //   number9 += 100;
    }

    if (button5.getText().equals("250 naira Beans"))
    {
    textView10th.setText("250 naira Beans");
    textView10th.setVisibility(View.VISIBLE);
    imageButton10th.setVisibility(View.VISIBLE);
    //   number10 += 50;
    }


    //  6                     T                         H

    if (button6.getText().equals("400 naira White Rice")) {
    textView.setText("400 naira White Rice");
    textView.setVisibility(View.VISIBLE);
    imageButton.setVisibility(View.VISIBLE);
    //  number1 += + 50;
    }


    if (button6.getText().equals("400 naira Jollof Rice"))
    {
    textView2nd.setText("400 naira Jollof Rice");
    textView2nd.setVisibility(View.VISIBLE);
    imageButton2nd.setVisibility(View.VISIBLE);
    // number2 += + 50;
    }
    if (button6.getText().equals("400 naira Fried Rice"))
    {
    textView3rd.setText("400 naira Fried Rice");
    textView3rd.setVisibility(View.VISIBLE);
    imageButton3rd.setVisibility(View.VISIBLE);
    //  number3 += + 50;
    }

    if (button6.getText().equals("600 naira Beef(6)"))
    {
    textView4th.setText("600 naira Beef(6)");
    textView4th.setVisibility(View.VISIBLE);
    imageButton4th.setVisibility(View.VISIBLE);
    // number4 += + 50;
    }

    if (button6.getText().equals("1800 naira Chicken(6)"))
    {
    textView5th.setText("1800 naira Chicken(6)");
    textView5th.setVisibility(View.VISIBLE);
    imageButton5th.setVisibility(View.VISIBLE);
    //    number5 += + 300;
    }

    if (button6.getText().equals("600 naira MoiMoi(6)"))
    {
    textView6th.setText("600 naira MoiMoi(6)");
    textView6th.setVisibility(View.VISIBLE);
    imageButton6th.setVisibility(View.VISIBLE);
    //  number6 += + 50;
    }

    if (button6.getText().equals("300 naira Plantain"))
    {
    textView7th.setText("300 naira Plantain");
    textView7th.setVisibility(View.VISIBLE);
    imageButton7th.setVisibility(View.VISIBLE);
    //   number7 += + 50;
    }

    if (button6.getText().equals("300 naira Egg(6)"))
    {
    textView8th.setText("300 naira Egg(6)");
    textView8th.setVisibility(View.VISIBLE);
    imageButton8th.setVisibility(View.VISIBLE);
    //   number8 += + 50;
    }

    if (button6.getText().equals("400 naira Sides"))
    {
    textView9th.setText("400 naira Sides");
    textView9th.setVisibility(View.VISIBLE);
    imageButton9th.setVisibility(View.VISIBLE);
    // number9 += + 50;
    }

    if (button6.getText().equals("300 naira Beans"))
    {
    textView10th.setText("300 naira Beans");
    textView10th.setVisibility(View.VISIBLE);
    imageButton10th.setVisibility(View.VISIBLE);
    //  number10 += + 50;
    }

    result.append(number1 + number2);
    count.setText(result);

    }  */


/**    @Override public void onClick(View v) {
int number1 = 0, number2 = 0, number3 = 0, number4 = 0, number5 = 0, number6 = 0, number7 = 0, number8 = 0, number9 = 0, number10 = 0;
StringBuilder result = new StringBuilder();

if (button.getText().equals("150 naira White Rice") && button.isPressed()) {
textView.setText("150 naira White Rice");
textView.setVisibility(View.VISIBLE);
number1 += 150;
}
if (button.getText().equals("150 naira Jollof Rice") && button.isPressed())
{
textView2nd.setText("150 naira Jollof Rice");
textView2nd.setVisibility(View.VISIBLE);
number2 += 150;
}
if (button.getText().equals("150 naira Fried Rice"))
{
textView3rd.setText("150 naira Fried Rice");
textView3rd.setVisibility(View.VISIBLE);
number3 += 150;
}

if (button.getText().equals("100 naira Beef"))
{
textView4th.setText("100 naira Beef");
textView4th.setVisibility(View.VISIBLE);
number4 += 100;
}

if (button.getText().equals("300 naira Chicken"))
{
textView5th.setText("300 naira Chicken");
textView5th.setVisibility(View.VISIBLE);
number5 += 300;
}

if (button.getText().equals("100 naira MoiMoi"))
{
textView6th.setText("100 naira MoiMoi");
textView6th.setVisibility(View.VISIBLE);
number6 += 100;
}

if (button.getText().equals("50 naira Plantain"))
{
textView7th.setText("50 naira Plantain");
textView7th.setVisibility(View.VISIBLE);
number7 += 50;
}

if (button.getText().equals("50 naira Egg"))
{
textView8th.setText("50 naira Egg");
textView8th.setVisibility(View.VISIBLE);
number8 += 50;
}

if (button.getText().equals("100 naira Sides"))
{
textView9th.setText("100 naira Sides");
textView9th.setVisibility(View.VISIBLE);
number9 += 100;
}

if (button.getText().equals("50 naira Beans"))
{
textView10th.setText("50 naira Beans");
textView10th.setVisibility(View.VISIBLE);
number10 += 50;
}


//  2                     N                         D

if (button2.getText().equals("200 naira White Rice") && button2.isPressed()) {
textView.setText("200 naira White Rice");
textView.setVisibility(View.VISIBLE);
//  number1 += + 50;
}


if (button2.getText().equals("200 naira Jollof Rice") && button2.isPressed())
{
textView2nd.setText("200 naira Jollof Rice");
textView2nd.setVisibility(View.VISIBLE);
// number2 += + 50;
}
if (button2.getText().equals("200 naira Fried Rice"))
{
textView3rd.setText("200 naira Fried Rice");
textView3rd.setVisibility(View.VISIBLE);
number3 += + 50;
}

if (button2.getText().equals("200 naira Beef(2)"))
{
textView4th.setText("200 naira Beef(2)");
textView4th.setVisibility(View.VISIBLE);
number4 += + 50;
}

if (button2.getText().equals("600 naira Chicken(2)"))
{
textView5th.setText("600 naira Chicken(2)");
textView5th.setVisibility(View.VISIBLE);
number5 += + 300;
}

if (button2.getText().equals("200 naira MoiMoi(2)"))
{
textView6th.setText("200 naira MoiMoi(2)");
textView6th.setVisibility(View.VISIBLE);
number6 += + 50;
}

if (button2.getText().equals("100 naira Plantain"))
{
textView7th.setText("100 naira Plantain");
textView7th.setVisibility(View.VISIBLE);
number7 += + 50;
}

if (button2.getText().equals("100 naira Egg(2)"))
{
textView8th.setText("100 naira Egg(2)");
textView8th.setVisibility(View.VISIBLE);
number8 += + 50;
}

if (button2.getText().equals("150 naira Sides"))
{
textView9th.setText("150 naira Sides");
textView9th.setVisibility(View.VISIBLE);
number9 += + 50;
}

if (button2.getText().equals("100 naira Beans"))
{
textView10th.setText("100 naira Beans");
textView10th.setVisibility(View.VISIBLE);
number10 += + 50;
}

result.append(number1 + number2);
count.setText(result);
} */


    /**
     * public void sendData() {
     * /*   int number1 = 0, number2 = 0, number3 = 0, number4 = 0, number5 = 0,
     * number6 = 0, number7 = 0, number8 = 0, number9 = 0,
     * number10 = 0, result;
     * StringBuilder thankgod = new StringBuilder();
     * <p>
     * if (button.isPressed() && button.getText().equals("150 naira White Rice") /*&&textView.getText().equals("150 naira White Rice" )* ) {
     * //   textView.getText().equals("150 naira White Rice");
     * // number1 = Integer.parseInt("150");
     * count.setText("150");
     * number1 += 150;
     * } else if (textView.getVisibility() == View.VISIBLE && textView.getText().equals("200 naira White Rice")) {
     * //  number1 = Integer.parseInt("200");
     * //    count.setText("200");
     * number1 += 200;
     * } else if (textView.getVisibility() == View.VISIBLE && textView.getText().equals("250 naira White Rice")) {
     * // number1 = Integer.parseInt("250");
     * //    count.setText("250");
     * number1 += 250;
     * } else if (textView.getVisibility() == View.VISIBLE && textView.getText().equals("300 naira White Rice")) {
     * //   number1 = Integer.parseInt("300");
     * //    count.setText("300");
     * number1 += 300;
     * } else if (textView.getVisibility() == View.VISIBLE && textView.getText().equals("350 naira White Rice")) {
     * //    number1 = Integer.parseInt("350");
     * //    count.setText("350");
     * number1 += 350;
     * } else if (textView.getVisibility() == View.VISIBLE && textView.getText().equals("400 naira White Rice")) {
     * //    number1 = Integer.parseInt("400");
     * //     count.setText("400");
     * number1 += 400;
     * }
     * <p>
     * if (textView2nd.getVisibility() == View.VISIBLE && textView2nd.getText().equals("150 naira Jollof Rice")) {
     * //  number2 = Integer.parseInt("150");
     * //     count.setText("150");
     * number2 += 150;
     * } else if (textView2nd.getVisibility() == View.VISIBLE && textView2nd.getText().equals("200 naira Jollof Rice")) {
     * //     number2 = Integer.parseInt("200");
     * //     count.setText("200");
     * number2 += 200;
     * } else if (textView2nd.getVisibility() == View.VISIBLE && textView2nd.getText().equals("250 naira Jollof Rice")) {
     * //      number2 = Integer.parseInt("250");
     * //     count.setText("250");
     * number2 += 250;
     * } else if (textView2nd.getVisibility() == View.VISIBLE && textView2nd.getText().equals("300 naira Jollof Rice")) {
     * //       number2 = Integer.parseInt("300");
     * //     count.setText("300");
     * number2 += 300;
     * } else if (textView2nd.getVisibility() == View.VISIBLE && textView2nd.getText().equals("350 naira Jollof Rice")) {
     * //       number2 = Integer.parseInt("350");
     * //      count.setText("350");
     * number2 += 350;
     * } else if (textView2nd.getVisibility() == View.VISIBLE && textView2nd.getText().equals("400 naira Jollof Rice")) {
     * //       number2 = Integer.parseInt("400");
     * //     count.setText("400");
     * number2 += 400;
     * }
     * <p>
     * if (textView3rd.getVisibility() == View.VISIBLE && textView3rd.getText().equals("150 naira Fried Rice")) {
     * //      number3 = Integer.parseInt("150");
     * //      count.setText("150");
     * number3 += 150;
     * } else if (textView3rd.getVisibility() == View.VISIBLE && textView3rd.getText().equals("200 naira Fried Rice")) {
     * //      number3 = Integer.parseInt("200");
     * //      count.setText("200");
     * number3 += 200;
     * } else if (textView3rd.getVisibility() == View.VISIBLE && textView3rd.getText().equals("250 naira Fried Rice")) {
     * //      number3 = Integer.parseInt("250");
     * //     count.setText("250");
     * number3 += 250;
     * } else if (textView3rd.getVisibility() == View.VISIBLE && textView3rd.getText().equals("300 naira Fried Rice")) {
     * //       number3 = Integer.parseInt("300");
     * //     count.setText("300");
     * number3 += 300;
     * } else if (textView3rd.getVisibility() == View.VISIBLE && textView3rd.getText().equals("350 naira Fried Rice")) {
     * //       number3 = Integer.parseInt("350");
     * //     count.setText("350");
     * number3 += 350;
     * } else if (textView3rd.getVisibility() == View.VISIBLE && textView3rd.getText().equals("400 naira Fried Rice")) {
     * //        number3 = Integer.parseInt("400");
     * //     count.setText("400");
     * number3 += 400;
     * }
     * <p>
     * if (textView4th.getVisibility() == View.VISIBLE && textView4th.getText().equals("100 naira Beef")) {
     * //       number4 = Integer.parseInt("150");
     * //    count.setText("100");
     * number4 += 100;
     * } else if (textView4th.getVisibility() == View.VISIBLE && textView4th.getText().equals("200 naira Beef(2)")) {
     * //        number4 = Integer.parseInt("200");
     * //     count.setText("200");
     * number4 += 200;
     * } else if (textView4th.getVisibility() == View.VISIBLE && textView4th.getText().equals("300 naira Beef(3)")) {
     * //        number4 = Integer.parseInt("300");
     * ///     count.setText("300");
     * number4 += 300;
     * } else if (textView4th.getVisibility() == View.VISIBLE && textView4th.getText().equals("400 naira Beef(4)")) {
     * //        number4 = Integer.parseInt("400");
     * //     count.setText("400");
     * number4 += 400;
     * } else if (textView4th.getVisibility() == View.VISIBLE && textView4th.getText().equals("500 naira Beef(5)")) {
     * //        number4 = Integer.parseInt("500");
     * //     count.setText("500");
     * number4 += 500;
     * } else if (textView4th.getVisibility() == View.VISIBLE && textView4th.getText().equals("600 naira Beef(6)")) {
     * //         number4 = Integer.parseInt("600");
     * //      count.setText("600");
     * number4 += 600;
     * }
     * <p>
     * if (textView5th.getVisibility() == View.VISIBLE && textView5th.getText().equals("300 naira Chicken")) {
     * //        number5 = Integer.parseInt("300");
     * //     count.setText("300");
     * number5 += 300;
     * } else if (textView5th.getVisibility() == View.VISIBLE && textView5th.getText().equals("600 naira Chicken(2)")) {
     * //         number5 = Integer.parseInt("600");
     * //     count.setText("600");
     * number5 += 600;
     * } else if (textView5th.getVisibility() == View.VISIBLE && textView5th.getText().equals("900 naira Chicken(3)")) {
     * //         number5 = Integer.parseInt("900");
     * //    count.setText("900");
     * number5 += 900;
     * } else if (textView5th.getVisibility() == View.VISIBLE && textView5th.getText().equals("1200 naira Chicken(4)")) {
     * //         number5 = Integer.parseInt("1200");
     * //     count.setText("1200");
     * number5 += 1200;
     * } else if (textView5th.getVisibility() == View.VISIBLE && textView5th.getText().equals("1500 naira Chicken(5)")) {
     * //          number5 = Integer.parseInt("1500");
     * //    count.setText("1500");
     * number5 += 1500;
     * } else if (textView5th.getVisibility() == View.VISIBLE && textView5th.getText().equals("1800 naira Chicken(6)")) {
     * //          number5 = Integer.parseInt("1800");
     * //     count.setText("1800");
     * number5 += 1800;
     * }
     * <p>
     * if (textView6th.getVisibility() == View.VISIBLE && textView6th.getText().equals("100 naira MoiMoi")) {
     * //        number6 = Integer.parseInt("100");
     * //     count.setText("100");
     * number6 += 100;
     * } else if (textView6th.getVisibility() == View.VISIBLE && textView6th.getText().equals("200 naira MoiMoi(2)")) {
     * //        number6 = Integer.parseInt("200");
     * //    count.setText("200");
     * number6 += 200;
     * } else if (textView6th.getVisibility() == View.VISIBLE && textView6th.getText().equals("300 naira MoiMoi(3)")) {
     * //        number6 = Integer.parseInt("300");
     * //     count.setText("300");
     * number6 += 300;
     * } else if (textView6th.getVisibility() == View.VISIBLE && textView6th.getText().equals("400 naira MoiMoi(4)")) {
     * //        number6 = Integer.parseInt("400");
     * //     count.setText("400");
     * number6 += 400;
     * } else if (textView6th.getVisibility() == View.VISIBLE && textView6th.getText().equals("500 naira MoiMoi(5)")) {
     * //        number6 = Integer.parseInt("500");
     * //    count.setText("500");
     * number6 += 500;
     * } else if (textView6th.getVisibility() == View.VISIBLE && textView6th.getText().equals("600 naira MoiMoi(6)")) {
     * //          number6 = Integer.parseInt("600");
     * //     count.setText("600");
     * number6 += 600;
     * }
     * <p>
     * if (textView7th.getVisibility() == View.VISIBLE && textView7th.getText().equals("50 naira Plantain")) {
     * //          number7 = Integer.parseInt("50");
     * //     count.setText("50");
     * number7 += 50;
     * } else if (textView7th.getVisibility() == View.VISIBLE && textView7th.getText().equals("100 naira Plantain")) {
     * //         number7 = Integer.parseInt("100");
     * //    count.setText("100");
     * number7 += 100;
     * } else if (textView7th.getVisibility() == View.VISIBLE && textView7th.getText().equals("150 naira Plantain")) {
     * //          number7 = Integer.parseInt("150");
     * //    count.setText("150");
     * number7 += 150;
     * } else if (textView7th.getVisibility() == View.VISIBLE && textView7th.getText().equals("200 naira Plantain")) {
     * //         number7 = Integer.parseInt("200");
     * //     count.setText("200");
     * number7 += 200;
     * } else if (textView7th.getVisibility() == View.VISIBLE && textView7th.getText().equals("250 naira Plantain")) {
     * //         number7 = Integer.parseInt("250");
     * //     count.setText("250");
     * number7 += 250;
     * } else if (textView7th.getVisibility() == View.VISIBLE && textView7th.getText().equals("300 naira Plantain")) {
     * //          number7 = Integer.parseInt("300");
     * //    count.setText("300");
     * number7 += 300;
     * }
     * <p>
     * if (textView8th.getVisibility() == View.VISIBLE && textView8th.getText().equals("50 naira Egg")) {
     * //         number8 = Integer.parseInt("50");
     * //     count.setText("50");
     * number8 += 50;
     * } else if (textView8th.getVisibility() == View.VISIBLE && textView8th.getText().equals("100 naira Egg(2)")) {
     * //         number8 = Integer.parseInt("100");
     * //     count.setText("100");
     * number8 += 100;
     * } else if (textView8th.getVisibility() == View.VISIBLE && textView8th.getText().equals("150 naira Egg(3)")) {
     * //        number8 = Integer.parseInt("150");
     * //     count.setText("150");
     * number8 += 150;
     * } else if (textView8th.getVisibility() == View.VISIBLE && textView8th.getText().equals("200 naira Egg(4)")) {
     * //      number8 = Integer.parseInt("200");
     * //     count.setText("200");
     * number8 += 200;
     * } else if (textView8th.getVisibility() == View.VISIBLE && textView8th.getText().equals("250 naira Egg(5)")) {
     * //        number8 = Integer.parseInt("250");
     * //     count.setText("250");
     * number8 += 250;
     * } else if (textView8th.getVisibility() == View.VISIBLE && textView8th.getText().equals("300 naira Egg(6)")) {
     * //       number8 = Integer.parseInt("300");
     * //     count.setText("300");
     * number8 += 300;
     * }
     * <p>
     * if (textView9th.getVisibility() == View.VISIBLE && textView9th.getText().equals("100 naira Sides")) {
     * //         number9 = Integer.parseInt("100");
     * //     count.setText("100");
     * number9 += 100;
     * } else if (textView9th.getVisibility() == View.VISIBLE && textView9th.getText().equals("150 naira Sides")) {
     * //         number9 = Integer.parseInt("150");
     * //     count.setText("150");
     * number9 += 150;
     * } else if (textView9th.getVisibility() == View.VISIBLE && textView9th.getText().equals("200 naira Sides")) {
     * //         number9 = Integer.parseInt("200");
     * //    count.setText("200");
     * number9 += 200;
     * } else if (textView9th.getVisibility() == View.VISIBLE && textView9th.getText().equals("250 naira Sides")) {
     * //         number9 = Integer.parseInt("250");
     * //   count.setText("250");
     * number9 += 250;
     * } else if (textView9th.getVisibility() == View.VISIBLE && textView9th.getText().equals("300 naira Sides")) {
     * //         number9 = Integer.parseInt("300");
     * //    count.setText("300");
     * number9 += 300;
     * } else if (textView9th.getVisibility() == View.VISIBLE && textView9th.getText().equals("400 naira Sides")) {
     * //         number9 = Integer.parseInt("400");
     * //    count.setText("400");
     * number9 += 400;
     * }
     * <p>
     * if (textView10th.getVisibility() == View.VISIBLE && textView10th.getText().equals("50 naira Beans")) {
     * //         number10 = Integer.parseInt("50");
     * //    count.setText("50");
     * number10 += 50;
     * } else if (textView10th.getVisibility() == View.VISIBLE && textView10th.getText().equals("100 naira Beans")) {
     * //         number10 = Integer.parseInt("100");
     * //   count.setText("100");
     * number10 += 100;
     * } else if (textView10th.getVisibility() == View.VISIBLE && textView10th.getText().equals("150 naira Beans")) {
     * //         number10 = Integer.parseInt("150");
     * //   count.setText("150");
     * number10 += 150;
     * } else if (textView10th.getVisibility() == View.VISIBLE && textView10th.getText().equals("200 naira Beans")) {
     * //        number10 = Integer.parseInt("200");
     * //   count.setText("200");
     * number10 += 200;
     * } else if (textView10th.getVisibility() == View.VISIBLE && textView10th.getText().equals("250 naira Beans")) {
     * //         number10 = Integer.parseInt("250");
     * //  count.setText("250");
     * number10 += 250;
     * } else if (textView10th.getVisibility() == View.VISIBLE && textView10th.getText().equals("300 naira Beans")) {
     * //         number10 = Integer.parseInt("300");
     * // count.setText("300");
     * number10 += 300;
     * }
     * <p>
     * //    thankgod.append(number1 + number2 + number3 + number4 + number5 + number6 + number7 + number8 + number9 + number10);
     * //  count.setText(thankgod);
     * <p>
     * }
     */


    public void ConfirmMyPurchase(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(FoodmenuActivity.this);
        builder.setTitle("Confirm Purchase");
        builder.setMessage("The items you selected will be bought by clicking \nDONE");
        LayoutInflater inflater = FoodmenuActivity.this.getLayoutInflater();
        View view = inflater.inflate(R.layout.fa_confirmpurchase_dialogue, null);
        builder.setView(view)
                .setCancelable(false);
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                StyleableToast NotConfirmed = new StyleableToast(getApplicationContext(), "Transaction not Confirmed", Toast.LENGTH_SHORT).spinIcon();
                NotConfirmed.setBackgroundColor(Color.parseColor("#FF5A5F"));
                NotConfirmed.setTextColor(Color.WHITE);
                NotConfirmed.show();
            }
        });
        builder.setPositiveButton(R.string.done, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                StyleableToast TranCompleted = new StyleableToast(getApplicationContext(), "Transaction Verified", Toast.LENGTH_SHORT).spinIcon();
                TranCompleted.setBackgroundColor(Color.parseColor("#FF5A5F"));
                TranCompleted.setTextColor(Color.WHITE);
                TranCompleted.setIcon(R.drawable.fa_confirmpurchasetoasticon);
                TranCompleted.show();

                Intent intent = new Intent(getBaseContext(), ServingActivity.class);
                intent.putExtra("Key", stringue);

                Bundle dweezy = new Bundle();
                dweezy.putString("favouritism", textView.getText().toString());
                intent.putExtras(dweezy);

                Bundle tobi = new Bundle();
                tobi.putString("genius", textView2nd.getText().toString());
                intent.putExtras(tobi);

                Bundle emmanuel = new Bundle();
                emmanuel.putString("generous", textView3rd.getText().toString());
                intent.putExtras(emmanuel);

                Bundle joseph = new Bundle();
                joseph.putString("focused", textView4th.getText().toString());
                intent.putExtras(joseph);

                Bundle godwin = new Bundle();
                godwin.putString("creativebeast", textView5th.getText().toString());
                intent.putExtras(godwin);

                Bundle funmilayo = new Bundle();
                funmilayo.putString("bestmom", textView6th.getText().toString());
                intent.putExtras(funmilayo);

                Bundle james = new Bundle();
                james.putString("bestdad", textView7th.getText().toString());
                intent.putExtras(james);

                Bundle tomilola = new Bundle();
                tomilola.putString("biggersis", textView8th.getText().toString());
                intent.putExtras(tomilola);

                Bundle opeyemi = new Bundle();
                opeyemi.putString("biggestsis", textView9th.getText().toString());
                intent.putExtras(opeyemi);

                Bundle david = new Bundle();
                david.putString("dhalson", textView10th.getText().toString());
                intent.putExtras(david);


                Bundle PrincessFiance = new Bundle();
                PrincessFiance.putString("prince", WelcomeSweet.getText().toString().substring(8));
                intent.putExtras(PrincessFiance);

                startActivity(intent);
            }

        }).setIcon(R.drawable.a_announcement);
        Dialog dialog = builder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.LTGRAY));
        dialog.show();
        pack = (CheckBox) view.findViewById(R.id.sendpackalso);
        pack.setOnCheckedChangeListener(this);
    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            pack.setText(" Buy in Pack(s)");
            pacque = pack.getText().toString();
            stringue = pacque;
        } else {
            pack.setText(" Buying in Plate(s)");
            pacque = pack.getText().toString();
            stringue = pacque;
        }
    }

    @Override
    public void respond(int i) {
        FragmentManager manager = getFragmentManager();
      /*  FoodavailableFragment faf = (FoodavailableFragment) manager.findFragmentById(R.id.FragmentFoodavailable);
        faf.changeData(i);  */

        FoodpriceFragment fpf = (FoodpriceFragment) manager.findFragmentById(R.id.FragmentFoodprice);
        fpf. Datachange(i);
    }

    @Override
    public void setName(String name) {
        ChosenfoodFragment cff = (ChosenfoodFragment) getFragmentManager().findFragmentById(R.id.FragmentChosenfood);
        cff.updateInfo(name);

        ChosenplateCounter cpc = (ChosenplateCounter) getFragmentManager().findFragmentById(R.id.FragmentCounter);
        cpc.updateInfo(name);

        Pcount.setEnabled(true);
        Purchase.setEnabled(true);
    }

    @Override
    public void setPrice(String price) {
        ChosenplateCounter cpc = (ChosenplateCounter) getFragmentManager().findFragmentById(R.id.FragmentCounter);
        cpc.updatePrice(price);
    }

    @Override
    public void FoodMenuFragmentsRespond(int joseph) {
      /*  FragmentManager VFRmanager = getFragmentManager();
        VendorFragment vendorFragment = (VendorFragment) VFRmanager.findFragmentById(R.id.displayAddorRemoveDialogue);
        vendorFragment.displayGridView(joseph); */
    }

    public void onnItemClick(int i) {
      /*  FragmentManager manager = getFragmentManager();
        FoodavailableFragment faf = (FoodavailableFragment) manager.findFragmentById(R.id.FragmentFoodavailable);
        faf.changeData(i);   */
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.foodactivityappbarmain, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.check_balance:
                break;

            case R.id.like_plate:
                break;

            case R.id.saved_plate:
                break;

            case R.id.log_out:
                break;
        }
        return false;
    }

    public void checkMyBalance(MenuItem item) {
        Snackbar CheckMyMoney = Snackbar.make(relative, "Balance will be Displayed Here", Snackbar.LENGTH_LONG);
        CheckMyMoney.setActionTextColor(Color.GREEN);
        CheckMyMoney.show();
    }

    public void iLikeThisPlate(MenuItem item) {

        String[] strings = {
                textView.isShown() ? textView.getText().toString() : null,
                textView2nd.isShown() ? textView2nd.getText().toString() : null,
                textView3rd.isShown() ? textView3rd.getText().toString() : null,
                textView4th.isShown() ? textView4th.getText().toString() : null,
                textView5th.isShown() ? textView5th.getText().toString() : null,
                textView6th.isShown() ? textView6th.getText().toString() : null,
                textView7th.isShown() ? textView7th.getText().toString() : null,
                textView8th.isShown() ? textView8th.getText().toString() : null,
                textView9th.isShown() ? textView9th.getText().toString() : null,
                textView10th.isShown() ? textView10th.getText().toString() : null};

        Bundle bundle = new Bundle();
        bundle.putString("string", String.valueOf(strings));

        //  Intent intent = new Intent(this, FoodhistoryActivity.class);
        //  intent.putExtra("string", strings);
        //  startActivity(intent);

        if (!textView.isShown() && !textView2nd.isShown() && !textView3rd.isShown()
                && !textView4th.isShown() && !textView5th.isShown() && !textView6th.isShown()
                && !textView7th.isShown() && !textView8th.isShown() && !textView9th.isShown()
                && !textView10th.isShown()) {

            StyleableToast LikePlate = new StyleableToast(this, "No food selected yet, Select one foodtype at least ", Toast.LENGTH_SHORT);
            LikePlate.setBackgroundColor(Color.parseColor("#FF5A5F"));
            LikePlate.setTextColor(Color.WHITE);
            LikePlate.show();
        } else {
            StyleableToast LikePlate = new StyleableToast(this, "I Like You Too", Toast.LENGTH_SHORT).spinIcon();
            LikePlate.setBackgroundColor(Color.parseColor("#FF5A5F"));
            LikePlate.setTextColor(Color.WHITE);
            LikePlate.setIcon(R.drawable.fa_lovethisplaterotatingtoasticon);
            LikePlate.show();
            Snackbar meetpie = Snackbar.make(relative, "Plate Liked and Added to History", Snackbar.LENGTH_LONG);
            meetpie.setAction("UNDO", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Here and Up add codes using (FabExample-tutorial) to add or remove food liked from ChosenfoodFragment into Settings.class, via listview
                    Snackbar.make(relative, "Plate Removed Successfully", Snackbar.LENGTH_SHORT).show();
                }
            });
            meetpie.setActionTextColor(Color.GREEN);
            meetpie.show();
        }

    }

    public void showRecentlyBoughtPlates(MenuItem item){

        String[] strings = {
                textView.isShown() ? textView.getText().toString() : null,
                textView2nd.isShown() ? textView2nd.getText().toString() : null,
                textView3rd.isShown() ? textView3rd.getText().toString() : null,
                textView4th.isShown() ? textView4th.getText().toString() : null,
                textView5th.isShown() ? textView5th.getText().toString() : null,
                textView6th.isShown() ? textView6th.getText().toString() : null,
                textView7th.isShown() ? textView7th.getText().toString() : null,
                textView8th.isShown() ? textView8th.getText().toString() : null,
                textView9th.isShown() ? textView9th.getText().toString() : null,
                textView10th.isShown() ? textView10th.getText().toString() : null};

        if (!textView.isShown() && !textView2nd.isShown() && !textView3rd.isShown()
                && !textView4th.isShown() && !textView5th.isShown() && !textView6th.isShown()
                && !textView7th.isShown() && !textView8th.isShown() && !textView9th.isShown()
                && !textView10th.isShown()) {

            StyleableToast LikePlate = new StyleableToast(this, "No food selected yet, Select one foodtype at least ", Toast.LENGTH_SHORT);
            LikePlate.setBackgroundColor(Color.parseColor("#FF5A5F"));
            LikePlate.setTextColor(Color.WHITE);
            LikePlate.show();
        }
        else {
            StyleableToast RecentlyPurchased = new StyleableToast(this, "Please select from recently bought plates", Toast.LENGTH_LONG).spinIcon();
            RecentlyPurchased.setBackgroundColor(Color.parseColor("#FF5A5F"));
            RecentlyPurchased.setTextColor(Color.WHITE);
            RecentlyPurchased.show();
            Intent intent = new Intent(this, FoodhistoryActivity.class);
            intent.putExtra("string", strings);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_up_in, R.anim.slide_up_out);
        }
    }

    public void AlrightImOff(MenuItem item) {
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        setTitle("");
        alertDialog.setTitle("End Transaction");
        alertDialog.setMessage("This action will cancel this current operation. Do you want to cancel your transaction? ");
        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }).setIcon(R.drawable.a_alert);

        Dialog dialog = alertDialog.create();
        dialog.show();
    }

    public void maxPlateCount(View view) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(FoodmenuActivity.this);
        final Bundle woods = getIntent().getExtras();
        try {
            final String[] whiteRing = woods.getStringArray("diamond");
              if (!Arrays.toString(woods.getStringArray("diamond")).isEmpty()) {
                  builder.setItems(whiteRing, new DialogInterface.OnClickListener() {
                      @Override
                      public void onClick(DialogInterface dialog, int which) {
                          if (which == 0) {
                              StyleableToast CheckMyMoney = new StyleableToast(getApplicationContext(), "You are buying all in a plate", Toast.LENGTH_SHORT).spinIcon();
                              CheckMyMoney.setBackgroundColor(Color.parseColor("#FF5A5F"));
                              CheckMyMoney.setTextColor(Color.WHITE);
                              CheckMyMoney.show();
                          }
                          if (which == 1) {
                              StyleableToast CheckMyMoney = new StyleableToast(getApplicationContext(), "You are buying all in two diff plates", Toast.LENGTH_SHORT).spinIcon();
                              CheckMyMoney.setBackgroundColor(Color.parseColor("#FF5A5F"));
                              CheckMyMoney.setTextColor(Color.WHITE);
                              CheckMyMoney.show();
                          }
                          if (which == 2) {
                              StyleableToast CheckMyMoney = new StyleableToast(getApplicationContext(), "You are buying all in three diff plates", Toast.LENGTH_SHORT).spinIcon();
                              CheckMyMoney.setBackgroundColor(Color.parseColor("#FF5A5F"));
                              CheckMyMoney.setTextColor(Color.WHITE);
                              CheckMyMoney.show();
                          }
                          if (which == 3) {
                              StyleableToast CheckMyMoney = new StyleableToast(getApplicationContext(), "You are buying all in four diff plates", Toast.LENGTH_SHORT).spinIcon();
                              CheckMyMoney.setBackgroundColor(Color.parseColor("#FF5A5F"));
                              CheckMyMoney.setTextColor(Color.WHITE);
                              CheckMyMoney.show();
                          }
                          if (which == 4) {
                              StyleableToast CheckMyMoney = new StyleableToast(getApplicationContext(), "You are buying all in five diff plates", Toast.LENGTH_SHORT).spinIcon();
                              CheckMyMoney.setBackgroundColor(Color.parseColor("#FF5A5F"));
                              CheckMyMoney.setTextColor(Color.WHITE);
                              CheckMyMoney.show();
                          }
                          if (which == 5) {
                              StyleableToast CheckMyMoney = new StyleableToast(getApplicationContext(), "You are buying all in six diff plates", Toast.LENGTH_SHORT).spinIcon();
                              CheckMyMoney.setBackgroundColor(Color.parseColor("#FF5A5F"));
                              CheckMyMoney.setTextColor(Color.WHITE);
                              CheckMyMoney.show();
                          }
                          if (which == 6) {
                              StyleableToast CheckMyMoney = new StyleableToast(getApplicationContext(), "You are buying all in seven diff plates", Toast.LENGTH_SHORT).spinIcon();
                              CheckMyMoney.setBackgroundColor(Color.parseColor("#FF5A5F"));
                              CheckMyMoney.setTextColor(Color.WHITE);
                              CheckMyMoney.show();
                          }
                          if (which == 7) {
                              StyleableToast CheckMyMoney = new StyleableToast(getApplicationContext(), "You are buying all in eight diff plates", Toast.LENGTH_SHORT).spinIcon();
                              CheckMyMoney.setBackgroundColor(Color.parseColor("#FF5A5F"));
                              CheckMyMoney.setTextColor(Color.WHITE);
                              CheckMyMoney.show();
                          }
                          if (which == 8) {
                              StyleableToast CheckMyMoney = new StyleableToast(getApplicationContext(), "You are buying all in nine diff plates", Toast.LENGTH_SHORT).spinIcon();
                              CheckMyMoney.setBackgroundColor(Color.parseColor("#FF5A5F"));
                              CheckMyMoney.setTextColor(Color.WHITE);
                              CheckMyMoney.show();
                          }
                          if (which == 9) {
                              StyleableToast CheckMyMoney = new StyleableToast(getApplicationContext(), "You are buying all in ten diff plates", Toast.LENGTH_SHORT).spinIcon();
                              CheckMyMoney.setBackgroundColor(Color.parseColor("#FF5A5F"));
                              CheckMyMoney.setTextColor(Color.WHITE);
                              CheckMyMoney.show();
                          }
                          if (which == 10) {
                              StyleableToast CheckMyMoney = new StyleableToast(getApplicationContext(), "You are buying all in eleven diff plates", Toast.LENGTH_SHORT).spinIcon();
                              CheckMyMoney.setBackgroundColor(Color.parseColor("#FF5A5F"));
                              CheckMyMoney.setTextColor(Color.WHITE);
                              CheckMyMoney.show();
                          }
                          if (which == 11) {
                              StyleableToast CheckMyMoney = new StyleableToast(getApplicationContext(), "You are buying all in twelve diff plates", Toast.LENGTH_SHORT).spinIcon();
                              CheckMyMoney.setBackgroundColor(Color.parseColor("#FF5A5F"));
                              CheckMyMoney.setTextColor(Color.WHITE);
                              CheckMyMoney.show();
                          }
                          if (which == 12) {
                              StyleableToast CheckMyMoney = new StyleableToast(getApplicationContext(), "You are buying all in thirteen diff plates", Toast.LENGTH_SHORT).spinIcon();
                              CheckMyMoney.setBackgroundColor(Color.parseColor("#FF5A5F"));
                              CheckMyMoney.setTextColor(Color.WHITE);
                              CheckMyMoney.show();
                          }
                          if (which == 13) {
                              StyleableToast CheckMyMoney = new StyleableToast(getApplicationContext(), "You are buying all in fourteen diff plates", Toast.LENGTH_SHORT).spinIcon();
                              CheckMyMoney.setBackgroundColor(Color.parseColor("#FF5A5F"));
                              CheckMyMoney.setTextColor(Color.WHITE);
                              CheckMyMoney.show();
                          }
                          if (which == 14) {
                              StyleableToast CheckMyMoney = new StyleableToast(getApplicationContext(), "You are buying all in fifteen diff plates", Toast.LENGTH_SHORT).spinIcon();
                              CheckMyMoney.setBackgroundColor(Color.parseColor("#FF5A5F"));
                              CheckMyMoney.setTextColor(Color.WHITE);
                              CheckMyMoney.show();
                          }
                          if (which == 15) {
                              StyleableToast CheckMyMoney = new StyleableToast(getApplicationContext(), "You are buying all in sixteen diff plates", Toast.LENGTH_SHORT).spinIcon();
                              CheckMyMoney.setBackgroundColor(Color.parseColor("#FF5A5F"));
                              CheckMyMoney.setTextColor(Color.WHITE);
                              CheckMyMoney.show();
                          }
                          if (which == 16) {
                              StyleableToast CheckMyMoney = new StyleableToast(getApplicationContext(), "You are buying all in seventeen diff plates", Toast.LENGTH_SHORT).spinIcon();
                              CheckMyMoney.setBackgroundColor(Color.parseColor("#FF5A5F"));
                              CheckMyMoney.setTextColor(Color.WHITE);
                              CheckMyMoney.show();
                          }
                          if (which == 17) {
                              StyleableToast CheckMyMoney = new StyleableToast(getApplicationContext(), "You are buying all in eighteen diff plates", Toast.LENGTH_SHORT).spinIcon();
                              CheckMyMoney.setBackgroundColor(Color.parseColor("#FF5A5F"));
                              CheckMyMoney.setTextColor(Color.WHITE);
                              CheckMyMoney.show();
                          }
                          if (which == 18) {
                              StyleableToast CheckMyMoney = new StyleableToast(getApplicationContext(), "You are buying all in nineteen diff plates", Toast.LENGTH_SHORT).spinIcon();
                              CheckMyMoney.setBackgroundColor(Color.parseColor("#FF5A5F"));
                              CheckMyMoney.setTextColor(Color.WHITE);
                              CheckMyMoney.show();
                          }
                          if (which == 19) {
                              StyleableToast CheckMyMoney = new StyleableToast(getApplicationContext(), "You are buying all in twenty diff plates", Toast.LENGTH_SHORT).spinIcon();
                              CheckMyMoney.setBackgroundColor(Color.parseColor("#FF5A5F"));
                              CheckMyMoney.setTextColor(Color.WHITE);
                              CheckMyMoney.show();
                          }
                          if (which == 20) {
                              StyleableToast CheckMyMoney = new StyleableToast(getApplicationContext(), "You are buying all in twentyone diff plates", Toast.LENGTH_SHORT).spinIcon();
                              CheckMyMoney.setBackgroundColor(Color.parseColor("#FF5A5F"));
                              CheckMyMoney.setTextColor(Color.WHITE);
                              CheckMyMoney.show();
                          }
                          if (which == 21) {
                              StyleableToast CheckMyMoney = new StyleableToast(getApplicationContext(), "You are buying all in twentytwo diff plates", Toast.LENGTH_SHORT).spinIcon();
                              CheckMyMoney.setBackgroundColor(Color.parseColor("#FF5A5F"));
                              CheckMyMoney.setTextColor(Color.WHITE);
                              CheckMyMoney.show();
                          }
                          if (which == 22) {
                              StyleableToast CheckMyMoney = new StyleableToast(getApplicationContext(), "You are buying all in twentythree diff plates", Toast.LENGTH_SHORT).spinIcon();
                              CheckMyMoney.setBackgroundColor(Color.parseColor("#FF5A5F"));
                              CheckMyMoney.setTextColor(Color.WHITE);
                              CheckMyMoney.show();
                          }
                          if (which == 23) {
                              StyleableToast CheckMyMoney = new StyleableToast(getApplicationContext(), "You are buying all in twentyfour diff plates", Toast.LENGTH_SHORT).spinIcon();
                              CheckMyMoney.setBackgroundColor(Color.parseColor("#FF5A5F"));
                              CheckMyMoney.setTextColor(Color.WHITE);
                              CheckMyMoney.show();
                          }
                          if (which == 24) {
                              StyleableToast CheckMyMoney = new StyleableToast(getApplicationContext(), "You are buying all in twentyfive diff plates", Toast.LENGTH_SHORT).spinIcon();
                              CheckMyMoney.setBackgroundColor(Color.parseColor("#FF5A5F"));
                              CheckMyMoney.setTextColor(Color.WHITE);
                              CheckMyMoney.show();
                          }
                          if (which == 25) {
                              StyleableToast CheckMyMoney = new StyleableToast(getApplicationContext(), "You are buying all in twentysix diff plates", Toast.LENGTH_SHORT).spinIcon();
                              CheckMyMoney.setBackgroundColor(Color.parseColor("#FF5A5F"));
                              CheckMyMoney.setTextColor(Color.WHITE);
                              CheckMyMoney.show();
                          }
                          if (which == 26) {
                              StyleableToast CheckMyMoney = new StyleableToast(getApplicationContext(), "You are buying all in twentyseven diff plates", Toast.LENGTH_SHORT).spinIcon();
                              CheckMyMoney.setBackgroundColor(Color.parseColor("#FF5A5F"));
                              CheckMyMoney.setTextColor(Color.WHITE);
                              CheckMyMoney.show();
                          }
                          if (which == 27) {
                              StyleableToast CheckMyMoney = new StyleableToast(getApplicationContext(), "You are buying all in twentyeight diff plates", Toast.LENGTH_SHORT).spinIcon();
                              CheckMyMoney.setBackgroundColor(Color.parseColor("#FF5A5F"));
                              CheckMyMoney.setTextColor(Color.WHITE);
                              CheckMyMoney.show();
                          }
                          if (which == 28) {
                              StyleableToast CheckMyMoney = new StyleableToast(getApplicationContext(), "You are buying all in twentynine diff plates", Toast.LENGTH_SHORT).spinIcon();
                              CheckMyMoney.setBackgroundColor(Color.parseColor("#FF5A5F"));
                              CheckMyMoney.setTextColor(Color.WHITE);
                              CheckMyMoney.show();
                          }
                          if (which == 29) {
                              StyleableToast CheckMyMoney = new StyleableToast(getApplicationContext(), "You are buying all in thirty diff plates", Toast.LENGTH_SHORT).spinIcon();
                              CheckMyMoney.setBackgroundColor(Color.parseColor("#FF5A5F"));
                              CheckMyMoney.setTextColor(Color.WHITE);
                              CheckMyMoney.show();
                          }
                      }
                  });
              } else  if ( //Arrays.toString(woods.getStringArray("diamond")).isEmpty()
                      VendorActivity.radioGroup.getVisibility() == View.GONE ||
                              VendorActivity.radioGroup.getVisibility() == View.INVISIBLE) {
                  builder.setItems(R.array.DefaultPlatenumber, new DialogInterface.OnClickListener() {
                      @Override
                      public void onClick(DialogInterface dialog, int which) {

                      }
                  });
              }
        }
        catch (NullPointerException n) {
            Toast.makeText(getApplicationContext(), "Ooops", Toast.LENGTH_LONG).show();
        }
        builder.setCancelable(true);
//        } else {
//            builder.setItems(R.array.TwoPlatenumbers, new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//
//                }
//            });
//        }
        Dialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public void onBackPressed() {
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        setTitle("");
        alertDialog.setTitle("End Transaction");
        alertDialog.setMessage("This action will cancel this current operation. Do you want to cancel your transaction? ");
        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }).setIcon(R.drawable.a_alert);

        Dialog dialog = alertDialog.create();
        dialog.show();
    }

    @Override
    public boolean onSupportNavigateUp() {
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("End Transaction");
        alertDialog.setMessage("This action will cancel this current operation. Do you want to Cancel your transaction? ");
        alertDialog.setIcon(R.drawable.a_alert);
        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alertDialog.create().show();
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("FoodmenuActivity","onStart invoked");
        reverseAnime(OperationAnimation.BEGIN);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("FoodmenuActivity","onResume invoked");
        wakeLock.acquire();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("FoodmenuActivity", "onPause invoked");
        wakeLock.release();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("FoodmenuActivity","onStop invoked");
        reverseAnime(OperationAnimation.ADJOURN);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("FoodmenuActivity","onRestart invoked");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("FoodmenuActivity","onDestroy invoked");
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    private void reverseAnime(OperationAnimation bedCheck) {
        Drawable graphicsPad = AnimatedImageView.getDrawable();
        Animatable crazitivity = ((Animatable) graphicsPad);
        switch (bedCheck) {
            case BEGIN:
                crazitivity.start();
                break;
            case ADJOURN:
                crazitivity.stop();
                break;
        }
    }
}
