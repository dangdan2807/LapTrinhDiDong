package com.example.lab_08_firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FaceScreen extends AppCompatActivity {
    private User user;
    private ImageButton btnHappy, btnNormal, btnUnHappy;
    private TextView tvName, tvStatus;
    private FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_face_screen);

        btnHappy = findViewById(R.id.faceA_btnHappy);
        btnNormal = findViewById(R.id.faceA_btnNormal);
        btnUnHappy = findViewById(R.id.faceA_btnUnHappy);

        tvName = findViewById(R.id.faceA_edtName);
        tvStatus = findViewById(R.id.faceA_edtStatus);

        Intent intent = getIntent();
        if (intent != null) {
            user = (User) intent.getSerializableExtra("user");
            tvName.setText(user.getName());
            tvStatus.setText(user.getStatus());
        }

        database = FirebaseDatabase.getInstance();
        btnHappy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String status = "Vui";
                updateStatus(status);
                String result = readingStatus();
                tvStatus.setText(result);
            }
        });
        btnNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String status = "Bình thường";
                updateStatus(status);
                String result = readingStatus();
                tvStatus.setText(result);
            }
        });
        btnUnHappy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String status = "Không vui";
                updateStatus(status);
                String result = readingStatus();
                tvStatus.setText(result);
            }
        });
    }

    private String readingStatus() {
        final String[] result = {""};
        DatabaseReference myRef = database.getReference("users");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
                result[0] = user.getStatus();
            }

            @Override
            public void onCancelled(DatabaseError error) {
            }
        });
        return result[0];
    }

    private void updateStatus(String status) {
        DatabaseReference myRef = database.getReference("users");
        myRef.child("status").setValue(status);
    }
}