package com.github.yonatankahana.xintro.activities;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;

import com.github.yonatankahana.xintro.actionstemplate.ActionTemplate;
import com.github.yonatankahana.xintro.imageloaders.ImageLoader;
import com.github.yonatankahana.xintro.introduction.entities.IntroFragmentModel;

import java.util.ArrayList;

/**
 * HACK ALERT!
 * Created by yonatan on 23/03/16.
 */
//TODO: remove this hack class.
public class AppStaticContext {
    @Nullable
    public static ArrayList<IntroFragmentModel> introFragmentModelArrayList;
    @Nullable
    public static ViewPager.PageTransformer pageTransformer;
    @Nullable
    public static XintroActivity.OnFragmentChangedListener onFragmentChangedListener;
    @Nullable
    public static XintroActivity.OnIntroductionFinishedListener onIntroductionFinishedListener;
    public static ImageLoader customImageLoader;
    public static Context callerContext;
    public static Activity introductionActivity;
    public static ArrayList<ActionTemplate> actionTemplates = new ArrayList<>();
}
