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


        if (idItem == 1) {


        } else if(idItem == 3) {

        }
        else if(idItem == 4) {

        }
        else if(idItem == 6) {

        }
        else if(idItem == 7) {

        }
        else if(idItem == 8) {

        }else if(idItem == 9) {

        }else if(idItem == 10) {

        }
        else if(idItem == 12) {

        }
        else if(idItem == 13) {

        }
        else if(idItem == 14) {

        }
        else if(idItem == 15) {

        }else if(idItem == 16) {

        }
        else if(idItem == 18) {

        }
        else if(idItem == 19) {

        }
        else if(idItem == 21) {

        }else if(idItem == 23) {

        }
        else if(idItem == 25) {

        }else if(idItem == 27) {

        }else if(idItem == 29) {

        }else if(idItem == 31) {

        }

        else if(idItem == 33) {

        }

        else if(idItem == 34) {

        }

        else if(idItem == 35) {

        }

        else if(idItem == 36) {

        }


        else if(idItem == 38) {

        }




    }
}
