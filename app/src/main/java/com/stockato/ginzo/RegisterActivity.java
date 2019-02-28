package com.stockato.ginzo;

import android.content.Intent;
import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {
private EditText emailTxt, pswTxt;
Button registerBtn, login;
private FirebaseAuth mAuth;
private DatabaseReference mDatabase;
private String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

    emailTxt = findViewById(R.id.emailTxt);
    pswTxt = findViewById(R.id.pwsTxt);
    registerBtn = findViewById(R.id.registerBtn);
    login = findViewById(R.id.goLogin);

    mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

    login.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
        }
    });

    if (emailTxt.getText().toString() != "" && pswTxt.getText().toString() != "") {

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Task<AuthResult> authResultTask = mAuth.createUserWithEmailAndPassword(emailTxt.getText().toString(), pswTxt.getText().toString())
                        .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {

                                    Toast.makeText(RegisterActivity.this, "Authentication success.", Toast.LENGTH_LONG).show();
                                    Log.d("Register", "createUserWithEmail:success");
                                                    Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                                                    startActivity(intent);

                                    id = FirebaseAuth.getInstance().getUid();
                                    mDatabase.child("users").child(id).setValue(emailTxt.getText().toString());


                                } else {
                                    Log.w("Register", "createUserWithEmail:failure", task.getException());
                                    Toast.makeText(RegisterActivity.this, "Authentication failed.", Toast.LENGTH_LONG).show();
                                }
                            }
                        });

            }
        });
    } else {
        Toast.makeText(RegisterActivity.this, "I Campi di Testo sono vuoti", Toast.LENGTH_LONG).show();
    }





    }

}
