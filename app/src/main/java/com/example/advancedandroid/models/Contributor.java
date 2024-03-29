package com.example.advancedandroid.models;

import com.google.auto.value.AutoValue;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

/**
 * @author Mugiwara_Munyi
 * @date 29/05/2019
 */
@AutoValue
public abstract class Contributor {

    public abstract long id();

    public abstract String login();

    @Json(name = "avatar_url")
    public abstract String avatarUrl();

    public static JsonAdapter<Contributor> jsonAdapter(Moshi moshi){
        return new AutoValue_Contributor.MoshiJsonAdapter(moshi);
    }
}
