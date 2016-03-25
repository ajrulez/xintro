package com.github.yonatankahana.xintro.imageloaders;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.widget.ImageView;

/**
 * Created by yonatan on 23/03/16.
 */
public interface ImageLoader {
    /**
     * This method should load the drawable to the target using the context.
     *
     * @param context  the context
     * @param target   the target
     * @param drawable the drawable
     */
    void loadImage(Context context, ImageView target, @DrawableRes int drawable);
}
