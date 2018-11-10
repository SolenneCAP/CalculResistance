package com.example.astrid.resistance6;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ColorSpinnerAdapter extends ArrayAdapter<ColorSpinnerAdapterItem> implements SpinnerAdapter {
    private ArrayList<ColorSpinnerAdapterItem> colors;

    ColorSpinnerAdapter(Context context, int textViewResourceId, ArrayList<ColorSpinnerAdapterItem> colors) {
        super(context, textViewResourceId, colors);
        this.colors = colors;
    }

    @Override
    public View getDropDownView(int position, View convertView, @NonNull ViewGroup parent) {
        super.getDropDownView(position, convertView, parent);
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
        }
        TextView tv = view.findViewById(android.R.id.text1);
        tv.setBackgroundColor(colors.get(position).getColor());
        tv.setText("");
        return view;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
        }
        TextView tv = view.findViewById(android.R.id.text1);
        tv.setBackgroundColor(colors.get(position).getColor());
        tv.setText("");
        return view;
    }
}

