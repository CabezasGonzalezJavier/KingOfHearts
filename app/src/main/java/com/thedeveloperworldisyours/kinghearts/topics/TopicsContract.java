package com.thedeveloperworldisyours.kinghearts.topics;

import com.thedeveloperworldisyours.kinghearts.BasePresenter;
import com.thedeveloperworldisyours.kinghearts.BaseView;

/**
 * Created by javierg on 09/05/2017.
 */

public interface TopicsContract {

    interface View extends BaseView<Presenter> {}

    interface Presenter extends BasePresenter {}
}
