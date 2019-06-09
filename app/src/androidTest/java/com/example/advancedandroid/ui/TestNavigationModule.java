package com.example.advancedandroid.ui;

import com.example.advancedandroid.lifecycle.ActivityLifeCycleTask;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoSet;

/**
 * @author Mugiwara_Munyi
 * @date 07/06/2019
 */
@Module
public abstract class TestNavigationModule {

    @Binds
    abstract ScreenNavigator bindsScreeNavigator(TestScreenNavigator screenNavigator);

    @Binds
    @IntoSet
    abstract ActivityLifeCycleTask bindsScreenNavigatorTask(TestScreenNavigator screenNavigator);
}
