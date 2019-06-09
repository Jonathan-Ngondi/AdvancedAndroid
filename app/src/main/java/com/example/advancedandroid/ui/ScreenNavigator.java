package com.example.advancedandroid.ui;

/**
 * @author Mugiwara_Munyi
 * @date 28/05/2019
 */
public interface ScreenNavigator {

    void goToRepoDetails(String repoOwner, String repoName);

    boolean pop();
}
