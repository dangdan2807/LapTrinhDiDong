package com.example.lab_04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.example.lab_04.adapter.ProductAdapterLv;
import com.example.lab_04.model.Product;

import java.util.ArrayList;
import java.util.List;

public class Layout4a extends AppCompatActivity implements View.OnClickListener {
    private ImageButton btnBackTop, btnBackBottom, btnCart, btnHome, btnMenu;
    private List<Product> listProduct;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout4a);

        btnBackTop = findViewById(R.id.layout4a_btnBackTop);
        btnBackBottom = findViewById(R.id.layout4a_btnBackBottom);
        btnCart = findViewById(R.id.layout4a_btnCart);
        btnHome = findViewById(R.id.layout4a_btnHome);
        btnMenu = findViewById(R.id.layout4a_btnMenu);

        listView = findViewById(R.id.layout4a_lvProduct);
        listProduct = new ArrayList<>();
        listProduct.add(new Product("Ca nấu lẫu, nấu mì mini...", "Devang", "ca_nau_lau"));
        listProduct.add(new Product("1KG Khô gà bỏ tỏi...", "LTD Food", "ga_bo_toi"));
        listProduct.add(new Product("Xe cần cẩu đa năng", "Thế giới đồ chơi", "xa_can_cau"));
        listProduct.add(new Product("Đồ chơi dạng mô hình", "Thế giới đồ chơi", "do_choi_dang_mo_hinh"));
        listProduct.add(new Product("Lãnh đạo đơn giản", "Minh Long Book", "lanh_dao_gian_don"));
        listProduct.add(new Product("Hiếu lòng con trẻ", "Minh Long Book", "hieu_long_con_tre"));
        listProduct.add(new Product("Donald Trump Thiên tài lãnh đạo", "Minh Long Book", "trump_1"));

        ProductAdapterLv adapter = new ProductAdapterLv(this, R.layout.item_custom_list_view, listProduct);
        listView.setAdapter(adapter);

        btnBackTop.setOnClickListener(this);
        btnBackBottom.setOnClickListener(this);
        btnCart.setOnClickListener(this);
        btnHome.setOnClickListener(this);
        btnMenu.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.layout4a_btnBackTop:
            case R.id.layout4a_btnBackBottom:
                this.finish();
                break;
            case R.id.layout4a_btnHome:
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