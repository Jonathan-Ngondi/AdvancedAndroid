package com.example.advancedandroid.database.favorites;

import com.example.advancedandroid.database.AppDatabase;
import com.example.advancedandroid.models.Contributor;
import com.jakewharton.rxrelay2.BehaviorRelay;

import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

/**
 * @author Mugiwara_Munyi
 * @date 11/06/2019
 */
@Singleton
public class FavoriteService {


    private final AppDatabase appDatabase;
    private final BehaviorRelay<Set<Long>> favoritedContributorIdRelay = BehaviorRelay.createDefault(new HashSet<>());


    @Inject
    FavoriteService(AppDatabase appDatabase){

        this.appDatabase = appDatabase;
        appDatabase.favoriteContributorDao().getFavoritedContributors()
                .subscribeOn(Schedulers.io())
                .map(favoriteContributors -> {
                    Set<Long> contributorIds = new HashSet<>();
                    for (FavoriteContributor favoriteContributor : favoriteContributors){
                        contributorIds.add(favoriteContributor.getId());
                    }
                    return contributorIds;
                })
                .subscribe(favoritedContributorIdRelay, throwable -> Timber.e(throwable, "Error getting favorited Ids"));
    }

    public Observable<Set<Long>> favoritedContributorIds(){
        return favoritedContributorIdRelay;
    }

    public void toggleFavoriteContributors(Contributor contributor){
        runDbOp(() -> {
            if (favoritedContributorIdRelay.getValue().contains(contributor.getId())){
                deleteFavoriteContributor(contributor);
            }else{
                addFavoriteContributor(contributor);
            }


        });

    }

    private void addFavoriteContributor(Contributor contributor) {
        appDatabase.favoriteContributorDao().addFavorite(new FavoriteContributor(contributor.id()));
    }

    private void deleteFavoriteContributor(Contributor contributor) {
        appDatabase.favoriteContributorDao().deleteFavorite(new FavoriteContributor(contributor.id()));
    }

    private void runDbOp(Action action){
        Completable.fromAction(action)
                .subscribeOn(Schedulers.io())
                .subscribe(() -> {}, throwable -> Timber.e(throwable, "Error performing database operations"));
    }
}


