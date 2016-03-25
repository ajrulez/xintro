package com.github.yonatankahana.xintro;

import android.annotation.TargetApi;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;

import com.github.yonatankahana.xintro.introduction.IntroFragment;
import com.github.yonatankahana.xintro.introduction.SimpleIntroFragment;
import com.github.yonatankahana.xintro.introduction.entities.IntroFragmentModel;

/**
 * XintroFragmentBuilder is builder that helps to create
 * IntroFragment instance with all the customizable options programmatically.
 * Created by yonatan on 14/03/16.
 *
 * @author Yonatan Kahana
 * @see IntroFragment
 * @see IntroFragmentModel
 * @see SimpleIntroFragment
 */
public class XintroFragmentBuilder {
    private String title;
    private String description;
    private int image;
    private int backgroundColor;
    private int titleTextColor;
    private int descriptionTextColor;
    private int imageElevation;

    @Nullable
    private IntroFragment introFragment;

    /**
     * Instantiates a new Xintro fragment builder.
     */
    protected XintroFragmentBuilder() {
    }

    /**
     * Initiate build process of xintro fragment.
     *
     * @return the xintro fragment builder
     */
    public static XintroFragmentBuilder build() {
        return new XintroFragmentBuilder();
    }

    /**
     * Sets intro fragment.
     * The default intro fragment is SimpleIntroFragment
     *
     * @param introFragment the intro fragment
     * @see SimpleIntroFragment
     * @see IntroFragment
     */
    public void setIntroFragment(@Nullable IntroFragment introFragment) {
        this.introFragment = introFragment;
    }

    /**
     * Sets the title of the fragment.
     *
     * @param title the title
     * @return the xintro fragment builder
     */
    public XintroFragmentBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * Sets description of the fragment.
     *
     * @param description the description
     * @return the xintro fragment builder
     */
    public XintroFragmentBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Sets image in the fragment.
     *
     * @param image the image
     * @return the xintro fragment builder
     */
    public XintroFragmentBuilder setImage(@DrawableRes int image) {
        this.image = image;
        return this;
    }

    /**
     * Sets background color of the fragment.
     *
     * @param backgroundColor the background color
     * @return the xintro fragment builder
     */
    public XintroFragmentBuilder setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    /**
     * Sets title text color.
     *
     * @param titleTextColor the title text color
     * @return the xintro fragment builder
     */
    public XintroFragmentBuilder setTitleTextColor(int titleTextColor) {
        this.titleTextColor = titleTextColor;
        return this;
    }

    /**
     * Sets description text color.
     *
     * @param descriptionTextColor the description text color
     * @return the xintro fragment builder
     */
    public XintroFragmentBuilder setDescriptionTextColor(int descriptionTextColor) {
        this.descriptionTextColor = descriptionTextColor;
        return this;
    }

    /**
     * Sets image elevation.
     *
     * @param imageElevation the image elevation
     * @return the xintro fragment builder
     */
    @TargetApi(android.os.Build.VERSION_CODES.LOLLIPOP)
    public XintroFragmentBuilder setImageElevation(int imageElevation) {
        this.imageElevation = imageElevation;
        return this;
    }

    /**
     * Compile to intro fragment model.
     *
     * @return the intro fragment model
     */
    public IntroFragmentModel compile() {
        return new IntroFragmentModel(introFragment == null ? new SimpleIntroFragment() /* its the default */ : introFragment, title, description, image, backgroundColor, imageElevation, titleTextColor, descriptionTextColor);
    }
}
