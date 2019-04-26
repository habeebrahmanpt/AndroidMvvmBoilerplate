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

package com.habeeb.android_mvvm_boilerplate.di.builder;

import com.habeeb.android_mvvm_boilerplate.ui.about.AboutFragmentProvider;
import com.habeeb.android_mvvm_boilerplate.ui.feed.FeedActivity;
import com.habeeb.android_mvvm_boilerplate.ui.feed.FeedActivityModule;
import com.habeeb.android_mvvm_boilerplate.ui.feed.blogs.BlogFragmentProvider;
import com.habeeb.android_mvvm_boilerplate.ui.feed.opensource.OpenSourceFragmentProvider;
import com.habeeb.android_mvvm_boilerplate.ui.login.LoginActivity;
import com.habeeb.android_mvvm_boilerplate.ui.login.LoginActivityModule;
import com.habeeb.android_mvvm_boilerplate.ui.main.MainActivity;
import com.habeeb.android_mvvm_boilerplate.ui.main.MainActivityModule;
import com.habeeb.android_mvvm_boilerplate.ui.main.rating.RateUsDialogProvider;
import com.habeeb.android_mvvm_boilerplate.ui.splash.SplashActivity;
import com.habeeb.android_mvvm_boilerplate.ui.splash.SplashActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by HABEEB on 24/04/19.
 */
@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = {
            FeedActivityModule.class,
            BlogFragmentProvider.class,
            OpenSourceFragmentProvider.class})
    abstract FeedActivity bindFeedActivity();

    @ContributesAndroidInjector(modules = LoginActivityModule.class)
    abstract LoginActivity bindLoginActivity();

    @ContributesAndroidInjector(modules = {
            MainActivityModule.class,
            AboutFragmentProvider.class,
            RateUsDialogProvider.class})
    abstract MainActivity bindMainActivity();

    @ContributesAndroidInjector(modules = SplashActivityModule.class)
    abstract SplashActivity bindSplashActivity();
}
