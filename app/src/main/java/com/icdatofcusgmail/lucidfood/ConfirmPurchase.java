package com.icdatofcusgmail.lucidfood;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import com.muddzdev.styleabletoastlibrary.StyleableToast;

/**
 * Created by DAVID OGUNDEPO on 03/28/2017.
 */

public class ConfirmPurchase extends DialogFragment {

    CheckBox checkBoxx;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Confirm Purchase");

        checkBoxx = (CheckBox) getActivity().findViewById(R.id.sendpackalso);
        builder.setMessage("The items you selected will be bought by clicking \nDONE");
        LayoutInflater inflater=getActivity().getLayoutInflater();
        View view=inflater.inflate(R.layout.fa_confirmpurchase_dialogue, null);
        builder.setView(view);
        setCancelable(false);
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                StyleableToast NotConfirmed = new StyleableToast(getActivity(), "Transaction not Confirmed", Toast.LENGTH_SHORT).spinIcon();
                NotConfirmed.setBackgroundColor(Color.parseColor("#FF5A5F"));
                NotConfirmed.setTextColor(Color.WHITE);
                NotConfirmed.show();
            }
        });
        builder.setPositiveButton(R.string.done, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                sendData();
            }
        })
        .setIcon(R.drawable.a_announcement);
        Dialog dialog = builder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.LTGRAY));
        dialog.show();
        return dialog;
    }

    private void sendData(){
        StyleableToast TranCompleted = new StyleableToast(getActivity(), "Transaction Verified", Toast.LENGTH_SHORT).spinIcon();
        TranCompleted.setBackgroundColor(Color.parseColor("#FF5A5F"));
        TranCompleted.setTextColor(Color.WHITE);
        TranCompleted.setIcon(R.drawable.fa_confirmpurchasetoasticon);
        TranCompleted.show();

       /* Intent intent1 = new Intent();
        intent1.setAction(intent1.ACTION_SEND);
        intent1.setType("message/rfc822");
        intent1.putExtra(intent1.EXTRA_EMAIL, new String[]{"icdatofcus@gmail.com"});
        intent1.putExtra( );
        intent1.putExtra(intent1.EXTRA_TEXT, "body of email");
        try {
            startActivity(Intent1.createChooser(intent1, "Send mail..."));
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this.getActivity(), "There are no email clients installed.", Toast.LENGTH_LONG).show();
        }
        startActivity(intent1); */

        Intent intent = new Intent(getActivity(), ServingActivity.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        startActivity(intent);

    }
}
