package com.stockato.ginzo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
    FirebaseUser user;
    String idUser;
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
        idUser = user.getEmail();

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {

                    for (DataSnapshot chidSnap : dataSnapshot.getChildren()) {


                        if (chidSnap.child("email").getValue().equals(idUser)){

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
    }
}
