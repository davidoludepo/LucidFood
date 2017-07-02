package com.icdatofcusgmail.lucidfood.FoodmenuActivityArchive;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.icdatofcusgmail.lucidfood.R;

public class FoodhistoryActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foodhistory);
        Log.d("FoodhistoryActivity","onCreate invoked");

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

        textView = (TextView) findViewById(R.id.history);

        Intent intent = getIntent();
        String[] str = intent.getStringArrayExtra("string");

        for (String s : str) {
            if (!(s == null)) {
                textView.setText(textView.getText() +  s  + ",   ");
            }
        }
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
