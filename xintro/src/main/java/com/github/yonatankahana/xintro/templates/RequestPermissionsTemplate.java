package com.github.yonatankahana.xintro.templates;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.ActivityCompat;

import com.github.yonatankahana.xintro.activities.AppStaticContext;

/**
 * Created by yonatan on 08/04/16.
 */
public class RequestPermissionsTemplate extends Template {
    public static final int CONST_REQUEST_KEY = 996144625;

    final String[] permissionsArray;
    final int atFragemntIndex;

    public RequestPermissionsTemplate(String[] permissionsArray, int atFragemntIndex) {
        this.permissionsArray = permissionsArray;
        this.atFragemntIndex = atFragemntIndex;
    }

    @Override
    public void onFragmentChangedListener(Context context, int from, int to) {
        if (to == atFragemntIndex) {
            ActivityCompat.requestPermissions(AppStaticContext.introductionActivity, permissionsArray, CONST_REQUEST_KEY);
        }
    }

    @Override
    public void OnIntroductionFinished(Activity activity) {

    }
}
