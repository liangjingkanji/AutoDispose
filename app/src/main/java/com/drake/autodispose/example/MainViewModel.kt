/*
 * Copyright (C) 2018 Drake, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.drake.autodispose.example

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.auto
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

class MainViewModel : ViewModel() {

    fun startInterval() {
        Observable.interval(1, TimeUnit.SECONDS).auto(this).subscribe {
            Log.d("日志", "MainViewModel = $it")
        }
    }
}