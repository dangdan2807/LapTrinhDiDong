package com.example.lab_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Layout_1 extends AppCompatActivity implements View.OnClickListener {
    private Button btnLogin, btnSignUp;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout1);

        btnLogin = findViewById(R.id.layout1_btnLogin);
        btnSignUp = findViewById(R.id.layout1_btnSignUp);
        context = this;
        btnLogin.setOnClickListener(this);
        btnSignUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(context, "Coming soon...", Toast.LENGTH_LONG).show();
    }
}