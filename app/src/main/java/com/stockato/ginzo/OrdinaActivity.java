package com.stockato.ginzo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
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

        list.add(new String("STARTERS"));
        list.add(new Sushi("STARTERS", R.drawable.baseline_play_arrow_black_18dp));
        list.add(new String("SUSHI SINGOLI"));
        list.add(new Sushi("Sushi singoli",R.drawable.baseline_play_arrow_black_18dp));
        list.add(new Sushi("Bignè di sushi",R.drawable.baseline_play_arrow_black_18dp));
        list.add(new String("MAKI"));
        list.add(new Sushi("Special Uramaki", R.drawable.baseline_play_arrow_black_18dp));
        list.add(new Sushi("Uramaki Rolls", R.drawable.baseline_play_arrow_black_18dp));
        list.add(new Sushi("Futomaki", R.drawable.baseline_play_arrow_black_18dp));
        list.add(new Sushi("Hosomaki", R.drawable.baseline_play_arrow_black_18dp));
        list.add(new Sushi("Temaki", R.drawable.baseline_play_arrow_black_18dp));
        list.add(new String("MIXED"));
        list.add(new Sushi("Nigiri mixed", R.drawable.baseline_play_arrow_black_18dp));
        list.add(new Sushi("Sushi mixed", R.drawable.baseline_play_arrow_black_18dp));
        list.add(new Sushi("Maki mixed", R.drawable.baseline_play_arrow_black_18dp));
        list.add(new Sushi("Veggy", R.drawable.baseline_play_arrow_black_18dp));
        list.add(new Sushi("Lunch menu", R.drawable.baseline_play_arrow_black_18dp));
        list.add(new String("Sashimi"));
        list.add(new Sushi("Sashimi", R.drawable.baseline_play_arrow_black_18dp));
        list.add(new Sushi("Sashimi a la carte", R.drawable.baseline_play_arrow_black_18dp));
        list.add(new String("TARTARE-CEVICHE-CHIRASHI"));
        list.add(new Sushi("Tartare-Ceviche-Chirashi", R.drawable.baseline_play_arrow_black_18dp));
        list.add(new String("SALADS"));
        list.add(new Sushi("Salads", R.drawable.baseline_play_arrow_black_18dp));
        list.add(new String("HOT DISHES"));
        list.add(new Sushi("HOT DISHES", R.drawable.baseline_play_arrow_black_18dp));
        list.add(new String("BARCHE MIX"));
        list.add(new Sushi("BARCHE MIX", R.drawable.baseline_play_arrow_black_18dp));
        list.add(new String("PARTY TRAYS"));
        list.add(new Sushi("PARTY TRAYS", R.drawable.baseline_play_arrow_black_18dp));
        list.add(new String("DESSERTS"));
        list.add(new Sushi("DESSERTS", R.drawable.baseline_play_arrow_black_18dp));
        list.add(new String("DRINKS"));
        list.add(new Sushi("Japanese Beers", R.drawable.baseline_play_arrow_black_18dp));
        list.add(new Sushi("Wines", R.drawable.baseline_play_arrow_black_18dp));
        list.add(new Sushi("Soft drinks", R.drawable.baseline_play_arrow_black_18dp));
        list.add(new Sushi("Sakè", R.drawable.baseline_play_arrow_black_18dp));
        list.add(new String("SALSE E CONDIMENTI"));
        list.add(new Sushi("Salse e condimenti", R.drawable.baseline_play_arrow_black_18dp));

        SushiAdapter sushiAdapter = new SushiAdapter(OrdinaActivity.this, list);

        listView.setAdapter(sushiAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(OrdinaActivity.this, OrdersActivity.class);
                startActivity(intent);
            }
        });
    }
}

