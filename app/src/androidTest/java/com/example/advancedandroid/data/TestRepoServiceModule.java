package com.example.advancedandroid.data;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

/**
 * @author Mugiwara_Munyi
 * @date 01/06/2019
 */
@Module
public abstract class TestRepoServiceModule {

    @Binds
    abstract RepoService bindRepoService(TestRepoService repoService);

    @Provides
    @Named("network_scheduler")
    static Scheduler provideNetworkScheduler(){
        return Schedulers.trampoline();
    }

}
