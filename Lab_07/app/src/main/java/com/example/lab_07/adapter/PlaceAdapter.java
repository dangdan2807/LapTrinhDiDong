package com.example.lab_07.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.lab_07.database.PlaceDatabaseHandler;
import com.example.lab_07.R;
import com.example.lab_07.model.PlaceA;

import java.util.List;

public class PlaceAdapter extends BaseAdapter {
    private int idLayout;
    private List<PlaceA> placeAList;
    private Context context;

    public PlaceAdapter(Context context, int idLayout, List<PlaceA> placeAList) {
        this.context = context;
        this.placeAList = placeAList;
        this.idLayout = idLayout;
    }

    @Override
    public int getCount() {
        if (placeAList.size() != 0 && !placeAList.isEmpty())
            return placeAList.size();
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
        view = LayoutInflater.from(viewGroup.getContext()).inflate(idLayout, viewGroup, false);

        TextView tvName = view.findViewById(R.id.customLvLayout_itemName);
        TextView tvId = view.findViewById(R.id.customLvLayout_itemId);
        ImageButton btnEdit = view.findViewById(R.id.customLvLayout_itemBtnEdit);
        ImageButton btnDelete = view.findViewById(R.id.customLvLayout_itemBtnDelete);

        if (!placeAList.isEmpty() && placeAList != null) {
            PlaceA placeA = placeAList.get(i);
            tvId.setText(String.valueOf(placeA.getId()));
            int index = i + 1;
            tvName.setText(index + ". " + placeA.getName());

            btnEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    EditText edt = view.findViewById(R.id.customLv_edt);
                    String name = placeA.getName();
                    edt.setText(name);
                }
            });

            btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    PlaceDatabaseHandler db = new PlaceDatabaseHandler(context);
                    int id = placeA.getId();
                    db.deletePlace(id);
                }
            });
        }

        return view;
    }
}
