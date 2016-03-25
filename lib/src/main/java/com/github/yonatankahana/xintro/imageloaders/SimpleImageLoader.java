package com.github.yonatankahana.xintro.imageloaders;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.v4.content.ContextCompat;
import android.widget.ImageView;

/**
 * Load the images with the View.setImageDrawable();.
 * This is <b>NOT RECOMMENDED.</b>
 *
 * @see ImageLoader
 * @see GlideImageLoader
 * @since 1.0
 * @deprecated This should not be use, use GlideImageLoader instead.
 */
@Deprecated
public class SimpleImageLoader implements ImageLoader {
    @Override
    public void loadImage(Context context, ImageView target, @DrawableRes int drawable) {
        target.setImageDrawable(ContextCompat.getDrawable(context, drawable));
    }
}
