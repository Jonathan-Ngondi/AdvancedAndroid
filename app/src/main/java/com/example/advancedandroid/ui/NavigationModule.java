package com.example.advancedandroid.ui;

import dagger.Binds;
import dagger.Module;

/**
 * @author Mugiwara_Munyi
 * @date 28/05/2019
 */
@Module
public abstract class NavigationModule {

    @Binds
    abstract ScreenNavigator providesScreeNavigator(DefaultScreenNavigator screenNavigator);
}
