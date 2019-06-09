package com.example.advancedandroid.test;

import android.content.Intent;

import com.bluelinelabs.conductor.Controller;
import com.example.advancedandroid.data.RepoRepository;
import com.example.advancedandroid.data.TestRepoService;
import com.example.advancedandroid.home.MainActivity;
import com.example.advancedandroid.ui.TestScreenNavigator;

import org.junit.Rule;

/**
 * @author Mugiwara_Munyi
 * @date 07/06/2019
 */
public abstract class ControllerTest {

    @Rule
    public ControllerTestRule<MainActivity> testRule = new ControllerTestRule<>(MainActivity.class);

    protected TestRepoService repoService = testRule.repoService;
    protected TestScreenNavigator screenNavigator = testRule.screenNavigator;
    protected RepoRepository repoRepository = testRule.repoRepository;
    
    public ControllerTest(){
        screenNavigator.overrideInitialController(controllerToLaunch());
    }

    protected abstract Controller controllerToLaunch();

    protected void launch(){
        launch(null);
    }

    protected void launch(Intent intent){
        testRule.launchActivity(intent);
    }
}
