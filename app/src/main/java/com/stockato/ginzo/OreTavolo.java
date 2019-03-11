package com.stockato.ginzo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class OreTavolo extends AppCompatActivity {
    ListView listore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ore_tavolo);

        getSupportActionBar().hide();
        listore = findViewById(R.id.listOre);
        ArrayList<Object> ore = new ArrayList<>();
        ore.add(new Ora("12:00"));
        ore.add(new Ora("12:30"));
        ore.add(new Ora("13:30"));
        ore.add(new Ora("14:00"));
        ore.add(new Ora("19:00"));
        ore.add(new Ora("19:30"));
        ore.add(new Ora("20:00"));
        ore.add(new Ora("20:30"));
        ore.add(new Ora("21:00"));
        ore.add(new Ora("21:30"));
        ore.add(new Ora("22:00"));



        OreAdapter oreAdapter = new OreAdapter(this, R.layout.ore, ore );
        listore.setAdapter(oreAdapter);

        listore.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(OreTavolo.this, CompilaPrenotazione.class);
                startActivity(intent);
            }
        });
    }
}
