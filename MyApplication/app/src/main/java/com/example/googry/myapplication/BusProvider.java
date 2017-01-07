package com.example.googry.myapplication;

import com.squareup.otto.Bus;

/**
 * Created by Googry on 2017-01-06.
 */

public final class BusProvider {
    private static final Bus BUS = new Bus();

    public static Bus getInstance(){
        return BUS;
    }

    private BusProvider(){
        //No instance.
    }
}
