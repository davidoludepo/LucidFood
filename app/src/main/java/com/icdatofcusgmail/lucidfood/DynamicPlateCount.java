package com.icdatofcusgmail.lucidfood;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.muddzdev.styleabletoastlibrary.StyleableToast;

/**
 * Created by DAVID OGUNDEPO on 03/27/2017.
 */

public class DynamicPlateCount extends DialogFragment implements RadioGroup.OnCheckedChangeListener {

    RadioGroup radioGroup;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Choose the slightest volume of items available");
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.va_dynamic_platecount, null);
        builder.setView(view);
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                StyleableToast NoPlateSelected = new StyleableToast(getActivity(), "Please Select Default Plate No.", Toast.LENGTH_SHORT).spinIcon();
                NoPlateSelected.setBackgroundColor(Color.parseColor("#FF5A5F"));
                NoPlateSelected.setTextColor(Color.WHITE);
                NoPlateSelected.show();
            }
        });
        builder.setPositiveButton(R.string.okay, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                StyleableToast APlateNoSelected = new StyleableToast(getActivity(), "An Item Selected" +which, Toast.LENGTH_SHORT).spinIcon();
                APlateNoSelected.setBackgroundColor(Color.parseColor("#FF5A5F"));
                APlateNoSelected.setTextColor(Color.WHITE);
                APlateNoSelected.show();
                dialog.dismiss();
            }
        });
        setCancelable(true);
        Dialog dialog = builder.create();
        dialog.show();

        radioGroup = (RadioGroup) view.findViewById(R.id.radiohead);
        radioGroup.setOnCheckedChangeListener(this);
        return dialog;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.one:
                Intent intent = new Intent(getActivity(), PlateCount.class);
                startActivityForResult(intent, 5);

                break;
            case R.id.two:

                break;
            case R.id.three:

                break;
            case R.id.four:

                break;
            case R.id.five:

                break;
            case R.id.six:

                break;
            case R.id.seven:

                break;
            case R.id.eight:

                break;
            case R.id.nine:

                break;
            case R.id.ten:

                break;
            case R.id.eleven:

                break;
            case R.id.twelve:

                break;
            case R.id.thirteen:

                break;
            case R.id.fourteen:

                break;
            case R.id.fifteen:

                break;
            case R.id.sixteen:

                break;
            case R.id.seventeen:

                break;
            case R.id.eighteen:

                break;
            case R.id.nineteen:

                break;
            case R.id.twenty:

                break;
            case R.id.twentyone:

                break;
            case R.id.twentytwo:

                break;
            case R.id.twentythree:

                break;
            case R.id.twentyfour:

                break;
            case R.id.twentyfive:

                break;
            case R.id.twentysix:

                break;
            case R.id.twentyseven:

                break;
            case R.id.twentyeight:

                break;
            case R.id.twentynine:

                break;
            case R.id.thirty:

                break;
        }
    }
}
