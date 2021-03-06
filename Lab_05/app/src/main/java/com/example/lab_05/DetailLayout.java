package com.example.lab_05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class DetailLayout extends AppCompatActivity implements View.OnClickListener {
    private ImageView imgProduct;
    private TextView tvProductName, tvProductDesc, tvProductPrice, tvOrderQuantity;
    private Button btnAddToCard;
    private ImageButton btnMinus, btnPlus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_layout);

        imgProduct = findViewById(R.id.detail_imgProduct);
        tvProductName = findViewById(R.id.detail_tvProductName);
        tvProductDesc = findViewById(R.id.detail_tvProductDesc);
        tvProductPrice = findViewById(R.id.detail_tvProductPrice);
        tvOrderQuantity = findViewById(R.id.detail_tvOrderQuantity);
        btnAddToCard = findViewById(R.id.detail_btnAddToCard);
        btnMinus = findViewById(R.id.detail_ibtnMinus);
        btnPlus = findViewById(R.id.detail_ibtnPlus);

        Intent intent = getIntent();
        if (intent != null) {
            Product product = (Product) intent.getSerializableExtra("product");
            tvProductName.setText(product.getName());
            tvProductDesc.setText(product.getDesc());
            double price = product.getPrice();
            DecimalFormat df = new DecimalFormat("$#,###.00");
            tvProductPrice.setText(df.format(price));
            String imageName = product.getImageName();
            setImageProduct(imageName != null ? imageName : "");
        }

        btnAddToCard.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnPlus.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String quantityStr = "";
        switch (view.getId()) {
            case R.id.detail_ibtnPlus:
                quantityStr = tvOrderQuantity.getText().toString();
                if (!quantityStr.isEmpty() || quantityStr != null) {
                    int quantity = Integer.parseInt(quantityStr);
                    tvOrderQuantity.setText(++quantity + "");
                }
                break;
            case R.id.detail_ibtnMinus:
                quantityStr = tvOrderQuantity.getText().toString();
                if (!quantityStr.isEmpty() || quantityStr != null) {
                    int quantity = Integer.parseInt(quantityStr);
                    if (quantity > 1)
                        tvOrderQuantity.setText(--quantity + "");
                }
                break;
            default:
                Toast.makeText(this, "Coming soon ...", Toast.LENGTH_LONG).show();
                break;
        }
    }

    private void setImageProduct(String imageName) {
        switch (imageName) {
            case "donut_red":
                imgProduct.setImageResource(R.drawable.donut_red);
                break;
            case "donut_yellow":
                imgProduct.setImageResource(R.drawable.donut_yellow);
                break;
            case "green_donut":
                imgProduct.setImageResource(R.drawable.green_donut);
                break;
            case "tasty_donut":
                imgProduct.setImageResource(R.drawable.tasty_donut);
                break;
            default:
                break;
        }
    }
}