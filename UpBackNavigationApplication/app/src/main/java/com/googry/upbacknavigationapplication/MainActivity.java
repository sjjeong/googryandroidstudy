package com.googry.upbacknavigationapplication;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.googry.upbacknavigationapplication.databinding.MainActivityBinding;

public class MainActivity extends AppCompatActivity {
    private MainActivityBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this,R.layout.main_activity);
        mBinding.setActivity(this);
    }

    public void onClickStartSample1Activity(View view){
        startActivity(new Intent(getApplicationContext(), Sample1Activity.class));
    }

}
