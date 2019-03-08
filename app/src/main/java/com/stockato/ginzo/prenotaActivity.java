package com.stockato.ginzo;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;


public class prenotaActivity extends AppCompatActivity {
TextView tx;
Button prosegui;
CalendarView calendarView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prenota);

        getSupportActionBar().hide();

     tx = findViewById(R.id.tx);
     prosegui = findViewById(R.id.prosegui);
     calendarView = findViewById(R.id.calendarView);
     tx.setText("Seleziona data e ora in cui vuoi prenotare il tuo tavolo."+ "\n" +" Le richieste vanno inviate almeno 1ora prima.");

     prosegui.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             Intent intent = new Intent(prenotaActivity.this, OreTavolo.class);
             startActivity(intent);
         }
     });








    }
}
