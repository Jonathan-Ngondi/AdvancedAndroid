package com.example.advancedandroid.di;

import com.bluelinelabs.conductor.Controller;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

import dagger.MapKey;

/**
 * @author Mugiwara_Munyi
 * @date 27/05/2019
 */
@MapKey
@Target(ElementType.METHOD)
public @interface ControllerKey {
    Class<? extends Controller> value();
}
