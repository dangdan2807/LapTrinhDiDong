package com.example.lap_06;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class ShoeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoe);

        ShoeFragment shoeFragment = new ShoeFragment();
        getSupportFragmentManager().beginTransaction()
            .add(R.id.fragment_shoe, shoeFragment, "shoeFragment")
            .commit();
    }
}