package com.stockato.ginzo;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class RegisterActivity extends AppCompatActivity {
    private EditText emailTxt, pswTxt;
    Button registerBtn, login;
    FirebaseAuth mAuth;
    User user;
    DatabaseReference reference;
    long id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        emailTxt = findViewById(R.id.emailTxt);
        pswTxt = findViewById(R.id.pwsTxt);
        registerBtn = findViewById(R.id.registerBtn);
        login = findViewById(R.id.goLogin);

        mAuth = FirebaseAuth.getInstance();


        user = new User();
        reference = FirebaseDatabase.getInstance().getReference().child("User");


       reference.addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
              if(dataSnapshot.exists()){
            id = dataSnapshot.getChildrenCount();
              }
           }

           @Override
           public void onCancelled(@NonNull DatabaseError databaseError) {

           }
       });




        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });


        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.createUserWithEmailAndPassword(emailTxt.getText().toString(), pswTxt.getText().toString())
                        .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Log.d("Register", "createUserWithEmail:success");
                                    Toast.makeText(RegisterActivity.this, "Authentication success.",
                                            Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                                    startActivity(intent);

                                    user.setEmail(emailTxt.getText().toString().trim());
                                    reference.child(String.valueOf(id+1)).setValue(user);
                                    Toast.makeText(RegisterActivity.this, "Utente aggiornato nel DB", Toast.LENGTH_SHORT).show();


                                } else {
                                    Log.w("Register", "createUserWithEmail:failure", task.getException());
                                    Toast.makeText(RegisterActivity.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();

                                }


                            }
                        });
            }
        });


    }


}