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

package com.habeeb.android_mvvm_boilerplate.data.remote;

import com.habeeb.android_mvvm_boilerplate.data.model.api.BlogResponse;
import com.habeeb.android_mvvm_boilerplate.data.model.api.LoginRequest;
import com.habeeb.android_mvvm_boilerplate.data.model.api.LoginResponse;
import com.habeeb.android_mvvm_boilerplate.data.model.api.LogoutResponse;
import com.habeeb.android_mvvm_boilerplate.data.model.api.OpenSourceResponse;

import io.reactivex.Single;

/**
 * Created by HABEEB on 24/04/19.
 */

public interface ApiHelper {

    Single<LoginResponse> doFacebookLoginApiCall(LoginRequest.FacebookLoginRequest request);

    Single<LoginResponse> doGoogleLoginApiCall(LoginRequest.GoogleLoginRequest request);

    Single<LogoutResponse> doLogoutApiCall();

    Single<LoginResponse> doServerLoginApiCall(LoginRequest.ServerLoginRequest request);

    ApiHeader getApiHeader();

    Single<BlogResponse> getBlogApiCall();

    Single<OpenSourceResponse> getOpenSourceApiCall();
}
