package com.stockato.ginzo;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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

public class profileActivity extends AppCompatActivity {
    TextView email;
    Button logoutBtn;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        getSupportActionBar().hide();


        email = findViewById(R.id.email);
        logoutBtn = findViewById(R.id.logoutBtn);


        mDatabase = FirebaseDatabase.getInstance().getReference().child("User");
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();



        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {

                    for (DataSnapshot chidSnap : dataSnapshot.getChildren()) {
                        Log.v("profile",""+ chidSnap.getKey());
                        Log.v("profile",""+ chidSnap.child("email").getValue());
                     email.setText((CharSequence) chidSnap.child("email").getValue());

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
