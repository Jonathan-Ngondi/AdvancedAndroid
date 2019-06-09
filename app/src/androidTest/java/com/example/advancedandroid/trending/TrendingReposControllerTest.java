package com.example.advancedandroid.trending;

import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.runner.AndroidJUnit4;

import com.bluelinelabs.conductor.Controller;
import com.example.advancedandroid.R;
import com.example.advancedandroid.base.TestApplication;
import com.example.advancedandroid.data.TestRepoService;
import com.example.advancedandroid.test.ControllerTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;

/**
 * @author Mugiwara_Munyi
 * @date 03/06/2019
 */
@RunWith(AndroidJUnit4.class)
public class TrendingReposControllerTest extends ControllerTest {


    @Before
    public void setUp(){

        TestApplication.getComponent().inject(this);

    }

    @Test
    public void loadRepos(){
        repoService.clearErrorFlags();
        launch();

        onView(withId(R.id.loading_indicator)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)));
        onView(withId(R.id.tv_error)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)));
        onView(withId(R.id.repo_list)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));

        onView(allOf(withId(R.id.tv_repo_name), withText("java-design-patterns"))).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
    }

    @Test
    public void loadReposError(){
        repoService.setErrorFlags(TestRepoService.FLAG_TRENDING_REPOS);
        launch();
        onView(withId(R.id.loading_indicator)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)));
        onView(withId(R.id.repo_list)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)));

        onView(withId(R.id.tv_error)).check(matches(allOf(withText(R.string.api_error_repos), withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE))));

    }

    @Override
    protected Controller controllerToLaunch() {
        return new TrendingReposController();
    }
}
