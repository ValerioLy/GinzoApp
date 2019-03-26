package com.stockato.ginzo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SceltaConsegna extends AppCompatActivity {
Button delivery, takeaway;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scelta_consegna);

        getSupportActionBar().hide();
        delivery = findViewById(R.id.delivery);
        takeaway = findViewById(R.id.takeaway);

        delivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        takeaway.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SceltaConsegna.this, OreDelivery.class);
                startActivity(intent);
            }
        });

    }
}
