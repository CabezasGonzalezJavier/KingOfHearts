package com.thedeveloperworldisyours.kinghearts.data;

import java.util.List;

import rx.Observable;

/**
 * Created by javierg on 09/05/2017.
 */

public interface TopicsDataSource {
    Observable<List<Topics>> getTasks();
}
