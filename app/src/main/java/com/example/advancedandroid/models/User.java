package com.example.advancedandroid.models;

import com.google.auto.value.AutoValue;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

/**
 * @author Mugiwara_Munyi
 * @date 28/05/2019
 */
@AutoValue
public abstract class User {

    public abstract long id();

    public abstract String login();

    public static JsonAdapter<User> jsonAdapter(Moshi moshi){
        return new AutoValue_User.MoshiJsonAdapter(moshi);
    }

}
