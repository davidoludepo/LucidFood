package com.icdatofcusgmail.lucidfood;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.muddzdev.styleabletoastlibrary.StyleableToast;

import java.util.ArrayList;
import java.util.Random;

public class LoginActivity extends AppCompatActivity {

    int intRandom;
    TextView reporterPassword, reporterUsername, textRandom;
    ArrayList<String> arrayRandom;
    public EditText UsernameField;
    public EditText PasswordField;
    Button login;
    public ImageButton clearAllUsername, clearAllPin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.d("LoginActivity","onCreate invoked"); 

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(android.R.color.transparent));
        }

        UsernameField = (EditText) findViewById(R.id.Usernamefield);
        PasswordField = (EditText) findViewById(R.id.Passwordfield);

        login = (Button) findViewById(R.id.loginbutton);

        clearAllUsername = (ImageButton) findViewById(R.id.clearAllUsername);
        clearAllPin = (ImageButton) findViewById(R.id.clearAllPin);
        clearAllUsername.setVisibility(View.GONE);
        clearAllPin.setVisibility(View.GONE);

        reporterPassword = (TextView) findViewById(R.id.reportPassWord);
        reporterUsername = (TextView) findViewById(R.id.reportUserName);
        textRandom = (TextView) findViewById(R.id.RandomMotivation);
        arrayRandom = new ArrayList();
        this.arrayRandom.add("In order to succeed, we must first believe that we can.");
        this.arrayRandom.add("You can't cross the sea merely by standing and staring at the water.");
        this.arrayRandom.add("Always do your best. What you plant now, you will harvest later.");
        this.arrayRandom.add("By failing to prepare, you are preparing to fail.");
        this.arrayRandom.add("If you can dream it, you can do it.");
        this.arrayRandom.add("It always seems impossible until it's done.");
        this.arrayRandom.add("Problems are not stop signs, they are guidelines.");
        this.arrayRandom.add("Always Dream big..One Day you'll Do It..");

        PasswordField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                clearAllPin.setVisibility(View.VISIBLE);
            }

            @Override
            public void afterTextChanged(Editable no) {

                if (no.length()==0) {
                    reporterPassword.setText("Not Entered");
                    clearAllPin.setVisibility(View.INVISIBLE);
                }
                else if (no.length()<4)
                    reporterPassword.setText("Short");
                if (no.length()==4)
                    reporterPassword.setText("Max Length");
            }
        });

        UsernameField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                clearAllUsername.setVisibility(View.VISIBLE);
            }

            @Override
            public void afterTextChanged(Editable no) {
               // login.setVisibility(View.VISIBLE);

                if (no.length()==0) {
                    reporterUsername.setText("Not Entered");
                    clearAllUsername.setVisibility(View.INVISIBLE);
                }
                if (no.length()>0)
                    reporterUsername.setText(" ");

            }
        });

        clearAllUsername.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UsernameField.getText().clear();
            }
        });

        clearAllPin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PasswordField.getText().clear();
            }
        });


    }

    public void AccessifCorrect(View view) {
        final Button button = (Button) findViewById(R.id.loginbutton);

        Animation animation = new AlphaAnimation(1.0f, 0.0f);
        animation.setDuration(1000);
        button.startAnimation(animation);

        if (UsernameField.getText().toString().equals("admin") && PasswordField.getText().toString().equals("1234")) {

            /** Also If there's enough money i.e. correct username, correct password, enough money in the  server e-wallet account **/

            StyleableToast VeriefiedKorQ = new StyleableToast(getApplicationContext(), "Welcome " + UsernameField.getText().toString(), Toast.LENGTH_SHORT).spinIcon();
            VeriefiedKorQ.setBackgroundColor(Color.parseColor("#FF5A5F"));
            VeriefiedKorQ.setTextColor(Color.WHITE);
            VeriefiedKorQ.show();
            Intent intent = new Intent(this, FoodmenuActivity.class);
            Bundle bundle = new Bundle();
            intent.putExtras(bundle);
            startActivity(intent);
        } else if (UsernameField.getText().toString().isEmpty() && PasswordField.getText().toString().isEmpty()) {
            StyleableToast EmptyFields = new StyleableToast(getApplicationContext(), "Please enter your Credentials", Toast.LENGTH_SHORT).spinIcon();
            EmptyFields.setBackgroundColor(Color.parseColor("#FF5A5F"));
            EmptyFields.setTextColor(Color.WHITE);
            EmptyFields.show();
        } else if (UsernameField.getText().toString().isEmpty()) {
            StyleableToast EmptyFields = new StyleableToast(getApplicationContext(), "Please enter your Username", Toast.LENGTH_SHORT).spinIcon();
            EmptyFields.setBackgroundColor(Color.parseColor("#FF5A5F"));
            EmptyFields.setTextColor(Color.WHITE);
            EmptyFields.show();
        } else if (PasswordField.getText().toString().isEmpty()) {
            StyleableToast EmptyFields = new StyleableToast(getApplicationContext(), "Please enter your Password", Toast.LENGTH_SHORT).spinIcon();
            EmptyFields.setBackgroundColor(Color.parseColor("#FF5A5F"));
            EmptyFields.setTextColor(Color.WHITE);
            EmptyFields.show();
        }

        else {
            StyleableToast NotVeriefiedKorQ = new StyleableToast(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_SHORT).spinIcon();
            NotVeriefiedKorQ.setBackgroundColor(Color.parseColor("#FF5A5F"));
            NotVeriefiedKorQ.setTextColor(Color.WHITE);
            NotVeriefiedKorQ.show();
            }
            /*else if (UsernameField == null){
            StyleableToast NotEnoughMoney = new StyleableToast(getApplicationContext(), "Welcome "+UsernameField.getText().toString(), Toast.LENGTH_SHORT).spinIcon();
            NotEnoughMoney.setBackgroundColor(Color.parseColor("#FF5A5F"));
            NotEnoughMoney.setTextColor(Color.WHITE);
            NotEnoughMoney.show();} */


    }

    @Override
    public void onBackPressed() {
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Unnecessary Move");
        alertDialog.setMessage("This action is prevented and unnecessary");
        alertDialog.setIcon(R.drawable.a_alert);
        alertDialog.setNeutralButton("   ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(getApplicationContext(), VendorActivity.class);
                startActivity(intent);
            }
        });
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
        this.intRandom = new Random().nextInt(4);
        this.textRandom.setText((CharSequence) this.arrayRandom.get(this.intRandom));
        Log.d("LoginActivity","onStart invoked");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LoginActivity","onResume invoked");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LoginActivity","onPause invoked");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("LoginActivity","onRestart invoked");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LoginActivity","onDestroy invoked");
    }
}
