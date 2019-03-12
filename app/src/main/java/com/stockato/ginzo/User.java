package com.stockato.ginzo;

public class User {
    String nome;
    String cognome;
    String via;
    String numero;
    String cap;
    String citta;
    String provincia;
    String campanello;
    String codice;
    String telefono;
    String email;



    public User(String nome, String cognome, String via, String numero, String cap, String citta, String provincia, String campanello, String codice, String telefono, String email) {
        this.nome = nome;
        this.cognome = cognome;
        this.via = via;
        this.numero = numero;
        this.cap = cap;
        this.citta = citta;
        this.provincia = provincia;
        this.campanello = campanello;
        this.codice = codice;
        this.telefono = telefono;
        this.email = email;
    }

    public User(){

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCampanello() {
        return campanello;
    }

    public void setCampanello(String campanello) {
        this.campanello = campanello;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
