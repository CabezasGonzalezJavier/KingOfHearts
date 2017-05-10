package com.thedeveloperworldisyours.kinghearts;

import com.thedeveloperworldisyours.kinghearts.topics.TopicsActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by javierg on 10/05/2017.
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    void inject(TopicsActivity topicsActivity);
}
