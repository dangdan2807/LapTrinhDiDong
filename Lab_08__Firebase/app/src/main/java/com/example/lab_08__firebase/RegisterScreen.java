package com.example.lab_08__firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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

public class RegisterScreen extends AppCompatActivity {
    private EditText edtName, edtEmail, edtPassword, edtRePassword;
    private Button btnSignUp, btnRegisterGoogle, btnSignIn;
    private Context context;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_screen);
        context = this;

        mAuth = FirebaseAuth.getInstance();

        edtName = findViewById(R.id.registerA_edtName);
        edtEmail = findViewById(R.id.registerA_edtEmail);
        edtPassword = findViewById(R.id.registerA_edtPassword);
        edtRePassword = findViewById(R.id.registerA_edtRePassword);

        btnSignUp = findViewById(R.id.registerA_btnSignUp);
        btnRegisterGoogle = findViewById(R.id.registerA_btnRegisterGoogle);
        btnSignIn = findViewById(R.id.registerA_btnSignIn);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean result = register();
            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(RegisterScreen.this, SignInScreen.class);
                startActivity(i);
            }
        });

    }

    private boolean register() {
        String name = edtName.getText().toString().trim();
        String email = edtEmail.getText().toString().trim();
        String password = edtPassword.getText().toString().trim();
        String rePassword = edtRePassword.getText().toString().trim();
        if (name.isEmpty() || name.length() <= 0) {
            Toast.makeText(context, "Name không được để trống", Toast.LENGTH_LONG).show();
            return false;
        }
        if (email.isEmpty() || email.length() <= 0) {
            Toast.makeText(context, "Email không được để trống", Toast.LENGTH_LONG).show();
            return false;
        }
        if (password.isEmpty() || password.length() <= 0) {
            Toast.makeText(context, "Password không được để trống", Toast.LENGTH_LONG).show();
            return false;
        }
        if (rePassword.isEmpty() || rePassword.length() <= 0) {
            Toast.makeText(context, "Password nhập lại không được để trống", Toast.LENGTH_LONG).show();
            return false;
        }
        if (!password.equals(rePassword)) {
            Toast.makeText(context, "Password không giống nhau", Toast.LENGTH_LONG).show();
            return false;
        }

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            String uid = mAuth.getCurrentUser().getUid();
                            FirebaseDatabase database = FirebaseDatabase.getInstance();
                            DatabaseReference myRef = database.getReference("user");
                            User user = new User(name, email, password);
                            myRef.child(uid).setValue(user);
                            Toast.makeText(context, "Đăng ký tài khoản thành công", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(context, "Đăng ký tài khoản thất bại", Toast.LENGTH_LONG).show();
                        }
                    }
                });

        return true;
    }
}