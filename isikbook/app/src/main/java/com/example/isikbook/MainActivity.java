package com.example.isikbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnWelcomeLogin, btnWelcomeNewAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnWelcomeLogin = findViewById(R.id.WelcomeLoginBtn);
        btnWelcomeNewAccount = findViewById(R.id.WelcomeNewAccountBtn);

        btnWelcomeLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentLogin = new Intent(MainActivity.this , LoginActivity.class);
                startActivity(intentLogin);
                finish();
            }
        });

        btnWelcomeNewAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentNew = new Intent(MainActivity.this , NewAccountActivity.class);
                startActivity(intentNew);
                finish();
            }
        });
    }
}

