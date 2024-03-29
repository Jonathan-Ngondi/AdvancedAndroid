package com.example.advancedandroid.trending;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.advancedandroid.R;
import com.example.advancedandroid.base.BaseController;

import javax.inject.Inject;

import butterknife.BindView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

/**
 * @author Mugiwara_Munyi
 * @date 27/05/2019
 */
public class TrendingReposController extends BaseController {

    @Inject TrendingReposPresenter presenter;
    @Inject TrendingReposViewModel viewModel;

    @BindView(R.id.repo_list)
    RecyclerView repoList;
    @BindView(R.id.loading_indicator)
    ProgressBar loadingView;
    @BindView(R.id.tv_error)
    TextView errorTextView;

    @Override
    protected void onViewBound(View view) {
        repoList.setLayoutManager(new LinearLayoutManager(view.getContext()));
        repoList.setAdapter(new RepoAdapter(presenter));
    }

    @Override
    protected int layoutRes() {
        return R.layout.screen_trending_repos;
    }

    @Override
    protected Disposable[] subscriptions() {
        return new Disposable[]{
                viewModel.loading()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(loading -> {
                    loadingView.setVisibility(loading ? View.VISIBLE : View.GONE);
                    repoList.setVisibility(loading ? View.GONE : View.VISIBLE);
                    errorTextView.setVisibility(loading ? View.GONE: errorTextView.getVisibility());
                }),
                viewModel.repos()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(((RepoAdapter)repoList.getAdapter())::setData),
                viewModel.error()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(errorRes ->{
                            if(errorRes == -1){
                                errorTextView.setText(null);
                                errorTextView.setVisibility(View.GONE);
                            } else {
                                errorTextView.setVisibility(View.VISIBLE);
                                repoList.setVisibility(View.GONE);
                                errorTextView.setText(errorRes);
                            }
                })
        };
    }
}
