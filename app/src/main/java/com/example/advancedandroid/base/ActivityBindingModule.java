package com.example.advancedandroid.base;

import android.app.Activity;

import com.example.advancedandroid.home.MainActivity;
import com.example.advancedandroid.home.MainActivityComponent;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

/**
 * @author Mugiwara_Munyi
 * @date 27/05/2019
 */
@Module(subcomponents = {MainActivityComponent.class,})
public abstract class ActivityBindingModule {

    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> providesMainActivityInjector(MainActivityComponent.Builder builder);

}
