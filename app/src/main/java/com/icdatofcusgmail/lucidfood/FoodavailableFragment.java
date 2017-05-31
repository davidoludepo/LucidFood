package com.icdatofcusgmail.lucidfood;

import android.app.Fragment;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by DAVID OGUNDEPO on 03/27/2017.
 *
 */

public class FoodavailableFragment extends Fragment implements AdapterView.OnItemClickListener {

    ListView listView;
    Communicator communicator;
    VendorAdapter vendorAdapter;
    ArrayList<Icdat> Always = new ArrayList<>();

   /* String[] names={"White Rice", "Jollof Rice", "Fried Rice", "Beef", "Chicken",
            "Moi Moi", "Plantain", "Egg", "Coleslaw", "Beans"};

    int[] images={R.drawable.c_whiterice, R.drawable.c_jollof, R.drawable.c_friedrice, R.drawable.c_beef,
            R.drawable.c_chicken, R.drawable.c_moimoi, R.drawable.c_plantain, R.drawable.c_egg,
            R.drawable.c_coleslaw, R.drawable.c_beans};   */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.foodmenufragment_foodavailable, container, false);


        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        communicator = (Communicator) getActivity();
        listView = (ListView) getActivity().findViewById(R.id.listView);

        Always = getActivity().getIntent().getParcelableArrayListExtra("BabaOsheyGanni");
        vendorAdapter = new VendorAdapter(getActivity(), Always);
     //   final FoodmenuAdapter foodmenuAdapter = new FoodmenuAdapter(getActivity(), getTeams());
        listView.setAdapter(vendorAdapter);
        listView.setOnItemClickListener(this);
    }

  /*  private ArrayList<Team> getTeams() {
        final ArrayList<Team> teams = new ArrayList<>();
        teams.add(new Team(names[0], images[0]));
        teams.add(new Team(names[1], images[1]));
        teams.add(new Team(names[2], images[2]));
        teams.add(new Team(names[3], images[3]));
        teams.add(new Team(names[4], images[4]));
        teams.add(new Team(names[5], images[5]));
        teams.add(new Team(names[6], images[6]));
        teams.add(new Team(names[7], images[7]));
        teams.add(new Team(names[8], images[8]));
        teams.add(new Team(names[9], images[9]));

     //   SearchView searchView = (SearchView) getActivity().findViewById(R.id.searchView);
        return teams;
    }   */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        communicator.respond(position);
    }
    public void changeData(int f) {
        Resources resources = getResources();
        ListView listView = (ListView) getActivity().findViewById(R.id.listView);
    }
}
