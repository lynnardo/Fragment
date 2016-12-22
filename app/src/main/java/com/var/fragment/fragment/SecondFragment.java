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
public class SecondFragment extends Fragment implements View.OnClickListener {

    private Button mBtnSecond;

    public SecondFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        mBtnSecond = (Button) view.findViewById(R.id.btn_second);
        mBtnSecond.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        ThirdFragment thirdFragment = new ThirdFragment();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction tx = fm.beginTransaction();
        tx.hide(this);
        tx.add(R.id.fragment_content, thirdFragment, "Third");
        tx.addToBackStack(null);
        tx.commit();
    }
}
