package com.example.advancedandroid.details;

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
public abstract class RepoDetailsScreenModule {

    @Binds
    @IntoSet
    abstract ScreenLifecycleTask bindsUiManagerTask(RepoDetailsUiManager uiManager);

    @Binds
    @IntoMap
    @RenderKey("Contributor")
    abstract ItemRenderer<? extends RecyclerItem> bindContributorRenderer(ContributorRenderer renderer);

    @Provides
    @ScreenScope
    static RecyclerDataSource prodvideDataSource(Map<String, ItemRenderer<? extends RecyclerItem>> renderers){
        return new RecyclerDataSource(renderers);
    }
}
