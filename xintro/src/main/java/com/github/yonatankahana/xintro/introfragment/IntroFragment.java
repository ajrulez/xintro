package com.github.yonatankahana.xintro.introfragment;

import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.yonatankahana.xintro.introfragment.entities.IntroFragmentEntity;

import java.io.Serializable;
import java.security.InvalidParameterException;

/**
 * Created by yonatan on 08/03/16.
 */
public abstract class IntroFragment extends Fragment implements Serializable {
    /**
     * The Intro fragment model object.
     */
    protected IntroFragmentEntity introFragmentEntityObject;

    /**
     * This method should return the View to inflate for the IntroFragment.
     *
     * Example:
     * return inflater.inflate(R.layout.base_fragment_layout, container, false);
     *
     * @param inflater  the inflater
     * @param container the container
     * @return the view to inflate
     * @see SimpleIntroFragment
     */
    public abstract View getViewToInflate(LayoutInflater inflater, ViewGroup container);

    /**
     * This method should set the title of the fragment by the given parameters.
     *
     * @param title the title
     */
    public abstract void setTitle(String title);

    /**
     * This method should set the image in the fragment by the given parameter (drawable resource ID).
     *
     * @param image the image
     * @see SimpleIntroFragment
     */
    public abstract void setImage(@DrawableRes int image);

    /**
     * This method should set the image elevation by the given parameter.
     *
     * @param imageElevation the image elevation
     * @see SimpleIntroFragment
     */
    public abstract void setImageElevation(float imageElevation);

    /**
     * This method should set the description of the fragment by the given parameter.
     *
     * @param description the description
     * @see SimpleIntroFragment
     */
    public abstract void setDescription(String description);

    /**
     * This method should set the fragment's background color by the given color.
     *
     * @param backgroundColor the background color
     * @see SimpleIntroFragment
     */
    public abstract void setBackgroundColor(int backgroundColor);

    /**
     * This method should set the title text color by the given color.
     *
     * @param titleColor the title color
     * @see SimpleIntroFragment
     */
    public abstract void setTitleTextColor(int titleColor);

    /**
     * This method should set the description text color by the given color.
     *
     * @param descriptionTextColor the description text color
     * @see SimpleIntroFragment
     */
    public abstract void setDescriptionTextColor(int descriptionTextColor);

    /**
     * This method should initialize its components and sets all the variables.
     * This method must add its components and call for the setters by the parameters of introFragmentEntity.
     *
     * @param view               the view
     * @param introFragmentEntity the intro fragment model
     * @see SimpleIntroFragment
     */
    public abstract void initialize(View view, IntroFragmentEntity introFragmentEntity);

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = getViewToInflate(inflater, container);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            introFragmentEntityObject = (IntroFragmentEntity) bundle.get("introFragmentEntityObject");
        } else {
            throw new InvalidParameterException("Unable to create IntroFragment without 'introFragmentEntityObject' bundle as parameter for the fragment.");
        }

        initialize(view, introFragmentEntityObject);

        return view;
    }
}
