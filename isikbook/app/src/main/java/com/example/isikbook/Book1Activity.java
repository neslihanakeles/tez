package com.example.isikbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;


public class Book1Activity extends AppCompatActivity {
private Button btnSiparis;
    private Toolbar actionbarBook1;
    private void init() {

        btnSiparis = findViewById(R.id.btnSiparis);

        actionbarBook1 = findViewById(R.id.actionbarBook1);
        setSupportActionBar(actionbarBook1);
        getSupportActionBar().setTitle("Book1");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

}

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book1);
        init();


        btnSiparis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent siparis= new Intent(Book1Activity.this,SiparisActivity.class);
                startActivity(siparis);
            }
        });
    }


}
