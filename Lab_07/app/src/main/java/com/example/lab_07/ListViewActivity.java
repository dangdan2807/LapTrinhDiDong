package com.example.lab_07;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {
    private Button btnAdd, btnRemove, btnCancel;
    private List<User> userList;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        btnAdd = findViewById(R.id.lvLayout_btnAdd);
        btnRemove = findViewById(R.id.lvLayout_btnRemove);
        btnCancel = findViewById(R.id.lvLayout_btnCancel);
        listView = findViewById(R.id.lvLayout_lv);

        DatabaseHandler db = new DatabaseHandler(this);

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

        userList = db.getAllUser();

        UserAdapter adapter = new UserAdapter(this, R.layout.lv_layout_item, userList);
        listView.setAdapter(adapter);
    }
}