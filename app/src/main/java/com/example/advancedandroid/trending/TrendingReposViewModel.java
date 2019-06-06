package com.example.advancedandroid.trending;

import com.example.advancedandroid.R;
import com.example.advancedandroid.di.ScreenScope;
import com.example.advancedandroid.models.Repo;
import com.jakewharton.rxrelay2.BehaviorRelay;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import timber.log.Timber;

/**
 * @author Mugiwara_Munyi
 * @date 29/05/2019
 */
@ScreenScope
final class TrendingReposViewModel {

    private final BehaviorRelay<List<Repo>> reposRelay = BehaviorRelay.create();
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

    Observable<List<Repo>> repos(){
        return reposRelay;
    }


    Consumer<List<Repo>> reposUpdated(){
        errorRelay.accept(-1);
        return reposRelay;
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
