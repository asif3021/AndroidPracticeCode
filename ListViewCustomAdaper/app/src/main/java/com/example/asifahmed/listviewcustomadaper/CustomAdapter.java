package com.example.asifahmed.listviewcustomadaper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

    int[] flagId;
    String[] countryAllNames;
    Context context;
    private LayoutInflater layoutInflater;
    ImageView imageView;

    CustomAdapter(Context context, String[] countryAllNames, int[] flagId){
        this.context = context;
        this.countryAllNames = countryAllNames;
        this.flagId = flagId;
    }

    @Override
    public int getCount() {
        return countryAllNames.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null){
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.layout_design,null);
        }

        imageView = convertView.findViewById(R.id.imageViewDesignId);
        TextView textView = convertView.findViewById(R.id.countryNameId);

        imageView.setImageResource(flagId[position]);
        textView.setText(countryAllNames[position]);

        return convertView;
    }
}
