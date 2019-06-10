package com.example.advancedandroid.trending;

import com.example.advancedandroid.R;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import io.reactivex.observers.TestObserver;

/**
 * @author Mugiwara_Munyi
 * @date 30/05/2019
 */
public class TrendingReposViewModelTest {

    private TrendingReposViewModel viewModel;

    @Before
    public void setUp() throws Exception {
        viewModel = new TrendingReposViewModel();
    }

    @Test
    public void loading() throws Exception {
        TestObserver<Boolean> loadingObserver = viewModel.loading().test();

        viewModel.loadingUpdated().accept(true);
        viewModel.loadingUpdated().accept(false);

        loadingObserver.assertValues(true, false);



    }

    @Test
    public void error() throws Exception {
        TestObserver<Integer> errorObserver = viewModel.error().test();
        viewModel.onError().accept(new IOException());
        viewModel.reposUpdated().run();

        errorObserver.assertValues(R.string.api_error_repos, -1);
    }

}