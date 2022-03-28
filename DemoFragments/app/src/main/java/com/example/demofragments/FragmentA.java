package com.example.demofragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentA#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentA extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private EditText edtData;
    private Button btnShow, btnSendData;

    private MainActivity mainActivity;
    private FragmentB fragmentB;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentA() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_A.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentA newInstance(String param1, String param2) {
        FragmentA fragment = new FragmentA();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        mainActivity = (MainActivity) getActivity();
        fragmentB = (FragmentB) getSharedElementEnterTransition();

        edtData = view.findViewById(R.id.fragmentA_edtData);
        btnShow = view.findViewById(R.id.fragmentA_btnShow);
        btnSendData = view.findViewById(R.id.fragmentA_btnSendData);

//        c1
        Bundle b = getArguments();
        if(b != null) {
            String data = b.getString("data");
            edtData.setText(data);
            Toast.makeText(getActivity(), data, Toast.LENGTH_LONG).show();
        }

//        c2
//        edtData.setText(mainActivity.getData());

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = edtData.getText().toString();
                Toast.makeText(getActivity(), data, Toast.LENGTH_LONG).show();
            }
        });

        btnSendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = edtData.getText().toString().trim();
                fragmentB.getEdtData().setText(data);
            }
        });
        return view;
    }

    public EditText getEdtData() {
        return edtData;
    }

    public void setEdtData(EditText edtData) {
        this.edtData = edtData;
    }
}