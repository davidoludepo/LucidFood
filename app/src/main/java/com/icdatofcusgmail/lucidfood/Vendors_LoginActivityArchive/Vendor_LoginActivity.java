package com.icdatofcusgmail.lucidfood.Vendors_LoginActivityArchive;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.icdatofcusgmail.lucidfood.LucidApplication;
import com.icdatofcusgmail.lucidfood.MyCountlesston;
import com.icdatofcusgmail.lucidfood.R;
import com.icdatofcusgmail.lucidfood.VendorActivityArchive.VendorActivity;
import com.muddzdev.styleabletoastlibrary.StyleableToast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Vendor_LoginActivity extends AppCompatActivity {

    Toolbar toolbar_vendor_login;
    public EditText MyIdNo;
    TextView myIDWitness;
    ImageButton ConfirmID;
    AlertDialog.Builder cicatrixElevation;

    String IDCrossCheck_url = "http://192.168.2.75/vendor_login.php";


    LucidApplication app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor__login);


        app = LucidApplication.getInstance();

        cicatrixElevation = new AlertDialog.Builder(Vendor_LoginActivity.this);

        MyIdNo = (EditText) findViewById(R.id.idNumber);
        myIDWitness = (TextView) findViewById(R.id.RandomMotivationNVendorName);
        ConfirmID = (ImageButton) findViewById(R.id.confirmID);

        ConfirmID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MyIdNo.getText().toString().isEmpty()) {
                    StyleableToast EmptyFields = new StyleableToast(Vendor_LoginActivity.this, "Please enter your Id Number", Toast.LENGTH_SHORT).spinIcon();
                    EmptyFields.setBackgroundColor(Color.parseColor("#FF5A5F"));
                    EmptyFields.setTextColor(Color.WHITE);
                    EmptyFields.show();
                } else {
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, IDCrossCheck_url,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    try {
                                        JSONArray jsonArray = new JSONArray(response);
                                        JSONObject jsonObject = jsonArray.getJSONObject(0);
                                        String code = jsonObject.getString("code");
                                        switch (code) {
                                            case "unsuccessful_move":
                                                cicatrixElevation.setTitle("No Match");
                                                elevateCicatrix(jsonObject.getString("rejection_message"));
                                                MyIdNo.setText("");
                                                myIDWitness.setText("");
                                                break;
                                            case "successful_access":
                                                myIDWitness.setVisibility(View.VISIBLE);
                                               // myIDWitness.setText(jsonObject.getString("seller_id"));
                                                myIDWitness.setText(jsonObject.getString("seller_name"));
                                                app.sellerOruko = new Bundle();
                                                app.sellerOruko.putString("seller_name", jsonObject.getString("seller_name"));
                                                app.sellerOruko.putString("seller_id", jsonObject.getString("seller_id"));
                                                break;
                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            try {
                                AlertDialog.Builder weightBuilder = new AlertDialog.Builder(Vendor_LoginActivity.this);
                                weightBuilder.setTitle("Connection disconnected");
                                weightBuilder.setMessage("You can do it. \n Swipe down from the very top and restart the wifi from its icon");
                                weightBuilder.setIcon(R.drawable.a_alert);
                                weightBuilder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                                weightBuilder.create().show();
                                error.printStackTrace();
                            } catch (Exception ignored) {

                            }
                        }
                    }) {
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> param = new HashMap<String, String>();
                            param.put("seller_id", MyIdNo.getText().toString());
                            param.put("seller_name", myIDWitness.getText().toString());
                            return param;
                        }
                    };
                    MyCountlesston.getmInstance(Vendor_LoginActivity.this).addToRequestQueue(stringRequest);
                }
            }
        });

        toolbar_vendor_login = (Toolbar) findViewById(R.id.ToolbarVendor_LoginActivity);
        setSupportActionBar(toolbar_vendor_login);

        getSupportActionBar().setTitle("");
    }

    public void elevateCicatrix(String ping) {
        cicatrixElevation.setMessage(ping);
        cicatrixElevation.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog alertDialog = cicatrixElevation.create();
        alertDialog.show();
    }

    public void IDCinfirmed(View view) {

        if (MyIdNo.getText().toString().isEmpty()) {
            AlertDialog.Builder Emptiness = new AlertDialog.Builder(this);
            Emptiness.setTitle("Input your Id");
            Emptiness.setMessage("Please your Vendor Id number is required for service rendering");
            Emptiness.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            Emptiness.create().show();
        }
        else if (myIDWitness.getVisibility() == View.GONE) {
            AlertDialog.Builder BlackList = new AlertDialog.Builder(this);
            BlackList.setTitle("Id is not Confirmed");
            BlackList.setMessage("Please check your Id there's no match for that.");
            BlackList.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            BlackList.create().show();
        }
        else {
            AlertDialog.Builder HomelandSecurity = new AlertDialog.Builder(this);
            HomelandSecurity.setTitle("Confirm Id!");
            HomelandSecurity.setMessage("By pressing YES you login as 'Id " + MyIdNo.getText().toString() + "' with the Name as '" + myIDWitness.getText().toString() + "'. \nAre you the described one?");
            HomelandSecurity.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    Intent IdConfirmed = new Intent(Vendor_LoginActivity.this, VendorActivity.class);
                    IdConfirmed.putExtras(app.sellerOruko);
                    app.Nametext = myIDWitness;
                    app.Idtext = MyIdNo;
                    startActivity(IdConfirmed);
                }
            });
            HomelandSecurity.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            HomelandSecurity.create().show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.vendor_login_activitymenumain, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.systemSettings:
                break;
            case R.id.offthaaApp:
                break;
        }
        return true;
    }

    public void getMeAppSettings(MenuItem item) {
        AlertDialog.Builder builder = new AlertDialog.Builder(Vendor_LoginActivity.this);
        builder.setTitle("App Restart!");
        builder.setMessage("No problem but this should only be done if the App needs to be Restarted. Are you pretty Sure?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(Settings.ACTION_APPLICATION_SETTINGS));
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();

    }

    public void alrightItsTimeToRest(MenuItem item) {
        AlertDialog.Builder destroyer = new AlertDialog.Builder(this);
        destroyer.setTitle("Exit App?");
        destroyer.setMessage("This will close Lucid. Are you sure?");
        destroyer.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

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
}
