package home

interface HomePresenter {
    fun initialize(homeViewContract: HomeViewContract)
    fun freeResources()
    fun getCustomerDetails()
}
