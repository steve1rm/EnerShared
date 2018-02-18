package di

import dagger.Module
import dagger.Provides
import dagger.Reusable
import home.HomePresenter
import home.HomePresenterImp

@Module
class HomeModule {

    @Reusable
    @Provides
    fun provideHomePresenter(): HomePresenter {
        return HomePresenterImp()
    }
}
