package com.example.isikbook;

import android.widget.EditText;
import android.widget.ImageView;


public class Books {
    public String kitap_ad;
    public String yazar;
    public String ders;
    public String fiyat;



    public Books() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public Books(String kitap_ad, String yazar, String ders, String fiyat) {
        this.kitap_ad = kitap_ad;
        this.yazar = yazar;
        this.ders = ders;
        this.fiyat = fiyat;


    }

}
