package com.icdatofcusgmail.lucidfood.VendorActivityArchive;

import android.content.Context;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.icdatofcusgmail.lucidfood.LucidApplication;
import com.icdatofcusgmail.lucidfood.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by DAVID OGUNDEPO on 03/27/2017.
 *
 *
 *
 * updated using ListViewGH still relevant for checking all.........
 */

class VendorAdapter extends BaseAdapter implements Filterable {

    private Context c;
    private ArrayList<Icdat> icdats;
    private ArrayList<Icdat> icdatsfiltered = new ArrayList<>();
    private ArrayList<Icdat> filterList;
    private CustomFilter filter;
    private Map<Integer, Boolean> isCheckMap = new HashMap<>();
    private List<Map<String, String>> data;
    private SparseBooleanArray mSelectedItemsIds;
    private LucidApplication app;

    VendorAdapter(Context c, ArrayList<Icdat> icdats) {
        super();
        mSelectedItemsIds = new SparseBooleanArray();
        this.c = c;
        this.icdats = icdats;

        app = LucidApplication.getInstance();
        configCheckMap(false);
    }

    private void configCheckMap(boolean bool) {
        for (int i = 0; i < icdats.size(); i++) {
            isCheckMap.put(i, bool);
        }
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
    public Filter getFilter() {

        if (filter == null)
        {
            filter = new CustomFilter();
        }

        return filter;
    }

    public void setFilterList(ArrayList<Icdat> filterList) {
        this.filterList = filterList;
    }

    private class CustomFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            FilterResults results = new FilterResults();

            if (constraint != null && constraint.length() > 0)
            {
                //CONSTRAINT TO UPPER
                constraint = constraint.toString().toUpperCase();
                ArrayList<Icdat> filters = new ArrayList<>();

                //FILTERING
                for (int i=0; i<filterList.size();i++)
                {
                    if (filterList.get(i).getFoodname().toUpperCase().contains(constraint))
                    {
                        Icdat icdat = new Icdat(filterList.get(i).getFoodname(), filterList.get(i).getFoodimage(), filterList.get(i).getSmooth());
                        filters.add(icdat);
                    }
                }
                results.count = filters.size();
                results.values = filters;
            } else
            {
                results.count = filterList.size();
                results.values = filterList;
            }

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            icdats = (ArrayList<Icdat>) results.values;
            notifyDataSetChanged();
        }
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent)  {


        LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ViewHolder holder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.va_imagemodel, parent, false);
            holder = new ViewHolder();
            holder.textView = (TextView) convertView.findViewById(R.id.textmodel);
            holder.imageView = (ImageView) convertView.findViewById(R.id.imagemodel);
            holder.smooth = (SmoothCheckBox) convertView.findViewById(R.id.smoothie);

            convertView.setTag(holder);
            convertView.setTag(R.id.textmodel, holder.textView);
            convertView.setTag(R.id.imagemodel, holder.imageView);
            convertView.setTag(R.id.smoothie, holder.smooth);

        } else {
            holder = (ViewHolder) convertView.getTag();
            holder.smooth.setTag(position);

        }
        final Icdat icdat = icdats.get(position);
        holder.getSmoothnNicelokingBOX().setTag(position);
        holder.getSmoothnNicelokingBOX().setChecked(icdat.isSelected());
        holder.getFoodName().setText(icdat.getFoodname());
        holder.getImageName().setImageResource(icdat.getFoodimage());


       if (compareIndex(icdat) == -1){
           holder.smooth.setChecked(false);
       } else {
           holder.smooth.setChecked(true);
       }
         //Set Data
        holder.imageView.setImageResource(icdats.get(position).getFoodimage());
        holder.textView.setText(icdats.get(position).getFoodname());

        holder.smooth.setTag(icdat);
        return convertView;
    }

    public void showFilterItems() {
        ArrayList<Icdat> filteredData = filterList;
        if (filteredData.isEmpty()) {
            Toast.makeText(c, "No Item has been selected", Toast.LENGTH_SHORT).show();
            icdatsfiltered = icdats;
            notifyDataSetChanged();
        }
        else {
            icdatsfiltered = filteredData;
            notifyDataSetChanged();
        }
    }

    private int compareIndex(Icdat icdat){
        int olonje = -1;
        for(int daveed = 0; daveed < app.selectedfoods.size(); daveed++){
            Icdat PhilFvsEithin= (Icdat) app.selectedfoods.get(daveed);
            if(PhilFvsEithin.getFoodname().equals(icdat.getFoodname())){
                olonje = daveed;
            }
        }
        return olonje;
    }
    public void setData(List<Map<String, String>> data) {
        this.data = data;
    }


    static class ViewHolder {
        SmoothCheckBox smooth;
        TextView textView;
        ImageView imageView;

        SmoothCheckBox getSmoothnNicelokingBOX() {
            return smooth;
        }

        void setSmoothNicelookingBOX(SmoothCheckBox NicelookingBOX) {
            this.smooth = NicelookingBOX;
        }

        TextView getFoodName() {
            return textView;
        }

        void setFoodName(TextView foodName) {
            this.textView = foodName;
        }

        ImageView getImageName() {
            return imageView;
        }

        void setImageName(ImageView imageName) {
            this.imageView = imageName;
        }

    }

    void toggleSelection(int position) {
        selectView(position, !mSelectedItemsIds.get(position));
    }

    private void selectView(int position, boolean value) {
        if (value) {
            mSelectedItemsIds.put(position, true);
        } else {
            mSelectedItemsIds.delete(position);
        }
        notifyDataSetChanged();
    }

}
