package com.stockato.ginzo;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
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

import static android.content.Intent.FLAG_ACTIVITY_REORDER_TO_FRONT;

public class profileActivity extends AppCompatActivity {
    EditText nome, cognome, via, numero, cap, citta, provincia, campanello, codice, telefono, email, account, pwsnuova, psw;
    TextView privacy;
    Button logoutBtn, conferma, pswUpdate;
    CheckBox check;
    private DatabaseReference mDatabase;
    private User utente;
    String chiave;
    FirebaseUser user;
    String idUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        getSupportActionBar().hide();
        privacy = findViewById(R.id.privacy);
        nome = findViewById(R.id.nome);
        cognome = findViewById(R.id.cognome);
        via = findViewById(R.id.via);
        numero = findViewById(R.id.numero);
        cap = findViewById(R.id.cap);
        citta = findViewById(R.id.citta);
        provincia = findViewById(R.id.provincia);
        campanello = findViewById(R.id.campanello);
        codice = findViewById(R.id.codice);
        telefono = findViewById(R.id.telefono);
        email = findViewById(R.id.email);
        account = findViewById(R.id.account);
        pwsnuova = findViewById(R.id.pwsnuova);
        psw = findViewById(R.id.psw);
        logoutBtn = findViewById(R.id.logoutBtn);
        conferma = findViewById(R.id.conferma);
        check = findViewById(R.id.check);
        pswUpdate = findViewById(R.id.pswUpdate);

        check.setText("*Confermo la lettura dell'informativa sulla privacy e acconsento " + "\n" + "al trattamento dei miei dati personali.");


         user = FirebaseAuth.getInstance().getCurrentUser();
         idUser = user.getEmail();




        utente = new User();
        mDatabase = FirebaseDatabase.getInstance().getReference().child("User");





        privacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(profileActivity.this, Privacy.class);
                startActivity(intent);
            }
        });

        pswUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(profileActivity.this, CambiaPassword.class);
                startActivity(intent);
            }
        });



        conferma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!psw.getText().toString().isEmpty() || !pwsnuova.getText().toString().isEmpty()) {

                    if (psw.getText().toString().length() > 6 || pwsnuova.getText().toString().length() > 6) {
                        if ((psw.getText().toString()).equals(pwsnuova.getText().toString())) {

                            if (check.isChecked()) {
                                Toast.makeText(profileActivity.this,"Account Aggiornato", Toast.LENGTH_LONG).show();
//                                chiave = mDatabase.push().getKey();
                                utente.setNome(nome.getText().toString().trim());
                                utente.setCognome(cognome.getText().toString().trim());
                                utente.setVia(via.getText().toString().trim());
                                utente.setNumero(numero.getText().toString().trim());
                                utente.setCap(cap.getText().toString().trim());
                                utente.setCitta(citta.getText().toString().trim());
                                utente.setProvincia(provincia.getText().toString().trim());
                                utente.setCampanello(campanello.getText().toString().trim());
                                utente.setCodice(codice.getText().toString().trim());
                                utente.setTelefono(telefono.getText().toString().trim());
//                                utente.setEmail(email.getText().toString().trim());

                                mDatabase.child(chiave).setValue(utente);


                                Intent intent = new Intent(profileActivity.this, MainActivity.class);
                                startActivity(intent);
                            } else {
                                new AlertDialog.Builder(profileActivity.this)
                                        .setTitle("Conferma la lettura della privacy")
                                        .setNegativeButton("Ok", null)
                                        .show();
                            }

                        } else {
                            new AlertDialog.Builder(profileActivity.this)
                                    .setTitle("Le Password devono essere uguali")
                                    .setNegativeButton("Ok", null)
                                    .show();
                        }

                    } else {
                        new AlertDialog.Builder(profileActivity.this)
                                .setTitle("La Password deve essere minimo di 6 caratteri")
                                .setNegativeButton("Ok", null)
                                .show();

                    }

                } else {
                    new AlertDialog.Builder(profileActivity.this)
                            .setTitle("Le Password sono vuote")
                            .setNegativeButton("Ok", null)
                            .show();
                }


            }
        });


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
                        codice.setText((CharSequence) chidSnap.child("codice").getValue());
                        telefono.setText((CharSequence) chidSnap.child("telefono").getValue());
                        email.setText((CharSequence) chidSnap.child("email").getValue());
                        account.setText((CharSequence) chidSnap.child("email").getValue());

                        }

                    }

                }
            }

            @Override
            public void onCancelled(DatabaseError error) {

                Log.w("profile", "Failed to read value.", error.toException());
            }
        });


        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FirebaseAuth.getInstance().signOut();
                if (user != null) {
                    Intent intent = new Intent(profileActivity.this, RegisterActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(profileActivity.this, "Logout Fallito", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
