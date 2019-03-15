package com.stockato.ginzo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailSushi extends AppCompatActivity {
    TextView titolotxt, descrizionetxt, prezzotxt, numero, textShop;
    ImageView imgSushi;
    ImageButton imgShop;
    String titolo, descrizione, prezzo;
    int img;
    Button piu, meno, carrello;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_sushi);

        getSupportActionBar().hide();

        titolotxt = findViewById(R.id.titolo);
        descrizionetxt = findViewById(R.id.descrizione);
        prezzotxt = findViewById(R.id.prezzo);
        imgSushi = findViewById(R.id.imgSushi);

        piu = findViewById(R.id.piu);
        meno = findViewById(R.id.meno);
        carrello = findViewById(R.id.btnCarrello);
        numero = findViewById(R.id.numero);

        textShop = findViewById(R.id.textShop);
        imgShop = findViewById(R.id.imgShop);


        if (getIntent().getExtras() != null) {
            Bundle bundle = getIntent().getExtras();
            titolo = bundle.getString("titolo");
            descrizione = bundle.getString("descrizione");
            prezzo = bundle.getString("prezzo");
            img = bundle.getInt("img");
        }

        titolotxt.setText(titolo);
        descrizionetxt.setText(descrizione);
        prezzotxt.setText(prezzo);
        imgSushi.setImageResource(img);


        meno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count == 0){
                }else {
                    count--;
                    numero.setText(String.valueOf(count));
                }
            }
        });

        piu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                numero.setText(String.valueOf(count));
            }
        });

        carrello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textShop.setText(String.valueOf(count));
            }
        });



    }
}
