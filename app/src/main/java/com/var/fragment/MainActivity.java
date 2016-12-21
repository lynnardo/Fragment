package com.var.fragment;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.var.fragment.fragment.ContentFragment;
import com.var.fragment.fragment.FriendFragment;

public class MainActivity extends Activity implements View.OnClickListener {

    private Button mBtnWechat;
    private Button mBtnFriend;

    private ContentFragment mWechat;
    private FriendFragment mFriend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnWechat = (Button) findViewById(R.id.btn_wechat);
        mBtnFriend = (Button) findViewById(R.id.btn_friend);

        mBtnWechat.setOnClickListener(this);
        mBtnFriend.setOnClickListener(this);

        setDefaultFragment();
    }

    private void setDefaultFragment() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        mWechat = new ContentFragment();
        transaction.replace(R.id.fragment_content, mWechat);
        transaction.commit();
    }

    @Override
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
    }
}
