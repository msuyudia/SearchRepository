package com.thejoker.searchrepository.dagger.module;

import com.thejoker.searchrepository.api.ApiService;
import com.thejoker.searchrepository.mvp.view.MainView;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class RepoModule {

    private MainView mView;

    public RepoModule(MainView view) {
        mView = view;
    }

    @Provides
    MainView provideView() {
        return mView;
    }

    @Provides
    ApiService provideApiService(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }

}
