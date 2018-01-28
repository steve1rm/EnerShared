package me.androidbox.enershared.core

import org.jetbrains.annotations.Nullable

interface BasePresenter<V> {
    fun attachView(view: V)
    fun detachView()
    fun isViewAttached(): Boolean
    @Nullable fun getView(): V?
}
