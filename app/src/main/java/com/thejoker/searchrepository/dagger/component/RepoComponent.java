package com.thejoker.searchrepository.dagger.component;

import com.thejoker.searchrepository.dagger.module.RepoModule;
import com.thejoker.searchrepository.dagger.scope.PerActivity;
import com.thejoker.searchrepository.main.MainActivity;

import dagger.Component;

@PerActivity
@Component(modules = RepoModule.class, dependencies = ApplicationComponent.class)
public interface RepoComponent {

    void inject(MainActivity mainActivity);

}
