package com.icdatofcusgmail.lucidfood;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by DAVID OGUNDEPO on 03/27/2017.
 */

public class VendorAdapter extends BaseAdapter {

    private Context c;
    private ArrayList<Icdat> icdats;

    private Map<Integer, Boolean> isCheckMap = new HashMap<>();

    VendorAdapter(Context c, ArrayList<Icdat> icdats) {
        this.c = c;
        this.icdats = icdats;
    }

    @Override
    public int getCount() {
        return icdats == null ? 0 : icdats.size();
    }

    @Override
    public Object getItem(int position) {
        return icdats.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.va_imagemodel, parent, false);
        }
        Icdat icdat = icdats.get(position);

        //Our Views
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imagemodel);
        TextView textView = (TextView) convertView.findViewById(R.id.textmodel);
        CheckBox checkBox = (CheckBox) convertView.findViewById(R.id.checkboxmodel);

        //Set Data
        imageView.setImageResource(icdats.get(position).getFoodimage());
        textView.setText(icdats.get(position).getFoodname());
        return convertView;
    }
    public static class ViewHolder {
        public CheckBox checkBox = null;
        public Object object = null;
    }

    public ArrayList<Icdat> getIcdats() {
        return icdats;
    }
}
