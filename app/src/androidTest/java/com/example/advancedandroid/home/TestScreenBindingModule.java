package com.example.advancedandroid.home;

import com.bluelinelabs.conductor.Controller;
import com.example.advancedandroid.di.ControllerKey;
import com.example.advancedandroid.trending.TrendingReposComponent;
import com.example.advancedandroid.trending.TrendingReposController;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

/**
 * @author Mugiwara_Munyi
 * @date 01/06/2019
 */
@Module(subcomponents = {
        TrendingReposComponent.class,
})
public abstract class TestScreenBindingModule {

    @Binds
    @IntoMap
    @ControllerKey(TrendingReposController.class)
    abstract AndroidInjector.Factory<? extends Controller> bindTrendingReposInjector(TrendingReposComponent.Builder builder);
}
