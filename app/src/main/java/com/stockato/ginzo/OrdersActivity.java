package com.stockato.ginzo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class OrdersActivity extends AppCompatActivity {
ListView listOrders;
private long idItem;
ItemAdapter itemAdapter;
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
        // 1
        ArrayList<ItemSushi> itemSushi1 = new ArrayList<>();
        itemSushi1.add(new ItemSushi(0, "TAKITO TARTARE", "Tortilla di mais con guacamole, tartare di salmon...", "7:00 euro", R.drawable.takito ));
        itemSushi1.add(new ItemSushi(1, "TAKITO SHRIMPS", "Tortilla di mais con guacamole, gambero fritto in...", "7:00 euro", R.drawable.shrimps ));
        itemSushi1.add(new ItemSushi(2, "RISO", "Riso bianco con sesamo.", "3:00", R.drawable.riso ));
        itemSushi1.add(new ItemSushi(3, "EDAMAME", "Fagiolini di soia bolliti.", "4:00 euro", R.drawable.edamame ));
        itemSushi1.add(new ItemSushi(4, "ZUPPA DI MISO", "Miso, tofu, funghi shitake.", "4:00 euro", R.drawable.zuppamiso ));
        itemSushi1.add(new ItemSushi(5, "WAKAME SALAD", "Insalata d'alghe wakame piccanti.", "4:00 euro", R.drawable.wakame ));
        itemSushi1.add(new ItemSushi(6, "IKANSAISALAD", "Insalata di calamari, funghi shitake, verdure, ze...", "5:50 euro", R.drawable.ikansaisalad ));
        itemSushi1.add(new ItemSushi(7, "MISO SPECIAL", "Miso, uovo di quaglia, olio al tartufo, erba cipo...", "5:00 euro", R.drawable.misospecial ));
        itemSushi1.add(new ItemSushi(8, "SPRING ROOLS", "Involtino di alga di riso ripieno di gamberi cott...", "6:50 euro", R.drawable.springrolls ));
        itemSushi1.add(new ItemSushi(9, "USUZUKURI", "Carpaccio di Salmone marinato in salsa Ponzu, man...", "7:00 euro", R.drawable.usuzukuri ));
        // 2
        ArrayList<ItemSushi> itemSushi2 = new ArrayList<>();
        itemSushi2.add(new ItemSushi(0, "WAGYUNIGIRI", "manzo flambato, uovo di quaglia fritto, salsa bar...", "3:00 euro", R.drawable.wagy));
        itemSushi2.add(new ItemSushi(1, "SAKE", "Salmone", "1:80 euro", R.drawable.sake));
        itemSushi2.add(new ItemSushi(2, "SAKE FUME'", "Salmone affumicato", "2:50 euro", R.drawable.sakefume));
        itemSushi2.add(new ItemSushi(3, "MAGURO", "Tonno", "2:00 euro", R.drawable.maguro));
        itemSushi2.add(new ItemSushi(4, "SAKE AVOCADO", "Salmone e avocado", "2:00 euro", R.drawable.sakeavocado));
        itemSushi2.add(new ItemSushi(5, "AMAEBI", "Gambero crudo", "2:00 euro", R.drawable.amaebi));
        itemSushi2.add(new ItemSushi(6, "EBI", "Gambero cotto", "1:80 euro", R.drawable.ebi));
        itemSushi2.add(new ItemSushi(7, "SUZUKI", "Branzino", "1:80 euro", R.drawable.suzuki));
        itemSushi2.add(new ItemSushi(8, "HOTATEGAI", "Capasata", "2:00 euro", R.drawable.hotategai));
        itemSushi2.add(new ItemSushi(9, "HIRAMASA", "Ricciola", "2:00 euro", R.drawable.hiramasa));
        itemSushi2.add(new ItemSushi(10, "WHITE LUNA", "Pesce Burro, uova di aringa affumicata", "2:00 euro", R.drawable.whitetuna));
        itemSushi2.add(new ItemSushi(11, "UNAGI", "Anguilla grigliata", "2:00 euro", R.drawable.unagi));
        itemSushi2.add(new ItemSushi(12, "TAKO", "Polipo", "1:80 euro", R.drawable.tako));
        itemSushi2.add(new ItemSushi(13, "AVOCADO", "Avocado", "1:70 euro", R.drawable.avocado));
        itemSushi2.add(new ItemSushi(14, "POMODORO", "Pomodoro", "1:80 euro", R.drawable.pomodoro));
        itemSushi2.add(new ItemSushi(15, "IKURA", "Uova di salmone", "3:50 euro", R.drawable.ikura));
        itemSushi2.add(new ItemSushi(16, "TOBIKKO", "Uova di pesce volante", "3:00 euro", R.drawable.tobikko));
        itemSushi2.add(new ItemSushi(17, "WAKAME BIGNE", "Alghe piccanti", "2:50 euro", R.drawable.bigne));
        itemSushi2.add(new ItemSushi(18, "TOFU", "Tofu, marmellata di fichi, anacardi", "1:80 euro", R.drawable.wagy));


        if (idItem == 1) {
            itemAdapter = new ItemAdapter(itemSushi1, OrdersActivity.this);
            listOrders.setAdapter(itemAdapter);
        } else if(idItem == 3) {
            itemAdapter = new ItemAdapter(itemSushi2, OrdersActivity.this);
            listOrders.setAdapter(itemAdapter);
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
