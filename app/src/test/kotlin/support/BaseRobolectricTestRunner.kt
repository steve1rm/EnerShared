package support

import android.os.Build
import android.support.v4.app.Fragment
import di.EnerSharedMainApplication
import me.androidbox.enershared.BuildConfig
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.shadows.support.v4.SupportFragmentTestUtil

@Config(sdk = intArrayOf(Build.VERSION_CODES.LOLLIPOP),
        constants = BuildConfig::class,
        packageName = "me.androidbox.enershared",
        application = EnerSharedMainApplication::class)
@RunWith(RobolectricTestRunner::class)
abstract class BaseRobolectricTestRunner {

    protected fun initializeFragment(fragment: Fragment) {
        SupportFragmentTestUtil.startVisibleFragment(fragment)
    }
}