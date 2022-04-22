package com.example.lab_08__firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FaceScreen extends AppCompatActivity {
    private User user;
    private ImageButton btnHappy, btnNormal, btnUnHappy;
    private Button btnFinish;
    private TextView tvName, tvStatus;
    private FirebaseDatabase database;
    private DatabaseReference myRef;
    private String uid;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_face_screen);
        context = this;

        btnHappy = findViewById(R.id.faceA_btnHappy);
        btnNormal = findViewById(R.id.faceA_btnNormal);
        btnUnHappy = findViewById(R.id.faceA_btnUnHappy);
        btnFinish = findViewById(R.id.faceA_btnFinish);


        tvName = findViewById(R.id.faceA_edtName);
        tvStatus = findViewById(R.id.faceA_edtStatus);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("user");

        Intent intent = getIntent();
        if (intent != null) {
            uid = intent.getStringExtra("uid");
            myRef.child(uid).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    user = dataSnapshot.getValue(User.class);
                    tvName.setText(user.getName());
                    tvStatus.setText(user.getStatus());
                }

                @Override
                public void onCancelled(DatabaseError error) {
                }
            });
        }

        btnHappy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String status = "Vui";
                updateStatus(status);
                readingStatus();
            }
        });
        btnNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String status = "Bình thường";
                updateStatus(status);
                readingStatus();
            }
        });
        btnUnHappy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String status = "Không vui";
                updateStatus(status);
                readingStatus();
            }
        });
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                finish();
            }
        });
    }

    private void readingStatus() {
        myRef.child(uid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                user = dataSnapshot.getValue(User.class);
                tvName.setText(user.getName());
                tvStatus.setText(user.getStatus());
            }

            @Override
            public void onCancelled(DatabaseError error) {
            }
        });
    }

    private void updateStatus(String status) {
        DatabaseReference myRef = database.getReference("user");
        myRef.child(uid).child("status").setValue(status);
    }
}