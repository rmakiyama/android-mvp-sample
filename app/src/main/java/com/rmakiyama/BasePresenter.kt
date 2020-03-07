package com.rmakiyama

import androidx.annotation.CallSuper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel
import kotlin.coroutines.CoroutineContext

interface BasePresenter<T> : CoroutineScope {

    override val coroutineContext: CoroutineContext

    fun takeView(view: T)

    @CallSuper
    fun dropView() {
        coroutineContext.cancel()
    }
}
