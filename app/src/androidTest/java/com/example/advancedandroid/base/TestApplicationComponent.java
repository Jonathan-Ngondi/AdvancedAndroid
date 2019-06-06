package com.example.advancedandroid.base;

import com.example.advancedandroid.data.TestRepoServiceModule;
import com.example.advancedandroid.networking.ServiceModule;
import com.example.advancedandroid.trending.TrendingReposControllerTest;
import com.example.advancedandroid.ui.NavigationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author Mugiwara_Munyi
 * @date 01/06/2019
 */
@Singleton
@Component (modules = {
        ApplicationModule.class,
        TestActivityBindingModule.class,
        TestRepoServiceModule.class,
        ServiceModule.class,
        NavigationModule.class,
})
public interface TestApplicationComponent extends ApplicationComponent{
   void inject(TrendingReposControllerTest trendingReposControllerTest);
}
