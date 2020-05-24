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
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private Toolbar actionbarLogin;
    private EditText txtEmail, txtPassword;
    private Button  btnGirisYap;
    private FirebaseAuth auth;
    public void init(){

        actionbarLogin =  findViewById(R.id.actionbarLogin);
        setSupportActionBar(actionbarLogin);
        getSupportActionBar().setTitle("Giriş Yap");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        auth = FirebaseAuth.getInstance();
        txtEmail = findViewById(R.id.txtmailLogin);
        txtPassword = findViewById(R.id.txtpasswordLogin);
        btnGirisYap = findViewById(R.id.btnGiris);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();

        btnGirisYap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loginUser();
            }
        });
    }

    private void loginUser() {

        String email = txtEmail.getText().toString();
        String password = txtPassword.getText().toString();

        if (TextUtils.isEmpty(email)){

            Toast.makeText(this, "Alan boş olamaz!",Toast.LENGTH_LONG).show();
        } else if(TextUtils.isEmpty(password)){
            Toast.makeText(this, "Alan boş olamaz!",Toast.LENGTH_LONG).show();
        } else{
            auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(LoginActivity.this, "Giriş Başarılı", Toast.LENGTH_LONG).show();
                        Intent anaekranIntent = new Intent(LoginActivity.this, AnaekranActivity.class);
                        startActivity(anaekranIntent);
                        finish();

                    } else {
                        Toast.makeText(LoginActivity.this, "Giriş Başarısız", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }

}