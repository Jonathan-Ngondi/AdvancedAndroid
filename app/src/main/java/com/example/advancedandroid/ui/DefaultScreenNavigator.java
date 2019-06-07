package com.example.advancedandroid.ui;

import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.Router;
import com.bluelinelabs.conductor.RouterTransaction;
import com.bluelinelabs.conductor.changehandler.FadeChangeHandler;
import com.example.advancedandroid.details.RepoDetailsController;

import javax.inject.Inject;

/**
 * @author Mugiwara_Munyi
 * @date 28/05/2019
 */

public class DefaultScreenNavigator implements ScreenNavigator {

    private Router router;

    @Inject DefaultScreenNavigator(){}

    @Override
    public void initWithRouter(Router router, Controller rootScreen) {
        this.router = router;
        if(!router.hasRootController()){
            router.setRoot(RouterTransaction.with(rootScreen));
        }

    }

    @Override
    public void goToRepoDetails(String repoOwner, String repoName) {
        if(router != null){
            router.pushController(RouterTransaction.with(RepoDetailsController.newInstance(repoName, repoOwner))
                    .pushChangeHandler(new FadeChangeHandler())
                    .popChangeHandler(new FadeChangeHandler()));
        }

    }

    @Override
    public boolean pop() {
        return router!=null && router.handleBack();
    }

    @Override
    public void clear() {
        router = null;
    }
}
