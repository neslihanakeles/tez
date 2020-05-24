package com.example.isikbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class SiparisActivity extends AppCompatActivity {
    private EditText adresYaz, numYaz, isimgir;
    private Button siparis;
    private Toolbar actionbarSiparis;

    FirebaseStorage storage = FirebaseStorage.getInstance();
    StorageReference referans = storage.getReference();
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();

    private void init() {
        actionbarSiparis = findViewById(R.id.actionbarSiparis);
        setSupportActionBar(actionbarSiparis);
        getSupportActionBar().setTitle("Sipariş Onay");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    private void newAdress(String adresYaz, String numYaz, String isimgir) {
        Siparis siparis = new Siparis(adresYaz, numYaz, isimgir);
        myRef.child("adress").child(isimgir).setValue(siparis);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_siparis);
        adresYaz = findViewById(R.id.adresYaz);
        numYaz = findViewById(R.id.numYaz);
        siparis = findViewById(R.id.siparisVer);
        isimgir = findViewById(R.id.isimgir);
        init();
        siparis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getadres = adresYaz.getText().toString();
                String getnum = numYaz.getText().toString();
                String getisimgir = isimgir.getText().toString();


                newAdress(getadres, getnum,getisimgir);
                Toast.makeText(SiparisActivity.this, "Sipariş Alındı", Toast.LENGTH_LONG).show();

                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                Notification.Builder builder = new Notification.Builder(SiparisActivity.this);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    builder.setChannelId("com.isikbook");
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    NotificationChannel channel = new NotificationChannel(
                            "com.isikbook",
                            "My App",
                            NotificationManager.IMPORTANCE_DEFAULT
                    );
                    if (manager != null) {
                        manager.createNotificationChannel(channel);
                    }
                    builder.setContentTitle("Bildirim");
                    builder.setContentText("Siparişiniz Alındı!");
                    builder.setSmallIcon(R.drawable.kargoicon);
                    builder.setAutoCancel(true);
                    builder.setTicker("Bildirim Var");

                    Intent intent = new Intent(SiparisActivity.this, AnaekranActivity.class);
                    PendingIntent pendingIntent = PendingIntent.getActivity(SiparisActivity.this, 1, intent, 0);
                    builder.setContentIntent(pendingIntent);

                    Notification notification = builder.getNotification();
                    manager.notify(2, builder.build());

                    Intent siparis = new Intent(SiparisActivity.this , AnaekranActivity.class);
              startActivity(siparis);
                }
            }
        });
    }
}