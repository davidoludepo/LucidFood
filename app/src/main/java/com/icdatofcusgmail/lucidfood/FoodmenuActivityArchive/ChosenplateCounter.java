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

    public static int parseOne, parseTwo, parseThree, parseFour, parseFive, parseSix, parseSeven, parseEight, parseNine, parseTen;
    public static String FirstSubString, SecondSubString, ThirdSubString, FourthSubString, FifthSubString, SixthSubString, SeventhSubString, EightSubString, NineSubString, TenSubString;

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

        String FirstString, SecondString, ThirdString, FourthString, FifthString, SixthString, SevenString, EightString, NineString, TenString;

        if (price.contentEquals("150 naira White Rice")) {
            FirstString = button.getText().toString();
            FirstSubString = FirstString.substring(FirstString.indexOf(""), FirstString.indexOf(" naira White Rice"));
            parseOne = Integer.parseInt(FirstSubString);
            if (!app.prev.containsKey("0")) {
                app.allinfoodcounter = app.allinfoodcounter + parseOne;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("0", "150 naira White Rice");
            } else {
                String val = app.prev.get("0");
                FirstSubString = val.substring(val.indexOf(""), val.indexOf(" naira White Rice"));

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
            FirstSubString = FirstString.substring(FirstString.indexOf(""), FirstString.indexOf(" naira White Rice"));
            parseOne = Integer.parseInt(FirstSubString);
            if (!app.prev.containsKey("0")) {
                app.allinfoodcounter = app.allinfoodcounter + parseOne;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("0", "200 naira White Rice");
            } else {
                String val = app.prev.get("0");
                FirstSubString = val.substring(val.indexOf(""), val.indexOf(" naira White Rice"));

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
            FirstSubString = FirstString.substring(FirstString.indexOf(""), FirstString.indexOf(" naira White Rice"));
            parseOne = Integer.parseInt(FirstSubString);
            if (!app.prev.containsKey("0")) {
                app.allinfoodcounter = app.allinfoodcounter + parseOne;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("0", "250 naira White Rice");
            } else {
                String val = app.prev.get("0");
                FirstSubString = val.substring(val.indexOf(""), val.indexOf(" naira White Rice"));

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
            FirstSubString = FirstString.substring(FirstString.indexOf(""), FirstString.indexOf(" naira White Rice"));
            parseOne = Integer.parseInt(FirstSubString);
            if (!app.prev.containsKey("0")) {
                app.allinfoodcounter = app.allinfoodcounter + parseOne;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("0", "300 naira White Rice");
            } else {
                String val = app.prev.get("0");
                FirstSubString = val.substring(val.indexOf(""), val.indexOf(" naira White Rice"));

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
            FirstSubString = FirstString.substring(FirstString.indexOf(""), FirstString.indexOf(" naira White Rice"));
            parseOne = Integer.parseInt(FirstSubString);
            if (!app.prev.containsKey("0")) {
                app.allinfoodcounter = app.allinfoodcounter + parseOne;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("0", "350 naira White Rice");
            } else {
                String val = app.prev.get("0");
                FirstSubString = val.substring(val.indexOf(""), val.indexOf(" naira White Rice"));

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
            FirstSubString = FirstString.substring(FirstString.indexOf(""), FirstString.indexOf(" naira White Rice"));
            parseOne = Integer.parseInt(FirstSubString);
            if (!app.prev.containsKey("0")) {
                app.allinfoodcounter = app.allinfoodcounter + parseOne;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("0", "400 naira White Rice");
            } else {
                String val = app.prev.get("0");
                FirstSubString = val.substring(val.indexOf(""), val.indexOf(" naira White Rice"));

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
            SecondSubString = SecondString.substring(SecondString.indexOf(""), SecondString.indexOf(" naira Jollof Rice"));
            parseTwo = Integer.parseInt(SecondSubString);
            if (!app.prev.containsKey("1")) {
                app.allinfoodcounter = app.allinfoodcounter + parseTwo;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("1", "150 naira Jollof Rice");
            } else {
                String val = app.prev.get("1");
                SecondSubString = val.substring(val.indexOf(""), val.indexOf(" naira Jollof Rice"));

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
            SecondSubString = SecondString.substring(SecondString.indexOf(""), SecondString.indexOf(" naira Jollof Rice"));
            parseTwo = Integer.parseInt(SecondSubString);
            if (!app.prev.containsKey("1")) {
                app.allinfoodcounter = app.allinfoodcounter + parseTwo;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("1", "200 naira Jollof Rice");
            } else {
                String val = app.prev.get("1");
                SecondSubString = val.substring(val.indexOf(""), val.indexOf(" naira Jollof Rice"));

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
            SecondSubString = SecondString.substring(SecondString.indexOf(""), SecondString.indexOf(" naira Jollof Rice"));
            parseTwo = Integer.parseInt(SecondSubString);
            if (!app.prev.containsKey("1")) {
                app.allinfoodcounter = app.allinfoodcounter + parseTwo;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("1", "250 naira Jollof Rice");
            } else {
                String val = app.prev.get("1");
                SecondSubString = val.substring(val.indexOf(""), val.indexOf(" naira Jollof Rice"));

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
            SecondSubString = SecondString.substring(SecondString.indexOf(""), SecondString.indexOf(" naira Jollof Rice"));
            parseTwo = Integer.parseInt(SecondSubString);
            if (!app.prev.containsKey("1")) {
                app.allinfoodcounter = app.allinfoodcounter + parseTwo;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("1", "300 naira Jollof Rice");
            } else {
                String val = app.prev.get("1");
                SecondSubString = val.substring(val.indexOf(""), val.indexOf(" naira Jollof Rice"));

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
            SecondSubString = SecondString.substring(SecondString.indexOf(""), SecondString.indexOf(" naira Jollof Rice"));
            parseTwo = Integer.parseInt(SecondSubString);
            if (!app.prev.containsKey("1")) {
                app.allinfoodcounter = app.allinfoodcounter + parseTwo;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("1", "350 naira Jollof Rice");
            } else {
                String val = app.prev.get("1");
                SecondSubString = val.substring(val.indexOf(""), val.indexOf(" naira Jollof Rice"));

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
            SecondSubString = SecondString.substring(SecondString.indexOf(""), SecondString.indexOf(" naira Jollof Rice"));
            parseTwo = Integer.parseInt(SecondSubString);
            if (!app.prev.containsKey("1")) {
                app.allinfoodcounter = app.allinfoodcounter + parseTwo;
                feetag.setText("" + app.allinfoodcounter + "");
                app.prev.put("1", "400 naira Jollof Rice");
            } else {
                String val = app.prev.get("1");
                SecondSubString = val.substring(val.indexOf(""), val.indexOf(" naira Jollof Rice"));

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
                ThirdSubString = ThirdString.substring(ThirdString.indexOf(""), ThirdString.indexOf(" naira Fried Rice"));
                parseThree = Integer.parseInt(ThirdSubString);
                if (!app.prev.containsKey("2")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseThree;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("2", "150 naira Fried Rice");
                } else {
                    String val = app.prev.get("2");
                    ThirdSubString = val.substring(val.indexOf(""), val.indexOf(" naira Fried Rice"));

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
                ThirdSubString = ThirdString.substring(ThirdString.indexOf(""), ThirdString.indexOf(" naira Fried Rice"));
                parseThree = Integer.parseInt(ThirdSubString);
                if (!app.prev.containsKey("2")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseThree;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("2", "200 naira Fried Rice");
                } else {
                    String val = app.prev.get("2");
                    ThirdSubString = val.substring(val.indexOf(""), val.indexOf(" naira Fried Rice"));

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
                ThirdSubString = ThirdString.substring(ThirdString.indexOf(""), ThirdString.indexOf(" naira Fried Rice"));
                parseThree = Integer.parseInt(ThirdSubString);
                if (!app.prev.containsKey("2")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseThree;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("2", "250 naira Fried Rice");
                } else {
                    String val = app.prev.get("2");
                    ThirdSubString = val.substring(val.indexOf(""), val.indexOf(" naira Fried Rice"));

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
                ThirdSubString = ThirdString.substring(ThirdString.indexOf(""), ThirdString.indexOf(" naira Fried Rice"));
                parseThree = Integer.parseInt(ThirdSubString);
                if (!app.prev.containsKey("2")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseThree;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("2", "300 naira Fried Rice");
                } else {
                    String val = app.prev.get("2");
                    ThirdSubString = val.substring(val.indexOf(""), val.indexOf(" naira Fried Rice"));

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
                ThirdSubString = ThirdString.substring(ThirdString.indexOf(""), ThirdString.indexOf(" naira Fried Rice"));
                parseThree = Integer.parseInt(ThirdSubString);
                if (!app.prev.containsKey("2")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseThree;
                    feetag.setText("" + app.allinfoodcounter + "");
                   app.prev.put("2", "350 naira Fried Rice");
                } else {
                    String val = app.prev.get("2");
                    ThirdSubString = val.substring(val.indexOf(""), val.indexOf(" naira Fried Rice"));

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
                ThirdSubString = ThirdString.substring(ThirdString.indexOf(""), ThirdString.indexOf(" naira Fried Rice"));
                parseThree = Integer.parseInt(ThirdSubString);
                if (!app.prev.containsKey("2")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseThree;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("2", "400 naira Fried Rice");
                } else {
                    String val = app.prev.get("2");
                    ThirdSubString = val.substring(val.indexOf(""), val.indexOf(" naira Fried Rice"));

                    if (Integer.parseInt(ThirdSubString) != parseThree) {
                        app.prev.remove("2");
                        app.prev.put("2", "400 naira Fried Rice");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(ThirdSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseThree;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }
            }

            if (price.contentEquals("100 naira Beef")) {
                FourthString = button.getText().toString();
                FourthSubString = FourthString.substring(FourthString.indexOf(""), FourthString.indexOf(" naira Beef"));
                parseFour = Integer.parseInt(FourthSubString);
                if (!app.prev.containsKey("3")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseFour;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("3", "100 naira Beef");
                } else {
                    String val = app.prev.get("3");
                    FourthSubString = val.substring(val.indexOf(""), val.indexOf(" naira Beef"));

                    if (Integer.parseInt(FourthSubString) != parseFour) {
                        app.prev.remove("3");
                        app.prev.put("3", "100 naira Beef");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(FourthSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseFour;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }

            } else if (price.contentEquals("200 naira Beef(2)")) {
                FourthString = button2.getText().toString();
                FourthSubString = FourthString.substring(FourthString.indexOf(""), FourthString.indexOf(" naira Beef(2)"));
                parseFour = Integer.parseInt(FourthSubString);
                if (!app.prev.containsKey("3")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseFour;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("3", "200 naira Beef(2)");
                } else {
                    String val = app.prev.get("3");
                    FourthSubString = val.substring(0, val.indexOf("n")).trim();

                    if (Integer.parseInt(FourthSubString) != parseFour) {
                        app.prev.remove("3");
                        app.prev.put("3", "200 naira Beef(2)");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(FourthSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseFour;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }

            } else if (price.contentEquals("300 naira Beef(3)")) {
                FourthString = button3.getText().toString();
                FourthSubString = FourthString.substring(FourthString.indexOf(""), FourthString.indexOf(" naira Beef(3)"));
                parseFour = Integer.parseInt(FourthSubString);
                if (!app.prev.containsKey("3")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseFour;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("3", "300 naira Beef(3)");
                } else {
                    String val = app.prev.get("3");
                    FourthSubString = val.substring(0, val.indexOf("n")).trim();

                    if (Integer.parseInt(FourthSubString) != parseFour) {
                        app.prev.remove("3");
                        app.prev.put("3", "300 naira Beef(3)");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(FourthSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseFour;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }

            } else if (price.contentEquals("400 naira Beef(4)")) {
                FourthString = button4.getText().toString();
                FourthSubString = FourthString.substring(FourthString.indexOf(""), FourthString.indexOf(" naira Beef(4)"));
                parseFour = Integer.parseInt(FourthSubString);
                if (!app.prev.containsKey("3")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseFour;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("3", "400 naira Beef(4)");
                } else {
                    String val = app.prev.get("3");
                    FourthSubString = val.substring(0, val.indexOf("n")).trim();

                    if (Integer.parseInt(FourthSubString) != parseFour) {
                        app.prev.remove("3");
                        app.prev.put("3", "400 naira Beef(4)");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(FourthSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseFour;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }

            } else if (price.contentEquals("500 naira Beef(5)")) {
                FourthString = button5.getText().toString();
                FourthSubString = FourthString.substring(FourthString.indexOf(""), FourthString.indexOf(" naira Beef(5)"));
                parseFour = Integer.parseInt(FourthSubString);
                if (!app.prev.containsKey("3")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseFour;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("3", "500 naira Beef(5)");
                } else {
                    String val = app.prev.get("3");
                    FourthSubString = val.substring(0, val.indexOf("n")).trim();

                    if (Integer.parseInt(FourthSubString) != parseFour) {
                        app.prev.remove("3");
                        app.prev.put("3", "500 naira Beef(5)");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(FourthSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseFour;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }

            } else if (price.contentEquals("600 naira Beef(6)")) {
                FourthString = button6.getText().toString();
                FourthSubString = FourthString.substring(FourthString.indexOf(""), FourthString.indexOf(" naira Beef(6)"));
                parseFour = Integer.parseInt(FourthSubString);
                if (!app.prev.containsKey("3")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseFour;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("3", "600 naira Beef(6)");
                } else {
                    String val = app.prev.get("3");
                    FourthSubString = val.substring(0, val.indexOf("n")).trim();

                    if (Integer.parseInt(FourthSubString) != parseFour) {
                        app.prev.remove("3");
                        app.prev.put("3", "600 naira Beef(6)");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(FourthSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseFour;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }
            }

            if (price.contentEquals("300 naira Chicken")) {
                FifthString = button.getText().toString();
                FifthSubString = FifthString.substring(FifthString.indexOf(""), FifthString.indexOf(" naira Chicken"));
                parseFive = Integer.parseInt(FifthSubString);
                if (!app.prev.containsKey("4")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseFive;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("4", "300 naira Chicken");
                } else {
                    String val = app.prev.get("4");
                    FifthSubString = val.substring(val.indexOf(""), val.indexOf(" naira Chicken"));

                    if (Integer.parseInt(FifthSubString) != parseFive) {
                        app.prev.remove("4");
                        app.prev.put("4", "300 naira Chicken");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(FifthSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseFive;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }

            } else if (price.contentEquals("600 naira Chicken(2)")) {
                FifthString = button2.getText().toString();
                FifthSubString = FifthString.substring(FifthString.indexOf(""), FifthString.indexOf(" naira Chicken(2)"));
                parseFive = Integer.parseInt(FifthSubString);
                if (!app.prev.containsKey("4")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseFive;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("4", "600 naira Chicken(2)");
                } else {
                    String val = app.prev.get("4");
                    FifthSubString = val.substring(0, val.indexOf("n")).trim();

                    if (Integer.parseInt(FifthSubString) != parseFive) {
                        app.prev.remove("4");
                        app.prev.put("4", "600 naira Chicken(2)");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(FifthSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseFive;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }

            } else if (price.contentEquals("900 naira Chicken(3)")) {
                FifthString = button3.getText().toString();
                FifthSubString = FifthString.substring(FifthString.indexOf(""), FifthString.indexOf(" naira Chicken(3)"));
                parseFive = Integer.parseInt(FifthSubString);
                if (!app.prev.containsKey("4")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseFive;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("4", "900 naira Chicken(3)");
                } else {
                    String val = app.prev.get("4");
                    FifthSubString = val.substring(0, val.indexOf("n")).trim();

                    if (Integer.parseInt(FifthSubString) != parseFive) {
                        app.prev.remove("4");
                        app.prev.put("4", "900 naira Chicken(3)");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(FifthSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseFive;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }

            } else if (price.contentEquals("1200 naira Chicken(4)")) {
                FifthString = button4.getText().toString();
                FifthSubString = FifthString.substring(FifthString.indexOf(""), FifthString.indexOf(" naira Chicken(4)"));
                parseFive = Integer.parseInt(FifthSubString);
                if (!app.prev.containsKey("4")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseFive;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("4", "1200 naira Chicken(4)");
                } else {
                    String val = app.prev.get("4");
                    FifthSubString = val.substring(0, val.indexOf("n")).trim();

                    if (Integer.parseInt(FifthSubString) != parseFive) {
                        app.prev.remove("4");
                        app.prev.put("4", "1200 naira Chicken(4)");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(FifthSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseFive;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }

            } else if (price.contentEquals("1500 naira Chicken(5)")) {
                FifthString = button5.getText().toString();
                FifthSubString = FifthString.substring(FifthString.indexOf(""), FifthString.indexOf(" naira Chicken(5)"));
                parseFive = Integer.parseInt(FifthSubString);
                if (!app.prev.containsKey("4")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseFive;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("4", "1500 naira Chicken(5)");
                } else {
                    String val = app.prev.get("4");
                    FifthSubString = val.substring(0, val.indexOf("n")).trim();

                    if (Integer.parseInt(FifthSubString) != parseFive) {
                        app.prev.remove("4");
                        app.prev.put("4", "1500 naira Chicken(5)");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(FifthSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseFive;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }

            } else if (price.contentEquals("1800 naira Chicken(6)")) {
                FifthString = button6.getText().toString();
                FifthSubString = FifthString.substring(FifthString.indexOf(""), FifthString.indexOf(" naira Chicken(6)"));
                parseFive = Integer.parseInt(FifthSubString);
                if (!app.prev.containsKey("4")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseFive;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("4", "1800 naira Chicken(6)");
                } else {
                    String val = app.prev.get("4");
                    FifthSubString = val.substring(0, val.indexOf("n")).trim();

                    if (Integer.parseInt(FifthSubString) != parseFive) {
                        app.prev.remove("4");
                        app.prev.put("4", "1800 naira Chicken(6)");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(FifthSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseFive;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }
            }

            if (price.contentEquals("100 naira MoiMoi")) {
                SixthString = button.getText().toString();
                SixthSubString = SixthString.substring(SixthString.indexOf(""), SixthString.indexOf(" naira MoiMoi"));
                parseSix = Integer.parseInt(SixthSubString);
                if (!app.prev.containsKey("5")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseSix;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("5", "100 naira MoiMoi");
                } else {
                    String val = app.prev.get("5");
                    SixthSubString = val.substring(val.indexOf(""), val.indexOf(" naira MoiMoi"));

                    if (Integer.parseInt(SixthSubString) != parseSix) {
                        app.prev.remove("5");
                        app.prev.put("5", "100 naira MoiMoi");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(SixthSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseSix;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }

            } else if (price.contentEquals("200 naira MoiMoi(2)")) {
                SixthString = button2.getText().toString();
                SixthSubString = SixthString.substring(SixthString.indexOf(""), SixthString.indexOf(" naira MoiMoi(2)"));
                parseSix = Integer.parseInt(SixthSubString);
                if (!app.prev.containsKey("5")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseSix;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("5", "200 naira MoiMoi(2)");
                } else {
                    String val = app.prev.get("5");
                    SixthSubString = val.substring(0, val.indexOf("n")).trim();

                    if (Integer.parseInt(SixthSubString) != parseSix) {
                        app.prev.remove("5");
                        app.prev.put("5", "200 naira MoiMoi(2)");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(SixthSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseSix;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }

            } else if (price.contentEquals("300 naira MoiMoi(3)")) {
                SixthString = button3.getText().toString();
                SixthSubString = SixthString.substring(SixthString.indexOf(""), SixthString.indexOf(" naira MoiMoi(3)"));
                parseSix = Integer.parseInt(SixthSubString);
                if (!app.prev.containsKey("5")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseSix;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("5", "300 naira MoiMoi(3)");
                } else {
                    String val = app.prev.get("5");
                    SixthSubString = val.substring(0, val.indexOf("n")).trim();

                    if (Integer.parseInt(SixthSubString) != parseSix) {
                        app.prev.remove("5");
                        app.prev.put("5", "300 naira MoiMoi(3)");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(SixthSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseSix;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }

            } else if (price.contentEquals("400 naira MoiMoi(4)")) {
                SixthString = button4.getText().toString();
                SixthSubString = SixthString.substring(SixthString.indexOf(""), SixthString.indexOf(" naira MoiMoi(4)"));
                parseSix = Integer.parseInt(SixthSubString);
                if (!app.prev.containsKey("5")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseSix;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("5", "400 naira MoiMoi(4)");
                } else {
                    String val = app.prev.get("5");
                    SixthSubString = val.substring(0, val.indexOf("n")).trim();

                    if (Integer.parseInt(SixthSubString) != parseSix) {
                        app.prev.remove("5");
                        app.prev.put("5", "400 naira MoiMoi(4)");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(SixthSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseSix;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }

            } else if (price.contentEquals("500 naira MoiMoi(5)")) {
                SixthString = button5.getText().toString();
                SixthSubString = SixthString.substring(SixthString.indexOf(""), SixthString.indexOf(" naira MoiMoi(5)"));
                parseSix = Integer.parseInt(SixthSubString);
                if (!app.prev.containsKey("5")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseSix;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("5", "500 naira MoiMoi(5)");
                } else {
                    String val = app.prev.get("5");
                    SixthSubString = val.substring(0, val.indexOf("n")).trim();

                    if (Integer.parseInt(SixthSubString) != parseSix) {
                        app.prev.remove("5");
                        app.prev.put("5", "500 naira MoiMoi(5)");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(SixthSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseSix;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }

            } else if (price.contentEquals("600 naira MoiMoi(6)")) {
                SixthString = button6.getText().toString();
                SixthSubString = SixthString.substring(SixthString.indexOf(""), SixthString.indexOf(" naira MoiMoi(6)"));
                parseSix = Integer.parseInt(SixthSubString);
                if (!app.prev.containsKey("5")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseSix;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("5", "600 naira MoiMoi(6)");
                } else {
                    String val = app.prev.get("5");
                    SixthSubString = val.substring(0, val.indexOf("n")).trim();

                    if (Integer.parseInt(SixthSubString) != parseSix) {
                        app.prev.remove("5");
                        app.prev.put("5", "600 naira MoiMoi(6)");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(SixthSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseSix;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }
            }

            if (price.contentEquals("50 naira Plantain")) {
                SevenString = button.getText().toString();
                SeventhSubString = SevenString.substring(SevenString.indexOf(""), SevenString.indexOf(" naira Plantain"));
                parseSeven = Integer.parseInt(SeventhSubString);
                if (!app.prev.containsKey("6")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseSeven;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("6", "50 naira Plantain");
                } else {
                    String val = app.prev.get("6");
                    SeventhSubString = val.substring(val.indexOf(""), val.indexOf(" naira Plantain"));

                    if (Integer.parseInt(SeventhSubString) != parseSeven) {
                        app.prev.remove("6");
                        app.prev.put("6", "50 naira Plantain");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(SeventhSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseSeven;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }

            } else if (price.contentEquals("100 naira Plantain")) {
                SevenString = button2.getText().toString();
                SeventhSubString = SevenString.substring(SevenString.indexOf(""), SevenString.indexOf(" naira Plantain"));
                parseSeven = Integer.parseInt(SeventhSubString);
                if (!app.prev.containsKey("6")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseSeven;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("6", "100 naira Plantain");
                } else {
                    String val = app.prev.get("6");
                    SeventhSubString = val.substring(val.indexOf(""), val.indexOf(" naira Plantain"));

                    if (Integer.parseInt(SeventhSubString) != parseSeven) {
                        app.prev.remove("6");
                        app.prev.put("6", "100 naira Plantain");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(SeventhSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseSeven;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }

            } else if (price.contentEquals("150 naira Plantain")) {
                SevenString = button3.getText().toString();
                SeventhSubString = SevenString.substring(SevenString.indexOf(""), SevenString.indexOf(" naira Plantain"));
                parseSeven = Integer.parseInt(SeventhSubString);
                if (!app.prev.containsKey("6")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseSeven;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("6", "150 naira Plantain");
                } else {
                    String val = app.prev.get("6");
                    SeventhSubString = val.substring(val.indexOf(""), val.indexOf(" naira Plantain"));

                    if (Integer.parseInt(SeventhSubString) != parseSeven) {
                        app.prev.remove("6");
                        app.prev.put("6", "150 naira Plantain");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(SeventhSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseSeven;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }

            } else if (price.contentEquals("200 naira Plantain")) {
                SevenString = button4.getText().toString();
                SeventhSubString = SevenString.substring(SevenString.indexOf(""), SevenString.indexOf(" naira Plantain"));
                parseSeven = Integer.parseInt(SeventhSubString);
                if (!app.prev.containsKey("6")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseSeven;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("6", "200 naira Plantain");
                } else {
                    String val = app.prev.get("6");
                    SeventhSubString = val.substring(val.indexOf(""), val.indexOf(" naira Plantain"));

                    if (Integer.parseInt(SeventhSubString) != parseSeven) {
                        app.prev.remove("6");
                        app.prev.put("6", "200 naira Plantain");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(SeventhSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseSeven;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }

            } else if (price.contentEquals("250 naira Plantain")) {
                SevenString = button5.getText().toString();
                SeventhSubString = SevenString.substring(SevenString.indexOf(""), SevenString.indexOf(" naira Plantain"));
                parseSeven = Integer.parseInt(SeventhSubString);
                if (!app.prev.containsKey("6")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseSeven;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("6", "250 naira Plantain");
                } else {
                    String val = app.prev.get("6");
                    SeventhSubString = val.substring(val.indexOf(""), val.indexOf(" naira Plantain"));

                    if (Integer.parseInt(SeventhSubString) != parseSeven) {
                        app.prev.remove("6");
                        app.prev.put("6", "250 naira Plantain");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(SeventhSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseSeven;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }

            } else if (price.contentEquals("300 naira Plantain")) {
                SevenString = button6.getText().toString();
                SeventhSubString = SevenString.substring(SevenString.indexOf(""), SevenString.indexOf(" naira Plantain"));
                parseSeven = Integer.parseInt(SeventhSubString);
                if (!app.prev.containsKey("6")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseSeven;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("6", "300 naira Plantain");
                } else {
                    String val = app.prev.get("6");
                    SeventhSubString = val.substring(val.indexOf(""), val.indexOf(" naira Plantain"));

                    if (Integer.parseInt(SeventhSubString) != parseSeven) {
                        app.prev.remove("6");
                        app.prev.put("6", "300 naira Plantain");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(SeventhSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseSeven;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }
            }

            if (price.contentEquals("50 naira Egg")) {
                EightString = button.getText().toString();
                EightSubString = EightString.substring(EightString.indexOf(""), EightString.indexOf(" naira Egg"));
                parseEight = Integer.parseInt(EightSubString);
                if (!app.prev.containsKey("7")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseEight;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("7", "50 naira Egg");
                } else {
                    String val = app.prev.get("7");
                    EightSubString = val.substring(val.indexOf(""), val.indexOf(" naira Egg"));

                    if (Integer.parseInt(EightSubString) != parseEight) {
                        app.prev.remove("7");
                        app.prev.put("7", "50 naira Egg");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(EightSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseEight;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }

            } else if (price.contentEquals("100 naira Egg(2)")) {
                EightString = button2.getText().toString();
                EightSubString = EightString.substring(EightString.indexOf(""), EightString.indexOf(" naira Egg(2)"));
                parseEight = Integer.parseInt(EightSubString);
                if (!app.prev.containsKey("7")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseEight;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("7", "100 naira Egg(2)");
                } else {
                    String val = app.prev.get("7");
                    EightSubString = val.substring(0, val.indexOf("n")).trim();

                    if (Integer.parseInt(EightSubString) != parseEight) {
                        app.prev.remove("7");
                        app.prev.put("7", "100 naira Egg(2)");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(EightSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseEight;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }

            } else if (price.contentEquals("150 naira Egg(3)")) {
                EightString = button3.getText().toString();
                EightSubString = EightString.substring(EightString.indexOf(""), EightString.indexOf(" naira Egg(3)"));
                parseEight = Integer.parseInt(EightSubString);
                if (!app.prev.containsKey("7")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseEight;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("7", "150 naira Egg(3)");
                } else {
                    String val = app.prev.get("7");
                    EightSubString = val.substring(0, val.indexOf("n")).trim();

                    if (Integer.parseInt(EightSubString) != parseEight) {
                        app.prev.remove("7");
                        app.prev.put("7", "150 naira Egg(3)");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(EightSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseEight;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }

            } else if (price.contentEquals("200 naira Egg(4)")) {
                EightString = button4.getText().toString();
                EightSubString = EightString.substring(EightString.indexOf(""), EightString.indexOf(" naira Egg(4)"));
                parseEight = Integer.parseInt(EightSubString);
                if (!app.prev.containsKey("7")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseEight;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("7", "200 naira Egg(4)");
                } else {
                    String val = app.prev.get("7");
                    EightSubString = val.substring(0, val.indexOf("n")).trim();

                    if (Integer.parseInt(EightSubString) != parseEight) {
                        app.prev.remove("7");
                        app.prev.put("7", "200 naira Egg(4)");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(EightSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseEight;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }

            } else if (price.contentEquals("250 naira Egg(5)")) {
                EightString = button5.getText().toString();
                EightSubString = EightString.substring(EightString.indexOf(""), EightString.indexOf(" naira Egg(5)"));
                parseEight = Integer.parseInt(EightSubString);
                if (!app.prev.containsKey("7")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseEight;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("7", "250 naira Egg(5)");
                } else {
                    String val = app.prev.get("7");
                    EightSubString = val.substring(0, val.indexOf("n")).trim();

                    if (Integer.parseInt(EightSubString) != parseEight) {
                        app.prev.remove("7");
                        app.prev.put("7", "250 naira Egg(5)");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(EightSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseEight;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }

            } else if (price.contentEquals("300 naira Egg(6)")) {
                EightString = button6.getText().toString();
                EightSubString = EightString.substring(EightString.indexOf(""), EightString.indexOf(" naira Egg(6)"));
                parseEight = Integer.parseInt(EightSubString);
                if (!app.prev.containsKey("7")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseEight;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("7", "300 naira Egg(6)");
                } else {
                    String val = app.prev.get("7");
                    EightSubString = val.substring(0, val.indexOf("n")).trim();

                    if (Integer.parseInt(EightSubString) != parseEight) {
                        app.prev.remove("7");
                        app.prev.put("7", "300 naira Egg(6)");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(EightSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseEight;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }
            }

            if (price.contentEquals("100 naira Sides")) {
                NineString = button.getText().toString();
                NineSubString = NineString.substring(NineString.indexOf(""), NineString.indexOf(" naira Sides"));
                parseNine = Integer.parseInt(NineSubString);
                if (!app.prev.containsKey("8")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseNine;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("8", "100 naira Sides");
                } else {
                    String val = app.prev.get("8");
                    NineSubString = val.substring(val.indexOf(""), val.indexOf(" naira Sides"));

                    if (Integer.parseInt(NineSubString) != parseNine) {
                        app.prev.remove("8");
                        app.prev.put("8", "100 naira Sides");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(NineSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseNine;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }

            } else if (price.contentEquals("150 naira Sides")) {
                NineString = button2.getText().toString();
                NineSubString = NineString.substring(NineString.indexOf(""), NineString.indexOf(" naira Sides"));
                parseNine = Integer.parseInt(NineSubString);
                if (!app.prev.containsKey("8")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseNine;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("8", "150 naira Sides");
                } else {
                    String val = app.prev.get("8");
                    NineSubString = val.substring(val.indexOf(""), val.indexOf(" naira Sides"));

                    if (Integer.parseInt(NineSubString) != parseNine) {
                        app.prev.remove("8");
                        app.prev.put("8", "150 naira Sides");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(NineSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseNine;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }

            } else if (price.contentEquals("200 naira Sides")) {
                NineString = button3.getText().toString();
                NineSubString = NineString.substring(NineString.indexOf(""), NineString.indexOf(" naira Sides"));
                parseNine = Integer.parseInt(NineSubString);
                if (!app.prev.containsKey("8")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseNine;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("8", "200 naira Sides");
                } else {
                    String val = app.prev.get("8");
                    NineSubString = val.substring(val.indexOf(""), val.indexOf(" naira Sides"));

                    if (Integer.parseInt(NineSubString) != parseNine) {
                        app.prev.remove("8");
                        app.prev.put("8", "200 naira Sides");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(NineSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseNine;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }

            } else if (price.contentEquals("250 naira Sides")) {
                NineString = button4.getText().toString();
                NineSubString = NineString.substring(NineString.indexOf(""), NineString.indexOf(" naira Sides"));
                parseNine = Integer.parseInt(NineSubString);
                if (!app.prev.containsKey("8")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseNine;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("8", "250 naira Sides");
                } else {
                    String val = app.prev.get("8");
                    NineSubString = val.substring(val.indexOf(""), val.indexOf(" naira Sides"));

                    if (Integer.parseInt(NineSubString) != parseNine) {
                        app.prev.remove("8");
                        app.prev.put("8", "250 naira Sides");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(NineSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseNine;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }

            } else if (price.contentEquals("300 naira Sides")) {
                NineString = button5.getText().toString();
                NineSubString = NineString.substring(NineString.indexOf(""), NineString.indexOf(" naira Sides"));
                parseNine = Integer.parseInt(NineSubString);
                if (!app.prev.containsKey("8")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseNine;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("8", "300 naira Sides");
                } else {
                    String val = app.prev.get("8");
                    NineSubString = val.substring(val.indexOf(""), val.indexOf(" naira Sides"));

                    if (Integer.parseInt(NineSubString) != parseNine) {
                        app.prev.remove("8");
                        app.prev.put("8", "300 naira Sides");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(NineSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseNine;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }

            } else if (price.contentEquals("400 naira Sides")) {
                NineString = button6.getText().toString();
                NineSubString = NineString.substring(NineString.indexOf(""), NineString.indexOf(" naira Sides"));
                parseNine = Integer.parseInt(NineSubString);
                if (!app.prev.containsKey("8")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseNine;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("8", "400 naira Sides");
                } else {
                    String val = app.prev.get("8");
                    NineSubString = val.substring(val.indexOf(""), val.indexOf(" naira Sides"));

                    if (Integer.parseInt(NineSubString) != parseNine) {
                        app.prev.remove("8");
                        app.prev.put("8", "400 naira Sides");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(NineSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseNine;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }
            }

            if (price.contentEquals("50 naira Beans")) {
                TenString = button.getText().toString();
                TenSubString = TenString.substring(TenString.indexOf(""), TenString.indexOf(" naira Beans"));
                parseTen = Integer.parseInt(TenSubString);
                if (!app.prev.containsKey("9")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseTen;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("9", "50 naira Beans");
                } else {
                    String val = app.prev.get("9");
                    TenSubString = val.substring(val.indexOf(""), val.indexOf(" naira Beans"));

                    if (Integer.parseInt(TenSubString) != parseTen) {
                        app.prev.remove("9");
                        app.prev.put("9", "50 naira Beans");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(TenSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseTen;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }

            } else if (price.contentEquals("100 naira Beans")) {
                TenString = button2.getText().toString();
                TenSubString = TenString.substring(TenString.indexOf(""), TenString.indexOf(" naira Beans"));
                parseTen = Integer.parseInt(TenSubString);
                if (!app.prev.containsKey("9")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseTen;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("9", "100 naira Beans");
                } else {
                    String val = app.prev.get("9");
                    TenSubString = val.substring(val.indexOf(""), val.indexOf(" naira Beans"));

                    if (Integer.parseInt(TenSubString) != parseTen) {
                        app.prev.remove("9");
                        app.prev.put("9", "100 naira Beans");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(TenSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseTen;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }

            } else if (price.contentEquals("150 naira Beans")) {
                TenString = button3.getText().toString();
                TenSubString = TenString.substring(TenString.indexOf(""), TenString.indexOf(" naira Beans"));
                parseTen = Integer.parseInt(TenSubString);
                if (!app.prev.containsKey("9")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseTen;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("9", "150 naira Beans");
                } else {
                    String val = app.prev.get("9");
                    TenSubString = val.substring(val.indexOf(""), val.indexOf(" naira Beans"));

                    if (Integer.parseInt(TenSubString) != parseTen) {
                        app.prev.remove("9");
                        app.prev.put("9", "150 naira Beans");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(TenSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseTen;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }

            } else if (price.contentEquals("200 naira Beans")) {
                TenString = button4.getText().toString();
                TenSubString = TenString.substring(TenString.indexOf(""), TenString.indexOf(" naira Beans"));
                parseTen = Integer.parseInt(TenSubString);
                if (!app.prev.containsKey("9")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseTen;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("9", "200 naira Beans");
                } else {
                    String val = app.prev.get("9");
                    TenSubString = val.substring(val.indexOf(""), val.indexOf(" naira Beans"));

                    if (Integer.parseInt(TenSubString) != parseTen) {
                        app.prev.remove("9");
                        app.prev.put("9", "200 naira Beans");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(TenSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseTen;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }

            } else if (price.contentEquals("250 naira Beans")) {
                TenString = button5.getText().toString();
                TenSubString = TenString.substring(TenString.indexOf(""), TenString.indexOf(" naira Beans"));
                parseTen = Integer.parseInt(TenSubString);
                if (!app.prev.containsKey("9")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseTen;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("9", "250 naira Beans");
                } else {
                    String val = app.prev.get("9");
                    TenSubString = val.substring(val.indexOf(""), val.indexOf(" naira Beans"));

                    if (Integer.parseInt(TenSubString) != parseTen) {
                        app.prev.remove("9");
                        app.prev.put("9", "250 naira Beans");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(TenSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseTen;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }

            } else if (price.contentEquals("300 naira Beans")) {
                TenString = button6.getText().toString();
                TenSubString = TenString.substring(TenString.indexOf(""), TenString.indexOf(" naira Beans"));
                parseTen = Integer.parseInt(TenSubString);
                if (!app.prev.containsKey("9")) {
                    app.allinfoodcounter = app.allinfoodcounter + parseTen;
                    feetag.setText("" + app.allinfoodcounter + "");
                    app.prev.put("9", "300 naira Beans");
                } else {
                    String val = app.prev.get("9");
                    TenSubString = val.substring(val.indexOf(""), val.indexOf(" naira Beans"));

                    if (Integer.parseInt(TenSubString) != parseTen) {
                        app.prev.remove("9");
                        app.prev.put("9", "300 naira Beans");
                        app.allinfoodcounter = app.allinfoodcounter - Integer.parseInt(TenSubString);
                        app.allinfoodcounter = app.allinfoodcounter + parseTen;
                        feetag.setText("" + app.allinfoodcounter + "");
                    }
                }
        }
    }
}
