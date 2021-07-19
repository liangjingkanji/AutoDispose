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

package com.drake.autodispose

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import io.reactivex.Observable

/**
 * 在LifecycleOwner的指定生命周期中取消订阅
 *
 * @param lifecycleOwner 一般为Activity或Fragment. 当然也可以自己实现LifecycleOwner
 * @param event 指定生命周期, 默认为[Lifecycle.Event.ON_DESTROY]
 */
fun <T> Observable<T>.auto(
    lifecycleOwner: LifecycleOwner,
    event: Lifecycle.Event = Lifecycle.Event.ON_DESTROY
): Observable<T> {
    return doOnLifecycle({ dispose ->
        lifecycleOwner.lifecycle.addObserver(object : LifecycleEventObserver {
            override fun onStateChanged(source: LifecycleOwner, actualEvent: Lifecycle.Event) {
                if (event == actualEvent) dispose.dispose()
            }
        })
    }, {})
}



