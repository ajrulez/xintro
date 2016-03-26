package com.github.yonatankahana.introexample;

import android.graphics.Color;

import com.github.yonatankahana.xintro.XintroFragmentBuilder;
import com.github.yonatankahana.xintro.activities.XintroActivity;
import com.github.yonatankahana.xintro.introduction.entities.IntroFragmentModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yonatan on 26/03/16.
 */
public class MyIntroActivity extends XintroActivity {
    @Override
    public void initialize() {
        super.initialize();

        setIntroFragmentModelsList(createFragments());

    }

    public List<IntroFragmentModel> createFragments() {
        List<IntroFragmentModel> introFragmentModelList = new ArrayList<>();

        // first fragment
        introFragmentModelList.add(XintroFragmentBuilder.build()
                .setTitle("Welcome to the XIntro Sample")
                .setDescription(getString(R.string.example_desc_1))
                .setImage(R.drawable.goose)
                .setBackgroundColor(Color.parseColor("#3F51B5"))
                .compile());

        // second fragment
        introFragmentModelList.add(XintroFragmentBuilder.build()
                .setTitle("Fully customizable")
                .setDescription(getString(R.string.example_desc_2))
                .setDescriptionTextColor(Color.BLACK)
                .setTitleTextColor(Color.BLACK)
                .setBackgroundColor(Color.parseColor("#2196F3"))
                .setImage(R.drawable.example_image_2)
                .compile());

        // third fragment
        introFragmentModelList.add(XintroFragmentBuilder.build()
                .setTitle("Easy to use")
                .setDescription(getString(R.string.example_desc_3))
                .setBackgroundColor(Color.parseColor("#4CAF50"))
                .setImage(R.drawable.example_image_3)
                .compile());

        return introFragmentModelList;
    }
}
