package com.googry.upbacknavigationapplication;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.googry.upbacknavigationapplication.databinding.MainActivityBinding;
import com.googry.upbacknavigationapplication.databinding.Sample2ActivityBinding;

public class Sample2Activity extends AppCompatActivity {
    private Sample2ActivityBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.sample2_activity);
        mBinding.setActivity(this);
    }
    public void onClickUpNavigation(View view) {
        NavUtils.navigateUpFromSameTask(this);
    }
}
