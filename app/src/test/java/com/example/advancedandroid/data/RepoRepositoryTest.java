package com.example.advancedandroid.data;

import com.example.advancedandroid.models.Repo;
import com.example.advancedandroid.testutils.TestUtils;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Provider;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

/**
 * @author Mugiwara_Munyi
 * @date 04/06/2019
 */
public class RepoRepositoryTest {

    @Mock
    Provider<RepoRequester> repoRequesterProvider;
    @Mock RepoRequester repoRequester;

    private RepoRepository repository;
    private TrendingReposResponse trendingReposResponse;
    private Repo javaDesignPatterns;
    private Repo otherRepo;


    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
        when(repoRequesterProvider.get()).thenReturn(repoRequester);

        trendingReposResponse = TestUtils.loadJson("mock/get_trending_repos.json", TrendingReposResponse.class);

        when(repoRequester.getTrendingRepos()).thenReturn(Single.just(trendingReposResponse.repos()));

        javaDesignPatterns = trendingReposResponse.repos().get(0);
        otherRepo = trendingReposResponse.repos().get(1);
        repository = new RepoRepository(repoRequesterProvider, Schedulers.trampoline());
    }

    @Test
    public void getTrendingRepos() throws Exception{
        repository.getTrendingRepos().test().assertValue(trendingReposResponse.repos());

        List<Repo> modifiedList = new ArrayList<>(trendingReposResponse.repos());
        modifiedList.remove(0);
        when(repoRequester.getTrendingRepos()).thenReturn(Single.just(modifiedList));

        repository.getTrendingRepos().test().assertValue(trendingReposResponse.repos());
    }

    @Test
    public void getRepo() throws Exception {

        repository.getTrendingRepos().subscribe();

        when(repoRequester.getRepo(anyString(), anyString())).thenReturn(Single.just(otherRepo));

        repository.getRepo("iluwatar","java-design-patterns").test().assertValue(javaDesignPatterns);

        repository.getRepo("NotInCache", "NotInCache").test().assertValue(otherRepo);


    }
}