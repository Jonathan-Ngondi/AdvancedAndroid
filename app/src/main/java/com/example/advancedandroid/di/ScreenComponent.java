package com.example.advancedandroid.di;

import com.example.advancedandroid.lifecycle.DisposableManager;

import dagger.android.AndroidInjector;

/**
 * @author Mugiwara_Munyi
 * @date 09/06/2019
 */
public interface ScreenComponent<T> extends AndroidInjector<T> {

    @ForScreen
    DisposableManager disposableManager();

}
