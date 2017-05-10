package com.thedeveloperworldisyours.kinghearts.topics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.thedeveloperworldisyours.kinghearts.KingHeartsApplication;
import com.thedeveloperworldisyours.kinghearts.R;
import com.thedeveloperworldisyours.kinghearts.data.source.TopicsDataSource;
import com.thedeveloperworldisyours.kinghearts.data.source.TopicsRepository;
import com.thedeveloperworldisyours.kinghearts.data.source.remote.TopicsRemoteDataSource;
import com.thedeveloperworldisyours.kinghearts.utils.ActivityUtils;
import com.thedeveloperworldisyours.kinghearts.utils.scheduler.BaseSchedulerProvider;
import com.thedeveloperworldisyours.kinghearts.utils.scheduler.SchedulerProvider;

import javax.inject.Inject;

public class TopicsActivity extends AppCompatActivity {

    private TopicsFragment mFragment;

//    @Inject TopicsPresenter mPresenter;

    @Inject
    TopicsDataSource mTopicsRemoteRepository;

    @Inject
    TopicsDataSource mTopicsLocalRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.topics_activity);

        initDagger();
        initFragment();

    }

    public void initFragment() {
        mFragment = (TopicsFragment) getSupportFragmentManager().findFragmentById(R.id.topics_activity_content_frame);

        if (mFragment == null) {
            mFragment = TopicsFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), mFragment, R.id.topics_activity_content_frame);
        }

        TopicsRepository topicsRepository = new TopicsRepository(mTopicsRemoteRepository, mTopicsLocalRepository);
        new TopicsPresenter(topicsRepository, mFragment);
    }

    public void initDagger() {
        KingHeartsApplication app = (KingHeartsApplication) getApplication();
        app.getAppComponent().inject();

//        mSchedulerProvider = new SchedulerProvider();
//
//        // Create the presenter
//        DaggerTopicsComponent.builder()
//                .
//                .inject(this);
    }
}
