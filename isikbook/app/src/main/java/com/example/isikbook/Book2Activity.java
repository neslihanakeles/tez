package com.example.isikbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;


public class Book2Activity extends AppCompatActivity {
    private Button btnsiparis;
    private Toolbar actionbarBook2;
    private void init() {
        actionbarBook2 = findViewById(R.id.actionbarBook2);
        setSupportActionBar(actionbarBook2);
        getSupportActionBar().setTitle("Book2");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book2);
        btnsiparis = findViewById(R.id.btnsiparis);
        init();


        btnsiparis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent siparis= new Intent(Book2Activity.this,SiparisActivity.class);
                startActivity(siparis);
            }
        });
    }


}
