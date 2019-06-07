package com.example.advancedandroid.ui;

import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.Router;

/**
 * @author Mugiwara_Munyi
 * @date 28/05/2019
 */
public interface ScreenNavigator {

    void initWithRouter(Router router, Controller rootScreen);

    void goToRepoDetails(String repoOwner, String repoName);

    boolean pop();

    void clear();
}
