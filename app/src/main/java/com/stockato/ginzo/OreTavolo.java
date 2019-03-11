package com.stockato.ginzo;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class OreTavolo extends AppCompatActivity {
    ListView listore;
    DatabaseReference reference;
    DataP dataP;
    String idPassato;
    String dataPassato;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ore_tavolo);

        getSupportActionBar().hide();

        if (getIntent().getExtras() != null){
            Bundle bundle = getIntent().getExtras();
            dataPassato = bundle.getString("data");
            idPassato = bundle.getString("id");
        }


        reference = FirebaseDatabase.getInstance().getReference().child("DataP");



        dataP = new DataP();
        listore = findViewById(R.id.listOre);
        ArrayList<Object> ore = new ArrayList<>();
        ore.add(new Ora("11:30"));
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



        final OreAdapter oreAdapter = new OreAdapter(this, R.layout.ore, ore);
        listore.setAdapter(oreAdapter);

        listore.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                String selectedFromList = String.valueOf(listore.getItemAtPosition(i));
//                String oraD = adapterView.getItemAtPosition(i).toString();

                String txtOra  = ((TextView)(view.findViewById(R.id.txtOra))).getText().toString();



                Log.i("diobono", "OreTavolo"+txtOra);
                dataP = new DataP();
                dataP.setOra(txtOra);
                reference.child(idPassato).setValue(dataP);
                Toast.makeText(OreTavolo.this, "Ora:"+txtOra, Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(OreTavolo.this, CompilaPrenotazione.class);
                    Bundle bundle =  new Bundle();
                    bundle.putString("id", idPassato);
                    bundle.putString("data", dataPassato);
                    bundle.putString("ora", txtOra);
                    intent.putExtras(bundle);
                    startActivity(intent);
            }
        });
    }
}
