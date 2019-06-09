package com.example.advancedandroid.ui;

import dagger.Module;
import dagger.Provides;

/**
 * @author Mugiwara_Munyi
 * @date 09/06/2019
 */
@Module
public class TestActivityViewInterceptorModule {

    @Provides
    static ActivityViewInterceptor providesActivityViewInterceptor(){
        return ActivityViewInterceptor.DEFAULT;
    }
}
