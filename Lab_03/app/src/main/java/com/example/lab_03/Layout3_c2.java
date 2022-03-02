package com.example.lab_03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Layout3_c2 extends AppCompatActivity implements View.OnClickListener {
    private Button btnAquaColor, btnRedColor, btnBlackColor, btnBlueColor, btnSubmit;
    private TextView tvColorName;
    private ImageView imageProduct;
    private String tag = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout3_c2);

        btnAquaColor = findViewById(R.id.layout3C2_btnAquaColor);
        btnRedColor = findViewById(R.id.layout3C2_btnRedColor);
        btnBlackColor = findViewById(R.id.layout3C2_btnBlackColor);
        btnBlueColor = findViewById(R.id.layout3C2_btnBlueColor);
        btnSubmit = findViewById(R.id.layout3C2_btnSubmit);

        tvColorName = findViewById(R.id.layout3C2_tvColorName);

        imageProduct = findViewById(R.id.layout3C2_imageProduct);

        tag = getIntent().getStringExtra("color");
        setImageProduct(tag);

        btnAquaColor.setOnClickListener(this);
        btnRedColor.setOnClickListener(this);
        btnBlackColor.setOnClickListener(this);
        btnBlueColor.setOnClickListener(this);
        btnSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Object o = view;
        if (o.equals(btnAquaColor)) {
            setImageProduct("white");
        } else if (o.equals(btnRedColor)) {
            setImageProduct("red");
        } else if (o.equals(btnBlackColor)) {
            setImageProduct("black");
        } else if (o.equals(btnBlueColor)) {
            setImageProduct("blue");
        } else if (o.equals(btnSubmit)) {
            Intent i = new Intent(Layout3_c2.this, Layout3C.class);
            String tag = imageProduct.getTag().toString();
            i.putExtra("color", tag);
            startActivity(i);
        }
    }

    private void setImageProduct(String tag) {
        if(tag.isEmpty())
            tag = "blue";
        if (tag.equals("white")) {
            tvColorName.setText("Bạc");
            imageProduct.setImageResource(R.drawable.vs_white);
            imageProduct.setTag(tag);
            unlockBtnColor();
            btnAquaColor.setEnabled(false);
        } else if (tag.equals("red")) {
            tvColorName.setText("Đỏ");
            imageProduct.setImageResource(R.drawable.vs_red);
            imageProduct.setTag(tag);
            unlockBtnColor();
            btnRedColor.setEnabled(false);
        } else if (tag.equals("blue")) {
            tvColorName.setText("Xanh dương");
            imageProduct.setImageResource(R.drawable.vs_blue);
            imageProduct.setTag(tag);
            unlockBtnColor();
            btnBlueColor.setEnabled(false);
        } else if (tag.equals("black")) {
            tvColorName.setText("Đen");
            imageProduct.setImageResource(R.drawable.vs_black);
            imageProduct.setTag(tag);
            unlockBtnColor();
            btnBlackColor.setEnabled(false);
        }
    }

    private void unlockBtnColor() {
        btnAquaColor.setEnabled(true);
        btnRedColor.setEnabled(true);
        btnBlueColor.setEnabled(true);
        btnBlackColor.setEnabled(true);
    }
}