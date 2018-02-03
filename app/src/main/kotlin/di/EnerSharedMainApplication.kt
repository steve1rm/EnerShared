package di

import android.app.Application
import com.facebook.stetho.Stetho
import me.androidbox.enershared.BuildConfig
import timber.log.Timber

class EnerSharedMainApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        if(BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
            Timber.d("Running in debug mode")
            Stetho.initializeWithDefaults(this)
        }
    }
}
