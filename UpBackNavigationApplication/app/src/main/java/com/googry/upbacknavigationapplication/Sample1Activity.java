package com.googry.upbacknavigationapplication;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.googry.upbacknavigationapplication.databinding.MainActivityBinding;
import com.googry.upbacknavigationapplication.databinding.Sample1ActivityBinding;

public class Sample1Activity extends AppCompatActivity {
    private Sample1ActivityBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.sample1_activity);
        mBinding.setActivity(this);
    }
    public void onClickUpNavigation(View view) {
        NavUtils.navigateUpFromSameTask(this);
    }
    public void onClickStartSample2Activity(View view) {
        startActivity(new Intent(getApplicationContext(), Sample2Activity.class));
    }
}
