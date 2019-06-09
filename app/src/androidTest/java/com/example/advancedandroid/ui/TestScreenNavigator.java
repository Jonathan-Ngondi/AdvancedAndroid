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
    private Controller overrideController;

    @Inject
    TestScreenNavigator(DefaultScreenNavigator screenNavigator){
        this.screenNavigator = screenNavigator;
    }

    /**
     * Set the Controller to launch when the Activity attaches to the Screen Navigator. This will be
     * used instead of the Controller passed in to {@link ScreenNavigator#initWithRouter(Router, Controller)}
     *
     * @param overrideController Controller to launch when the Activity starts. Or null to fall back to default.
     */
    public void overrideInitialController(Controller overrideController){
        this.overrideController = overrideController;
    }

    @Override
    public void initWithRouter(Router router, Controller rootScreen) {
        Controller launchController = overrideController==null?rootScreen: overrideController;
        screenNavigator.initWithRouter(router, launchController);

    }

    @Override
    public void goToRepoDetails(String repoOwner, String repoName) {
        screenNavigator.goToRepoDetails(repoOwner, repoName);
    }

    @Override
    public boolean pop() {
        return screenNavigator.pop();
    }

    @Override
    public void clear() {
        screenNavigator.clear();
    }
}
