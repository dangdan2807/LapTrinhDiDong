package com.example.lab_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnLayoutA, btnLayoutB, btnLayoutC, btnLayoutD, btnLayoutE;
    private Button btnLayoutComments, btnLayoutTiki, btnLayoutProfile, btnLayoutPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLayoutA = findViewById(R.id.layoutMain_btnLayoutA);
        btnLayoutB = findViewById(R.id.layoutMain_btnLayoutB);
        btnLayoutC = findViewById(R.id.layoutMain_btnLayoutC);
        btnLayoutD = findViewById(R.id.layoutMain_btnLayoutD);
        btnLayoutE = findViewById(R.id.layoutMain_btnLayoutE);
        btnLayoutComments = findViewById(R.id.layoutMain_btnLayoutComment);
        btnLayoutTiki = findViewById(R.id.layoutMain_btnLayoutTiki);
        btnLayoutProfile = findViewById(R.id.layoutMain_btnLayoutProfile);
        btnLayoutPassword = findViewById(R.id.layoutMain_btnLayoutPassword);
        setEventClick();
    }

    private void setEventClick() {
        btnLayoutA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Layout_1.class);
                startActivity(i);
            }
        });

        btnLayoutB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Layout_2.class);
                startActivity(i);
            }
        });

        btnLayoutC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Layout_3.class);
                startActivity(i);
            }
        });

        btnLayoutD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Layout_4.class);
                startActivity(i);
            }
        });

        btnLayoutE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Layout_5.class);
                startActivity(i);
            }
        });
        btnLayoutComments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Comments.class);
                startActivity(i);
            }
        });
        btnLayoutPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, PasswordGenerator.class);
                startActivity(i);
            }
        });
        btnLayoutProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Profile.class);
                startActivity(i);
            }
        });
        btnLayoutTiki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Tiki.class);
                startActivity(i);
            }
        });
    }
}