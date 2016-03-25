package com.github.yonatankahana.introexample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.github.yonatankahana.xintro.XintroActivityBuilder;
import com.github.yonatankahana.xintro.XintroFragmentBuilder;
import com.github.yonatankahana.xintro.imageloaders.GlideImageLoader;
import com.github.yonatankahana.xintro.imageloaders.ImageLoader;
import com.github.yonatankahana.xintro.imageloaders.PicassoImageLoader;
import com.github.yonatankahana.xintro.imageloaders.SimpleImageLoader;
import com.github.yonatankahana.xintro.introduction.entities.IntroFragmentModel;
import com.github.yonatankahana.xintro.transformers.DepthPageTransformer;
import com.github.yonatankahana.xintro.transformers.FadeTransformer;
import com.github.yonatankahana.xintro.transformers.ParallaxPageTransformer;
import com.github.yonatankahana.xintro.transformers.RotatingTransformer;
import com.github.yonatankahana.xintro.transformers.ZoomOutPageTransformer;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private ViewPager.PageTransformer mPageTransformer = new ParallaxPageTransformer();
    private ImageLoader mImageLoader = new GlideImageLoader();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showIntroduction();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        pageTransformerListenerInit();
        imageLoaderListenerInit();
    }

    private void imageLoaderListenerInit() {
        Spinner imageLoaderSpinner = (Spinner) findViewById(R.id.imageLoaderSpinner);
        ArrayAdapter<CharSequence> imageLoaderSpinnerAdapter = ArrayAdapter.createFromResource(this, R.array.imageLoaders, android.R.layout.simple_spinner_item);
        imageLoaderSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        imageLoaderSpinner.setAdapter(imageLoaderSpinnerAdapter);

        imageLoaderSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ImageLoader imageLoader = null;
                switch (position) {
                    case 0:
                        imageLoader = new GlideImageLoader();
                        break;
                    case 1:
                        imageLoader = new PicassoImageLoader();
                        break;
                    case 2:
                        imageLoader = new SimpleImageLoader();
                        break;
                }

                mImageLoader = imageLoader;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void pageTransformerListenerInit() {
        Spinner pageTransformerSpinner = (Spinner) findViewById(R.id.pageTransformerSpinner);
        ArrayAdapter<CharSequence> pageTransformerSpinnerAdapter = ArrayAdapter.createFromResource(this, R.array.pageTransformers, android.R.layout.simple_spinner_item);
        pageTransformerSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        pageTransformerSpinner.setAdapter(pageTransformerSpinnerAdapter);

        pageTransformerSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ViewPager.PageTransformer pageTransformer = null;
                switch (position) {
                    case 0:
                        pageTransformer = new ParallaxPageTransformer();
                        break;
                    case 1:
                        pageTransformer = new DepthPageTransformer();
                        break;
                    case 2:
                        pageTransformer = new FadeTransformer();
                        break;
                    case 3:
                        pageTransformer = new RotatingTransformer(130);
                        break;
                    case 4:
                        pageTransformer = new ZoomOutPageTransformer();
                        break;
                }

                mPageTransformer = pageTransformer;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {

        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void showIntroduction() {
        XintroActivityBuilder.with(this)
                .setPageTransformer(mPageTransformer)
                .withCustomImageLoader(mImageLoader)
                .addSlides(createSlides())
                .introduce();
    }

    private List<IntroFragmentModel> createSlides() {
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
