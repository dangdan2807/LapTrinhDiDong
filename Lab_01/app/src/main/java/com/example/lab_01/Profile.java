package com.example.lab_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Profile extends AppCompatActivity implements View.OnClickListener {
    private Button btnPortfolio, btnHireMe;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        context = this;

        btnPortfolio = findViewById(R.id.layoutProfile_btnPortfolio);
        btnHireMe = findViewById(R.id.layoutProfile_btnHireMe);

        btnPortfolio.setOnClickListener(this);
        btnHireMe.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(context, "Coming soon...", Toast.LENGTH_LONG).show();
    }
}