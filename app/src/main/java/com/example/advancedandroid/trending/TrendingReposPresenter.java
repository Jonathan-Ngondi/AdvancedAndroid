package com.example.advancedandroid.trending;

import com.example.advancedandroid.data.RepoRepository;
import com.example.advancedandroid.di.ForScreen;
import com.example.advancedandroid.di.ScreenScope;
import com.example.advancedandroid.lifecycle.DisposableManager;
import com.example.advancedandroid.models.Repo;
import com.example.advancedandroid.ui.ScreenNavigator;
import com.example.poweradapter.adapter.RecyclerDataSource;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 * @author Mugiwara_Munyi
 * @date 29/05/2019
 */
@ScreenScope
final class TrendingReposPresenter {

    private final TrendingReposViewModel viewModel;
    private final RepoRepository reposRepository;
    private final ScreenNavigator screenNavigator;
    private final DisposableManager disposableManager;
    private final RecyclerDataSource dataSource;

    @Inject
    TrendingReposPresenter(TrendingReposViewModel viewModel,
                           RepoRepository reposRepository,
                           ScreenNavigator screenNavigator,
                           @ForScreen DisposableManager disposableManager,
                            RecyclerDataSource dataSource){
        this.viewModel = viewModel;
        this.reposRepository = reposRepository;
        this.screenNavigator = screenNavigator;
        this.disposableManager = disposableManager;
        this.dataSource = dataSource;

        loadRepos();
    }


    private void loadRepos() {

        disposableManager.add(reposRepository.getTrendingRepos()
                .doOnSubscribe( __ -> viewModel.loadingUpdated().accept(true))
                .doOnEvent((d,t) -> viewModel.loadingUpdated().accept(false))
                .doOnSuccess(__ -> viewModel.reposUpdated().run())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(dataSource::setData,viewModel.onError()));

    }


    void onRepoClicked(Repo repo) {
        screenNavigator.goToRepoDetails(repo.owner().login(), repo.name());

    }
}
