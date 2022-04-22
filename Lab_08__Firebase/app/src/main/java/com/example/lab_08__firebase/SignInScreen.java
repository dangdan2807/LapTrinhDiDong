package com.example.lab_08__firebase;

import androidx.annotation.NonNull;
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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignInScreen extends AppCompatActivity {
    private Button btnSignIn, btnForgotPassword, btnSignInGoogle, btnRegister;
    private EditText edtEmail, edtPassword;
    private Context context;
    private FirebaseDatabase database;
    private FirebaseAuth auth;
    private User user;
    private boolean flagHidePass = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_screen);
        context = this;

        database = FirebaseDatabase.getInstance();
        auth = FirebaseAuth.getInstance();

        btnSignIn = findViewById(R.id.signInA_btnSignIn);
        btnForgotPassword = findViewById(R.id.signInA_btnForgotPassword);
        btnSignInGoogle = findViewById(R.id.signInA_btnSignInGoogle);
        btnRegister = findViewById(R.id.signInA_btnRegister);

        edtEmail = findViewById(R.id.signInA_edtEmail);
        edtPassword = findViewById(R.id.signInA_edtPassword);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edtEmail.getText().toString();
                String password = edtPassword.getText().toString();
                boolean result = checkData(email, password);
                if(result) {
                    auth.signInWithEmailAndPassword(email, password)
                            .addOnCompleteListener(SignInScreen.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful()) {
                                        Toast.makeText(context, "Đăng nhập thành công", Toast.LENGTH_LONG).show();
                                        Intent intent = new Intent(SignInScreen.this, FaceScreen.class);
                                        intent.putExtra("uid", auth.getCurrentUser().getUid());
                                        startActivity(intent);
                                    } else {
                                        Toast.makeText(context, "Tài khoản/ mật khẩu không đúng", Toast.LENGTH_LONG).show();
                                    }
                                }
                            });
                }
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SignInScreen.this, RegisterScreen.class);
                startActivity(i);
            }
        });

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
    }

    public boolean checkData(String email, String password) {
        if(email.isEmpty() || email.length() <= 0) {
            Toast.makeText(context, "Email không được để trống", Toast.LENGTH_LONG).show();
            return false;
        }
        if(password.isEmpty() || password.length() <= 0) {
            Toast.makeText(context, "Mật khẩu không được để trống", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }
}