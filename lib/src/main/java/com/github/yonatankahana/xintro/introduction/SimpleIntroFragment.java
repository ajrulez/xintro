package com.github.yonatankahana.xintro.introduction;

import android.annotation.TargetApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.yonatankahana.xintro.R;
import com.github.yonatankahana.xintro.activities.AppStaticContext;
import com.github.yonatankahana.xintro.imageloaders.GlideImageLoader;
import com.github.yonatankahana.xintro.introduction.entities.IntroFragmentModel;

/**
 * Created by yonatan on 08/03/16.
 */
public class SimpleIntroFragment extends IntroFragment {
    TextView mTitleTextView;
    TextView mDescriptionTextView;
    ImageView mImageView;
    private View mView;
    private RelativeLayout mBaseRelativeView;

    @Override
    public View getViewToInflate(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.base_fragment_layout, container, false);
    }

    @Override
    public void setTitle(String title) {
        mTitleTextView.setText(title);
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
        mDescriptionTextView.setText(description);
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
        mTitleTextView.setTextColor(titleColor);
    }

    @Override
    public void setDescriptionTextColor(int descriptionTextColor) {
        if (descriptionTextColor == 0) {
            return;
        }
        mDescriptionTextView.setTextColor(descriptionTextColor);
    }

    @Override
    public void initialize(View view, IntroFragmentModel introFragmentModel) {
        mView = view;
        mTitleTextView = (TextView) mView.findViewById(R.id.titleTextView);
        mDescriptionTextView = (TextView) mView.findViewById(R.id.descriptionTextView);
        mImageView = (ImageView) mView.findViewById(R.id.imageView);
        mBaseRelativeView = (RelativeLayout) mView.findViewById(R.id.baseRelativeView);

        setTitle(introFragmentModel.getTitle());
        setDescription(introFragmentModel.getDescription());
        setImage(introFragmentModel.getImage());
        setBackgroundColor(introFragmentModel.getBackgroundColor());
        setTitleTextColor(introFragmentModel.getTitleTextColor());
        setDescriptionTextColor(introFragmentModel.getDescriptionTextColor());
    }

}
