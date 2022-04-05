package com.example.demosqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileInputStream;

public class MainActivity extends AppCompatActivity {
    private Button btn;
    private EditText edt;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);
        edt = findViewById(R.id.edt);
        tv = findViewById(R.id.tv);
        SharedPreferences sharedPreferences = this.getSharedPreferences("MyData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name", "Đan");
        editor.commit();

        FileInputStream inputStream = null;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = edt.getText().toString();
                try {
//                    inputStream = new FileInputStream("MyData.txt", Context.MODE_PRIVATE);

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }
}