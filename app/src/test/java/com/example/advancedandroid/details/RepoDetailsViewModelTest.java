package com.example.advancedandroid.details;

import com.example.advancedandroid.R;
import com.example.advancedandroid.models.Contributor;
import com.example.advancedandroid.models.Repo;
import com.example.advancedandroid.testutils.TestUtils;
import com.squareup.moshi.Types;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * @author Mugiwara_Munyi
 * @date 05/06/2019
 */
public class RepoDetailsViewModelTest {

    private RepoDetailsViewModel viewModel;
    private Repo repo = TestUtils.loadJson("mock/get_repo.json", Repo.class);
    private List<Contributor> contributors = TestUtils.loadJson("mock/get_contributors.json", Types.newParameterizedType(List.class, Contributor.class));


    @Before
    public void setUp() throws Exception {
        viewModel = new RepoDetailsViewModel();
    }

    @Test
    public void contributors() throws Exception{
        viewModel.processContributors().accept(contributors);

        viewModel.contributors().test().assertValue(ContributorState.builder()
                .loading(false)
                .contributors(contributors)
                .build());
    }

    @Test
    public void details() throws Exception {
        viewModel.processRepo().accept(repo);

        viewModel.details().test().assertValue(RepoDetailState.builder()
                .loading(false)
                .name("RxJava")
                .description("RxJava – Reactive Extensions for the JVM – a library for composing asynchronous and event-based programs using observable sequences for the Java VM.")
                .createdDate("Jan 08, 2013")
                .updatedDate("Oct 06, 2017")
                .build());
    }

    @Test
    public void detailsError() throws Exception {
        viewModel.detailsError().accept(new IOException());

        viewModel.details().test().assertValue(
                RepoDetailState.builder()
                        .loading(false)
                        .errorRes(R.string.api_error_single_repo)
                        .build()
        );
    }

    @Test
    public void contributorsError() throws Exception {
        viewModel.contributorsError().accept(new IOException());

        viewModel.contributors().test().assertValue(
                ContributorState.builder()
                        .loading(false)
                        .errorRes(R.string.api_error_contributors)
                        .build()
        );
    }
}