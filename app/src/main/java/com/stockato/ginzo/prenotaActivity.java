package com.stockato.ginzo;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Date;


public class prenotaActivity extends AppCompatActivity {
    TextView tx;
    Button prosegui;
    CalendarView calendarView;
    DatabaseReference reference;
    DataP dataP;
    String dataCurrent;
    String key;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prenota);

        getSupportActionBar().hide();

        tx = findViewById(R.id.tx);
        prosegui = findViewById(R.id.prosegui);
        calendarView = findViewById(R.id.calendarView);
        tx.setText("Seleziona data e ora in cui vuoi prenotare il tuo tavolo." + "\n" + " Le richieste vanno inviate almeno 1ora prima.");

        reference = FirebaseDatabase.getInstance().getReference().child("DataP");

        dataP = new DataP();

        // Prendere la data
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        final String selectedDate = sdf.format(new Date(calendarView.getDate()));




        calendarView.setOnDateChangeListener( new CalendarView.OnDateChangeListener() {
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
//                Toast.makeText(getApplicationContext(),dayOfMonth+ "/"+month+"/"+year, Toast.LENGTH_LONG).show();
                dataCurrent = dayOfMonth+ "/"+month+"/"+year;
                Toast.makeText(getApplicationContext(),dataCurrent, Toast.LENGTH_LONG).show();
            }
        });

        prosegui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                key =reference.push().getKey();
                Intent intent = new Intent(prenotaActivity.this, OreTavolo.class);
                Bundle bundle = new Bundle();
                bundle.putString("id", key);
                bundle.putString("data", dataCurrent);
                intent.putExtras(bundle);
                startActivity(intent);
                dataP.setGiorno(dataCurrent);
                reference.child(key).setValue(dataP);
                Log.i("idpassato", "prenotaActivity"+key);
                Toast.makeText(prenotaActivity.this, "Data aggiornato nel DB", Toast.LENGTH_SHORT).show();
            }
        });



    }
}
