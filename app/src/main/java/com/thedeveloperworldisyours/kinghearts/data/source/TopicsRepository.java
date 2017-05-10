package com.thedeveloperworldisyours.kinghearts.data.source;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;

import com.thedeveloperworldisyours.kinghearts.data.Topic;
import com.thedeveloperworldisyours.kinghearts.utils.scheduler.BaseSchedulerProvider;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;
import rx.functions.Func1;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by javierg on 09/05/2017.
 */
@Singleton
public class TopicsRepository implements TopicsDataSource {

//    @Nullable
//    private static TopicsRepository INSTANCE = null;

    @NonNull
    private final TopicsDataSource mTopicsRemoteDataSource;

    @NonNull
    private final TopicsDataSource mTopicsLocalDataSource;

    /**
     * This variable has package local visibility so it can be accessed from tests.
     */
    @VisibleForTesting
    @Nullable
    Map<String, Topic> mCachedTopics;

    /**
     * Marks the cache as invalid, to force an update the next time data is requested. This variable
     * has package local visibility so it can be accessed from tests.
     */
    @VisibleForTesting
    boolean mCacheIsDirty = false;


//    // Prevent direct instantiation.
//    @Inject
    public TopicsRepository(@NonNull TopicsDataSource tasksRemoteDataSource,
                            @NonNull TopicsDataSource tasksLocalDataSource) {
        mTopicsRemoteDataSource = checkNotNull(tasksRemoteDataSource);
        mTopicsLocalDataSource = checkNotNull(tasksLocalDataSource);
    }

//    public static TopicsRepository getInstance(@NonNull TopicsDataSource tasksRemoteDataSource,
//                            @NonNull TopicsDataSource tasksLocalDataSource) {
//        if (INSTANCE == null) {
//            INSTANCE = new TopicsRepository(tasksRemoteDataSource, tasksLocalDataSource);
//        }
//        return INSTANCE;
//    }

//    @Inject
//    BaseSchedulerProvider mScheduler;

    @Override
    public Observable<List<Topic>> getTopics() {
        // Respond immediately with cache if available and not dirty
        if (mCachedTopics != null && !mCacheIsDirty) {
            return Observable.from(mCachedTopics.values()).toList();
        } else if (mCachedTopics == null) {
            mCachedTopics = new LinkedHashMap<>();
        }

        Observable<List<Topic>> remoteTopics = getAndSaveRemoteTopics();

        if (mCacheIsDirty) {
            return remoteTopics;
        } else {
            // Query the local storage if available. If not, query the network.
            Observable<List<Topic>> localTopics = getAndCacheLocalTopics();
            return Observable.concat(localTopics, remoteTopics)
                    .filter((topics) ->
                            !topics.isEmpty()
                    ).first();
        }
    }

    private Observable<List<Topic>> getAndCacheLocalTopics() {
        return mTopicsLocalDataSource.getTopics()
                .flatMap(new Func1<List<Topic>, Observable<List<Topic>>>() {
                    @Override
                    public Observable<List<Topic>> call(List<Topic> tasks) {
                        return Observable.from(tasks)
                                .doOnNext((Topic topic) ->
                                        mCachedTopics.put(String.valueOf(topic.getId()), topic)
                                )
                                .toList();
                    }
                });
    }


    private Observable<List<Topic>> getAndSaveRemoteTopics() {
        return mTopicsRemoteDataSource
                .getTopics()
                .flatMap(new Func1<List<Topic>, Observable<List<Topic>>>() {
                    @Override
                    public Observable<List<Topic>> call(List<Topic> tasks) {
                        return Observable.from(tasks).doOnNext((Topic topic) -> {
                                mTopicsLocalDataSource.saveTopic(topic);
                                mCachedTopics.put(String.valueOf(topic.getId()), topic);
                        }).toList();
                    }
                })
                .doOnCompleted(() ->
                        mCacheIsDirty = false
                );
    }

    @Override
    public void saveTopic(@NonNull Topic topic) {

        checkNotNull(topic);
//        mTopicsRemoteDataSource.saveTopic(topic);
        mTopicsLocalDataSource.saveTopic(topic);

        // Do in memory cache update to keep the app UI up to date
        if (mCachedTopics == null) {
            mCachedTopics = new LinkedHashMap<>();
        }
        mCachedTopics.put(String.valueOf(topic.getId()), topic);
    }
}
