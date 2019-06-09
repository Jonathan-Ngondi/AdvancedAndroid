package com.example.advancedandroid.ui;

import dagger.Binds;
import dagger.Module;

/**
 * @author Mugiwara_Munyi
 * @date 07/06/2019
 */
@Module
public abstract class TestNavigationModule {

    @Binds
    abstract ScreenNavigator bindsScreeNavigator(TestScreenNavigator screenNavigator);
}
