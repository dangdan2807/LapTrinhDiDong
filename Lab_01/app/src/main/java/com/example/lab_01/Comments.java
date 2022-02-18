package com.example.lab_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Comments extends AppCompatActivity implements View.OnClickListener {
    private Button btnAddImg, btnSubmit;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);
        btnAddImg = findViewById(R.id.layoutComment_btnAddImg);
        btnSubmit = findViewById(R.id.layoutComment_btnSubmit);

        context = this;

        btnAddImg.setOnClickListener(this);
        btnSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(context, "Coming soon...", Toast.LENGTH_LONG).show();
    }
}