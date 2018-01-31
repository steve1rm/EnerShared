package me.androidbox.enershared.home

import android.support.v7.view.menu.MenuBuilder
import android.view.Menu
import me.androidbox.enershared.R
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.notNullValue
import org.junit.Before
import org.junit.Test
import org.robolectric.Robolectric
import org.robolectric.shadows.ShadowApplication
import support.BaseRobolectricTestRunner

class HomeActivityTest: BaseRobolectricTestRunner() {

    private lateinit var homeActivity: HomeActivity

    @Before
    fun setup() {
        homeActivity = Robolectric.buildActivity(HomeActivity::class.java)
                .create()
                .start()
                .get()
    }

    @Test
    fun testHomeActivityIsNotNullValue() {
        assertThat(homeActivity, `is`(notNullValue()))
    }

    @Test
    fun testHomeFragmentHasStarted() {
        val actualFragment = homeActivity.supportFragmentManager.findFragmentByTag(HomeView.TAG)

        assertThat(actualFragment.tag, `is`(HomeView.TAG))
    }

    @Test
    fun testOnOptionsItemSelectedReturnTrueHomeMenuItem() {
        val context = ShadowApplication.getInstance().applicationContext
        val menu = MenuBuilder(context)
        val item = menu.add(Menu.NONE, android.R.id.home, Menu.NONE, R.string.home)

        assertThat(homeActivity.onOptionsItemSelected(item), `is`(true))
    }

    @Test
    fun testOnOptionsItemSelectedReturnFalseWhenNotHomeMenuItem() {
        val context = ShadowApplication.getInstance().applicationContext
        val menu = MenuBuilder(context)
        val item = menu.add(Menu.NONE, android.R.id.empty, Menu.NONE, R.string.home)

        assertThat(homeActivity.onOptionsItemSelected(item), `is`(false))
    }
}
