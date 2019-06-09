package com.example.advancedandroid.details;

import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.runner.AndroidJUnit4;

import com.bluelinelabs.conductor.Controller;
import com.example.advancedandroid.R;
import com.example.advancedandroid.data.TestRepoService;
import com.example.advancedandroid.test.ControllerTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Mugiwara_Munyi
 * @date 09/06/2019
 */
@RunWith(AndroidJUnit4.class)
public class RepoDetailsControllerTest extends ControllerTest {

    @Before
    public void setUp(){
        testRule.clearState();
    }

    @Test
    public void repoDetailsSuccess(){
        launch();
        RepoDetailsRobot.init()
                .verifyLoadingVisibility(ViewMatchers.Visibility.GONE)
                .verifyName("RxJava")
                .verifyDescription("RxJava – Reactive Extensions for the JVM – a library for composing asynchronous and event-based programs using observable sequences for the Java VM.")
                .verifyCreatedDate("Jan 08, 2013")
                .verifyUpdatedDate("Oct 06, 2017");

    }

    @Test
    public void repoDetailsError(){
        repoService.setErrorFlags(TestRepoService.FLAG_GET_REPO);
        launch();
        RepoDetailsRobot.init()
                .verifyLoadingVisibility(ViewMatchers.Visibility.GONE)
                .verifyContentVisibility(ViewMatchers.Visibility.GONE)
                .verifyErrorText(R.string.api_error_single_repo);

    }

    @Test
    public void contributorSuccess(){
        launch();
        RepoDetailsRobot.init()
                .verifyContributorLoadingVisibility(ViewMatchers.Visibility.GONE)
                .verifyContributorErrorVisibility(ViewMatchers.Visibility.GONE)
                .verifyContributorShown("benjchristensen");
    }

    @Test
    public void contributorError(){
        repoService.setErrorFlags(TestRepoService.FLAG_GET_CONTRIBUTORS);
        launch();
        RepoDetailsRobot.init()
                .verifyLoadingVisibility(ViewMatchers.Visibility.GONE)
                .verifyContributorsErrorText(R.string.api_error_contributors);
    }

    @Test
    public void repoSuccessContributorError(){
        repoService.setErrorFlags(TestRepoService.FLAG_GET_CONTRIBUTORS);
        launch();
        RepoDetailsRobot.init()
                .verifyLoadingVisibility(ViewMatchers.Visibility.GONE)
                .verifyContributorLoadingVisibility(ViewMatchers.Visibility.GONE)
                .verifyErrorVisibility(ViewMatchers.Visibility.GONE)
                .verifyContributorsErrorText(R.string.api_error_contributors);
    }
    @Test
    public void loadingRepo(){
        repoService.setHoldFlags(TestRepoService.FLAG_GET_REPO);
        launch();
        RepoDetailsRobot.init()
                .verifyLoadingVisibility(ViewMatchers.Visibility.VISIBLE);

    }
    @Test
    public void loadingContributors(){
        repoService.setHoldFlags(TestRepoService.FLAG_GET_CONTRIBUTORS);
        launch();
        RepoDetailsRobot.init().verifyContributorLoadingVisibility(ViewMatchers.Visibility.VISIBLE);
    }

    @Override
    protected Controller controllerToLaunch() {
        return RepoDetailsController.newInstance("ReactiveX", "RxJava");
    }


}
