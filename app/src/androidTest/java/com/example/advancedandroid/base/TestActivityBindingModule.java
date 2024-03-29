package com.example.advancedandroid.base;

import android.app.Activity;

import com.example.advancedandroid.home.MainActivity;
import com.example.advancedandroid.home.TestMainActivityComponent;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

/**
 * @author Mugiwara_Munyi
 * @date 01/06/2019
 */
@Module(subcomponents = TestMainActivityComponent.class)
public abstract class TestActivityBindingModule {

    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> bindMainActivityInjector(TestMainActivityComponent.Builder builder);
}
