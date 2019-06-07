package com.example.advancedandroid.ui;

import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.Router;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author Mugiwara_Munyi
 * @date 07/06/2019
 */

@Singleton
public class TestScreenNavigator implements ScreenNavigator {

    private final DefaultScreenNavigator screenNavigator;

    @Inject
    TestScreenNavigator(DefaultScreenNavigator screenNavigator){
        this.screenNavigator = screenNavigator;
    }

    @Override
    public void initWithRouter(Router router, Controller rootScreen) {

    }

    @Override
    public void goToRepoDetails(String repoOwner, String repoName) {

    }

    @Override
    public boolean pop() {
        return false;
    }

    @Override
    public void clear() {

    }
}
