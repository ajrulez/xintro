package com.github.yonatankahana.xintro;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;

import com.github.yonatankahana.xintro.activities.AppStaticContext;
import com.github.yonatankahana.xintro.activities.XintroActivity;
import com.github.yonatankahana.xintro.imageloaders.ImageLoader;
import com.github.yonatankahana.xintro.introduction.entities.IntroFragmentModel;
import com.github.yonatankahana.xintro.templates.Template;
import com.github.yonatankahana.xintro.transformers.ZoomOutPageTransformer;

import java.util.ArrayList;
import java.util.List;

/**
 * XintroActivityBuilder is the main class of XIntro Project.
 * With it, you can build yourself XIntro Activity with just one line.
 * No need to write code, just give parameters and you'll get a
 * full production-ready introduction to your application.
 * <p>
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
    private ArrayList<Template> templates = new ArrayList<>();

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
    public XintroActivityBuilder addFragment(IntroFragmentModel introFragmentModel) {
        introFragmentModelList.add(introFragmentModel);
        return this;
    }

    /**
     * Add introFragmentAttributes to xintro activity builder.
     *
     * @param introFragmentAttributes the introFragmentAttributes
     * @return the XintroActivityBuilder object with the changed parameters. You can keep adjusting the builder with one-line.
     */
    public XintroActivityBuilder addFragments(IntroFragmentModel... introFragmentAttributes) {
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
    public XintroActivityBuilder addFragments(List<IntroFragmentModel> introFragmentAttributes) {
        introFragmentModelList.addAll(introFragmentAttributes);

        return this;
    }

    /**
     * Remove introFragmentModel from xintro activity builder.
     *
     * @param introFragmentModel the introFragmentModel
     * @return the XintroActivityBuilder object with the changed parameters. You can keep adjusting the builder with one-line.
     */
    public XintroActivityBuilder removeFragment(IntroFragmentModel introFragmentModel) {
        introFragmentModelList.remove(introFragmentModel);
        return this;
    }

    /**
     * Remove fragment from xintro activity builder.
     *
     * @param fragmentPos the fragment pos
     * @return the XintroActivityBuilder object with the changed parameters. You can keep adjusting the builder with one-line.
     */
    public XintroActivityBuilder removeFragment(int fragmentPos) {
        introFragmentModelList.remove(fragmentPos);
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
     * Sets fragments list.
     *
     * @param introFragmentModelList the fragments list
     * @return the XintroActivityBuilder object with the changed parameters. You can keep adjusting the builder with one-line.
     */
    public XintroActivityBuilder setIntroFragmentModelList(ArrayList<IntroFragmentModel> introFragmentModelList) {
        this.introFragmentModelList = introFragmentModelList;
        return this;
    }

    /**
     * Sets onFragmentChangedListener.
     *
     * @param onFragmentChangedListener the on fragment changed listener
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
     * Add template to the activity.
     *
     * @param template the template
     * @return the XintroActivityBuilder object with the changed parameters. You can keep adjusting the builder with one-line.
     */
    public XintroActivityBuilder addTemplate(Template template) {
        this.templates.add(template);
        return this;
    }

    /**
     * Remove template from the activity by template object.
     *
     * @param template the template to remove
     * @return the XintroActivityBuilder object with the changed parameters. You can keep adjusting the builder with one-line.
     */
    public XintroActivityBuilder removeTemplate(Template template) {
        this.templates.remove(template);
        return this;
    }

    /**
     * Remove template from the activity by index.
     *
     * @param template the template index (int)
     * @return the XintroActivityBuilder object with the changed parameters. You can keep adjusting the builder with one-line.
     */
    public XintroActivityBuilder removeTemplate(int template) {
        this.templates.remove(template);
        return this;
    }


    /**
     * Sets templates from array list.
     * Null parameter will produce empty templates list.
     *
     * @param templates the templates list.
     * @return the templates
     */
    public XintroActivityBuilder setTemplates(@Nullable ArrayList<Template> templates) {
        if (templates == null) {
            templates = new ArrayList<>();
        }

        this.templates = templates;
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
        AppStaticContext.templates = templates;


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
