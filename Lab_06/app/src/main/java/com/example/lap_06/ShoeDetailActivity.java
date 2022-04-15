package com.example.lap_06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.DecimalFormat;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ShoeDetailActivity extends AppCompatActivity {
    private TextView tvShoeName, tvSole, tvClosure, tvShoeWidth, tvShoePrice;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoe_detail);

        Intent intent = getIntent();
        Shoe shoe = (Shoe) intent.getSerializableExtra("shoe");

        tvShoeName = findViewById(R.id.shoeDetailA_tvShoeName);
        tvSole = findViewById(R.id.shoeDetailA_tvSole);
        tvClosure = findViewById(R.id.shoeDetailA_tvClosure);
        tvShoeWidth = findViewById(R.id.shoeDetailA_tvShoeWidth);
        tvShoePrice = findViewById(R.id.shoeDetailA_tvShoePrice);
        img = findViewById(R.id.shoeDetailA_img);

        img.setImageResource(shoe.getImage());
        tvShoeName.setText(shoe.getName());
        tvSole.setText(shoe.getSole());
        tvClosure.setText(shoe.getClosure());
        tvShoeWidth.setText(shoe.getShoeWidth());
        DecimalFormat df = new DecimalFormat("#,###.##$");
        tvShoePrice.setText(df.format(shoe.getPrice()));
    }
}