package com.example.isikbook;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
public class KitapActivity extends AppCompatActivity {

    FirebaseStorage storage = FirebaseStorage.getInstance();
    StorageReference referans = storage.getReference();
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    DatabaseReference oku = FirebaseDatabase.getInstance().getReference().child("books");
    private EditText kitap_ad, yazar,fiyat,  ders;
    private ImageButton book1, book2;
    private Toolbar actionbarOkumaKitap;
    private Button btnMenuBtn, btnHome, btnKamera, btnBildirims, btnAccount ;
    private EditText adresYaz, numYaz;
    private void init() {
        actionbarOkumaKitap = findViewById(R.id.actionbarOkumaKitap);
        setSupportActionBar(actionbarOkumaKitap);
        getSupportActionBar().setTitle("Kitaplar");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitap);
        btnMenuBtn = findViewById(R.id.btnMenu);
        btnHome = findViewById(R.id.button_home);
        btnKamera = findViewById(R.id.button_camera);
        btnBildirims = findViewById(R.id.button_bildirim);
        btnAccount = findViewById(R.id.button_account);
        book1 = findViewById(R.id.book1);
        book2 = findViewById(R.id.book2);
        init();

        book1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent siparis1 = new Intent(KitapActivity.this, Book1Activity.class);
                startActivity(siparis1);
            }
//                ValueEventListener dinle = new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                        Books k = new Books();
//                        k = dataSnapshot.getValue(Books.class);
//
//                        tw.setText(k.kitap_ad + "" + k.yazar + "" + k.ders + "" + k.fiyat);
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError databaseError) {
//                        Toast.makeText(KitapActivity.this, "Bir sorun oluştu", Toast.LENGTH_LONG).show();
//                    }
//                };
//                oku.addValueEventListener(dinle);
//            }
        });
        book2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent siparis2 = new Intent(KitapActivity.this, Book2Activity.class);
                startActivity(siparis2);
            }
//                ValueEventListener dinle = new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                        Books k = new Books();
//                        k = dataSnapshot.getValue(Books.class);
//
//                        tw.setText(k.kitap_ad + "" + k.yazar + "" + k.ders + "" + k.fiyat);
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError databaseError) {
//                        Toast.makeText(KitapActivity.this, "Bir sorun oluştu", Toast.LENGTH_LONG).show();
//                    }
//                };
//                oku.addValueEventListener(dinle);
//            }
        });
        btnMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Menu = new Intent(KitapActivity.this, MenuActivity.class);
                startActivity(Menu);
            }
        });
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Home = new Intent(KitapActivity.this, AnaekranActivity.class);
                startActivity(Home);
            }
        });

        btnKamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Kamera = new Intent(KitapActivity.this, KameraActivity.class);
                startActivity(Kamera);
            }
        });

        btnBildirims.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Bildirim = new Intent(KitapActivity.this, BildirimActivity.class);
                startActivity(Bildirim);
            }
        });

        btnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Account = new Intent(KitapActivity.this, AccountActivity.class);
                startActivity(Account);
            }
        });
    }}