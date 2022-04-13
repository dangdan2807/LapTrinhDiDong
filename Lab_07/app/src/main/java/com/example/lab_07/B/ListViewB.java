package com.example.lab_07.B;

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

import com.example.lab_07.B.DAO.UserBDao;
import com.example.lab_07.B.Database.UserBRoomDatabase;
import com.example.lab_07.B.adapter.UserBAdapter;
import com.example.lab_07.B.entity.UserB;
import com.example.lab_07.R;

import java.util.List;

public class ListViewB extends AppCompatActivity {
    private Button btnAdd, btnRemove, btnCancel;
    private EditText edt;
    private List<UserB> userBList;
    private ListView listView;
    private Context context;
    private UserBAdapter adapter;
    private int selectedId = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_a);
        context = this;

        btnAdd = findViewById(R.id.lvLayoutB_btnAdd);
        btnRemove = findViewById(R.id.lvLayoutB_btnRemove);
        btnCancel = findViewById(R.id.lvLayoutB_btnCancel);
        edt = findViewById(R.id.lvLayoutB_edtSearch);
        listView = findViewById(R.id.lvLayoutB_lv);

        UserBRoomDatabase database = Room.databaseBuilder(this, UserBRoomDatabase.class, "Lab07")
                .allowMainThreadQueries()
                .build();

        UserBDao userBDao = database.getUserBDao();
//        userBDao.deleteAll();

        userBDao.insert(new UserB(1, "Đỗ Anh Bôn"));
//        userBDao.insert(new UserB("Hoàng Quốc Cường"));
//        userBDao.insert(new UserB("Phạm Minh Dũng"));
//        userBDao.insert(new UserB("Châu Hoàng Duy"));
//        userBDao.insert(new UserB("Trần Nhật Duy"));
//        userBDao.insert(new UserB("Nguyễn Đình Hảo"));
//        userBDao.insert(new UserB("Hà Khã Huê"));
//        userBDao.insert(new UserB("Nguyễn Hoàng Hữu"));
//        userBDao.insert(new UserB("Lê Nguyễn Quang Linh"));
//        userBDao.insert(new UserB("Nguyễn Công Minh"));
//        userBDao.insert(new UserB("Nguyễn Hoàng Nghĩa"));
//        userBDao.insert(new UserB("Trần Thanh Nhã"));
//        userBDao.insert(new UserB("Trương Hoàng Anh Vũ"));

        userBList = userBDao.getAllUser();

        adapter = new UserBAdapter(this, R.layout.lv_layout_item_a, userBList);
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

                    userBDao.insert(new UserB(data));
                    userBList = userBDao.getAllUser();
                    adapter = new UserBAdapter(context, R.layout.lv_layout_item_a, userBList);
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
                    userBDao.deleteUser(selectedId);
                    userBList = userBDao.getAllUser();
                    adapter = new UserBAdapter(context, R.layout.lv_layout_item_a, userBList);
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