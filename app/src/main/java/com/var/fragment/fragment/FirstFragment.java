package com.var.fragment.fragment;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.var.fragment.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment implements View.OnClickListener {

    private Button mBtnFirst;

    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        mBtnFirst = (Button) view.findViewById(R.id.btn_first);
        mBtnFirst.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        SecondFragment secondFragment = new SecondFragment();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction tx = fm.beginTransaction();
        tx.replace(R.id.fragment_content, secondFragment, "Second");
        tx.addToBackStack(null);
        tx.commit();
    }
}
