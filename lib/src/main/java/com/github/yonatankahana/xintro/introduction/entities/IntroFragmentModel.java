package com.github.yonatankahana.xintro.introduction.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.github.yonatankahana.xintro.introduction.IntroFragment;

/**
 * Created by yonatan on 08/03/16.
 */
public class IntroFragmentModel implements Parcelable {
    /**
     * Created by the Parcelable implementation.
     */
    public static final Creator<IntroFragmentModel> CREATOR = new Creator<IntroFragmentModel>() {
        @Override
        public IntroFragmentModel createFromParcel(Parcel in) {
            return new IntroFragmentModel(in);
        }

        @Override
        public IntroFragmentModel[] newArray(int size) {
            return new IntroFragmentModel[size];
        }
    };

    private IntroFragment fragment;
    private String title;
    private String description;
    private int image;
    private int backgroundColor;
    private int imageElevation;
    private int titleTextColor;
    private int descriptionTextColor;

    /**
     * Instantiates a new Intro fragment model.
     *
     * @param fragment             the fragment
     * @param title                the title
     * @param description          the description
     * @param image                the image
     * @param backgroundColor      the background color
     * @param imageElevation       the image elevation
     * @param titleTextColor       the title text color
     * @param descriptionTextColor the description text color
     * @see com.github.yonatankahana.xintro.XintroFragmentBuilder
     */
    public IntroFragmentModel(IntroFragment fragment, String title, String description, int image, int backgroundColor, int imageElevation, int titleTextColor, int descriptionTextColor) {
        this.fragment = fragment;
        this.title = title;
        this.description = description;
        this.image = image;
        this.backgroundColor = backgroundColor;
        this.imageElevation = imageElevation;
        this.titleTextColor = titleTextColor;
        this.descriptionTextColor = descriptionTextColor;
    }

    /**
     * Instantiates a new Intro fragment model.
     *
     * @param fragment the fragment
     */
    public IntroFragmentModel(IntroFragment fragment) {
        this.fragment = fragment;
    }

    /**
     * Instantiates a new Intro fragment model by Parcel.
     *
     * @param in the Parcel
     */
    protected IntroFragmentModel(Parcel in) {
        title = in.readString();
        description = in.readString();
        image = in.readInt();
        backgroundColor = in.readInt();
        imageElevation = in.readInt();
        titleTextColor = in.readInt();
        descriptionTextColor = in.readInt();
    }

    /**
     * Returns the background color.
     *
     * @return the background color
     */
    public int getBackgroundColor() {
        return backgroundColor;
    }

    /**
     * Sets background color.
     *
     * @param backgroundColor the background color
     */
    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    /**
     * Returns the fragment.
     *
     * @return the fragment
     */
    public IntroFragment getFragment() {
        return fragment;
    }

    /**
     * Sets fragment.
     *
     * @param fragment the fragment
     */
    public void setFragment(IntroFragment fragment) {
        this.fragment = fragment;
    }

    /**
     * Returns the title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title.
     *
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Returns the description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns the image.
     *
     * @return the image
     */
    public int getImage() {
        return image;
    }

    /**
     * Sets image.
     *
     * @param image the image
     */
    public void setImage(int image) {
        this.image = image;
    }

    /**
     * Returns the image elevation.
     *
     * @return the image elevation
     */
    public int getImageElevation() {
        return imageElevation;
    }

    /**
     * Sets image elevation.
     *
     * @param imageElevation the image elevation
     */
    public void setImageElevation(int imageElevation) {
        this.imageElevation = imageElevation;
    }

    /**
     * Returns the title text color.
     *
     * @return the title text color
     */
    public int getTitleTextColor() {
        return titleTextColor;
    }

    /**
     * Sets title text color.
     *
     * @param titleTextColor the title text color
     */
    public void setTitleTextColor(int titleTextColor) {
        this.titleTextColor = titleTextColor;
    }

    /**
     * Returns the description text color.
     *
     * @return the description text color
     */
    public int getDescriptionTextColor() {
        return descriptionTextColor;
    }

    /**
     * Returns the description text color.
     *
     * @param descriptionTextColor the description text color
     */
    public void setDescriptionTextColor(int descriptionTextColor) {
        this.descriptionTextColor = descriptionTextColor;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(description);
        dest.writeInt(image);
        dest.writeInt(backgroundColor);
        dest.writeInt(imageElevation);
        dest.writeInt(titleTextColor);
        dest.writeInt(descriptionTextColor);
    }
}
