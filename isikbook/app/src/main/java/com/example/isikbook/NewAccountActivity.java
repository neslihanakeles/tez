package com.example.isikbook;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class NewAccountActivity extends AppCompatActivity {
    private Toolbar actionbarNewAccount;
    private EditText txtUsername, txtEmail, txtPassword;
    private Button btnHesapOlustur;
    private FirebaseAuth auth;

    public void init() {

        Toolbar actionbarNewAccount = findViewById(R.id.actionbarNewAccount);
        setSupportActionBar(actionbarNewAccount);
        getSupportActionBar().setTitle("Hesap Oluştur");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        auth = FirebaseAuth.getInstance();

        txtUsername = findViewById(R.id.username);
        txtEmail = findViewById(R.id.mail);
        txtPassword = findViewById(R.id.password);
        btnHesapOlustur = findViewById(R.id.btnOlustur);

    }

    private void createNewAccount() {

        String username = txtUsername.getText().toString();
        String email = txtEmail.getText().toString();
        String password = txtPassword.getText().toString();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, " Boş alanı doldurun !", Toast.LENGTH_LONG).show();
        } else if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, " Boş alanı doldurun !", Toast.LENGTH_LONG).show();
        } else {
            auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {

                        Toast.makeText(NewAccountActivity.this, "Hesabınız oluşturuldu !", Toast.LENGTH_LONG).show();
                        Intent LoginIntent = new Intent(NewAccountActivity.this, AnaekranActivity.class);
                        startActivity(LoginIntent);
                        finish();

                    } else {

                        Toast.makeText(NewAccountActivity.this, "Bir hata oluştu!", Toast.LENGTH_LONG).show();

                    }
                }
            });
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_account);
        init();

        btnHesapOlustur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNewAccount();

            }
        });


    }
}