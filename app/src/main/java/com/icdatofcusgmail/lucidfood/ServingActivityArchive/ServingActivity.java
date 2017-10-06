package com.icdatofcusgmail.lucidfood.ServingActivityArchive;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.icdatofcusgmail.lucidfood.FoodmenuActivityArchive.FoodmenuActivity;
import com.icdatofcusgmail.lucidfood.LucidApplication;
import com.icdatofcusgmail.lucidfood.R;
import com.icdatofcusgmail.lucidfood.VendorActivityArchive.VendorActivity;

public class ServingActivity extends AppCompatActivity {

    /** Build Internal-Storage here and External-Storage here for
     * bought foods using the tutorials
     * InternalDataStorage
     * and
     * ExternalDataStorage
     * @params savedInstanceState
     */

    PowerManager.WakeLock wakeLock;
    TextView textViewun, textViewdo, textViewtrois, textViewquartz, textViewfive, textViewsix, textViewsept, textVieweight, textViewnous, textViewten, textVieweleven, textViewtwelve, textViewthirteen, textViewfourteen, textViewfifteen, textViewsixteen, textViewseventeen, textVieweighteen, textViewnineteen, textViewtwenty, textViewtwentyOne, textViewPlateorPark;
    TextView textView, textView2nd, textView3rd, textView4th, textView5th, textView6th, textView7th, textView8th, textView9th, textView10th, textView11th, textView12th, textView13th, textView14th, textView15th, textView16th, textView17th, textView18th, textView19th, textView20th, textView21st;
    TextView pleaseServeMe;
    LucidApplication app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serving);

        app = LucidApplication.getInstance();

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
        SecondParcel.getString("prince");

        String azubike = SecondParcel.toString();

        String Azubike = azubike.substring(0,1).toUpperCase() + azubike.substring(1).toLowerCase();

        String vendorName = app.Nametext.getText().toString();
        String VendorName = vendorName.substring(0,1).toUpperCase() + vendorName.substring(1).toLowerCase();

        pleaseServeMe.setText(VendorName + "Please serve " + Azubike + " the following:" );



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
        textVieweleven = (TextView) findViewById(R.id.plate11);
        textVieweleven.setVisibility(View.GONE);
        textViewtwelve = (TextView) findViewById(R.id.plate12);
        textViewtwelve.setVisibility(View.GONE);
        textViewthirteen = (TextView) findViewById(R.id.plate13);
        textViewthirteen.setVisibility(View.GONE);
        textViewfourteen = (TextView) findViewById(R.id.plate14);
        textViewfourteen.setVisibility(View.GONE);
        textViewfifteen = (TextView) findViewById(R.id.plate15);
        textViewfifteen.setVisibility(View.GONE);
        textViewsixteen = (TextView) findViewById(R.id.plate16);
        textViewsixteen.setVisibility(View.GONE);
        textViewseventeen = (TextView) findViewById(R.id.plate17);
        textViewseventeen.setVisibility(View.GONE);
        textVieweighteen = (TextView) findViewById(R.id.plate18);
        textVieweighteen.setVisibility(View.GONE);
        textViewnineteen = (TextView) findViewById(R.id.plate19);
        textViewnineteen.setVisibility(View.GONE);
        textViewtwenty = (TextView) findViewById(R.id.plate20);
        textViewtwenty.setVisibility(View.GONE);
        textViewtwentyOne = (TextView) findViewById(R.id.plate21);
        textViewtwentyOne.setVisibility(View.GONE);

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
        textView11th = (Button) findViewById(R.id.Eleventhchosenbutton);
        textView12th = (Button) findViewById(R.id.Twelvthchosenbutton);
        textView13th = (Button) findViewById(R.id.Thirteenthchosenbutton);
        textView14th = (Button) findViewById(R.id.Fourteenthchosenbutton);
        textView15th = (Button) findViewById(R.id.Fifteenthchosenbutton);
        textView16th = (Button) findViewById(R.id.Sixteenthchosenbutton);
        textView17th = (Button) findViewById(R.id.Seventeenthchosenbutton);
        textView18th = (Button) findViewById(R.id.Eighteenthchosenbutton);
        textView19th = (Button) findViewById(R.id.Nineteenthchosenbutton);
        textView20th = (Button) findViewById(R.id.Twentiethchosenbutton);
        textView21st = (Button) findViewById(R.id.TwentyIstchosenbutton);

        Intent PorP = getIntent();
        String receivedvalue = PorP.getStringExtra("Roman");
        String string = PorP.getStringExtra("Key");

        if (receivedvalue.contentEquals("Buying all in a plate") && !string.contentEquals(" Buy in Pack(s)"))
            textViewPlateorPark.setText("" + "All in one Plate" + "");
        else if (receivedvalue.contentEquals("Buying all in a plate") && string.contentEquals(" Buy in Pack(s)"))
            textViewPlateorPark.setText("" + "All in one Pack" + "");


        else if (receivedvalue.contentEquals("Buying all in two plates") && !string.contentEquals(" Buy in Pack(s)"))
            textViewPlateorPark.setText("" + "All in Two different Plates" + "");
        else if (receivedvalue.contentEquals("Buying all in two plates") && string.contentEquals(" Buy in Pack(s)"))
            textViewPlateorPark.setText("" + "All in Two different Packs" + "");


        else if (receivedvalue.contentEquals("Buying all in three plates") && !string.contentEquals(" Buy in Pack(s)"))
            textViewPlateorPark.setText("" + "All in Three different Plates" + "");
        else if (receivedvalue.contentEquals("Buying all in three plates") && string.contentEquals(" Buy in Pack(s)"))
            textViewPlateorPark.setText("" + "All in Three different Packs" + "");


        else if (receivedvalue.contentEquals("Buying all in four plates") && !string.contentEquals(" Buy in Pack(s)"))
            textViewPlateorPark.setText("" + "All in Four different Plates" + "");
        else if (receivedvalue.contentEquals("Buying all in four plates") && string.contentEquals(" Buy in Pack(s)"))
            textViewPlateorPark.setText("" + "All in Four different Packs" + "");


        else if (receivedvalue.contentEquals("Buying all in five plates") && !string.contentEquals(" Buy in Pack(s)"))
            textViewPlateorPark.setText("" + "All in Five different Plates" + "");
        else if (receivedvalue.contentEquals("Buying all in five plates") && string.contentEquals(" Buy in Pack(s)"))
            textViewPlateorPark.setText("" + "All in Five different Packs" + "");


        else if (receivedvalue.contentEquals("Buying all in six plates") && !string.contentEquals(" Buy in Pack(s)"))
            textViewPlateorPark.setText("" + "All in Six different Plates" + "");
        else if (receivedvalue.contentEquals("Buying all in six plates") && string.contentEquals(" Buy in Pack(s)"))
            textViewPlateorPark.setText("" + "All in Six different Packs" + "");


        else if (receivedvalue.contentEquals("Buying all in seven plates") && !string.contentEquals(" Buy in Pack(s)"))
            textViewPlateorPark.setText("" + "All in Seven different Plates" + "");
        else if (receivedvalue.contentEquals("Buying all in seven plates") && string.contentEquals(" Buy in Pack(s)"))
            textViewPlateorPark.setText("" + "All in Seven different Pack" + "");


        else if (receivedvalue.contentEquals("Buying all in eight plates") && !string.contentEquals(" Buy in Pack(s)"))
            textViewPlateorPark.setText("" + "All in Eight different Plates" + "");
        else if (receivedvalue.contentEquals("Buying all in eight plates") && string.contentEquals(" Buy in Pack(s)"))
            textViewPlateorPark.setText("" + "All in Eight different Packs" + "");


        else if (receivedvalue.contentEquals("Buying all in nine plates") && !string.contentEquals(" Buy in Pack(s)"))
            textViewPlateorPark.setText("" + "All in Nine different Plates" + "");
        else if (receivedvalue.contentEquals("Buying all in nine plates") && string.contentEquals(" Buy in Pack(s)"))
            textViewPlateorPark.setText("" + "All in Nine different Packs" + "");


        else if (receivedvalue.contentEquals("Buying all in ten plates") && !string.contentEquals(" Buy in Pack(s)"))
            textViewPlateorPark.setText("" + "All in Ten different Plates" + "");
        else if (receivedvalue.contentEquals("Buying all in ten plates") && string.contentEquals(" Buy in Pack(s)"))
            textViewPlateorPark.setText("" + "All in Ten different Packs" + "");


        else if (receivedvalue.contentEquals("Buying all in oneone plates") && !string.contentEquals(" Buy in Pack(s)"))
            textViewPlateorPark.setText("" + "All in Eleven different Plates" + "");
        else if (receivedvalue.contentEquals("Buying all in oneone plates") && string.contentEquals(" Buy in Pack(s)"))
            textViewPlateorPark.setText("" + "All in Eleven different Packs" + "");


        else if (receivedvalue.contentEquals("Buying all in onetwo plates") && !string.contentEquals(" Buy in Pack(s)"))
            textViewPlateorPark.setText("" + "All in Twelve different Plates" + "");
        else if (receivedvalue.contentEquals("Buying all in onetwo plates") && string.contentEquals(" Buy in Pack(s)"))
            textViewPlateorPark.setText("" + "All in Twelve different Packs" + "");


        else if (receivedvalue.contentEquals("Buying all in onethree plates") && !string.contentEquals(" Buy in Pack(s)"))
            textViewPlateorPark.setText("" + "All in Thirteen different Plates" + "");
        else if (receivedvalue.contentEquals("Buying all in onethree plates") && string.contentEquals(" Buy in Pack(s)"))
            textViewPlateorPark.setText("" + "All in Thirteen different Packs" + "");


        else if (receivedvalue.contentEquals("Buying all in onefour plates") && !string.contentEquals(" Buy in Pack(s)"))
            textViewPlateorPark.setText("" + "All in Fourteen different Plates" + "");
        else if (receivedvalue.contentEquals("Buying all in onefour plates") && string.contentEquals(" Buy in Pack(s)"))
            textViewPlateorPark.setText("" + "All in Fourteen different Packs" + "");


        else if (receivedvalue.contentEquals("Buying all in onefive plates") && !string.contentEquals(" Buy in Pack(s)"))
            textViewPlateorPark.setText("" + "All in Fifteen different Plates" + "");
        else if (receivedvalue.contentEquals("Buying all in onefive plates") && string.contentEquals(" Buy in Pack(s)"))
            textViewPlateorPark.setText("" + "All in Fifteen different Packs" + "");


        else if (receivedvalue.contentEquals("Buying all in onesix plates") && !string.contentEquals(" Buy in Pack(s)"))
            textViewPlateorPark.setText("" + "All in Sixteen different Plates" + "");
        else if (receivedvalue.contentEquals("Buying all in onesix plates") && string.contentEquals(" Buy in Pack(s)"))
            textViewPlateorPark.setText("" + "All in Sixteen different Packs" + "");


        else if (receivedvalue.contentEquals("Buying all in oneseven plates") && !string.contentEquals(" Buy in Pack(s)"))
            textViewPlateorPark.setText("" + "All in Seventeen Plates" + "");
        else if (receivedvalue.contentEquals("Buying all in oneseven plates") && string.contentEquals(" Buy in Pack(s)"))
            textViewPlateorPark.setText("" + "All in Seventeen Packs" + "");


        else if (receivedvalue.contentEquals("Buying all in oneeight plates") && !string.contentEquals(" Buy in Pack(s)"))
            textViewPlateorPark.setText("" + "All in Eighteen different Plates" + "");
        else if (receivedvalue.contentEquals("Buying all in oneeight plates") && string.contentEquals(" Buy in Pack(s)"))
            textViewPlateorPark.setText("" + "All in Eighteen different Packs" + "");


        else if (receivedvalue.contentEquals("Buying all in onenine plates") && !string.contentEquals(" Buy in Pack(s)"))
            textViewPlateorPark.setText("" + "All in Nineteen different Plates" + "");
        else if (receivedvalue.contentEquals("Buying all in onenine plates") && string.contentEquals(" Buy in Pack(s)"))
            textViewPlateorPark.setText("" + "All in Nineteen different Packs" + "");


        else if (receivedvalue.contentEquals("Buying all in oneten plates") && !string.contentEquals(" Buy in Pack(s)"))
            textViewPlateorPark.setText("" + "All in Twenty different Plates" + "");
        else if (receivedvalue.contentEquals("Buying all in oneten plates") && string.contentEquals(" Buy in Pack(s)"))
            textViewPlateorPark.setText("" + "All in Twenty different Packs" + "");


        else if (receivedvalue.contentEquals("Buying all in twoone plates") && !string.contentEquals(" Buy in Pack(s)"))
            textViewPlateorPark.setText("" + "All in TwentyOne Plates" + "");
        else if (receivedvalue.contentEquals("Buying all in twoone plates") && string.contentEquals(" Buy in Pack(s)"))
            textViewPlateorPark.setText("" + "All in TwentyOne Packs" + "");


        else if (receivedvalue.contentEquals("Buying all in twotwo plates") && !string.contentEquals(" Buy in Pack(s)"))
            textViewPlateorPark.setText("" + "All in TwentyTwo different Plates" + "");
        else if (receivedvalue.contentEquals("Buying all in twotwo plates") && string.contentEquals(" Buy in Pack(s)"))
            textViewPlateorPark.setText("" + "All in TwentyTwo different Packs" + "");


        else if (receivedvalue.contentEquals("Buying all in twothree plates") && !string.contentEquals(" Buy in Pack(s)"))
            textViewPlateorPark.setText("" + "All in TwentyThree different Plates" + "");
        else if (receivedvalue.contentEquals("Buying all in twothree plates") && string.contentEquals(" Buy in Pack(s)"))
            textViewPlateorPark.setText("" + "All in TwentyThree different Packs" + "");


        else if (receivedvalue.contentEquals("Buying all in twofour plates") && !string.contentEquals(" Buy in Pack(s)"))
            textViewPlateorPark.setText("" + "All in TwentyFour different Plates" + "");
        else if (receivedvalue.contentEquals("Buying all in twofour plates") && string.contentEquals(" Buy in Pack(s)"))
            textViewPlateorPark.setText("" + "All in TwentyFour different Packs" + "");


        else if (receivedvalue.contentEquals("Buying all in twofive plates") && !string.contentEquals(" Buy in Pack(s)"))
            textViewPlateorPark.setText("" + "All in TwentyFive different Plates" + "");
        else if (receivedvalue.contentEquals("Buying all in twofive plates") && string.contentEquals(" Buy in Pack(s)"))
            textViewPlateorPark.setText("" + "All in TwentyFive different Packs" + "");


        else if (receivedvalue.contentEquals("Buying all in twosix plates") && !string.contentEquals(" Buy in Pack(s)"))
            textViewPlateorPark.setText("" + "All in TwentySix different Plates" + "");
        else if (receivedvalue.contentEquals("Buying all in twosix plates") && string.contentEquals(" Buy in Pack(s)"))
            textViewPlateorPark.setText("" + "All in TwentySix different Packs" + "");


        else if (receivedvalue.contentEquals("Buying all in twoseven plates") && !string.contentEquals(" Buy in Pack(s)"))
            textViewPlateorPark.setText("" + "All in TwentySeven different Plates" + "");
        else if (receivedvalue.contentEquals("Buying all in twoseven plates") && string.contentEquals(" Buy in Pack(s)"))
            textViewPlateorPark.setText("" + "All in TwentySeven different Packs" + "");


        else if (receivedvalue.contentEquals("Buying all in twoeight plates") && !string.contentEquals(" Buy in Pack(s)"))
            textViewPlateorPark.setText("" + "All in TwentyEight different Plates" + "");
        else if (receivedvalue.contentEquals("Buying all in twoeight plates") && string.contentEquals(" Buy in Pack(s)"))
            textViewPlateorPark.setText("" + "All in TwentyEight different Packs" + "");


        else if (receivedvalue.contentEquals("Buying all in twonine plates") && !string.contentEquals(" Buy in Pack(s)"))
            textViewPlateorPark.setText("" + "All in TwentyNine different Plates" + "");
        else if (receivedvalue.contentEquals("Buying all in twonine plates") && string.contentEquals(" Buy in Pack(s)"))
            textViewPlateorPark.setText("" + "All in TwentyNine different Packs" + "");


        else if (receivedvalue.contentEquals("Buying all in twoten plates") && !string.contentEquals(" Buy in Pack(s)"))
            textViewPlateorPark.setText("" + "All in Thirty different Plates" + "");
        else if (receivedvalue.contentEquals("Buying all in twoten plates") && string.contentEquals(" Buy in Pack(s)"))
            textViewPlateorPark.setText("" + "All in Thirty different Packs" + "");


        else {
            textViewPlateorPark.setText("" + "All in a Plate" + "");
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

        Intent obla = getIntent();
        String mami = obla.getStringExtra("chikito");
        if (FoodmenuActivity.textView11th.getVisibility() == View.VISIBLE) {
            textVieweleven.setText(mami);
            textVieweleven.setVisibility(View.VISIBLE);
        } else if (FoodmenuActivity.textView11th.getVisibility() == View.GONE) {
            textVieweleven.setVisibility(View.GONE);
        }

        Intent love = getIntent();
        String unfailing = love.getStringExtra("blackdiamond");
        if (FoodmenuActivity.textView12th.getVisibility() == View.VISIBLE) {
            textViewtwelve.setText(unfailing);
            textViewtwelve.setVisibility(View.VISIBLE);
        } else if (FoodmenuActivity.textView12th.getVisibility() == View.GONE) {
            textViewtwelve.setVisibility(View.GONE);
        }

        Intent mrnoah = getIntent();
        String studentdeveloper = mrnoah.getStringExtra("versatile");
        if (FoodmenuActivity.textView13th.getVisibility() == View.VISIBLE) {
            textViewthirteen.setText(studentdeveloper);
            textViewthirteen.setVisibility(View.VISIBLE);
        } else if (FoodmenuActivity.textView13th.getVisibility() == View.GONE) {
            textViewthirteen.setVisibility(View.GONE);
        }

        Intent google = getIntent();
        String android = google.getStringExtra("resourceful");
        if (FoodmenuActivity.textView14th.getVisibility() == View.VISIBLE) {
            textViewfourteen.setText(android);
            textViewfourteen.setVisibility(View.VISIBLE);
        } else if (FoodmenuActivity.textView14th.getVisibility() == View.GONE) {
            textViewfourteen.setVisibility(View.GONE);
        }

        Intent havillah = getIntent();
        String agadah = havillah.getStringExtra("crazitivity");
        if (FoodmenuActivity.textView15th.getVisibility() == View.VISIBLE) {
            textViewfifteen.setText(agadah);
            textViewfifteen.setVisibility(View.VISIBLE);
        } else if (FoodmenuActivity.textView15th.getVisibility() == View.GONE) {
            textViewfifteen.setVisibility(View.GONE);
        }

        Intent samuel = getIntent();
        String agbede = samuel.getStringExtra("humility");
        if (FoodmenuActivity.textView16th.getVisibility() == View.VISIBLE) {
            textViewsixteen.setText(agbede);
            textViewsixteen.setVisibility(View.VISIBLE);
        } else if (FoodmenuActivity.textView16th.getVisibility() == View.GONE) {
            textViewsixteen.setVisibility(View.GONE);
        }

        Intent praise = getIntent();
        String pop = praise.getStringExtra("omuaranprince");
        if (FoodmenuActivity.textView17th.getVisibility() == View.VISIBLE) {
            textViewseventeen.setText(pop);
            textViewseventeen.setVisibility(View.VISIBLE);
        } else if (FoodmenuActivity.textView17th.getVisibility() == View.GONE) {
            textViewseventeen.setVisibility(View.GONE);
        }

        Intent albert = getIntent();
        String mutale = albert.getStringExtra("zambian");
        if (FoodmenuActivity.textView18th.getVisibility() == View.VISIBLE) {
            textVieweighteen.setText(mutale);
            textVieweighteen.setVisibility(View.VISIBLE);
        } else if (FoodmenuActivity.textView18th.getVisibility() == View.GONE) {
            textVieweighteen.setVisibility(View.GONE);
        }

        Intent akinfenwa = getIntent();
        String dopest = akinfenwa.getStringExtra("silentassasin");
        if (FoodmenuActivity.textView19th.getVisibility() == View.VISIBLE) {
            textViewnineteen.setText(dopest);
            textViewnineteen.setVisibility(View.VISIBLE);
        } else if (FoodmenuActivity.textView19th.getVisibility() == View.GONE) {
            textViewnineteen.setVisibility(View.GONE);
        }

        Intent aize = getIntent();
        String obayan = aize.getStringExtra("speciallyunique");
        if (FoodmenuActivity.textView20th.getVisibility() == View.VISIBLE) {
            textViewtwenty.setText(obayan);
            textViewtwenty.setVisibility(View.VISIBLE);
        } else if (FoodmenuActivity.textView20th.getVisibility() == View.GONE) {
            textViewtwenty.setVisibility(View.GONE);
        }

        Intent eruku = getIntent();
        String bayo = eruku.getStringExtra("oribee");
        if (FoodmenuActivity.textView21st.getVisibility() == View.VISIBLE) {
            textViewtwentyOne.setText(bayo);
            textViewtwentyOne.setVisibility(View.VISIBLE);
        } else if (FoodmenuActivity.textView21st.getVisibility() == View.GONE) {
            textViewtwentyOne.setVisibility(View.GONE);
        }

    }

    public void NextTransactionPlease (View view) {

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
