package com.example.advancedandroid.details;

import com.example.advancedandroid.di.ScreenScope;

import javax.inject.Named;

import dagger.BindsInstance;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * @author Mugiwara_Munyi
 * @date 04/06/2019
 */
@ScreenScope
@Subcomponent
public interface RepoDetailsComponent extends AndroidInjector<RepoDetailsController> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<RepoDetailsController>{

        @BindsInstance
        public abstract void bindRepoOwner(@Named("repo_owner") String repoOwner);

        @BindsInstance
        public abstract void bindRepoName(@Named("repo_name") String repoName);

        @Override
        public void seedInstance(RepoDetailsController instance) {
            bindRepoOwner(instance.getArgs().getString(RepoDetailsController.REPO_OWNER_KEY));
            bindRepoName(instance.getArgs().getString(RepoDetailsController.REPO_NAME_KEY));
        }
    }
}
