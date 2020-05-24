package com.example.isikbook;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {
    private Toolbar actionbarMenuu;
    private Button  btnAyar, btnKitap,btnHesap;
    private void init() {
        actionbarMenuu = findViewById(R.id.actionbarMenu);
        setSupportActionBar(actionbarMenuu);
        getSupportActionBar().setTitle("Menü");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        btnAyar = findViewById(R.id.Ayarlar);
        btnKitap = findViewById(R.id.Kitaplar);
        btnHesap = findViewById(R.id.hesap);
        init();

        btnAyar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent ayar = new Intent(MenuActivity.this ,SettingsActivity.class);
                startActivity(ayar);
            }
        });

        btnHesap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent hesap = new Intent(MenuActivity.this ,AccountActivity.class);
                startActivity(hesap);
            }
        });

        btnKitap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent kitap = new Intent(MenuActivity.this ,KitapActivity.class);
                startActivity(kitap);
            }
        });
    }
}
