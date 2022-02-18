package com.example.lab_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Layout_3 extends AppCompatActivity {
    private Button btnVerifyCode;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout3);
        btnVerifyCode = findViewById(R.id.layout3_btnVerifyCode);
        context = this;
        btnVerifyCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Coming soon...", Toast.LENGTH_LONG).show();
            }
        });
    }
}