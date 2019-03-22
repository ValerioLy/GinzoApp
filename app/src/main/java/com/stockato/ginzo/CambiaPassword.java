package com.stockato.ginzo;

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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class CambiaPassword extends AppCompatActivity {
    private FirebaseUser user;
    EditText pswNuova;
    Button updatePsw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambia_password);
        getSupportActionBar().hide();

       user = FirebaseAuth.getInstance().getCurrentUser();

        pswNuova = findViewById(R.id.pswNuova);
        updatePsw = findViewById(R.id.updatePsw);

        updatePsw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user.updatePassword(pswNuova.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(CambiaPassword.this, "Password Aggiornata", Toast.LENGTH_LONG).show();
                                }
                            }
                        });
            }
        });


    }
}
