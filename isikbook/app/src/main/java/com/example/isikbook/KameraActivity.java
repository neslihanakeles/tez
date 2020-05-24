package com.example.isikbook;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class KameraActivity extends AppCompatActivity {
    FirebaseStorage storage = FirebaseStorage.getInstance();
    StorageReference referans = storage.getReference();
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    private Toolbar actionbarKamera;
    private Button fotoSecbtn, yYukle;
    private EditText kitap_ad, yazar,fiyat,  ders;
    private ImageView img_book;
    private void init() {
        kitap_ad = findViewById(R.id.kitap_ad);
        fiyat = findViewById(R.id.fiyat);
        ders = findViewById(R.id.ders);
        yazar = findViewById(R.id.yazar);

        actionbarKamera = findViewById(R.id.actionbarKamera);
        setSupportActionBar(actionbarKamera);
        getSupportActionBar().setTitle("Kamera");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
private  void newBook(String kitap_ad, String yazar, String ders, String fiyat) {
    Books books = new Books(kitap_ad, yazar, ders, fiyat);
    myRef.child("books").child(kitap_ad).setValue(books);
}
 @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kamera);
        fotoSecbtn = findViewById(R.id.fotoSecc);
        yYukle = findViewById(R.id.yukle);
        img_book = findViewById(R.id.img_picture);
        init();
        fotoSecbtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK);
                i.setType("image/*");
                startActivityForResult(i, 1); }
        });

        yYukle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            String getkitap_ad = kitap_ad.getText().toString();
            String getyazar = yazar.getText().toString();
            String getders = ders.getText().toString();
            String getfiyat = fiyat.getText().toString();

            newBook(getkitap_ad ,getyazar ,getders,getfiyat);
            Toast.makeText(KameraActivity.this, "Yüklendi", Toast.LENGTH_LONG).show(); }
    } ); }

@Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1 && resultCode==RESULT_OK){
            Uri uri = data.getData();
            ImageView img_picture = findViewById(R.id.img_picture);
            img_picture.setImageURI(uri);
            StorageReference ref = referans.child(uri.getLastPathSegment());
            ref.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                }
            });

        } }}


