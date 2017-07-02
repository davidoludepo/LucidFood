package com.icdatofcusgmail.lucidfood.FoodmenuActivityArchive;

import android.app.Dialog;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
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
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.antonionicolaspina.revealtextview.RevealTextView;
import com.icdatofcusgmail.lucidfood.LoginActivityArchive.LoginActivity;
import com.icdatofcusgmail.lucidfood.LucidApplication;
import com.icdatofcusgmail.lucidfood.MyCountlesston;
import com.icdatofcusgmail.lucidfood.R;
import com.icdatofcusgmail.lucidfood.ServingActivityArchive.ServingActivity;
import com.muddzdev.styleabletoastlibrary.StyleableToast;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import de.hdodenhof.circleimageview.CircleImageView;

public class FoodmenuActivity extends AppCompatActivity implements Communicator, FoodpriceFragment.OnNameSetListener, ChosenfoodFragment.OnPriceSetListener, CompoundButton.OnCheckedChangeListener, AdapterView.OnItemClickListener {

    PowerManager.WakeLock wakeLock;
    Toolbar toolbar_foodmenu;
    private RelativeLayout relative;
    public static TextView textView, textView2nd, textView3rd, textView4th, textView5th, textView6th, textView7th, textView8th, textView9th, textView10th;
    Button button, button2, button3, button4, button5, button6;
    static Button Pcount, Purchase;
    ListView ShowForThis;
    TextView WelcomeSweet, fullUsername, Lucid;
    static TextView myOwnPay;
    static CheckBox pack;
    FoodHistoryDBHelper foodHistoryDBHelper;
    MenuItem savior, salvation;
    private ImageView AnimatedImageView;
    CircleImageView circleImageView;
    public static int out = 0;
    public static int fifty = 0;
    static int hundred = 0;
    static int onefifty = 0;
    static int twohundred = 0;
    static int twofifty = 0;
    static int threehundred = 0;
    static int threehundredfifty = 0;
    static int fourhundred = 0;
    static int fourhundredfifty = 0;
    static int fivehundred = 0;
    static int fivehundredfifty = 0;
    static int sixhundred = 0;
    static int sixhundredfifty = 0;
    static int sevenhundred = 0;
    static int sevenhundredfifty = 0;
    static int eighthundred = 0;
    static int eighthundredfifty = 0;
    static int ninehundred = 0;
    static int ninehundredfifty = 0;
    static int onethousand = 0;
    static int onethousandfifty = 0;
    static int onethousandhundred = 0;
    static int onethousandonefifty = 0;
    static int onethousandtwohundred = 0;
    static int onethousandtwofifty = 0;
    static int onethousandthreehundred = 0;
    static int onethousandthreefifty = 0;
    static int onethousandfourhundred = 0;
    static int onethousandfourfifty = 0;
    static int onethousandfivehundred = 0;

    String pacque, stringue = "";
    public static String playtcount = "";
    public static String stringplayti = "Buying all in a plate";
    String stringplaytii = "Buying all in two plates";
    String stringplaytiii = "Buying all in three plates";
    String stringplaytiv = "Buying all in four plates";
    String stringplaytv = "Buying all in five plates";
    String stringplaytvi = "Buying all in six plates";
    String stringplaytvii = "Buying all in seven plates";
    String stringplaytviii = "Buying all in eight plates";
    String stringplaytix = "Buying all in nine plates";
    String stringplaytx = "Buying all in ten plates";
    String stringplaytxi = "Buying all in oneone plates";
    String stringplaytxii = "Buying all in onetwo plates";
    String stringplaytxiii = "Buying all in onethree plates";
    String stringplaytxiv = "Buying all in onefour plates";
    String stringplaytxv = "Buying all in onefive plates";
    String stringplaytxvi = "Buying all in onesix plates";
    String stringplaytxvii = "Buying all in oneseven plates";
    String stringplaytxviii = "Buying all in oneeight plates";
    String stringplaytxix = "Buying all in onenine plates";
    String stringplaytxx = "Buying all in oneten plates";
    String stringplaytxxi = "Buying all in twoone plates";
    String stringplaytxxii = "Buying all in twotwo plates";
    String stringplaytxxiii = "Buying all in twothree plates";
    String stringplaytxxiv = "Buying all in twofour plates";
    String stringplaytxxv = "Buying all in twofive plates";
    String stringplaytxxvi = "Buying all in twosix plates";
    String stringplaytxxvii = "Buying all in twoseven plates";
    String stringplaytxxviii = "Buying all in twoeight plates";
    String stringplaytxxix = "Buying all in twonine plates";
    String stringplaytxxx = "Buying all in twoten plates";

    LucidApplication app;

    String update_url = "http://192.168.43.79/account_balance_difference.php";
    AlertDialog.Builder Dweezy;


    private enum OperationAnimation {
        BEGIN, ADJOURN
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foodmenu);
        Log.d("FoodmenuActivity", "onCreate invoked");

        app = LucidApplication.getInstance();

        Dweezy = new AlertDialog.Builder(FoodmenuActivity.this);

        foodHistoryDBHelper = new FoodHistoryDBHelper(this);
        playtcount = stringplayti;
        ShowForThis = (ListView) findViewById(R.id.listView);
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


        WelcomeSweet = (TextView) findViewById(R.id.UserWelcome);
        fullUsername = (TextView) findViewById(R.id.fullUsername);
        Lucid = (RevealTextView) findViewById(R.id.AppName);
        Typeface blackface = Typeface.createFromAsset(getAssets(), "customfont/buttonfor.otf");
        Lucid.setTypeface(blackface);

        savior = (MenuItem) findViewById(R.id.like_plate);
        salvation = (MenuItem) findViewById(R.id.saved_plate);

        button = (Button) findViewById(R.id.Istpricebutton);
        button2 = (Button) findViewById(R.id.Secondpricebutton);
        button3 = (Button) findViewById(R.id.Thirdpricebutton);
        button4 = (Button) findViewById(R.id.Fourthpricebutton);
        button5 = (Button) findViewById(R.id.Fifthpricebutton);
        button6 = (Button) findViewById(R.id.Sixthpricebutton);
        Pcount = (Button) findViewById(R.id.button);

        Purchase = (Button) findViewById(R.id.button20000);

        AnimatedImageView = (ImageView) findViewById(R.id.animatedImages);

        circleImageView = (CircleImageView) findViewById(R.id.ServerImage);
        final Bundle bundle = getIntent().getExtras();
        getUserAppearance(bundle.getString("image"));

        if (!textView.isShown() && !textView2nd.isShown() && !textView3rd.isShown()
                && !textView4th.isShown() && !textView5th.isShown() && !textView6th.isShown()
                && !textView7th.isShown() && !textView8th.isShown() && !textView9th.isShown()
                && !textView10th.isShown()) {
            Pcount.setEnabled(false);
            Purchase.setEnabled(false);
        }

        Bundle FirstParcel = getIntent().getExtras();
        try {
            WelcomeSweet.setText("Welcome,  " + FirstParcel.getString("king") + "");
        } catch (Exception ignored) {

        }

        Bundle SecondParcel = getIntent().getExtras();
        try {
            fullUsername.setText("" + SecondParcel.getString("kingDavid") + "");
        } catch (Exception ignored) {

        }

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        relative = (RelativeLayout) findViewById(R.id.activity_Foodmenu);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(android.R.color.transparent));
        }
        toolbar_foodmenu = (Toolbar) findViewById(R.id.ToolbarFoodmenuActivity);
        setSupportActionBar(toolbar_foodmenu);

        try {
            getSupportActionBar().setTitle("");
        }catch (NullPointerException ignored) {

        }


    }

    private void getUserAppearance(String url) {
        Picasso.with(this).load(url).placeholder(R.drawable.c_failed_userappearancesub).error(R.drawable.c_failed_userappearancesub).into(circleImageView, new com.squareup.picasso.Callback()  {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError() {

                    }
                });

    }

    public void ConfirmMyPurchase(View v) {

       // StringRequest stringRequest = new StringRequest()

        if (ChosenplateCounter.feetag.getCurrentTextColor() == Color.parseColor("#B71C1C")) {
            AlertDialog.Builder notExactly = new AlertDialog.Builder(FoodmenuActivity.this);
            notExactly.setMessage("You've kinda exceeded your Balance");
            notExactly.setPositiveButton("I'm Sorry", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            notExactly.create().show();
        } else if (ChosenplateCounter.feetag.getCurrentTextColor() == Color.parseColor("#303F9F")) {
                AlertDialog.Builder notBeyond = new AlertDialog.Builder(FoodmenuActivity.this);
                notBeyond.setMessage("Ummmm....Your Purchase really can't be equal with your Balance");
                notBeyond.setPositiveButton("I'm Sorry", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                notBeyond.create().show();
            } else {
                final AlertDialog.Builder builder = new AlertDialog.Builder(FoodmenuActivity.this);
                builder.setTitle("Confirm Purchase");
                builder.setMessage("The item(s) you selected will be bought by clicking \nSENDDATA");
                LayoutInflater inflater = FoodmenuActivity.this.getLayoutInflater();
                View view = inflater.inflate(R.layout.fa_confirmpurchase_dialogue, null);
                builder.setView(view).setCancelable(false);

                builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        playtcount = stringplayti;
                        ChosenplateCounter.feetag.setText("" + Integer.toString(out) + "");
                        FoodmenuActivity.Pcount.setText("" + "PLATE COUNT" + "");

                        StyleableToast NotConfirmed = new StyleableToast(getApplicationContext(), "Transaction not Confirmed", Toast.LENGTH_SHORT).spinIcon();
                        NotConfirmed.setBackgroundColor(Color.parseColor("#FF5A5F"));
                        NotConfirmed.setTextColor(Color.WHITE);
                        NotConfirmed.show();
                    }
                });
                builder.setPositiveButton(R.string.done, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        StringRequest fromJingSun = new StringRequest(Request.Method.POST, update_url,
                                new Response.Listener<String>() {
                                    @Override
                                    public void onResponse(final String response) {
                                        try {
                                            JSONArray jsonArray = new JSONArray(response);
                                            JSONObject jsonObject = jsonArray.getJSONObject(0);
                                            String code = jsonObject.getString("code");
                                            Dweezy.setMessage(code);
                                            Dweezy.setCancelable(false);
                                            exhibitAnswer(code);
                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        }) {
                            @Override
                            protected Map<String, String> getParams() throws AuthFailureError {
                                Map<String,String> params = new HashMap<String, String>();
                                params.put("accountbalance_diff", ChosenplateCounter.feetag.getText().toString());
                                params.put("user_name", fullUsername.getText().toString());
                                return params;
                            }
                        };
                        MyCountlesston.getmInstance(FoodmenuActivity.this).addToRequestQueue(fromJingSun);
                    }

                }).setIcon(R.drawable.a_announcement);
                Dialog dialog = builder.create();
                try {
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.LTGRAY));
                } catch (NullPointerException ignored) {

                }
                dialog.show();

                myOwnPay = (TextView) view.findViewById(R.id.myPaynotYours);
                //  myOwnPay.setText(ChosenplateCounter.feetag.getText().toString());

                pack = (CheckBox) view.findViewById(R.id.sendpackalso);
                pack.setOnCheckedChangeListener(this);

            }
        }

    public void exhibitAnswer(final String code) {
        Dweezy.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                if (code.equals("Transaction Successful"))
                {
                    StyleableToast TranCompleted = new StyleableToast(getApplicationContext(), "Transaction Verified", Toast.LENGTH_SHORT).spinIcon();
                    TranCompleted.setBackgroundColor(Color.parseColor("#FF5A5F"));
                    TranCompleted.setTextColor(Color.WHITE);
                    TranCompleted.setIcon(R.drawable.fa_confirmpurchasetoasticon);
                    TranCompleted.show();

                    Intent intent = new Intent(getBaseContext(), ServingActivity.class);
                    intent.putExtra("Roman", playtcount);
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


                    Bundle PrincessFiancee = new Bundle();
                    PrincessFiancee.putString("prince", WelcomeSweet.getText().toString().substring(8));
                    intent.putExtras(PrincessFiancee);

                    startActivity(intent);
                }
            }
        });
        AlertDialog alertDialog = Dweezy.create();
        alertDialog.show();
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        out = Integer.parseInt(String.valueOf(app.allinfoodcounter));
        fifty = Integer.parseInt(String.valueOf(app.fifty));
        hundred = Integer.parseInt(String.valueOf(app.hundred));
        onefifty = Integer.parseInt(String.valueOf(app.onefifty));
        twohundred = Integer.parseInt(String.valueOf(app.twohundred));
        twofifty = Integer.parseInt(String.valueOf(app.twofifty));
        threehundred = Integer.parseInt(String.valueOf(app.threehundred));
        threehundredfifty = Integer.parseInt(String.valueOf(app.threehundredfifty));
        fourhundred = Integer.parseInt(String.valueOf(app.fourhundred));
        fourhundredfifty = Integer.parseInt(String.valueOf(app.fourhundredfifty));
        fivehundred = Integer.parseInt(String.valueOf(app.fivehundred));
        fivehundredfifty = Integer.parseInt(String.valueOf(app.fivehundredfifty));
        sixhundred = Integer.parseInt(String.valueOf(app.sixhundred));
        sixhundredfifty = Integer.parseInt(String.valueOf(app.sixhundredfifty));
        sevenhundred = Integer.parseInt(String.valueOf(app.sevenhundred));
        sevenhundredfifty = Integer.parseInt(String.valueOf(app.sevenhundredfifty));
        eighthundred = Integer.parseInt(String.valueOf(app.eighthundred));
        eighthundredfifty = Integer.parseInt(String.valueOf(app.eighthundredfifty));
        ninehundred = Integer.parseInt(String.valueOf(app.ninehundred));
        ninehundredfifty = Integer.parseInt(String.valueOf(app.ninehundredfifty));
        onethousand = Integer.parseInt(String.valueOf(app.onethousand));
        onethousandfifty = Integer.parseInt(String.valueOf(app.onethousandfifty));
        onethousandhundred = Integer.parseInt(String.valueOf(app.onethousandhundred));
        onethousandonefifty = Integer.parseInt(String.valueOf(app.onethousandonefifty));
        onethousandtwohundred = Integer.parseInt(String.valueOf(app.onethousandtwohundred));
        onethousandtwofifty = Integer.parseInt(String.valueOf(app.onethousandtwofifty));
        onethousandthreehundred = Integer.parseInt(String.valueOf(app.onethousandthreehundred));
        onethousandthreefifty = Integer.parseInt(String.valueOf(app.onethousandthreefifty));
        onethousandfourhundred = Integer.parseInt(String.valueOf(app.onethousandfourhundred));
        onethousandfourfifty = Integer.parseInt(String.valueOf(app.onethousandfourfifty));
        onethousandfivehundred = Integer.parseInt(String.valueOf(app.onethousandfivehundred));



        if (isChecked && Objects.equals(playtcount, stringplayti)) {
            pack.setText("" + " Buy in Pack(s)" + "");
            pacque = pack.getText().toString();
            stringue = pacque;
            myOwnPay.setText("" + Integer.toString(out + fifty) + "");
            ChosenplateCounter.feetag.setText("" + Integer.toString(out + fifty) + "");
        }else if (!isChecked && Objects.equals(playtcount, stringplayti)) {
            pack.setText("" + " Buying in Plate(s)" + "");
            pacque = pack.getText().toString();
            stringue = pacque;
            myOwnPay.setText("" + Integer.toString(out) + "");
            ChosenplateCounter.feetag.setText("" + Integer.toString(out) + "");
        }

        else if (isChecked && Objects.equals(playtcount, stringplaytii)) {
            pack.setText("" + " Buy in Pack(s)" + "");
            pacque = pack.getText().toString();
            stringue = pacque;
            myOwnPay.setText("" + Integer.toString(out * 2 + hundred) + "");
            ChosenplateCounter.feetag.setText("" + Integer.toString(out * 2 + hundred) + "");
        } else if (!isChecked && Objects.equals(playtcount, stringplaytii)) {
            pack.setText("" + " Buying in Plate(s)" + "");
            pacque = pack.getText().toString();
            stringue = pacque;
            myOwnPay.setText("" + Integer.toString(out * 2) + "");
            ChosenplateCounter.feetag.setText("" + Integer.toString(out * 2) + "");
        }

        else if (isChecked && Objects.equals(playtcount, stringplaytiii)) {
            pack.setText("" + " Buy in Pack(s)" + "");
            pacque = pack.getText().toString();
            stringue = pacque;
            myOwnPay.setText("" + Integer.toString(out * 3 + onefifty) + "");
            ChosenplateCounter.feetag.setText("" + Integer.toString(out * 3 + onefifty) + "");
        } else if (!isChecked && Objects.equals(playtcount, stringplaytiii)) {
            pack.setText("" + " Buying in Plate(s)" + "");
            pacque = pack.getText().toString();
            stringue = pacque;
            myOwnPay.setText("" + Integer.toString(out * 3) + "");
            ChosenplateCounter.feetag.setText("" + Integer.toString(out * 3) + "");
        }

        else if (isChecked && Objects.equals(playtcount, stringplaytiv)) {
            pack.setText("" + " Buy in Pack(s)" + "");
            pacque = pack.getText().toString();
            stringue = pacque;
            myOwnPay.setText("" + Integer.toString(out * 4 + twohundred) + "");
            ChosenplateCounter.feetag.setText("" + Integer.toString(out * 4 + twohundred) + "");
        } else if (!isChecked && Objects.equals(playtcount, stringplaytiv)) {
            pack.setText("" + " Buying in Plate(s)" + "");
            pacque = pack.getText().toString();
            stringue = pacque;
            myOwnPay.setText("" + Integer.toString(out * 4) + "");
            ChosenplateCounter.feetag.setText("" + Integer.toString(out * 4) + "");
        }

        else if (isChecked && Objects.equals(playtcount, stringplaytv)) {
            pack.setText("" + " Buy in Pack(s)" + "");
            pacque = pack.getText().toString();
            stringue = pacque;
            myOwnPay.setText("" + Integer.toString(out * 5 + twofifty) + "");
            ChosenplateCounter.feetag.setText("" + Integer.toString(out * 5 + twofifty) + "");
        } else if (!isChecked && Objects.equals(playtcount, stringplaytv)) {
            pack.setText("" + " Buying in Plate(s)" + "");
            pacque = pack.getText().toString();
            stringue = pacque;
            myOwnPay.setText("" + Integer.toString(out * 5) + "");
            ChosenplateCounter.feetag.setText("" + Integer.toString(out * 5) + "");
        }

        else if (isChecked && Objects.equals(playtcount, stringplaytvi)) {
            pack.setText("" + " Buy in Pack(s)" + "");
            pacque = pack.getText().toString();
            stringue = pacque;
            myOwnPay.setText("" + Integer.toString(out * 6 + threehundred) + "");
            ChosenplateCounter.feetag.setText("" + Integer.toString(out * 6 + threehundred) + "");
        } else if (!isChecked && Objects.equals(playtcount, stringplaytvi)) {
            pack.setText("" + " Buying in Plate(s)" + "");
            pacque = pack.getText().toString();
            stringue = pacque;
            myOwnPay.setText("" + Integer.toString(out * 6) + "");
            ChosenplateCounter.feetag.setText("" + Integer.toString(out * 6) + "");
        }

        else if (isChecked && Objects.equals(playtcount, stringplaytvii)) {
            pack.setText("" + " Buy in Pack(s)" + "");
            pacque = pack.getText().toString();
            stringue = pacque;
            myOwnPay.setText("" + Integer.toString(out * 7 + threehundredfifty) + "");
            ChosenplateCounter.feetag.setText("" + Integer.toString(out * 7 + threehundredfifty) + "");
        } else if (!isChecked && Objects.equals(playtcount, stringplaytvii)) {
            pack.setText("" + " Buying in Plate(s)" + "");
            pacque = pack.getText().toString();
            stringue = pacque;
            myOwnPay.setText("" + Integer.toString(out * 7) + "");
            ChosenplateCounter.feetag.setText("" + Integer.toString(out * 7) + "");
        }

        else if (isChecked && Objects.equals(playtcount, stringplaytviii)) {
            pack.setText("" + " Buy in Pack(s)" + "");
            pacque = pack.getText().toString();
            stringue = pacque;
            myOwnPay.setText("" + Integer.toString(out * 8 + fourhundred) + "");
            ChosenplateCounter.feetag.setText("" + Integer.toString(out * 8 + fourhundred) + "");
        } else if (!isChecked && Objects.equals(playtcount, stringplaytviii)) {
            pack.setText("" + " Buying in Plate(s)" + "");
            pacque = pack.getText().toString();
            stringue = pacque;
            myOwnPay.setText("" + Integer.toString(out * 8) + "");
            ChosenplateCounter.feetag.setText("" + Integer.toString(out * 8) + "");
        }

        else if (isChecked && Objects.equals(playtcount, stringplaytix)) {
            pack.setText("" + " Buy in Pack(s)" + "");
            pacque = pack.getText().toString();
            stringue = pacque;
            myOwnPay.setText("" + Integer.toString(out * 9 + fourhundredfifty) + "");
            ChosenplateCounter.feetag.setText("" + Integer.toString(out * 9 + fourhundredfifty) + "");
        } else if (!isChecked && Objects.equals(playtcount, stringplaytix)) {
            pack.setText("" + " Buying in Plate(s)" + "");
            pacque = pack.getText().toString();
            stringue = pacque;
            myOwnPay.setText("" + Integer.toString(out * 9) + "");
            ChosenplateCounter.feetag.setText("" + Integer.toString(out * 9) + "");
        }

        else if (isChecked && Objects.equals(playtcount, stringplaytx)) {
            pack.setText("" + " Buy in Pack(s)" + "");
            pacque = pack.getText().toString();
            stringue = pacque;
            myOwnPay.setText("" + Integer.toString(out * 10 + fivehundred) + "");
            ChosenplateCounter.feetag.setText("" + Integer.toString(out * 10 + fivehundred) + "");
        } else if (!isChecked && Objects.equals(playtcount, stringplaytx)) {
            pack.setText("" + " Buying in Plate(s)" + "");
            pacque = pack.getText().toString();
            stringue = pacque;
            myOwnPay.setText("" + Integer.toString(out * 10) + "");
            ChosenplateCounter.feetag.setText("" + Integer.toString(out * 10) + "");
        }

        else if (isChecked && Objects.equals(playtcount, stringplaytxi)) {
            pack.setText("" + " Buy in Pack(s)" + "");
            pacque = pack.getText().toString();
            stringue = pacque;
            myOwnPay.setText("" + Integer.toString(out * 11 + fivehundredfifty) + "");
            ChosenplateCounter.feetag.setText("" + Integer.toString(out * 11 + fivehundredfifty) + "");
        } else if (!isChecked && Objects.equals(playtcount, stringplaytxi)) {
            pack.setText("" + " Buying in Plate(s)" + "");
            pacque = pack.getText().toString();
            stringue = pacque;
            myOwnPay.setText("" + Integer.toString(out * 11) + "");
            ChosenplateCounter.feetag.setText("" + Integer.toString(out * 11) + "");
        }

        else if (isChecked && Objects.equals(playtcount, stringplaytxii)) {
            pack.setText("" + " Buy in Pack(s)" + "");
            pacque = pack.getText().toString();
            stringue = pacque;
            myOwnPay.setText("" + Integer.toString(out * 12 + sixhundred) + "");
            ChosenplateCounter.feetag.setText("" + Integer.toString(out * 12 + sixhundred) + "");
        } else if (!isChecked && Objects.equals(playtcount, stringplaytxii)) {
            pack.setText("" + " Buying in Plate(s)" + "");
            pacque = pack.getText().toString();
            stringue = pacque;
            myOwnPay.setText("" + Integer.toString(out * 12) + "");
            ChosenplateCounter.feetag.setText("" + Integer.toString(out * 12) + "");
        }

        else if (isChecked && Objects.equals(playtcount, stringplaytxiii)) {
            pack.setText("" + " Buy in Pack(s)" + "");
            pacque = pack.getText().toString();
            stringue = pacque;
            myOwnPay.setText("" + Integer.toString(out * 13 + sixhundredfifty) + "");
            ChosenplateCounter.feetag.setText("" + Integer.toString(out * 13 + sixhundredfifty) + "");
        } else if (!isChecked && Objects.equals(playtcount, stringplaytxiii)) {
            pack.setText("" + " Buying in Plate(s)" + "");
            pacque = pack.getText().toString();
            stringue = pacque;
            myOwnPay.setText("" + Integer.toString(out * 13) + "");
            ChosenplateCounter.feetag.setText("" + Integer.toString(out * 13) + "");
        }

        else if (isChecked && Objects.equals(playtcount, stringplaytxiv)) {
            pack.setText("" + " Buy in Pack(s)" + "");
            pacque = pack.getText().toString();
            stringue = pacque;
            myOwnPay.setText("" + Integer.toString(out * 14 + sevenhundred) + "");
            ChosenplateCounter.feetag.setText("" + Integer.toString(out * 14 + sevenhundred) + "");
        } else if (!isChecked && Objects.equals(playtcount, stringplaytxiv)) {
            pack.setText("" + " Buying in Plate(s)" + "");
            pacque = pack.getText().toString();
            stringue = pacque;
            myOwnPay.setText("" + Integer.toString(out * 14) + "");
            ChosenplateCounter.feetag.setText("" + Integer.toString(out * 14) + "");
        }

        else if (isChecked && Objects.equals(playtcount, stringplaytxv)) {
            pack.setText("" + " Buy in Pack(s)" + "");
            pacque = pack.getText().toString();
            stringue = pacque;
            myOwnPay.setText("" + Integer.toString(out * 15 + sevenhundredfifty) + "");
            ChosenplateCounter.feetag.setText("" + Integer.toString(out * 15 + sevenhundredfifty) + "");
        } else if (!isChecked && Objects.equals(playtcount, stringplaytxv)) {
            pack.setText("" + " Buying in Plate(s)" + "");
            pacque = pack.getText().toString();
            stringue = pacque;
            myOwnPay.setText("" + Integer.toString(out * 15) + "");
            ChosenplateCounter.feetag.setText("" + Integer.toString(out * 15) + "");
        }

        else if (isChecked && Objects.equals(playtcount, stringplaytxvi)) {
            pack.setText("" + " Buy in Pack(s)" + "");
            pacque = pack.getText().toString();
            stringue = pacque;
            myOwnPay.setText("" + Integer.toString(out * 16 + eighthundred) + "");
            ChosenplateCounter.feetag.setText("" + Integer.toString(out * 16 + eighthundred) + "");
        } else if (!isChecked && Objects.equals(playtcount, stringplaytxvi)) {
            pack.setText("" + " Buying in Plate(s)" + "");
            pacque = pack.getText().toString();
            stringue = pacque;
            myOwnPay.setText("" + Integer.toString(out * 16) + "");
            ChosenplateCounter.feetag.setText("" + Integer.toString(out * 16) + "");
        }

        else if (isChecked && Objects.equals(playtcount, stringplaytxvii)) {
            pack.setText("" + " Buy in Pack(s)" + "");
            pacque = pack.getText().toString();
            stringue = pacque;
            myOwnPay.setText("" + Integer.toString(out * 17 + eighthundredfifty) + "");
            ChosenplateCounter.feetag.setText("" + Integer.toString(out * 17 + eighthundredfifty) + "");
        } else if (!isChecked && Objects.equals(playtcount, stringplaytxvii)) {
            pack.setText("" + " Buying in Plate(s)" + "");
            pacque = pack.getText().toString();
            stringue = pacque;
            myOwnPay.setText("" + Integer.toString(out * 17) + "");
            ChosenplateCounter.feetag.setText("" + Integer.toString(out * 17) + "");
        }

        else if (isChecked && Objects.equals(playtcount, stringplaytxviii)) {
            pack.setText("" + " Buy in Pack(s)" + "");
            pacque = pack.getText().toString();
            stringue = pacque;
            myOwnPay.setText("" + Integer.toString(out * 18 + ninehundred) + "");
            ChosenplateCounter.feetag.setText("" + Integer.toString(out * 18 + ninehundred) + "");
        } else if (!isChecked && Objects.equals(playtcount, stringplaytxviii)) {
            pack.setText("" + " Buying in Plate(s)" + "");
            pacque = pack.getText().toString();
            stringue = pacque;
            myOwnPay.setText("" + Integer.toString(out * 18) + "");
            ChosenplateCounter.feetag.setText("" + Integer.toString(out * 18) + "");
        }

        else if (isChecked && Objects.equals(playtcount, stringplaytxix)) {
            pack.setText("" + " Buy in Pack(s)" + "");
            pacque = pack.getText().toString();
            stringue = pacque;
            myOwnPay.setText("" + Integer.toString(out * 19 + ninehundredfifty) + "");
            ChosenplateCounter.feetag.setText("" + Integer.toString(out * 19 + ninehundredfifty) + "");
        } else if (!isChecked && Objects.equals(playtcount, stringplaytxix)) {
            pack.setText("" + " Buying in Plate(s)" + "");
            pacque = pack.getText().toString();
            stringue = pacque;
            myOwnPay.setText("" + Integer.toString(out * 19) + "");
            ChosenplateCounter.feetag.setText("" + Integer.toString(out * 19) + "");
        }

        else if (isChecked && Objects.equals(playtcount, stringplaytxx)) {
            pack.setText("" + " Buy in Pack(s)" + "");
            pacque = pack.getText().toString();
            stringue = pacque;
            myOwnPay.setText("" + Integer.toString(out * 20 + onethousand) + "");
            ChosenplateCounter.feetag.setText("" + Integer.toString(out * 20 + onethousand) + "");
        } else if (!isChecked && Objects.equals(playtcount, stringplaytxx)) {
            pack.setText("" + " Buying in Plate(s)" + "");
            pacque = pack.getText().toString();
            stringue = pacque;
            myOwnPay.setText("" + Integer.toString(out * 20) + "");
            ChosenplateCounter.feetag.setText("" + Integer.toString(out * 20) + "");
        }

        else if (isChecked && Objects.equals(playtcount, stringplaytxxi)) {
            pack.setText("" + " Buy in Pack(s)" + "");
            pacque = pack.getText().toString();
            stringue = pacque;
            myOwnPay.setText("" + Integer.toString(out * 21 + onethousandfifty) + "");
            ChosenplateCounter.feetag.setText("" + Integer.toString(out * 21 + onethousandfifty) + "");
        } else if (!isChecked && Objects.equals(playtcount, stringplaytxxi)) {
            pack.setText("" + " Buying in Plate(s)" + "");
            pacque = pack.getText().toString();
            stringue = pacque;
            myOwnPay.setText("" + Integer.toString(out * 21) + "");
            ChosenplateCounter.feetag.setText("" + Integer.toString(out * 21) + "");
        }

        else if (isChecked && Objects.equals(playtcount, stringplaytxxii)) {
            pack.setText("" + " Buy in Pack(s)" + "");
            pacque = pack.getText().toString();
            stringue = pacque;
            myOwnPay.setText("" + Integer.toString(out * 22 + onethousandhundred) + "");
            ChosenplateCounter.feetag.setText("" + Integer.toString(out * 22 + onethousandhundred) + "");
        } else if (!isChecked && Objects.equals(playtcount, stringplaytxxii)) {
            pack.setText("" + " Buying in Plate(s)" + "");
            pacque = pack.getText().toString();
            stringue = pacque;
            myOwnPay.setText("" + Integer.toString(out * 22) + "");
            ChosenplateCounter.feetag.setText("" + Integer.toString(out * 22) + "");
        }

        else if (isChecked && Objects.equals(playtcount, stringplaytxxiii)) {
            pack.setText("" + " Buy in Pack(s)" + "");
            pacque = pack.getText().toString();
            stringue = pacque;
            myOwnPay.setText("" + Integer.toString(out * 23 + onethousandonefifty) + "");
            ChosenplateCounter.feetag.setText("" + Integer.toString(out * 23 + onethousandonefifty) + "");
        } else if (!isChecked && Objects.equals(playtcount, stringplaytxxiii)) {
            pack.setText("" + " Buying in Plate(s)" + "");
            pacque = pack.getText().toString();
            stringue = pacque;
            myOwnPay.setText("" + Integer.toString(out * 23) + "");
            ChosenplateCounter.feetag.setText("" + Integer.toString(out * 23) + "");
        }

        else if (isChecked && Objects.equals(playtcount, stringplaytxxiv)) {
            pack.setText("" + " Buy in Pack(s)" + "");
            pacque = pack.getText().toString();
            stringue = pacque;
            myOwnPay.setText("" + Integer.toString(out * 24 + onethousandtwohundred) + "");
            ChosenplateCounter.feetag.setText("" + Integer.toString(out * 24 + onethousandtwohundred) + "");
        } else if (!isChecked && Objects.equals(playtcount, stringplaytxxiv)) {
            pack.setText("" + " Buying in Plate(s)" + "");
            pacque = pack.getText().toString();
            stringue = pacque;
            myOwnPay.setText("" + Integer.toString(out * 24) + "");
            ChosenplateCounter.feetag.setText("" + Integer.toString(out * 24) + "");
        }

        else if (isChecked && Objects.equals(playtcount, stringplaytxxv)) {
            pack.setText("" + " Buy in Pack(s)" + "");
            pacque = pack.getText().toString();
            stringue = pacque;
            myOwnPay.setText("" + Integer.toString(out * 25 + onethousandtwofifty) + "");
            ChosenplateCounter.feetag.setText("" + Integer.toString(out * 25 + onethousandtwofifty) + "");
        } else if (!isChecked && Objects.equals(playtcount, stringplaytxxv)) {
            pack.setText("" + " Buying in Plate(s)" + "");
            pacque = pack.getText().toString();
            stringue = pacque;
            myOwnPay.setText("" + Integer.toString(out * 25) + "");
            ChosenplateCounter.feetag.setText("" + Integer.toString(out * 25) + "");
        }

        else if (isChecked && Objects.equals(playtcount, stringplaytxxvi)) {
            pack.setText("" + " Buy in Pack(s)" + "");
            pacque = pack.getText().toString();
            stringue = pacque;
            myOwnPay.setText("" + Integer.toString(out * 26 + onethousandthreehundred) + "");
            ChosenplateCounter.feetag.setText("" + Integer.toString(out * 26 + onethousandthreehundred) + "");
        } else if (!isChecked && Objects.equals(playtcount, stringplaytxxvi)) {
            pack.setText("" + " Buying in Plate(s)" + "");
            pacque = pack.getText().toString();
            stringue = pacque;
            myOwnPay.setText("" + Integer.toString(out * 26) + "");
            ChosenplateCounter.feetag.setText("" + Integer.toString(out * 26) + "");
        }

        else if (isChecked && Objects.equals(playtcount, stringplaytxxvii)) {
            pack.setText("" + " Buy in Pack(s)" + "");
            pacque = pack.getText().toString();
            stringue = pacque;
            myOwnPay.setText("" + Integer.toString(out * 27 + onethousandthreefifty) + "");
            ChosenplateCounter.feetag.setText("" + Integer.toString(out * 27 + onethousandthreefifty) + "");
        } else if (!isChecked && Objects.equals(playtcount, stringplaytxxvii)) {
            pack.setText("" + " Buying in Plate(s)" + "");
            pacque = pack.getText().toString();
            stringue = pacque;
            myOwnPay.setText("" + Integer.toString(out * 27) + "");
            ChosenplateCounter.feetag.setText("" + Integer.toString(out * 27) + "");
        }

        else if (isChecked && Objects.equals(playtcount, stringplaytxxviii)) {
            pack.setText("" + " Buy in Pack(s)" + "");
            pacque = pack.getText().toString();
            stringue = pacque;
            myOwnPay.setText("" + Integer.toString(out * 28 + onethousandfourhundred) + "");
            ChosenplateCounter.feetag.setText("" + Integer.toString(out * 28 + onethousandfourhundred) + "");
        } else if (!isChecked && Objects.equals(playtcount, stringplaytxxviii)) {
            pack.setText("" + " Buying in Plate(s)" + "");
            pacque = pack.getText().toString();
            stringue = pacque;
            myOwnPay.setText("" + Integer.toString(out * 28) + "");
            ChosenplateCounter.feetag.setText("" + Integer.toString(out * 28) + "");
        }

        else if (isChecked && Objects.equals(playtcount, stringplaytxxix)) {
            pack.setText("" + " Buy in Pack(s)" + "");
            pacque = pack.getText().toString();
            stringue = pacque;
            myOwnPay.setText("" + Integer.toString(out * 29 + onethousandfourfifty) + "");
            ChosenplateCounter.feetag.setText("" + Integer.toString(out * 29 + onethousandfourfifty) + "");
        } else if (!isChecked && Objects.equals(playtcount, stringplaytxxix)) {
            pack.setText("" + " Buying in Plate(s)" + "");
            pacque = pack.getText().toString();
            stringue = pacque;
            myOwnPay.setText("" + Integer.toString(out * 29) + "");
            ChosenplateCounter.feetag.setText("" + Integer.toString(out * 29) + "");
        }

        else if (isChecked && Objects.equals(playtcount, stringplaytxxx)) {
            pack.setText("" + " Buy in Pack(s)" + "");
            pacque = pack.getText().toString();
            stringue = pacque;
            myOwnPay.setText("" + Integer.toString(out * 30 + onethousandfivehundred) + "");
            ChosenplateCounter.feetag.setText("" + Integer.toString(out * 30 + onethousandfivehundred) + "");
        } else if (!isChecked && Objects.equals(playtcount, stringplaytxxx)) {
            pack.setText("" + " Buying in Plate(s)" + "");
            pacque = pack.getText().toString();
            stringue = pacque;
            myOwnPay.setText("" + Integer.toString(out * 30) + "");
            ChosenplateCounter.feetag.setText("" + Integer.toString(out * 30) + "");
        }
        else if (isChecked)  {
            pack.setText("" + " Buy in Pack(s)" + "");
            pacque = pack.getText().toString();
            stringue = pacque;
            myOwnPay.setText("" + Integer.toString(out + fifty) + "");
            ChosenplateCounter.feetag.setText("" + Integer.toString(out + fifty) + "");
        }
        else {
            pack.setText("" + " Buying in Plate(s)" + "");
            pacque = pack.getText().toString();
            stringue = pacque;
            myOwnPay.setText("" + Integer.toString(out) + "");
            ChosenplateCounter.feetag.setText("" + Integer.toString(out + fifty) + "");
        }
    }

    @Override
    public void respond(int ant) {
        FragmentManager manager = getFragmentManager();

        FoodpriceFragment fpf = (FoodpriceFragment) manager.findFragmentById(R.id.FragmentFoodprice);
        fpf.Datachange(ant);
    }

    @Override
    public void setName(String name) {
        ChosenfoodFragment cff = (ChosenfoodFragment) getFragmentManager().findFragmentById(R.id.FragmentChosenfood);
        cff.updateInfo(name);

        ChosenplateCounter cpc = (ChosenplateCounter) getFragmentManager().findFragmentById(R.id.FragmentCounter);
        cpc.updateInfo(name);

        Pcount.setEnabled(true);
        Purchase.setEnabled(true);
    }

    @Override
    public void setPrice(String price) {
        ChosenplateCounter cpc = (ChosenplateCounter) getFragmentManager().findFragmentById(R.id.FragmentCounter);
        cpc.updatePrice(price);
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
                break;

            case R.id.like_plate:
                break;

            case R.id.saved_plate:
                break;

            case R.id.log_out:
                break;
        }
        return false;
    }

    public void checkMyBalance(MenuItem item) {
        Bundle myMoney = getIntent().getExtras();
        myMoney.getString("");
        Snackbar CheckMyMoney = Snackbar.make(relative, "Your balance is: " + myMoney.getString("accountbalance"), Snackbar.LENGTH_LONG);
        CheckMyMoney.setActionTextColor(Color.GREEN);
        CheckMyMoney.show();
    }

    public void iLikeThisPlate(MenuItem item) {

        String[] strings = {
                textView.isShown() ? textView.getText().toString() : null,
                textView2nd.isShown() ? textView2nd.getText().toString() : null,
                textView3rd.isShown() ? textView3rd.getText().toString() : null,
                textView4th.isShown() ? textView4th.getText().toString() : null,
                textView5th.isShown() ? textView5th.getText().toString() : null,
                textView6th.isShown() ? textView6th.getText().toString() : null,
                textView7th.isShown() ? textView7th.getText().toString() : null,
                textView8th.isShown() ? textView8th.getText().toString() : null,
                textView9th.isShown() ? textView9th.getText().toString() : null,
                textView10th.isShown() ? textView10th.getText().toString() : null};

        Bundle bundle = new Bundle();
        bundle.putString("string", Arrays.toString(strings));

        if (!textView.isShown() && !textView2nd.isShown() && !textView3rd.isShown()
                && !textView4th.isShown() && !textView5th.isShown() && !textView6th.isShown()
                && !textView7th.isShown() && !textView8th.isShown() && !textView9th.isShown()
                && !textView10th.isShown()) {

            StyleableToast LikePlate = new StyleableToast(this, "No food selected yet, Select one foodtype at least ", Toast.LENGTH_SHORT);
            LikePlate.setBackgroundColor(Color.parseColor("#FF5A5F"));
            LikePlate.setTextColor(Color.WHITE);
            LikePlate.show();
        } else {
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

    }

    public void showRecentlyBoughtPlates(MenuItem item){

        String[] strings = {
                textView.isShown() ? textView.getText().toString() : null,
                textView2nd.isShown() ? textView2nd.getText().toString() : null,
                textView3rd.isShown() ? textView3rd.getText().toString() : null,
                textView4th.isShown() ? textView4th.getText().toString() : null,
                textView5th.isShown() ? textView5th.getText().toString() : null,
                textView6th.isShown() ? textView6th.getText().toString() : null,
                textView7th.isShown() ? textView7th.getText().toString() : null,
                textView8th.isShown() ? textView8th.getText().toString() : null,
                textView9th.isShown() ? textView9th.getText().toString() : null,
                textView10th.isShown() ? textView10th.getText().toString() : null};

        if (!textView.isShown() && !textView2nd.isShown() && !textView3rd.isShown()
                && !textView4th.isShown() && !textView5th.isShown() && !textView6th.isShown()
                && !textView7th.isShown() && !textView8th.isShown() && !textView9th.isShown()
                && !textView10th.isShown()) {

            StyleableToast LikePlate = new StyleableToast(this, "No food selected yet, Select one foodtype at least ", Toast.LENGTH_SHORT);
            LikePlate.setBackgroundColor(Color.parseColor("#FF5A5F"));
            LikePlate.setTextColor(Color.WHITE);
            LikePlate.show();
        }
        else {
          /*  StyleableToast RecentlyPurchased = new StyleableToast(this, "Please select from recently bought plates", Toast.LENGTH_LONG).spinIcon();
            RecentlyPurchased.setBackgroundColor(Color.parseColor("#FF5A5F"));
            RecentlyPurchased.setTextColor(Color.WHITE);
            RecentlyPurchased.show();  */
            Intent intent = new Intent(this, FoodhistoryActivity.class);
            intent.putExtra("string", strings);
          //  startActivity(intent);
            overridePendingTransition(R.anim.slide_up_in, R.anim.slide_up_out);
        }
    }

    public void AlrightImOff(MenuItem item) {
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

    public void maxPlateCount(View view) {

        out = Integer.parseInt(String.valueOf(app.allinfoodcounter));

        final AlertDialog.Builder builder = new AlertDialog.Builder(FoodmenuActivity.this);

        try { final String[] whiteRing = app.Diamond;
                  builder.setItems(whiteRing, new DialogInterface.OnClickListener() {
                      @Override
                      public void onClick(DialogInterface dialog, int which) {
                          if (which == 0) {
                              Pcount.setText("" + "PLATE COUNT" + "");
                              StyleableToast CheckMyMoney = new StyleableToast(getApplicationContext(), "You are buying all in a plate", Toast.LENGTH_SHORT).spinIcon();
                              CheckMyMoney.setBackgroundColor(Color.parseColor("#FF5A5F"));
                              CheckMyMoney.setTextColor(Color.WHITE);
                              CheckMyMoney.show();
                              ChosenplateCounter.feetag.setText("" + Integer.toString(out) + "");
                              playtcount = stringplayti;
                          }
                          if (which == 1) {
                              Pcount.setText("PLATE COUNT\n(2)");
                              StyleableToast CheckMyMoney = new StyleableToast(getApplicationContext(), "You are buying all in two diff plates", Toast.LENGTH_SHORT).spinIcon();
                              CheckMyMoney.setBackgroundColor(Color.parseColor("#FF5A5F"));
                              CheckMyMoney.setTextColor(Color.WHITE);
                              CheckMyMoney.show();
                              ChosenplateCounter.feetag.setText("" + Integer.toString(2 * out ) + "");
                              playtcount = stringplaytii;
                          }
                          if (which == 2) {
                              Pcount.setText("PLATE COUNT\n(3)");
                              StyleableToast CheckMyMoney = new StyleableToast(getApplicationContext(), "You are buying all in three diff plates", Toast.LENGTH_SHORT).spinIcon();
                              CheckMyMoney.setBackgroundColor(Color.parseColor("#FF5A5F"));
                              CheckMyMoney.setTextColor(Color.WHITE);
                              CheckMyMoney.show();
                              ChosenplateCounter.feetag.setText("" + Integer.toString(3 * out ) + "");
                              playtcount = stringplaytiii;
                          }
                          if (which == 3) {
                              Pcount.setText("PLATE COUNT\n(4)");
                              StyleableToast CheckMyMoney = new StyleableToast(getApplicationContext(), "You are buying all in four diff plates", Toast.LENGTH_SHORT).spinIcon();
                              CheckMyMoney.setBackgroundColor(Color.parseColor("#FF5A5F"));
                              CheckMyMoney.setTextColor(Color.WHITE);
                              CheckMyMoney.show();
                              ChosenplateCounter.feetag.setText("" + Integer.toString(4 * out ) + "");
                              playtcount = stringplaytiv;
                          }
                          if (which == 4) {
                              Pcount.setText("PLATE COUNT\n(5)");
                              StyleableToast CheckMyMoney = new StyleableToast(getApplicationContext(), "You are buying all in five diff plates", Toast.LENGTH_SHORT).spinIcon();
                              CheckMyMoney.setBackgroundColor(Color.parseColor("#FF5A5F"));
                              CheckMyMoney.setTextColor(Color.WHITE);
                              CheckMyMoney.show();
                              ChosenplateCounter.feetag.setText("" + Integer.toString(5 * out ) + "");
                              playtcount = stringplaytv;
                          }
                          if (which == 5) {
                              Pcount.setText("PLATE COUNT\n(6)");
                              StyleableToast CheckMyMoney = new StyleableToast(getApplicationContext(), "You are buying all in six diff plates", Toast.LENGTH_SHORT).spinIcon();
                              CheckMyMoney.setBackgroundColor(Color.parseColor("#FF5A5F"));
                              CheckMyMoney.setTextColor(Color.WHITE);
                              CheckMyMoney.show();
                              ChosenplateCounter.feetag.setText("" + Integer.toString(6 * out ) + "");
                              playtcount = stringplaytvi;
                          }
                          if (which == 6) {
                              Pcount.setText("PLATE COUNT\n(7)");
                              StyleableToast CheckMyMoney = new StyleableToast(getApplicationContext(), "You are buying all in seven diff plates", Toast.LENGTH_SHORT).spinIcon();
                              CheckMyMoney.setBackgroundColor(Color.parseColor("#FF5A5F"));
                              CheckMyMoney.setTextColor(Color.WHITE);
                              CheckMyMoney.show();
                              ChosenplateCounter.feetag.setText("" + Integer.toString(7 * out ) + "");
                              playtcount = stringplaytvii;
                          }
                          if (which == 7) {
                              Pcount.setText("PLATE COUNT\n(8)");
                              StyleableToast CheckMyMoney = new StyleableToast(getApplicationContext(), "You are buying all in eight diff plates", Toast.LENGTH_SHORT).spinIcon();
                              CheckMyMoney.setBackgroundColor(Color.parseColor("#FF5A5F"));
                              CheckMyMoney.setTextColor(Color.WHITE);
                              CheckMyMoney.show();
                              ChosenplateCounter.feetag.setText("" + Integer.toString(8 * out ) + "");
                              playtcount = stringplaytviii;
                          }
                          if (which == 8) {
                              Pcount.setText("PLATE COUNT\n(9)");
                              StyleableToast CheckMyMoney = new StyleableToast(getApplicationContext(), "You are buying all in nine diff plates", Toast.LENGTH_SHORT).spinIcon();
                              CheckMyMoney.setBackgroundColor(Color.parseColor("#FF5A5F"));
                              CheckMyMoney.setTextColor(Color.WHITE);
                              CheckMyMoney.show();
                              ChosenplateCounter.feetag.setText("" + Integer.toString(9 * out ) + "");
                              playtcount = stringplaytix;
                          }
                          if (which == 9) {
                              Pcount.setText("PLATE COUNT\n(10)");
                              StyleableToast CheckMyMoney = new StyleableToast(getApplicationContext(), "You are buying all in ten diff plates", Toast.LENGTH_SHORT).spinIcon();
                              CheckMyMoney.setBackgroundColor(Color.parseColor("#FF5A5F"));
                              CheckMyMoney.setTextColor(Color.WHITE);
                              CheckMyMoney.show();
                              ChosenplateCounter.feetag.setText("" + Integer.toString(10 * out ) + "");
                              playtcount = stringplaytx;
                          }
                          if (which == 10) {
                              Pcount.setText("PLATE COUNT\n(11)");
                              StyleableToast CheckMyMoney = new StyleableToast(getApplicationContext(), "You are buying all in eleven diff plates", Toast.LENGTH_SHORT).spinIcon();
                              CheckMyMoney.setBackgroundColor(Color.parseColor("#FF5A5F"));
                              CheckMyMoney.setTextColor(Color.WHITE);
                              CheckMyMoney.show();
                              ChosenplateCounter.feetag.setText("" + Integer.toString(11 * out ) + "");
                              playtcount = stringplaytxi;
                          }
                          if (which == 11) {
                              Pcount.setText("PLATE COUNT\n(12)");
                              StyleableToast CheckMyMoney = new StyleableToast(getApplicationContext(), "You are buying all in twelve diff plates", Toast.LENGTH_SHORT).spinIcon();
                              CheckMyMoney.setBackgroundColor(Color.parseColor("#FF5A5F"));
                              CheckMyMoney.setTextColor(Color.WHITE);
                              CheckMyMoney.show();
                              ChosenplateCounter.feetag.setText("" + Integer.toString(12 * out ) + "");
                              playtcount = stringplaytxii;
                          }
                          if (which == 12) {
                              Pcount.setText("PLATE COUNT\n(13)");
                              StyleableToast CheckMyMoney = new StyleableToast(getApplicationContext(), "You are buying all in thirteen diff plates", Toast.LENGTH_SHORT).spinIcon();
                              CheckMyMoney.setBackgroundColor(Color.parseColor("#FF5A5F"));
                              CheckMyMoney.setTextColor(Color.WHITE);
                              CheckMyMoney.show();
                              ChosenplateCounter.feetag.setText("" + Integer.toString(13 * out ) + "");
                              playtcount = stringplaytxiii;
                          }
                          if (which == 13) {
                              Pcount.setText("PLATE COUNT\n(14)");
                              StyleableToast CheckMyMoney = new StyleableToast(getApplicationContext(), "You are buying all in fourteen diff plates", Toast.LENGTH_SHORT).spinIcon();
                              CheckMyMoney.setBackgroundColor(Color.parseColor("#FF5A5F"));
                              CheckMyMoney.setTextColor(Color.WHITE);
                              CheckMyMoney.show();
                              ChosenplateCounter.feetag.setText("" + Integer.toString(14 * out ) + "");
                              playtcount = stringplaytxiv;
                          }
                          if (which == 14) {
                              Pcount.setText("PLATE COUNT\n(15)");
                              StyleableToast CheckMyMoney = new StyleableToast(getApplicationContext(), "You are buying all in fifteen diff plates", Toast.LENGTH_SHORT).spinIcon();
                              CheckMyMoney.setBackgroundColor(Color.parseColor("#FF5A5F"));
                              CheckMyMoney.setTextColor(Color.WHITE);
                              CheckMyMoney.show();
                              ChosenplateCounter.feetag.setText("" + Integer.toString(15 * out ) + "");
                              playtcount = stringplaytxv;
                          }
                          if (which == 15) {
                              Pcount.setText("PLATE COUNT\n(16)");
                              StyleableToast CheckMyMoney = new StyleableToast(getApplicationContext(), "You are buying all in sixteen diff plates", Toast.LENGTH_SHORT).spinIcon();
                              CheckMyMoney.setBackgroundColor(Color.parseColor("#FF5A5F"));
                              CheckMyMoney.setTextColor(Color.WHITE);
                              CheckMyMoney.show();
                              ChosenplateCounter.feetag.setText("" + Integer.toString(16 * out ) + "");
                              playtcount = stringplaytxvi;
                          }
                          if (which == 16) {
                              Pcount.setText("PLATE COUNT\n(17)");
                              StyleableToast CheckMyMoney = new StyleableToast(getApplicationContext(), "You are buying all in seventeen diff plates", Toast.LENGTH_SHORT).spinIcon();
                              CheckMyMoney.setBackgroundColor(Color.parseColor("#FF5A5F"));
                              CheckMyMoney.setTextColor(Color.WHITE);
                              CheckMyMoney.show();
                              ChosenplateCounter.feetag.setText("" + Integer.toString(17 * out ) + "");
                              playtcount = stringplaytxvii;
                          }
                          if (which == 17) {
                              Pcount.setText("PLATE COUNT\n(18)");
                              StyleableToast CheckMyMoney = new StyleableToast(getApplicationContext(), "You are buying all in eighteen diff plates", Toast.LENGTH_SHORT).spinIcon();
                              CheckMyMoney.setBackgroundColor(Color.parseColor("#FF5A5F"));
                              CheckMyMoney.setTextColor(Color.WHITE);
                              CheckMyMoney.show();
                              ChosenplateCounter.feetag.setText("" + Integer.toString(18 * out ) + "");
                              playtcount = stringplaytxviii;
                          }
                          if (which == 18) {
                              Pcount.setText("PLATE COUNT\n(19)");
                              StyleableToast CheckMyMoney = new StyleableToast(getApplicationContext(), "You are buying all in nineteen diff plates", Toast.LENGTH_SHORT).spinIcon();
                              CheckMyMoney.setBackgroundColor(Color.parseColor("#FF5A5F"));
                              CheckMyMoney.setTextColor(Color.WHITE);
                              CheckMyMoney.show();
                              ChosenplateCounter.feetag.setText("" + Integer.toString(19 * out ) + "");
                              playtcount = stringplaytxix;
                          }
                          if (which == 19) {
                              Pcount.setText("PLATE COUNT\n(20)");
                              StyleableToast CheckMyMoney = new StyleableToast(getApplicationContext(), "You are buying all in twenty diff plates", Toast.LENGTH_SHORT).spinIcon();
                              CheckMyMoney.setBackgroundColor(Color.parseColor("#FF5A5F"));
                              CheckMyMoney.setTextColor(Color.WHITE);
                              CheckMyMoney.show();
                              ChosenplateCounter.feetag.setText("" + Integer.toString(20 * out ) + "");
                              playtcount = stringplaytxx;
                          }
                          if (which == 20) {
                              Pcount.setText("PLATE COUNT\n(21)");
                              StyleableToast CheckMyMoney = new StyleableToast(getApplicationContext(), "You are buying all in twentyone diff plates", Toast.LENGTH_SHORT).spinIcon();
                              CheckMyMoney.setBackgroundColor(Color.parseColor("#FF5A5F"));
                              CheckMyMoney.setTextColor(Color.WHITE);
                              CheckMyMoney.show();
                              ChosenplateCounter.feetag.setText("" + Integer.toString(21 * out ) + "");
                              playtcount = stringplaytxxi;
                          }
                          if (which == 21) {
                              Pcount.setText("PLATE COUNT\n(22)");
                              StyleableToast CheckMyMoney = new StyleableToast(getApplicationContext(), "You are buying all in twentytwo diff plates", Toast.LENGTH_SHORT).spinIcon();
                              CheckMyMoney.setBackgroundColor(Color.parseColor("#FF5A5F"));
                              CheckMyMoney.setTextColor(Color.WHITE);
                              CheckMyMoney.show();
                              ChosenplateCounter.feetag.setText("" + Integer.toString(22 * out ) + "");
                              playtcount = stringplaytxxii;
                          }
                          if (which == 22) {
                              Pcount.setText("PLATE COUNT\n(23)");
                              StyleableToast CheckMyMoney = new StyleableToast(getApplicationContext(), "You are buying all in twentythree diff plates", Toast.LENGTH_SHORT).spinIcon();
                              CheckMyMoney.setBackgroundColor(Color.parseColor("#FF5A5F"));
                              CheckMyMoney.setTextColor(Color.WHITE);
                              CheckMyMoney.show();
                              ChosenplateCounter.feetag.setText("" + Integer.toString(23 * out ) + "");
                              playtcount = stringplaytxxiii;
                          }
                          if (which == 23) {
                              Pcount.setText("PLATE COUNT\n(24)");
                              StyleableToast CheckMyMoney = new StyleableToast(getApplicationContext(), "You are buying all in twentyfour diff plates", Toast.LENGTH_SHORT).spinIcon();
                              CheckMyMoney.setBackgroundColor(Color.parseColor("#FF5A5F"));
                              CheckMyMoney.setTextColor(Color.WHITE);
                              CheckMyMoney.show();
                              ChosenplateCounter.feetag.setText("" + Integer.toString(24 * out ) + "");
                              playtcount = stringplaytxxiv;
                          }
                          if (which == 24) {
                              Pcount.setText("PLATE COUNT\n(25)");
                              StyleableToast CheckMyMoney = new StyleableToast(getApplicationContext(), "You are buying all in twentyfive diff plates", Toast.LENGTH_SHORT).spinIcon();
                              CheckMyMoney.setBackgroundColor(Color.parseColor("#FF5A5F"));
                              CheckMyMoney.setTextColor(Color.WHITE);
                              CheckMyMoney.show();
                              ChosenplateCounter.feetag.setText("" + Integer.toString(25 * out ) + "");
                              playtcount = stringplaytxxv;
                          }
                          if (which == 25) {
                              Pcount.setText("PLATE COUNT\n(26)");
                              StyleableToast CheckMyMoney = new StyleableToast(getApplicationContext(), "You are buying all in twentysix diff plates", Toast.LENGTH_SHORT).spinIcon();
                              CheckMyMoney.setBackgroundColor(Color.parseColor("#FF5A5F"));
                              CheckMyMoney.setTextColor(Color.WHITE);
                              CheckMyMoney.show();
                              ChosenplateCounter.feetag.setText("" + Integer.toString(26 * out ) + "");
                              playtcount = stringplaytxxvi;
                          }
                          if (which == 26) {
                              Pcount.setText("PLATE COUNT\n(27)");
                              StyleableToast CheckMyMoney = new StyleableToast(getApplicationContext(), "You are buying all in twentyseven diff plates", Toast.LENGTH_SHORT).spinIcon();
                              CheckMyMoney.setBackgroundColor(Color.parseColor("#FF5A5F"));
                              CheckMyMoney.setTextColor(Color.WHITE);
                              CheckMyMoney.show();
                              ChosenplateCounter.feetag.setText("" + Integer.toString(27 * out ) + "");
                              playtcount = stringplaytxxvii;
                          }
                          if (which == 27) {
                              Pcount.setText("PLATE COUNT\n(28)");
                              StyleableToast CheckMyMoney = new StyleableToast(getApplicationContext(), "You are buying all in twentyeight diff plates", Toast.LENGTH_SHORT).spinIcon();
                              CheckMyMoney.setBackgroundColor(Color.parseColor("#FF5A5F"));
                              CheckMyMoney.setTextColor(Color.WHITE);
                              CheckMyMoney.show();
                              ChosenplateCounter.feetag.setText("" + Integer.toString(28 * out ) + "");
                              playtcount = stringplaytxxviii;
                          }
                          if (which == 28) {
                              Pcount.setText("PLATE COUNT\n(29)");
                              StyleableToast CheckMyMoney = new StyleableToast(getApplicationContext(), "You are buying all in twentynine diff plates", Toast.LENGTH_SHORT).spinIcon();
                              CheckMyMoney.setBackgroundColor(Color.parseColor("#FF5A5F"));
                              CheckMyMoney.setTextColor(Color.WHITE);
                              CheckMyMoney.show();
                              ChosenplateCounter.feetag.setText("" + Integer.toString(29 * out ) + "");
                              playtcount = stringplaytxxix;
                          }
                          if (which == 29) {
                              Pcount.setText("PLATE COUNT\n(30)");
                              StyleableToast CheckMyMoney = new StyleableToast(getApplicationContext(), "You are buying all in thirty diff plates", Toast.LENGTH_SHORT).spinIcon();
                              CheckMyMoney.setBackgroundColor(Color.parseColor("#FF5A5F"));
                              CheckMyMoney.setTextColor(Color.WHITE);
                              CheckMyMoney.show();
                              ChosenplateCounter.feetag.setText("" + Integer.toString(30 * out ) + "");
                              playtcount = stringplaytxxx;
                          }
                      }
                  });
        }
        catch (NullPointerException ignored) {

        }
        builder.setCancelable(true);
        Dialog dialog = builder.create();
        dialog.show();
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
        reverseAnime(OperationAnimation.BEGIN);
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
        Log.d("FoodmenuActivity", "onPause invoked");
        wakeLock.release();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("FoodmenuActivity","onStop invoked");
        reverseAnime(OperationAnimation.ADJOURN);
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

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    private void reverseAnime(OperationAnimation bedCheck) {
        Drawable graphicsPad = AnimatedImageView.getDrawable();
        Animatable crazitivity = ((Animatable) graphicsPad);
        switch (bedCheck) {
            case BEGIN:
                crazitivity.start();
                break;
            case ADJOURN:
                crazitivity.stop();
                break;
        }
    }

}
