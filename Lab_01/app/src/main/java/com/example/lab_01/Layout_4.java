package com.example.lab_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Layout_4 extends AppCompatActivity implements View.OnClickListener {
    private Button btnLogin, btnFacebook, btnZalo, btnGoogle, btnForgotPassword;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout4);
        context = this;

        btnLogin = findViewById(R.id.layout4_btnLogin);
        btnFacebook = findViewById(R.id.layout4_btnFacebook);
        btnZalo = findViewById(R.id.layout4_btnZalo);
        btnGoogle = findViewById(R.id.layout4_btnGoogle);
        btnForgotPassword = findViewById(R.id.layout4_btnForgotPassword);

        btnLogin.setOnClickListener(this);
        btnFacebook.setOnClickListener(this);
        btnZalo.setOnClickListener(this);
        btnGoogle.setOnClickListener(this);
        btnForgotPassword.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(context, "Coming soon...", Toast.LENGTH_LONG).show();
    }
}