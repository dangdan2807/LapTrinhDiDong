package com.example.lap_06;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ShoeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ShoeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ShoeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ShoeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ShoeFragment newInstance(String param1, String param2) {
        ShoeFragment fragment = new ShoeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private ListView listView;
    private List<Shoe> shoeList;
    private ShoeAdapter shoeAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_shoe, container, false);

        listView = view.findViewById(R.id.shoesFragment_lv);

        shoeList = new ArrayList<>();
        shoeList.add(
                new Shoe("Nike shoes-discount 50%", "Pls touch to see detail", 100,
                        "Small", "Rubber", R.drawable.shoes_purple, "Lace-up"));
        shoeList.add(
                new Shoe("Adidas shoes-discount 80%", "Pls touch to see detail", 123,
                        "Medium", "Grip Rubber Sole", R.drawable.shoes_blue, "Lace-up"));
        shoeList.add(
                new Shoe("Nike Bicycle-discount 30%", "Pls touch to see detail", 24,
                        "Large", "Padded Insole", R.drawable.shoes_green, "Lace-up"));
        shoeList.add(
                new Shoe("Yonex shoes-discount 50%", "Pls touch to see detail", 242,
                        "Extra Large", "Rubber", R.drawable.shoes_pink, "Lace-up"));
        shoeList.add(
                new Shoe("Victor shoes-discount 50%", "Pls touch to see detail", 234,
                        "Small", "Grip Rubber Sole", R.drawable.shoes_yellow, "Lace-up"));
        shoeList.add(
                new Shoe("Lining shoes-discount 50%", "Pls touch to see detail", 973,
                        "Medium", "Rubber", R.drawable.shoes_white, "Lace-up"));
        shoeList.add(
                new Shoe("Binh Minh shoes-discount 90%", "Pls touch to see detail", 238,
                        "Large", "Padded Insole", R.drawable.shoes_1, "Lace-up"));

        shoeAdapter = new ShoeAdapter(getActivity(), R.layout.shoe_item, shoeList);
        listView.setAdapter(shoeAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
//                ShoeDetailFragment shoeDetailFragment = new ShoeDetailFragment();
//                transaction.replace(R.id.fragment_shoe, shoeDetailFragment);
//                transaction.commit();
                Intent intent = new Intent(getActivity(), ShoeDetailActivity.class);
                String name = getData(view, R.id.item_tvName);
                String detail = getData(view, R.id.item_tvDetail);
                double price = Double.parseDouble(getData(view, R.id.item_tvPrice));
                String shoeWidth = getData(view, R.id.item_tvShoeWidth);
                String sole = getData(view, R.id.item_tvSole);
                int imageId = getImageId(view, R.id.item_imageShoe);
                String closure = getData(view, R.id.item_tvClosure);
                Shoe shoe = new Shoe(name, detail, price, shoeWidth, sole, imageId, closure);
                intent.putExtra("shoe", shoe);
                getActivity().startActivity(intent);
            }
        });

        return view;
    }

    private String getData(View view, int id) {
        String data = ((TextView) view.findViewById(id)).getText().toString();
        return data;
    }

    private int getImageId(View view, int id) {
        ImageView img = view.findViewById(id);
        int imageId = (Integer) img.getTag();
        return imageId;
    }
}