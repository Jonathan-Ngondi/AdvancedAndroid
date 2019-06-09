package com.example.advancedandroid.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * @author Mugiwara_Munyi
 * @date 09/06/2019
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface ForScreen {
}
