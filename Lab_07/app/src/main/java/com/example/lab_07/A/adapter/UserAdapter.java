package com.example.lab_07.A.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lab_07.A.model.UserA;
import com.example.lab_07.R;

import java.util.List;

public class UserAdapter extends BaseAdapter {
    private Context context;
    private List<UserA> userAList;
    private int idLayout;

    public UserAdapter(Context context, int idLayout, List<UserA> userAList) {
        this.context = context;
        this.userAList = userAList;
        this.idLayout = idLayout;
    }

    @Override
    public int getCount() {
        if (userAList.size() != 0 && !userAList.isEmpty())
            return userAList.size();
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

        if (!userAList.isEmpty() && userAList != null) {
            UserA userA = userAList.get(i);
            tvId.setText(String.valueOf(userA.getId()));
            tvName.setText(userA.getName());
        }

        return view;
    }
}
