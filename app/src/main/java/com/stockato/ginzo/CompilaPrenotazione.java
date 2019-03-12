package com.stockato.ginzo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CompilaPrenotazione extends AppCompatActivity {
    TextView txtCompila, txtRic, txtprivacy;
    Button btnGiorno, btnSubmit;
    CheckBox checkBox;
    String dataPassato;
    String idPassato;
    String oraD;
    EditText editNome, editCognome, editTelefono, editEmail;
    private DatabaseReference mDatabase;
    private User utente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compila_prenotazione);
        getSupportActionBar().hide();

        if (getIntent().getExtras() != null) {
            Bundle bundle = getIntent().getExtras();
            dataPassato = bundle.getString("data");
            idPassato = bundle.getString("id");
            oraD = bundle.getString("ora");
        }

        txtprivacy = findViewById(R.id.txtPrivacy);
        utente = new User();
        mDatabase = FirebaseDatabase.getInstance().getReference().child("User");


        txtCompila = findViewById(R.id.txtCompila);
        txtCompila.setText("Invia la tua richiesta di prenotazione del " + "\n" + "tavolo per il giorno");
        btnGiorno = findViewById(R.id.btnGiorno);
        txtRic = findViewById(R.id.txtRic);
        txtRic.setText("Riceverete un'email di conferma della " + "\n" + "vostra prenotazione");
        checkBox = findViewById(R.id.checkBox);
        checkBox.setText("*Confermo la lettura dell'informativa sulla privacy e acconsento" + "\n" + "al trattamento dei miei dati personali.");
        btnSubmit = findViewById(R.id.btnSubmit);

        editNome = findViewById(R.id.editNome);
        editCognome = findViewById(R.id.editCognome);
        editTelefono = findViewById(R.id.editTelefono);
        editEmail = findViewById(R.id.editEmail);

        btnGiorno.setText(dataPassato + " " + oraD);

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {

                    for (DataSnapshot chidSnap : dataSnapshot.getChildren()) {
                        Log.v("profile", "" + chidSnap.getKey());
                        Log.v("profile", "" + chidSnap.child("email").getValue());
                        editNome.setText((CharSequence) chidSnap.child("nome").getValue());
                        editCognome.setText((CharSequence) chidSnap.child("cognome").getValue());
                        editTelefono.setText((CharSequence) chidSnap.child("telefono").getValue());
                        editEmail.setText((CharSequence) chidSnap.child("email").getValue());


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
