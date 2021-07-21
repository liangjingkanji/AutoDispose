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

package androidx.lifecycle

import io.reactivex.Flowable
import io.reactivex.Observable
import java.io.Closeable

/**
 * 在[ViewModel]被销毁时取消订阅
 */
fun <T> Observable<T>.auto(viewModel: ViewModel): Observable<T> {
    return doOnLifecycle({ dispose ->
        val rxCloseable = Closeable { dispose.dispose() }
        viewModel.setTagIfAbsent(rxCloseable.toString(), rxCloseable)
    }, {})
}

/**
 * 在[ViewModel]被销毁时取消订阅
 */
fun <T> Flowable<T>.auto(viewModel: ViewModel): Flowable<T> {
    return doOnLifecycle({
        val rxCloseable = Closeable { it.cancel() }
        viewModel.setTagIfAbsent(rxCloseable.toString(), rxCloseable)
    }, {}, {})
}