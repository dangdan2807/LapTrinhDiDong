package com.example.lab_02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Layout1 extends AppCompatActivity implements View.OnClickListener {
    private Button btnLogin, btnForgotPassword;
    private EditText edtName, edtPassword;
    private Context context;
    private boolean flagHidePass = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout1);
        context = this;
        btnLogin = findViewById(R.id.layout1_btnLogin);
        btnForgotPassword = findViewById(R.id.layout1_btnForgotPassword);
        edtName = findViewById(R.id.layout1_edtName);
        edtPassword = findViewById(R.id.layout1_edtPassword);

        edtPassword.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int DRAWABLE_LEFT = 0;
                final int DRAWABLE_TOP = 1;
                final int DRAWABLE_RIGHT = 2;
                final int DRAWABLE_BOTTOM = 3;

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (event.getRawX() >= (edtPassword.getRight() - edtPassword.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                        if (flagHidePass) {
                            edtPassword.setInputType(InputType.TYPE_TEXT_VARIATION_NORMAL);
                            flagHidePass = false;
                        } else {
                            edtPassword.setInputType(129);
                            flagHidePass = true;
                        }
                        return true;
                    }
                }
                return false;
            }
        });

        btnLogin.setOnClickListener(this);
        btnForgotPassword.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Object o = view;
        if (o.equals(btnLogin)) {
            String name = edtName.getText().toString();
            String password = edtPassword.getText().toString();
            boolean result = login(name, password);
            if (result)
                showMessages("Đăng nhập thành công");
        } else if (o.equals(btnForgotPassword))
            Toast.makeText(context, "Coming soon...", Toast.LENGTH_LONG).show();
    }

    private void showMessages(String messages) {
        Toast.makeText(context, messages, Toast.LENGTH_LONG).show();
    }

    private boolean login(String name, String password) {
        if (name.isEmpty()) {
            showMessages("Tên không được để trống");
            return false;
        }
        if (password.isEmpty()) {
            showMessages("Mật khẩu không được để trống");
            return false;
        }
        if (!(name.equals("admin") && password.equals("admin"))) {
            showMessages("Tên đăng nhập hoặc mật khẩu không đúng");
            return false;
        }
        return true;
    }
}