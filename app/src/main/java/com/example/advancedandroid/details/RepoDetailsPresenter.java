package com.example.advancedandroid.details;

import android.annotation.SuppressLint;

import com.example.advancedandroid.data.RepoRepository;
import com.example.advancedandroid.di.ScreenScope;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author Mugiwara_Munyi
 * @date 06/06/2019
 */
@ScreenScope
public class RepoDetailsPresenter {

    @SuppressLint("CheckResult")
    @Inject
    RepoDetailsPresenter(
            @Named("repo_owner") String repoOwner,
            @Named("repo_name") String repoName,
            RepoRepository repoRepository,
            RepoDetailsViewModel viewModel){
        //noinspection ResultOfMethodCallIgnored
        repoRepository.getRepo(repoOwner, repoName)
                .doOnSuccess(viewModel.processRepo())
                .doOnError(viewModel.detailsError())
                .flatMap(repo -> repoRepository.getContributors(repo.contributorsUrl())
                .doOnError(viewModel.contributorsError()))
                .subscribe(viewModel.processContributors(), throwable -> {
                    //We handle logging in the view model
                });
     }

}

