package com.googry.upbacknavigationapplication;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.googry.upbacknavigationapplication.databinding.TestMainActivityBinding;

public class TestMainActivity extends AppCompatActivity {
    private TestMainActivityBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this,R.layout.test_main_activity);
        mBinding.setActivity(this);
    }

    public void onClickStartTest1Activity(View view){
        startActivity(new Intent(getApplicationContext(), Test1Activity.class));
    }
}
