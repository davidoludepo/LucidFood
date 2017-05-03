package com.icdatofcusgmail.lucidfood;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.PowerManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class ServingActivity extends AppCompatActivity {

    /** Build Internal-Storage here and External-Storage here for
     * bought foods using the tutorials
     * InternalDataStorage
     * and
     * ExternalDataStorage
     * @param savedInstanceState
     */

    PowerManager.WakeLock wakeLock;
    TextView textViewun, textViewdo, textViewtrois, textViewquartz, textViewfive, textViewsix, textViewsept, textVieweight, textViewnous, textViewten, textViewPlateorPark;
    TextView textView, textView2nd, textView3rd, textView4th, textView5th, textView6th, textView7th, textView8th, textView9th, textView10th;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serving);
        Log.d("ServingActivity","onCreate invoked");
        PowerManager powerManager = (PowerManager) getSystemService(Context.POWER_SERVICE);
        wakeLock = powerManager.newWakeLock(PowerManager.FULL_WAKE_LOCK, "deprecatedmyfoot");
        wakeLock.acquire();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(android.R.color.transparent));
        }

        textViewun = (TextView) findViewById(R.id.plate1);
        textViewun.setVisibility(View.GONE);
        textViewdo = (TextView) findViewById(R.id.plate2);
        textViewdo.setVisibility(View.GONE);
        textViewtrois = (TextView) findViewById(R.id.plate3);
        textViewtrois.setVisibility(View.GONE);
        textViewquartz = (TextView) findViewById(R.id.plate4);
        textViewquartz.setVisibility(View.GONE);
        textViewfive = (TextView) findViewById(R.id.plate5);
        textViewfive.setVisibility(View.GONE);
        textViewsix = (TextView) findViewById(R.id.plate6);
        textViewsix.setVisibility(View.GONE);
        textViewsept = (TextView) findViewById(R.id.plate7);
        textViewsept.setVisibility(View.GONE);
        textVieweight = (TextView) findViewById(R.id.plate8);
        textVieweight.setVisibility(View.GONE);
        textViewnous = (TextView) findViewById(R.id.plate9);
        textViewnous.setVisibility(View.GONE);
        textViewten = (TextView) findViewById(R.id.plate10);
        textViewten.setVisibility(View.GONE);
        textViewPlateorPark = (TextView) findViewById(R.id.PackorPlate);

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

        Intent PorP = getIntent();
        String receivedvalue = PorP.getStringExtra("Key");
        if (receivedvalue.contentEquals(" Buying in Plate(s)"))
            textViewPlateorPark.setText("All in Plate");
        else {
            textViewPlateorPark.setText("All in Pack");
        }

        Intent i = getIntent();
        String s = i.getStringExtra("favouritism");
        if (s.getClass().getClassLoader().equals(""))
            textViewun.setVisibility(View.GONE);
        else {
            textViewun = (TextView) findViewById(R.id.plate1);
            Bundle dweezy = getIntent().getExtras();
            textViewun.setText(dweezy.getString("favouritism"));
            textViewun.setVisibility(View.VISIBLE);
        }

        Intent ii = getIntent();
        String ss = ii.getStringExtra("genius");
        if (ss.getClass().getClassLoader().equals(""))
            textViewdo.setVisibility(View.GONE);
        else {
            textViewdo = (TextView) findViewById(R.id.plate2);
            Bundle tobi = getIntent().getExtras();
            textViewdo.setText(tobi.getString("genius"));
            textViewdo.setVisibility(View.VISIBLE);
        }

        Intent iii = getIntent();
        String sss = iii.getStringExtra("generous");

        if (sss.getClass().getClassLoader().equals("")) {
            textViewtrois.setVisibility(View.GONE);
        } else {
            textViewtrois = (TextView) findViewById(R.id.plate3);
            Bundle emmanuel = getIntent().getExtras();
            textViewtrois.setText(emmanuel.getString("generous"));
            textViewtrois.setVisibility(View.VISIBLE);
        }

        Intent j = getIntent();
        String t = j.getStringExtra("focused");

        if (t.getClass().getClassLoader().equals("")) {
            textViewquartz.setVisibility(View.GONE);
        } else {
            textViewquartz = (TextView) findViewById(R.id.plate4);
            Bundle joseph = getIntent().getExtras();
            textViewquartz.setText(joseph.getString("focused"));
            textViewquartz.setVisibility(View.VISIBLE);
        }

        Intent jj = getIntent();
        String tt = jj.getStringExtra("creativebeast");

        if (tt.getClass().getClassLoader().equals(""))
            textViewfive.setVisibility(View.GONE);
        else {
            textViewfive = (TextView) findViewById(R.id.plate5);
            Bundle godwin = getIntent().getExtras();
            textViewfive.setText(godwin.getString("creativebeast"));
            textViewfive.setVisibility(View.VISIBLE);
        }

        Intent jjj = getIntent();
        String ttt = jjj.getStringExtra("bestmom");

        if (ttt.getClass().getClassLoader().equals(""))
            textViewsix.setVisibility(View.GONE);
        else {
            textViewsix = (TextView) findViewById(R.id.plate6);
            Bundle funmilayo = getIntent().getExtras();
            textViewsix.setText(funmilayo.getString("bestmom"));
            textViewsix.setVisibility(View.VISIBLE);
        }

        Intent k = getIntent();
        String u = k.getStringExtra("bestdad");

        if (u.getClass().getClassLoader().equals(""))
             textViewsept.setVisibility(View.GONE);
        else {
            textViewsept = (TextView) findViewById(R.id.plate7);
            Bundle james = getIntent().getExtras();
            textViewsept.setText(james.getString("bestdad"));
            textViewsept.setVisibility(View.VISIBLE);
        }

        Intent kk = getIntent();
        String uu = kk.getStringExtra("biggersis");

        if (uu.getClass().getClassLoader().equals(""))
            textVieweight.setVisibility(View.GONE);
        else {
            textVieweight = (TextView) findViewById(R.id.plate8);
            Bundle tomilola = getIntent().getExtras();
            textVieweight.setText(tomilola.getString("biggersis"));
            textVieweight.setVisibility(View.VISIBLE);
        }

        Intent kkk = getIntent();
        String uuu = kkk.getStringExtra("biggestsis");

        if (uuu.getClass().getClassLoader().equals(""))
            textViewnous.setVisibility(View.GONE);
        else {
            textViewnous = (TextView) findViewById(R.id.plate9);
            Bundle opeyemi = getIntent().getExtras();
            textViewnous.setText(opeyemi.getString("biggestsis"));
            textViewnous.setVisibility(View.VISIBLE);
        }

        Intent l = getIntent();
        String v = l.getStringExtra("dhalson");

        if (v.getClass().getClassLoader().equals(""))
           textViewten.setVisibility(View.GONE);
        else {
            textViewten = (TextView) findViewById(R.id.plate10);
            Bundle david = getIntent().getExtras();
            textViewten.setText(david.getString("dhalson"));
            textViewten.setVisibility(View.VISIBLE);
        }
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
        wakeLock.acquire();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("ServingActivity","onPause invoked");
        wakeLock.release();
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
