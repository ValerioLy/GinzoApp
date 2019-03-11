package com.stockato.ginzo;

public class DataP {
    private String giorno;
    private String ora;

    public DataP(String giorno, String ora) {
        this.giorno = giorno;
        this.ora = ora;
    }

    public DataP(){

    }

    public String getGiorno() {
        return giorno;
    }

    public void setGiorno(String giorno) {
        this.giorno = giorno;
    }

    public String getOra() {
        return ora;
    }

    public void setOra(String ora) {
        this.ora = ora;
    }
}
