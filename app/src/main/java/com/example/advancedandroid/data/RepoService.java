package com.example.advancedandroid.data;

import com.example.advancedandroid.models.Contributor;
import com.example.advancedandroid.models.Repo;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Url;

/**
 * @author Mugiwara_Munyi
 * @date 29/05/2019
 */
public interface RepoService {

    @GET("search/repositories?q=language:java&order=desc&sort=stars")
    Single<TrendingReposResponse> getTrendingRepos();

    @GET("repos/{owner}/{name}")
    Single<Repo> getRepo(@Path("owner") String repoOwner, @Path("name") String repoName);

    @GET
    Single<List<Contributor>> getContributors(@Url String url);

}
