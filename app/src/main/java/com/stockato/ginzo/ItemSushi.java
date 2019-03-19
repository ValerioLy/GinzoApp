package com.stockato.ginzo;

import android.os.Parcel;
import android.os.Parcelable;

public class ItemSushi {
    private int id;
    private String titolo;
    private String descrizione;
    private String prezzo;
    private int img;
    private String numero;

    public ItemSushi(int id, String titolo, String descrizione, String prezzo, int img, String numero) {
        this.id = id;
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
        this.numero = numero;
        this.img = img;
    }
    public ItemSushi(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(String prezzo) {
        this.prezzo = prezzo;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }


}
