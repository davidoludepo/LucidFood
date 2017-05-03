package com.icdatofcusgmail.lucidfood;

import android.app.Dialog;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
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
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.muddzdev.styleabletoastlibrary.StyleableToast;

public class FoodmenuActivity extends AppCompatActivity implements Communicator, FoodpriceFragment.OnNameSetListener, ChosenfoodFragment.OnPriceSetListener, CompoundButton.OnCheckedChangeListener {

    PowerManager.WakeLock wakeLock;
    Toolbar toolbar_foodmenu;
    private RelativeLayout relative;
    private TextView textView, textView2nd, textView3rd, textView4th, textView5th, textView6th, textView7th, textView8th, textView9th, textView10th;
    Button ConfirmPurchaze;
    CheckBox pack;
    String pacque, stringue="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foodmenu);
        Log.d("FoodmenuActivity", "onCreate invoked");
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

        ConfirmPurchaze = (Button) findViewById(R.id.button20000);

        //   requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        relative = (RelativeLayout) findViewById(R.id.activity_Foodmenu);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(android.R.color.transparent));
        }
        toolbar_foodmenu = (Toolbar) findViewById(R.id.ToolbarFoodmenuActivity);
        setSupportActionBar(toolbar_foodmenu);
        getSupportActionBar().setTitle(" FoodMenu");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setIcon(R.drawable.c_davooo);
    }

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
            stringue= pacque;
        }
        else {
            pack.setText(" Buying in Plate(s)");
            pacque = pack.getText().toString();
            stringue=pacque;
        }
    }

    @Override
    public void respond(int i) {
        FragmentManager manager = getFragmentManager();
        FoodavailableFragment faf = (FoodavailableFragment) manager.findFragmentById(R.id.FragmentFoodavailable);
        faf.changeData(i);

        FoodpriceFragment fpf = (FoodpriceFragment) manager.findFragmentById(R.id.FragmentFoodprice);
        fpf.Datachange(i);
    }

    @Override
    public void setName(String name) {
        ChosenfoodFragment cff = (ChosenfoodFragment) getFragmentManager().findFragmentById(R.id.FragmentChosenfood);
        cff.updateInfo(name);

        ChosenplateCounter cpc = (ChosenplateCounter) getFragmentManager().findFragmentById(R.id.FragmentCounter);
        cpc.updateInfo(name);
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
        FragmentManager manager = getFragmentManager();
        FoodavailableFragment faf = (FoodavailableFragment) manager.findFragmentById(R.id.FragmentFoodavailable);
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
        overridePendingTransition(R.anim.slide_up_in, R.anim.slide_up_out);
    }

    public void maxPlateCount(View view) {
        FragmentManager manager = getFragmentManager();
        PlateCount PCdialogue = new PlateCount();
        PCdialogue.show(manager, "PlateCount");
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
        wakeLock.acquire();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("FoodmenuActivity","onPause invoked");
        wakeLock.release();
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