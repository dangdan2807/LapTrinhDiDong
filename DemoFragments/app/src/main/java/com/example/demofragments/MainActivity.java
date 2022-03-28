package com.example.demofragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btnSendData;
    private EditText edtData;
    private TextView tv;

    private String mData = "";
    private FragmentB fragmentB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSendData = findViewById(R.id.main_btnSendData);
        edtData = findViewById(R.id.main_edtData);
        tv = findViewById(R.id.main_tv);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        FragmentA fragmentA = new FragmentA();
//        c1: trường hợp thêm fragment trực tiếp vào layout (fragment trước đó phải không có trong layout)
//        Bundle b = new Bundle();
//        b.putString("data", data);
//        fragmentA.setArguments(b);
//        fragmentTransaction.add(R.id.main_linearLayout, fragmentA);
//
//        c2: fragment đã có trong ui main
        fragmentTransaction.replace(R.id.fragment_a, fragmentA);

        fragmentTransaction.commit();
        btnSendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mData = edtData.getText().toString().trim();
                fragmentA.getEdtData().setText(mData);
            }
        });
    }

    public String getData() {
        return mData;
    }

    public TextView getTv() {
        return tv;
    }

    public void setTv(TextView tv) {
        this.tv = tv;
    }
}