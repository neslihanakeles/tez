package com.example.isikbook;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
public class AccountActivity extends AppCompatActivity {

    private Toolbar actionbarAccount;
    private Button btnCikis,  btnSettings, txt8, txt9;


public void init() {
        actionbarAccount = findViewById(R.id.actionbarAccount);
        setSupportActionBar(actionbarAccount);
        getSupportActionBar().setTitle("Hesabım");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        btnCikis = findViewById(R.id.logoutB);
        btnSettings = findViewById(R.id.settingsB);
        txt8 = findViewById(R.id.text8);
        txt9 = findViewById(R.id.text9);
        init();

        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Ayarlar = new Intent(AccountActivity.this, SettingsActivity.class);
                startActivity(Ayarlar);
            }
        });

        txt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent txt8txt = new Intent(AccountActivity.this, SettingsActivity.class);
                startActivity(txt8txt);
            }
        });

        txt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logOutIntent = new Intent(AccountActivity.this, MainActivity.class);
                startActivity(logOutIntent);
                finish();
            }
        });

        btnCikis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logOutIntent = new Intent(AccountActivity.this, MainActivity.class);
                startActivity(logOutIntent);
                finish();
            }
        });

    }

}


