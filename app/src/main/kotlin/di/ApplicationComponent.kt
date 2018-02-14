package di

import dagger.Component
import me.androidbox.enershared.home.HomeView
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidModule::class,
    HomeModule::class])
interface ApplicationComponent {
    fun inject(homeView: HomeView)
}
