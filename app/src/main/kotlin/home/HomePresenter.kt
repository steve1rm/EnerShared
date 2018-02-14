package home

import me.androidbox.enershared.core.BasePresenter

interface HomePresenter: BasePresenter<HomeViewContract> {
    fun getCustomerDetails()
}

