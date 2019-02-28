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

public class LoginActivity extends AppCompatActivity {
    private EditText emailLogin, pswLogin;
    Button loginButton;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailLogin = findViewById(R.id.emailLogin);
        pswLogin = findViewById(R.id.pswLogin);
        loginButton = findViewById(R.id.loginButton);

        mAuth = FirebaseAuth.getInstance();


        if (emailLogin.getText().toString() != "" && pswLogin.getText().toString() != "")
        {
            loginButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mAuth.signInWithEmailAndPassword(emailLogin.getText().toString(), pswLogin.getText().toString())
                            .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                        startActivity(intent);
                                        Log.d("Login", "signInWithEmail:success");
                                        Toast.makeText(LoginActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Log.w("Login", "signInWithEmail:failure", task.getException());
                                        Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();

                                    }
                                }
                            });
                }
            });

        } else {
            Toast.makeText(LoginActivity.this, "I Campi sono vuoti", Toast.LENGTH_SHORT).show();
        }



    }
}
