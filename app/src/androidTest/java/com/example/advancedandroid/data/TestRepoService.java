package com.example.advancedandroid.data;

import com.example.advancedandroid.models.Contributor;
import com.example.advancedandroid.models.Repo;
import com.example.advancedandroid.test.TestUtils;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

/**
 * @author Mugiwara_Munyi
 * @date 01/06/2019
 */

@Singleton
public class TestRepoService implements RepoService{

    private boolean sendError;
    private TestUtils testUtils;

    @Inject
    TestRepoService(TestUtils testUtils){
        this.testUtils = testUtils;
    }
    @Override
    public Single<TrendingReposResponse> getTrendingRepos() {
        if(!sendError){
            TrendingReposResponse response = testUtils.loadJson("mock/get_trending_repos.json", TrendingReposResponse.class);
            return Single.just(response);
        }

        return Single.error(new IOException());
    }

    @Override
    public Single<Repo> getRepo(String repoOwner, String repoName) {
        return null;
    }

    @Override
    public Single<List<Contributor>> getContributors(String url) {
        return null;
    }


    public void setSendError(boolean sendError){
        this.sendError = sendError;
    }
}
