package com.googry.frescostudy;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.request.Postprocessor;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Googry on 2017-01-09.
 */

/**
 * http://frescolib.org/docs/
 *
 */
public class MainFragment extends Fragment {
    @BindView(R.id.my_image_view)
    SimpleDraweeView my_image_view;

    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        unbinder = ButterKnife.bind(this, view);

        //SimpleDraweeView set uri
//        Uri uri = Uri.parse("http://fresco.recrack.com/static/fresco-logo.png");
        Uri uri = Uri.parse("data:image/jpeg;base64,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");
//        my_image_view.setImageURI(uri);


        // Hierarchy
        GenericDraweeHierarchyBuilder builder = new GenericDraweeHierarchyBuilder(getResources());
        GenericDraweeHierarchy hierarchy = builder
                .setFadeDuration(300)
                .setPlaceholderImage(getResources().getDrawable(R.drawable.empty_image))
                .build();


        // Rounding
        int color = Color.RED;
        RoundingParams roundingParams = RoundingParams.fromCornersRadius(0.3f);
        roundingParams.setBorder(color, 3.0f);
        roundingParams.setRoundAsCircle(true);
        hierarchy.setRoundingParams(roundingParams);
        my_image_view.setHierarchy(hierarchy);

        ControllerListener listener = new BaseControllerListener(){};

        // Controller
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(uri)
                .setTapToRetryEnabled(true)
                .setOldController(my_image_view.getController())
                .setControllerListener(listener)
                .build();

        my_image_view.setController(controller);


        // Customizing the ImageRequest
        Postprocessor myPostprocessor = new Postprocessor() {
            @Override
            public CloseableReference<Bitmap> process(Bitmap sourceBitmap, PlatformBitmapFactory bitmapFactory) {
                return null;
            }

            @Override
            public String getName() {
                return null;
            }

            @Nullable
            @Override
            public CacheKey getPostprocessorCacheKey() {
                return null;
            }
        };
        ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri)
                .setPostprocessor(myPostprocessor)
                .build();

        DraweeController imageRequestController = Fresco.newDraweeControllerBuilder()
                .setImageRequest(request)
                .setOldController(my_image_view.getController())
                .build();
        my_image_view.setController(imageRequestController);

        return view;
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }
}
