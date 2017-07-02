package com.icdatofcusgmail.lucidfood.FoodmenuActivityArchive;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.icdatofcusgmail.lucidfood.LucidApplication;
import com.icdatofcusgmail.lucidfood.R;
import com.icdatofcusgmail.lucidfood.VendorActivityArchive.Icdat;

import java.util.ArrayList;

/**
 * Created by DAVID OGUNDEPO on 03/27/2017.
 *
 */

public class FoodavailableFragment extends Fragment implements AdapterView.OnItemClickListener {

    ListView listView;
    Communicator communicator;
    FoodmenuAdapter foodmenuAdapter;
    LucidApplication MainApp;
    ArrayList<Icdat> Always = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.foodmenufragment_foodavailable, container, false);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        MainApp = LucidApplication.getInstance();
        communicator = (Communicator) getActivity();
        listView = (ListView) getActivity().findViewById(R.id.listView);

        for( int i = 0; i < MainApp.selectedfoods.size(); i++ ) {
            Icdat d = (Icdat) MainApp.selectedfoods.get(i);
            Always.add(i,d);
        }

        foodmenuAdapter = new FoodmenuAdapter(getActivity(), Always);
        listView.setAdapter(foodmenuAdapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        communicator.respond(position);
    }
}
