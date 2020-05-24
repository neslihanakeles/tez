package com.example.isikbook;

public class SifreAyari {
    public String mevcutsifrem;
    public String yenisifrem;
    public String isim;



    public SifreAyari() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public SifreAyari(String mevcutsifrem, String yenisifrem, String isim) {
        this.mevcutsifrem= mevcutsifrem;
        this.yenisifrem =yenisifrem;
        this.isim =isim;




    }
}