package com.example.lab_07.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.lab_07.CustomLVActivity;
import com.example.lab_07.R;
import com.example.lab_07.database.PlaceDatabaseHandler;
import com.example.lab_07.model.Place;

import java.util.List;

public class PlaceAdapter extends BaseAdapter {
    private Context context;
    private List<Place> placeList;
    private int idLayout;
    private EditText edt;
    private int selectedId = -1;

    public PlaceAdapter(Context context, int idLayout, List<Place> placeList, EditText edt) {
        this.context = context;
        this.placeList = placeList;
        this.idLayout = idLayout;
        this.edt = edt;
    }

    @Override
    public int getCount() {
        if (placeList.size() != 0 && !placeList.isEmpty())
            return placeList.size();
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

        TextView tvId = view.findViewById(R.id.customLvLayout_itemId);
        TextView tvName = view.findViewById(R.id.customLvLayout_itemName);
        ImageButton btnEdit = view.findViewById(R.id.customLvLayout_itemBtnEdit);
        ImageButton btnDelete = view.findViewById(R.id.customLvLayout_itemBtnDelete);

        if (!placeList.isEmpty() && placeList != null) {
            Place place = placeList.get(i);
            tvId.setText(String.valueOf(place.getId()));
            int index = i + 1;
            tvName.setText(index + ". " + place.getName());
        }

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = tvName.getText().toString().split("\\d\\.", 0)[1];
                edt.setText(name.trim());
                edt.setSelection(name.length() - 1);
                int id = Integer.parseInt(tvId.getText().toString());
                selectedId = id;
                ((CustomLVActivity) context).setTurnOnBtnCancel();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String idStr = tvId.getText().toString();
                int id = Integer.parseInt(idStr);
                PlaceDatabaseHandler placeDatabaseHandler = new PlaceDatabaseHandler(context);
                placeDatabaseHandler.deletePlace(id);
                ((CustomLVActivity) context).loadPlaceList();
            }
        });
        return view;
    }

    public int getSelectedId() {
        return selectedId;
    }

    public void setSelectedId(int selectedId) {
        this.selectedId = selectedId;
    }
}
