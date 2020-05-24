package com.example.isikbook;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SettingsActivity extends AppCompatActivity {
    private Toolbar actionbarAyarlarr;
    private Button sifreA, hesapA,btnHome, btnKamera, btnBildirims, btnAccount, btnMenuBtn;
    public void init(){
        actionbarAyarlarr = findViewById(R.id.actionbarAyarlar);
        setSupportActionBar(actionbarAyarlarr);
        getSupportActionBar().setTitle("Ayarlar");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        sifreA = findViewById(R.id.sifreAyarlari);
        hesapA = findViewById(R.id.hesapAyarlari);
        btnHome = findViewById(R.id.button_home);
        btnKamera = findViewById(R.id.button_camera);
        btnBildirims = findViewById(R.id.button_bildirim);
        btnAccount = findViewById(R.id.button_account);
        btnMenuBtn = findViewById(R.id.btnMenu);
        init();
        btnMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Menu = new Intent(SettingsActivity.this, MenuActivity.class);
                startActivity(Menu);
            }
        });

        sifreA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent sifre = new Intent(SettingsActivity.this , SifreAyarlariActivity.class);
                startActivity(sifre);
            }
        });

        hesapA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent hesap = new Intent(SettingsActivity.this , HesapAyarlariActivity.class);
                startActivity(hesap);
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Home = new Intent(SettingsActivity.this , AnaekranActivity.class);
                startActivity(Home);
            }
        });

        btnKamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Kamera = new Intent(SettingsActivity.this , KameraActivity.class);
                startActivity(Kamera);
            }
        });

        btnBildirims.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Bildirim = new Intent(SettingsActivity.this , BildirimActivity.class);
                startActivity(Bildirim);
            }
        });

        btnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Account = new Intent(SettingsActivity.this , AccountActivity.class);
                startActivity(Account);
            }
        });
    }
}
