package com.example.advancedandroid.base;

import com.example.advancedandroid.di.ForScreen;
import com.example.advancedandroid.di.ScreenScope;
import com.example.advancedandroid.lifecycle.DisposableManager;
import com.example.advancedandroid.lifecycle.ScreenLifecycleTask;

import java.util.Set;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.Multibinds;

/**
 * @author Mugiwara_Munyi
 * @date 09/06/2019
 */
@Module
public abstract class ScreenModule {

    @Provides
    @ScreenScope
    @ForScreen
    static DisposableManager providesDisposableManager(){
        return new DisposableManager();
    }

    @Multibinds
    abstract Set<ScreenLifecycleTask> screenLifeCycleTasks();
}
