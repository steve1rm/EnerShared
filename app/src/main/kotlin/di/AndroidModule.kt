package di

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AndroidModule(application: EnerSharedMainApplication) {
    private val context: Context

    init {
        context = application
    }

    @Singleton
    @Provides
    fun provideContext(): Context {
        return context
    }

    @Singleton
    @Provides
    fun provideSharedPreferences(context: Context): SharedPreferences?
            = PreferenceManager.getDefaultSharedPreferences(context)
}
