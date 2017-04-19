package com.icdatofcusgmail.lucidfood;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by DAVID OGUNDEPO on 03/27/2017.
 */

public class FoodmenuAdapter extends BaseAdapter {

    private Context d;
    private ArrayList<Team> teams;
    FoodmenuAdapter(Context d, ArrayList<Team> teams) {
        this.d = d;
        this.teams = teams;
    }

    @Override
    public int getCount() {
        return teams.size();
    }

    @Override
    public Object getItem(int position) {
        return teams.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) d.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.fa_imagemodel, parent, false);
        }

        //Our Views
        ImageView imageView2 = (ImageView) convertView.findViewById(R.id.imagemodel2);
        TextView textView2 = (TextView) convertView.findViewById(R.id.textmodel2);

        //Set Data
        imageView2.setImageResource(teams.get(position).getFoodimagez());
        textView2.setText(teams.get(position).getFoodnamez());
        return convertView;
    }
}
