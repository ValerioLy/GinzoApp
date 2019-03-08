package com.stockato.ginzo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        list.add(new Sushi("STARTERS"));
        list.add(new String("SUSHI SINGOLI"));
        list.add(new Sushi("Sushi singoli"));
        list.add(new Sushi("Bignè di sushi"));
        list.add(new String("MAKI"));
        list.add(new Sushi("Special Uramaki"));
        list.add(new Sushi("Uramaki Rolls"));
        list.add(new Sushi("Futomaki"));
        list.add(new Sushi("Hosomaki"));
        list.add(new Sushi("Temaki"));
        list.add(new String("MIXED"));
        list.add(new Sushi("Nigiri mixed"));
        list.add(new Sushi("Sushi mixed"));
        list.add(new Sushi("Maki mixed"));
        list.add(new Sushi("Veggy"));
        list.add(new Sushi("Lunch menu"));
        list.add(new String("Sashimi"));
        list.add(new Sushi("Sashimi"));
        list.add(new Sushi("Sashimi a la carte"));
        list.add(new String("TARTARE-CEVICHE-CHIRASHI"));
        list.add(new Sushi("Tartare-Ceviche-Chirashi"));
        list.add(new String("SALADS"));
        list.add(new Sushi("Salads"));
        list.add(new String("HOT DISHES"));
        list.add(new Sushi("HOT DISHES"));
        list.add(new String("BARCHE MIX"));
        list.add(new Sushi("BARCHE MIX"));
        list.add(new String("PARTY TRAYS"));
        list.add(new Sushi("PARTY TRAYS"));
        list.add(new String("DESSERRTS"));
        list.add(new Sushi("DESSERTS"));
        list.add(new String("DRINKS"));
        list.add(new Sushi("Japanese Beers"));
        list.add(new Sushi("Wines"));
        list.add(new Sushi("Soft drinks"));
        list.add(new Sushi("Sakè"));
        list.add(new String("SALSE E CONDIMENTI"));
        list.add(new Sushi("Salse e condimenti"));

        SushiAdapter sushiAdapter = new SushiAdapter(OrdinaActivity.this, list);

        listView.setAdapter(sushiAdapter);
    }
}

