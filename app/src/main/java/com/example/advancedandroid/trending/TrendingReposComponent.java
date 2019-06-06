package com.example.advancedandroid.trending;

import com.example.advancedandroid.di.ScreenScope;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * @author Mugiwara_Munyi
 * @date 27/05/2019
 */
@ScreenScope
@Subcomponent
public interface TrendingReposComponent extends AndroidInjector<TrendingReposController> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<TrendingReposController>{

    }

}
