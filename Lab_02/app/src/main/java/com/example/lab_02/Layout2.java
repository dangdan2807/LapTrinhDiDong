package com.example.lab_02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Layout2 extends AppCompatActivity implements View.OnClickListener {
    private Button btnAddImg, btnSend;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout2);
        context = this;
        btnAddImg = findViewById(R.id.layout2_btnAddImg);
        btnSend = findViewById(R.id.layout2_btnSend);

        btnAddImg.setOnClickListener(this);
        btnSend.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(context, "Coming soon...", Toast.LENGTH_LONG).show();
    }
}