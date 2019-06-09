package com.example.advancedandroid.details;

import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.advancedandroid.R;
import com.example.advancedandroid.di.ScreenScope;
import com.example.advancedandroid.lifecycle.ScreenLifecycleTask;
import com.example.advancedandroid.ui.ScreenNavigator;
import com.example.advancedandroid.util.ButterKnifeUtils;

import javax.inject.Inject;
import javax.inject.Named;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author Mugiwara_Munyi
 * @date 09/06/2019
 */
@ScreenScope
public class RepoDetailsUiManager extends ScreenLifecycleTask {

    private final String repoName;
    private final ScreenNavigator screenNavigator;
    @BindView(R.id.toolbar) Toolbar toolbar;
    private Unbinder unbinder;

    @Inject
    RepoDetailsUiManager(@Named("repo_name") String repoName, ScreenNavigator screenNavigator){
        this.repoName = repoName;
        this.screenNavigator = screenNavigator;
    }

    @Override
    public void onEnterScope(View view) {
        unbinder = ButterKnife.bind(this, view);
        toolbar.setTitle(repoName);
        toolbar.setNavigationIcon(R.drawable.ic_back);
        toolbar.setNavigationOnClickListener(v -> screenNavigator.pop());
    }

    @Override
    public void onExitScope() {
        toolbar.setNavigationOnClickListener(null);
        ButterKnifeUtils.unbind(unbinder);
    }
}
