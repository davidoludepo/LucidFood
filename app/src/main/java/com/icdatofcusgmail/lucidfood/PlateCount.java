package com.icdatofcusgmail.lucidfood;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.widget.Toast;

import com.muddzdev.styleabletoastlibrary.StyleableToast;

/**
 * Created by DAVID OGUNDEPO on 03/28/2017.
 */

public class PlateCount extends DialogFragment{

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        builder.setItems(R.array.platenumbers, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which == 0) {
                    StyleableToast CheckMyMoney = new StyleableToast(getActivity(), "You are buying all in a plate", Toast.LENGTH_SHORT).spinIcon();
                    CheckMyMoney.setBackgroundColor(Color.parseColor("#FF5A5F"));
                    CheckMyMoney.setTextColor(Color.WHITE);
                    CheckMyMoney.show();
                }
                if (which == 1) {
                    StyleableToast CheckMyMoney = new StyleableToast(getActivity(), "You are buying all in two diff plates", Toast.LENGTH_SHORT).spinIcon();
                    CheckMyMoney.setBackgroundColor(Color.parseColor("#FF5A5F"));
                    CheckMyMoney.setTextColor(Color.WHITE);
                    CheckMyMoney.show();
                }
                if (which == 2) {
                    StyleableToast CheckMyMoney = new StyleableToast(getActivity(), "You are buying all in three diff plates", Toast.LENGTH_SHORT).spinIcon();
                    CheckMyMoney.setBackgroundColor(Color.parseColor("#FF5A5F"));
                    CheckMyMoney.setTextColor(Color.WHITE);
                    CheckMyMoney.show();
                }
                if (which == 3) {
                    StyleableToast CheckMyMoney = new StyleableToast(getActivity(), "You are buying all in four diff plates", Toast.LENGTH_SHORT).spinIcon();
                    CheckMyMoney.setBackgroundColor(Color.parseColor("#FF5A5F"));
                    CheckMyMoney.setTextColor(Color.WHITE);
                    CheckMyMoney.show();
                }
                if (which == 4) {
                    StyleableToast CheckMyMoney = new StyleableToast(getActivity(), "You are buying all in five diff plates", Toast.LENGTH_SHORT).spinIcon();
                    CheckMyMoney.setBackgroundColor(Color.parseColor("#FF5A5F"));
                    CheckMyMoney.setTextColor(Color.WHITE);
                    CheckMyMoney.show();
                }

            }
        });
        setCancelable(true);
        Dialog dialog = builder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.LTGRAY));
        dialog.show();
        return dialog;

    }
}
