package com.stockato.ginzo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class SushiAdapter extends BaseAdapter {
    ArrayList<Object>list;
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
                item.setText(((Sushi)list.get(i)).getName());
                break;
            case HEADER:
                TextView title = view.findViewById(R.id.titolo);
                title.setText(((String)list.get(i)));
                break;
        }
        return view;
    }
}
