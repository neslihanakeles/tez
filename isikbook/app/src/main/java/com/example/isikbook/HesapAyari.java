package com.example.isikbook;



public class HesapAyari {
    public String isim;
    public String mail;
    public String adres;


    public HesapAyari() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public HesapAyari(String isim, String mail, String adres) {
        this.isim = isim;
        this.mail = mail;
        this.adres = adres;



    }
}