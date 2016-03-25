package com.github.yonatankahana.xintro;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;

import com.github.yonatankahana.xintro.activities.AppStaticContext;
import com.github.yonatankahana.xintro.activities.XintroActivity;
import com.github.yonatankahana.xintro.imageloaders.ImageLoader;
import com.github.yonatankahana.xintro.introduction.entities.IntroFragmentModel;
import com.github.yonatankahana.xintro.transformers.ZoomOutPageTransformer;

import java.util.ArrayList;
import java.util.List;

/**
 * XintroActivityBuilder is the main class of XIntro Project.
 * With it, you can build yourself XIntro Activity with just one line.
 * No need to write code, just give parameters and you'll get a
 * full production-ready introduction to your application.
 * <p/>
 * Created by yonatan on 11/03/16.
 *
 * @author Yonatan Kahana
 * @since 1.0
 */
public class XintroActivityBuilder {
    private static Context mContext;
    private ArrayList<IntroFragmentModel> introFragmentModelList;
    private ViewPager.PageTransformer pageTransformer = new ZoomOutPageTransformer();
    @Nullable
    private XintroActivity.OnFragmentChangedListener onFragmentChangedListener = null;
    @Nullable
    private XintroActivity.OnIntroductionFinishedListener onIntroductionFinishedListener = null;
    private ImageLoader customImageLoader;

    private XintroActivityBuilder(Context context) {
        mContext = context;
        introFragmentModelList = new ArrayList<>();
    }

    /**
     * Initiate the XintroActivityBuilder with context
     *
     * @param context the context
     * @return the XintroActivityBuilder object with the changed parameters. You can keep adjusting the builder with one-line.
     */
    public static XintroActivityBuilder with(Context context) {
        return new XintroActivityBuilder(context);
    }

    /**
     * Add introFragmentModel to xintro activity builder.
     *
     * @param introFragmentModel the introFragmentModel
     * @return the XintroActivityBuilder object with the changed parameters. You can keep adjusting the builder with one-line.
     */
    public XintroActivityBuilder addSlide(IntroFragmentModel introFragmentModel) {
        introFragmentModelList.add(introFragmentModel);
        return this;
    }

    /**
     * Add introFragmentAttributes to xintro activity builder.
     *
     * @param introFragmentAttributes the introFragmentAttributes
     * @return the XintroActivityBuilder object with the changed parameters. You can keep adjusting the builder with one-line.
     */
    public XintroActivityBuilder addSlides(IntroFragmentModel... introFragmentAttributes) {
        for (IntroFragmentModel introFragmentAttribute : introFragmentAttributes) {
            introFragmentModelList.add(introFragmentAttribute);
        }

        return this;
    }

    /**
     * Add introFragmentAttributes to xintro activity builder.
     *
     * @param introFragmentAttributes the introFragmentAttributes
     * @return the XintroActivityBuilder object with the changed parameters. You can keep adjusting the builder with one-line.
     */
    public XintroActivityBuilder addSlides(List<IntroFragmentModel> introFragmentAttributes) {
        introFragmentModelList.addAll(introFragmentAttributes);

        return this;
    }

    /**
     * Remove introFragmentModel from xintro activity builder.
     *
     * @param introFragmentModel the introFragmentModel
     * @return the XintroActivityBuilder object with the changed parameters. You can keep adjusting the builder with one-line.
     */
    public XintroActivityBuilder removeSlide(IntroFragmentModel introFragmentModel) {
        introFragmentModelList.remove(introFragmentModel);
        return this;
    }

    /**
     * Remove slide from xintro activity builder.
     *
     * @param slidePos the slide pos
     * @return the XintroActivityBuilder object with the changed parameters. You can keep adjusting the builder with one-line.
     */
    public XintroActivityBuilder removeSlide(int slidePos) {
        introFragmentModelList.remove(slidePos);
        return this;
    }

    /**
     * Sets page transformer.
     *
     * @param pageTransformer the page transformer. If null,
     *                        then use the default page transformer.
     * @return the XintroActivityBuilder object with the changed parameters. You can keep adjusting the builder with one-line.
     */
    public XintroActivityBuilder setPageTransformer(@Nullable ViewPager.PageTransformer pageTransformer) {
        this.pageTransformer = pageTransformer;

        return this;
    }

    /**
     * Sets slide list.
     *
     * @param introFragmentModelList the slide list
     * @return the XintroActivityBuilder object with the changed parameters. You can keep adjusting the builder with one-line.
     */
    public XintroActivityBuilder setIntroFragmentModelList(ArrayList<IntroFragmentModel> introFragmentModelList) {
        this.introFragmentModelList = introFragmentModelList;
        return this;
    }

    /**
     * Sets onFragmentChangedListener.
     *
     * @param onFragmentChangedListener the on slide listener
     * @return the XintroActivityBuilder object with the changed parameters. You can keep adjusting the builder with one-line.
     * @see XintroActivity.OnFragmentChangedListener
     */
    public XintroActivityBuilder setOnFragmentChangedListener(@Nullable XintroActivity.OnFragmentChangedListener onFragmentChangedListener) {
        this.onFragmentChangedListener = onFragmentChangedListener;
        return this;
    }

    /**
     * Sets onIntroductionFinishedListener.
     *
     * @param onIntroductionFinishedListener the onIntroductionFinishedListener
     * @return the XintroActivityBuilder object with the changed parameters. You can keep adjusting the builder with one-line.
     * @see XintroActivity.OnIntroductionFinishedListener
     */
    public XintroActivityBuilder setOnIntroductionFinishedListener(@Nullable XintroActivity.OnIntroductionFinishedListener onIntroductionFinishedListener) {
        this.onIntroductionFinishedListener = onIntroductionFinishedListener;
        return this;
    }

    /**
     * With custom image loader.
     *
     * @param customImageLoader the custom image loader
     * @return the XintroActivityBuilder object with the changed parameters. You can keep adjusting the builder with one-line.
     * @see ImageLoader
     */
    public XintroActivityBuilder withCustomImageLoader(ImageLoader customImageLoader) {
        this.customImageLoader = customImageLoader;
        return this;
    }

    /**
     * Compile to intent.
     *
     * @return the intent
     */
    public Intent compile() {
        AppStaticContext.introFragmentModelArrayList = introFragmentModelList;
        AppStaticContext.onFragmentChangedListener = onFragmentChangedListener;
        AppStaticContext.onIntroductionFinishedListener = onIntroductionFinishedListener;
        AppStaticContext.pageTransformer = pageTransformer;
        AppStaticContext.customImageLoader = customImageLoader;
        AppStaticContext.callerContext = mContext;

        XintroActivity xintroActivity = new XintroActivity();
        Intent intent = new Intent(mContext, xintroActivity.getClass());
        return intent;
    }

    /**
     * Compile to intent and start the XIntro Activity.
     */
    public void introduce() {
        mContext.startActivity(compile());
    }
}
