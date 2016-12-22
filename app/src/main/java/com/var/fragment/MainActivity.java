package com.var.fragment;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.var.fragment.fragment.FirstFragment;
import com.var.fragment.fragment.SecondFragment;
import com.var.fragment.fragment.ThirdFragment;

public class MainActivity extends Activity implements FirstFragment.IFirstBtnOnClickListener,
        SecondFragment.ISecondBtnOnClickListener {

//    private Button mBtnWechat;
//    private Button mBtnFriend;
//
//    private ContentFragment mWechat;
//    private FriendFragment mFriend;

    private FirstFragment firstFragment;
    private SecondFragment secondFragment;
    private ThirdFragment thirdFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*mBtnWechat = (Button) findViewById(R.id.btn_wechat);
        mBtnFriend = (Button) findViewById(R.id.btn_friend);

        mBtnWechat.setOnClickListener(this);
        mBtnFriend.setOnClickListener(this);
*/
//        setDefaultFragment();

        if (savedInstanceState == null) {
            FragmentManager fm = getFragmentManager();
            FragmentTransaction transaction = fm.beginTransaction();
            firstFragment = new FirstFragment();
            transaction.add(R.id.fragment_content, firstFragment, "First");
            transaction.commit();
        }
    }

    private void setDefaultFragment() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        firstFragment = new FirstFragment();
        transaction.add(R.id.fragment_content, firstFragment, "First");
        transaction.commit();
    }

    /*@Override
    public void onClick(View v) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        switch (v.getId()) {
            case R.id.btn_wechat:
                if (mWechat == null) {
                    mWechat = new ContentFragment();
                }
                transaction.replace(R.id.fragment_content, mWechat);
                break;
            case R.id.btn_friend:
                if (mFriend == null) {
                    mFriend = new FriendFragment();

                }
                transaction.replace(R.id.fragment_content, mFriend);
                break;
        }
        transaction.commit();
    }*/

    @Override
    public void onFirstBtnClick() {
        if (secondFragment == null) {
            secondFragment = new SecondFragment();
            secondFragment.setSecondBtnOnClickListener(this);
        }
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.fragment_content, secondFragment, "Second");
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onSecondBtnClick() {
        if (thirdFragment == null) {
            thirdFragment = new ThirdFragment();
        }
        FragmentManager fm = getFragmentManager();
        FragmentTransaction tx = fm.beginTransaction();
        tx.hide(secondFragment);
        tx.add(R.id.fragment_content, thirdFragment, "Third");
        tx.addToBackStack(null);
        tx.commit();
    }
}
