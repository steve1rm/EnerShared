package me.androidbox.enershared.trading

import me.androidbox.enershared.billing.BillingView
import org.hamcrest.core.Is.`is`
import org.hamcrest.core.IsNull.notNullValue
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test
import org.robolectric.Robolectric
import support.BaseRobolectricTestRunner

class TradingActivityTest: BaseRobolectricTestRunner() {
    private lateinit var tradingActivity: TradingActivity

    @Before
    fun setup() {
        tradingActivity = Robolectric.setupActivity(TradingActivity::class.java)
    }

    @Test
    fun testTradingActivityIsNotNullValue() {
        assertThat(tradingActivity, `is`(notNullValue()))
    }

    @Test
    fun testTradingFragmentHasStarted() {
        val actualFragment = tradingActivity.supportFragmentManager.findFragmentByTag(TradingView.TAG)

        assertThat(actualFragment.tag, `is`(TradingView::class.java.name))

    }
}