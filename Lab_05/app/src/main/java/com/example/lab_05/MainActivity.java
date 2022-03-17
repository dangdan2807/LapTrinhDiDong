package com.example.lab_05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnDonut, btnPinkDonut, btnFloating;
    private ImageButton btnSearch;
    private List<Product> productList, tempProductList;
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

        setFocusBtn(1);
        adapter = new ProductAdapter(this, R.layout.item_custom_list_view, productList);
        listView.setAdapter(adapter);

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
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(context, "123", Toast.LENGTH_LONG).show();
            }
        });
        adapter.notifyDataSetChanged();
    }

    class ProductAdapter extends BaseAdapter {
        private Context adapterContext;
        private int idLayout;
        private int positionSelect = -1;
        private List<Product> productList;

        public ProductAdapter(Context adapterContext, int idLayout, List<Product> productList) {
            this.adapterContext = adapterContext;
            this.idLayout = idLayout;
            this.productList = productList;
        }

        @Override
        public int getCount() {
            if (productList.size() != 0 && !productList.isEmpty())
                return productList.size();
            return 0;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext())
                        .inflate(idLayout, viewGroup, false);
            }
            ImageView imgProduct = view.findViewById(R.id.item_lv_productImage);
            TextView tvProductName = view.findViewById(R.id.item_lv_productName);
            TextView tvProductDesc = view.findViewById(R.id.item_lv_description);
            TextView tvProductPrice = view.findViewById(R.id.item_lv_price);

            ImageButton btnAddToCard = view.findViewById(R.id.item_lv_btnAdd);
            final Product product = productList.get(i);
            DecimalFormat df = new DecimalFormat("$#,###.00");

            if (productList.size() != 0 && !productList.isEmpty()) {
                tvProductName.setText(product.getName());
                tvProductDesc.setText(product.getDesc());
                tvProductPrice.setText(df.format(product.getPrice()));
                String imageName = product.getImageName();
                switch (imageName) {
                    case "donut_red":
                        imgProduct.setImageResource(R.drawable.donut_red);
                        break;
                    case "donut_yellow":
                        imgProduct.setImageResource(R.drawable.donut_yellow);
                        break;
                    case "green_donut":
                        imgProduct.setImageResource(R.drawable.green_donut);
                        break;
                    case "tasty_donut":
                        imgProduct.setImageResource(R.drawable.tasty_donut);
                        break;
                    default:
                        break;
                }
            }

            btnAddToCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(adapterContext, "Coming soon ...", Toast.LENGTH_LONG).show();
                }
            });

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, DetailLayout.class);
                    intent.putExtra("name", product.getName());
                    intent.putExtra("desc", product.getDesc());
                    intent.putExtra("imageName", product.getImageName());
                    intent.putExtra("price", product.getPrice());
                    startActivity(intent);
                }
            });

            return view;
        }
    }
}