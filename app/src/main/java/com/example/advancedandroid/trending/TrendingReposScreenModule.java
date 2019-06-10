package com.example.advancedandroid.trending;

import com.example.advancedandroid.di.ScreenScope;
import com.example.advancedandroid.lifecycle.ScreenLifecycleTask;
import com.example.poweradapter.adapter.RecyclerDataSource;
import com.example.poweradapter.item.ItemRenderer;
import com.example.poweradapter.item.RecyclerItem;
import com.example.poweradapter.item.RenderKey;

import java.util.Map;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.IntoSet;

/**
 * @author Mugiwara_Munyi
 * @date 09/06/2019
 */
@Module
public abstract class TrendingReposScreenModule {

    @Binds
    @IntoSet
    abstract ScreenLifecycleTask bindUiManager(TrendingReposUiManager trendingReposUiManager);

    @Binds
    @IntoMap
    @RenderKey("Repo")
    abstract ItemRenderer<? extends RecyclerItem> bindRepoRenderer(RepoRenderer repoRenderer);

    @Provides
    @ScreenScope
    static RecyclerDataSource provideRecyclerDataSource(Map<String, ItemRenderer<? extends RecyclerItem>> rendererMap){
        return new RecyclerDataSource(rendererMap);
    }


}
