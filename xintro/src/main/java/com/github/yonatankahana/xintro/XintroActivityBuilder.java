package com.github.yonatankahana.xintro;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;

import com.github.yonatankahana.xintro.actionstemplate.ActionTemplate;
import com.github.yonatankahana.xintro.activities.AppStaticContext;
import com.github.yonatankahana.xintro.activities.XintroActivity;
import com.github.yonatankahana.xintro.imageloaders.ImageLoader;
import com.github.yonatankahana.xintro.introfragment.entities.IntroFragmentEntity;
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
    private ArrayList<IntroFragmentEntity> introFragmentEntityList;
    private ViewPager.PageTransformer pageTransformer = new ZoomOutPageTransformer();
    @Nullable
    private XintroActivity.OnFragmentChangedListener onFragmentChangedListener = null;
    @Nullable
    private XintroActivity.OnIntroductionFinishedListener onIntroductionFinishedListener = null;
    private ImageLoader customImageLoader;
    private ArrayList<ActionTemplate> actionTemplates = new ArrayList<>();

    private XintroActivityBuilder(Context context) {
        mContext = context;
        introFragmentEntityList = new ArrayList<>();
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
     * Add introFragmentEntity to xintro activity builder.
     *
     * @param introFragmentEntity the introFragmentEntity
     * @return the XintroActivityBuilder object with the changed parameters. You can keep adjusting the builder with one-line.
     */
    public XintroActivityBuilder addFragment(IntroFragmentEntity introFragmentEntity) {
        introFragmentEntityList.add(introFragmentEntity);
        return this;
    }

    /**
     * Add introFragmentAttributes to xintro activity builder.
     *
     * @param introFragmentAttributes the introFragmentAttributes
     * @return the XintroActivityBuilder object with the changed parameters. You can keep adjusting the builder with one-line.
     */
    public XintroActivityBuilder addFragments(IntroFragmentEntity... introFragmentAttributes) {
        for (IntroFragmentEntity introFragmentAttribute : introFragmentAttributes) {
            introFragmentEntityList.add(introFragmentAttribute);
        }

        return this;
    }

    /**
     * Add introFragmentAttributes to xintro activity builder.
     *
     * @param introFragmentAttributes the introFragmentAttributes
     * @return the XintroActivityBuilder object with the changed parameters. You can keep adjusting the builder with one-line.
     */
    public XintroActivityBuilder addFragments(List<IntroFragmentEntity> introFragmentAttributes) {
        introFragmentEntityList.addAll(introFragmentAttributes);

        return this;
    }

    /**
     * Remove introFragmentEntity from xintro activity builder.
     *
     * @param introFragmentEntity the introFragmentEntity
     * @return the XintroActivityBuilder object with the changed parameters. You can keep adjusting the builder with one-line.
     */
    public XintroActivityBuilder removeFragment(IntroFragmentEntity introFragmentEntity) {
        introFragmentEntityList.remove(introFragmentEntity);
        return this;
    }

    /**
     * Remove fragment from xintro activity builder.
     *
     * @param fragmentPos the fragment pos
     * @return the XintroActivityBuilder object with the changed parameters. You can keep adjusting the builder with one-line.
     */
    public XintroActivityBuilder removeFragment(int fragmentPos) {
        introFragmentEntityList.remove(fragmentPos);
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
     * @param introFragmentEntityList the fragments list
     * @return the XintroActivityBuilder object with the changed parameters. You can keep adjusting the builder with one-line.
     */
    public XintroActivityBuilder setIntroFragmentEntityList(ArrayList<IntroFragmentEntity> introFragmentEntityList) {
        this.introFragmentEntityList = introFragmentEntityList;
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
     * Add action template to the activity.
     *
     * @param actionTemplate the action template
     * @return the XintroActivityBuilder object with the changed parameters. You can keep adjusting the builder with one-line.
     */
    public XintroActivityBuilder addActionTemplate(ActionTemplate actionTemplate) {
        this.actionTemplates.add(actionTemplate);
        return this;
    }

    /**
     * Remove action template from the activity by action template object.
     *
     * @param actionTemplate the action template to remove
     * @return the XintroActivityBuilder object with the changed parameters. You can keep adjusting the builder with one-line.
     */
    public XintroActivityBuilder removeActionTemplate(ActionTemplate actionTemplate) {
        this.actionTemplates.remove(actionTemplate);
        return this;
    }

    /**
     * Remove action template from the activity by index.
     *
     * @param actionTemplateIndex the action template index (int)
     * @return the XintroActivityBuilder object with the changed parameters. You can keep adjusting the builder with one-line.
     */
    public XintroActivityBuilder removeActionTemplate(int actionTemplateIndex) {
        this.actionTemplates.remove(actionTemplateIndex);
        return this;
    }


    /**
     * Sets action templates from array list.
     * Null parameter will produce empty action templates list.
     *
     * @param actionTemplates the action templates list.
     * @return the actionTemplates
     */
    public XintroActivityBuilder setActionTemplates(@Nullable ArrayList<ActionTemplate> actionTemplates) {
        if (actionTemplates == null) {
            actionTemplates = new ArrayList<>();
        }

        this.actionTemplates = actionTemplates;
        return this;
    }

    /**
     * Compile to intent.
     *
     * @return the intent
     */
    public Intent compile() {
        AppStaticContext.introFragmentEntityArrayList = introFragmentEntityList;
        AppStaticContext.onFragmentChangedListener = onFragmentChangedListener;
        AppStaticContext.onIntroductionFinishedListener = onIntroductionFinishedListener;
        AppStaticContext.pageTransformer = pageTransformer;
        AppStaticContext.customImageLoader = customImageLoader;
        AppStaticContext.callerContext = mContext;
        AppStaticContext.actionTemplates = actionTemplates;


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
