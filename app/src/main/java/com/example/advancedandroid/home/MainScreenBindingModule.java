package com.example.advancedandroid.home;

import com.bluelinelabs.conductor.Controller;
import com.example.advancedandroid.details.RepoDetailsComponent;
import com.example.advancedandroid.details.RepoDetailsController;
import com.example.advancedandroid.di.ControllerKey;
import com.example.advancedandroid.trending.TrendingReposComponent;
import com.example.advancedandroid.trending.TrendingReposController;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

/**
 * @author Mugiwara_Munyi
 * @date 27/05/2019
 */
@Module(subcomponents = {
        TrendingReposComponent.class,
        RepoDetailsComponent.class,
})
public abstract class MainScreenBindingModule {

    @Binds
    @IntoMap
    @ControllerKey(TrendingReposController.class)
    abstract AndroidInjector.Factory<? extends Controller> bindTrendingReposInjector(TrendingReposComponent.Builder builder);

    @Binds
    @IntoMap
    @ControllerKey(RepoDetailsController.class)
    abstract AndroidInjector.Factory<? extends Controller> bindRepoDetailsInjector(RepoDetailsComponent.Builder builder);


}
