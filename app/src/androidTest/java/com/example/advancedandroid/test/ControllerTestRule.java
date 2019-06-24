package com.example.advancedandroid.test;

import android.app.Activity;
import android.support.test.rule.ActivityTestRule;

import com.example.advancedandroid.base.TestApplication;
import com.example.advancedandroid.data.RepoRepository;
import com.example.advancedandroid.data.TestRepoService;
import com.example.advancedandroid.ui.TestScreenNavigator;

/**
 * @author Mugiwara_Munyi
 * @date 07/06/2019
 */
public class ControllerTestRule<T extends Activity> extends ActivityTestRule<T> {

    public final TestScreenNavigator screenNavigator;
    public final TestRepoService repoService;
    public final RepoRepository repoRepository;

    public ControllerTestRule(Class<T> activityClass){
        super(activityClass, true, false);
        screenNavigator = TestApplication.getComponent().screenNavigator();
        repoService = TestApplication.getComponent().repoService();
        repoRepository = TestApplication.getComponent().repoRepository();
    }

    public void clearState(){
        repoRepository.clearCache();
        repoService.clearErrorFlags();
        repoService.clearHoldFlags();
    }

}
