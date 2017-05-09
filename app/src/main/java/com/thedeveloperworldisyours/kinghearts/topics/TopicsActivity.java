package com.thedeveloperworldisyours.kinghearts.topics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.thedeveloperworldisyours.kinghearts.KingHeartsApplication;
import com.thedeveloperworldisyours.kinghearts.R;

public class TopicsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDagger();
    }


    public void initDagger() {
        // Create the presenter
        DaggerTopicsComponent.builder()
                .tasksRepositoryComponent(((KingHeartsApplication) getApplication()).getTopicsRepositoryComponent())
                .tasksPresenterModule(new TopicsPresenterModule(tsFragment)).build()
                .inject(this);
    }
}
