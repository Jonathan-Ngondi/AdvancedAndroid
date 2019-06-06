package com.example.advancedandroid.base;

import android.app.Application;

import com.example.advancedandroid.BuildConfig;
import com.example.advancedandroid.di.ActivityInjector;

import javax.inject.Inject;

import timber.log.Timber;

/**
 * @author Mugiwara_Munyi
 * @date 27/05/2019
 */
public class MyApplication extends Application {

    @Inject
    ActivityInjector activityInjector;


    protected ApplicationComponent component;

    @Override public void onCreate(){
        super.onCreate();

        component = initComponent();
        component.inject(this);

        if(BuildConfig.DEBUG){
            Timber.plant(new Timber.DebugTree());
        }


    }

    protected ApplicationComponent initComponent(){
        return DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ActivityInjector getActivityInjector(){
        return activityInjector;
    }


}
