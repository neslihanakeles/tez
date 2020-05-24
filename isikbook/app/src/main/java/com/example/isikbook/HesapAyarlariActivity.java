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

public class HesapAyarlariActivity extends AppCompatActivity {
    FirebaseStorage storage = FirebaseStorage.getInstance();
    StorageReference referans = storage.getReference();
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    private Toolbar actionbarHesapAyarlarii;
    private EditText isim, adres, mail;
    private Button btnHome, btnKamera, btnBildirims, btnAccount , guncelle,btnMenuBtn;
    public void init(){
        actionbarHesapAyarlarii = findViewById(R.id.actionbarHesapAyarlari);
        setSupportActionBar(actionbarHesapAyarlarii);
        getSupportActionBar().setTitle("Hesap Ayarları");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    private  void newHesap(String isim, String mail, String adres) {
        HesapAyari hesap = new HesapAyari(isim,  mail,  adres);
        myRef.child("Hesap Güncelleme").child(isim).setValue(hesap);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hesap_ayarlari);
        btnHome = findViewById(R.id.button_home);
        btnKamera = findViewById(R.id.button_camera);
        btnBildirims = findViewById(R.id.button_bildirim);
        btnAccount = findViewById(R.id.button_account);
        isim = findViewById(R.id.isim);
        mail = findViewById(R.id.mail);
        adres = findViewById(R.id.adres);
        guncelle = findViewById(R.id.buttong1);

        btnMenuBtn = findViewById(R.id.btnMenu);
        init();
        btnMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Menu = new Intent(HesapAyarlariActivity.this, MenuActivity.class);
                startActivity(Menu);
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Home = new Intent(HesapAyarlariActivity.this , AnaekranActivity.class);
                startActivity(Home);
            }
        });

        btnKamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Kamera = new Intent(HesapAyarlariActivity.this , KameraActivity.class);
                startActivity(Kamera);
            }
        });

        btnBildirims.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Bildirim = new Intent(HesapAyarlariActivity.this , BildirimActivity.class);
                startActivity(Bildirim);
            }
        });

        btnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Account = new Intent(HesapAyarlariActivity.this , AccountActivity.class);
                startActivity(Account);
            }
        });

        guncelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getisim = isim.getText().toString();
                String getadres = adres.getText().toString();
                String getmail = mail.getText().toString();


                newHesap(getisim  ,getadres ,getmail);
                Toast.makeText(HesapAyarlariActivity.this, "Güncellendi", Toast.LENGTH_LONG).show();

            }

        });
    }
}
