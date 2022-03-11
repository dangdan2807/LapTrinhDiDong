package com.example.lab_04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnA, btnB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnA = findViewById(R.id.mainLayout_btnA);
        btnB = findViewById(R.id.mainLayout_btnB);

        btnA.setOnClickListener(this);
        btnB.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mainLayout_btnA:
                Intent layoutA = new Intent(MainActivity.this, Layout4a.class);
                startActivity(layoutA);
                break;
            case R.id.mainLayout_btnB:
                Intent layoutB = new Intent(MainActivity.this, Layout4b.class);
                startActivity(layoutB);
                break;
        }
    }
}