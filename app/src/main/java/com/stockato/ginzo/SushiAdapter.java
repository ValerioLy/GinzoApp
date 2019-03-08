package com.stockato.ginzo;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SushiAdapter extends BaseAdapter {
    ArrayList<Object> list;
    private static final int ITEM = 0;
    private static final int HEADER = 1;
    LayoutInflater layoutInflater;

    public SushiAdapter(Context context, ArrayList<Object> list) {
        this.list = list;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getItemViewType(int position) {
        if (list.get(position) instanceof Sushi) {
            return ITEM;
        } else {
            return HEADER;
        }
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            switch (getItemViewType(i)) {
                case ITEM:
                    view = layoutInflater.inflate(R.layout.sushi_row, null);
                    break;
                case HEADER:
                    view = layoutInflater.inflate(R.layout.header_row, null);
                    break;
            }
        }
        switch (getItemViewType(i)) {
            case ITEM:
                TextView item = view.findViewById(R.id.sushi);
                ImageView arrow = view.findViewById(R.id.arrow);
                item.setText(((Sushi) list.get(i)).getName());
                arrow.setImageResource(R.drawable.baseline_play_arrow_black_18dp);
                break;
            case HEADER:
                TextView title = view.findViewById(R.id.titolo);
                title.setText(((String) list.get(i)));
                ImageView imgHeader = view.findViewById(R.id.imgSushi);


               switch (title.getText().toString()) {
                   case "STARTERS":
                       imgHeader.setImageResource(R.drawable.antipasto);
                       break;
                   case "SUSHI SINGOLI":
                       imgHeader.setImageResource(R.drawable.singoli);
                       break;
                   case "MAKI":
                       imgHeader.setImageResource(R.drawable.maki);
                       break;
                   case "MIXED":
                       imgHeader.setImageResource(R.drawable.mixed);
                       break;
                   case "Sashimi":
                       imgHeader.setImageResource(R.drawable.sashimi);
                       break;
                   case "TARTARE-CEVICHE-CHIRASHI":
                       imgHeader.setImageResource(R.drawable.tartare);
                       break;
                   case "SALADS":
                       imgHeader.setImageResource(R.drawable.salads);
                       break;
                   case "HOT DISHES":
                       imgHeader.setImageResource(R.drawable.hotdishes);
                       break;
                   case "BARCHE MIX":
                       imgHeader.setImageResource(R.drawable.barche);
                       break;
                   case "PARTY TRAYS":
                       imgHeader.setImageResource(R.drawable.trays);
                       break;
                   case "DESSERTS":
                       imgHeader.setImageResource(R.drawable.desserts);
                       break;
                   case "DRINKS":
                       imgHeader.setImageResource(R.drawable.drinks);
                       break;
                   case "SALSE E CONDIMENTI":
                       imgHeader.setImageResource(R.drawable.salse);
                       break;
               }

                break;
        }
        return view;
    }
}
