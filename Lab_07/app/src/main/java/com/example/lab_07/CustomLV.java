package com.example.lab_07;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lab_07.database.PlaceDatabaseHandler;
import com.example.lab_07.model.PlaceA;
import com.example.lab_07.adapter.PlaceAdapter;

import java.util.List;

public class CustomLV extends AppCompatActivity {
    private Button btnSave, btnCancel;
    private EditText edt;
    private List<PlaceA> placeAList;
    private ListView listView;
    private Context context;
    private PlaceAdapter adapter;
    private int selectedId = -1;
    private ImageButton btnEdit, btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_lv_a);
        context = this;

        btnSave = findViewById(R.id.customLvLayout_btnSave);
        btnCancel = findViewById(R.id.customLvLayout_btnCancel);
        edt = findViewById(R.id.customLv_edt);
        listView = findViewById(R.id.customLVLayout_lv);

        PlaceDatabaseHandler db = new PlaceDatabaseHandler(this);
        db.resetDatabase();

        db.addPlace(new PlaceA("Đà Lạt"));
        db.addPlace(new PlaceA("Buôn Mê Thuộc"));
        db.addPlace(new PlaceA("Cần Thơ"));
        db.addPlace(new PlaceA("Phú Quốc"));
        db.addPlace(new PlaceA("Lý Sơn"));
        db.addPlace(new PlaceA("Côn Đảo"));
        db.addPlace(new PlaceA("Vũng Tàu"));

        placeAList = db.getAllPlace();

        adapter = new PlaceAdapter(this, R.layout.customlv_layout_item_a, placeAList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView tvId = view.findViewById(R.id.customLvLayout_itemId);
                TextView tvName = view.findViewById(R.id.customLvLayout_itemName);
                int id = Integer.parseInt(tvId.getText().toString());
                String name = tvName.getText().toString();
                edt.setText(name);
                Toast.makeText(context, name, Toast.LENGTH_LONG).show();
                selectedId = id;
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = edt.getText().toString();
                if (data.equals("") || data.isEmpty()) {
                    Toast.makeText(context, "Tên không được để trỗng", Toast.LENGTH_LONG).show();
                } else {
                    if(selectedId == -1) {
                        db.addPlace(new PlaceA(data));
                    } else {
                        db.updatePlace(new PlaceA(selectedId, data));
                    }
                    placeAList = db.getAllPlace();
                    adapter = new PlaceAdapter(context, R.layout.customlv_layout_item_a, placeAList);
                    listView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edt.setText("");
                selectedId = -1;
            }
        });
    }
}