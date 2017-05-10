package com.thedeveloperworldisyours.kinghearts.topics;

import com.thedeveloperworldisyours.kinghearts.data.source.TopicsRepository;

import javax.inject.Inject;

/**
 * Created by javierg on 09/05/2017.
 */

public class TopicsPresenter implements TopicsContract.Presenter{

    private final TopicsRepository mTopicsRepository;

    private final TopicsContract.View mTopicsView;

    @Inject
    TopicsPresenter(TopicsRepository topicsRepository, TopicsContract.View topicsView) {
        mTopicsRepository = topicsRepository;
        mTopicsView = topicsView;
    }

    @Inject
    void setupListeners() {
        mTopicsView.setPresenter(this);
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unSubscribe() {

    }
}
