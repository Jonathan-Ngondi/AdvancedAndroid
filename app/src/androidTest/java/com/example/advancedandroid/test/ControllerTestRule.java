package com.example.advancedandroid.test;

import android.app.Activity;
import android.support.test.rule.ActivityTestRule;

/**
 * @author Mugiwara_Munyi
 * @date 07/06/2019
 */
public class ControllerTestRule<T extends Activity> extends ActivityTestRule<T> {

    public ControllerTestRule(Class<T> activityClass){
        super(activityClass, true, false);
    }

}
