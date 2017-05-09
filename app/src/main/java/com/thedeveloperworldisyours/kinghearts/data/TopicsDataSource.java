package com.thedeveloperworldisyours.kinghearts.data;

import android.support.annotation.NonNull;

import java.util.List;

import rx.Observable;

/**
 * Created by javierg on 09/05/2017.
 */

public interface TopicsDataSource {
    Observable<List<Topic>> getTopics();

    void saveTopic(@NonNull Topic topic);
}
