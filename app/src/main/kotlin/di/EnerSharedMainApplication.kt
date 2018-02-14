package di

import android.app.Application
import com.facebook.stetho.Stetho
import me.androidbox.enershared.BuildConfig
import timber.log.Timber

class EnerSharedMainApplication: Application() {
    private lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        setDebugImplementation()

        applicationComponent = DaggerApplicationComponent.builder()
                .androidModule(AndroidModule(this))
                .homeModule(HomeModule())
                .build()
    }

    fun getApplicationComponent() = applicationComponent

    private fun setDebugImplementation() {
        if(BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
            Timber.d("Running in debug mode")
            Stetho.initializeWithDefaults(this)
        }
    }
}
