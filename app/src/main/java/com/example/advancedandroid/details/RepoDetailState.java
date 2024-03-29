package com.example.advancedandroid.details;

import com.google.auto.value.AutoValue;

import javax.annotation.Nullable;

/**
 * @author Mugiwara_Munyi
 * @date 05/06/2019
 */
@AutoValue
abstract class RepoDetailState {

    abstract boolean loading();

    @Nullable
    abstract String name();

    @Nullable
    abstract String description();

    @Nullable
    abstract String createdDate();

    @Nullable
    abstract String updatedDate();

    @Nullable
    abstract Integer errorRes();

    static Builder builder(){
        return new AutoValue_RepoDetailState.Builder();
    }

    @AutoValue.Builder
    abstract static class Builder{

        abstract Builder loading(boolean loading);

        abstract Builder name(String name);

        abstract Builder description(String description);

        abstract Builder createdDate(String createdDate);

        abstract Builder updatedDate(String updatedDate);

        abstract Builder errorRes(Integer errorRes);

        abstract RepoDetailState build();

    }
}
