package com.icdatofcusgmail.lucidfood;

import android.app.Fragment;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.muddzdev.styleabletoastlibrary.StyleableToast;

import java.util.ArrayList;

/**
 * Created by DAVID OGUNDEPO on 03/27/2017.
 */

public class VendorFragment extends Fragment implements View.OnClickListener, AdapterView.OnItemClickListener {

    Communicator VendorCommunicate;

    private Adapter dweezy = null;
    static GridView ShowInThis;
    final String [] foodnames = new String[]{"White Rice", "Jollof Rice", "Fried Rice", "Beef", "Chicken", "Moi Moi", "Beans", "Egg", "Coleslaw", "Plantain"};
    int[] foodimages = {R.drawable.c_whiterice, R.drawable.c_jollof, R.drawable.c_friedrice, R.drawable.c_beef, R.drawable.c_chicken, R.drawable.c_moimoi, R.drawable.c_beans, R.drawable.c_egg, R.drawable.c_coleslaw, R.drawable.c_plantain};
    private static int visibility;

    public static void setVisibility(int visibility) {
        VendorFragment.visibility = visibility;
        ShowInThis.setVisibility(View.VISIBLE);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vendor, container, false);
        ShowInThis = (GridView) view.findViewById(R.id.showInThis);
        ShowInThis.setOnItemClickListener(this);
        ShowInThis.setVisibility(View.GONE);

        //ADAPTER
        VendorAdapter adapter = new VendorAdapter(getActivity(), getIcdats());
        ShowInThis.setAdapter(adapter);
        ShowInThis.setChoiceMode(GridView.CHOICE_MODE_MULTIPLE);
        ShowInThis.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    Toast.makeText(getContext(), foodnames[position], Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }
    private ArrayList<Icdat> getIcdats() {
        ArrayList<Icdat> icdats = new ArrayList<>();
        icdats.add(new Icdat(foodnames[0], foodimages[0]));
        icdats.add(new Icdat(foodnames[1], foodimages[1]));
        icdats.add(new Icdat(foodnames[2], foodimages[2]));
        icdats.add(new Icdat(foodnames[3], foodimages[3]));
        icdats.add(new Icdat(foodnames[4], foodimages[4]));
        icdats.add(new Icdat(foodnames[5], foodimages[5]));
        icdats.add(new Icdat(foodnames[6], foodimages[6]));
        icdats.add(new Icdat(foodnames[7], foodimages[7]));
        icdats.add(new Icdat(foodnames[8], foodimages[8]));
        icdats.add(new Icdat(foodnames[9], foodimages[9]));

        return icdats;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        VendorCommunicate = (Communicator) getActivity();
        ShowInThis = (GridView) getActivity().findViewById(R.id.showInThis);
        final VendorAdapter adapter = new VendorAdapter(getActivity(), getIcdats());
        ShowInThis.setAdapter(adapter);
        ShowInThis.setOnItemClickListener(this);
    }

    public void displayGridView(int joseph) {
        Resources ideas = getResources();
        GridView griddisplay = (GridView) getView().findViewById(R.id.showInThis);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (view.getTag() instanceof VendorAdapter.ViewHolder) {
            VendorAdapter.ViewHolder holder = (VendorAdapter.ViewHolder) view.getTag();
            holder.checkBox.toggle();
        }
        StyleableToast JustFoodNames = new StyleableToast(getActivity(), foodnames[position], Toast.LENGTH_SHORT).spinIcon();
        JustFoodNames.setBackgroundColor(Color.parseColor("#FF5A5F"));
        JustFoodNames.setTextColor(Color.WHITE);
        JustFoodNames.show();
    }
}
