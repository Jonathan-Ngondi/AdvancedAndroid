package com.example.advancedandroid.ui;

import com.example.advancedandroid.di.ActivityScope;

import dagger.Binds;
import dagger.Module;

/**
 * @author Mugiwara_Munyi
 * @date 28/05/2019
 */
@Module
public abstract class NavigationModule {

    @Binds
    @ActivityScope
    abstract ScreenNavigator providesScreeNavigator(DefaultScreenNavigator screenNavigator);
}
