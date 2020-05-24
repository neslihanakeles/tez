package com.example.isikbook;

public class Siparis {
    public String adresYaz;
    public String numYaz;
    public String isimgir;

    public Siparis() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public Siparis(String isimgir, String adresYaz, String numYaz) {
        this.adresYaz = adresYaz;
        this.numYaz = numYaz;
        this.isimgir =isimgir;


    }
}