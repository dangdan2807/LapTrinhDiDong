package com.example.lab_03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnTiki;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTiki = findViewById(R.id.main_btn1);

        btnTiki.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Object o = view;
        if(o.equals(btnTiki)) {
            Intent i = new Intent(MainActivity.this, Layout3A.class);
            startActivity(i);
        }
    }
}