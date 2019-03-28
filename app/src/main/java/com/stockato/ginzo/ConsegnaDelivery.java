package com.stockato.ginzo;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ConsegnaDelivery extends AppCompatActivity {
    TextView spese;
    EditText nome, cognome, via, numero, cap, citta, provincia, campanello, telefono, note, bacchette;
    Button conferma;
    private DatabaseReference mDatabase;
    private DatabaseReference mDatabase2;
    private DatabaseReference mDatabase3;
    FirebaseUser user;
    String idUser;
    int sommaPrezzo = 0;

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
        setContentView(R.layout.activity_consegna_delivery);

        getSupportActionBar().hide();

        spese = findViewById(R.id.spese);
        nome = findViewById(R.id.nome);
        cognome = findViewById(R.id.cognome);
        via = findViewById(R.id.via);
        numero = findViewById(R.id.numero);
        cap = findViewById(R.id.cap);
        citta = findViewById(R.id.citta);
        provincia = findViewById(R.id.provincia);
        campanello = findViewById(R.id.campanello);
        telefono = findViewById(R.id.telefono);
        note = findViewById(R.id.note);
        bacchette = findViewById(R.id.bacchette);
        conferma = findViewById(R.id.conferma);

        user = FirebaseAuth.getInstance().getCurrentUser();
        mDatabase = FirebaseDatabase.getInstance().getReference().child("User");
        mDatabase2 = FirebaseDatabase.getInstance().getReference().child("Ordine");
        mDatabase3 = FirebaseDatabase.getInstance().getReference().child("OrdiniAcquistati");
        itemSushi = new ItemSushi();

        idUser = user.getEmail();


        mDatabase2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {

                    for (DataSnapshot chidSnap : dataSnapshot.getChildren()) {

                        String prezzo = (String) chidSnap.child("prezzo").getValue();
                        String numero = (String) chidSnap.child("numero").getValue();

                        String prezzoInt = prezzo.substring(0, 5);


                        double price = Double.valueOf(prezzoInt);
                        double number = Double.valueOf(numero);

                        sommaPrezzo += price * number;

                    }

                    spese.setText(String.valueOf(sommaPrezzo + "euro"));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {

                    for (DataSnapshot chidSnap : dataSnapshot.getChildren()) {


                        if (chidSnap.child("email").getValue().equals(idUser)) {

                            nome.setText((CharSequence) chidSnap.child("nome").getValue());
                            cognome.setText((CharSequence) chidSnap.child("cognome").getValue());
                            via.setText((CharSequence) chidSnap.child("via").getValue());
                            numero.setText((CharSequence) chidSnap.child("numero").getValue());
                            cap.setText((CharSequence) chidSnap.child("cap").getValue());
                            citta.setText((CharSequence) chidSnap.child("citta").getValue());
                            provincia.setText((CharSequence) chidSnap.child("provincia").getValue());
                            campanello.setText((CharSequence) chidSnap.child("campanello").getValue());
                            telefono.setText((CharSequence) chidSnap.child("telefono").getValue());

                        }

                    }

                }
            }

            @Override
            public void onCancelled(DatabaseError error) {

                Log.w("profile", "Failed to read value.", error.toException());
            }
        });


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
                        Intent intent = new Intent(ConsegnaDelivery.this, MainActivity.class);
                        startActivity(intent);
                    }
                });
            }
        });

    }
}
