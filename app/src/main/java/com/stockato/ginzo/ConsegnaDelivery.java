package com.stockato.ginzo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ConsegnaDelivery extends AppCompatActivity {
TextView spese;
EditText nome, cognome, via, numero, cap, citta, provincia, campanello, telefono, note, bacchette;
Button conferma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consegna_delivery);

        getSupportActionBar().hide();
        
        spese = findViewById(R.id.spese);
        nome = findViewById(R.id.nome);
        cognome = findViewById(R.id.cognome);
        via = findViewById(R.id.via);
        numero = findViewById(R.id.numero);
        cap = findViewById(R.id.cap);
        citta = findViewById(R.id.citta);
        provincia = findViewById(R.id.citta);
        campanello = findViewById(R.id.campanello);
        telefono = findViewById(R.id.telefono);
        note = findViewById(R.id.note);
        bacchette = findViewById(R.id.bacchette);
        conferma = findViewById(R.id.conferma);


    }
}
