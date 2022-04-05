package com.example.lab_07;

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

import java.util.List;

public class ListViewActivity extends AppCompatActivity {
    private Button btnAdd, btnRemove, btnCancel;
    private EditText edt;
    private List<User> userList;
    private ListView listView;
    private Context context;
    private UserAdapter adapter;
    private int selectedId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        context = this;

        btnAdd = findViewById(R.id.lvLayout_btnAdd);
        btnRemove = findViewById(R.id.lvLayout_btnRemove);
        btnCancel = findViewById(R.id.lvLayout_btnCancel);
        edt = findViewById(R.id.lvLayout_edtSearch);
        listView = findViewById(R.id.lvLayout_lv);

        DatabaseHandler db = new DatabaseHandler(this);
        db.resetDatabase();

        db.addUser(new User("Đỗ Anh Bôn"));
        db.addUser(new User("Hoàng Quốc Cường"));
        db.addUser(new User("Phạm Minh Dũng"));
        db.addUser(new User("Châu Hoàng Duy"));
        db.addUser(new User("Trần Nhật Duy"));
        db.addUser(new User("Nguyễn Đình Hảo"));
        db.addUser(new User("Hà Khã Huê"));
        db.addUser(new User("Nguyễn Hoàng Hữu"));
        db.addUser(new User("Lê Nguyễn Quang Linh"));
        db.addUser(new User("Nguyễn Công Minh"));
        db.addUser(new User("Nguyễn Hoàng Nghĩa"));
        db.addUser(new User("Trần Thanh Nhã"));
        db.addUser(new User("Trương Hoàng Anh Vũ"));

        userList = db.getAllUser();

        adapter = new UserAdapter(this, R.layout.lv_layout_item, userList);
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
                    db.addUser(new User(data));
                    userList = db.getAllUser();
                    adapter = new UserAdapter(context, R.layout.lv_layout_item, userList);
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
                    db.deleteUser(new User(selectedId));
                    userList = db.getAllUser();
                    adapter = new UserAdapter(context, R.layout.lv_layout_item, userList);
                    listView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edt.setText("");
                selectedId = 0;
            }
        });
    }
}