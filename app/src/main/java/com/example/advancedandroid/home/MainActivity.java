package com.example.advancedandroid.home;

import com.bluelinelabs.conductor.Controller;
import com.example.advancedandroid.R;
import com.example.advancedandroid.base.BaseActivity;
import com.example.advancedandroid.trending.TrendingReposController;

public class MainActivity extends BaseActivity {

    @Override
    protected int layoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected Controller initialScreen() {
        return new TrendingReposController();
    }
}
