package com.habeeb.android_mvvm_boilerplate.ui.feed;

import com.habeeb.android_mvvm_boilerplate.data.DataManager;
import com.habeeb.android_mvvm_boilerplate.ui.base.BaseViewModel;
import com.habeeb.android_mvvm_boilerplate.utils.rx.SchedulerProvider;

/**
 * Created by HABEEB on 24/04/19.
 */

public class FeedViewModel extends BaseViewModel {

    public FeedViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }
}
