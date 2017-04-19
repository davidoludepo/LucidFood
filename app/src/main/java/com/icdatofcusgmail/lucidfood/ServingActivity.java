package com.icdatofcusgmail.lucidfood;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

public class ServingActivity extends AppCompatActivity {


    /** Build Internal-Storage here and External-Storage here for
     * bought foods using the tutorials
     * InternalDataStorage
     * and
     * ExternalDataStorage
     * @param savedInstanceState
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serving);
        Log.d("ServingActivity","onCreate invoked");

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(android.R.color.transparent));
        }
        TextView textView = (TextView) findViewById(R.id.plate1);
        TextView textView2 = (TextView) findViewById(R.id.plate2);
        TextView textView3 = (TextView) findViewById(R.id.plate3);
        TextView textView4 = (TextView) findViewById(R.id.plate4);
        TextView textView5 = (TextView) findViewById(R.id.plate5);
        TextView textView6 = (TextView) findViewById(R.id.plate6);
        TextView textView7 = (TextView) findViewById(R.id.plate7);
        TextView textView8 = (TextView) findViewById(R.id.plate8);
        TextView textView9 = (TextView) findViewById(R.id.plate9);
        TextView textView10 = (TextView) findViewById(R.id.plate10);

    }

    public void NextTransactionPlease (View view) {
        Intent StopFoodServicing = new Intent(this, FoodServicing.class);
        stopService(StopFoodServicing);

        Intent lucid = new Intent(this, VendorActivity.class);
        startActivity(lucid);
    }

    @Override
    public void onBackPressed() {
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Unnecessary Move");
        alertDialog.setMessage("This action is prevented and unnecessary");
        alertDialog.setIcon(R.drawable.a_alert);
        alertDialog.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alertDialog.create().show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ServingActivity","onStart invoked");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ServingActivity","onResume invoked");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("ServingActivity","onPause invoked");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("ServingActivity","onRestart invoked");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("ServingActivity","onDestroy invoked");
    }
}
