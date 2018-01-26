package me.androidbox.enershared.core

import org.jetbrains.annotations.Nullable
import java.lang.ref.WeakReference

open class BasePresenterImp<V>: BasePresenter<V> {
    private var viewReference: WeakReference<V>? = null


    override fun attachView(view: V) {
        viewReference = WeakReference(view)
    }

    override fun detachView() {
        viewReference?.clear()
        viewReference = null
    }

    override fun isViewAttached(): Boolean {
        return viewReference != null && viewReference?.get() != null
    }

    @Nullable
    override fun getView(): V? {
        return viewReference?.get()
    }
}
