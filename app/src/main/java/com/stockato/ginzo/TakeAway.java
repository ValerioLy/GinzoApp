package com.stockato.ginzo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TakeAway extends AppCompatActivity {
Button conferma;
EditText bacchette, note;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_away);

        getSupportActionBar().hide();

        bacchette = findViewById(R.id.bacchette);
        note = findViewById(R.id.note);
        conferma = findViewById(R.id.conferma);



        final String numeroBacchette = bacchette.getText().toString();
        final String noteA = note.getText().toString();

        conferma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("bacchette",numeroBacchette);
                bundle.putString("note", noteA);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });









    }
}
