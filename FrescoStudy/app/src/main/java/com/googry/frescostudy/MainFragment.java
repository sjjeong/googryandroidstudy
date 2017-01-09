package com.googry.frescostudy;

import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Googry on 2017-01-09.
 */

public class MainFragment extends Fragment {
    @BindView(R.id.my_image_view)
    SimpleDraweeView my_image_view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main,container,false);
        ButterKnife.bind(this,view);

        Uri uri = Uri.parse("http://fresco.recrack.com/static/fresco-logo.png");
        my_image_view.setImageURI(uri);
        return view;
    }
}
