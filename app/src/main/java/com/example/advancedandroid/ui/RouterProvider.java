package com.example.advancedandroid.ui;

import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.Router;

/**
 * @author Mugiwara_Munyi
 * @date 09/06/2019
 */
public interface RouterProvider {

    Router getRouter();

    Controller initialScreen();
}
