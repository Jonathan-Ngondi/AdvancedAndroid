package com.example.advancedandroid.home;

import com.example.advancedandroid.di.ActivityScope;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * @author Mugiwara_Munyi
 * @date 01/06/2019
 */
@ActivityScope
@Subcomponent (modules = {TestScreenBindingModule.class,})
public interface TestMainActivityComponent extends AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity> {

    }

}
