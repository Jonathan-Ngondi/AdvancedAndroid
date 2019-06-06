package com.example.advancedandroid.trending;

import android.annotation.SuppressLint;

import com.example.advancedandroid.data.RepoRepository;
import com.example.advancedandroid.di.ScreenScope;
import com.example.advancedandroid.models.Repo;

import javax.inject.Inject;

/**
 * @author Mugiwara_Munyi
 * @date 29/05/2019
 */
@ScreenScope
final class TrendingReposPresenter implements RepoAdapter.RepoClickedListener {

    private final TrendingReposViewModel viewModel;
    private final RepoRepository reposRepository;
    
    @Inject
    TrendingReposPresenter(TrendingReposViewModel viewModel, RepoRepository reposRepository){
        this.viewModel = viewModel;
        this.reposRepository = reposRepository;
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

    }
}
