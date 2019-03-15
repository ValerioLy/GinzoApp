package com.stockato.ginzo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailSushi extends AppCompatActivity {
    TextView titolotxt, descrizionetxt, prezzotxt;
    ImageView imgSushi;
    String titolo, descrizione, prezzo;
    int img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_sushi);

        getSupportActionBar().hide();

        titolotxt = findViewById(R.id.titolo);
        descrizionetxt = findViewById(R.id.descrizione);
        prezzotxt = findViewById(R.id.prezzo);
        imgSushi = findViewById(R.id.imgSushi);


        if (getIntent().getExtras()!=null){
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






    }
}
