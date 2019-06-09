package com.example.advancedandroid.ui;

import android.app.Activity;
import android.support.annotation.LayoutRes;

/**
 * @author Mugiwara_Munyi
 * @date 09/06/2019
 */
public interface ActivityViewInterceptor {

    void setContentView(Activity activity, @LayoutRes int layoutRes);

    void clear();

    ActivityViewInterceptor DEFAULT = new ActivityViewInterceptor() {
        @Override
        public void setContentView(Activity activity, int layoutRes) {
            activity.setContentView(layoutRes);
        }

        @Override
        public void clear() {

        }
    };

}
