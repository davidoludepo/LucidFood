package com.icdatofcusgmail.lucidfood;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;

public class FoodhistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foodhistory);
        Log.d("FoodhistoryActivity","onCreate invoked");

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("FoodhistoryActivity","onStart invoked");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("FoodhistoryActivity","onResume invoked");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("FoodhistoryActivity","onPause invoked");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("FoodhistoryActivity","onRestart invoked");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("FoodhistoryActivity","onDestroy invoked");
    }
}
