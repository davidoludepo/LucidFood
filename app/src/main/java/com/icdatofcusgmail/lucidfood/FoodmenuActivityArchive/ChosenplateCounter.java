package com.icdatofcusgmail.lucidfood.FoodmenuActivityArchive;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.icdatofcusgmail.lucidfood.LucidApplication;
import com.icdatofcusgmail.lucidfood.R;

/**
 * Created by DAVID OGUNDEPO on 03/28/2017.
 *
 */

public class ChosenplateCounter extends Fragment {

    public static int balance_exceeded_checker, items_been_selected;
    public static TextView feetag;
 //   public static EasyMoneyTextView feetag;

    Spinner spinner;
    TextView textView, textView2nd, textView3rd, textView4th, textView5th, textView6th, textView7th, textView8th, textView9th, textView10th;
    Button button, button2, button3, button4, button5, button6;

    public static int parseOne, parseTwo, parseThree, parseFour, parseFive, parseSix, parseSeven, parseEight, parseNine, parseTen, parseEleven, parseTwelve, parseThirteen, parseFourteen, parseFifteen, parseSixteen, parseSeventeen, parseEighteen, parseNineteen, parseTwenty, parseTwentyOne;
    public static String FirstSubString, SecondSubString, ThirdSubString, FourthSubString, FifthSubString, SixthSubString, SeventhSubString, EightSubString, NineSubString, TenSubString, EleventhSubString, TwelvethSubString, ThirteenthSubString, FourteenthSubString, FifteenthSubString, SixteenthSubString, SeventeenthSubString, EighteenthSubString, NineteenthSubString, TwentiethSubString, TwentyOneSubString;

    LucidApplication app;
    //String balance_exceeded_checker = "http://192.168.43.79/account_balance_difference.php";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.foodmenufragment5_chosenplate_counter, container, false);

        app = LucidApplication.getInstance();

        textView = (Button) view.findViewById(R.id.Istchosenbutton);
        textView2nd = (Button) view.findViewById(R.id.Secondchosenbutton);
        textView3rd = (Button) view.findViewById(R.id.Thirdchosenbutton);
        textView4th = (Button) view.findViewById(R.id.Fourthchosenbutton);
        textView5th = (Button) view.findViewById(R.id.Fifthchosenbutton);
        textView6th = (Button) view.findViewById(R.id.Sixthchosenbutton);
        textView7th = (Button) view.findViewById(R.id.Seventhchosenbutton);
        textView8th = (Button) view.findViewById(R.id.Eightchosenbutton);
        textView9th = (Button) view.findViewById(R.id.Ninthchosenbutton);
        textView10th = (Button) view.findViewById(R.id.Tenthchosenbutton);
        return view;
    }

    public void updatePrice(String deductPrice) {

        int cve = Integer.parseInt(deductPrice.substring(0, deductPrice.indexOf(" n")));
        app.allinfoodcounter = app.allinfoodcounter - cve;
        feetag.setText("" + app.allinfoodcounter + "");

        FoodmenuActivity.Pcount.setText("" + "PLATE COUNT" + "");
    }

    public void updateInfo(String price) {

        button = (Button) getActivity().findViewById(R.id.Istpricebutton);
        button2 = (Button) getActivity().findViewById(R.id.Secondpricebutton);
        button3 = (Button) getActivity().findViewById(R.id.Thirdpricebutton);
        button4 = (Button) getActivity().findViewById(R.id.Fourthpricebutton);
        button5 = (Button) getActivity().findViewById(R.id.Fifthpricebutton);
        button6 = (Button) getActivity().findViewById(R.id.Sixthpricebutton);

        feetag = (TextView) getActivity().findViewById(R.id.counter);
        spinner = (Spinner) getActivity().findViewById(R.id.spinnerCurrency);


        //<!--For currency textview--- !>
//        feetag.showCommas();
//        feetag.showCurrencySymbol();

    /*    spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String itemName = spinner.getSelectedItem().toString();
                String symbol = itemName.substring(itemName.indexOf("(")+1, itemName.indexOf(")"));
                feetag.setCurrency(symbol);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });   */

        feetag.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int feetag, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int feetag) {

            }

            @Override
            public void afterTextChanged(Editable s) {



                /* <!-- Please note the below strictly requires HighSea for for crashesAdmiNes --!> */ //i.e light

                try {
                    Bundle bundle = getActivity().getIntent().getExtras();
                    items_been_selected = Integer.parseInt(String.valueOf(s));
                    balance_exceeded_checker = Integer.parseInt(String.valueOf(bundle.getString("accountbalance")));

                    if (items_been_selected > balance_exceeded_checker) {
                        feetag.setTextColor(Color.parseColor("#B71C1C"));
                    } else if (items_been_selected < balance_exceeded_checker) {
                        feetag.setTextColor(Color.parseColor("#000000"));
                    } else if (items_been_selected == balance_exceeded_checker) {
                        feetag.setTextColor(Color.parseColor("#303F9F"));
                    }
                } catch (Exception ignored) {

                }

                //                StringRequest stringRequest = new StringRequest(Request.Method.POST, balance_exceeded_checker,
//                        new Response.Listener<String>() {
//                            @Override
//                            public void onResponse(String response) {
//                                try {
//                                    JSONArray jsonArray = new JSONArray(response);
//                                    JSONObject jsonObject = jsonArray.getJSONObject(0);
//                                    String code = jsonObject.getString("code");
//                                    switch (code) {
//                                        case "fetched_balance":
//
//                                            break;
//                                    }
//                                } catch (JSONException e) {
//                                    e.printStackTrace();
//                                }
//                            }
//                        }, new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//
//                    }
//                });
            }
        });

        String FirstString, SecondString, ThirdString, FourthString, FifthString, SixthString, SevenString, EightString, NineString, TenString, ElevenString, TwelveString, ThirteenString, FourteenString, FifteenString, SixteenString, SeventeenString, EighteenString, NineteenString, TwentyString, TwentyOneString;

        if (price.contentEquals("150 naira White Rice")) {
            FirstString = button.getText().toString();
            FirstSubString = FirstString.substring(FirstString.indexOf(""), FirstString.indexOf(" "));
            parseOne = Integer.parseInt(FirstSubString);
            if (!app.prev.containsKey("0")) {
                app.allinfoodcounter = app.allinfoodcounter + parseOne;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("0", "150 naira White Rice");
            } else {
                String val = app.prev.get("0");
                FirstSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                if (Integer.parseInt(FirstSubString) != parseOne) {
                    app.prev.remove("0");
                    app.prev.put("0", "150 naira White Rice");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(FirstSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseOne;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }

        } else if (price.contentEquals("200 naira White Rice")) {
            FirstString = button2.getText().toString();
            FirstSubString = FirstString.substring(FirstString.indexOf(""), FirstString.indexOf(" "));
            parseOne = Integer.parseInt(FirstSubString);
            if (!app.prev.containsKey("0")) {
                app.allinfoodcounter = app.allinfoodcounter + parseOne;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("0", "200 naira White Rice");
            } else {
                String val = app.prev.get("0");
                FirstSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                if (Integer.parseInt(FirstSubString) != parseOne) {
                    app.prev.remove("0");
                    app.prev.put("0", "200 naira White Rice");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(FirstSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseOne;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }

        } else if (price.contentEquals("250 naira White Rice")) {
            FirstString = button3.getText().toString();
            FirstSubString = FirstString.substring(FirstString.indexOf(""), FirstString.indexOf(" "));
            parseOne = Integer.parseInt(FirstSubString);
            if (!app.prev.containsKey("0")) {
                app.allinfoodcounter = app.allinfoodcounter + parseOne;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("0", "250 naira White Rice");
            } else {
                String val = app.prev.get("0");
                FirstSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                if (Integer.parseInt(FirstSubString) != parseOne) {
                    app.prev.remove("0");
                    app.prev.put("0", "250 naira White Rice");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(FirstSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseOne;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }

        } else if (price.contentEquals("300 naira White Rice")) {
            FirstString = button4.getText().toString();
            FirstSubString = FirstString.substring(FirstString.indexOf(""), FirstString.indexOf(" "));
            parseOne = Integer.parseInt(FirstSubString);
            if (!app.prev.containsKey("0")) {
                app.allinfoodcounter = app.allinfoodcounter + parseOne;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("0", "300 naira White Rice");
            } else {
                String val = app.prev.get("0");
                FirstSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                if (Integer.parseInt(FirstSubString) != parseOne) {
                    app.prev.remove("0");
                    app.prev.put("0", "300 naira White Rice");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(FirstSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseOne;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }

        } else if (price.contentEquals("350 naira White Rice")) {
            FirstString = button5.getText().toString();
            FirstSubString = FirstString.substring(FirstString.indexOf(""), FirstString.indexOf(" "));
            parseOne = Integer.parseInt(FirstSubString);
            if (!app.prev.containsKey("0")) {
                app.allinfoodcounter = app.allinfoodcounter + parseOne;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("0", "350 naira White Rice");
            } else {
                String val = app.prev.get("0");
                FirstSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                if (Integer.parseInt(FirstSubString) != parseOne) {
                    app.prev.remove("0");
                    app.prev.put("0", "350 naira White Rice");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(FirstSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseOne;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }

        } else if (price.contentEquals("400 naira White Rice")) {
            FirstString = button6.getText().toString();
            FirstSubString = FirstString.substring(FirstString.indexOf(""), FirstString.indexOf(" "));
            parseOne = Integer.parseInt(FirstSubString);
            if (!app.prev.containsKey("0")) {
                app.allinfoodcounter = app.allinfoodcounter + parseOne;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("0", "400 naira White Rice");
            } else {
                String val = app.prev.get("0");
                FirstSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                if (Integer.parseInt(FirstSubString) != parseOne) {
                    app.prev.remove("0");
                    app.prev.put("0", "400 naira White Rice");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(FirstSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseOne;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }

        }

        if (price.contentEquals("150 naira Jollof Rice")) {
            SecondString = button.getText().toString();
            SecondSubString = SecondString.substring(SecondString.indexOf(""), SecondString.indexOf(" "));
            parseTwo = Integer.parseInt(SecondSubString);
            if (!app.prev.containsKey("1")) {
                app.allinfoodcounter = app.allinfoodcounter + parseTwo;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("1", "150 naira Jollof Rice");
            } else {
                String val = app.prev.get("1");
                SecondSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                if (Integer.parseInt(SecondSubString) != parseTwo) {
                    app.prev.remove("1");
                    app.prev.put("1", "150 naira Jollof Rice");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(SecondSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseTwo;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }

        } else if (price.contentEquals("200 naira Jollof Rice")) {
            SecondString = button2.getText().toString();
            SecondSubString = SecondString.substring(SecondString.indexOf(""), SecondString.indexOf(" "));
            parseTwo = Integer.parseInt(SecondSubString);
            if (!app.prev.containsKey("1")) {
                app.allinfoodcounter = app.allinfoodcounter + parseTwo;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("1", "200 naira Jollof Rice");
            } else {
                String val = app.prev.get("1");
                SecondSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                if (Integer.parseInt(SecondSubString) != parseTwo) {
                   app.prev.remove("1");
                    app.prev.put("1", "200 naira Jollof Rice");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(SecondSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseTwo;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }

        } else if (price.contentEquals("250 naira Jollof Rice")) {
            SecondString = button3.getText().toString();
            SecondSubString = SecondString.substring(SecondString.indexOf(""), SecondString.indexOf(" "));
            parseTwo = Integer.parseInt(SecondSubString);
            if (!app.prev.containsKey("1")) {
                app.allinfoodcounter = app.allinfoodcounter + parseTwo;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("1", "250 naira Jollof Rice");
            } else {
                String val = app.prev.get("1");
                SecondSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                if (Integer.parseInt(SecondSubString) != parseTwo) {
                    app.prev.remove("1");
                    app.prev.put("1", "250 naira Jollof Rice");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(SecondSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseTwo;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }

        } else if (price.contentEquals("300 naira Jollof Rice")) {
            SecondString = button4.getText().toString();
            SecondSubString = SecondString.substring(SecondString.indexOf(""), SecondString.indexOf(" "));
            parseTwo = Integer.parseInt(SecondSubString);
            if (!app.prev.containsKey("1")) {
                app.allinfoodcounter = app.allinfoodcounter + parseTwo;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("1", "300 naira Jollof Rice");
            } else {
                String val = app.prev.get("1");
                SecondSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                if (Integer.parseInt(SecondSubString) != parseTwo) {
                    app.prev.remove("1");
                    app.prev.put("1", "300 naira Jollof Rice");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(SecondSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseTwo;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }

        } else if (price.contentEquals("350 naira Jollof Rice")) {
            SecondString = button5.getText().toString();
            SecondSubString = SecondString.substring(SecondString.indexOf(""), SecondString.indexOf(" "));
            parseTwo = Integer.parseInt(SecondSubString);
            if (!app.prev.containsKey("1")) {
                app.allinfoodcounter = app.allinfoodcounter + parseTwo;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("1", "350 naira Jollof Rice");
            } else {
                String val = app.prev.get("1");
                SecondSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                if (Integer.parseInt(SecondSubString) != parseTwo) {
                    app.prev.remove("1");
                    app.prev.put("1", "350 naira Jollof Rice");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(SecondSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseTwo;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }

        } else if (price.contentEquals("400 naira Jollof Rice")) {
            SecondString = button6.getText().toString();
            SecondSubString = SecondString.substring(SecondString.indexOf(""), SecondString.indexOf(" "));
            parseTwo = Integer.parseInt(SecondSubString);
            if (!app.prev.containsKey("1")) {
                app.allinfoodcounter = app.allinfoodcounter + parseTwo;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("1", "400 naira Jollof Rice");
            } else {
                String val = app.prev.get("1");
                SecondSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                if (Integer.parseInt(SecondSubString) != parseTwo) {
                    app.prev.remove("1");
                    app.prev.put("1", "400 naira Jollof Rice");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(SecondSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseTwo;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }
        }

            if (price.contentEquals("150 naira Fried Rice")) {
                ThirdString = button.getText().toString();
                ThirdSubString = ThirdString.substring(ThirdString.indexOf(""), ThirdString.indexOf(" "));
                parseThree = Integer.parseInt(ThirdSubString);
                if (!app.prev.containsKey("2")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseThree;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("2", "150 naira Fried Rice");
                } else {
                    String val = app.prev.get("2");
                    ThirdSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                    if (Integer.parseInt(ThirdSubString) != parseThree) {
                        app.prev.remove("2");
                        app.prev.put("2", "150 naira Fried Rice");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(ThirdSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseThree;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }

            } else if (price.contentEquals("200 naira Fried Rice")) {
                ThirdString = button2.getText().toString();
                ThirdSubString = ThirdString.substring(ThirdString.indexOf(""), ThirdString.indexOf(" "));
                parseThree = Integer.parseInt(ThirdSubString);
                if (!app.prev.containsKey("2")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseThree;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("2", "200 naira Fried Rice");
                } else {
                    String val = app.prev.get("2");
                    ThirdSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                    if (Integer.parseInt(ThirdSubString) != parseThree) {
                        app.prev.remove("2");
                        app.prev.put("2", "200 naira Fried Rice");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(ThirdSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseThree;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }


            } else if (price.contentEquals("250 naira Fried Rice")) {
                ThirdString = button3.getText().toString();
                ThirdSubString = ThirdString.substring(ThirdString.indexOf(""), ThirdString.indexOf(" "));
                parseThree = Integer.parseInt(ThirdSubString);
                if (!app.prev.containsKey("2")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseThree;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("2", "250 naira Fried Rice");
                } else {
                    String val = app.prev.get("2");
                    ThirdSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                    if (Integer.parseInt(ThirdSubString) != parseThree) {
                        app.prev.remove("2");
                        app.prev.put("2", "250 naira Fried Rice");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(ThirdSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseThree;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }

            } else if (price.contentEquals("300 naira Fried Rice")) {
                ThirdString = button4.getText().toString();
                ThirdSubString = ThirdString.substring(ThirdString.indexOf(""), ThirdString.indexOf(" "));
                parseThree = Integer.parseInt(ThirdSubString);
                if (!app.prev.containsKey("2")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseThree;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("2", "300 naira Fried Rice");
                } else {
                    String val = app.prev.get("2");
                    ThirdSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                    if (Integer.parseInt(ThirdSubString) != parseThree) {
                        app.prev.remove("2");
                        app.prev.put("2", "300 naira Fried Rice");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(ThirdSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseThree;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }

            } else if (price.contentEquals("350 naira Fried Rice")) {
                ThirdString = button5.getText().toString();
                ThirdSubString = ThirdString.substring(ThirdString.indexOf(""), ThirdString.indexOf(" "));
                parseThree = Integer.parseInt(ThirdSubString);
                if (!app.prev.containsKey("2")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseThree;
                    feetag.setText("" + app.allinfoodcounter + "");
                   app.prev.put("2", "350 naira Fried Rice");
                } else {
                    String val = app.prev.get("2");
                    ThirdSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                    if (Integer.parseInt(ThirdSubString) != parseThree) {
                        app.prev.remove("2");
                        app.prev.put("2", "350 naira Fried Rice");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(ThirdSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseThree;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }

            } else if (price.contentEquals("400 naira Fried Rice")) {
                ThirdString = button6.getText().toString();
                ThirdSubString = ThirdString.substring(ThirdString.indexOf(""), ThirdString.indexOf(" "));
                parseThree = Integer.parseInt(ThirdSubString);
                if (!app.prev.containsKey("2")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseThree;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("2", "400 naira Fried Rice");
                } else {
                    String val = app.prev.get("2");
                    ThirdSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                    if (Integer.parseInt(ThirdSubString) != parseThree) {
                        app.prev.remove("2");
                        app.prev.put("2", "400 naira Fried Rice");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(ThirdSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseThree;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }
            }

            if (price.contentEquals("150 naira Vegatable Rice")) {
                FourthString = button.getText().toString();
                FourthSubString = FourthString.substring(FourthString.indexOf(""), FourthString.indexOf(" "));
                parseFour = Integer.parseInt(FourthSubString);
                if (!app.prev.containsKey("3")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseFour;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("3", "150 naira Vegatable Rice");
                } else {
                    String val = app.prev.get("3");
                    FourthSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                    if (Integer.parseInt(FourthSubString) != parseFour) {
                        app.prev.remove("3");
                        app.prev.put("3", "150 naira Vegatable Rice");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(FourthSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseFour;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }

            } else if (price.contentEquals("200 naira Vegatable Rice")) {
                FourthString = button2.getText().toString();
                FourthSubString = FourthString.substring(FourthString.indexOf(""), FourthString.indexOf(" "));
                parseFour = Integer.parseInt(FourthSubString);
                if (!app.prev.containsKey("3")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseFour;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("3", "200 naira Vegatable Rice");
                } else {
                    String val = app.prev.get("3");
                    FourthSubString = val.substring(0, val.indexOf("n")).trim();

                    if (Integer.parseInt(FourthSubString) != parseFour) {
                        app.prev.remove("3");
                        app.prev.put("3", "200 naira Vegatable Rice");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(FourthSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseFour;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }

            } else if (price.contentEquals("250 naira Vegatable Rice")) {
                FourthString = button3.getText().toString();
                FourthSubString = FourthString.substring(FourthString.indexOf(""), FourthString.indexOf(" "));
                parseFour = Integer.parseInt(FourthSubString);
                if (!app.prev.containsKey("3")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseFour;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("3", "250 naira Vegatable Rice");
                } else {
                    String val = app.prev.get("3");
                    FourthSubString = val.substring(0, val.indexOf("n")).trim();

                    if (Integer.parseInt(FourthSubString) != parseFour) {
                        app.prev.remove("3");
                        app.prev.put("3", "250 naira Vegatable Rice");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(FourthSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseFour;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }

            } else if (price.contentEquals("300 naira Vegatable Rice")) {
                FourthString = button4.getText().toString();
                FourthSubString = FourthString.substring(FourthString.indexOf(""), FourthString.indexOf(" "));
                parseFour = Integer.parseInt(FourthSubString);
                if (!app.prev.containsKey("3")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseFour;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("3", "300 naira Vegatable Rice");
                } else {
                    String val = app.prev.get("3");
                    FourthSubString = val.substring(0, val.indexOf("n")).trim();

                    if (Integer.parseInt(FourthSubString) != parseFour) {
                        app.prev.remove("3");
                        app.prev.put("3", "300 naira Vegatable Rice");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(FourthSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseFour;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }

            } else if (price.contentEquals("350 naira Vegatable Rice")) {
                FourthString = button5.getText().toString();
                FourthSubString = FourthString.substring(FourthString.indexOf(""), FourthString.indexOf(" "));
                parseFour = Integer.parseInt(FourthSubString);
                if (!app.prev.containsKey("3")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseFour;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("3", "350 naira Vegatable Rice");
                } else {
                    String val = app.prev.get("3");
                    FourthSubString = val.substring(0, val.indexOf("n")).trim();

                    if (Integer.parseInt(FourthSubString) != parseFour) {
                        app.prev.remove("3");
                        app.prev.put("3", "350 naira Vegatable Rice");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(FourthSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseFour;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }

            } else if (price.contentEquals("400 naira Vegatable Rice")) {
                FourthString = button6.getText().toString();
                FourthSubString = FourthString.substring(FourthString.indexOf(""), FourthString.indexOf(" "));
                parseFour = Integer.parseInt(FourthSubString);
                if (!app.prev.containsKey("3")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseFour;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("3", "400 naira Vegatable Rice");
                } else {
                    String val = app.prev.get("3");
                    FourthSubString = val.substring(0, val.indexOf("n")).trim();

                    if (Integer.parseInt(FourthSubString) != parseFour) {
                        app.prev.remove("3");
                        app.prev.put("3", "400 naira Vegatable Rice");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(FourthSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseFour;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }
            }

            if (price.contentEquals("150 naira Coconut Rice")) {
                FifthString = button.getText().toString();
                FifthSubString = FifthString.substring(FifthString.indexOf(""), FifthString.indexOf(" "));
                parseFive = Integer.parseInt(FifthSubString);
                if (!app.prev.containsKey("4")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseFive;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("4", "150 naira Coconut Rice");
                } else {
                    String val = app.prev.get("4");
                    FifthSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                    if (Integer.parseInt(FifthSubString) != parseFive) {
                        app.prev.remove("4");
                        app.prev.put("4", "150 naira Coconut Rice");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(FifthSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseFive;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }

            } else if (price.contentEquals("200 naira Coconut Rice")) {
                FifthString = button2.getText().toString();
                FifthSubString = FifthString.substring(FifthString.indexOf(""), FifthString.indexOf(" "));
                parseFive = Integer.parseInt(FifthSubString);
                if (!app.prev.containsKey("4")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseFive;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("4", "200 naira Coconut Rice");
                } else {
                    String val = app.prev.get("4");
                    FifthSubString = val.substring(0, val.indexOf("n")).trim();

                    if (Integer.parseInt(FifthSubString) != parseFive) {
                        app.prev.remove("4");
                        app.prev.put("4", "200 naira Coconut Rice");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(FifthSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseFive;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }

            } else if (price.contentEquals("250 naira Coconut Rice")) {
                FifthString = button3.getText().toString();
                FifthSubString = FifthString.substring(FifthString.indexOf(""), FifthString.indexOf(" "));
                parseFive = Integer.parseInt(FifthSubString);
                if (!app.prev.containsKey("4")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseFive;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("4", "250 naira Coconut Rice");
                } else {
                    String val = app.prev.get("4");
                    FifthSubString = val.substring(0, val.indexOf("n")).trim();

                    if (Integer.parseInt(FifthSubString) != parseFive) {
                        app.prev.remove("4");
                        app.prev.put("4", "250 naira Coconut Rice");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(FifthSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseFive;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }

            } else if (price.contentEquals("300 naira Coconut Rice")) {
                FifthString = button4.getText().toString();
                FifthSubString = FifthString.substring(FifthString.indexOf(""), FifthString.indexOf(" "));
                parseFive = Integer.parseInt(FifthSubString);
                if (!app.prev.containsKey("4")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseFive;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("4", "300 naira Coconut Rice");
                } else {
                    String val = app.prev.get("4");
                    FifthSubString = val.substring(0, val.indexOf("n")).trim();

                    if (Integer.parseInt(FifthSubString) != parseFive) {
                        app.prev.remove("4");
                        app.prev.put("4", "300 naira Coconut Rice");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(FifthSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseFive;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }

            } else if (price.contentEquals("350 naira Coconut Rice")) {
                FifthString = button5.getText().toString();
                FifthSubString = FifthString.substring(FifthString.indexOf(""), FifthString.indexOf(" "));
                parseFive = Integer.parseInt(FifthSubString);
                if (!app.prev.containsKey("4")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseFive;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("4", "350 naira Coconut Rice");
                } else {
                    String val = app.prev.get("4");
                    FifthSubString = val.substring(0, val.indexOf("n")).trim();

                    if (Integer.parseInt(FifthSubString) != parseFive) {
                        app.prev.remove("4");
                        app.prev.put("4", "350 naira Coconut Rice");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(FifthSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseFive;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }

            } else if (price.contentEquals("400 naira Coconut Rice")) {
                FifthString = button6.getText().toString();
                FifthSubString = FifthString.substring(FifthString.indexOf(""), FifthString.indexOf(" "));
                parseFive = Integer.parseInt(FifthSubString);
                if (!app.prev.containsKey("4")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseFive;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("4", "400 naira Coconut Rice");
                } else {
                    String val = app.prev.get("4");
                    FifthSubString = val.substring(0, val.indexOf("n")).trim();

                    if (Integer.parseInt(FifthSubString) != parseFive) {
                        app.prev.remove("4");
                        app.prev.put("4", "400 naira Coconut Rice");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(FifthSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseFive;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }
            }

            if (price.contentEquals("100 naira Small Beef")) {
                SixthString = button.getText().toString();
                SixthSubString = SixthString.substring(SixthString.indexOf(""), SixthString.indexOf(" "));
                parseSix = Integer.parseInt(SixthSubString);
                if (!app.prev.containsKey("5")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseSix;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("5", "100 naira Small Beef");
                } else {
                    String val = app.prev.get("5");
                    SixthSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                    if (Integer.parseInt(SixthSubString) != parseSix) {
                        app.prev.remove("5");
                        app.prev.put("5", "100 naira Small Beef");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(SixthSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseSix;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }

            } else if (price.contentEquals("200 naira Small Beef(2)")) {
                SixthString = button2.getText().toString();
                SixthSubString = SixthString.substring(SixthString.indexOf(""), SixthString.indexOf(" "));
                parseSix = Integer.parseInt(SixthSubString);
                if (!app.prev.containsKey("5")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseSix;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("5", "200 naira Small Beef(2)");
                } else {
                    String val = app.prev.get("5");
                    SixthSubString = val.substring(0, val.indexOf("n")).trim();

                    if (Integer.parseInt(SixthSubString) != parseSix) {
                        app.prev.remove("5");
                        app.prev.put("5", "200 naira Small Beef(2)");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(SixthSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseSix;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }

            } else if (price.contentEquals("300 naira Small Beef(3)")) {
                SixthString = button3.getText().toString();
                SixthSubString = SixthString.substring(SixthString.indexOf(""), SixthString.indexOf(" "));
                parseSix = Integer.parseInt(SixthSubString);
                if (!app.prev.containsKey("5")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseSix;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("5", "300 naira Small Beef(3)");
                } else {
                    String val = app.prev.get("5");
                    SixthSubString = val.substring(0, val.indexOf("n")).trim();

                    if (Integer.parseInt(SixthSubString) != parseSix) {
                        app.prev.remove("5");
                        app.prev.put("5", "300 naira Small Beef(3)");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(SixthSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseSix;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }

            } else if (price.contentEquals("400 naira Small Beef(4)")) {
                SixthString = button4.getText().toString();
                SixthSubString = SixthString.substring(SixthString.indexOf(""), SixthString.indexOf(" "));
                parseSix = Integer.parseInt(SixthSubString);
                if (!app.prev.containsKey("5")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseSix;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("5", "400 naira Small Beef(4)");
                } else {
                    String val = app.prev.get("5");
                    SixthSubString = val.substring(0, val.indexOf("n")).trim();

                    if (Integer.parseInt(SixthSubString) != parseSix) {
                        app.prev.remove("5");
                        app.prev.put("5", "400 naira Small Beef(4)");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(SixthSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseSix;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }

            } else if (price.contentEquals("500 naira Small Beef(5)")) {
                SixthString = button5.getText().toString();
                SixthSubString = SixthString.substring(SixthString.indexOf(""), SixthString.indexOf(" "));
                parseSix = Integer.parseInt(SixthSubString);
                if (!app.prev.containsKey("5")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseSix;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("5", "500 naira Small Beef(5)");
                } else {
                    String val = app.prev.get("5");
                    SixthSubString = val.substring(0, val.indexOf("n")).trim();

                    if (Integer.parseInt(SixthSubString) != parseSix) {
                        app.prev.remove("5");
                        app.prev.put("5", "500 naira Small Beef(5)");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(SixthSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseSix;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }

            } else if (price.contentEquals("600 naira Small Beef(6)")) {
                SixthString = button6.getText().toString();
                SixthSubString = SixthString.substring(SixthString.indexOf(""), SixthString.indexOf(" "));
                parseSix = Integer.parseInt(SixthSubString);
                if (!app.prev.containsKey("5")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseSix;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("5", "600 naira Small Beef(6)");
                } else {
                    String val = app.prev.get("5");
                    SixthSubString = val.substring(0, val.indexOf("n")).trim();

                    if (Integer.parseInt(SixthSubString) != parseSix) {
                        app.prev.remove("5");
                        app.prev.put("5", "600 naira Small Beef(6)");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(SixthSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseSix;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }
            }

            if (price.contentEquals("200 naira Big Beef")) {
                SevenString = button.getText().toString();
                SeventhSubString = SevenString.substring(SevenString.indexOf(""), SevenString.indexOf(" "));
                parseSeven = Integer.parseInt(SeventhSubString);
                if (!app.prev.containsKey("6")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseSeven;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("6", "200 naira Big Beef");
                } else {
                    String val = app.prev.get("6");
                    SeventhSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                    if (Integer.parseInt(SeventhSubString) != parseSeven) {
                        app.prev.remove("6");
                        app.prev.put("6", "200 naira Big Beef");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(SeventhSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseSeven;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }

            } else if (price.contentEquals("400 naira Big Beef(2)")) {
                SevenString = button2.getText().toString();
                SeventhSubString = SevenString.substring(SevenString.indexOf(""), SevenString.indexOf(" "));
                parseSeven = Integer.parseInt(SeventhSubString);
                if (!app.prev.containsKey("6")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseSeven;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("6", "400 naira Big Beef(2)");
                } else {
                    String val = app.prev.get("6");
                    SeventhSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                    if (Integer.parseInt(SeventhSubString) != parseSeven) {
                        app.prev.remove("6");
                        app.prev.put("6", "400 naira Big Beef(2)");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(SeventhSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseSeven;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }

            } else if (price.contentEquals("600 naira Big Beef(3)")) {
                SevenString = button3.getText().toString();
                SeventhSubString = SevenString.substring(SevenString.indexOf(""), SevenString.indexOf(" "));
                parseSeven = Integer.parseInt(SeventhSubString);
                if (!app.prev.containsKey("6")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseSeven;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("6", "600 naira Big Beef(3)");
                } else {
                    String val = app.prev.get("6");
                    SeventhSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                    if (Integer.parseInt(SeventhSubString) != parseSeven) {
                        app.prev.remove("6");
                        app.prev.put("6", "600 naira Big Beef(3)");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(SeventhSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseSeven;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }

            } else if (price.contentEquals("800 naira Big Beef(4)")) {
                SevenString = button4.getText().toString();
                SeventhSubString = SevenString.substring(SevenString.indexOf(""), SevenString.indexOf(" "));
                parseSeven = Integer.parseInt(SeventhSubString);
                if (!app.prev.containsKey("6")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseSeven;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("6", "800 naira Big Beef(4)");
                } else {
                    String val = app.prev.get("6");
                    SeventhSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                    if (Integer.parseInt(SeventhSubString) != parseSeven) {
                        app.prev.remove("6");
                        app.prev.put("6", "800 naira Big Beef(4)");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(SeventhSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseSeven;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }

            } else if (price.contentEquals("1000 naira Big Beef(5)")) {
                SevenString = button5.getText().toString();
                SeventhSubString = SevenString.substring(SevenString.indexOf(""), SevenString.indexOf(" "));
                parseSeven = Integer.parseInt(SeventhSubString);
                if (!app.prev.containsKey("6")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseSeven;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("6", "1000 naira Big Beef(5)");
                } else {
                    String val = app.prev.get("6");
                    SeventhSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                    if (Integer.parseInt(SeventhSubString) != parseSeven) {
                        app.prev.remove("6");
                        app.prev.put("6", "1000 naira Big Beef(5)");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(SeventhSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseSeven;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }

            } else if (price.contentEquals("1200 naira Small Beef(6)")) {
                SevenString = button6.getText().toString();
                SeventhSubString = SevenString.substring(SevenString.indexOf(""), SevenString.indexOf(" "));
                parseSeven = Integer.parseInt(SeventhSubString);
                if (!app.prev.containsKey("6")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseSeven;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("6", "1200 naira Small Beef(6)");
                } else {
                    String val = app.prev.get("6");
                    SeventhSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                    if (Integer.parseInt(SeventhSubString) != parseSeven) {
                        app.prev.remove("6");
                        app.prev.put("6", "1200 naira Small Beef(6)");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(SeventhSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseSeven;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }
            }

            if (price.contentEquals("100 naira Assorted Meat")) {
                EightString = button.getText().toString();
                EightSubString = EightString.substring(EightString.indexOf(""), EightString.indexOf(" "));
                parseEight = Integer.parseInt(EightSubString);
                if (!app.prev.containsKey("7")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseEight;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("7", "100 naira Assorted Meat");
                } else {
                    String val = app.prev.get("7");
                    EightSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                    if (Integer.parseInt(EightSubString) != parseEight) {
                        app.prev.remove("7");
                        app.prev.put("7", "100 naira Assorted Meat");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(EightSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseEight;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }

            } else if (price.contentEquals("200 naira Assorted Meat(2)")) {
                EightString = button2.getText().toString();
                EightSubString = EightString.substring(EightString.indexOf(""), EightString.indexOf(" "));
                parseEight = Integer.parseInt(EightSubString);
                if (!app.prev.containsKey("7")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseEight;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("7", "200 naira Assorted Meat(2)");
                } else {
                    String val = app.prev.get("7");
                    EightSubString = val.substring(0, val.indexOf("n")).trim();

                    if (Integer.parseInt(EightSubString) != parseEight) {
                        app.prev.remove("7");
                        app.prev.put("7", "200 naira Assorted Meat(2)");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(EightSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseEight;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }

            } else if (price.contentEquals("300 naira Assorted Meat(3)")) {
                EightString = button3.getText().toString();
                EightSubString = EightString.substring(EightString.indexOf(""), EightString.indexOf(" "));
                parseEight = Integer.parseInt(EightSubString);
                if (!app.prev.containsKey("7")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseEight;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("7", "300 naira Assorted Meat(3)");
                } else {
                    String val = app.prev.get("7");
                    EightSubString = val.substring(0, val.indexOf("n")).trim();

                    if (Integer.parseInt(EightSubString) != parseEight) {
                        app.prev.remove("7");
                        app.prev.put("7", "300 naira Assorted Meat(3)");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(EightSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseEight;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }

            } else if (price.contentEquals("400 naira Assorted Meat(4)")) {
                EightString = button4.getText().toString();
                EightSubString = EightString.substring(EightString.indexOf(""), EightString.indexOf(" "));
                parseEight = Integer.parseInt(EightSubString);
                if (!app.prev.containsKey("7")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseEight;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("7", "400 naira Assorted Meat(4)");
                } else {
                    String val = app.prev.get("7");
                    EightSubString = val.substring(0, val.indexOf("n")).trim();

                    if (Integer.parseInt(EightSubString) != parseEight) {
                        app.prev.remove("7");
                        app.prev.put("7", "400 naira Assorted Meat(4)");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(EightSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseEight;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }

            } else if (price.contentEquals("500 naira Assorted Meat(5)")) {
                EightString = button5.getText().toString();
                EightSubString = EightString.substring(EightString.indexOf(""), EightString.indexOf(" "));
                parseEight = Integer.parseInt(EightSubString);
                if (!app.prev.containsKey("7")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseEight;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("7", "500 naira Assorted Meat(5)");
                } else {
                    String val = app.prev.get("7");
                    EightSubString = val.substring(0, val.indexOf("n")).trim();

                    if (Integer.parseInt(EightSubString) != parseEight) {
                        app.prev.remove("7");
                        app.prev.put("7", "500 naira Assorted Meat(5)");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(EightSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseEight;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }

            } else if (price.contentEquals("600 naira Assorted Meat(6)")) {
                EightString = button6.getText().toString();
                EightSubString = EightString.substring(EightString.indexOf(""), EightString.indexOf(" "));
                parseEight = Integer.parseInt(EightSubString);
                if (!app.prev.containsKey("7")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseEight;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("7", "600 naira Assorted Meat(6)");
                } else {
                    String val = app.prev.get("7");
                    EightSubString = val.substring(0, val.indexOf("n")).trim();

                    if (Integer.parseInt(EightSubString) != parseEight) {
                        app.prev.remove("7");
                        app.prev.put("7", "600 naira Assorted Meat(6)");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(EightSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseEight;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }
            }

            if (price.contentEquals("50 naira Ponmo")) {
                NineString = button.getText().toString();
                NineSubString = NineString.substring(NineString.indexOf(""), NineString.indexOf(" "));
                parseNine = Integer.parseInt(NineSubString);
                if (!app.prev.containsKey("8")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseNine;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("8", "50 naira Ponmo");
                } else {
                    String val = app.prev.get("8");
                    NineSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                    if (Integer.parseInt(NineSubString) != parseNine) {
                        app.prev.remove("8");
                        app.prev.put("8", "50 naira Ponmo");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(NineSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseNine;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }

            } else if (price.contentEquals("100 naira Ponmo(2)")) {
                NineString = button2.getText().toString();
                NineSubString = NineString.substring(NineString.indexOf(""), NineString.indexOf(" "));
                parseNine = Integer.parseInt(NineSubString);
                if (!app.prev.containsKey("8")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseNine;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("8", "100 naira Ponmo(2)");
                } else {
                    String val = app.prev.get("8");
                    NineSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                    if (Integer.parseInt(NineSubString) != parseNine) {
                        app.prev.remove("8");
                        app.prev.put("8", "100 naira Ponmo(2)");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(NineSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseNine;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }

            } else if (price.contentEquals("150 naira Ponmo(3)")) {
                NineString = button3.getText().toString();
                NineSubString = NineString.substring(NineString.indexOf(""), NineString.indexOf(" "));
                parseNine = Integer.parseInt(NineSubString);
                if (!app.prev.containsKey("8")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseNine;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("8", "150 naira Ponmo(3)");
                } else {
                    String val = app.prev.get("8");
                    NineSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                    if (Integer.parseInt(NineSubString) != parseNine) {
                        app.prev.remove("8");
                        app.prev.put("8", "150 naira Ponmo(3)");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(NineSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseNine;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }

            } else if (price.contentEquals("200 naira Ponmo(4)")) {
                NineString = button4.getText().toString();
                NineSubString = NineString.substring(NineString.indexOf(""), NineString.indexOf(" "));
                parseNine = Integer.parseInt(NineSubString);
                if (!app.prev.containsKey("8")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseNine;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("8", "200 naira Ponmo(4)");
                } else {
                    String val = app.prev.get("8");
                    NineSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                    if (Integer.parseInt(NineSubString) != parseNine) {
                        app.prev.remove("8");
                        app.prev.put("8", "200 naira Ponmo(4)");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(NineSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseNine;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }

            } else if (price.contentEquals("250 naira Ponmo(5)")) {
                NineString = button5.getText().toString();
                NineSubString = NineString.substring(NineString.indexOf(""), NineString.indexOf(" "));
                parseNine = Integer.parseInt(NineSubString);
                if (!app.prev.containsKey("8")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseNine;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("8", "250 naira Ponmo(5)");
                } else {
                    String val = app.prev.get("8");
                    NineSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                    if (Integer.parseInt(NineSubString) != parseNine) {
                        app.prev.remove("8");
                        app.prev.put("8", "250 naira Ponmo(5)");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(NineSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseNine;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }

            } else if (price.contentEquals("250 naira Ponmo(6)")) {
                NineString = button6.getText().toString();
                NineSubString = NineString.substring(NineString.indexOf(""), NineString.indexOf(" "));
                parseNine = Integer.parseInt(NineSubString);
                if (!app.prev.containsKey("8")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseNine;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("8", "250 naira Ponmo(6)");
                } else {
                    String val = app.prev.get("8");
                    NineSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                    if (Integer.parseInt(NineSubString) != parseNine) {
                        app.prev.remove("8");
                        app.prev.put("8", "250 naira Ponmo(6)");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(NineSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseNine;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }
            }

            if (price.contentEquals("200 naira Small Chicken")) {
                TenString = button.getText().toString();
                TenSubString = TenString.substring(TenString.indexOf(""), TenString.indexOf(" "));
                parseTen = Integer.parseInt(TenSubString);
                if (!app.prev.containsKey("9")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseTen;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("9", "200 naira Small Chicken");
                } else {
                    String val = app.prev.get("9");
                    TenSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                    if (Integer.parseInt(TenSubString) != parseTen) {
                        app.prev.remove("9");
                        app.prev.put("9", "200 naira Small Chicken");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(TenSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseTen;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }

            } else if (price.contentEquals("400 naira Small Chicken(2)")) {
                TenString = button2.getText().toString();
                TenSubString = TenString.substring(TenString.indexOf(""), TenString.indexOf(" "));
                parseTen = Integer.parseInt(TenSubString);
                if (!app.prev.containsKey("9")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseTen;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("9", "400 naira Small Chicken(2)");
                } else {
                    String val = app.prev.get("9");
                    TenSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                    if (Integer.parseInt(TenSubString) != parseTen) {
                        app.prev.remove("9");
                        app.prev.put("9", "400 naira Small Chicken(2)");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(TenSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseTen;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }

            } else if (price.contentEquals("600 naira Small Chicken(3)")) {
                TenString = button3.getText().toString();
                TenSubString = TenString.substring(TenString.indexOf(""), TenString.indexOf(" "));
                parseTen = Integer.parseInt(TenSubString);
                if (!app.prev.containsKey("9")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseTen;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("9", "600 naira Small Chicken(3)");
                } else {
                    String val = app.prev.get("9");
                    TenSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                    if (Integer.parseInt(TenSubString) != parseTen) {
                        app.prev.remove("9");
                        app.prev.put("9", "600 naira Small Chicken(3)");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(TenSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseTen;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }

            } else if (price.contentEquals("800 naira Small Chicken(4)")) {
                TenString = button4.getText().toString();
                TenSubString = TenString.substring(TenString.indexOf(""), TenString.indexOf(" "));
                parseTen = Integer.parseInt(TenSubString);
                if (!app.prev.containsKey("9")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseTen;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("9", "800 naira Small Chicken(4)");
                } else {
                    String val = app.prev.get("9");
                    TenSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                    if (Integer.parseInt(TenSubString) != parseTen) {
                        app.prev.remove("9");
                        app.prev.put("9", "800 naira Small Chicken(4)");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(TenSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseTen;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }

            } else if (price.contentEquals("1000 naira Small Chicken(5)")) {
                TenString = button5.getText().toString();
                TenSubString = TenString.substring(TenString.indexOf(""), TenString.indexOf(" "));
                parseTen = Integer.parseInt(TenSubString);
                if (!app.prev.containsKey("9")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseTen;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("9", "1000 naira Small Chicken(5)");
                } else {
                    String val = app.prev.get("9");
                    TenSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                    if (Integer.parseInt(TenSubString) != parseTen) {
                        app.prev.remove("9");
                        app.prev.put("9", "1000 naira Small Chicken(5)");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(TenSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseTen;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }

            } else if (price.contentEquals("1200 naira Small Chicken(6)")) {
                TenString = button6.getText().toString();
                TenSubString = TenString.substring(TenString.indexOf(""), TenString.indexOf(" "));
                parseTen = Integer.parseInt(TenSubString);
                if (!app.prev.containsKey("9")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseTen;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("9", "1200 naira Small Chicken(6)");
                } else {
                    String val = app.prev.get("9");
                    TenSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                    if (Integer.parseInt(TenSubString) != parseTen) {
                        app.prev.remove("9");
                        app.prev.put("9", "1200 naira Small Chicken(6)");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(TenSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseTen;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }
            }




        if (price.contentEquals("300 naira Big Chicken")) {
            ElevenString = button.getText().toString();
            EleventhSubString = ElevenString.substring(ElevenString.indexOf(""), ElevenString.indexOf(" "));
            parseEleven = Integer.parseInt(EleventhSubString);
            if (!app.prev.containsKey("10")) {
                app.allinfoodcounter = app.allinfoodcounter + parseEleven;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("10", "300 naira Big Chicken");
            } else {
                String val = app.prev.get("10");
                EleventhSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                if (Integer.parseInt(EleventhSubString) != parseEleven) {
                    app.prev.remove("10");
                    app.prev.put("10", "300 naira Big Chicken");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(EleventhSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseEleven;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }

        } else if (price.contentEquals("600 naira Big Chicken(2)")) {
            ElevenString = button2.getText().toString();
            EleventhSubString = ElevenString.substring(ElevenString.indexOf(""), ElevenString.indexOf(" "));
            parseEleven = Integer.parseInt(EleventhSubString);
            if (!app.prev.containsKey("10")) {
                app.allinfoodcounter = app.allinfoodcounter + parseEleven;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("10", "600 naira Big Chicken(2)");
            } else {
                String val = app.prev.get("10");
                EleventhSubString = val.substring(0, val.indexOf("n")).trim();

                if (Integer.parseInt(EleventhSubString) != parseEleven) {
                    app.prev.remove("10");
                    app.prev.put("10", "600 naira Big Chicken(2)");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(EleventhSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseEleven;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }

        } else if (price.contentEquals("900 naira Big Chicken(3)")) {
            ElevenString = button3.getText().toString();
            EleventhSubString = ElevenString.substring(ElevenString.indexOf(""), ElevenString.indexOf(" "));
            parseEleven = Integer.parseInt(EleventhSubString);
            if (!app.prev.containsKey("10")) {
                app.allinfoodcounter = app.allinfoodcounter + parseEleven;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("10", "900 naira Big Chicken(3)");
            } else {
                String val = app.prev.get("10");
                EleventhSubString = val.substring(0, val.indexOf("n")).trim();

                if (Integer.parseInt(EleventhSubString) != parseEleven) {
                    app.prev.remove("10");
                    app.prev.put("10", "900 naira Big Chicken(3)");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(EleventhSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseEleven;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }

        } else if (price.contentEquals("1200 naira Big Chicken(4)")) {
            ElevenString = button4.getText().toString();
            EleventhSubString = ElevenString.substring(ElevenString.indexOf(""), ElevenString.indexOf(" "));
            parseEleven = Integer.parseInt(EleventhSubString);
            if (!app.prev.containsKey("10")) {
                app.allinfoodcounter = app.allinfoodcounter + parseEleven;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("10", "1200 naira Big Chicken(4)");
            } else {
                String val = app.prev.get("10");
                EleventhSubString = val.substring(0, val.indexOf("n")).trim();

                if (Integer.parseInt(EleventhSubString) != parseEleven) {
                    app.prev.remove("10");
                    app.prev.put("10", "1200 naira Big Chicken(4)");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(EleventhSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseEleven;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }

        } else if (price.contentEquals("1500 naira Big Chicken(5)")) {
            ElevenString = button5.getText().toString();
            EleventhSubString = ElevenString.substring(ElevenString.indexOf(""), ElevenString.indexOf(" "));
            parseEleven = Integer.parseInt(EleventhSubString);
            if (!app.prev.containsKey("10")) {
                app.allinfoodcounter = app.allinfoodcounter + parseEleven;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("10", "1500 naira Big Chicken(5)");
            } else {
                String val = app.prev.get("10");
                EleventhSubString = val.substring(0, val.indexOf("n")).trim();

                if (Integer.parseInt(EleventhSubString) != parseEleven) {
                    app.prev.remove("10");
                    app.prev.put("10", "1500 naira Big Chicken(5)");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(EleventhSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseEleven;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }

        }
        else if (price.contentEquals("1800 naira Big Chicken(6)")) {
            ElevenString = button6.getText().toString();
            EleventhSubString = ElevenString.substring(ElevenString.indexOf(""), ElevenString.indexOf(" "));
            parseEleven = Integer.parseInt(EleventhSubString);
            if (!app.prev.containsKey("10")) {
                app.allinfoodcounter = app.allinfoodcounter + parseEleven;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("10", "1800 naira Big Chicken(6)");
            } else {
                String val = app.prev.get("10");
                EleventhSubString = val.substring(0, val.indexOf("n")).trim();

                if (Integer.parseInt(EleventhSubString) != parseEleven) {
                    app.prev.remove("10");
                    app.prev.put("10", "1800 naira Big Chicken(6)");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(EleventhSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseEleven;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }
        }

        if (price.contentEquals("200 naira Small Goatmeat")) {
            TwelveString = button.getText().toString();
            TwelvethSubString = TwelveString.substring(TwelveString.indexOf(""), TwelveString.indexOf(" "));
            parseTwelve = Integer.parseInt(TwelvethSubString);
            if (!app.prev.containsKey("11")) {
                app.allinfoodcounter = app.allinfoodcounter + parseTwelve;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("11", "200 naira Small Goatmeat");
            } else {
                String val = app.prev.get("11");
                TwelvethSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                if (Integer.parseInt(TwelvethSubString) != parseTwelve) {
                    app.prev.remove("11");
                    app.prev.put("11", "200 naira Small Goatmeat");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(TwelvethSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseTwelve;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }

        } else if (price.contentEquals("400 naira Small Goatmeat(2)")) {
            TwelveString = button2.getText().toString();
            TwelvethSubString = TwelveString.substring(TwelveString.indexOf(""), TwelveString.indexOf(" "));
            parseTwelve = Integer.parseInt(TwelvethSubString);
            if (!app.prev.containsKey("11")) {
                app.allinfoodcounter = app.allinfoodcounter + parseTwelve;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("11", "400 naira Small Goatmeat(2)");
            } else {
                String val = app.prev.get("11");
                TwelvethSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                if (Integer.parseInt(SecondSubString) != parseTwelve) {
                    app.prev.remove("11");
                    app.prev.put("11", "400 naira Small Goatmeat(2)");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(TwelvethSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseTwelve;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }

        } else if (price.contentEquals("600 naira Small Goatmeat(3)")) {
            TwelveString = button3.getText().toString();
            TwelvethSubString = TwelveString.substring(TwelveString.indexOf(""), TwelveString.indexOf(" "));
            parseTwelve = Integer.parseInt(TwelvethSubString);
            if (!app.prev.containsKey("11")) {
                app.allinfoodcounter = app.allinfoodcounter + parseTwelve;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("11", "600 naira Small Goatmeat(3)");
            } else {
                String val = app.prev.get("11");
                TwelvethSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                if (Integer.parseInt(TwelvethSubString) != parseTwelve) {
                    app.prev.remove("11");
                    app.prev.put("11", "600 naira Small Goatmeat(3)");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(TwelvethSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseTwelve;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }

        } else if (price.contentEquals("800 naira Small Goatmeat(4)")) {
            TwelveString = button4.getText().toString();
            TwelvethSubString = TwelveString.substring(TwelveString.indexOf(""), TwelveString.indexOf(" "));
            parseTwelve = Integer.parseInt(TwelvethSubString);
            if (!app.prev.containsKey("11")) {
                app.allinfoodcounter = app.allinfoodcounter + parseTwelve;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("11", "800 naira Small Goatmeat(4)");
            } else {
                String val = app.prev.get("11");
                TwelvethSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                if (Integer.parseInt(TwelvethSubString) != parseTwelve) {
                    app.prev.remove("11");
                    app.prev.put("11", "800 naira Small Goatmeat(4)");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(TwelvethSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseTwelve;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }

        } else if (price.contentEquals("1000 naira Small Goatmeat(5)")) {
            TwelveString = button5.getText().toString();
            TwelvethSubString = TwelveString.substring(TwelveString.indexOf(""), TwelveString.indexOf(" "));
            parseTwelve = Integer.parseInt(TwelvethSubString);
            if (!app.prev.containsKey("11")) {
                app.allinfoodcounter = app.allinfoodcounter + parseTwelve;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("11", "1000 naira Small Goatmeat(5)");
            } else {
                String val = app.prev.get("11");
                TwelvethSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                if (Integer.parseInt(TwelvethSubString) != parseTwelve) {
                    app.prev.remove("11");
                    app.prev.put("11", "1000 naira Small Goatmeat(5)");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(TwelvethSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseTwelve;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }

        }
        else if (price.contentEquals("1200 naira Small Goatmeat(6)")) {
            TwelveString = button6.getText().toString();
            TwelvethSubString = TwelveString.substring(TwelveString.indexOf(""), TwelveString.indexOf(" "));
            parseTwelve = Integer.parseInt(TwelvethSubString);
            if (!app.prev.containsKey("11")) {
                app.allinfoodcounter = app.allinfoodcounter + parseTwelve;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("11", "1200 naira Small Goatmeat(6)");
            } else {
                String val = app.prev.get("11");
                TwelvethSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                if (Integer.parseInt(TwelvethSubString) != parseTwelve) {
                    app.prev.remove("11");
                    app.prev.put("11", "1200 naira Small Goatmeat(6)");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(TwelvethSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseTwelve;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }
        }

        if (price.contentEquals("300 naira Big Goatmeat")) {
            ThirteenString = button.getText().toString();
            ThirteenthSubString = ThirteenString.substring(ThirteenString.indexOf(""), ThirteenString.indexOf(" "));
            parseThirteen = Integer.parseInt(ThirteenthSubString);
            if (!app.prev.containsKey("12")) {
                app.allinfoodcounter = app.allinfoodcounter + parseThirteen;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("12", "300 naira Big Goatmeat");
            } else {
                String val = app.prev.get("12");
                ThirteenthSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                if (Integer.parseInt(ThirteenthSubString) != parseThirteen) {
                    app.prev.remove("12");
                    app.prev.put("12", "300 naira Big Goatmeat");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(ThirteenthSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseThirteen;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }

        } else if (price.contentEquals("600 naira Big Goatmeat(2)")) {
            ThirteenString = button2.getText().toString();
            ThirteenthSubString = ThirteenString.substring(ThirteenString.indexOf(""), ThirteenString.indexOf(" "));
            parseThirteen = Integer.parseInt(ThirteenthSubString);
            if (!app.prev.containsKey("12")) {
                app.allinfoodcounter = app.allinfoodcounter + parseThirteen;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("12", "600 naira Big Goatmeat(2)");
            } else {
                String val = app.prev.get("12");
                ThirteenthSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                if (Integer.parseInt(ThirteenthSubString) != parseThirteen) {
                    app.prev.remove("12");
                    app.prev.put("12", "600 naira Big Goatmeat(2)");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(ThirteenthSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseThirteen;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }


        } else if (price.contentEquals("900 naira Big Goatmeat(3)")) {
            ThirteenString = button3.getText().toString();
            ThirteenthSubString = ThirteenString.substring(ThirteenString.indexOf(""), ThirteenString.indexOf(" "));
            parseThirteen = Integer.parseInt(ThirteenthSubString);
            if (!app.prev.containsKey("12")) {
                app.allinfoodcounter = app.allinfoodcounter + parseThirteen;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("12", "900 naira Big Goatmeat(3)");
            } else {
                String val = app.prev.get("12");
                ThirteenthSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                if (Integer.parseInt(ThirteenthSubString) != parseThirteen) {
                    app.prev.remove("12");
                    app.prev.put("12", "900 naira Big Goatmeat(3)");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(ThirteenthSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseThirteen;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }

        } else if (price.contentEquals("1200 naira Big Goatmeat(4)")) {
            ThirteenString = button4.getText().toString();
            ThirteenthSubString = ThirteenString.substring(ThirteenString.indexOf(""), ThirteenString.indexOf(" "));
            parseThirteen = Integer.parseInt(ThirteenthSubString);
            if (!app.prev.containsKey("12")) {
                app.allinfoodcounter = app.allinfoodcounter + parseThirteen;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("12", "1200 naira Big Goatmeat(4)");
            } else {
                String val = app.prev.get("12");
                ThirteenthSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                if (Integer.parseInt(ThirteenthSubString) != parseThirteen) {
                    app.prev.remove("12");
                    app.prev.put("12", "1200 naira Big Goatmeat(4)");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(ThirteenthSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseThirteen;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }

        } else if (price.contentEquals("1500 naira Big Goatmeat(5)")) {
            ThirteenString = button5.getText().toString();
            ThirteenthSubString = ThirteenString.substring(ThirteenString.indexOf(""), ThirteenString.indexOf(" "));
            parseThirteen = Integer.parseInt(ThirteenthSubString);
            if (!app.prev.containsKey("12")) {
                app.allinfoodcounter = app.allinfoodcounter + parseThirteen;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("12", "1500 naira Big Goatmeat(5)");
            } else {
                String val = app.prev.get("12");
                ThirteenthSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                if (Integer.parseInt(ThirteenthSubString) != parseThirteen) {
                    app.prev.remove("12");
                    app.prev.put("12", "1500 naira Big Goatmeat(5)");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(ThirteenthSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseThirteen;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }

        }
        else if (price.contentEquals("1800 naira Big Goatmeat(6)")) {
            ThirteenString = button6.getText().toString();
            ThirteenthSubString = ThirteenString.substring(ThirteenString.indexOf(""), ThirteenString.indexOf(" "));
            parseThirteen = Integer.parseInt(ThirteenthSubString);
            if (!app.prev.containsKey("12")) {
                app.allinfoodcounter = app.allinfoodcounter + parseThirteen;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("12", "1800 naira Big Goatmeat(6)");
            } else {
                String val = app.prev.get("12");
                ThirteenthSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                if (Integer.parseInt(ThirteenthSubString) != parseThirteen) {
                    app.prev.remove("12");
                    app.prev.put("12", "1800 naira Big Goatmeat(6)");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(ThirteenthSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseThirteen;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }
        }

        if (price.contentEquals("100 naira Titus Fish")) {
            FourteenString = button.getText().toString();
            FourteenthSubString = FourteenString.substring(FourteenString.indexOf(""), FourteenString.indexOf(" "));
            parseFourteen = Integer.parseInt(FourteenthSubString);
            if (!app.prev.containsKey("13")) {
                app.allinfoodcounter = app.allinfoodcounter + parseFourteen;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("13", "100 naira Titus Fish");
            } else {
                String val = app.prev.get("13");
                FourteenthSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                if (Integer.parseInt(FourteenthSubString) != parseFourteen) {
                    app.prev.remove("13");
                    app.prev.put("13", "100 naira Titus Fish");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(FourteenthSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseFourteen;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }

        } else if (price.contentEquals("200 naira Titus Fish(2)")) {
            FourteenString = button2.getText().toString();
            FourteenthSubString = FourteenString.substring(FourteenString.indexOf(""), FourteenString.indexOf(" "));
            parseFourteen = Integer.parseInt(FourteenthSubString);
            if (!app.prev.containsKey("13")) {
                app.allinfoodcounter = app.allinfoodcounter + parseFourteen;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("13", "200 naira Titus Fish(2)");
            } else {
                String val = app.prev.get("13");
                FourteenthSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                if (Integer.parseInt(FourteenthSubString) != parseFourteen) {
                    app.prev.remove("13");
                    app.prev.put("13", "200 naira Titus Fish(2)");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(FourteenthSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseFourteen;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }

        } else if (price.contentEquals("300 naira Titus Fish(3)")) {
            FourteenString = button3.getText().toString();
            FourteenthSubString = FourteenString.substring(FourteenString.indexOf(""), FourteenString.indexOf(" "));
            parseFourteen = Integer.parseInt(FourteenthSubString);
            if (!app.prev.containsKey("13")) {
                app.allinfoodcounter = app.allinfoodcounter + parseFourteen;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("13", "300 naira Titus Fish(3)");
            } else {
                String val = app.prev.get("13");
                FourteenthSubString = val.substring(0, val.indexOf("n")).trim();

                if (Integer.parseInt(FourteenthSubString) != parseFourteen) {
                    app.prev.remove("13");
                    app.prev.put("13", "300 naira Titus Fish(3)");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(FourteenthSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseFourteen;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }

        } else if (price.contentEquals("400 naira Titus Fish(4)")) {
            FourteenString = button4.getText().toString();
            FourteenthSubString = FourteenString.substring(FourteenString.indexOf(""), FourteenString.indexOf(" "));
            parseFourteen = Integer.parseInt(FourteenthSubString);
            if (!app.prev.containsKey("13")) {
                app.allinfoodcounter = app.allinfoodcounter + parseFourteen;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("13", "400 naira Titus Fish(4)");
            } else {
                String val = app.prev.get("13");
                FourteenthSubString = val.substring(0, val.indexOf("n")).trim();

                if (Integer.parseInt(FourteenthSubString) != parseFourteen) {
                    app.prev.remove("13");
                    app.prev.put("13", "400 naira Titus Fish(4)");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(FourteenthSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseFourteen;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }

        } else if (price.contentEquals("500 naira Titus Fish(5)")) {
            FourteenString = button5.getText().toString();
            FourteenthSubString = FourteenString.substring(FourteenString.indexOf(""), FourteenString.indexOf(" "));
            parseFourteen = Integer.parseInt(FourteenthSubString);
            if (!app.prev.containsKey("13")) {
                app.allinfoodcounter = app.allinfoodcounter + parseFourteen;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("13", "500 naira Titus Fish(5)");
            } else {
                String val = app.prev.get("13");
                FourteenthSubString = val.substring(0, val.indexOf("n")).trim();

                if (Integer.parseInt(FourteenthSubString) != parseFourteen) {
                    app.prev.remove("13");
                    app.prev.put("13", "500 naira Titus Fish(5)");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(FourteenthSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseFourteen;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }

        }
        else if (price.contentEquals("600 naira Titus Fish(6)")) {
            FourteenString = button6.getText().toString();
            FourteenthSubString = FourteenString.substring(FourteenString.indexOf(""), FourteenString.indexOf(" "));
            parseFourteen = Integer.parseInt(FourteenthSubString);
            if (!app.prev.containsKey("13")) {
                app.allinfoodcounter = app.allinfoodcounter + parseFourteen;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("13", "600 naira Titus Fish(6)");
            } else {
                String val = app.prev.get("13");
                FourteenthSubString = val.substring(0, val.indexOf("n")).trim();

                if (Integer.parseInt(FourteenthSubString) != parseFourteen) {
                    app.prev.remove("13");
                    app.prev.put("13", "600 naira Titus Fish(6)");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(FourteenthSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseFourteen;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }
        }

        if (price.contentEquals("100 naira Sawa Fish")) {
            FifteenString = button.getText().toString();
            FifteenthSubString = FifteenString.substring(FifteenString.indexOf(""), FifteenString.indexOf(" "));
            parseFifteen = Integer.parseInt(FifteenthSubString);
            if (!app.prev.containsKey("14")) {
                app.allinfoodcounter = app.allinfoodcounter + parseFifteen;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("14", "100 naira Sawa Fish");
            } else {
                String val = app.prev.get("14");
                FifteenthSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                if (Integer.parseInt(FifteenthSubString) != parseFifteen) {
                    app.prev.remove("14");
                    app.prev.put("14", "100 naira Sawa Fish");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(FifteenthSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseFifteen;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }

        } else if (price.contentEquals("200 naira Sawa Fish(2)")) {
            FifteenString = button2.getText().toString();
            FifteenthSubString = FifteenString.substring(FifteenString.indexOf(""), FifteenString.indexOf(" "));
            parseFifteen = Integer.parseInt(FifteenthSubString);
            if (!app.prev.containsKey("14")) {
                app.allinfoodcounter = app.allinfoodcounter + parseFifteen;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("14", "200 naira Sawa Fish(2)");
            } else {
                String val = app.prev.get("14");
                FifteenthSubString = val.substring(0, val.indexOf("n")).trim();

                if (Integer.parseInt(FifteenthSubString) != parseFifteen) {
                    app.prev.remove("14");
                    app.prev.put("14", "200 naira Sawa Fish(2)");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(FifteenthSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseFifteen;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }

        } else if (price.contentEquals("300 naira Sawa Fish(3)")) {
            FifteenString = button3.getText().toString();
            FifteenthSubString = FifteenString.substring(FifteenString.indexOf(""), FifteenString.indexOf(" "));
            parseFifteen = Integer.parseInt(FifteenthSubString);
            if (!app.prev.containsKey("14")) {
                app.allinfoodcounter = app.allinfoodcounter + parseFifteen;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("14", "300 naira Sawa Fish(3)");
            } else {
                String val = app.prev.get("14");
                FifteenthSubString = val.substring(0, val.indexOf("n")).trim();

                if (Integer.parseInt(FifthSubString) != parseFifteen) {
                    app.prev.remove("14");
                    app.prev.put("14", "300 naira Sawa Fish(3)");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(FifteenthSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseFifteen;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }

        } else if (price.contentEquals("400 naira Sawa Fish(4)")) {
            FifteenString = button4.getText().toString();
            FifteenthSubString = FifteenString.substring(FifteenString.indexOf(""), FifteenString.indexOf(" "));
            parseFifteen = Integer.parseInt(FifteenthSubString);
            if (!app.prev.containsKey("14")) {
                app.allinfoodcounter = app.allinfoodcounter + parseFifteen;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("14", "400 naira Sawa Fish(4)");
            } else {
                String val = app.prev.get("14");
                FifteenthSubString = val.substring(0, val.indexOf("n")).trim();

                if (Integer.parseInt(FifteenthSubString) != parseFifteen) {
                    app.prev.remove("14");
                    app.prev.put("14", "400 naira Sawa Fish(4)");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(FifteenthSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseFifteen;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }

        } else if (price.contentEquals("500 naira Sawa Fish(5)")) {
            FifteenString = button5.getText().toString();
            FifteenthSubString = FifteenString.substring(FifteenString.indexOf(""), FifteenString.indexOf(" "));
            parseFifteen = Integer.parseInt(FifteenthSubString);
            if (!app.prev.containsKey("14")) {
                app.allinfoodcounter = app.allinfoodcounter + parseFifteen;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("14", "500 naira Sawa Fish(5)");
            } else {
                String val = app.prev.get("14");
                FifteenthSubString = val.substring(0, val.indexOf("n")).trim();

                if (Integer.parseInt(FifteenthSubString) != parseFifteen) {
                    app.prev.remove("14");
                    app.prev.put("14", "500 naira Sawa Fish(5)");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(FifteenthSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseFifteen;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }

        }
        else if (price.contentEquals("600 naira Sawa Fish(6)")) {
            FifteenString = button6.getText().toString();
            FifteenthSubString = FifteenString.substring(FifteenString.indexOf(""), FifteenString.indexOf(" "));
            parseFifteen = Integer.parseInt(FifteenthSubString);
            if (!app.prev.containsKey("14")) {
                app.allinfoodcounter = app.allinfoodcounter + parseFifteen;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("14", "600 naira Sawa Fish(6)");
            } else {
                String val = app.prev.get("14");
                FifteenthSubString = val.substring(0, val.indexOf("n")).trim();

                if (Integer.parseInt(FifteenthSubString) != parseFifteen) {
                    app.prev.remove("14");
                    app.prev.put("14", "600 naira Sawa Fish(6)");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(FifteenthSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseFifteen;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }
        }

        if (price.contentEquals("100 naira Panla Fish")) {
            SixteenString = button.getText().toString();
            SixteenthSubString = SixteenString.substring(SixteenString.indexOf(""), SixteenString.indexOf(" "));
            parseSixteen = Integer.parseInt(SixteenthSubString);
            if (!app.prev.containsKey("15")) {
                app.allinfoodcounter = app.allinfoodcounter + parseSixteen;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("15", "100 naira Panla Fish");
            } else {
                String val = app.prev.get("15");
                SixteenthSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                if (Integer.parseInt(SixteenthSubString) != parseSixteen) {
                    app.prev.remove("15");
                    app.prev.put("15", "100 naira Panla Fish");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(SixteenthSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseSixteen;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }

            } else if (price.contentEquals("200 naira Panla Fish(2)")) {
            SixteenString = button2.getText().toString();
            SixteenthSubString = SixteenString.substring(SixteenString.indexOf(""), SixteenString.indexOf(" "));
            parseSixteen = Integer.parseInt(SixteenthSubString);
            if (!app.prev.containsKey("15")) {
                app.allinfoodcounter = app.allinfoodcounter + parseSixteen;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("15", "200 naira Panla Fish(2)");
            } else {
                String val = app.prev.get("15");
                SixteenthSubString = val.substring(0, val.indexOf("n")).trim();

                if (Integer.parseInt(SixteenthSubString) != parseSixteen) {
                    app.prev.remove("15");
                    app.prev.put("15", "200 naira Panla Fish(2)");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(SixteenthSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseSixteen;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }

        } else if (price.contentEquals("300 naira Panla Fish(3)")) {
            SixteenString = button3.getText().toString();
            SixteenthSubString = SixteenString.substring(SixteenString.indexOf(""), SixteenString.indexOf(" "));
            parseSixteen = Integer.parseInt(SixteenthSubString);
            if (!app.prev.containsKey("15")) {
                app.allinfoodcounter = app.allinfoodcounter + parseSixteen;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("15", "300 naira Panla Fish(3)");
            } else {
                String val = app.prev.get("15");
                SixteenthSubString = val.substring(0, val.indexOf("n")).trim();

                if (Integer.parseInt(SixteenthSubString) != parseSixteen) {
                    app.prev.remove("15");
                    app.prev.put("15", "300 naira Panla Fish(3)");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(SixteenthSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseSixteen;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }

        } else if (price.contentEquals("400 naira Panla Fish(4)")) {
            SixteenString = button4.getText().toString();
            SixteenthSubString = SixteenString.substring(SixteenString.indexOf(""), SixteenString.indexOf(" "));
            parseSixteen = Integer.parseInt(SixteenthSubString);
            if (!app.prev.containsKey("15")) {
                app.allinfoodcounter = app.allinfoodcounter + parseSixteen;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("15", "400 naira Panla Fish(4)");
            } else {
                String val = app.prev.get("15");
                SixteenthSubString = val.substring(0, val.indexOf("n")).trim();

                if (Integer.parseInt(SixteenthSubString) != parseSixteen) {
                    app.prev.remove("15");
                    app.prev.put("15", "400 naira Panla Fish(4)");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(SixteenthSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseSixteen;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }

        } else if (price.contentEquals("500 naira Panla Fish(5)")) {
            SixteenString = button5.getText().toString();
            SixteenthSubString = SixteenString.substring(SixteenString.indexOf(""), SixteenString.indexOf(" "));
            parseSixteen = Integer.parseInt(SixteenthSubString);
            if (!app.prev.containsKey("15")) {
                app.allinfoodcounter = app.allinfoodcounter + parseSixteen;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("15", "500 naira Panla Fish(5)");
            } else {
                String val = app.prev.get("15");
                SixteenthSubString = val.substring(0, val.indexOf("n")).trim();

                if (Integer.parseInt(SixteenthSubString) != parseSixteen) {
                    app.prev.remove("15");
                    app.prev.put("15", "500 naira Panla Fish(5)");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(SixteenthSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseSixteen;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }

        }
        else if (price.contentEquals("600 naira Panla Fish(6)")) {
            SixteenString = button6.getText().toString();
            SixteenthSubString = SixteenString.substring(SixteenString.indexOf(""), SixteenString.indexOf(" "));
            parseSixteen = Integer.parseInt(SixteenthSubString);
            if (!app.prev.containsKey("15")) {
                app.allinfoodcounter = app.allinfoodcounter + parseSixteen;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("15", "600 naira Panla Fish(6)");
            } else {
                String val = app.prev.get("15");
                SixteenthSubString = val.substring(0, val.indexOf("n")).trim();

                if (Integer.parseInt(SixteenthSubString) != parseSixteen) {
                    app.prev.remove("15");
                    app.prev.put("15", "600 naira Panla Fish(6)");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(SixteenthSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseSixteen;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }
        }

        if (price.contentEquals("100 naira MoiMoi")) {
            SeventeenString = button.getText().toString();
            SeventeenthSubString = SeventeenString.substring(SeventeenString.indexOf(""), SeventeenString.indexOf(" "));
            parseSeventeen = Integer.parseInt(SeventeenthSubString);
            if (!app.prev.containsKey("16")) {
                app.allinfoodcounter = app.allinfoodcounter + parseSeventeen;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("16", "100 naira MoiMoi");
            } else {
                String val = app.prev.get("16");
                SeventeenthSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                if (Integer.parseInt(SeventeenthSubString) != parseSeventeen) {
                    app.prev.remove("16");
                    app.prev.put("16", "100 naira MoiMoi");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(SeventeenthSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseSeventeen;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }

        } else if (price.contentEquals("200 naira MoiMoi(2)")) {
            SeventeenString = button2.getText().toString();
            SeventeenthSubString = SeventeenString.substring(SeventeenString.indexOf(""), SeventeenString.indexOf(" "));
            parseSeventeen = Integer.parseInt(SeventeenthSubString);
            if (!app.prev.containsKey("16")) {
                app.allinfoodcounter = app.allinfoodcounter + parseSeventeen;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("16", "200 naira MoiMoi(2)");
            } else {
                String val = app.prev.get("16");
                SeventeenthSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                if (Integer.parseInt(SeventeenthSubString) != parseSeventeen) {
                    app.prev.remove("16");
                    app.prev.put("16", "200 naira MoiMoi(2)");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(SeventeenthSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseSeventeen;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }

        } else if (price.contentEquals("300 naira MoiMoi(3)")) {
            SeventeenString = button3.getText().toString();
            SeventeenthSubString = SeventeenString.substring(SeventeenString.indexOf(""), SeventeenString.indexOf(" "));
            parseSeventeen = Integer.parseInt(SeventeenthSubString);
            if (!app.prev.containsKey("16")) {
                app.allinfoodcounter = app.allinfoodcounter + parseSeventeen;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("16", "300 naira MoiMoi(3)");
            } else {
                String val = app.prev.get("16");
                SeventeenthSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                if (Integer.parseInt(SeventeenthSubString) != parseSeventeen) {
                    app.prev.remove("16");
                    app.prev.put("16", "300 naira MoiMoi(3)");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(SeventeenthSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseSeventeen;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }

        } else if (price.contentEquals("400 naira MoiMoi(4)")) {
            SeventeenString = button4.getText().toString();
            SeventeenthSubString = SeventeenString.substring(SeventeenString.indexOf(""), SeventeenString.indexOf(" "));
            parseSeventeen = Integer.parseInt(SeventeenthSubString);
            if (!app.prev.containsKey("16")) {
                app.allinfoodcounter = app.allinfoodcounter + parseSeventeen;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("16", "400 naira MoiMoi(4)");
            } else {
                String val = app.prev.get("16");
                SeventeenthSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                if (Integer.parseInt(SeventeenthSubString) != parseSeventeen) {
                    app.prev.remove("16");
                    app.prev.put("16", "400 naira MoiMoi(4)");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(SeventeenthSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseSeventeen;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }

        } else if (price.contentEquals("500 naira MoiMoi(5)")) {
            SeventeenString = button5.getText().toString();
            SeventeenthSubString = SeventeenString.substring(SeventeenString.indexOf(""), SeventeenString.indexOf(" "));
            parseSeventeen = Integer.parseInt(SeventeenthSubString);
            if (!app.prev.containsKey("16")) {
                app.allinfoodcounter = app.allinfoodcounter + parseSeventeen;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("16", "500 naira MoiMoi(5)");
            } else {
                String val = app.prev.get("16");
                SeventeenthSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                if (Integer.parseInt(SeventeenthSubString) != parseSeventeen) {
                    app.prev.remove("16");
                    app.prev.put("16", "500 naira MoiMoi(5)");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(SeventeenthSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseSeventeen;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }

        }
        else if (price.contentEquals("600 naira MoiMoi(6)")) {
            SeventeenString = button6.getText().toString();
            SeventeenthSubString = SeventeenString.substring(SeventeenString.indexOf(""), SeventeenString.indexOf(" "));
            parseSeventeen = Integer.parseInt(SeventeenthSubString);
            if (!app.prev.containsKey("16")) {
                app.allinfoodcounter = app.allinfoodcounter + parseSeventeen;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("16", "600 naira MoiMoi(6)");
            } else {
                String val = app.prev.get("16");
                SeventeenthSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                if (Integer.parseInt(SeventeenthSubString) != parseSeventeen) {
                    app.prev.remove("16");
                    app.prev.put("16", "600 naira MoiMoi(6)");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(SeventeenthSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseSeventeen;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }
        }

        if (price.contentEquals("50 naira Plantain")) {
            EighteenString = button.getText().toString();
            EighteenthSubString = EighteenString.substring(EighteenString.indexOf(""), EighteenString.indexOf(" "));
            parseEighteen = Integer.parseInt(EighteenthSubString);
            if (!app.prev.containsKey("17")) {
                app.allinfoodcounter = app.allinfoodcounter + parseEighteen;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("17", "50 naira Plantain");
            } else {
                String val = app.prev.get("17");
                EighteenthSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                if (Integer.parseInt(EighteenthSubString) != parseEighteen) {
                    app.prev.remove("17");
                    app.prev.put("17", "50 naira Plantain");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(EighteenthSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseEighteen;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }

        } else if (price.contentEquals("100 naira Plantain")) {
            EighteenString = button2.getText().toString();
            EighteenthSubString = EighteenString.substring(EighteenString.indexOf(""), EighteenString.indexOf(" "));
            parseEighteen = Integer.parseInt(EighteenthSubString);
            if (!app.prev.containsKey("17")) {
                app.allinfoodcounter = app.allinfoodcounter + parseEighteen;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("17", "100 naira Plantain");
            } else {
                String val = app.prev.get("17");
                EighteenthSubString = val.substring(0, val.indexOf("n")).trim();

                if (Integer.parseInt(EighteenthSubString) != parseEighteen) {
                    app.prev.remove("17");
                    app.prev.put("17", "100 naira Plantain");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(EighteenthSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseEighteen;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }

        } else if (price.contentEquals("150 naira Plantain")) {
            EighteenString = button3.getText().toString();
            EighteenthSubString = EighteenString.substring(EighteenString.indexOf(""), EighteenString.indexOf(" "));
            parseEighteen = Integer.parseInt(EighteenthSubString);
            if (!app.prev.containsKey("17")) {
                app.allinfoodcounter = app.allinfoodcounter + parseEighteen;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("17", "150 naira Plantain");
            } else {
                String val = app.prev.get("17");
                EighteenthSubString = val.substring(0, val.indexOf("n")).trim();

                if (Integer.parseInt(EighteenthSubString) != parseEighteen) {
                    app.prev.remove("17");
                    app.prev.put("17", "150 naira Plantain");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(EighteenthSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseEighteen;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }

        } else if (price.contentEquals("200 naira Plantain")) {
            EighteenString = button4.getText().toString();
            EighteenthSubString = EighteenString.substring(EighteenString.indexOf(""), EighteenString.indexOf(" "));
            parseEighteen = Integer.parseInt(EighteenthSubString);
            if (!app.prev.containsKey("17")) {
                app.allinfoodcounter = app.allinfoodcounter + parseEighteen;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("17", "200 naira Plantain");
            } else {
                String val = app.prev.get("17");
                EighteenthSubString = val.substring(0, val.indexOf("n")).trim();

                if (Integer.parseInt(EighteenthSubString) != parseEighteen) {
                    app.prev.remove("17");
                    app.prev.put("17", "200 naira Plantain");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(EighteenthSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseEighteen;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }

        } else if (price.contentEquals("250 naira Plantain")) {
            EighteenString = button5.getText().toString();
            EighteenthSubString = EighteenString.substring(EighteenString.indexOf(""), EighteenString.indexOf(" "));
            parseEighteen = Integer.parseInt(EighteenthSubString);
            if (!app.prev.containsKey("17")) {
                app.allinfoodcounter = app.allinfoodcounter + parseEighteen;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("17", "250 naira Plantain");
            } else {
                String val = app.prev.get("17");
                EighteenthSubString = val.substring(0, val.indexOf("n")).trim();

                if (Integer.parseInt(EighteenthSubString) != parseEighteen) {
                    app.prev.remove("17");
                    app.prev.put("17", "250 naira Plantain");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(EighteenthSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseEighteen;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }

        }
        else if (price.contentEquals("300 naira Plantain")) {
            EighteenString = button6.getText().toString();
            EighteenthSubString = EighteenString.substring(EighteenString.indexOf(""), EighteenString.indexOf(" "));
            parseEighteen = Integer.parseInt(EighteenthSubString);
            if (!app.prev.containsKey("17")) {
                app.allinfoodcounter = app.allinfoodcounter + parseEighteen;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("17", "300 naira Plantain");
            } else {
                String val = app.prev.get("17");
                EighteenthSubString = val.substring(0, val.indexOf("n")).trim();

                if (Integer.parseInt(EighteenthSubString) != parseEighteen) {
                    app.prev.remove("17");
                    app.prev.put("17", "300 naira Plantain");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(EighteenthSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseEighteen;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }
        }

        if (price.contentEquals("50 naira Boiled Egg")) {
            NineteenString = button.getText().toString();
            NineteenthSubString = NineteenString.substring(NineteenString.indexOf(""), NineteenString.indexOf(" "));
            parseNineteen = Integer.parseInt(NineteenthSubString);
            if (!app.prev.containsKey("18")) {
                app.allinfoodcounter = app.allinfoodcounter + parseNineteen;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("18", "50 naira Boiled Egg");
            } else {
                String val = app.prev.get("18");
                NineteenthSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                if (Integer.parseInt(NineteenthSubString) != parseNineteen) {
                    app.prev.remove("18");
                    app.prev.put("18", "50 naira Boiled Egg");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(NineteenthSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseNineteen;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }

        } else if (price.contentEquals("100 naira Boiled Egg(2)")) {
            NineteenString = button2.getText().toString();
            NineteenthSubString = NineteenString.substring(NineteenString.indexOf(""), NineteenString.indexOf(" "));
            parseNineteen = Integer.parseInt(NineteenthSubString);
            if (!app.prev.containsKey("18")) {
                app.allinfoodcounter = app.allinfoodcounter + parseNineteen;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("18", "100 naira Boiled Egg(2)");
            } else {
                String val = app.prev.get("18");
                NineteenthSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                if (Integer.parseInt(NineteenthSubString) != parseNineteen) {
                    app.prev.remove("18");
                    app.prev.put("18", "100 naira Boiled Egg(2)");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(NineteenthSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseNineteen;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }

        } else if (price.contentEquals("150 naira Boiled Egg(3)")) {
            NineteenString = button3.getText().toString();
            NineteenthSubString = NineteenString.substring(NineteenString.indexOf(""), NineteenString.indexOf(" "));
            parseNineteen = Integer.parseInt(NineteenthSubString);
            if (!app.prev.containsKey("18")) {
                app.allinfoodcounter = app.allinfoodcounter + parseNineteen;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("18", "150 naira Boiled Egg(3)");
            } else {
                String val = app.prev.get("18");
                NineteenthSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                if (Integer.parseInt(NineteenthSubString) != parseNineteen) {
                    app.prev.remove("18");
                    app.prev.put("18", "150 naira Boiled Egg(3)");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(NineteenthSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseNineteen;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }

        } else if (price.contentEquals("200 naira Boiled Egg(4)")) {
            NineteenString = button4.getText().toString();
            NineteenthSubString = NineteenString.substring(NineteenString.indexOf(""), NineteenString.indexOf(" "));
            parseNineteen = Integer.parseInt(NineteenthSubString);
            if (!app.prev.containsKey("18")) {
                app.allinfoodcounter = app.allinfoodcounter + parseNineteen;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("18", "200 naira Boiled Egg(4)");
            } else {
                String val = app.prev.get("18");
                NineteenthSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                if (Integer.parseInt(NineteenthSubString) != parseNineteen) {
                    app.prev.remove("18");
                    app.prev.put("18", "200 naira Boiled Egg(4)");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(NineteenthSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseNineteen;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }

        } else if (price.contentEquals("250 naira Boiled Egg(5)")) {
            NineteenString = button5.getText().toString();
            NineteenthSubString = NineteenString.substring(NineteenString.indexOf(""), NineteenString.indexOf(" "));
            parseNineteen = Integer.parseInt(NineteenthSubString);
            if (!app.prev.containsKey("18")) {
                app.allinfoodcounter = app.allinfoodcounter + parseNineteen;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("18", "250 naira Boiled Egg(5)");
            } else {
                String val = app.prev.get("18");
                NineteenthSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                if (Integer.parseInt(NineteenthSubString) != parseNineteen) {
                    app.prev.remove("18");
                    app.prev.put("18", "250 naira Boiled Egg(5)");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(NineteenthSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseNineteen;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }

        }
        else if (price.contentEquals("300 naira Boiled Egg(6)")) {
            NineteenString = button6.getText().toString();
            NineteenthSubString = NineteenString.substring(NineteenString.indexOf(""), NineteenString.indexOf(" "));
            parseNineteen = Integer.parseInt(NineteenthSubString);
            if (!app.prev.containsKey("18")) {
                app.allinfoodcounter = app.allinfoodcounter + parseNineteen;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("18", "300 naira Boiled Egg(6)");
            } else {
                String val = app.prev.get("18");
                NineteenthSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                if (Integer.parseInt(NineteenthSubString) != parseNineteen) {
                    app.prev.remove("18");
                    app.prev.put("18", "300 naira Boiled Egg(6)");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(NineteenthSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseNineteen;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }
        }

        if (price.contentEquals("100 naira Coleslaw")) {
            TwentyString = button.getText().toString();
            TwentiethSubString = TwentyString.substring(TwentyString.indexOf(""), TwentyString.indexOf(" "));
            parseTwenty = Integer.parseInt(TwentiethSubString);
            if (!app.prev.containsKey("19")) {
                app.allinfoodcounter = app.allinfoodcounter + parseTwenty;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("19", "100 naira Coleslaw");
            } else {
                String val = app.prev.get("19");
                TwentiethSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                if (Integer.parseInt(TwentiethSubString) != parseTwenty) {
                    app.prev.remove("19");
                    app.prev.put("19", "100 naira Coleslaw");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(TwentiethSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseTwenty;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }

        } else if (price.contentEquals("150 naira Coleslaw")) {
            TwentyString = button2.getText().toString();
            TwentiethSubString = TwentyString.substring(TwentyString.indexOf(""), TwentyString.indexOf(" "));
            parseTwenty = Integer.parseInt(TwentiethSubString);
            if (!app.prev.containsKey("19")) {
                app.allinfoodcounter = app.allinfoodcounter + parseTwenty;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("19", "150 naira Coleslaw");
            } else {
                String val = app.prev.get("19");
                TwentiethSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                if (Integer.parseInt(TwentiethSubString) != parseTwenty) {
                    app.prev.remove("19");
                    app.prev.put("19", "150 naira Coleslaw");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(TwentiethSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseTwenty;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }

        } else if (price.contentEquals("200 naira Coleslaw")) {
            TwentyString = button3.getText().toString();
            TwentiethSubString = TwentyString.substring(TwentyString.indexOf(""), TwentyString.indexOf(" "));
            parseTwenty = Integer.parseInt(TwentiethSubString);
            if (!app.prev.containsKey("19")) {
                app.allinfoodcounter = app.allinfoodcounter + parseTwenty;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("19", "200 naira Coleslaw");
            } else {
                String val = app.prev.get("19");
                TwentiethSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                if (Integer.parseInt(TwentiethSubString) != parseTwenty) {
                    app.prev.remove("19");
                    app.prev.put("19", "200 naira Coleslaw");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(TwentiethSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseTwenty;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }

        } else if (price.contentEquals("250 naira Coleslaw")) {
            TwentyString = button4.getText().toString();
            TwentiethSubString = TwentyString.substring(TwentyString.indexOf(""), TwentyString.indexOf(" "));
            parseTwenty = Integer.parseInt(TwentiethSubString);
            if (!app.prev.containsKey("19")) {
                app.allinfoodcounter = app.allinfoodcounter + parseTwenty;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("19", "250 naira Coleslaw");
            } else {
                String val = app.prev.get("19");
                TwentiethSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                if (Integer.parseInt(TwentiethSubString) != parseTwenty) {
                    app.prev.remove("19");
                    app.prev.put("19", "250 naira Coleslaw");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(TwentiethSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseTwenty;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }

        } else if (price.contentEquals("300 naira Coleslaw")) {
            TwentyString = button5.getText().toString();
            TwentiethSubString = TwentyString.substring(TwentyString.indexOf(""), TwentyString.indexOf(" "));
            parseTwenty = Integer.parseInt(TwentiethSubString);
            if (!app.prev.containsKey("19")) {
                app.allinfoodcounter = app.allinfoodcounter + parseTwenty;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("19", "300 naira Coleslaw");
            } else {
                String val = app.prev.get("19");
                TwentiethSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                if (Integer.parseInt(TwentiethSubString) != parseTwenty) {
                    app.prev.remove("19");
                    app.prev.put("19", "300 naira Coleslaw");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(TwentiethSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseTwenty;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }

        }
        else if (price.contentEquals("350 naira Coleslaw")) {
            TwentyString = button6.getText().toString();
            TwentiethSubString = TwentyString.substring(TwentyString.indexOf(""), TwentyString.indexOf(" "));
            parseTwenty = Integer.parseInt(TwentiethSubString);
            if (!app.prev.containsKey("19")) {
                app.allinfoodcounter = app.allinfoodcounter + parseTwenty;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("19", "350 naira Coleslaw");
            } else {
                String val = app.prev.get("19");
                TwentiethSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                if (Integer.parseInt(TwentiethSubString) != parseTwenty) {
                    app.prev.remove("19");
                    app.prev.put("19", "350 naira Coleslaw`");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(TwentiethSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseTwenty;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }
        }


        if (price.contentEquals("100 naira WhiteBeans")) {
            TwentyOneString = button.getText().toString();
            TwentyOneSubString = TwentyOneString.substring(TwentyOneString.indexOf(""), TwentyOneString.indexOf(" "));
            parseTwentyOne = Integer.parseInt(TwentyOneSubString);
            if (!app.prev.containsKey("20")) {
                app.allinfoodcounter = app.allinfoodcounter + parseTwentyOne;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("20", "100 naira WhiteBeans");
            } else {
                String val = app.prev.get("20");
                TwentyOneSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                if (Integer.parseInt(TwentyOneSubString) != parseTwentyOne) {
                    app.prev.remove("20");
                    app.prev.put("20", "100 naira WhiteBeans");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(TwentyOneSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseTwentyOne;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }

        } else if (price.contentEquals("150 naira WhiteBeans")) {
            TwentyOneString = button2.getText().toString();
            TwentyOneSubString = TwentyOneString.substring(TwentyOneString.indexOf(""), TwentyOneString.indexOf(" "));
            parseTwentyOne = Integer.parseInt(TwentyOneSubString);
            if (!app.prev.containsKey("20")) {
                app.allinfoodcounter = app.allinfoodcounter + parseTwentyOne;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("20", "150 naira WhiteBeans");
            } else {
                String val = app.prev.get("20");
                TwentyOneSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                if (Integer.parseInt(TwentyOneSubString) != parseTwentyOne) {
                    app.prev.remove("20");
                    app.prev.put("20", "150 naira WhiteBeans");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(TwentyOneSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseTwentyOne;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }

        } else if (price.contentEquals("200 naira WhiteBeans")) {
            TwentyOneString = button3.getText().toString();
            TwentyOneSubString = TwentyOneString.substring(TwentyOneString.indexOf(""), TwentyOneString.indexOf(" "));
            parseTwentyOne = Integer.parseInt(TwentyOneSubString);
            if (!app.prev.containsKey("20")) {
                app.allinfoodcounter = app.allinfoodcounter + parseTwentyOne;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("20", "200 naira WhiteBeans");
            } else {
                String val = app.prev.get("20");
                TwentyOneSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                if (Integer.parseInt(TwentyOneSubString) != parseTwentyOne) {
                    app.prev.remove("20");
                    app.prev.put("20", "200 naira WhiteBeans");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(TwentyOneSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseTwentyOne;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }

        } else if (price.contentEquals("250 naira WhiteBeans")) {
            TwentyOneString = button4.getText().toString();
            TwentyOneSubString = TwentyOneString.substring(TwentyOneString.indexOf(""), TwentyOneString.indexOf(" "));
            parseTwentyOne = Integer.parseInt(TwentyOneSubString);
            if (!app.prev.containsKey("20")) {
                app.allinfoodcounter = app.allinfoodcounter + parseTwentyOne;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("20", "250 naira WhiteBeans");
            } else {
                String val = app.prev.get("20");
                TwentyOneSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                if (Integer.parseInt(TwentyOneSubString) != parseTwentyOne) {
                    app.prev.remove("20");
                    app.prev.put("20", "250 naira WhiteBeans");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(TwentyOneSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseTwentyOne;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }

        } else if (price.contentEquals("300 naira WhiteBeans")) {
            TwentyOneString = button5.getText().toString();
            TwentyOneSubString = TwentyOneString.substring(TwentyOneString.indexOf(""), TwentyOneString.indexOf(" "));
            parseTwentyOne = Integer.parseInt(TwentyOneSubString);
            if (!app.prev.containsKey("20")) {
                app.allinfoodcounter = app.allinfoodcounter + parseTwentyOne;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("20", "300 naira WhiteBeans");
            } else {
                String val = app.prev.get("20");
                TwentyOneSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                if (Integer.parseInt(TwentyOneSubString) != parseTwentyOne) {
                    app.prev.remove("20");
                    app.prev.put("20", "300 naira WhiteBeans");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(TwentyOneSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseTwentyOne;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }

        }
        else if (price.contentEquals("350 naira WhiteBeans")) {
            TwentyOneString = button6.getText().toString();
            TwentyOneSubString = TwentyOneString.substring(TwentyOneString.indexOf(""), TwentyOneString.indexOf(" "));
            parseTwentyOne = Integer.parseInt(TwentyOneSubString);
            if (!app.prev.containsKey("20")) {
                app.allinfoodcounter = app.allinfoodcounter + parseTwentyOne;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("20", "350 naira WhiteBeans");
            } else {
                String val = app.prev.get("20");
                TwentyOneSubString = val.substring(val.indexOf(""), val.indexOf(" "));

                if (Integer.parseInt(TwentyOneSubString) != parseTwentyOne) {
                    app.prev.remove("20");
                    app.prev.put("20", "350 naira WhiteBeans");
                    app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(TwentyOneSubString);
                    app.allinfoodcounter = app.allinfoodcounter + parseTwentyOne;
                    feetag.setText("" + app.allinfoodcounter + "");
                }
            }

        }

    }
}
