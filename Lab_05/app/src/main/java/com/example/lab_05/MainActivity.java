package com.example.lab_05;

import static android.graphics.Color.parseColor;

import static com.example.lab_05.R.color.black;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnDonut, btnPinkDonut, btnFloating;
    private ImageButton btnSearch;
    private List<Product> productList;
    private ListView listView;
    private ProductAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSearch = findViewById(R.id.main_btnSearch);
        btnDonut = findViewById(R.id.main_btnDonut);
        btnPinkDonut = findViewById(R.id.main_btnPinkDonut);
        btnFloating = findViewById(R.id.main_btnFloating);
        listView = findViewById(R.id.main_lvProduct);

        productList = new ArrayList<>();
        productList.add(new Product("Tasty Donut", 10.0, "donut_yellow", "Spicy tasty donut family"));
        productList.add(new Product("Pink Donut", 20.0, "tasty_donut", "Spicy tasty donut family"));
        productList.add(new Product("Floating Donut", 30.0, "green_donut", "Spicy tasty donut family"));
        productList.add(new Product("Red Donut", 25.0, "donut_red", "Spicy tasty donut family"));

        adapter = new ProductAdapter(this, R.layout.item_custom_list_view, productList);
        listView.setAdapter(adapter);
        setFocusBtn(1);

        btnSearch.setOnClickListener(this);
        btnDonut.setOnClickListener(this);
        btnPinkDonut.setOnClickListener(this);
        btnFloating.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_btnDonut:
                setFocusBtn(1);
                showProduct("all");
                break;
            case R.id.main_btnFloating:
                setFocusBtn(2);
                showProduct("Floating Donut");
                break;
            case R.id.main_btnPinkDonut:
                setFocusBtn(3);
                showProduct("Pink Donut");
                break;
            default:
                Toast.makeText(this, "coming soon...", Toast.LENGTH_LONG).show();
                break;
        }
    }

    private void setFocusBtn(int index) {
        String colorFocus = "#F1B000";
        String colorUnFocus = "#f5f5f5";
        btnDonut.setBackgroundColor(Color.parseColor(colorUnFocus));
        btnFloating.setBackgroundColor(Color.parseColor(colorUnFocus));
        btnPinkDonut.setBackgroundColor(Color.parseColor(colorUnFocus));
        switch (index) {
            case 1:
                btnDonut.setBackgroundColor(Color.parseColor(colorFocus));
                break;
            case 2:
                btnFloating.setBackgroundColor(Color.parseColor(colorFocus));
                break;
            case 3:
                btnPinkDonut.setBackgroundColor(Color.parseColor(colorFocus));
                break;
        }
    }

    private void showProduct(String type) {
        List<Product> tempProductList = new ArrayList<>();
        if (type.equals("all"))
            tempProductList = productList;
        else
            for (Product p : productList) {
                if (p.getName().equals(type))
                    tempProductList.add(p);
            }
        adapter = new ProductAdapter(this, R.layout.item_custom_list_view, tempProductList);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}