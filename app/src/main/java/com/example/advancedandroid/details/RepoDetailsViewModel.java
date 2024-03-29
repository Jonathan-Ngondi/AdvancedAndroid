package com.example.advancedandroid.details;

import com.example.advancedandroid.R;
import com.example.advancedandroid.di.ScreenScope;
import com.example.advancedandroid.models.Contributor;
import com.example.advancedandroid.models.Repo;
import com.jakewharton.rxrelay2.BehaviorRelay;

import org.threeten.bp.format.DateTimeFormatter;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import timber.log.Timber;

/**
 * @author Mugiwara_Munyi
 * @date 05/06/2019
 */
@ScreenScope
public class RepoDetailsViewModel {


    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("MMM dd, yyyy");
    private final BehaviorRelay<RepoDetailState> detailStateStateRelay = BehaviorRelay.create();
    private final BehaviorRelay<ContributorState> contributorStateRelay = BehaviorRelay.create();


    @Inject RepoDetailsViewModel(){
        detailStateStateRelay.accept(RepoDetailState.builder().loading(true).build());
        contributorStateRelay.accept(ContributorState.builder().loading(true).build());
    }

    Observable<ContributorState> contributors() {
        return contributorStateRelay;
    }

    Observable<RepoDetailState> details(){
        return detailStateStateRelay;
    }

    Consumer<Repo> processRepo(){
        return repo -> detailStateStateRelay.accept(RepoDetailState.builder()
                .loading(false)
                .name(repo.name())
                .description(repo.description())
                .createdDate(repo.createdDate().format(DATE_FORMATTER))
                .updatedDate(repo.updatedDate().format(DATE_FORMATTER))
                .build());
    }

    Consumer<List<Contributor>> processContributors(){
        return contributors -> contributorStateRelay.accept(ContributorState.builder()
                .loading(false)
                .contributors(contributors)
                .build());
    }

    Consumer<Throwable> detailsError(){
        return throwable -> {
            Timber.e(throwable, "Error loading repo details");
            detailStateStateRelay.accept(
                    RepoDetailState.builder()
                            .loading(false)
                            .errorRes(R.string.api_error_single_repo)
                            .build()
            );
        };

    }

    Consumer<Throwable> contributorsError(){
        return throwable -> {
            Timber.e(throwable, "Error loading contributors");
            contributorStateRelay.accept(
                    ContributorState.builder()
                            .loading(false)
                            .errorRes(R.string.api_error_contributors)
                            .build()
            );
        };
    }
}
