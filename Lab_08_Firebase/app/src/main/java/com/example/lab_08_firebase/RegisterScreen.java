package com.example.lab_08_firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterScreen extends AppCompatActivity {
    private EditText edtName, edtEmail, edtPassword, edtRePassword;
    private Button btnSignUp, btnRegisterGoogle, btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_screen);

        edtName = findViewById(R.id.RegisterA_edtName);
        edtEmail = findViewById(R.id.RegisterA_edtEmail);
        edtPassword = findViewById(R.id.RegisterA_edtPassword);
        edtRePassword = findViewById(R.id.RegisterA_edtRePassword);
        btnSignUp = findViewById(R.id.RegisterA_btnSignUp);
        btnRegisterGoogle = findViewById(R.id.RegisterA_btnRegisterGoogle);
        btnSignIn = findViewById(R.id.RegisterA_btnSignIn);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(RegisterScreen.this, SignInScreen.class);
                startActivity(i);
            }
        });
    }
}