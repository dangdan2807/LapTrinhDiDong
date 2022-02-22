package com.example.lab_02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnLayoutA, btnLayoutB, btnLayoutC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLayoutA = findViewById(R.id.layoutMain_btn1);
        btnLayoutB = findViewById(R.id.layoutMain_btn2);
        btnLayoutC = findViewById(R.id.layoutMain_btn3);
        btnLayoutA.setOnClickListener(this);
        btnLayoutB.setOnClickListener(this);
        btnLayoutC.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Object o = view;
        if (o.equals(btnLayoutA)) {
            Intent i = new Intent(MainActivity.this, Layout1.class);
            startActivity(i);
        } else if (o.equals(btnLayoutB)) {
            Intent i = new Intent(MainActivity.this, Layout2.class);
            startActivity(i);
        } else if (o.equals(btnLayoutC)) {
            Intent i = new Intent(MainActivity.this, Layout3.class);
            startActivity(i);
        }
    }
}