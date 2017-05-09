package com.thedeveloperworldisyours.kinghearts.data.remote;

import com.thedeveloperworldisyours.kinghearts.data.Topic;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by javierg on 09/05/2017.
 */

public interface Service {
    String URL_BASE = "https://guessthebeach.herokuapp.com/api/";

    @GET("topics/")
    Observable<List<Topic>> getTopicsRx();

}

