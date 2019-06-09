package com.example.advancedandroid.ui;

import com.example.advancedandroid.lifecycle.ActivityLifeCycleTask;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoSet;

/**
 * @author Mugiwara_Munyi
 * @date 28/05/2019
 */
@Module
public abstract class NavigationModule {

    @Binds
    abstract ScreenNavigator providesScreeNavigator(DefaultScreenNavigator screenNavigator);

    @Binds
    @IntoSet
    abstract ActivityLifeCycleTask bindsScreenNavigatorTask(DefaultScreenNavigator screenNavigator);
}
