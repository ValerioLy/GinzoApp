package com.stockato.ginzo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CarrelloEmpty extends AppCompatActivity {
Button menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrello_empty);

        getSupportActionBar().hide();

    menu = findViewById(R.id.menu);

    menu.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(CarrelloEmpty.this, OrdinaActivity.class);
            startActivity(intent);
        }
    });

    }
}
