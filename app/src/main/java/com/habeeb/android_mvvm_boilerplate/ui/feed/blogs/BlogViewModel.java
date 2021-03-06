/*
 *  Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      https://mindorks.com/license/apache-v2
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License
 */

package com.habeeb.android_mvvm_boilerplate.ui.feed.blogs;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;

import com.habeeb.android_mvvm_boilerplate.data.DataManager;
import com.habeeb.android_mvvm_boilerplate.data.model.api.BlogResponse;
import com.habeeb.android_mvvm_boilerplate.ui.base.BaseViewModel;
import com.habeeb.android_mvvm_boilerplate.utils.rx.SchedulerProvider;

import java.util.List;

/**
 * Created by HABEEB on 24/04/19.
 */

public class BlogViewModel extends BaseViewModel<BlogNavigator> {

    public final ObservableList<BlogResponse.Blog> blogObservableArrayList = new ObservableArrayList<>();

    private final MutableLiveData<List<BlogResponse.Blog>> blogListLiveData;

    public BlogViewModel(DataManager dataManager,
                         SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
        blogListLiveData = new MutableLiveData<>();
        fetchBlogs();
    }

    public void addBlogItemsToList(List<BlogResponse.Blog> blogs) {
        blogObservableArrayList.clear();
        blogObservableArrayList.addAll(blogs);
    }

    public void fetchBlogs() {
        setIsLoading(true);
        getCompositeDisposable().add(getDataManager()
                .getBlogApiCall()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(blogResponse -> {
                    if (blogResponse != null && blogResponse.getData() != null) {
                        blogListLiveData.setValue(blogResponse.getData());
                    }
                    setIsLoading(false);
                }, throwable -> {
                    setIsLoading(false);
                    getNavigator().handleError(throwable);
                }));
    }

    public MutableLiveData<List<BlogResponse.Blog>> getBlogListLiveData() {
        return blogListLiveData;
    }

    public ObservableList<BlogResponse.Blog> getBlogObservableList() {
        return blogObservableArrayList;
    }
}
