package com.example.advancedandroid.home;

import com.example.advancedandroid.di.ActivityScope;
import com.example.advancedandroid.ui.ActivityViewInterceptorModule;
import com.example.advancedandroid.ui.NavigationModule;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * @author Mugiwara_Munyi
 * @date 27/05/2019
 */
@ActivityScope
@Subcomponent( modules = {
        MainScreenBindingModule.class,
        NavigationModule.class,
        ActivityViewInterceptorModule.class,})
public interface MainActivityComponent extends AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity>{

        @Override
        public void seedInstance(MainActivity instance) {

        }
    }


}
