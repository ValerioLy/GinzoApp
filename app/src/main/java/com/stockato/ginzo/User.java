package com.stockato.ginzo;

public class User {
    String id;
    String email;


    public User(String email) {
        this.id = id;
        this.email = email;
    }

    public User(){

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
