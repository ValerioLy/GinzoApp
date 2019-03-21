package com.stockato.ginzo;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
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
    CarrelloAdapter carrelloAdapter;
    private DatabaseReference mDatabase;
    ItemSushi itemSushi;
    ArrayList<ItemSushi> arraySushi;
    String  idUser;
    ItemSushi post;
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

        itemSushi = new ItemSushi();

        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        idUser = user.getUid();
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Ordine");




        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {

                    for (DataSnapshot chidSnap : dataSnapshot.getChildren()) {
                        String idUserChild = (String) chidSnap.child("idUser").getValue();

                        if (idUser.equals(idUserChild)) {
                            Log.i("diocane", ""+idUserChild+idUser);
                             post = chidSnap.getValue(ItemSushi.class);
                             arraySushi.add(post);
                            carrelloAdapter = new CarrelloAdapter(CarrelloActivity.this, arraySushi);
                            list.setAdapter(carrelloAdapter);

                        }

                    }


                }
            }

            @Override
            public void onCancelled(DatabaseError error) {

                Log.w("profile", "Failed to read value.", error.toException());
            }
        });


        svuota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                new AlertDialog.Builder(CarrelloActivity.this)
                        .setTitle("Vuoi svuotare gli ordini?")
                        .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                mDatabase.removeValue();
                                Intent intent = new Intent(CarrelloActivity.this, CarrelloActivity.class);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("No", null)
                        .show();
            }
        });


    }
}
