package me.androidbox.enershared.home

import android.support.v7.view.menu.MenuBuilder
import android.view.Menu
import me.androidbox.enershared.R
import me.androidbox.enershared.billing.BillingView
import me.androidbox.enershared.payment.PaymentView
import me.androidbox.enershared.trading.TradingView
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.notNullValue
import org.junit.Before
import org.junit.Test
import org.robolectric.Robolectric
import org.robolectric.shadows.ShadowApplication
import support.BaseRobolectricTestRunner

class HomeActivityTest: BaseRobolectricTestRunner() {
    private val context by lazy {
        ShadowApplication.getInstance().applicationContext
    }

    private val menuBuilder by lazy {
        MenuBuilder(context)
    }

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
        val menu = menuBuilder
        val item = menu.add(Menu.NONE, android.R.id.home, Menu.NONE, R.string.home)

        assertThat(homeActivity.onOptionsItemSelected(item), `is`(true))
    }

    @Test
    fun testOnOptionsItemSelectedReturnFalseWhenNotHomeMenuItem() {
        val menu = menuBuilder
        val item = menu.add(Menu.NONE, android.R.id.empty, Menu.NONE, R.string.home)

        assertThat(homeActivity.onOptionsItemSelected(item), `is`(false))
    }

    @Test
    fun testSelectDrawerItemStartsBillingFragment() {
        val menu = menuBuilder
        val item = menu.add(Menu.NONE, R.id.menuBilling, Menu.NONE, R.string.billing)

        homeActivity.selectDrawerItem(item)

        assertThat(homeActivity.supportFragmentManager.findFragmentByTag(BillingView.TAG).tag,
                `is`(BillingView.TAG))
    }

    @Test
    fun testSelectDrawerItemStartsTradingFragment() {
        val menu = menuBuilder
        val item = menu.add(Menu.NONE, R.id.menuTrading, Menu.NONE, R.string.trading)

        homeActivity.selectDrawerItem(item)

        assertThat(homeActivity.supportFragmentManager.findFragmentByTag(TradingView.TAG).tag,
                `is`(TradingView.TAG))
    }

    @Test
    fun testSelectDrawerItemStartsPaymentFragment() {
        val menu = menuBuilder
        val item = menu.add(Menu.NONE, R.id.menuPayment, Menu.NONE, R.string.payment)

        homeActivity.selectDrawerItem(item)

        assertThat(homeActivity.supportFragmentManager.findFragmentByTag(PaymentView.TAG).tag,
        `is`(PaymentView.TAG))
    }

    @Test
    fun testSelectDrawerItemStartsHomeFragmentOnDefault() {
        val menu = menuBuilder
        val item = menu.add(Menu.NONE, R.id.home, Menu.NONE, R.string.home)

        homeActivity.selectDrawerItem(item)

        assertThat(homeActivity.supportFragmentManager.findFragmentByTag(HomeView.TAG).tag,
                `is`(HomeView.TAG))
    }
}

