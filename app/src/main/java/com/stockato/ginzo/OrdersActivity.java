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
        // 3
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
        //  4
        ArrayList<ItemSushi> itemSushi3 = new ArrayList<>();
        itemSushi3.add(new ItemSushi(0, "AMAEBI BIGNE'", "Tartare di gambero crudo, zucchina, lime", "3:00 euro", R.drawable.amaebibigne));
        itemSushi3.add(new ItemSushi(1, "EBI BIGNE'", "Tartare di gambero cotto, mayo, zucchina, erba ci...", "3:00 euro", R.drawable.ebi));
        itemSushi3.add(new ItemSushi(2, "TUNA BIGNE'", "Tartare di tonno, tabasco, erba cipollina", "3:00 euro", R.drawable.tuna_bigne));
        itemSushi3.add(new ItemSushi(3, "SALMON BIGNE'", "Tartare di salmone, mayo, erba cipollina", "3:00 euro", R.drawable.salmonbigne));
        itemSushi3.add(new ItemSushi(4, "SUZUKI BIGNE'", "Tartare di branzino, olio al tartufo, tobikko, gu...", "3:00 euro", R.drawable.suzukibigne));
        itemSushi3.add(new ItemSushi(5, "SPICY SALMON BIGNE'", "Tartare di salmone, avocado, mayo, tobikko, tabas...", "3:00 euro", R.drawable.spicysalmonbigne));
        itemSushi3.add(new ItemSushi(6, "ZUSHI BIGNE'", "Burrata, gamberi rossi sicilia, uova di aringa af...", "3:00 euro", R.drawable.zushibigne));
        itemSushi3.add(new ItemSushi(7, "MANGA BIGNE'", "Tartare di salmone, mango, mayo, mandorle, salsa...", "3:00 euro", R.drawable.mangabigne ));
        // 6
        ArrayList<ItemSushi> itemSushi4 = new ArrayList<>();
        itemSushi4.add(new ItemSushi(0, "FAST LOVE'", "2 Salmone, 2 tonno, 2 gamberi cotti.", "7:00 euro", R.drawable.fastlove));
        itemSushi4.add(new ItemSushi(1, "TOKYO SUNSET'", "2 Salmone, 2 tonno, 2 gamberi cotti, 2 branzino...", "10:00 euro", R.drawable.tokyo));
        itemSushi4.add(new ItemSushi(2, "ZUSHI LOVER SUP...'", "2 Salmone, 2 tonno, 2 gamberi cotti, 2 branzino...", "14:00 euro", R.drawable.zushilover));
        itemSushi4.add(new ItemSushi(3, "SAKE EXPERIENCE'", "Nigiri salmone", "13:00 euro", R.drawable.sakexperience));
        itemSushi4.add(new ItemSushi(4, "TUNA ADDICTED'", "Nigiri tonno", "15:00 euro", R.drawable.tunaddicted));
        itemSushi4.add(new ItemSushi(5, "GYNZA'", "Oshi-Zushi pressato con tartare di salmone, ikura...", "12:00 euro", R.drawable.gynza));
        itemSushi4.add(new ItemSushi(6, "NIGIRI FLAMBE''", "2 Salmon Teriyaki, 2 Tuna spicy, 2 Branzino Tartu...", "12:00 euro", R.drawable.nigiriflambe));
        itemSushi4.add(new ItemSushi(7, "TAKESHITA STRE...'", "Oshi-Zushi pressato con salmone Teriyaki alla pia...", "14:00 euro", R.drawable.takeshita));
        // 7
        ArrayList<ItemSushi> itemSushi5 = new ArrayList<>();
        itemSushi5.add(new ItemSushi(0, "CALIFORNIA'", "Gamberi cotti, salsa zushi e avocado", "8:50 euro", R.drawable.california));
        itemSushi5.add(new ItemSushi(1, "RAINBOW'", "Gambero cotto, granchio, salmone, branzino, tonno...", "8:50 euro", R.drawable.rainbmow));
        itemSushi5.add(new ItemSushi(2, "ZUSHI ROLL'", "Uova di pesce volante, granchio, avocado, lattura...", "8:50 euro", R.drawable.zushiroll));
        itemSushi5.add(new ItemSushi(3, "PHILADELPHIA'", "Salmone, philadelphia e avocado", "8:50 euro euro", R.drawable.philadelphia));
        itemSushi5.add(new ItemSushi(4, "SPICYTORO'", "Tonno, salsa spicy, erba cipollina e lattuga", "8:50 euro euro", R.drawable.spicytoro));
        itemSushi5.add(new ItemSushi(5, "ANAGOMAKI'", "Anguilla grigliata, avocado, philadelphia e salsa...", "8:50 euro euro", R.drawable.anagomaki));
        itemSushi5.add(new ItemSushi(6, "VEGGYROLL''", "Cetriolo, avocado, philadelphia e lattuga", "8:50 euro euro", R.drawable.veggyroll));
        itemSushi5.add(new ItemSushi(7, "VEGAN ROLLS'", "Asparagi, tofu, marmellata di fichi, mandorle", "8:50 euro euro", R.drawable.veganroll));
        // 8
        ArrayList<ItemSushi> itemSushi8 = new ArrayList<>();
        itemSushi8.add(new ItemSushi(0, "FUTU-ZU", "Alga di soya, tonno, salmone, philadelphia, avoca...", "8:00 euro", R.drawable.futuzu));
        itemSushi8.add(new ItemSushi(1, "PINK-MAKI", "Alga di soya, salmone alla piastra, gambero cotto...", "8:00 euro", R.drawable.pinkmaki));
        itemSushi8.add(new ItemSushi(2, "MEXI ROLLS'", "Tartare di tonno, avocado, Philadelphia, Guacamol...", "11:00 euro", R.drawable.mexi));
        itemSushi8.add(new ItemSushi(3, "SALMON NINJA'", "Salmone, japanese crabstick, philadelphia, spicy", "11:00 euro euro", R.drawable.salmonninja));

        // 9
        ArrayList<ItemSushi> itemSushi9 = new ArrayList<>();
        itemSushi9.add(new ItemSushi(0, "AVOCADO MAKI", "Filetto di salmone, philadelphia, riso", "5:00 euro", R.drawable.avocadomaki));
        itemSushi9.add(new ItemSushi(1, "EBI MAKI", "Salmone", "5:00 euro", R.drawable.ebimaki));
        itemSushi9.add(new ItemSushi(2, "KAPPA MAKI'", "Tonno", "4:50 euro", R.drawable.kappamaki));
        itemSushi9.add(new ItemSushi(3, "SAKE FUME' ROLLS'", "Gamberi cotti", "6:50 euro euro", R.drawable.sakefumerolls));
        itemSushi9.add(new ItemSushi(4, "SAKE MAKI", "Cetrioli, philadelphia", "5:00 euro", R.drawable.sakemaki));
        itemSushi9.add(new ItemSushi(5, "SALMON ROLLS", "Avocado, mayo", "6:50 euro", R.drawable.salmonrolls));
        itemSushi9.add(new ItemSushi(6, "TEKKA MAKI'", "Salmone affumicato, philadelphia, erba cipollina", "5:00 euro", R.drawable.tekamaki));

        // 10

        ArrayList<ItemSushi> itemSushi10 = new ArrayList<>();
        itemSushi10.add(new ItemSushi(0, "ANAGO TEMAKI", "Salmone, philadelphia, avocado", "5:00 euro", R.drawable.anagotemaki));
        itemSushi10.add(new ItemSushi(1, "MAGURO TEMAKI", "Tonno, avocado", "5:00 euro", R.drawable.magurotemaki));
        itemSushi10.add(new ItemSushi(2, "SAFADO TEMAKI'", "Gamberi cotti, avocado, philadelphia", "6:00 euro", R.drawable.safadotemaki));
        itemSushi10.add(new ItemSushi(3, "SAKE TEMAKI", "Anguilla grigliata, avocado, philadelphia, salsa..", "5:00 euro euro", R.drawable.saketemaki));
        itemSushi10.add(new ItemSushi(4, "TEMPURA TEMAKI", "Gambero fritto in tempura, mayo, insalata, ATTENZ..", "6:00 euro", R.drawable.tempuratemaki));
        itemSushi10.add(new ItemSushi(5, "ZUSHI TEMAKI", "Tartare di salmone, lattuga, erba cipollina, mayo...", "5:00 euro", R.drawable.zushitemaki));


        // 12
        ArrayList<ItemSushi> itemSushi12 = new ArrayList<>();
        itemSushi12.add(new ItemSushi(0, "FAST LOVE", "2 salmone, 2 tonno, 2 gamberi cotti", "7:00 euro", R.drawable.fastlove));
        itemSushi12.add(new ItemSushi(1, "FIRESTARTER", "2 salmone, 2 tonno, 2 gamberi cotti, 2 branzino..", "8:50 euro", R.drawable.firestarter));
        itemSushi12.add(new ItemSushi(2, "GHEMON'", "2 salmone, 2 tonno, 2 gamberi cotti, 2 branzino...", "12:00 euro", R.drawable.ghemon));
        itemSushi12.add(new ItemSushi(3, "GYNZA", "Nigiri  salmone", "12:00 euro euro", R.drawable.gynza));
        itemSushi12.add(new ItemSushi(4, "LOVE BOX", "Nigiri tonno", "35:00 euro", R.drawable.lovebox));
        itemSushi12.add(new ItemSushi(5, "MARISMO", "Oshi-Zushi pressato con tartare di salmone, ikura..", "14:00 euro", R.drawable.marismo));
        itemSushi12.add(new ItemSushi(6, "NIGIRI FLAMBE'", "2 Salmon, Teriyaki, 2 Tuna spicy, 2 Branzino Tartu...", "12:00 euro", R.drawable.nigiriflambe));
        itemSushi12.add(new ItemSushi(7, "NOT-CRUDO", "Oshi-Zushi pressato con salmone Teriyaki alla pia...", "13:00 euro", R.drawable.notcrudo));

        // 13
        ArrayList<ItemSushi> itemSushi13 = new ArrayList<>();
        itemSushi13.add(new ItemSushi(0, "LOVE BOX", "Da oggi il LOVE MENU in un cofanetto originale", "35:00 euro", R.drawable.lovebox));
        itemSushi13.add(new ItemSushi(1, "FIRESTARTER", "2 Salmone, 1 tonno, 1 branzino, 4 uramaki", "8:50 euro", R.drawable.firestarter));
        itemSushi13.add(new ItemSushi(2, "GHEMON", "2 Salmone, 2 tonno, 1 gambero cotto, 1 gambero cr...", "12:00 euro", R.drawable.ghemon));
        itemSushi13.add(new ItemSushi(3, "MARISMO", "2 Salmone, 2 tonno, 2 gamberi cotti, 1 branzino", "14:00 euro", R.drawable.marismo));
        itemSushi13.add(new ItemSushi(4, "SASHI ZUSHI TOP", "12 Filetti di sashimi misti, 4 nigiri, 3 hosomaki", "17:00 euro", R.drawable.sashizushitop));
        itemSushi13.add(new ItemSushi(5, "NOT CRUDO", "2 Salmone affumicato, 2 gamberi cotti, 2 polipo bo..", "13:00 euro", R.drawable.notcrudo));

        // 14
        ArrayList<ItemSushi> itemSushi14 = new ArrayList<>();
        itemSushi14.add(new ItemSushi(0, "SATRINCHA", "2 California, 2 philadelphia, 2 spicy toro, 2 ana...", "13:00 euro", R.drawable.satrincha));

        // 15

        ArrayList<ItemSushi> itemSushi15 = new ArrayList<>();
        itemSushi15.add(new ItemSushi(0, "SUSHI VEGANO", "Tofu, avocado, pomodoro, cetriolo, alghe wakame,...", "12:00 euro", R.drawable.sushivegano));

        //16

        ArrayList<ItemSushi> itemSushi16 = new ArrayList<>();
        itemSushi16.add(new ItemSushi(0, "ZUSHI LUNCH (S..", "1 Ciotola di riso sushi, 4 nigiri misti, 4 uramak..", "9:90 euro", R.drawable.zushilunchp));
        itemSushi16.add(new ItemSushi(1, "ZUNCH LUNC PL..", "Salmone cotto alla piastra con salsa Teriyaki, 4..", "12:90 euro", R.drawable.zushilunchpl));
        itemSushi16.add(new ItemSushi(2, "ZUSHI BRUNCH (...", "1Zuppa di miso, Ravioli Thailandesi di gamberi a..", "14:90 euro", R.drawable.zushibrunchsolopranzo));
        itemSushi16.add(new ItemSushi(3, "MENU EXPERIENC..", "1Zuppa di Miso, 1Riso saltato con gaberi uova..", "14:90 euro", R.drawable.menuxperiencezushi));
        itemSushi16.add(new ItemSushi(4, "VEGAN BRUNCH", "1Ciotola Edamame, tofu, avocado, pomodoro, alghe...", "14:90 euro", R.drawable.veganbrunch));

        //18
        ArrayList<ItemSushi> itemSushi18 = new ArrayList<>();
        itemSushi18.add(new ItemSushi(0, "SASHITEN", "5 Salmone, 5 tonno", "12:00 euro", R.drawable.sahiten));
        itemSushi18.add(new ItemSushi(1, "SASHIGOLD", "4 Salmone, 4 tonno, 4 branzino, 3 gamberi crudi", "15:00 euro", R.drawable.sashigold));

        // 19
        ArrayList<ItemSushi> itemSushi19 = new ArrayList<>();
        itemSushi19.add(new ItemSushi(0, "SAKE SASHIMI", "Salmone", "4:00 euro", R.drawable.sakesashimi));
        itemSushi19.add(new ItemSushi(1, "HIRAMASA SASHI", "Ricciola", "4:50 euro", R.drawable.hiramasasashimi));
        itemSushi19.add(new ItemSushi(2, "MAGURO SASHIMI", "Tonno", "4:50 euro", R.drawable.magurosashimi));
        itemSushi19.add(new ItemSushi(3, "SUZUKI SASHIMI", "Branzino", "4:00 euro", R.drawable.suzukisashimi));
        itemSushi19.add(new ItemSushi(4, "AMAEBI SASHIMI", "Gambero crudo dolce", "4:50 euro", R.drawable.amaebisashimi));
        itemSushi19.add(new ItemSushi(5, "HOTATEGAI SASH..", "Capasanta", "4:00 euro", R.drawable.hotatesashimi));
        itemSushi19.add(new ItemSushi(6, "SAKE FUME' SAS...", "Salmone affumicato", "4:50 euro", R.drawable.sakefumesashimi));


        // 21
        ArrayList<ItemSushi> itemSushi21 = new ArrayList<>();
        itemSushi21.add(new ItemSushi(0, "CHIRASHI ZUSHI", "Ciotola di riso con filetti di pesce crudo", "12:00 euro", R.drawable.chirashi));
        itemSushi21.add(new ItemSushi(1, "SALMON TARTARE", "Tartare di salmone, avocado, sesamo su un letto d...", "11:00 euro", R.drawable.salmontartare));
        itemSushi21.add(new ItemSushi(2, "TUNA TARTARE", "Tartare di tonno, mango, sesamo, lime, su un letto..", "12:00 euro", R.drawable.tunatartare));
        itemSushi21.add(new ItemSushi(3, "SAUDADE", "Tartare di branzino, mango, avocado, menta, lime.", "12:00 euro", R.drawable.saudade));
        itemSushi21.add(new ItemSushi(4, "ZUSHI TUNA SPECIAL", "Tartare di tonno, uovo di quaglia, wasabi, black..", "13:00 euro", R.drawable.zushitunaspecial));
        itemSushi21.add(new ItemSushi(5, "LEBLON", "Tartare di gamberi rossi, Sicilia, granchio reale,..", "12:00 euro", R.drawable.leblon));

        // 23
        ArrayList<ItemSushi> itemSushi23 = new ArrayList<>();
        itemSushi23.add(new ItemSushi(0, "ZUSHI SALAD", "Insalata verde con granchio, tonno sashimi, pomod..", "7:00 euro", R.drawable.zushisalad));
        itemSushi23.add(new ItemSushi(1, "THAI SALAD", "Insalata valeriana, scampi scottati, germogli di.", "7:00 euro", R.drawable.thaisalad));
        itemSushi23.add(new ItemSushi(2, "VEGAN SALAD", "Insalata Valeriana, pompelmo rosa, zucchine, edam...", "7:00 euro", R.drawable.vegansalad));

        // 25

        ArrayList<ItemSushi> itemSushi25 = new ArrayList<>();
        itemSushi25.add(new ItemSushi(0, "GYOZA PORK", "Ravioli tipici giapponesi ripieni di maiale e spec..", "8:00 euro", R.drawable.gyozapork));
        itemSushi25.add(new ItemSushi(1, "BEEF RAMEN", "Noodles in brodo, tenero manzo marinato, verdure,..", "9:00 euro", R.drawable.beeframen));
        itemSushi25.add(new ItemSushi(2, "YAKISOBA", "Spaghetti di grano saraceno saltati con gamberi..", "9:00 euro", R.drawable.yakisoba));
        itemSushi25.add(new ItemSushi(3, "YAKISOBA VEGGY", "Spaghetti di grando saraceno con verdure", "9:00 euro", R.drawable.yakisobaveggy));
        itemSushi25.add(new ItemSushi(4, "YAKIUDON", "Noodles saltati alla piastra con verdure nocciole..", "9:00 euro", R.drawable.yakiudon));
        itemSushi25.add(new ItemSushi(5, "YAKIUDON FISH", "Noodles saltati alla piastra con gamberi, zucch..", "9:00 euro", R.drawable.yakiudonfish));
        itemSushi25.add(new ItemSushi(6, "GOA FISH", "Riso saltato alla piastra  con gamberi, granchio..", "9:00 euro", R.drawable.goafish));
        itemSushi25.add(new ItemSushi(7, "GOA VEGGY", "Riso saltato alla piastra con verdure, e uova", "9:00 euro", R.drawable.goaveggy));
        itemSushi25.add(new ItemSushi(8, "GOA CHICKEN", "Riso saltato alla piastra con pollo e verdure", "9:00 euro", R.drawable.goachicken));
        itemSushi25.add(new ItemSushi(9, "SHAO MAI", "Ravioli di gamberi thailandesi cotti al vapore ac...", "7:00 euro", R.drawable.shaomai));
        itemSushi25.add(new ItemSushi(10, "UDON SOUP", "Zuppa con noodles, gamberi granchio, funchi shit..", "9:00 euro", R.drawable.udonsoup));
        itemSushi25.add(new ItemSushi(11, "CHICKEN RAMEN", "Spaghetti in brodo, pollo cotto alla piastra, uov...", "9:00 euro", R.drawable.chickenramen));
        itemSushi25.add(new ItemSushi(12, "TUNA TATAKI", "Tonno scottato alla piastra con sesamo", "13:00 euro", R.drawable.tunatataki));
        itemSushi25.add(new ItemSushi(13, "SALMON TERIYAKI", "Salmone alla piastra con salsa teriyaki", "11:00 euro", R.drawable.salmonteriyaki));
        itemSushi25.add(new ItemSushi(14, "YAKITORI HOTATE", "2 Spiedini di pollo con salsa teryaki", "6:00 euro", R.drawable.yakitorihotate));
        itemSushi25.add(new ItemSushi(15, "SHRIMPS YAKITO", "2 Spedini di capesante con salsa zushi", "6:50 euro", R.drawable.shrimpsyakitori));
        itemSushi25.add(new ItemSushi(16, "KOBE YAKITORI", "2 spiedini di Gamberi alla piastra con sesamo e l...", "8:50 euro", R.drawable.kobeyakitori));
        itemSushi25.add(new ItemSushi(17, "PANANGKAI", "Pollo alla piastra con curry latte di cocco, mel...", "12:00 euro", R.drawable.panangkai));
        itemSushi25.add(new ItemSushi(18, "TORI TONKATSU", "Pollo fritto in tempura di panko con salsa Tonkat...", "12:00 euro", R.drawable.toritonkatsu));




        // 38
        ArrayList<ItemSushi> itemSushi38 = new ArrayList<>();
        itemSushi38.add(new ItemSushi(0, "SALSA DI SOYA...", "Salsa di soia Bottiglia tappo rosso", "4:00 euro", R.drawable.salsasoya));
        itemSushi38.add(new ItemSushi(1, "SALSA DI SOYA...", "Salsa di soya Bottiglia tappo verde. -43/in men...", "4:00 euro", R.drawable.salsasoyavegetale));
        itemSushi38.add(new ItemSushi(2, "SALSA DI SOYA...", "Senza Glutine - Adatta ai celiaci", "6:00 euro", R.drawable.soiasenzaglutine));
        itemSushi38.add(new ItemSushi(3, "SALSA TERIYAKI", "Salsa di soya dolce", "6:00 euro", R.drawable.teriyaki));

        if (idItem == 1) {
            itemAdapter = new ItemAdapter(itemSushi1, OrdersActivity.this);
            listOrders.setAdapter(itemAdapter);
        } else if(idItem == 3) {
            itemAdapter = new ItemAdapter(itemSushi2, OrdersActivity.this);
            listOrders.setAdapter(itemAdapter);
        }
        else if(idItem == 4) {
            itemAdapter = new ItemAdapter(itemSushi3, OrdersActivity.this);
            listOrders.setAdapter(itemAdapter);
        }
        else if(idItem == 6) {
            itemAdapter = new ItemAdapter(itemSushi4, OrdersActivity.this);
            listOrders.setAdapter(itemAdapter);
        }
        else if(idItem == 7) {
            itemAdapter = new ItemAdapter(itemSushi5, OrdersActivity.this);
            listOrders.setAdapter(itemAdapter);

        }
        else if(idItem == 8) {
            itemAdapter = new ItemAdapter(itemSushi8, OrdersActivity.this);
            listOrders.setAdapter(itemAdapter);

        }else if(idItem == 9) {
            itemAdapter = new ItemAdapter(itemSushi9, OrdersActivity.this);
            listOrders.setAdapter(itemAdapter);
        }else if(idItem == 10) {
            itemAdapter = new ItemAdapter(itemSushi10, OrdersActivity.this);
            listOrders.setAdapter(itemAdapter);
        }
        else if(idItem == 12) {
            itemAdapter = new ItemAdapter(itemSushi12, OrdersActivity.this);
            listOrders.setAdapter(itemAdapter);
        }
        else if(idItem == 13) {
            itemAdapter = new ItemAdapter(itemSushi13, OrdersActivity.this);
            listOrders.setAdapter(itemAdapter);
        }
        else if(idItem == 14) {
            itemAdapter = new ItemAdapter(itemSushi14, OrdersActivity.this);
            listOrders.setAdapter(itemAdapter);
        }
        else if(idItem == 15) {
            itemAdapter = new ItemAdapter(itemSushi15, OrdersActivity.this);
            listOrders.setAdapter(itemAdapter);
        }else if(idItem == 16) {
            itemAdapter = new ItemAdapter(itemSushi16, OrdersActivity.this);
            listOrders.setAdapter(itemAdapter);
        }
        else if(idItem == 18) {
            itemAdapter = new ItemAdapter(itemSushi18, OrdersActivity.this);
            listOrders.setAdapter(itemAdapter);
        }
        else if(idItem == 19) {
            itemAdapter = new ItemAdapter(itemSushi19, OrdersActivity.this);
            listOrders.setAdapter(itemAdapter);
        }
        else if(idItem == 21) {
            itemAdapter = new ItemAdapter(itemSushi21, OrdersActivity.this);
            listOrders.setAdapter(itemAdapter);
        }else if(idItem == 23) {
            itemAdapter = new ItemAdapter(itemSushi23, OrdersActivity.this);
            listOrders.setAdapter(itemAdapter);
        }
        else if(idItem == 25) {
            itemAdapter = new ItemAdapter(itemSushi25, OrdersActivity.this);
            listOrders.setAdapter(itemAdapter);
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
            itemAdapter = new ItemAdapter(itemSushi38, OrdersActivity.this);
            listOrders.setAdapter(itemAdapter);

        }




    }
}
