package com.thejoker.searchrepository.api;

import com.thejoker.searchrepository.mvp.model.Repo;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface ApiService {

    @GET("repositories?q=topic")
    Observable<Repo> getRepo();

    @GET("repositories")
    Observable<Repo> findTopic(@Query("q") String topic);

}
