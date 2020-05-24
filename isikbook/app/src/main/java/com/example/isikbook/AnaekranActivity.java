package com.example.isikbook;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class AnaekranActivity extends AppCompatActivity {
private ImageButton imgbook;
 private Button   btnHome, btnKamera, btnBildirims, btnAccount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anaekran);
        btnHome = findViewById(R.id.button_home);
        btnKamera = findViewById(R.id.button_camera);
        btnBildirims = findViewById(R.id.button_bildirim);
        btnAccount = findViewById(R.id.button_account);
        imgbook= findViewById(R.id.imgbook);

        imgbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent kitap = new Intent(AnaekranActivity.this ,KitapActivity.class);
                startActivity(kitap);
            }
        });
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Home = new Intent(AnaekranActivity.this , AnaekranActivity.class);
                startActivity(Home);
            }
        });

        btnKamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Kamera = new Intent(AnaekranActivity.this , KameraActivity.class);
                startActivity(Kamera);
            }
        });

        btnBildirims.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Bildirim = new Intent(AnaekranActivity.this , BildirimActivity.class);
                startActivity(Bildirim);
            }
        });

        btnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Account = new Intent(AnaekranActivity.this , AccountActivity.class);
                startActivity(Account);
            }
        });


    }

}
