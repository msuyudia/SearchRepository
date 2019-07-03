package com.thejoker.searchrepository.mvp.presenter;

import com.thejoker.searchrepository.api.ApiService;
import com.thejoker.searchrepository.base.BasePresenter;
import com.thejoker.searchrepository.mvp.model.Item;
import com.thejoker.searchrepository.mvp.model.Repo;
import com.thejoker.searchrepository.mvp.view.MainView;

import java.util.ArrayList;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;

public class RepoPresenter extends BasePresenter<MainView> implements Observer<Repo> {

    @Inject
    protected ApiService mApiService;

    @Inject
    public RepoPresenter() {
    }

    public void getRepo() {
        getView().onShowDialog("Loading...");
        Observable<Repo> repoObservable = mApiService.getRepo();
        subscribe(repoObservable, this);
    }

    public void findTopic(String topic) {
        getView().onShowDialog("Finding topic...");
        Observable<Repo> repoObservable2 = mApiService.findTopic(topic);
        subscribe(repoObservable2, this);
    }

    @Override
    public void onCompleted() {
        getView().onHideDialog();
        getView().onShowToast("Connection Success");
    }

    @Override
    public void onError(Throwable e) {
        getView().onHideDialog();
        getView().onShowToast("Connection Failed");
    }

    @Override
    public void onNext(Repo repo) {
        ArrayList<Item> list = repo.getItems();
        getView().onClearItem();
        getView().onRepoLoad(list);
    }

}
