package com.thejoker.searchrepository.dagger.component;

import android.content.Context;

import com.thejoker.searchrepository.dagger.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    Retrofit exposeRetrofit();

    Context exposeContext();

}
