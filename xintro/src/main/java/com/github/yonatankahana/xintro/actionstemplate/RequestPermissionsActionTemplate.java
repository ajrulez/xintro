package com.github.yonatankahana.xintro.actionstemplate;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.ActivityCompat;

import com.github.yonatankahana.xintro.activities.AppStaticContext;

/**
 * RequestPermissionsActionTemplate is a ActionTemplate class that should help to
 * request Runtime Permissions with XIntro.
 *
 * @see ActionTemplate
 * @since 1.2
 */
public class RequestPermissionsActionTemplate extends ActionTemplate {

    public static final int CONST_REQUEST_KEY = 996144625;

    /**
     * The Permissions array.
     */
    final String[] permissionsArray;
    /**
     * The fragemnt index to perform the action.
     */
    final int atFragemntIndex;

    /**
     * Instantiates a new Request permissions action template.
     *
     * @param permissionsArray Provide string array that contains the permissions to request.
     * @param atFragemntIndex  Provide the fragment index to request the permissions at.
     */
    public RequestPermissionsActionTemplate(String[] permissionsArray, int atFragemntIndex) {
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
