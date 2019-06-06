package com.example.advancedandroid.data;

import com.example.advancedandroid.models.Contributor;
import com.example.advancedandroid.models.Repo;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * @author Mugiwara_Munyi
 * @date 29/05/2019
 */
public class RepoRequester {

    private final RepoService service;

    @Inject
    RepoRequester(RepoService service){
        this.service = service;
    }

    Single<List<Repo>> getTrendingRepos(){
        return service.getTrendingRepos()
                .map(TrendingReposResponse::repos);
    }

    Single<Repo> getRepo(String repoName, String repoOwner){
        return service.getRepo(repoName, repoOwner);
    }

    Single<List<Contributor>> getContributors(String url){
        return service.getContributors(url);
    }
}
