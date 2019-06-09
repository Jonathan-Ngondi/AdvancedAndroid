package com.example.advancedandroid.base;

import com.example.advancedandroid.data.RepoRepository;
import com.example.advancedandroid.data.TestRepoService;
import com.example.advancedandroid.data.TestRepoServiceModule;
import com.example.advancedandroid.networking.ServiceModule;
import com.example.advancedandroid.trending.TrendingReposControllerTest;
import com.example.advancedandroid.ui.TestActivityViewInterceptorModule;
import com.example.advancedandroid.ui.TestNavigationModule;
import com.example.advancedandroid.ui.TestScreenNavigator;

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
        TestNavigationModule.class,
        TestActivityViewInterceptorModule.class,
})
public interface TestApplicationComponent extends ApplicationComponent{
   void inject(TrendingReposControllerTest trendingReposControllerTest);

   TestScreenNavigator screenNavigator();

   TestRepoService repoService();

   RepoRepository repoRepository();
}
