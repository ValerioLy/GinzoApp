package com.stockato.ginzo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class OrdersActivity extends AppCompatActivity {
ListView listOrders;
private long idItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);
        getSupportActionBar().hide();
        listOrders = findViewById(R.id.listOrders);

        if (getIntent().getExtras() != null){
            Bundle bundle = getIntent().getExtras();
            idItem = bundle.getLong("idItem");
        }










    }
}
