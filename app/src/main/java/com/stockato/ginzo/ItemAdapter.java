package com.stockato.ginzo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemAdapter extends BaseAdapter {

    private ArrayList<ItemSushi> itemSushi;
    private Context context;

    public ItemAdapter(ArrayList<ItemSushi> itemSushi, Context context) {
        this.itemSushi = itemSushi;
        this.context = context;
    }

    @Override
    public int getCount() {
        return itemSushi.size();
    }

    @Override
    public Object getItem(int i) {
        return itemSushi.get(i);
    }

    @Override
    public long getItemId(int i) {
        return itemSushi.get(i).getId();
    }

    class ViewHolder {
        TextView titolo, descrizione, prezzo;
        ImageView img;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        if(convertView == null){
            LayoutInflater vInflater=LayoutInflater.from(context);
            convertView=vInflater.inflate(R.layout.sushi_list, null);
            ViewHolder vHolder=new ViewHolder();
            vHolder.titolo=convertView.findViewById(R.id.titolo);
            vHolder.descrizione=convertView.findViewById(R.id.descrizione);
            vHolder.prezzo=convertView.findViewById(R.id.prezzo);
            vHolder.img=convertView.findViewById(R.id.img);
            convertView.setTag((vHolder));

        }
        ItemSushi itemSushi= (ItemSushi) (ItemSushi) getItem(position);
        ViewHolder viewHolder=(ViewHolder) convertView.getTag();

        viewHolder.titolo.setText(itemSushi.getTitolo());
        viewHolder.descrizione.setText(itemSushi.getDescrizione());
        viewHolder.prezzo.setText(itemSushi.getPrezzo());
        viewHolder.img.setImageResource(itemSushi.getImg());

        return convertView;
    }
}
