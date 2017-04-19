package com.icdatofcusgmail.lucidfood;

import android.app.Dialog;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.muddzdev.styleabletoastlibrary.StyleableToast;

public class FoodmenuActivity extends AppCompatActivity implements Communicator, FoodpriceFragment.OnNameSetListener, ChosenfoodFragment.OnPriceSetListener {

    private Toolbar toolbar_foodmenu;
    private RelativeLayout relative;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foodmenu);
        Log.d("FoodmenuActivity","onCreate invoked");

     //   requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        relative = (RelativeLayout) findViewById(R.id.activity_foodstuffmenu);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(android.R.color.transparent));
        }
        toolbar_foodmenu = (Toolbar) findViewById(R.id.toolbarfoodmenuactivity);
        setSupportActionBar(toolbar_foodmenu);
        getSupportActionBar().setTitle(" FoodMenu");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setIcon(R.drawable.c_davooo);
    }

    @Override
    public void respond(int i) {
        FragmentManager manager = getFragmentManager();
        FoodavailableFragment faf = (FoodavailableFragment) manager.findFragmentById(R.id.fragmentfoodavailable);
        faf.changeData(i);

        FoodpriceFragment fpf = (FoodpriceFragment) manager.findFragmentById(R.id.fragmentfoodprice);
        fpf.Datachange(i);
    }

    @Override
    public void setName(String name) {
        ChosenfoodFragment cff = (ChosenfoodFragment) getFragmentManager().findFragmentById(R.id.fragmentchosenfood);
        cff.updateInfo(name);

        ChosenplateCounter cpc = (ChosenplateCounter) getFragmentManager().findFragmentById(R.id.fragmentcounter);
        cpc.updateInfo(name);
    }

    @Override
    public void setPrice(String price) {
        ChosenplateCounter cpc = (ChosenplateCounter) getFragmentManager().findFragmentById(R.id.fragmentcounter);
        cpc.updatePrice(price);
    }

    @Override
    public void FoodMenuFragmentsRespond(int joseph) {
        FragmentManager VFRmanager = getFragmentManager();
        VendorFragment vendorFragment = (VendorFragment) VFRmanager.findFragmentById(R.id.displayAddorRemoveDialogue);
        vendorFragment.displayGridView(joseph);
    }

    public void onnItemClick(int i) {
        FragmentManager manager = getFragmentManager();
        FoodavailableFragment faf = (FoodavailableFragment) manager.findFragmentById(R.id.fragmentfoodavailable);
        faf.changeData(i);
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
                checkMyBalance();
                break;

            case R.id.like_plate:
                iLikeThisPlate();
                break;

            case R.id.saved_plate:
                showRecentlyBoughtPlates();
                break;
        }
        return false;
    }

    public void checkMyBalance() {
        Snackbar CheckMyMoney = Snackbar.make(relative, "Balance will be Displayed Here", Snackbar.LENGTH_LONG);
        CheckMyMoney.setActionTextColor(Color.GREEN);
        CheckMyMoney.show();
    }

    public void iLikeThisPlate() {
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

    public void showRecentlyBoughtPlates() {
        StyleableToast RecentlyPurchased = new StyleableToast(this, "Please select from recently bought plates", Toast.LENGTH_LONG).spinIcon();
        RecentlyPurchased.setBackgroundColor(Color.parseColor("#FF5A5F"));
        RecentlyPurchased.setTextColor(Color.WHITE);
        RecentlyPurchased.show();
        Intent intent = new Intent(this, FoodhistoryActivity.class);
        startActivity(intent);
    }

    public void maxPlateCount(View view) {
        FragmentManager manager = getFragmentManager();
        PlateCount PCdialogue = new PlateCount();
        PCdialogue.show(manager, "PlateCount");
    }

    public void ConfirmMyPurchase(View view) {
        FragmentManager director = getFragmentManager();
        ConfirmPurchase CMPdialogue = new ConfirmPurchase();
        CMPdialogue.show(director, "ConfirmPurchase");

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
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("FoodmenuActivity","onResume invoked");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("FoodmenuActivity","onPause invoked");
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
}
