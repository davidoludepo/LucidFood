package com.icdatofcusgmail.lucidfood;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.muddzdev.styleabletoastlibrary.StyleableToast;

/**
    *
 *  Created by DAVID OGUNDEPO on 03/27/2017.
            *
                *
                    *
                         *
                             *
                                *
                                    *
                                        *
                                            *
                                        *
                                    *
                                *
                            *
                        *
                    *
                *
            *
 * CCreated by DAVID OGUNDEPO on 03/27/2017.
    *
 */

public class AddorRemove extends DialogFragment implements CompoundButton.OnCheckedChangeListener {

    CheckBox Alle;
    SmoothCheckBox smoot;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Alle = (CheckBox) getActivity().findViewById(R.id.checkboxAll);
        Alle.setOnCheckedChangeListener(this);
        smoot = (SmoothCheckBox) getActivity().findViewById(R.id.smoothie);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setItems(R.array.AorR, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which == 0) {
                    StyleableToast AddItems = new StyleableToast(getActivity(), "Adding Items", Toast.LENGTH_SHORT).spinIcon();
                    AddItems.setBackgroundColor(Color.parseColor("#FF5A5F"));
                    AddItems.setTextColor(Color.WHITE);
                    AddItems.show();
                    VendorActivity.All.setVisibility(View.VISIBLE);
                    VendorActivity.All.setText("Add All");
                    VendorActivity.itemsState.setVisibility(View.VISIBLE);
                    VendorActivity.itemsState.setText("Adding Items Available");
                    VendorActivity.ShowInThis.setVisibility(View.VISIBLE);
                    VendorActivity.pleaseWork.setVisibility(View.VISIBLE);
                }
                if (which == 1) {
                    StyleableToast RemoveItems = new StyleableToast(getActivity(), "Removing Items", Toast.LENGTH_SHORT).spinIcon();
                    RemoveItems.setBackgroundColor(Color.parseColor("#FF5A5F"));
                    RemoveItems.setTextColor(Color.WHITE);
                    RemoveItems.show();
                    VendorActivity.All.setVisibility(View.VISIBLE);
                    VendorActivity.All.setText("Remove All");
                    VendorActivity.itemsState.setText("Removing Items Not Available");
                    VendorActivity.ShowInThis.setVisibility(View.VISIBLE);
                    VendorActivity.pleaseWork.setVisibility(View.VISIBLE);
                }
            }
        });
        setCancelable(true);
        AlertDialog alertDialog = builder.create();
      //  alertDialog.getWindow().getAttributes().windowAnimations=R.style.SetDialogAnimation;
      //  alertDialog.getWindow().getAttributes().windowAnimations=R.style.SamAnimation_Window;
        alertDialog.show();
        alertDialog.dismiss();
        return builder.create();
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//        if (buttonView.getId()==R.id.checkboxAll && isChecked)
//            smoot.setChecked(true);
//        if (buttonView.getId()==R.id.checkboxAll && !isChecked)
//            smoot.setChecked(false);
    }

}
