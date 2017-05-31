package com.icdatofcusgmail.lucidfood.ServingActivityArchve;

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

import com.icdatofcusgmail.lucidfood.FoodServicing;
import com.icdatofcusgmail.lucidfood.FoodmenuActivityArchive.FoodmenuActivity;
import com.icdatofcusgmail.lucidfood.R;
import com.icdatofcusgmail.lucidfood.VendorActivityArchive.VendorActivity;

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
    TextView pleaseServeMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serving);
        Log.d("ServingActivity", "onCreate invoked");
        PowerManager powerManager = (PowerManager) getSystemService(Context.POWER_SERVICE);
        wakeLock = powerManager.newWakeLock(PowerManager.FULL_WAKE_LOCK, "deprecatedmyfoot");
        wakeLock.acquire();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(android.R.color.transparent));
        }

        pleaseServeMe = (TextView) findViewById(R.id.serveMePlease);
        Bundle SecondParcel = getIntent().getExtras();
        pleaseServeMe.setText("Please serve " + SecondParcel.getString("prince") + " the following:" );

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
        if (receivedvalue.contentEquals(" Buy in Pack(s)"))
            textViewPlateorPark.setText("" +  "" + "All in Pack");
        else {
            textViewPlateorPark.setText("" + "" + "All in Plate");
        }

        Intent favouritism = getIntent();
        String dweezy = favouritism.getStringExtra("favouritism");
        if (FoodmenuActivity.textView.getVisibility() == View.VISIBLE) {
            textViewun.setText(dweezy);
            textViewun.setVisibility(View.VISIBLE);
        } else if (FoodmenuActivity.textView.getVisibility() == View.GONE) {
            textViewun.setVisibility(View.GONE);
        }

        Intent genius = getIntent();
        String tobi = genius.getStringExtra("genius");
        if (FoodmenuActivity.textView2nd.getVisibility() == View.VISIBLE) {
            textViewdo.setText(tobi);
            textViewdo.setVisibility(View.VISIBLE);
        } else if (FoodmenuActivity.textView2nd.getVisibility() == View.GONE) {
            textViewdo.setVisibility(View.GONE);
        }

        Intent generous = getIntent();
        String emmanuel = generous.getStringExtra("generous");
        if (FoodmenuActivity.textView3rd.getVisibility() == View.VISIBLE) {
            textViewtrois.setText(emmanuel);
            textViewtrois.setVisibility(View.VISIBLE);
        } else if (FoodmenuActivity.textView3rd.getVisibility() == View.GONE) {
            textViewtrois.setVisibility(View.GONE);
        }

        Intent focused = getIntent();
        String joseph = focused.getStringExtra("focused");
        if (FoodmenuActivity.textView4th.getVisibility() == View.VISIBLE) {
            textViewquartz.setText(joseph);
            textViewquartz.setVisibility(View.VISIBLE);
        } else if (FoodmenuActivity.textView4th.getVisibility() == View.GONE) {
            textViewquartz.setVisibility(View.GONE);
        }

        Intent creativebeast = getIntent();
        String godwin = creativebeast.getStringExtra("creativebeast");
        if (FoodmenuActivity.textView5th.getVisibility() == View.VISIBLE) {
            textViewfive.setText(godwin);
            textViewfive.setVisibility(View.VISIBLE);
        } else if (FoodmenuActivity.textView5th.getVisibility() == View.GONE) {
            textViewfive.setVisibility(View.GONE);
        }

        Intent bestmom = getIntent();
        String funmilayo = bestmom.getStringExtra("bestmom");
        if (FoodmenuActivity.textView6th.getVisibility() == View.VISIBLE) {
            textViewsix.setText(funmilayo);
            textViewsix.setVisibility(View.VISIBLE);
        } else if (FoodmenuActivity.textView6th.getVisibility() == View.GONE) {
            textViewsix.setVisibility(View.GONE);
        }

        Intent bestdad = getIntent();
        String james = bestdad.getStringExtra("bestdad");
        if (FoodmenuActivity.textView7th.getVisibility() == View.VISIBLE) {
            textViewsept.setText(james);
            textViewsept.setVisibility(View.VISIBLE);
        } else if (FoodmenuActivity.textView7th.getVisibility() == View.GONE) {
            textViewsept.setVisibility(View.GONE);
        }

        Intent biggersis = getIntent();
        String tomilola = biggersis.getStringExtra("biggersis");
        if (FoodmenuActivity.textView8th.getVisibility() == View.VISIBLE) {
            textVieweight.setText(tomilola);
            textVieweight.setVisibility(View.VISIBLE);
        } else if (FoodmenuActivity.textView8th.getVisibility() == View.GONE) {
            textVieweight.setVisibility(View.GONE);
        }

        Intent biggestsis = getIntent();
        String opeyemi = biggestsis.getStringExtra("biggestsis");
        if (FoodmenuActivity.textView9th.getVisibility() == View.VISIBLE) {
            textViewnous.setText(opeyemi);
            textViewnous.setVisibility(View.VISIBLE);
        } else if (FoodmenuActivity.textView9th.getVisibility() == View.GONE) {
            textViewnous.setVisibility(View.GONE);
        }

        Intent dhalson = getIntent();
        String david = dhalson.getStringExtra("dhalson");
        if (FoodmenuActivity.textView10th.getVisibility() == View.VISIBLE) {
            textViewten.setText(david);
            textViewten.setVisibility(View.VISIBLE);
        } else if (FoodmenuActivity.textView10th.getVisibility() == View.GONE) {
            textViewten.setVisibility(View.GONE);
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
