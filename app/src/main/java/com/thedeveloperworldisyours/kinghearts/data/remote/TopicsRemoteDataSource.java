package com.thedeveloperworldisyours.kinghearts.data.remote;

import android.support.annotation.NonNull;

import com.thedeveloperworldisyours.kinghearts.data.Topic;
import com.thedeveloperworldisyours.kinghearts.data.TopicsDataSource;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by javierg on 09/05/2017.
 */

public class TopicsRemoteDataSource implements TopicsDataSource {


    public static final int TIMER_HTTP_OK = 5;

    @Override
    public Observable<List<Topic>> getTopics() {
        return getService().getTopicsRx();
    }

    public OkHttpClient getOkHttpClient() {
        return new OkHttpClient().newBuilder()
                .connectTimeout(TIMER_HTTP_OK, TimeUnit.SECONDS)
                .readTimeout(TIMER_HTTP_OK, TimeUnit.SECONDS)
                .writeTimeout(TIMER_HTTP_OK, TimeUnit.SECONDS)
                .build();
    }

    public Service getService() {
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Service.URL_BASE)
                .client(getOkHttpClient())
                .build();

        return retrofit.create(Service.class);
    }

    @Override
    public void saveTopic(@NonNull Topic topic) {

    }
}
