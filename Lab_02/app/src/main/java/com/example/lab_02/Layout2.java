package com.example.lab_02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class Layout2 extends AppCompatActivity implements View.OnClickListener {
    private Button btnAddImg, btnSend;
    private RatingBar ratingBar;
    private EditText edtReview;
    private Context context;
    private int SELECT_PICTURE = 200;
    private TextView tvReview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout2);
        context = this;
        btnAddImg = findViewById(R.id.layout2_btnAddImg);
        btnSend = findViewById(R.id.layout2_btnSend);
        edtReview = findViewById(R.id.layout2_edtReview);
        ratingBar = findViewById(R.id.layout2_ratingBar);
        tvReview = findViewById(R.id.layout2_tvReview);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                double rating = ratingBar.getRating();
                String content = "";
                if (rating >= 5.0) {
                    content = "Cực kỳ hài lòng";
                } else if (rating >= 4.0 && rating < 5.0) {
                    content = "Hài lòng";
                } else if (rating >= 3.0 && rating < 4.0) {
                    content = "Bình thường";
                } else if (rating >= 2.0 && rating < 3.0) {
                    content = "Không hài lòng";
                } else if (rating >= 1.0 && rating < 2.0) {
                    content = "Tệ";
                } else if (rating < 1.0) {
                    content = "Rất Tệ";
                }
                tvReview.setText(content);
            }
        });

        btnAddImg.setOnClickListener(this);
        btnSend.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Object o = view;
        if (o.equals(btnAddImg)) {
            imageChooser();
        } else if (o.equals(btnSend)) {
            double rating = ratingBar.getRating();
            String comment = edtReview.getText().toString();
            if (rating == 0.0) {
                showMessages("Vui lòng đánh giá sao");
            }
            if (comment.isEmpty()) {
                showMessages("Hãy để lại cảm nghĩ của bạn về sản phẩm này");
            }
            if (rating > 0.0 && !comment.isEmpty()) {
                showMessages("Đánh giá sản phẩm thành công");
            }
        }
    }

    private void showMessages(String messages) {
        Toast.makeText(context, messages, Toast.LENGTH_LONG).show();
    }

    private void imageChooser() {
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE);
    }
}