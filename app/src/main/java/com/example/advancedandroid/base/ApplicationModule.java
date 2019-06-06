package com.example.advancedandroid.base;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * @author Mugiwara_Munyi
 * @date 27/05/2019
 */

@Module
public class ApplicationModule {

    private final Application application;

    ApplicationModule(Application application){
        this.application = application;
    }

    @Provides
    Context provideApplicationContext(){
        return application;
    }

}
