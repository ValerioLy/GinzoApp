package com.stockato.ginzo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class CompilaPrenotazione extends AppCompatActivity {
    TextView txtCompila, txtRic;
    Button btnGiorno, btnSubmit;
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compila_prenotazione);
        getSupportActionBar().hide();
        txtCompila = findViewById(R.id.txtCompila);
        txtCompila.setText("Invia la tua richiesta di prenotazione del " + "\n" +"tavolo per il giorno");
        btnGiorno = findViewById(R.id.btnGiorno);
        txtRic = findViewById(R.id.txtRic);
        txtRic.setText("Riceverete un'email di conferma della "+ "\n" + "vostra prenotazione");
        checkBox = findViewById(R.id.checkBox);
        checkBox.setText("*Confermo la lettura dell'informativa sulla privacy e acconsento" + "\n" +"al trattamento dei miei dati personali.");
        btnSubmit = findViewById(R.id.btnSubmit);
    }
}
