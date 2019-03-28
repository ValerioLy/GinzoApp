package com.stockato.ginzo;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
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

import java.util.ArrayList;

public class StoricoOrdini extends AppCompatActivity {
    ListView list;
    CarrelloAdapter carrelloAdapter;
    private DatabaseReference mDatabase;
    String idUser;
    ItemSushi post;
    ArrayList<ItemSushi> arraySushi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storico_ordini);
        list = findViewById(R.id.list);

        getSupportActionBar().hide();
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        idUser = user.getUid();

        mDatabase = FirebaseDatabase.getInstance().getReference().child("OrdiniAcquistati");
        arraySushi = new ArrayList<>();

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {

                    for (final DataSnapshot chidSnap : dataSnapshot.getChildren()) {
                        String idUserChild = (String) chidSnap.child("idUser").getValue();

                        if (idUser.equals(idUserChild)) {


                            post = chidSnap.getValue(ItemSushi.class);
                            arraySushi.add(post);
                            carrelloAdapter = new CarrelloAdapter(StoricoOrdini.this, arraySushi);
                            list.setAdapter(carrelloAdapter);


                        }

                    }


                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
            }
        });

    }
}
