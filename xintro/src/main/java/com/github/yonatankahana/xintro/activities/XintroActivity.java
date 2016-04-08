package com.github.yonatankahana.xintro.activities;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.CallSuper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.github.yonatankahana.xintro.R;
import com.github.yonatankahana.xintro.imageloaders.GlideImageLoader;
import com.github.yonatankahana.xintro.imageloaders.ImageLoader;
import com.github.yonatankahana.xintro.imageloaders.PicassoImageLoader;
import com.github.yonatankahana.xintro.imageloaders.SimpleImageLoader;
import com.github.yonatankahana.xintro.introduction.IntroFragment;
import com.github.yonatankahana.xintro.introduction.entities.IntroFragmentModel;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Xintro activity.
 */
public class XintroActivity extends FragmentActivity {
    private List<IntroFragmentModel> introFragmentModelsList = new ArrayList<>();
    private ViewPager.PageTransformer pageTransformer;
    private OnIntroductionFinishedListener onIntroductionFinishedListener;
    private OnFragmentChangedListener onFragmentChangedListener;
    private ViewPager mViewPager;
    private XintroFragmentsViewPagerAdapter mXintroFragmentsViewPagerAdapter;
    private ImageButton nextButton;
    private ImageButton prevButton;
    private int lastPosition = 0;

    /**
     * Instantiates a new Xintro activity.
     */
    public XintroActivity() {
    }

    /**
     * Gets intro fragment models list.
     *
     * @return the intro fragment model list
     */
    public List<IntroFragmentModel> getIntroFragmentModelsList() {
        return introFragmentModelsList;
    }

    /**
     * Sets intro fragment models list.
     *
     * @param introFragmentModelsList the intro fragment model list
     */
    public void setIntroFragmentModelsList(List<IntroFragmentModel> introFragmentModelsList) {
        introFragmentModelsList = introFragmentModelsList;
    }

    /**
     * Gets page transformer.
     *
     * @return the page transformer
     */
    public ViewPager.PageTransformer getPageTransformer() {
        return pageTransformer;
    }

    /**
     * Sets page transformer.
     *
     * @param pageTransformer the page transformer
     */
    public void setPageTransformer(ViewPager.PageTransformer pageTransformer) {
        if (pageTransformer == null) {
            // keep original pagetransformer on null.
            return;
        }
        mViewPager.setPageTransformer(false, pageTransformer);
    }

    /**
     * Gets on introduction finished listener.
     *
     * @return the on introduction finished listener
     */
    public OnIntroductionFinishedListener getOnIntroductionFinishedListener() {
        return onIntroductionFinishedListener;
    }

    /**
     * Sets on introduction finished listener.
     *
     * @param onIntroductionFinishedListener the on introduction finished listener
     */
    public void setOnIntroductionFinishedListener(OnIntroductionFinishedListener onIntroductionFinishedListener) {
        this.onIntroductionFinishedListener = onIntroductionFinishedListener;
    }

    /**
     * Gets on slide listener.
     *
     * @return the on slide listener
     */
    public OnFragmentChangedListener getOnFragmentChangedListener() {
        return onFragmentChangedListener;
    }

    /**
     * Sets on slide listener.
     *
     * @param onFragmentChangedListener the on slide listener
     */
    public void setOnFragmentChangedListener(OnFragmentChangedListener onFragmentChangedListener) {
        this.onFragmentChangedListener = onFragmentChangedListener;
    }

    /**
     * Sets custom image loader.
     *
     * @param customImageLoader the custom image loader
     */
    public void setCustomImageLoader(ImageLoader customImageLoader) {
        AppStaticContext.customImageLoader = customImageLoader;
    }

    /**
     * Use default image loader (GlideImageLoader).
     *
     * @see GlideImageLoader
     */
    public void useDefaultImageLoader() {
        useGlideImageLoader();
    }

    /**
     * Use simple image loader.
     *
     * @see GlideImageLoader
     * @deprecated Use GlideImageLoader instead.
     */
    public void useSimpleImageLoader() {
        AppStaticContext.customImageLoader = new SimpleImageLoader();
    }

    /**
     * Use glide image loader.
     */
    public void useGlideImageLoader() {
        AppStaticContext.customImageLoader = new GlideImageLoader();
    }

    /**
     * Use picasso image loader.
     */
    public void usePicassoImageLoader() {
        AppStaticContext.customImageLoader = new PicassoImageLoader();
    }


    @Override
    protected final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_intro);

        //components
        mViewPager = (ViewPager) findViewById(R.id.main_view_pager);
        nextButton = (ImageButton) findViewById(R.id.nextButton);
        prevButton = (ImageButton) findViewById(R.id.prevButton);


        mXintroFragmentsViewPagerAdapter = new XintroFragmentsViewPagerAdapter(getSupportFragmentManager());


        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                updateProgressBar();

                if (position == 0) {
                    toggleBackButtonVisibility(false);
                } else if (position == 1 && lastPosition == 0) {
                    // we dont want to update it every time, for future animation.
                    toggleBackButtonVisibility(true);
                }

                if (position == (introFragmentModelsList.size() - 1)) {
                    toggleFinishIcon(true);
                } else {
                    toggleFinishIcon(false);
                }

                if (position != lastPosition) {
                    if (position < lastPosition) {
                        performOnSlideListener(getApplicationContext(), position, position - 1);
                    } else {
                        performOnSlideListener(getApplicationContext(), position, position + 1);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });


        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNextButtonClick();
            }
        });

        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPrevButtonClick();
            }
        });

        initialize();

        if (introFragmentModelsList == null || introFragmentModelsList.isEmpty()) {
            throw new InvalidParameterException("Unable to start XintroActivity without slides.");
        }

        if (introFragmentModelsList.size() == 1) {
            // one page situation.
            toggleFinishIcon(true);
        }

        mViewPager.setAdapter(mXintroFragmentsViewPagerAdapter);
        mViewPager.setPageTransformer(false, pageTransformer);
        updateProgressBar();
    }

    private void toggleFinishIcon(final boolean isFinish) {
        final ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(nextButton, View.ROTATION, isFinish ? 360 : 0);
        objectAnimator.setDuration(500);
        objectAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        nextButton.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), isFinish ? R.drawable.ic_done_white_24dp : R.drawable.ic_arrow_forward_white_24dp));
                    }
                }, objectAnimator.getDuration() / 2);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });


        objectAnimator.start();
    }

    /**
     * On next button click.
     */
    public void onNextButtonClick() {
        if (mViewPager.getCurrentItem() == mViewPager.getAdapter().getCount() - 1) {
            // finish
            performOnIntroductionFinished();
        } else {
            mViewPager.setCurrentItem(mViewPager.getCurrentItem() + 1, true);
            performOnSlideListener(getApplicationContext(), mViewPager.getCurrentItem(), mViewPager.getCurrentItem() + 1);
        }
    }

    /**
     * On prev button click.
     */
    public void onPrevButtonClick() {
        if (mViewPager.getCurrentItem() == 0) {
            // no back
        } else {
            mViewPager.setCurrentItem(mViewPager.getCurrentItem() - 1, true);
            performOnSlideListener(getApplicationContext(), mViewPager.getCurrentItem(), mViewPager.getCurrentItem() - 1);
        }
    }

    private void toggleBackButtonVisibility(boolean visible) {
        ObjectAnimator objectAnimator = new ObjectAnimator().ofFloat(prevButton, View.ALPHA, visible ? 1f : 0f);
        objectAnimator.setDuration(500);
        objectAnimator.start();
    }

    /**
     * Perform on introduction finished.
     */
    public void performOnIntroductionFinished() {
        if (onIntroductionFinishedListener == null) {
            finish();
        } else {
            onIntroductionFinishedListener.OnIntroductionFinished(this);
        }
    }

    private void performOnSlideListener(Context context, int from, int to) {
        if (onFragmentChangedListener != null) {
            onFragmentChangedListener.onFragmentChangedListener(context, from, to);
        }
    }

    /**
     * Gets slides view pager adapter.
     *
     * @return the slides view pager adapter
     */
    public XintroFragmentsViewPagerAdapter getmXintroFragmentsViewPagerAdapter() {
        return mXintroFragmentsViewPagerAdapter;
    }

    /**
     * Sets slides view pager adapter.
     *
     * @param mXintroFragmentsViewPagerAdapter the m slides view pager adapter
     */
    public void setmXintroFragmentsViewPagerAdapter(XintroFragmentsViewPagerAdapter mXintroFragmentsViewPagerAdapter) {
        this.mXintroFragmentsViewPagerAdapter = mXintroFragmentsViewPagerAdapter;
    }

    /**
     * Initialize your activity with your options.
     * This method must call the super method - FIRST OF ALL.
     * You must add fragments to the activity
     * Common setters:
     * {@link #setCustomImageLoader(ImageLoader)}
     * {@link #setIntroFragmentModelsList(List)}
     * {@link #setOnIntroductionFinishedListener(OnIntroductionFinishedListener)}
     * {@link #setOnFragmentChangedListener(OnFragmentChangedListener)}
     * {@link #useDefaultImageLoader()}
     * {@link #useGlideImageLoader()}
     * {@link #usePicassoImageLoader()}
     * {@link #useSimpleImageLoader()}
     */
    @CallSuper
    public void initialize() {
        if (AppStaticContext.introFragmentModelArrayList != null) {
            introFragmentModelsList = AppStaticContext.introFragmentModelArrayList;
        }
        if (AppStaticContext.onFragmentChangedListener != null) {
            onFragmentChangedListener = AppStaticContext.onFragmentChangedListener;
        }
        if (AppStaticContext.onIntroductionFinishedListener != null) {
            onIntroductionFinishedListener = AppStaticContext.onIntroductionFinishedListener;
        }
        if (AppStaticContext.pageTransformer != null) {
            pageTransformer = AppStaticContext.pageTransformer;
        }
    }

    /**
     * Update progress bar.
     */
    public void updateProgressBar() {
        createProgressViews(mViewPager.getCurrentItem(), introFragmentModelsList.size());
    }

    private void createProgressViews(int pos, int max) {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        linearLayout.removeAllViewsInLayout();
        for (int i = 0; i < max; i++) {
            ImageView dotImageView = new ImageView(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.gravity = Gravity.CENTER;
            layoutParams.setMargins(5, 0, 5, 0);
            dotImageView.setLayoutParams(layoutParams);

            if (i == pos) {
                dotImageView.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.progress_dot_selected));
            } else {
                dotImageView.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.progress_dot_unselected));
            }

            linearLayout.addView(dotImageView, i);
        }


    }

    /**
     * The interface of OnIntroductionFinishedListener.
     */
    public interface OnIntroductionFinishedListener {
        /**
         * On introduction finished method.
         * Default:
         * <code>activity.finish();</code>
         *
         * @param activity the activity
         */
        void OnIntroductionFinished(Activity activity);
    }

    /**
     * The interface of OnFragmentChangedListener..
     */
    public interface OnFragmentChangedListener {
        /**
         * This event called when the fragment change in the XIntro activity.
         *
         * @param context the context of the activity.
         * @param from    the from position
         * @param to      the to position.
         */
        void onFragmentChangedListener(Context context, int from, int to);
    }

    /**
     * The type Slides view pager adapter.
     */
    public class XintroFragmentsViewPagerAdapter extends FragmentStatePagerAdapter {

        /**
         * Instantiates a new Slides view pager adapter.
         *
         * @param fm the fm
         */
        public XintroFragmentsViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            IntroFragment fragment = introFragmentModelsList.get(i).getFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("introFragmentModelObject", introFragmentModelsList.get(i));
            fragment.setArguments(bundle);
            return fragment;
        }

        @Override
        public int getCount() {
            return introFragmentModelsList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "IntroFragmentModel " + (position + 1);
        }
    }

}
