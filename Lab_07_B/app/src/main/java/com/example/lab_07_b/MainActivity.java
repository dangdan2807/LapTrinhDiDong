package com.example.lab_07_b;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lab_07_b.DAO.UserDao;
import com.example.lab_07_b.Database.UserRoomDatabase;
import com.example.lab_07_b.Entity.User;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button btnAdd, btnRemove, btnCancel;
    private EditText edt;
    private List<User> userList;
    private ListView listView;
    private Context context;
    private UserAdapter adapter;
    private int selectedId = -1;

    private UserRoomDatabase database;
    private UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        btnAdd = findViewById(R.id.lvLayoutB_btnAdd);
        btnRemove = findViewById(R.id.lvLayoutB_btnRemove);
        btnCancel = findViewById(R.id.lvLayoutB_btnCancel);
        edt = findViewById(R.id.lvLayoutB_edtSearch);
        listView = findViewById(R.id.lvLayoutB_lv);

        database = Room.databaseBuilder(this, UserRoomDatabase.class, "Lab7B")
                .allowMainThreadQueries()
                .build();

        userDao = database.getUserDao();
        userDao.deleteAllUser();

        userDao.insertUser(new User("Đỗ Anh Bôn"));
        userDao.insertUser(new User("Hoàng Quốc Cường"));
        userDao.insertUser(new User("Phạm Minh Dũng"));
        userDao.insertUser(new User("Châu Hoàng Duy"));
        userDao.insertUser(new User("Trần Nhật Duy"));
        userDao.insertUser(new User("Nguyễn Đình Hảo"));
        userDao.insertUser(new User("Hà Khã Huê"));
        userDao.insertUser(new User("Nguyễn Hoàng Hữu"));
        userDao.insertUser(new User("Lê Nguyễn Quang Linh"));
        userDao.insertUser(new User("Nguyễn Công Minh"));
        userDao.insertUser(new User("Nguyễn Hoàng Nghĩa"));
        userDao.insertUser(new User("Trần Thanh Nhã"));
        userDao.insertUser(new User("Trương Hoàng Anh Vũ"));

        userList = userDao.getAllUser();

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

                    userDao.insertUser(new User(data));
                    userList = userDao.getAllUser();
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
                    userDao.deleteUser(selectedId);
                    userList = userDao.getAllUser();
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
                selectedId = -1;
            }
        });
    }
}