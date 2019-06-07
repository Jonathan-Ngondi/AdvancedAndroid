package com.example.advancedandroid.trending;

import android.annotation.SuppressLint;

import com.example.advancedandroid.data.RepoRepository;
import com.example.advancedandroid.di.ScreenScope;
import com.example.advancedandroid.models.Repo;
import com.example.advancedandroid.ui.ScreenNavigator;

import javax.inject.Inject;

/**
 * @author Mugiwara_Munyi
 * @date 29/05/2019
 */
@ScreenScope
final class TrendingReposPresenter implements RepoAdapter.RepoClickedListener {

    private final TrendingReposViewModel viewModel;
    private final RepoRepository reposRepository;
    private final ScreenNavigator screenNavigator;

    @Inject
    TrendingReposPresenter(TrendingReposViewModel viewModel,
                           RepoRepository reposRepository,
                           ScreenNavigator screenNavigator){
        this.viewModel = viewModel;
        this.reposRepository = reposRepository;
        this.screenNavigator = screenNavigator;
        loadRepos();
    }


    @SuppressLint("CheckResult")
    private void loadRepos() {
        //noinspection ResultOfMethodCallIgnored
        reposRepository.getTrendingRepos()
                .doOnSubscribe( __ -> viewModel.loadingUpdated().accept(true))
                .doOnEvent((d,t) -> viewModel.loadingUpdated().accept(false))
                .subscribe(viewModel.reposUpdated(),viewModel.onError());

    }

    @Override
    public void onRepoClicked(Repo repo) {
        screenNavigator.goToRepoDetails(repo.owner().login(), repo.name());

    }
}
