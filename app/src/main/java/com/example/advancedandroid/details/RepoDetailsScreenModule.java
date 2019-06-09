package com.example.advancedandroid.details;

import com.example.advancedandroid.lifecycle.ScreenLifecycleTask;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoSet;

/**
 * @author Mugiwara_Munyi
 * @date 09/06/2019
 */
@Module
public abstract class RepoDetailsScreenModule {

    @Binds
    @IntoSet
    abstract ScreenLifecycleTask bindsUiManagerTask(RepoDetailsUiManager uiManager);
}
