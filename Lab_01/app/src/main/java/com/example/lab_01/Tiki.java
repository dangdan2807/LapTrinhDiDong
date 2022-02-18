package com.example.lab_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.StrikethroughSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class Tiki extends AppCompatActivity implements View.OnClickListener {
    private Button btnSubtract, btnMulti, btnBuyLater, btnSeeHere, btnVoucher, btnApply, btnEnterHere, btnOrder;
    private Context context;
    private TextView tvCountOrderProduct, tvOldPrice, tvTotalPrice, tvTempPayment, tvPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiki);
        context = this;

        btnMulti = findViewById(R.id.layoutTiki_btnMulti);
        btnSubtract = findViewById(R.id.layoutTiki_btnSubtract);
        btnBuyLater = findViewById(R.id.layoutTiki_btnBuyLater);
        btnSeeHere = findViewById(R.id.layoutTiki_btnSeeHere);
        btnVoucher = findViewById(R.id.layoutTiki_btnVoucher);
        btnApply = findViewById(R.id.layoutTiki_btnApply);
        btnEnterHere = findViewById(R.id.layoutTiki_btnEnterHere);
        btnOrder = findViewById(R.id.layoutTiki_btnOrder);

        tvCountOrderProduct = findViewById(R.id.layoutTiki_tvCountOrder);
        tvOldPrice = findViewById(R.id.layoutTiki_tvOldPrice);
        tvTempPayment = findViewById(R.id.layoutTiki_tvTempPayment);
        tvTotalPrice = findViewById(R.id.layoutTiki_tvTotalPrice);
        tvPrice = findViewById(R.id.layoutTiki_tvPrice);

        tvOldPrice.setPaintFlags(tvOldPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        btnMulti.setOnClickListener(this);
        btnSubtract.setOnClickListener(this);
        btnBuyLater.setOnClickListener(this);
        btnSeeHere.setOnClickListener(this);
        btnVoucher.setOnClickListener(this);
        btnApply.setOnClickListener(this);
        btnEnterHere.setOnClickListener(this);
        btnOrder.setOnClickListener(this);
    }

    private void changeTotalPrice(int countOrderProduct) {
        String priceStr = tvPrice.getText().toString().replaceAll("[/s.đ]", "");
        double price = Double.parseDouble(priceStr);
        double totalPrice = price * countOrderProduct;
        DecimalFormat df = new DecimalFormat("#,###.###");
        tvTempPayment.setText(df.format(totalPrice) + " đ");
        tvTotalPrice.setText(df.format(totalPrice) + " đ");
    }

    @Override
    public void onClick(View view) {
        Object o = view;
        if (o.equals(btnMulti)) {
            int countOrderProduct = Integer.parseInt(tvCountOrderProduct.getText().toString());
            ++countOrderProduct;
            tvCountOrderProduct.setText(countOrderProduct + "");
            changeTotalPrice(countOrderProduct);
        } else if (o.equals(btnSubtract)) {
            int countOrderProduct = Integer.parseInt(tvCountOrderProduct.getText().toString());
            if (countOrderProduct > 1) {
                --countOrderProduct;
            }
            tvCountOrderProduct.setText(countOrderProduct + "");
            changeTotalPrice(countOrderProduct);
        } else if (o.equals(btnBuyLater) || o.equals(btnSeeHere) || o.equals(btnVoucher) ||
                o.equals(btnApply) || o.equals(btnEnterHere) || o.equals(btnOrder)) {
            Toast.makeText(context, "Coming soon...", Toast.LENGTH_LONG).show();
        }
    }
}