package com.stockato.ginzo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class OrdinaActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordina);

        getSupportActionBar().hide();

        listView = findViewById(R.id.listView);
        ArrayList<Object> list = new ArrayList<>();

        list.add(new String("STARTERS"));  // 0
        list.add(new Sushi("STARTERS", R.drawable.baseline_play_arrow_black_18dp));
        list.add(new String("SUSHI SINGOLI"));  // 2
        list.add(new Sushi("Sushi singoli",R.drawable.baseline_play_arrow_black_18dp));
        list.add(new Sushi("Bignè di sushi",R.drawable.baseline_play_arrow_black_18dp));
        list.add(new String("MAKI")); // 5
        list.add(new Sushi("Special Uramaki", R.drawable.baseline_play_arrow_black_18dp));
        list.add(new Sushi("Uramaki Rolls", R.drawable.baseline_play_arrow_black_18dp));
        list.add(new Sushi("Futomaki", R.drawable.baseline_play_arrow_black_18dp));
        list.add(new Sushi("Hosomaki", R.drawable.baseline_play_arrow_black_18dp));
        list.add(new Sushi("Temaki", R.drawable.baseline_play_arrow_black_18dp));
        list.add(new String("MIXED")); // 11
        list.add(new Sushi("Nigiri mixed", R.drawable.baseline_play_arrow_black_18dp));
        list.add(new Sushi("Sushi mixed", R.drawable.baseline_play_arrow_black_18dp));
        list.add(new Sushi("Maki mixed", R.drawable.baseline_play_arrow_black_18dp));
        list.add(new Sushi("Veggy", R.drawable.baseline_play_arrow_black_18dp));
        list.add(new Sushi("Lunch menu", R.drawable.baseline_play_arrow_black_18dp));
        list.add(new String("Sashimi"));  // 17
        list.add(new Sushi("Sashimi", R.drawable.baseline_play_arrow_black_18dp));
        list.add(new Sushi("Sashimi a la carte", R.drawable.baseline_play_arrow_black_18dp));
        list.add(new String("TARTARE-CEVICHE-CHIRASHI")); // 20
        list.add(new Sushi("Tartare-Ceviche-Chirashi", R.drawable.baseline_play_arrow_black_18dp));
        list.add(new String("SALADS")); // 22
        list.add(new Sushi("Salads", R.drawable.baseline_play_arrow_black_18dp));
        list.add(new String("HOT DISHES"));  // 24
        list.add(new Sushi("HOT DISHES", R.drawable.baseline_play_arrow_black_18dp));
        list.add(new String("BARCHE MIX")); // 26
        list.add(new Sushi("BARCHE MIX", R.drawable.baseline_play_arrow_black_18dp));
        list.add(new String("PARTY TRAYS")); // 28
        list.add(new Sushi("PARTY TRAYS", R.drawable.baseline_play_arrow_black_18dp));
        list.add(new String("DESSERTS")); // 30
        list.add(new Sushi("DESSERTS", R.drawable.baseline_play_arrow_black_18dp));
        list.add(new String("DRINKS")); // 32
        list.add(new Sushi("Japanese Beers", R.drawable.baseline_play_arrow_black_18dp));
        list.add(new Sushi("Wines", R.drawable.baseline_play_arrow_black_18dp));
        list.add(new Sushi("Soft drinks", R.drawable.baseline_play_arrow_black_18dp));
        list.add(new Sushi("Sakè", R.drawable.baseline_play_arrow_black_18dp));
        list.add(new String("SALSE E CONDIMENTI"));  // 37
        list.add(new Sushi("Salse e condimenti", R.drawable.baseline_play_arrow_black_18dp));

        SushiAdapter sushiAdapter = new SushiAdapter(OrdinaActivity.this, list);

        listView.setAdapter(sushiAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                long idItem = adapterView.getAdapter().getItemId(i);

                if (idItem != 0 || idItem != 2 || idItem != 5 || idItem != 11 || idItem != 17 || idItem !=  20 || idItem != 22 || idItem != 24 || idItem != 26 || idItem != 28 || idItem != 30 || idItem != 32 || idItem != 37) {
                    Intent intent = new Intent(OrdinaActivity.this, OrdersActivity.class);
                    Log.i("ordina", "id:"+idItem);
                    Bundle bundle = new Bundle();
                    bundle.putLong("idItem", l);
                    intent.putExtras(bundle);
                    startActivity(intent);
                } else {

                }

            }
        });
    }
}

