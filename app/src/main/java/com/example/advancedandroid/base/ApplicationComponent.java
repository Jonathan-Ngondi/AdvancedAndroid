package com.example.advancedandroid.base;

import com.example.advancedandroid.data.RepoServiceModule;
import com.example.advancedandroid.networking.ServiceModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author Mugiwara_Munyi
 * @date 27/05/2019
 */

@Singleton
@Component(modules = {ApplicationModule.class,
        ActivityBindingModule.class,
        ServiceModule.class,
        RepoServiceModule.class,

})
public interface ApplicationComponent {
    void  inject(MyApplication myApplication);
}
