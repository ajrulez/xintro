package com.github.yonatankahana.xintro.transformers;

import android.support.v4.view.ViewPager;
import android.view.View;

import com.github.yonatankahana.xintro.R;

/**
 * <u><b>NOTE:</b></u><b> it will only work with SimpleIntroFragment implementation.</b>
 *
 * @see com.github.yonatankahana.xintro.introduction.SimpleIntroFragment
 */
public class ParallaxPageTransformer implements ViewPager.PageTransformer {

    public void transformPage(View view, float position) {

        int pageWidth = view.getWidth();


        if (position < -1) { // [-Infinity,-1)
            // This page is way off-screen to the left.
            view.setAlpha(1);

        } else if (position <= 1) { // [-1,1]

            view.findViewById(R.id.imageView).setTranslationX(-position * (pageWidth / 2)); //Half the normal speed

        } else { // (1,+Infinity]
            // This page is way off-screen to the right.
            view.setAlpha(1);
        }


    }
}
