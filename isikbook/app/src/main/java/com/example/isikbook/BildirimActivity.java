package com.example.isikbook;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.widget.Toolbar;
public class BildirimActivity extends AppCompatActivity {
    private Button btnKitap, btnHome, btnKamera, btnBildirims, btnAccount;
    private Toolbar actionbarBildirims;

    private void init() {
        actionbarBildirims = (Toolbar) findViewById(R.id.actionbarBildirim);
        setSupportActionBar(actionbarBildirims);
        getSupportActionBar().setTitle("Bildirimler");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bildirim);
        btnHome = findViewById(R.id.button_home);
        btnKamera = findViewById(R.id.button_camera);
        btnBildirims = findViewById(R.id.button_bildirim);
        btnAccount = findViewById(R.id.button_account);
        btnKitap = findViewById(R.id.Kitaplar);
        init();
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Home = new Intent(BildirimActivity.this , AnaekranActivity.class);
                startActivity(Home);
            }
        });

        btnKamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Kamera = new Intent(BildirimActivity.this , KameraActivity.class);
                startActivity(Kamera);
            }
        });

        btnBildirims.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Bildirim = new Intent(BildirimActivity.this , BildirimActivity.class);
                startActivity(Bildirim);
            }
        });

        btnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Account = new Intent(BildirimActivity.this , AccountActivity.class);
                startActivity(Account);
            }
        });
    }
}
