package com.thejoker.searchrepository.application;

import android.app.Application;

import com.thejoker.searchrepository.dagger.component.ApplicationComponent;
import com.thejoker.searchrepository.dagger.component.DaggerApplicationComponent;
import com.thejoker.searchrepository.dagger.module.ApplicationModule;

public class RepoApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initializaApplicationComponent();
    }

    private void initializaApplicationComponent() {
        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this, "https://api.github.com/search/"))
                .build();

    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

}
