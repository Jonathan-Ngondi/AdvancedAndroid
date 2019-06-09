package com.example.advancedandroid.trending;

import com.example.advancedandroid.base.ScreenModule;
import com.example.advancedandroid.di.ScreenComponent;
import com.example.advancedandroid.di.ScreenScope;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * @author Mugiwara_Munyi
 * @date 27/05/2019
 */
@ScreenScope
@Subcomponent (modules = {
        ScreenModule.class,
        TrendingReposScreenModule.class,
})
public interface TrendingReposComponent extends ScreenComponent<TrendingReposController> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<TrendingReposController>{

    }

}
