package com.example.lab_07.A;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lab_07.A.database.UserDatabaseHandler;
import com.example.lab_07.A.model.UserA;
import com.example.lab_07.A.adapter.UserAdapter;
import com.example.lab_07.R;

import java.util.List;

public class ListViewActivity extends AppCompatActivity {
    private Button btnAdd, btnRemove, btnCancel;
    private EditText edt;
    private List<UserA> userAList;
    private ListView listView;
    private Context context;
    private UserAdapter adapter;
    private int selectedId = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_a);
        context = this;

        btnAdd = findViewById(R.id.lvLayout_btnAdd);
        btnRemove = findViewById(R.id.lvLayout_btnRemove);
        btnCancel = findViewById(R.id.lvLayout_btnCancel);
        edt = findViewById(R.id.lvLayout_edtSearch);
        listView = findViewById(R.id.lvLayout_lv);

        UserDatabaseHandler db = new UserDatabaseHandler(this);
        db.resetDatabase();

        db.addUser(new UserA("Đỗ Anh Bôn"));
        db.addUser(new UserA("Hoàng Quốc Cường"));
        db.addUser(new UserA("Phạm Minh Dũng"));
        db.addUser(new UserA("Châu Hoàng Duy"));
        db.addUser(new UserA("Trần Nhật Duy"));
        db.addUser(new UserA("Nguyễn Đình Hảo"));
        db.addUser(new UserA("Hà Khã Huê"));
        db.addUser(new UserA("Nguyễn Hoàng Hữu"));
        db.addUser(new UserA("Lê Nguyễn Quang Linh"));
        db.addUser(new UserA("Nguyễn Công Minh"));
        db.addUser(new UserA("Nguyễn Hoàng Nghĩa"));
        db.addUser(new UserA("Trần Thanh Nhã"));
        db.addUser(new UserA("Trương Hoàng Anh Vũ"));

        userAList = db.getAllUser();

        adapter = new UserAdapter(this, R.layout.lv_layout_item_a, userAList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView tvName = view.findViewById(R.id.lvLayout_itemName);
                TextView tvId = view.findViewById(R.id.lvLayout_itemId);
                int id = Integer.parseInt(tvId.getText().toString());
                String name = tvName.getText().toString();
                edt.setText(name);
                selectedId = id;
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = edt.getText().toString();
                if (data.equals("") || data.isEmpty()) {
                    Toast.makeText(context, "Tên không được để trỗng", Toast.LENGTH_LONG).show();
                } else {

                    db.addUser(new UserA(data));
                    userAList = db.getAllUser();
                    adapter = new UserAdapter(context, R.layout.lv_layout_item_a, userAList);
                    listView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
            }
        });

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = edt.getText().toString();
                if (data.equals("") || data.isEmpty()) {
                    Toast.makeText(context, "Tên không được để trỗng", Toast.LENGTH_LONG).show();
                } else {
                    db.deleteUser(new UserA(selectedId));
                    userAList = db.getAllUser();
                    adapter = new UserAdapter(context, R.layout.lv_layout_item_a, userAList);
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