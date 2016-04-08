package com.github.yonatankahana.xintro.introduction;

import android.annotation.TargetApi;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.github.yonatankahana.xintro.R;
import com.github.yonatankahana.xintro.activities.AppStaticContext;
import com.github.yonatankahana.xintro.imageloaders.GlideImageLoader;
import com.github.yonatankahana.xintro.introduction.entities.IntroFragmentModel;

/**
 * ImageOnly Introduction Fragment.
 *
 * @see SimpleIntroFragment
 */
public class ImageOnlyIntroFragment extends IntroFragment {
    ImageView mImageView;
    View mView;
    RelativeLayout mBaseRelativeView;

    @Override
    public View getViewToInflate(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.image_only_fragment_layout, container, false);
    }

    @Override
    public void setTitle(String title) {
        Log.w("XIntro", "setTitle(string) should not be called on ImageOnlyIntroFragment.");
    }

    @Override
    public final void setImage(int image) {
        if (image == 0) {
            // dont try to load null images.
            return;
        }

        if (AppStaticContext.customImageLoader != null) {
            AppStaticContext.customImageLoader.loadImage(getContext(), mImageView, image);
        } else {
            new GlideImageLoader().loadImage(getContext(), mImageView, image);
        }
    }

    @Override
    @TargetApi(android.os.Build.VERSION_CODES.LOLLIPOP)
    public void setImageElevation(float imageElevation) {
        mImageView.setElevation(imageElevation);
    }

    @Override
    public void setDescription(String description) {
        Log.w("XIntro", "setDescription(string) should not be called on ImageOnlyIntroFragment.");
    }

    @Override
    public void setBackgroundColor(int backgroundColor) {
        if (backgroundColor == 0) {
            return;
        }

        mBaseRelativeView.setBackgroundColor(backgroundColor);
    }

    @Override
    public void setTitleTextColor(int titleColor) {
        if (titleColor == 0) {
            return;
        }

        Log.w("XIntro", "setTitleTextColor(int) should not be called on ImageOnlyIntroFragment.");
    }

    @Override
    public void setDescriptionTextColor(int descriptionTextColor) {
        if (descriptionTextColor == 0) {
            return;
        }

        Log.w("XIntro", "setDescriptionTextColor(int) should not be called on ImageOnlyIntroFragment.");
    }

    @Override
    public void initialize(View view, IntroFragmentModel introFragmentModel) {
        mView = view;
        mImageView = (ImageView) mView.findViewById(R.id.imageView);
        mBaseRelativeView = (RelativeLayout) mView.findViewById(R.id.baseRelativeView);

        setImage(introFragmentModel.getImage());
        setBackgroundColor(introFragmentModel.getBackgroundColor());
    }

}
