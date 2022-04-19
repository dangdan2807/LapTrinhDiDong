package com.example.lab_08_firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignInScreen extends AppCompatActivity {
    private Button btnSignIn, btnForgotPassword, btnSignInGoogle, btnRegister;
    private EditText edtEmail, edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_screen);

        btnSignIn = findViewById(R.id.signInA_btnSignIn);
        btnForgotPassword = findViewById(R.id.signInA_btnForgotPassword);
        btnSignInGoogle = findViewById(R.id.signInA_btnSignInGoogle);
        btnRegister = findViewById(R.id.signInA_btnRegister);
        edtEmail = findViewById(R.id.signInA_edtEmail);
        edtPassword = findViewById(R.id.signInA_edtPassword);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SignInScreen.this, RegisterScreen.class);
                startActivity(i);
            }
        });
    }
}