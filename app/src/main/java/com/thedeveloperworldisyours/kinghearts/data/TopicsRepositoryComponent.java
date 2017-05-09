package com.thedeveloperworldisyours.kinghearts.data;

import com.thedeveloperworldisyours.kinghearts.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by javierg on 09/05/2017.
 */
@Singleton
@Component(modules = {TopicsRepositoryModule.class, AppModule.class})
public interface TopicsRepositoryComponent {

    TopicsRepository getTopicsRepository();
}
