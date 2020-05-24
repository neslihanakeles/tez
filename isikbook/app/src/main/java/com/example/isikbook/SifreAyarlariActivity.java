package com.example.isikbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class SifreAyarlariActivity extends AppCompatActivity {
    FirebaseStorage storage = FirebaseStorage.getInstance();
    StorageReference referans = storage.getReference();
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    private Toolbar actionbarSifreAyarlarii;
    private Button btnHome, btnKamera, btnBildirims, btnAccount, guncelle2, btnMenuBtn;
    private EditText mevcutSifrem, yeniSifrem, isim;
    public void init(){
        actionbarSifreAyarlarii = findViewById(R.id.actionbarSifreAyarlari);
        setSupportActionBar(actionbarSifreAyarlarii);
        getSupportActionBar().setTitle("Şifre Ayarları");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    private  void newSifre(String mevcutSifrem, String yeniSifrem, String isim) {
        SifreAyari sifre = new SifreAyari(mevcutSifrem, yeniSifrem,isim);
        myRef.child("Şifre Güncelleme").child(isim).setValue(sifre);
    }
    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_sifre_ayarlari);
            btnHome = findViewById(R.id.button_home);
            btnKamera = findViewById(R.id.button_camera);
            btnBildirims = findViewById(R.id.button_bildirim);
            btnAccount = findViewById(R.id.button_account);
            guncelle2 = findViewById(R.id.buttong2);
            mevcutSifrem = findViewById(R.id.mevcutsifrem);
            yeniSifrem = findViewById(R.id.yeniSifrem);
            isim = findViewById(R.id.isim);
            btnMenuBtn = findViewById(R.id.btnMenu);
            init();

         btnMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Menu = new Intent(SifreAyarlariActivity.this, MenuActivity.class);
                startActivity(Menu);
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Home = new Intent(SifreAyarlariActivity.this , AnaekranActivity.class);
                startActivity(Home);
            }
        });

        btnKamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Kamera = new Intent(SifreAyarlariActivity.this , KameraActivity.class);
                startActivity(Kamera);
            }
        });

        btnBildirims.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Bildirim = new Intent(SifreAyarlariActivity.this , BildirimActivity.class);
                startActivity(Bildirim);
            }
        });

        btnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Account = new Intent(SifreAyarlariActivity.this , AccountActivity.class);
                startActivity(Account);
            }
        });
        guncelle2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getmevcutSifrem = mevcutSifrem.getText().toString();
                String getyeniSifrem = yeniSifrem.getText().toString();
                String getisim = isim.getText().toString();


                newSifre(getmevcutSifrem  ,getyeniSifrem, getisim);
                Toast.makeText(SifreAyarlariActivity.this, "Güncellendi", Toast.LENGTH_LONG).show();

            }

        });
    }
}
