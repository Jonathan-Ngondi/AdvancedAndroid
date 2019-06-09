package com.example.advancedandroid.lifecycle;

import android.view.View;

import com.example.advancedandroid.di.ActivityScope;

/**
 * @author Mugiwara_Munyi
 * @date 09/06/2019
 */
public abstract class ScreenLifecycleTask {

    /**
     * Callback received when a Screen becomes the visible screen.
     */

    public void onEnterScope(View view){

    }

    /**
     * Callback received when a Screen is moved to the back stack or popped.
     */
    public void onExitScope(){

    }

    /**
     * Callback received when a Screen is destroyed and will not be coming back (except as a new instance).
     * This should be used to clear any {@link ActivityScope} connections (Disposables, etc).
     */
    public void onDestroy(){

    }
}
