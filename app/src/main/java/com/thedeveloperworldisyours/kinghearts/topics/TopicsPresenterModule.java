package com.thedeveloperworldisyours.kinghearts.topics;

import dagger.Module;
import dagger.Provides;

/**
 * Created by javierg on 09/05/2017.
 */
@Module
public class TopicsPresenterModule {
    private final TopicsContract.View mView;

    public TopicsPresenterModule(TopicsContract.View view) {
        mView = view;
    }

    @Provides
    TopicsContract.View provideTopicsContractView() {return mView;}
}
