package com.example.lab_08_firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_screen);
        context = this;

        database = FirebaseDatabase.getInstance();

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
                    DatabaseReference myRef = database.getReference("users");
                    myRef.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            user = dataSnapshot.getValue(User.class);
                            Toast.makeText(context, "Đăng nhập thành công", Toast.LENGTH_LONG).show();
                            Intent i = new Intent(SignInScreen.this, FaceScreen.class);
                            i.putExtra("user", user);
                            startActivity(i);
                        }

                        @Override
                        public void onCancelled(DatabaseError error) {
                            Toast.makeText(context, "Đăng nhập thất bại", Toast.LENGTH_LONG).show();
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