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

        SushiAdapter sushiAdapter = new SushiAdapter(OrdinaActivity.this, list);

        listView.setAdapter(sushiAdapter);
    }
}

