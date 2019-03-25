package com.stockato.ginzo;



public class ItemSushi {
    private int id;
    private String titolo;
    private String descrizione;
    private String prezzo;
    private int img;
    private String urlImg;
    private String numero;
    private String idUser;



    public ItemSushi(int id, String titolo, String descrizione, String prezzo, int img, String numero, String idUser, String urlImg) {
        this.id = id;
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
        this.numero = numero;
        this.img = img;
        this.idUser = idUser;
        this.urlImg = urlImg;
    }
    public ItemSushi(){

    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
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

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }


}
