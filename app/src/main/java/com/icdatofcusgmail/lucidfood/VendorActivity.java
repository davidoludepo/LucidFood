package com.icdatofcusgmail.lucidfood;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;

public class VendorActivity extends AppCompatActivity implements Communicator, AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor);

        WifiManager wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        wifi.setWifiEnabled(true);

        Intent StartFoodServicing = new Intent(this, FoodServicing.class);
        startService(StartFoodServicing);

        Log.d("VendorActivity","onCreate invoked");

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(android.R.color.transparent));
        }
    }

    public void OCAddorRemove(View view) {
        FragmentManager AorRmanager = getFragmentManager();
        AddorRemove reveal = new AddorRemove();
        reveal.show(AorRmanager, "AddorRemove");
    }

    public void OCDynamicPlateCount(View view) {
        FragmentManager DPCmanager = getFragmentManager();
        DynamicPlateCount conceal = new DynamicPlateCount();
        conceal.show(DPCmanager, "DynamicPlateCount");
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void respond(int i) {

    }

    @Override
    public void onnItemClick(int i) {

    }

    @Override
    public void FoodMenuFragmentsRespond(int joseph) {
        FragmentManager VFRmanager = getFragmentManager();
        VendorFragment vendorFragment = (VendorFragment) VFRmanager.findFragmentById(R.id.displayAddorRemoveDialogue);
        vendorFragment.displayGridView(joseph);
    }

    public void GetMeNextActivity(View view) {
            Intent obsolete = new Intent(this, LoginActivity.class);
            startActivity(obsolete);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("VendorActivity","onStart invoked");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("VendorActivity","onResume invoked");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("VendorActivity","onPause invoked");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("VendorActivity","onRestart invoked");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("VendorActivity","onDestroy invoked");

    }
}
