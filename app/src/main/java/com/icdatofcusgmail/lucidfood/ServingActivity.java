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


    TextView textViewun, textViewdo, textViewtrois, textViewquartz, textViewfive, textViewsix, textViewsept, textVieweight, textViewnous, textViewten;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serving);
        Log.d("ServingActivity","onCreate invoked");

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        textViewun = (TextView) findViewById(R.id.plate1);
        textViewdo = (TextView) findViewById(R.id.plate2);
        textViewtrois = (TextView) findViewById(R.id.plate3);
        textViewquartz = (TextView) findViewById(R.id.plate4);
        textViewfive = (TextView) findViewById(R.id.plate5);
        textViewsix = (TextView) findViewById(R.id.plate6);
        textViewsept = (TextView) findViewById(R.id.plate7);
        textVieweight = (TextView) findViewById(R.id.plate8);
        textViewnous = (TextView) findViewById(R.id.plate9);
        textViewten = (TextView) findViewById(R.id.plate10);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(android.R.color.transparent));
        }

      /*  if (textViewun.getText().toString().isEmpty()) {
            textViewun.setVisibility(View.GONE);
        } else { */
            textViewun = (TextView) findViewById(R.id.plate1);
            Bundle dweezy = getIntent().getExtras();
            textViewun.setText(dweezy.getString("favouritism"));
       // }

     //   if (textViewdo.getText().toString().isEmpty()) {
       //     textViewdo.setVisibility(View.GONE);
     //   } else {
            textViewdo = (TextView) findViewById(R.id.plate2);
            Bundle tobi = getIntent().getExtras();
            textViewdo.setText(tobi.getString("genius"));
      //  }

     //   if (textViewtrois.getText().toString().isEmpty()) {
     //       textViewtrois.setVisibility(View.GONE);
     //   } else {
            textViewtrois = (TextView) findViewById(R.id.plate3);
            Bundle emmanuel = getIntent().getExtras();
            textViewtrois.setText(emmanuel.getString("generous"));
     //   }

    //    if (textViewquartz.getText().toString().isEmpty()) {
     //       textViewquartz.setVisibility(View.GONE);
     //   } else {
            textViewquartz = (TextView) findViewById(R.id.plate4);
            Bundle joseph = getIntent().getExtras();
            textViewquartz.setText(joseph.getString("focused"));
    //    }

    //    if (textViewfive.getText().toString().isEmpty()) {
    //        textViewfive.setVisibility(View.GONE);
    //    } else {
            textViewfive = (TextView) findViewById(R.id.plate5);
            Bundle godwin = getIntent().getExtras();
            textViewfive.setText(godwin.getString("creativebeast"));
    //    }

   //     if (textViewsix.getText().toString().isEmpty()) {
   //         textViewsix.setVisibility(View.GONE);
   //     } else {
            textViewsix = (TextView) findViewById(R.id.plate6);
            Bundle funmilayo = getIntent().getExtras();
            textViewsix.setText(funmilayo.getString("bestmom"));
   //     }

   //     if (textViewsept.getText().toString().isEmpty()) {
   //         textViewsept.setVisibility(View.GONE);
  //      } else {
            textViewsept = (TextView) findViewById(R.id.plate7);
            Bundle james = getIntent().getExtras();
            textViewsept.setText(james.getString("bestdad"));
  //      }

  //      if (textVieweight.getText().toString().isEmpty()) {
   //         textVieweight.setVisibility(View.GONE);
   //     } else {
            textVieweight = (TextView) findViewById(R.id.plate8);
            Bundle tomilola = getIntent().getExtras();
            textVieweight.setText(tomilola.getString("biggersis"));
   //     }

   //     if (textViewnous.getText().toString().isEmpty()) {
   //         textViewnous.setVisibility(View.GONE);
   //     } else {
            textViewnous = (TextView) findViewById(R.id.plate9);
            Bundle opeyemi = getIntent().getExtras();
            textViewnous.setText(opeyemi.getString("biggestsis"));
   //     }

  //      if (textViewten.getText().toString().isEmpty()) {
  //          textViewten.setVisibility(View.GONE);
  //      } else {
            textViewten = (TextView) findViewById(R.id.plate10);
            Bundle david = getIntent().getExtras();
            textViewten.setText(david.getString("dhalson"));
  //      }
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
