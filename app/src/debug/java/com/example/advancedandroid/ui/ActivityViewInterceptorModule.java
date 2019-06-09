package com.example.advancedandroid.ui;

import dagger.Binds;
import dagger.Module;

/**
 * @author Mugiwara_Munyi
 * @date 09/06/2019
 */
@Module
public abstract class ActivityViewInterceptorModule {

    @Binds
    abstract ActivityViewInterceptor bindsActivityViewInterceptor(DebugActivityViewInterceptor activityViewInterceptor);
}
