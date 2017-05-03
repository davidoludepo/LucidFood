package com.icdatofcusgmail.lucidfood;

import android.app.Dialog;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.muddzdev.styleabletoastlibrary.StyleableToast;

import java.util.ArrayList;

public class VendorActivity extends AppCompatActivity implements /*Communicator, */ View.OnClickListener, AdapterView.OnItemClickListener, RadioGroup.OnCheckedChangeListener,  AdapterView.OnItemSelectedListener, SmoothCheckBox.OnCheckedChangeListener {

    RadioGroup radioGroup;
    PowerManager.WakeLock wakeLock;
    VendorAdapter vendorAdapter;
    static GridView ShowInThis;
    final String [] foodnames = new String[]{"White Rice", "Jollof Rice", "Fried Rice", "Beef", "Chicken", "Moi Moi", "Beans", "Egg", "Coleslaw", "Plantain"};
    int[] foodimages = {R.drawable.c_whiterice, R.drawable.c_jollof, R.drawable.c_friedrice, R.drawable.c_beef, R.drawable.c_chicken, R.drawable.c_moimoi, R.drawable.c_beans, R.drawable.c_egg, R.drawable.c_coleslaw, R.drawable.c_plantain};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor);
        Log.d("VendorActivity","onCreate invoked");
        PowerManager powerManager = (PowerManager) getSystemService(Context.POWER_SERVICE);
        wakeLock = powerManager.newWakeLock(PowerManager.FULL_WAKE_LOCK, "deprecatedmyfoot");
        wakeLock.acquire();
        WifiManager wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        wifi.setWifiEnabled(true);
        Intent StartFoodServicing = new Intent(this, FoodServicing.class);
        startService(StartFoodServicing);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(android.R.color.transparent));
        }

        ShowInThis = (GridView) findViewById(R.id.showInThis);
        ShowInThis.setOnItemClickListener(this);
        ShowInThis.setVisibility(View.GONE);
        ShowInThis.setChoiceMode(GridView.CHOICE_MODE_MULTIPLE);
        vendorAdapter = new VendorAdapter(getApplicationContext(), getIcdats());
        ShowInThis.setAdapter(vendorAdapter);
    }

    private ArrayList<Icdat> getIcdats() {
        ArrayList<Icdat> icdats = new ArrayList<>();
        icdats.add(new Icdat(foodnames[0], foodimages[0]));
        icdats.add(new Icdat(foodnames[1], foodimages[1]));
        icdats.add(new Icdat(foodnames[2], foodimages[2]));
        icdats.add(new Icdat(foodnames[3], foodimages[3]));
        icdats.add(new Icdat(foodnames[4], foodimages[4]));
        icdats.add(new Icdat(foodnames[5], foodimages[5]));
        icdats.add(new Icdat(foodnames[6], foodimages[6]));
        icdats.add(new Icdat(foodnames[7], foodimages[7]));
        icdats.add(new Icdat(foodnames[8], foodimages[8]));
        icdats.add(new Icdat(foodnames[9], foodimages[9]));

        return icdats;
    }

    public void OCAddorRemove(View view) {
        FragmentManager AorRmanager = getFragmentManager();
        AddorRemove reveal = new AddorRemove();
        reveal.show(AorRmanager, "AddorRemove");
        startActionMode(callback);
    }

    ActionMode.Callback callback = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            MenuInflater menuInflater = mode.getMenuInflater();
            menuInflater.inflate(R.menu.vendoractivitycontextualmenumain, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            switch (item.getItemId()){
                case R.id.item_option1:
                    Toast.makeText(getApplicationContext(),item.toString(),Toast.LENGTH_SHORT).show();

                    break;

                case R.id.item_option2:
                    Toast.makeText(getApplicationContext(),item.toString(),Toast.LENGTH_SHORT).show();

                    break;

                case R.id.item_option3:
                    Toast.makeText(getApplicationContext(),item.toString(),Toast.LENGTH_SHORT).show();

                    break;

                case R.id.item_option4:
                    Toast.makeText(getApplicationContext(),item.toString(),Toast.LENGTH_SHORT).show();

                    break;
            }
            return true;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {

        }
    };

    public void OCDynamicPlateCount(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(VendorActivity.this);
        builder.setTitle("Choose the slightest volume of items available");
        LayoutInflater inflater = VendorActivity.this.getLayoutInflater();
        View view = inflater.inflate(R.layout.va_dynamic_platecount, null);
        builder.setView(view);
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                StyleableToast NoPlateSelected = new StyleableToast(getApplicationContext(), "Please Select Default Plate No.", Toast.LENGTH_SHORT).spinIcon();
                NoPlateSelected.setBackgroundColor(Color.parseColor("#FF5A5F"));
                NoPlateSelected.setTextColor(Color.WHITE);
                NoPlateSelected.show();
            }
        });
        builder.setPositiveButton(R.string.okay, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                StyleableToast APlateNoSelected = new StyleableToast(getApplicationContext(), "An Item Selected" +which, Toast.LENGTH_SHORT).spinIcon();
                APlateNoSelected.setBackgroundColor(Color.parseColor("#FF5A5F"));
                APlateNoSelected.setTextColor(Color.WHITE);
                APlateNoSelected.show();
                dialog.dismiss();
            }
        });
        Dialog dialog = builder.create();
        dialog.show();
        radioGroup = (RadioGroup) view.findViewById(R.id.radiohead);
        radioGroup.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        switch (checkedId) {
            case R.id.one:
               // Intent intent = new Intent(getApplicationContext(), PlateCount.class);
               // startActivityForResult(intent, 5);
                StyleableToast OnePlate = new StyleableToast(getApplicationContext(), "One Plate Selected", Toast.LENGTH_SHORT).spinIcon();
                OnePlate.setBackgroundColor(Color.parseColor("#FF5A5F"));
                OnePlate.setTextColor(Color.WHITE);
                OnePlate.show();
                break;

            case R.id.two:
                StyleableToast TwoPlate = new StyleableToast(getApplicationContext(), "Two Plates Selected", Toast.LENGTH_SHORT).spinIcon();
                TwoPlate.setBackgroundColor(Color.parseColor("#FF5A5F"));
                TwoPlate.setTextColor(Color.WHITE);
                TwoPlate.show();
                break;

            case R.id.three:
                StyleableToast ThreePlate = new StyleableToast(getApplicationContext(), "Three Plates Selected", Toast.LENGTH_SHORT).spinIcon();
                ThreePlate.setBackgroundColor(Color.parseColor("#FF5A5F"));
                ThreePlate.setTextColor(Color.WHITE);
                ThreePlate.show();
                break;
            case R.id.four:
                StyleableToast FourPlate = new StyleableToast(getApplicationContext(), "Four Plates Selected", Toast.LENGTH_SHORT).spinIcon();
                FourPlate.setBackgroundColor(Color.parseColor("#FF5A5F"));
                FourPlate.setTextColor(Color.WHITE);
                FourPlate.show();
                break;
            case R.id.five:
                StyleableToast FivePlate = new StyleableToast(getApplicationContext(), "Five Plates Selected", Toast.LENGTH_SHORT).spinIcon();
                FivePlate.setBackgroundColor(Color.parseColor("#FF5A5F"));
                FivePlate.setTextColor(Color.WHITE);
                FivePlate.show();
                break;
            case R.id.six:
                StyleableToast SixPlate = new StyleableToast(getApplicationContext(), "Six Plates Selected", Toast.LENGTH_SHORT).spinIcon();
                SixPlate.setBackgroundColor(Color.parseColor("#FF5A5F"));
                SixPlate.setTextColor(Color.WHITE);
                SixPlate.show();
                break;
            case R.id.seven:
                StyleableToast SevenPlate = new StyleableToast(getApplicationContext(), "Seven Plates Selected", Toast.LENGTH_SHORT).spinIcon();
                SevenPlate.setBackgroundColor(Color.parseColor("#FF5A5F"));
                SevenPlate.setTextColor(Color.WHITE);
                SevenPlate.show();
                break;
            case R.id.eight:
                StyleableToast EightPlate = new StyleableToast(getApplicationContext(), "Eight Plates Selected", Toast.LENGTH_SHORT).spinIcon();
                EightPlate.setBackgroundColor(Color.parseColor("#FF5A5F"));
                EightPlate.setTextColor(Color.WHITE);
                EightPlate.show();
                break;
            case R.id.nine:
                StyleableToast NinePlate = new StyleableToast(getApplicationContext(), "Nine Plates Selected", Toast.LENGTH_SHORT).spinIcon();
                NinePlate.setBackgroundColor(Color.parseColor("#FF5A5F"));
                NinePlate.setTextColor(Color.WHITE);
                NinePlate.show();
                break;
            case R.id.ten:
                StyleableToast TenPlate = new StyleableToast(getApplicationContext(), "Ten Plates Selected", Toast.LENGTH_SHORT).spinIcon();
                TenPlate.setBackgroundColor(Color.parseColor("#FF5A5F"));
                TenPlate.setTextColor(Color.WHITE);
                TenPlate.show();
                break;
            case R.id.eleven:
                StyleableToast ElevenPlate = new StyleableToast(getApplicationContext(), "Eleven Plates Selected", Toast.LENGTH_SHORT).spinIcon();
                ElevenPlate.setBackgroundColor(Color.parseColor("#FF5A5F"));
                ElevenPlate.setTextColor(Color.WHITE);
                ElevenPlate.show();
                break;
            case R.id.twelve:
                StyleableToast TwelvePlate = new StyleableToast(getApplicationContext(), "Twelve Plates Selected", Toast.LENGTH_SHORT).spinIcon();
                TwelvePlate.setBackgroundColor(Color.parseColor("#FF5A5F"));
                TwelvePlate.setTextColor(Color.WHITE);
                TwelvePlate.show();
                break;
            case R.id.thirteen:
                StyleableToast ThirteenPlate = new StyleableToast(getApplicationContext(), "Thirteen Plates Selected", Toast.LENGTH_SHORT).spinIcon();
                ThirteenPlate.setBackgroundColor(Color.parseColor("#FF5A5F"));
                ThirteenPlate.setTextColor(Color.WHITE);
                ThirteenPlate.show();
                break;
            case R.id.fourteen:
                StyleableToast FourteenPlate = new StyleableToast(getApplicationContext(), "Fourteen Plates Selected", Toast.LENGTH_SHORT).spinIcon();
                FourteenPlate.setBackgroundColor(Color.parseColor("#FF5A5F"));
                FourteenPlate.setTextColor(Color.WHITE);
                FourteenPlate.show();
                break;
            case R.id.fifteen:
                StyleableToast FifteenPlate = new StyleableToast(getApplicationContext(), "Fifteen Plates Selected", Toast.LENGTH_SHORT).spinIcon();
                FifteenPlate.setBackgroundColor(Color.parseColor("#FF5A5F"));
                FifteenPlate.setTextColor(Color.WHITE);
                FifteenPlate.show();
                break;
            case R.id.sixteen:
                StyleableToast SixteenPlate = new StyleableToast(getApplicationContext(), "Sixteen Plates Selected", Toast.LENGTH_SHORT).spinIcon();
                SixteenPlate.setBackgroundColor(Color.parseColor("#FF5A5F"));
                SixteenPlate.setTextColor(Color.WHITE);
                SixteenPlate.show();
                break;
            case R.id.seventeen:
                StyleableToast SeventeenPlate = new StyleableToast(getApplicationContext(), "Seventeen Plates Selected", Toast.LENGTH_SHORT).spinIcon();
                SeventeenPlate.setBackgroundColor(Color.parseColor("#FF5A5F"));
                SeventeenPlate.setTextColor(Color.WHITE);
                SeventeenPlate.show();
                break;
            case R.id.eighteen:
                StyleableToast EighteenPlate = new StyleableToast(getApplicationContext(), "Eighteen Plates Selected", Toast.LENGTH_SHORT).spinIcon();
                EighteenPlate.setBackgroundColor(Color.parseColor("#FF5A5F"));
                EighteenPlate.setTextColor(Color.WHITE);
                EighteenPlate.show();
                break;
            case R.id.nineteen:
                StyleableToast NineteenPlate = new StyleableToast(getApplicationContext(), "Nineteen Plates Selected", Toast.LENGTH_SHORT).spinIcon();
                NineteenPlate.setBackgroundColor(Color.parseColor("#FF5A5F"));
                NineteenPlate.setTextColor(Color.WHITE);
                NineteenPlate.show();
                break;
            case R.id.twenty:
                StyleableToast TwentyPlate = new StyleableToast(getApplicationContext(), "Twenty Plates Selected", Toast.LENGTH_SHORT).spinIcon();
                TwentyPlate.setBackgroundColor(Color.parseColor("#FF5A5F"));
                TwentyPlate.setTextColor(Color.WHITE);
                TwentyPlate.show();
                break;
            case R.id.twentyone:
                StyleableToast TwentyOnePlate = new StyleableToast(getApplicationContext(), "Twentyone Plates Selected", Toast.LENGTH_SHORT).spinIcon();
                TwentyOnePlate.setBackgroundColor(Color.parseColor("#FF5A5F"));
                TwentyOnePlate.setTextColor(Color.WHITE);
                TwentyOnePlate.show();
                break;
            case R.id.twentytwo:
                StyleableToast TwentyTwoPlate = new StyleableToast(getApplicationContext(), "Twentytwo Plates Selected", Toast.LENGTH_SHORT).spinIcon();
                TwentyTwoPlate.setBackgroundColor(Color.parseColor("#FF5A5F"));
                TwentyTwoPlate.setTextColor(Color.WHITE);
                TwentyTwoPlate.show();
                break;
            case R.id.twentythree:
                StyleableToast TwentyThreePlate = new StyleableToast(getApplicationContext(), "Twentythree Plates Selected", Toast.LENGTH_SHORT).spinIcon();
                TwentyThreePlate.setBackgroundColor(Color.parseColor("#FF5A5F"));
                TwentyThreePlate.setTextColor(Color.WHITE);
                TwentyThreePlate.show();
                break;
            case R.id.twentyfour:
                StyleableToast TwentyFourPlate = new StyleableToast(getApplicationContext(), "Twentyfour Plates Selected", Toast.LENGTH_SHORT).spinIcon();
                TwentyFourPlate.setBackgroundColor(Color.parseColor("#FF5A5F"));
                TwentyFourPlate.setTextColor(Color.WHITE);
                TwentyFourPlate.show();
                break;
            case R.id.twentyfive:
                StyleableToast TwentyFivePlate = new StyleableToast(getApplicationContext(), "Twentyfive Plates Selected", Toast.LENGTH_SHORT).spinIcon();
                TwentyFivePlate.setBackgroundColor(Color.parseColor("#FF5A5F"));
                TwentyFivePlate.setTextColor(Color.WHITE);
                TwentyFivePlate.show();
                break;
            case R.id.twentysix:
                StyleableToast TwentySixPlate = new StyleableToast(getApplicationContext(), "Twentysix Plates Selected", Toast.LENGTH_SHORT).spinIcon();
                TwentySixPlate.setBackgroundColor(Color.parseColor("#FF5A5F"));
                TwentySixPlate.setTextColor(Color.WHITE);
                TwentySixPlate.show();
                break;
            case R.id.twentyseven:
                StyleableToast TwentySevenPlate = new StyleableToast(getApplicationContext(), "Twentyseven Plates Selected", Toast.LENGTH_SHORT).spinIcon();
                TwentySevenPlate.setBackgroundColor(Color.parseColor("#FF5A5F"));
                TwentySevenPlate.setTextColor(Color.WHITE);
                TwentySevenPlate.show();
                break;
            case R.id.twentyeight:
                StyleableToast TwentyEightPlate = new StyleableToast(getApplicationContext(), "Twentyeight Plates Selected", Toast.LENGTH_SHORT).spinIcon();
                TwentyEightPlate.setBackgroundColor(Color.parseColor("#FF5A5F"));
                TwentyEightPlate.setTextColor(Color.WHITE);
                TwentyEightPlate.show();
                break;
            case R.id.twentynine:
                StyleableToast TwentyNinePlate = new StyleableToast(getApplicationContext(), "Twentynine Plates Selected", Toast.LENGTH_SHORT).spinIcon();
                TwentyNinePlate.setBackgroundColor(Color.parseColor("#FF5A5F"));
                TwentyNinePlate.setTextColor(Color.WHITE);
                TwentyNinePlate.show();
                break;
            case R.id.thirty:
                StyleableToast ThirtyPlate = new StyleableToast(getApplicationContext(), "Thirty Plates Selected", Toast.LENGTH_SHORT).spinIcon();
                ThirtyPlate.setBackgroundColor(Color.parseColor("#FF5A5F"));
                ThirtyPlate.setTextColor(Color.WHITE);
                ThirtyPlate.show();
                break;
        }
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (view.getTag() instanceof VendorAdapter.ViewHolder) {
            VendorAdapter.ViewHolder holder = (VendorAdapter.ViewHolder) view.getTag();
            holder.smooth.toggle();
        }
        StyleableToast JustFoodNames = new StyleableToast(getApplication(), foodnames[position] + " Selected", Toast.LENGTH_SHORT).spinIcon();
        JustFoodNames.setBackgroundColor(Color.parseColor("#FF5A5F"));
        JustFoodNames.setTextColor(Color.WHITE);
        JustFoodNames.show();
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
        wakeLock.acquire();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("VendorActivity","onPause invoked");
        wakeLock.release();
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

    @Override
    public void onBackPressed() {
        confirmExitDialog();
    }

    public void confirmExitDialog() {
        AlertDialog.Builder destroyer = new AlertDialog.Builder(this);
        destroyer.setTitle("Exit App?");
        destroyer.setMessage("This will close Lucid. Are you sure?");
        destroyer.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               // moveTaskToBack(true);
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
                System.exit(0);
                dialog.dismiss();
            }
        });
        destroyer.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        destroyer.create().show();

    }


    @Override
    public void onClick(View v) {

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onCheckedChanged(SmoothCheckBox smoothCheckBox, boolean isChecked) {
        if (isChecked)
        Toast.makeText(getApplicationContext(), "This is cool", Toast.LENGTH_LONG).show();
    }


}
