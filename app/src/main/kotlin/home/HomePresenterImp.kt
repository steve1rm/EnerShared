package home

import me.androidbox.enershared.core.BasePresenterImp

class HomePresenterImp: HomePresenter, BasePresenterImp<HomeViewContract>() {

    override fun initialize(homeViewContract: HomeViewContract) {
        attachView(homeViewContract)
    }

    override fun freeResources() {
        detachView()
    }

    override fun getCustomerDetails() {

    }
}