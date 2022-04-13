package com.example.lap_06;

import android.content.Context;
import android.icu.text.DecimalFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class ShoeAdapter extends BaseAdapter {
    private Context context;
    private int idLayout;
    private int positionSelect = -1;
    private List<Shoe> shoeList;

    public ShoeAdapter(Context context, int idLayout, List<Shoe> shoeList) {
        this.context = context;
        this.idLayout = idLayout;
        this.shoeList = shoeList;
    }

    @Override
    public int getCount() {
        if (shoeList.size() != 0 && !shoeList.isEmpty())
            return shoeList.size();
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
        view = LayoutInflater.from(viewGroup.getContext())
                .inflate(idLayout, viewGroup, false);

        ImageView imgShoes = view.findViewById(R.id.item_imageShoe);
        TextView tvName = view.findViewById(R.id.item_tvName);
        TextView tvDetail = view.findViewById(R.id.item_tvDetail);
        TextView tvPrice = view.findViewById(R.id.item_tvPrice);
        TextView tvShoeWidth = view.findViewById(R.id.item_tvShoeWidth);
        TextView tvSole = view.findViewById(R.id.item_tvSole);
        TextView tvClosure = view.findViewById(R.id.item_tvClosure);

        final Shoe shoe = shoeList.get(i);
        if (shoeList.size() != 0 && !shoeList.isEmpty()) {
            int id = shoe.getImage();
            imgShoes.setImageResource(id);
            imgShoes.setTag(id);

            tvName.setText(shoe.getName());
            tvDetail.setText(shoe.getDetail());
            tvPrice.setText(shoe.getPrice() + "");
            tvShoeWidth.setText(shoe.getShoeWidth());
            tvSole.setText(shoe.getSole());
            tvClosure.setText(shoe.getClosure());
        }
        return view;
    }
}
