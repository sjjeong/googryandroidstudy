package com.googry.upbacknavigationapplication;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.googry.upbacknavigationapplication.databinding.Test1ActivityBinding;

import java.util.Iterator;
import java.util.List;

public class Test1Activity extends AppCompatActivity {
    private Test1ActivityBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.test1_activity);
        mBinding.setActivity(this);
    }

    public void onClickUpNavigation(View view) {
        Intent upIntent = NavUtils.getParentActivityIntent(this);
//        if (NavUtils.shouldUpRecreateTask(this, upIntent)) {
//            TaskStackBuilder.create(this)
//                    .addNextIntentWithParentStack(upIntent)
//                    .startActivities();
//        } else {
//            NavUtils.navigateUpFromSameTask(this);
//        }

        NavUtils.navigateUpTo(this, upIntent);
        Toast.makeText(this, NavUtils.getParentActivityName(this), Toast.LENGTH_SHORT).show();
    }

}
