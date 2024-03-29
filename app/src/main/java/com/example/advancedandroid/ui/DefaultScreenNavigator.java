package com.example.advancedandroid.ui;

import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.Router;
import com.bluelinelabs.conductor.RouterTransaction;
import com.example.advancedandroid.di.ActivityScope;

import javax.inject.Inject;

/**
 * @author Mugiwara_Munyi
 * @date 28/05/2019
 */
@ActivityScope
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
    public boolean pop() {
        return router!=null && router.handleBack();
    }

    @Override
    public void clear() {
        router = null;
    }
}
