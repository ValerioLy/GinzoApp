package com.stockato.ginzo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.content.Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP;

public class Privacy extends AppCompatActivity {
    TextView txtPrivacy;
    Button chiudi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy);
        getSupportActionBar().hide();

        txtPrivacy = findViewById(R.id.txtPrivacy);
        chiudi = findViewById(R.id.chiudi);
        txtPrivacy.setText("Legge sulla privacy. Il decreto 196 del 2003 “Codice in materia di protezione dei dati personali” detto anche “Testo unico sulla Privacy” è la normativa entrata in vigore dal 1° gennaio 2004, ampliando il percorso legislativo compiuto dall'Italia in materia di dati personali a partire dalla legge 675/96. Il settore dell'informazione è un settore interessato da una continua evoluzione e da una rilevante importanza sociale. Basta pensare alla quantità e qualità delle informazioni sotto forma di dati personali, abitudini e consumi dei clienti, che posseggono le aziende. La tutela dei dati personali risulta essere argomento di controversia, tra quelli che vorrebbero un libero scambio delle informazioni e quelli che vorrebbero delle limitazioni attraverso la tutela e il controllo. Oltre alla tutela dei dati personali e sensibili di clienti, fornitori e dipendenti, le aziende hanno la necessità di tutelare la proprietà intellettuale, i brevetti e il know-how interno.\n" +
                "\n" +
                "Tali diritti vengono bilanciati con altri diritti di pari rango, contemplati in Costituzione, quali il diritto a un'equa retribuzione (art. 36), e il diritto di difesa (art. 24). L'effettività di questi diritti richiede la possibilità di accesso e di consultazione dei documenti aziendali, per produrre le prova necessarie ad esempio a dimostrare la qualità e quantità del lavoro svolto, ovvero la propria estraneità ai fatti imputati. In questo senso, il principio del pari rango regolamenta la stessa problematica di accesso e consultazione, nel settore pubblico. Essendo il datore di lavoro l'unico soggetto avente titolo, in quanto proprietario e gestore dei sistemi informatici e di archiviazione, esiste l'eventualità concreta di creazione, eliminazione o modifica senza traccia di informazioni e azioni dell'utente sul sistema prima della loro acquisizione in sede processuale, e la difficoltà di una loro ricostruzione ex-post.\n" +
                "\n" +
                "Prima di una specifica normativa, l'unica tutela era fornita dalla giurisprudenza della Suprema Corte di Cassazione. Alla fine del XX secolo per rispettare gli Accordi di Schengen e per dare attuazione alla direttiva europea 95/46/CE del 24 ottobre 1995, relativa alla tutela delle persone fisiche con riguardo al trattamento dei dati personali venne emanata la legge 31 dicembre 1996 n. 675, che entrò in vigore nel maggio 1997.\n" +
                "\n" +
                "Col passare del tempo, a tale norma si erano affiancate ulteriori leggi, riguardanti singoli e specifici aspetti del trattamento dei dati. La sopravvenuta complessità normativa creatasi in seguito all'approvazione di diverse disposizioni portò all'emanazione del d.lgs 30 giugno 2003, n. 196 che ha riordinato interamente la materia. Nel 2011 e 2012 altre disposizioni hanno emendato il codice del 2003, in particolare abolendo alcuni passaggi burocratici (tipo il DPS) oppure le regole per le informazioni sensibili fornite spontaneamente mediante il proprio CV.\n");





        chiudi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });
    }
}
