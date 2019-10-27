/*
 * Copyright (C) 2018, Umbrella CompanyLimited All rights reserved.
 * Project：AutoDispose
 * Author：Drake
 * Date：10/27/19 6:54 PM
 */

package com.drake.autodispose

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import io.reactivex.Observable


fun <T> Observable<T>.auto(
    lifecycleOwner: LifecycleOwner,
    event: Lifecycle.Event = Lifecycle.Event.ON_DESTROY
): Observable<T> {

    return doOnLifecycle({ dispose ->

        lifecycleOwner.lifecycle.addObserver(object : LifecycleEventObserver {

            override fun onStateChanged(source: LifecycleOwner, actualEvent: Lifecycle.Event) {
                if (event == actualEvent) {
                    dispose.dispose()
                }
            }

        })
    }, {})
}



