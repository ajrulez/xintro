package com.github.yonatankahana.xintro.imageloaders;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Load images with Glide library.
 *
 * @see ImageLoader
 * @since 1.0
 */
public class GlideImageLoader implements ImageLoader {

    @Override
    public void loadImage(Context context, ImageView target, @DrawableRes int drawable) {
        Glide.with(context).load(drawable).into(target);
    }
}
