package com.example.lab_07;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lab_07.adapter.PlaceAdapter;
import com.example.lab_07.database.PlaceDatabaseHandler;
import com.example.lab_07.model.Place;

import java.util.List;

public class CustomLVActivity extends AppCompatActivity {
    private Button btnSave, btnCancel;
    private EditText edt;
    private List<Place> placeList;
    private ListView listView;
    private Context context;
    private PlaceAdapter adapter;
    private PlaceDatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_lv);
        context = this;

        btnSave = findViewById(R.id.customLvLayout_btnSave);
        btnCancel = findViewById(R.id.customLvLayout_btnCancel);
        edt = findViewById(R.id.customLv_edt);
        listView = findViewById(R.id.customLVLayout_lv);

        db = new PlaceDatabaseHandler(this);
        db.resetDatabase();

        db.addPlace(new Place("Đà Lạt"));
        db.addPlace(new Place("Côn Đảo"));
        db.addPlace(new Place("Vũng Tàu"));
        db.addPlace(new Place("Buôn Mê Thuộc"));
        db.addPlace(new Place("Cần Thơ"));
        db.addPlace(new Place("Phú Quốc"));
        db.addPlace(new Place("Lý Sơn"));
        db.addPlace(new Place("Cần Giờ"));

        placeList = db.getAllPlace();

        adapter = new PlaceAdapter(this, R.layout.customlv_layout_item, placeList, edt);
        listView.setAdapter(adapter);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = edt.getText().toString();
                if (data.equals("") || data.isEmpty()) {
                    Toast.makeText(context, "Tên không được để trỗng", Toast.LENGTH_LONG).show();
                } else {
                    int selectedId = adapter.getSelectedId();
                    if(selectedId == -1) {
                        db.addPlace(new Place(data));
                    } else {
                        db.updatePlace(new Place(selectedId, data));
                    }
                    loadPlaceList();
                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edt.setText("");
                adapter.setSelectedId(-1);
                btnCancel.setEnabled(false);
                btnCancel.setBackgroundColor(Color.parseColor("#dc886e"));
            }
        });
    }

    public void loadPlaceList() {
        placeList = db.getAllPlace();
        adapter = new PlaceAdapter(context, R.layout.customlv_layout_item, placeList, edt);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public void setTurnOnBtnCancel() {
        btnCancel.setEnabled(true);
        btnCancel.setBackgroundColor(Color.parseColor("#C94820"));
    }
}
