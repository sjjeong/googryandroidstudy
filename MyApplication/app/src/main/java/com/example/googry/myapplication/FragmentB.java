package com.example.googry.myapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Googry on 2017-01-02.
 */

public class FragmentB extends Fragment {

    @OnClick(R.id.btn_B) void btn_B(){
        Log.i("googry","Pressed down button B in FragmentB");
        BusProvider.getInstance().post(new Event("event"));
        BusProvider.getInstance().post(new PushEvent("PushEvent"));
        BusProvider.getInstance().post(new PushEvent2("PushEvent2"));
    }

    public FragmentB() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_b, container,false);
        ButterKnife.bind(this,v);
        return v;
    }


}
