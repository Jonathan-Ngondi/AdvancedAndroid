package com.example.advancedandroid.trending;

import com.example.advancedandroid.R;
import com.example.advancedandroid.di.ScreenScope;
import com.jakewharton.rxrelay2.BehaviorRelay;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import timber.log.Timber;

/**
 * @author Mugiwara_Munyi
 * @date 29/05/2019
 */
@ScreenScope
final class TrendingReposViewModel {

    private final BehaviorRelay<Integer> errorRelay = BehaviorRelay.create();
    private final BehaviorRelay<Boolean> loadingRelay = BehaviorRelay.create();


    @Inject
    TrendingReposViewModel(){

    }

    Observable<Boolean> loading(){
        return loadingRelay;
    }

    Observable<Integer> error(){
        return errorRelay;
    }



    Action reposUpdated(){
        return () -> errorRelay.accept(-1);

    }

    Consumer<Boolean> loadingUpdated(){

        return loadingRelay;
    }

    Consumer<Throwable> onError(){
        return throwable->{
            Timber.e(throwable, "Error loading Repos");
            errorRelay.accept(R.string.api_error_repos);
        };
    }
}
