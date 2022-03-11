package com.example.lab_04.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.lab_04.R;
import com.example.lab_04.model.Product;

import java.text.DecimalFormat;
import java.util.List;

public class ProductAdapterGv extends BaseAdapter {
    private Context context;
    private int idLayout;
    private List<Product> listProduct;
    private int positionSelect = -1;

    public ProductAdapterGv(Context context, int idLayout, List<Product> listProduct) {
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
        ImageView imageProduct = view.findViewById(R.id.item_gv_imageProduct);
        TextView tvProductName = view.findViewById(R.id.item_gv_tvProductName);
        TextView tvCountReview = view.findViewById(R.id.item_gv_tvCountReview);
        TextView tvPrice = view.findViewById(R.id.item_gv_tvPrice);
        TextView tvDiscount = view.findViewById(R.id.item_gv_tvDiscount);
        RatingBar ratingBar = view.findViewById(R.id.item_gv_ratingBar);
        final ConstraintLayout constraintLayout = view.findViewById(R.id.item_gv_layout);
        final Product product = listProduct.get(i);

        DecimalFormat df = new DecimalFormat("#,###.##");

        if (listProduct != null && !listProduct.isEmpty()) {
            tvProductName.setText(product.getProductName());
            ratingBar.setRating((float) product.getRating());
            ratingBar.setEnabled(false);
            tvCountReview.setText("(" + df.format(product.getVote()) + ")");
            tvPrice.setText(df.format(product.getPrice()) + " đ");
            tvDiscount.setText("-" + df.format(product.getDiscount()) + "%");

            String productImage = product.getImageName();
            switch (productImage) {
                case "car_bus_btop_s2":
                    imageProduct.setImageResource(R.drawable.car_bus_btop_s2);
                    break;
                case "dau_cam":
                    imageProduct.setImageResource(R.drawable.dau_cam);
                    break;
                case "dau_chuyen_doi":
                    imageProduct.setImageResource(R.drawable.dau_chuyen_doi);
                    break;
                case "dau_chuyen_doi_psps2":
                    imageProduct.setImageResource(R.drawable.dau_chuyen_doi_psps2);
                    break;
                case "day_nguon":
                    imageProduct.setImageResource(R.drawable.day_nguon);
                    break;
                case "giac_chuyen":
                    imageProduct.setImageResource(R.drawable.giac_chuyen);
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
            constraintLayout.setBackgroundColor(Color.WHITE);
        } else {
            constraintLayout.setBackgroundColor(Color.parseColor("#C4C4C4"));
        }
        return view;
    }
}
