package com.example.advancedandroid.networking.ui;

import com.example.advancedandroid.ui.ActivityViewInterceptor;

import dagger.Module;
import dagger.Provides;

/**
 * @author Mugiwara_Munyi
 * @date 09/06/2019
 */
@Module
public abstract class ActivityViewInterceptorModule {

   @Provides
    static ActivityViewInterceptor providesActivityViewInterceptor(){
       return ActivityViewInterceptor.DEFAULT;
   }
}
