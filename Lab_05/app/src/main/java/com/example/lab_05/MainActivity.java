package com.example.lab_05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    private Button btnDonut, btnPinkDonut, btnFloating;
    private ImageButton btnSearch;
    private List<Product> productList;
    private List<Product> tempProductList;
    private ListView listView;
    private ProductAdapter adapter;
    private Context context;
    private EditText edtSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        btnSearch = findViewById(R.id.main_btnSearch);
        btnDonut = findViewById(R.id.main_btnDonut);
        btnPinkDonut = findViewById(R.id.main_btnPinkDonut);
        btnFloating = findViewById(R.id.main_btnFloating);
        listView = findViewById(R.id.main_lvProduct);
        edtSearch = findViewById(R.id.main_edtSearch);

        productList = new ArrayList<>();
        productList.add(new Product("Tasty Donut", 10.0, "donut_yellow", "Spicy tasty donut family"));
        productList.add(new Product("Pink Donut", 20.0, "tasty_donut", "Spicy tasty donut family"));
        productList.add(new Product("Floating Donut", 30.0, "green_donut", "Spicy tasty donut family"));
        productList.add(new Product("Red Donut", 25.0, "donut_red", "Spicy tasty donut family"));

        adapter = new ProductAdapter(this, R.layout.item_custom_list_view, productList);
        listView.setAdapter(adapter);
        setFocusBtn(1);

        listView.setOnItemClickListener(this);

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
                showProduct("all", "");
                break;
            case R.id.main_btnFloating:
                setFocusBtn(2);
                showProduct("Floating Donut", "");
                break;
            case R.id.main_btnPinkDonut:
                setFocusBtn(3);
                showProduct("Pink Donut", "");
                break;
            case R.id.main_btnSearch:
                String keyword = edtSearch.getText().toString().toLowerCase(Locale.ROOT);
                showProduct("search", keyword);
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

    private void showProduct(String type, String keyword) {
        tempProductList = new ArrayList<>();
        if (type.equals("all"))
            tempProductList = productList;
        else if (type.equals("search")) {
            if (keyword.isEmpty() || keyword.equals(""))
                tempProductList = productList;
            else {
                for (Product p : productList) {
                    if (p.getName().contains(keyword)) {
                        tempProductList.add(p);
                    }
                }
            }
        } else {
            for (Product p : productList) {
                if (p.getName().equals(type))
                    tempProductList.add(p);
            }
        }
        adapter = new ProductAdapter(this, R.layout.item_custom_list_view, tempProductList);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(context, DetailLayout.class);
//        Bundle b = new Bundle();
//        b.putString("name", tempProductList.get(i).getName());
//        b.putString("desc", tempProductList.get(i).getDesc());
//        b.putString("imageName", tempProductList.get(i).getImageName());
//        b.putDouble("price", tempProductList.get(i).getPrice());
//        intent.putExtras(b);
        startActivity(intent);
    }
}