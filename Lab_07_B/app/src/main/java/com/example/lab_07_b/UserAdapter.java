package com.example.lab_07_b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lab_07_b.Entity.User;

import java.util.List;

public class UserAdapter extends BaseAdapter {
    private Context context;
    private List<User> userBList;
    private int idLayout;

    public UserAdapter(Context context, int idLayout, List<User> userBList) {
        this.context = context;
        this.userBList = userBList;
        this.idLayout = idLayout;
    }

    @Override
    public int getCount() {
        if (userBList.size() != 0 && !userBList.isEmpty())
            return userBList.size();
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

        TextView tvName = view.findViewById(R.id.lvLayout_itemName);
        TextView tvId = view.findViewById(R.id.lvLayout_itemId);

        if (!userBList.isEmpty() && userBList != null) {
            User user = userBList.get(i);
            tvId.setText(String.valueOf(user.getId()));
            tvName.setText(user.getName());
        }

        return view;
    }
}