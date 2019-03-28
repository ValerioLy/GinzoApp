package com.stockato.ginzo;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class TakeAway extends AppCompatActivity {
    Button conferma;
    EditText bacchette, note;
    private DatabaseReference mDatabase2;
    private DatabaseReference mDatabase3;

    String idUtente;
    String number;
    String prezzo;
    String titolo;
    String urlImg;
    String keyId;
    ItemSushi itemSushi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_away);

        getSupportActionBar().hide();

        bacchette = findViewById(R.id.bacchette);
        note = findViewById(R.id.note);
        conferma = findViewById(R.id.conferma);

        mDatabase2 = FirebaseDatabase.getInstance().getReference().child("Ordine");
        mDatabase3 = FirebaseDatabase.getInstance().getReference().child("OrdiniAcquistati");
        itemSushi = new ItemSushi();

        conferma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDatabase2.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        if (dataSnapshot.exists()) {

                            for (final DataSnapshot chidSnap : dataSnapshot.getChildren()) {

                                keyId = (String) chidSnap.getKey();
                                idUtente = (String) chidSnap.child("idUser").getValue();
                                number = (String) chidSnap.child("numero").getValue();
                                prezzo = (String) chidSnap.child("prezzo").getValue();
                                titolo = (String) chidSnap.child("titolo").getValue();
                                urlImg = (String) chidSnap.child("urlImg").getValue();


                                itemSushi.setIdUser(idUtente);
                                itemSushi.setNumero(number);
                                itemSushi.setPrezzo(prezzo);
                                itemSushi.setTitolo(titolo);
                                itemSushi.setUrlImg(urlImg);
                                mDatabase3.child(keyId).setValue(itemSushi);


                            }

                            mDatabase2.removeValue();

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Intent intent = new Intent(TakeAway.this, MainActivity.class);
                        startActivity(intent);
                    }
                });

            }
        });


    }
}
