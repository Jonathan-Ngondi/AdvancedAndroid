package com.example.advancedandroid.details;

import com.example.advancedandroid.data.RepoRepository;
import com.example.advancedandroid.di.ForScreen;
import com.example.advancedandroid.di.ScreenScope;
import com.example.advancedandroid.lifecycle.DisposableManager;
import com.example.poweradapter.adapter.RecyclerDataSource;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 * @author Mugiwara_Munyi
 * @date 06/06/2019
 */
@ScreenScope
public class RepoDetailsPresenter {


    @Inject
    RepoDetailsPresenter(
            @Named("repo_owner") String repoOwner,
            @Named("repo_name") String repoName,
            RepoRepository repoRepository,
            RepoDetailsViewModel viewModel,
            @ForScreen DisposableManager disposableManager,
            RecyclerDataSource contributorDataSource){
        //noinspection ResultOfMethodCallIgnored
        disposableManager.add(repoRepository.getRepo(repoOwner, repoName)
                .doOnSuccess(viewModel.processRepo())
                .doOnError(viewModel.detailsError())
                .flatMap(repo -> repoRepository.getContributors(repo.contributorsUrl())
                .doOnError(viewModel.contributorsError()))
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSuccess(contributorDataSource::setData)
                .subscribe(viewModel.contributorsLoaded(), throwable -> {
                    //We handle logging in the view model
                }));
     }

}

