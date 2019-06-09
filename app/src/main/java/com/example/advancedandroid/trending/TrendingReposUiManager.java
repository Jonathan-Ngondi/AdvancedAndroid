package com.example.advancedandroid.trending;

import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.advancedandroid.R;
import com.example.advancedandroid.di.ScreenScope;
import com.example.advancedandroid.lifecycle.ScreenLifecycleTask;
import com.example.advancedandroid.util.ButterKnifeUtils;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author Mugiwara_Munyi
 * @date 09/06/2019
 */

@ScreenScope
public class TrendingReposUiManager extends ScreenLifecycleTask {

    @BindView(R.id.toolbar) Toolbar toolbar;
    private Unbinder unbinder;

    @Inject
    TrendingReposUiManager(){

    }

    @Override
    public void onEnterScope(View view) {
        unbinder = ButterKnife.bind(this, view);
        toolbar.setTitle(R.string.screen_title_trending);
    }

    @Override
    public void onExitScope() {
        ButterKnifeUtils.unbind(unbinder);
    }
}
