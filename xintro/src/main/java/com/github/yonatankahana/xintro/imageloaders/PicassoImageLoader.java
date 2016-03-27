package com.github.yonatankahana.xintro.imageloaders;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Load the images using Picasso library.
 *
 * @see ImageLoader
 * @since 1.0
 */
public class PicassoImageLoader implements ImageLoader {
    @Override
    public void loadImage(final Context context, final ImageView target, @DrawableRes int drawable) {
        Picasso.with(context).load(drawable).into(target);
    }
}
