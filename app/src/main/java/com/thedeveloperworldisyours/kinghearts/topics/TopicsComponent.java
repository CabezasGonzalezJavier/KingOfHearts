package com.thedeveloperworldisyours.kinghearts.topics;

import com.thedeveloperworldisyours.kinghearts.data.TopicsRepositoryComponent;
import com.thedeveloperworldisyours.kinghearts.utils.FragmentScoped;

import dagger.Component;
import dagger.Module;
import dagger.Provides;

/**
 * Created by javierg on 09/05/2017.
 */
@FragmentScoped
@Component(dependencies = TopicsRepositoryComponent.class, modules = TopicsPresenterModule.class)
public class TopicsComponent {
}
