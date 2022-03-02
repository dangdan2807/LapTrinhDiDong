package com.example.lab_03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class Layout3C extends AppCompatActivity implements View.OnClickListener {
    private TextView tvOldPrice;
    private Button btnBuy, btnChooseColor;
    private RatingBar ratingBar;
    private ImageView imageProduct;
    private String tag = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout3_c);

        btnBuy = findViewById(R.id.layout3C_btnBuy);
        btnChooseColor = findViewById(R.id.layout3C_btnChooseColor);
        ratingBar = findViewById(R.id.layout3C_ratingBar);

        tvOldPrice = findViewById(R.id.layout3C_tvOldPrice);
        imageProduct = findViewById(R.id.layout3C_imageProduct);

        ratingBar.setRating(4);
        ratingBar.setEnabled(false);
        tvOldPrice.setPaintFlags(tvOldPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        tag = getIntent().getStringExtra("color");
        setImageProduct(tag);

        btnChooseColor.setOnClickListener(this);
        btnBuy.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Object o = view;
        if (o.equals(btnBuy)) {
            Toast.makeText(this, "Đã thêm sản phẩm vào giỏ hàng thành công", Toast.LENGTH_LONG).show();
        } else if (o.equals(btnChooseColor)) {
            Intent i = new Intent(Layout3C.this, Layout3_c2.class);
            String tag = imageProduct.getTag().toString();
            i.putExtra("color", tag);
            startActivity(i);
        }
    }

    private void setImageProduct(String tag) {
        if(tag.isEmpty())
            tag = "blue";
        if (tag.equals("white")) {
            imageProduct.setImageResource(R.drawable.vs_white);
            imageProduct.setTag(tag);
        } else if (tag.equals("red")) {
            imageProduct.setImageResource(R.drawable.vs_red);
            imageProduct.setTag(tag);
        } else if (tag.equals("blue")) {
            imageProduct.setImageResource(R.drawable.vs_blue);
            imageProduct.setTag(tag);
        } else if (tag.equals("black")) {
            imageProduct.setImageResource(R.drawable.vs_black);
            imageProduct.setTag(tag);
        }
    }
}