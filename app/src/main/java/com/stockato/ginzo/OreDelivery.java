package com.stockato.ginzo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class OreDelivery extends AppCompatActivity {
    TextView data;
    ListView lista;
    DataP dataP;
    DatabaseReference reference;
    String key;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ore_delivery);
        getSupportActionBar().hide();
        data = findViewById(R.id.data);
        lista = findViewById(R.id.lista);

//        String mydate = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());

        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        data.setText("OGGI " + "\n" + day+"/"+month+"/"+year);

        reference = FirebaseDatabase.getInstance().getReference().child("DataP");
        dataP = new DataP();

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
        lista.setAdapter(oreAdapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String txtOra = ((TextView) (view.findViewById(R.id.txtOra))).getText().toString();

                Log.i("diobono", "OreTavolo" + txtOra);
                dataP = new DataP();
                key = reference.push().getKey();
                dataP.setOra(txtOra);
                reference.child(key).setValue(dataP);
                Toast.makeText(OreDelivery.this, "Ora:" + txtOra, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(OreDelivery.this, TakeAway.class);
                Bundle bundle = new Bundle();
                bundle.putString("id", key);
                bundle.putString("ora", txtOra);
                Log.i("idpassato", "OreTavolo" + key);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });


    }
}
