package com.stockato.ginzo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;

import java.util.ArrayList;

public class CarrelloAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<ItemSushi> itemSushi;

    public CarrelloAdapter(Context context, ArrayList<ItemSushi> itemSushi) {
        this.context = context;
        this.itemSushi = itemSushi;
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
        TextView titolo, prezzo, numero;
        ImageView img;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        if(convertView == null){
            LayoutInflater vInflater=LayoutInflater.from(context);
            convertView=vInflater.inflate(R.layout.sushi_carrello, null);
            ViewHolder vHolder=new ViewHolder();

            vHolder.titolo=convertView.findViewById(R.id.titolo);
            vHolder.numero=convertView.findViewById(R.id.numero);
            vHolder.prezzo=convertView.findViewById(R.id.prezzo);
            vHolder.img=convertView.findViewById(R.id.img);
            convertView.setTag((vHolder));

        }
        ItemSushi itemSushi= (ItemSushi) (ItemSushi) getItem(position);
       ViewHolder viewHolder = (ViewHolder) convertView.getTag();

        viewHolder.titolo.setText(itemSushi.getTitolo());
        viewHolder.numero.setText(itemSushi.getNumero());
        viewHolder.prezzo.setText(itemSushi.getPrezzo());
//        viewHolder.img.setImageResource(itemSushi.getImg());

        return convertView;
    }

}
