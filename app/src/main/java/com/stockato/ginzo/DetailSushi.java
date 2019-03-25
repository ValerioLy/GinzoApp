package com.stockato.ginzo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
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
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;

public class DetailSushi extends AppCompatActivity {
    TextView titolotxt, descrizionetxt, prezzotxt, numero, textShop;
    ImageView imgSushi;
    ImageButton imgShop;
    String titolo, descrizione, prezzo;
    int id, img;
    Button piu, meno, carrello;
    int count, count2, count3;
    DatabaseReference reference;
    String key;
    ItemSushi itemSushi;
    String idUser;
    boolean check = false;
    boolean premuto = false;
    FirebaseStorage storage;
    StorageReference storageRef;

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

        itemSushi = new ItemSushi();
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference().child("Ordine");

        storage = FirebaseStorage.getInstance();



        if (getIntent().getExtras() != null) {
            Bundle bundle = getIntent().getExtras();
            id = bundle.getInt("id");
            titolo = bundle.getString("titolo");
            descrizione = bundle.getString("descrizione");
            prezzo = bundle.getString("prezzo");
            img = bundle.getInt("img");
        }


        titolotxt.setText(titolo);
        descrizionetxt.setText(descrizione);
        prezzotxt.setText(prezzo);
        imgSushi.setImageResource(img);


        final FirebaseUser utente = FirebaseAuth.getInstance().getCurrentUser();
        idUser = utente.getUid();
        reference = FirebaseDatabase.getInstance().getReference().child("Ordine");


        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    for (DataSnapshot chidSnap : dataSnapshot.getChildren()) {
                        String idUserChild = (String) chidSnap.child("idUser").getValue();

                        if (check == false) {
                            if (idUser.equals(idUserChild)) {
                                count2 = count2 + 1;
                                textShop.setText(String.valueOf(count2));

                            }
                        }


                    }
                    check = true;
                    if (premuto == true) {
                        textShop.setText(String.valueOf(count3));
                    }


                }
            }

            @Override
            public void onCancelled(DatabaseError error) {

                Log.w("profile", "Failed to read value.", error.toException());
            }
        });


        meno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count == 0) {
                } else {
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
                key = reference.push().getKey();
                itemSushi.setTitolo(titolotxt.getText().toString());
                itemSushi.setPrezzo(prezzotxt.getText().toString());
                itemSushi.setNumero(String.valueOf(count));
                itemSushi.setIdUser(user.getUid());
                //storage
                storageRef = storage.getReference().child(key);
                imgSushi.setDrawingCacheEnabled(true);
                imgSushi.buildDrawingCache();
                Bitmap bitmap = ((BitmapDrawable) imgSushi.getDrawable()).getBitmap();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                byte[] data = baos.toByteArray();
                UploadTask uploadTask = storageRef.putBytes(data);
                uploadTask.addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        Toast.makeText(DetailSushi.this, "Upload Image Successfull", Toast.LENGTH_LONG).show();
                    }
                }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        Toast.makeText(DetailSushi.this, "NADA", Toast.LENGTH_LONG).show();
                    }
                });

                reference.child(key).setValue(itemSushi);
                count3 = count2 + 1;
                premuto = true;

            }
        });

        imgShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailSushi.this, CarrelloActivity.class);
                startActivity(intent);
            }
        });
    }
}
