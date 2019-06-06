package com.example.advancedandroid.trending;

import com.example.advancedandroid.data.RepoRepository;
import com.example.advancedandroid.data.TrendingReposResponse;
import com.example.advancedandroid.models.Repo;
import com.example.advancedandroid.testutils.TestUtils;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.util.List;

import io.reactivex.Single;
import io.reactivex.functions.Consumer;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

/**
 * @author Mugiwara_Munyi
 * @date 31/05/2019
 */
public class TrendingReposPresenterTest {

    @Mock
    RepoRepository repoRepository;
    @Mock TrendingReposViewModel trendingViewModel;
    @Mock Consumer<Throwable> onErrorConsumer;
    @Mock Consumer<List<Repo>> onSuccessConsumer;
    @Mock Consumer<Boolean> loadingConsumer;

    private TrendingReposPresenter presenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        when(trendingViewModel.loadingUpdated()).thenReturn(loadingConsumer);
        when(trendingViewModel.onError()).thenReturn(onErrorConsumer);
        when(trendingViewModel.reposUpdated()).thenReturn(onSuccessConsumer);

    }

    @Test
    public void reposLoaded() throws Exception{
        List<Repo> repos = setUpSuccess();
        initializePresenter();
        verify(repoRepository).getTrendingRepos();
        verify(onSuccessConsumer).accept(repos);
        verifyZeroInteractions(onErrorConsumer);
    }

    @Test
    public void reposLoadedError()throws Exception {
        Throwable error = setUpError();
        initializePresenter();

        verify(onErrorConsumer).accept(error);
        verifyZeroInteractions(onErrorConsumer);
    }

    @Test
    public void loadingSuccess() throws Exception {
        setUpSuccess();
        initializePresenter();

        InOrder inOrder = Mockito.inOrder(loadingConsumer);
        inOrder.verify(loadingConsumer).accept(true);
        inOrder.verify(loadingConsumer).accept(false);
    }

    @Test
    public void loadingError() throws Exception {
        //noinspection ThrowableNotThrown
        setUpError();
        initializePresenter();

        InOrder inOrder = Mockito.inOrder(loadingConsumer);
        inOrder.verify(loadingConsumer).accept(true);
        inOrder.verify(loadingConsumer).accept(false);
    }

    @Test
    public void onRepoClicked() throws Exception {
        //TODO
    }



    private List<Repo> setUpSuccess() {
        List<Repo> repos;
        TrendingReposResponse  response = TestUtils.loadJson("mock/get_trending_repos.json", TrendingReposResponse.class);
        repos = response.repos();

        when(repoRepository.getTrendingRepos()).thenReturn(Single.just(repos));
        return repos;

    }

    private Throwable setUpError(){
        Throwable error = new IOException();
        when(repoRepository.getTrendingRepos()).thenReturn(Single.error(error));
        return error;
    }
    private void initializePresenter(){
        presenter = new TrendingReposPresenter(trendingViewModel, repoRepository);
    }
}