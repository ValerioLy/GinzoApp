package com.stockato.ginzo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class OreAdapter extends ArrayAdapter {
    ArrayList<Object> list;


    public OreAdapter(Context context, int resource, ArrayList<Object> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.ore, null);
        TextView txtOra = (TextView)convertView.findViewById(R.id.txtOra);

        Ora ora = (Ora) getItem(position);
        txtOra.setText(ora.getOra());

        return convertView;
    }
}
