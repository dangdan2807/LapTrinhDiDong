package com.example.lab_04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.lab_04.adapter.ProductAdapterGv;
import com.example.lab_04.model.Product;

import java.util.ArrayList;
import java.util.List;

public class Layout4b extends AppCompatActivity implements View.OnClickListener {
    private ImageButton btnBackTop, btnBackBottom, btnCart, btnHome, btnMenu, btnMore;
    private List<Product> listProduct;
    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout4b);

        btnBackTop = findViewById(R.id.layout4b_btnBackTop);
        btnBackBottom = findViewById(R.id.layout4b_btnBackBottom);
        btnCart = findViewById(R.id.layout4b_btnCart);
        btnHome = findViewById(R.id.layout4b_btnHome);
        btnMenu = findViewById(R.id.layout4b_btnMenu);
        btnMore = findViewById(R.id.layout4b_btnMore);

        gridView = findViewById(R.id.layout4b_gvProduct);
        listProduct = new ArrayList<>();
        listProduct.add(new Product("Cáp chuyển từ Cổng USB sang PS2...", "giac_chuyen", 4.0, 39, 16, 69000));
        listProduct.add(new Product("Cáp sạc USB X300", "day_nguon", 3.5, 40, 847, 79000));
        listProduct.add(new Product("Cáp chuyển từ Cổng USB sang Type-c", "dau_chuyen_doi_psps2", 3, 10, 347, 119000));
        listProduct.add(new Product("Cáp chuyển từ Cổng Type-c sang USB", "dau_chuyen_doi", 2, 23, 35, 229000));
        listProduct.add(new Product("Cáp chuyển từ Cổng Type-c sang PS2", "car_bus_btop_s2", 5, 35, 463, 309000));
        listProduct.add(new Product("Cáp chuyển từ Cổng USB sang PS2", "dau_cam", 4.5, 46, 43567, 229000));

        ProductAdapterGv adapter = new ProductAdapterGv(this, R.layout.item_custom_grid_view, listProduct);
        gridView.setAdapter(adapter);

        btnBackTop.setOnClickListener(this);
        btnBackBottom.setOnClickListener(this);
        btnCart.setOnClickListener(this);
        btnHome.setOnClickListener(this);
        btnMenu.setOnClickListener(this);
        btnMore.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.layout4b_btnBackTop:
            case R.id.layout4b_btnBackBottom:
                this.finish();
                break;
            case R.id.layout4b_btnHome:
                Intent startMain = new Intent(Intent.ACTION_MAIN);
                startMain.addCategory(Intent.CATEGORY_HOME);
                startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(startMain);
                break;
            default:
                Toast.makeText(this, "coming soon...", Toast.LENGTH_LONG).show();
        }
    }
}