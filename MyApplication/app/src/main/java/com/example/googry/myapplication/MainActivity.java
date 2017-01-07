package com.example.googry.myapplication;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.squareup.otto.Subscribe;

public class MainActivity extends AppCompatActivity {

    private boolean isFragmentB = true;
    private Fragment frB, frC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(MainActivity.this);
        setContentView(R.layout.activity_main);
        BusProvider.getInstance().register(this);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchFragment();

            }
        });

        frB = new FragmentB();
        frC = new FragmentC();

        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentBorC, frB);
        fragmentTransaction.commit();



    }

    @Subscribe
    public void onEvent(Event event){
        Log.i("googry","Event "+ event.getStr());
    }

    @Subscribe
    public void onPushEvent(PushEvent event){
        Log.i("googry","PushEvent "+ event.getStr());
    }

    @Subscribe
    public void onPushEvent2(PushEvent2 event){
        Log.i("googry","PushEvent2 "+ event.getStr());
    }

    private void switchFragment() {
        Fragment fr;

        if (!isFragmentB) {
            fr = frB;
        } else {
            fr = frC;
        }

        isFragmentB = (isFragmentB) ? false : true;

        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentBorC, fr);
        fragmentTransaction.commit();
    }

    @Override
    protected void onDestroy() {
        BusProvider.getInstance().unregister(this);
        super.onDestroy();
    }
}
