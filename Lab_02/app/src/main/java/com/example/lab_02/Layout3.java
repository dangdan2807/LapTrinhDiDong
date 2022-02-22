package com.example.lab_02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Layout3 extends AppCompatActivity implements View.OnClickListener {
    private Button btnGenerator;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout3);
        context = this;
        btnGenerator = findViewById(R.id.layout3_btnGenerator);

        btnGenerator.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(context, "Coming soon...", Toast.LENGTH_LONG).show();
    }
}