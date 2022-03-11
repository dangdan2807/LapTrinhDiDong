package com.example.lab_04.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lab_04.R;
import com.example.lab_04.model.Product;

import java.util.List;

public class ProductAdapterLv extends BaseAdapter {
    private Context context;
    private int idLayout;
    private List<Product> listProduct;
    private int positionSelect = -1;

    public ProductAdapterLv(Context context, int idLayout, List<Product> listProduct) {
        this.context = context;
        this.idLayout = idLayout;
        this.listProduct = listProduct;
    }

    @Override
    public int getCount() {
        if (listProduct.size() != 0 && !listProduct.isEmpty())
            return listProduct.size();
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
            view = LayoutInflater.from(viewGroup.getContext()).inflate(idLayout, viewGroup, false);
        }
        TextView tvShopName = (TextView) view.findViewById(R.id.item_lv_tvShopName);
        TextView tvProductName = (TextView) view.findViewById(R.id.item_lv_tvProductName);
        ImageView imageView = view.findViewById(R.id.item_lv_logo);
        final LinearLayout linearLayout = view.findViewById(R.id.item_lv_layout);
        final Product product = listProduct.get(i);

        if (listProduct != null && !listProduct.isEmpty()) {
            tvShopName.setText(product.getShopName());
            tvProductName.setText(product.getProductName());
            String productImage = product.getImageName();
            switch (productImage) {
                case "ca_nau_lau":
                    imageView.setImageResource(R.drawable.ca_nau_lau);
                    break;
                case "ga_bo_toi":
                    imageView.setImageResource(R.drawable.ga_bo_toi);
                    break;
                case "xa_can_cau":
                    imageView.setImageResource(R.drawable.xa_can_cau);
                    break;
                case "do_choi_dang_mo_hinh":
                    imageView.setImageResource(R.drawable.do_choi_dang_mo_hinh);
                    break;
                case "lanh_dao_gian_don":
                    imageView.setImageResource(R.drawable.lanh_dao_gian_don);
                    break;
                case "hieu_long_con_tre":
                    imageView.setImageResource(R.drawable.hieu_long_con_tre);
                    break;
                case "trump_1":
                    imageView.setImageResource(R.drawable.trump_1);
                    break;
                default:
                    break;
            }
        }
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, product.getProductName(), Toast.LENGTH_LONG).show();
                positionSelect = i;
                notifyDataSetChanged();
            }
        });

        if (positionSelect == i) {
            linearLayout.setBackgroundColor(Color.WHITE);
        } else {
            linearLayout.setBackgroundColor(Color.parseColor("#C4C4C4"));
        }
        return view;
    }
}
