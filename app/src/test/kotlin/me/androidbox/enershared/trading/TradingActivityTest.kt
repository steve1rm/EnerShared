package me.androidbox.enershared.trading

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.notNullValue
import org.junit.Before
import org.junit.Test
import org.robolectric.Robolectric
import org.robolectric.android.controller.ActivityController
import support.BaseRobolectricTestRunner

class TradingActivityTest: BaseRobolectricTestRunner() {
    private lateinit var activityController: ActivityController<TradingActivity>

    @Before
    fun setup() {
        activityController = Robolectric.buildActivity(TradingActivity::class.java)
        activityController.create().start()
    }

    @Test
    fun testTradingActivityIsNotNullValue() {
        assertThat(activityController, `is`(notNullValue()))
    }

    @Test
    fun testTradingFragmentHasStarted() {
        val actualFragment = activityController.get()
                .supportFragmentManager.findFragmentByTag(TradingView.TAG)

        assertThat(actualFragment.tag, `is`(TradingView.TAG))
    }

    @Test
    fun testBillingFragment_doNotCommit_WhenAlreadyAttached() {
        activityController.get().recreate()

        val actualFragment = activityController.get()
                .supportFragmentManager
                .findFragmentByTag(TradingView.TAG)

        assertThat(actualFragment.tag, `is`(TradingView.TAG))
    }
}