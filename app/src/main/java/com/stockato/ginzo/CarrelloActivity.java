package com.stockato.ginzo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class CarrelloActivity extends AppCompatActivity {
    TextView txtTotale;
    ListView list;
    Button svuota, prosegui;
    private String titolo, prezzo;
    private int id, img;
    CarrelloAdapter carrelloAdapter;
    private DatabaseReference mDatabase;
    ItemSushi itemSushi;
    ArrayList<ItemSushi> arraySushi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrello);

        getSupportActionBar().hide();

        txtTotale = findViewById(R.id.txtTotale);
        list = findViewById(R.id.list);
        svuota = findViewById(R.id.svuota);
        prosegui = findViewById(R.id.prosegui);

        arraySushi = new ArrayList<>();
        if (getIntent().getExtras() != null) {
            Bundle bundle = getIntent().getExtras();

        }
        itemSushi = new ItemSushi();
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Ordine");


        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {

                    for (DataSnapshot chidSnap : dataSnapshot.getChildren()) {
                        ItemSushi post = chidSnap.getValue(ItemSushi.class);
                        arraySushi.add(post);

//                        itemSushi.setImg((Integer) chidSnap.child("img").getValue());
//                        itemSushi.setPrezzo((String) chidSnap.child("prezzo").getValue());
//                        itemSushi.setNumero((String) chidSnap.child("numero").getValue());
//                        arraySushi.add(itemSushi);
                        carrelloAdapter = new CarrelloAdapter(CarrelloActivity.this, arraySushi);
                        list.setAdapter(carrelloAdapter);

                    }

                }
            }

            @Override
            public void onCancelled(DatabaseError error) {

                Log.w("profile", "Failed to read value.", error.toException());
            }
        });


    }
}
