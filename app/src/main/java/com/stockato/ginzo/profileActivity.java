package com.stockato.ginzo;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class profileActivity extends AppCompatActivity {
TextView email;
private DatabaseReference mDatabase;

Button logoutBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

      getSupportActionBar().hide();
      email = findViewById(R.id.email);

      mDatabase = FirebaseDatabase.getInstance().getReference();
        FirebaseAuth mFirebaseAuth = FirebaseAuth.getInstance();
        final FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
      logoutBtn = findViewById(R.id.logoutBtn);

      logoutBtn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {

              FirebaseAuth.getInstance().signOut();
              if (mFirebaseUser != null){
                  Intent intent = new Intent(profileActivity.this, RegisterActivity.class);
                  startActivity(intent);
              }


               else {
              Toast.makeText(profileActivity.this, "Logout Fallito", Toast.LENGTH_SHORT).show();
              }
          }
      });



    }
}
